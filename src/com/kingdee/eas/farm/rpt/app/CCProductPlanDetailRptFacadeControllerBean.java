package com.kingdee.eas.farm.rpt.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.TableManagerFacadeFactory;
import com.kingdee.eas.farm.breed.BreedBatchFactory;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.BreedModelEntryCollection;
import com.kingdee.eas.farm.breed.BreedModelEntryFactory;
import com.kingdee.eas.farm.breed.BreedModelEntryInfo;
import com.kingdee.eas.farm.breed.BreedModelFactory;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.business.CCBreedPlanFactory;
import com.kingdee.eas.farm.breed.business.CCBreedPlanInfo;
import com.kingdee.eas.farm.breed.comm.BREED_CONSTANTS;
import com.kingdee.eas.farm.rpt.CCProductPlanRptCommonFacadeFactory;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.jdbc.rowset.IRowSet;

public class CCProductPlanDetailRptFacadeControllerBean extends AbstractCCProductPlanDetailRptFacadeControllerBean
{
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -9101189627955161908L;

	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.rpt.app.CCProductPlanDetailRptFacadeControllerBean");
    
    // ���������� �����
//  private List<CCProductPlanRptBean> beans;
    // ��ֳ�淶
    private BreedModelInfo currentBreedModel;
    // ��ֳ�淶��ϸ
    private Map<Integer,BreedModelEntryInfo> currentBreedModelDetails;
    // ��ǰ��ֳ�淶������������Ϣ
    private Map<Integer,MaterialInfo> currentBreedMaterials;
    
    // ���˿�ʼ����
    private Date filterBeginDate;
    // ���˽�������
    private Date filterEndDate;
    // ��ֳ����
    private int breedDays;
	@Override
	protected IRowSet _getRptData(Context ctx, HashMap param)
			throws BOSException {
		// TODO Auto-generated method stub
//		return super._getRptData(ctx, param);
		// ��ȡ�������ڣ����û�д��� ��Ĭ�ϵ�ǰϵͳʱ��
		filterBeginDate = (Date)param.get("filterBeginDate");
		if(filterBeginDate == null){
			filterBeginDate = new Date();
		}
		
		// ��ȡ���˽������ڣ����û�д��� ��Ĭ�ϵ�ǰϵͳʱ��
		filterEndDate = (Date)param.get("filterEndDate");
		if(filterEndDate == null){
			filterEndDate = new Date();
		}
		// ��ȡ��ֳ����
		String breedDaysStr = (String)param.get("breedDays");
		if(StringUtils.isNotBlank(breedDaysStr)){
			breedDays = Integer.parseInt(breedDaysStr);
		}
		
		String showBatch = (String) param.get("showBatch");
		List<CCProductPlanRptBean> resultBeans = new ArrayList<CCProductPlanRptBean>();
		try{
			// ��ȡ ��ֳ�淶
			getCurrentCCBreedModelInfo(ctx);
			
			List<CCProductPlanRptBean> storageBeans = getRptBeanStorageInfos(ctx, param);
			// �����ֳ��  �����ö�Ӧ�����κͼƻ���Ϣ
			for(CCProductPlanRptBean ccRptBean : storageBeans){
				
				
				List<CCProductPlanRptBean> batchRptBeans = this.getStoorgBatchInfo(ctx, ccRptBean, param);
				
				// ����ID
				List<String> planIDs = new ArrayList<String>();
				if(batchRptBeans != null && batchRptBeans.size() > 0){
					for(int i = 0; i < batchRptBeans.size();i++){
						CCProductPlanRptBean batchRptBean = batchRptBeans.get(i);
						// ����й����ƻ���  ���üƻ�id���б���
						if(batchRptBean.getPlanID() != null && StringUtils.isNotBlank(batchRptBean.getPlanID())){
							planIDs.add(batchRptBean.getPlanID());
						}
						// ����Ǽƻ��Ļ����üƻ��߼�
						List<CCProductPlanRptBean> storageBatchResultBeans =  this.setBatchDetailInfos(ctx,batchRptBean,batchRptBean.getBatchID(),param);
						if(storageBatchResultBeans != null && storageBatchResultBeans.size() > 0){
							// ���ӵ� �����
							resultBeans.addAll(storageBatchResultBeans);
						}
					}
				}
				// �ƻ�
				List<CCProductPlanRptBean> planRptBeans = this.getStoorgPlanInfo(ctx, ccRptBean,planIDs, param);
				if(planRptBeans!= null && planRptBeans.size() > 0){
					for(int i = 0; i < planRptBeans.size(); i++){
						CCProductPlanRptBean planRptBean =  planRptBeans.get(i);
						// ʵ�����ΰ������μ���
						List<CCProductPlanRptBean> storagePlanResultBeans =  this.setPlanDetailInfos(ctx,planRptBean,planRptBean.getBatchID(),param);
						if(storagePlanResultBeans != null && storagePlanResultBeans.size() > 0){
							// ���ӵ� �����
							resultBeans.addAll(storagePlanResultBeans);
						}
					}
				}
			}
			
			// ���ӵ����ݿ���
			// ������ʱ��
			String temptable = TableManagerFacadeFactory.getLocalInstance(ctx).getTableName("CCProductPlanDetailRpt");
			TableManagerFacadeFactory.getLocalInstance(ctx).createTempTable(getTempTableCreateSql(temptable));
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < resultBeans.size(); i++){
				CCProductPlanRptBean bean = resultBeans.get(i);
				// �����������
				sb.append(this.getInsertSql(temptable, bean));
				sb.append(";");
				// ÿ10��ִ��һ��
				if(i != 0 && i / 10 == 0) {
					DbUtil.execute(ctx, sb.substring(0,sb.length() -1).toString());
					sb = new StringBuilder();
				}
				
				// ���һ���ж�һ���Ƿ���Ҫִ��
				if(i == (resultBeans.size() -1)){
					if(sb.length() > 10){
						DbUtil.execute(ctx, sb.substring(0,sb.length() -1).toString());
						sb = new StringBuilder();
					}
				}
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			String sumType = (String) param.get("sumType");	
			// 1 ������ �ϺŻ���
			if("1".equals(sumType)){
				StringBuilder sumsql = new StringBuilder();
				sumsql.append("select currentDate, sum(OneMaterialPredictQty)/1000 OneMaterialPredictQty,");
				sumsql.append(" sum(OneMaterialActualQty)/1000 OneMaterialActualQty,");
				sumsql.append(" sum(TwoMaterialPredictQty)/1000 TwoMaterialPredictQty,");
				sumsql.append(" sum(TwoMaterialActualQty)/1000 TwoMaterialActualQty,");
				sumsql.append(" sum(ThreeMaterialPredictQty)/1000 ThreeMaterialPredictQty,");
				sumsql.append(" sum(ThreeMaterialActualQty)/1000 ThreeMaterialActualQty ");
				sumsql.append(" from ");
				sumsql.append(temptable);
				sumsql.append(" where 1=1 ");
				if(filterBeginDate != null){
					sumsql.append(" and currentDate >= {ts'");
					sumsql.append(sdf.format(filterBeginDate));
					sumsql.append("'} ");
				}
				
				if(filterEndDate != null){
					sumsql.append(" and currentDate <= {ts'");
					sumsql.append(sdf.format(filterEndDate));
					sumsql.append("'} ");
				}
				
				
				sumsql.append(" group by currentDate order by currentDate  ");
				
				IRowSet rs = DbUtil.executeQuery(ctx, sumsql.toString());
				
				return rs;
			}else if("2".equals(sumType)){
				StringBuilder sumsql = new StringBuilder();
				sumsql.append("/*dialect*/select stoOrgName,");
				if("true".endsWith(showBatch)){
					sumsql.append("batchName,");
				}else{
					sumsql.append("'����/�ƻ��ϼ�' batchName,");
				}
				sumsql.append(" to_char(currentDate,'yyyy-mm-dd') currentDate, sum(OneMaterialPredictQty)/1000 OneMaterialPredictQty,");
				sumsql.append(" sum(OneMaterialActualQty)/1000 OneMaterialActualQty,");
				sumsql.append(" sum(TwoMaterialPredictQty)/1000 TwoMaterialPredictQty,");
				sumsql.append(" sum(TwoMaterialActualQty)/1000 TwoMaterialActualQty,");
				sumsql.append(" sum(ThreeMaterialPredictQty)/1000 ThreeMaterialPredictQty,");
				sumsql.append(" sum(ThreeMaterialActualQty)/1000 ThreeMaterialActualQty ");
				sumsql.append(" from ");
				sumsql.append(temptable);
				sumsql.append(" where 1=1 ");
				if(filterBeginDate != null){
					sumsql.append(" and currentDate >= {ts'");
					sumsql.append(sdf.format(filterBeginDate));
					sumsql.append("'} ");
				}
				
				if(filterEndDate != null){
					sumsql.append(" and currentDate <= {ts'");
					sumsql.append(sdf.format(filterEndDate));
					sumsql.append("'} ");
				}
				
				if("true".endsWith(showBatch)){
					sumsql.append(" group by stoOrgName,batchName,currentDate order by stoOrgName,batchName,currentDate  ");
				}else{
					sumsql.append(" group by stoOrgName,currentDate order by stoOrgName,currentDate  ");
				}
				IRowSet rs = DbUtil.executeQuery(ctx, sumsql.toString());
				
				return rs;
			}else if("3".equals(sumType)){
				IRowSet rs = DbUtil.executeQuery(ctx, "select * from "+ temptable +" order by stoOrgNumber,batchNumber,inhouseDate ");
				return rs;
			}
			// �������������ʱ�����ؽ��
//			if(sb.length() > 10){
				IRowSet rs = DbUtil.executeQuery(ctx, "select * from "+ temptable +" order by stoOrgNumber,batchNumber,inhouseDate ");
				return rs;
//			}
				
				
			
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		} catch (EASBizException e) {
			e.printStackTrace();
			throw new BOSException(e);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new BOSException(e);
		}
//		return null;
	}
	


	/**
	 * ����������ϸ��Ϣ
	 * 
	 * @param ctx
	 * @param ccRptBean
	 * @param param
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	private List<CCProductPlanRptBean> setBatchDetailInfos(Context ctx,CCProductPlanRptBean stoBatchBean,String batchID,HashMap param) throws EASBizException, BOSException, SQLException, ParseException{
		List<CCProductPlanRptBean> batchDetailInfos = new ArrayList<CCProductPlanRptBean>();
		// ��ȡ������ϸ��Ϣ 
		if(StringUtils.isNotBlank(batchID)){
			// ��ȡ ������ϸ��Ϣ
			BreedBatchInfo batchInfo = BreedBatchFactory.getLocalInstance(ctx).getBreedBatchInfo(new ObjectUuidPK(batchID));
			if(batchInfo != null){
				// �ж����� ��������  �͵�ǰʱ��Ƚ�  �����Ƿ��� ��ǰʱ����
				StringBuilder sb = new StringBuilder();
				sb.append("select t.fid billID,te.fid entryID,te.cfhenhouseid,te.cfhenhouseName, ");
				sb.append(" te.cfinitqty,te.cfincoopdate,t.fbizdate billBizdate ");
				sb.append(" from CT_FM_BreedBatch t inner join CT_FM_BreedBatchEntry te on t.fid = te.fparentid ");
				sb.append(" where t.fid ='");
				sb.append(batchInfo.getId().toString());
				sb.append("'  order by te.cfincoopdate ");
				
				IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
				
//				Date currEntryInDate = new Date();
				Date currEntryOutDate = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String currEntryDateStr = "";
				List<String> entryHenhouseIDs = new ArrayList<String>();
				int currIncoopQty =0;
				int  currEntryDays;
				// ������
				int i = 0;
				while(rs.next()){
					
					String billID = rs.getString("billID");
					String entryID = rs.getString("entryID");
					String cfhenhouseid = rs.getString("cfhenhouseid");
					String cfhenhouseName = rs.getString("cfhenhouseName");
					int cfinitqty = rs.getInt("cfinitqty");
					// ��������
					Date cfincoopdate = rs.getDate("cfincoopdate");
					
					if(cfincoopdate == null ){
						cfincoopdate = rs.getDate("billBizdate");
					}
//					String incoopdateStr = sdf.format(cfincoopdate);
					
					// ��� ʵ�ʳ����������۳�������
					
					// �������ڱ仯�� δ�仯  �ֱ���
					if(cfincoopdate!= null && currEntryDateStr.equals(sdf.format(cfincoopdate))){
						currIncoopQty = currIncoopQty + cfinitqty;
						// ��¼ ����id
						entryHenhouseIDs.add(cfhenhouseid);
					}else{
						
						// ����仯���������� ֮ǰ���ݣ������ʱ��¼�ֶ�
						if(StringUtils.isNotBlank(currEntryDateStr)){
							
							
							
							
							// ��ȡ����������ϸ��Ϣ
							List<CCProductPlanRptBean> batchEntryDetailBean = getBatchFodders(ctx, stoBatchBean, batchID, sdf.parse(currEntryDateStr), currEntryOutDate,currIncoopQty, entryHenhouseIDs);
							batchDetailInfos.addAll(batchEntryDetailBean);
						}
						
						// ��ǰ��������ָ�� ��ǰ����
//						currEntryInDate = cfincoopdate;
						
						currEntryDateStr = sdf.format(cfincoopdate);
						entryHenhouseIDs = new ArrayList<String>();
						entryHenhouseIDs.add(cfhenhouseid);
						// ��ǰ�����������ڵ�ǰ��
						currIncoopQty = cfinitqty;
						// ��� ��������
						currEntryOutDate = getBatchEntryOutcoopDate(ctx, billID, cfhenhouseid, cfincoopdate);
						Calendar cal = Calendar.getInstance();
						
						// ���ȡ�õĳ�������Ϊnull����������۳���ʱ��     �������ڼ���  38��
						if(currEntryOutDate == null){
							cal.setTime(cfincoopdate);
							cal.add(Calendar.DATE, this.getBreedDays());
							
							currEntryOutDate = cal.getTime();
							
						}
					}
					
					// ���һ�� ���ӺϼƵ� �б���
					if(i == rs.size() -1){
						// ��ȡ����������ϸ��Ϣ
						List<CCProductPlanRptBean> batchEntryDetailBean  = getBatchFodders(ctx, stoBatchBean, batchID, sdf.parse(currEntryDateStr), currEntryOutDate,currIncoopQty, entryHenhouseIDs);
						batchDetailInfos.addAll(batchEntryDetailBean);
					}
					// �������ۼ�
					i++;
				}
				
				
				
//				sb.append("")
			}
		}
		
		return batchDetailInfos;
	}

	
	/**
	 * ���� �ƻ������������  �ƻ�������Ϣ
	 * 
	 * @param ctx
	 * @param ccRptBean
	 * @param param
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	private List<CCProductPlanRptBean> setPlanDetailInfos(Context ctx,CCProductPlanRptBean stoBatchBean,String planID,HashMap param) throws EASBizException, BOSException, SQLException, ParseException{
		List<CCProductPlanRptBean> batchDetailInfos = new ArrayList<CCProductPlanRptBean>();
		// ��ȡ�ƻ���ϸ��Ϣ 
		if(StringUtils.isNotBlank(planID)){
			// ��ȡ �ƻ���ϸ��Ϣ
			CCBreedPlanInfo planInfo = CCBreedPlanFactory.getLocalInstance(ctx).getCCBreedPlanInfo(new ObjectUuidPK(planID));
			if(planInfo != null){
				// �ж� �ƻ���������  �͵�ǰʱ��Ƚ�  �ƻ��Ƿ��� ��ǰʱ����
				StringBuilder sb = new StringBuilder();
				sb.append("select t.fid billID,te.fid entryID,te.cfhenhouseid,te.cfhenhouseName, ");
				sb.append(" te.cfinitqty,te.cfincoopdate,t.fbizdate billBizdate ");
				sb.append(" from CT_FM_CCBreedPlan t inner join CT_FM_CCBreedPlanEntry te on t.fid = te.fparentid ");
				sb.append(" where t.fid ='");
				sb.append(planInfo.getId().toString());
				sb.append("'  order by te.cfincoopdate ");
				
				IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
				
//				Date currEntryInDate = new Date();
				Date currEntryOutDate = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String currEntryDateStr = "";
				List<String> entryHenhouseIDs = new ArrayList<String>();
				int currIncoopQty =0;
				int  currEntryDays;
				// ������
				int i = 0;
				while(rs.next()){
					
					String billID = rs.getString("billID");
					String entryID = rs.getString("entryID");
					String cfhenhouseid = rs.getString("cfhenhouseid");
					String cfhenhouseName = rs.getString("cfhenhouseName");
					int cfinitqty = rs.getInt("cfinitqty");
					// ��������
					Date cfincoopdate = rs.getDate("cfincoopdate");
					
					if(cfincoopdate == null ){
						cfincoopdate = rs.getDate("billBizdate");
					}
//					String incoopdateStr = sdf.format(cfincoopdate);
					
					// ��� ʵ�ʳ����������۳�������
					
					// �������ڱ仯�� δ�仯  �ֱ���
					if(cfincoopdate!= null && currEntryDateStr.equals(sdf.format(cfincoopdate))){
						currIncoopQty = currIncoopQty + cfinitqty;
						// ��¼ ����id
						entryHenhouseIDs.add(cfhenhouseid);
					}else{
						
						// ����仯���������� ֮ǰ���ݣ������ʱ��¼�ֶ�
						if(StringUtils.isNotBlank(currEntryDateStr)){
							
							// ��������۳�������
							Calendar cal = Calendar.getInstance();
							
							// ���ȡ�õĳ�������Ϊnull����������۳���ʱ��     �������ڼ���  38��
							cal.setTime(cfincoopdate);
							cal.add(Calendar.DATE, this.getBreedDays());
							currEntryOutDate = cal.getTime();
							// ��ȡ����������ϸ��Ϣ
							List<CCProductPlanRptBean> batchEntryDetailBeans = getPlanDetailFodders(ctx,
									stoBatchBean,
									planID, 
									sdf.parse(currEntryDateStr), 
									currEntryOutDate,
									filterBeginDate,
									currIncoopQty,
									entryHenhouseIDs);
//							batchEntryDetailBean.setPlan(true);
							batchDetailInfos.addAll(batchEntryDetailBeans);
						}
						
						// ��ǰ��������ָ�� ��ǰ����
//						currEntryInDate = cfincoopdate;
						
						currEntryDateStr = sdf.format(cfincoopdate);
						entryHenhouseIDs = new ArrayList<String>();
						entryHenhouseIDs.add(cfhenhouseid);
						// ��ǰ�����������ڵ�ǰ��
						currIncoopQty = cfinitqty;
						// ��� ��������
//						currEntryOutDate = getBatchEntryOutcoopDate(ctx, billID, cfhenhouseid, cfincoopdate);
						
					}
					
					// ���һ�� ���ӺϼƵ� �б���
					if(i == rs.size() -1){
						// ��������۳�������
						Calendar cal = Calendar.getInstance();
						
						// ���ȡ�õĳ�������Ϊnull����������۳���ʱ��     �������ڼ���  38��
						cal.setTime(cfincoopdate);
						cal.add(Calendar.DATE, this.getBreedDays());
						
						currEntryOutDate = cal.getTime();
						// ��ȡ����������ϸ��Ϣ
						List<CCProductPlanRptBean> batchEntryDetailBeans = getPlanDetailFodders(ctx,
								stoBatchBean, 
								planID,
								sdf.parse(currEntryDateStr),
								currEntryOutDate,
								filterBeginDate,
								currIncoopQty,
								entryHenhouseIDs);
//						batchEntryDetailBean.setPlan(true);
						batchDetailInfos.addAll(batchEntryDetailBeans);
					}
					// �������ۼ�
					i++;
				}
				
				
				
//				sb.append("")
			}
		}
		
		return batchDetailInfos;
	}
	
	/**
	 * �����ι��׼������������ ��� �ֱ� ����� ����ι��׼ ������� ���� 
	 * @param ctx
	 * @param stoBatchInfo
	 * @param batchID
	 * @param incoopDate
	 * @param outcoopDate
	 * @param incoopQty
	 * @param henhouseIDs
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws SQLException 
	 */
	private CCProductPlanRptBean getPlanFodders(Context ctx,CCProductPlanRptBean stoBatchInfo, String planID,Date incoopDate,Date outcoopDate,int incoopQty,List<String> henhouseIDs) throws EASBizException, BOSException, SQLException{
		long timeLong = outcoopDate.getTime()-incoopDate.getTime();
		long days = timeLong / (1000 * 60 * 60 * 24);
		int outDays = (new Long(days)).intValue();
		
		CCProductPlanRptBean newRptBean = new CCProductPlanRptBean();
		newRptBean.setStoOrgID(stoBatchInfo.getStoOrgID());
		newRptBean.setStoOrgName(stoBatchInfo.getStoOrgName());
		newRptBean.setStoOrgNumber(stoBatchInfo.getStoOrgNumber());
		
		newRptBean.setBatchID(planID);
		newRptBean.setBatchEntryIDs(stoBatchInfo.getBatchEntryIDs());
		newRptBean.setBatchName(stoBatchInfo.getBatchName());
		newRptBean.setBatchNumber(stoBatchInfo.getBatchNumber());
		
		newRptBean.setCostObjectID(stoBatchInfo.getCostObjectID());
		
		newRptBean.setInhouseDate(incoopDate);
		newRptBean.setInhouseQty(incoopQty);
		newRptBean.setCurrDateNum(outDays);
		newRptBean.setDesc("");
		
//		newRptBean.set
		// �����Ϻ� ��С���� ���ѭ��  ������������ͬ�� ��ֻ������ ����
		// ����
		int qty = incoopQty;
		
		for(int m = 1; m <= currentBreedMaterials.size(); m++){
			MaterialInfo currMaterial = currentBreedMaterials.get(Integer.valueOf(m));
			if(StringUtils.isBlank(currMaterial.getName())){
				currMaterial = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(currMaterial.getId()));
				
			}
			// �Ϻ� �ܺ���
			BigDecimal currTheoryQty = new BigDecimal("0.00");
			// ������ι����
			int prediDays = 0;
			for(int i = 1; i <= days; i++){
				// ����ƥ��  ƥ�䵽�� ���ݵ����¼��ϸ���� ���������� ͬʱ���� ������
				BreedModelEntryInfo modelEntryInfo =  currentBreedModelDetails.get(Integer.valueOf(i));
				if(modelEntryInfo != null && modelEntryInfo.getMaterial() != null){
					MaterialInfo  modelEntryMaterial = modelEntryInfo.getMaterial();
					// ����ƥ�� 
					if(currMaterial.getId().toString().equals(modelEntryMaterial.getId().toString())){
						// ���� ��������
						BigDecimal dcRate = modelEntryInfo.getDailyDCRate();
						// ����ι��
						BigDecimal perQtyEveryone = modelEntryInfo.getQtyPerday();
						
						// ���ܺ���
						BigDecimal perQtyAllday = perQtyEveryone.multiply(new BigDecimal(qty)).divide(new BigDecimal(1000),2,RoundingMode.HALF_UP);
						// �ۼƺ���
//						currTheoryQty = currTheoryQty.add(perQtyAllday);
						// �ۼ������ۺ�����
						currTheoryQty = currTheoryQty.add(perQtyAllday);
						// ����������
						BigDecimal dayDCQty = ((new BigDecimal(qty)).multiply(dcRate)).divide(new BigDecimal(100),0,RoundingMode.HALF_UP);
						
						int dayDCQtyInt = dayDCQty.intValue();
						
						// ʣ������
						qty = qty - dayDCQtyInt;
						
						prediDays ++;
					}
				}
			}
			
			newRptBean.setPredictOuthouseDate(outcoopDate);
			newRptBean.setPredictOuthouseQty(qty);
			
			// ��� �����������
			String henhouseIDStr = getHenhouseStr(henhouseIDs);
			// ���ϵ�ʵ����ι�� ����ι����
			BigDecimal actualQty = new BigDecimal("0.00");
			int actualDays  = 0;
			// ��ȡʵ����ι��
			String materialName = BREED_CONSTANTS.CC_RJ01;
			if(m ==1) materialName = BREED_CONSTANTS.CC_RJ01;
			if(m ==2) materialName = BREED_CONSTANTS.CC_RJ02;
			if(m ==3) materialName = BREED_CONSTANTS.CC_RJ03;
			
			// ��ǰ����������ι�� ���õ�  �������TODO �˴��������list��map�����~~~
			if(m == 1){
				newRptBean.setOneMaterialID(currMaterial.getId().toString());
				newRptBean.setOneMaterialName(currMaterial.getName());
				newRptBean.setOneMaterialNumber(currMaterial.getNumber());
				newRptBean.setOneMaterialPredictDays(prediDays);
				newRptBean.setOneMaterialPredictQty(currTheoryQty);
			}else if(m == 2){
				newRptBean.setTwoMaterialID(currMaterial.getId().toString());
				newRptBean.setTwoMaterialName(currMaterial.getName());
				newRptBean.setTwoMaterialNumber(currMaterial.getNumber());
				newRptBean.setTwoMaterialPredictDays(prediDays);
				newRptBean.setTwoMaterialPredictQty(currTheoryQty);
			}else if(m == 3){
				newRptBean.setThreeMaterialID(currMaterial.getId().toString());
				newRptBean.setThreeMaterialName(currMaterial.getName());
				newRptBean.setThreeMaterialNumber(currMaterial.getNumber());
				newRptBean.setThreeMaterialPredictDays(prediDays);
				newRptBean.setThreeMaterialPredictQty(currTheoryQty);
			}
			
		}
		
		
//		// ����ڼ�����
//		for(int i = 1; i <= days; i++){
//			
//		}
		
		return newRptBean;
	}
	
	/**
	 * �����ι��׼������������ ��� �ֱ� ����� ����ι��׼ ������� ���� 
	 * @param ctx
	 * @param stoBatchInfo
	 * @param batchID
	 * @param incoopDate
	 * @param outcoopDate
	 * @param incoopQty
	 * @param henhouseIDs
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws SQLException 
	 */
	private List<CCProductPlanRptBean> getPlanDetailFodders(Context ctx,
			CCProductPlanRptBean stoBatchInfo,
			String planID,
			Date incoopDate,
			Date outcoopDate,
			Date filterDate,
			int incoopQty,
			List<String> henhouseIDs) throws EASBizException, BOSException, SQLException{
		long timeLong = outcoopDate.getTime()-incoopDate.getTime();
		long days = timeLong / (1000 * 60 * 60 * 24);
		int outDays = (new Long(days)).intValue();
		
		List<CCProductPlanRptBean> result = new ArrayList<CCProductPlanRptBean>();
		
		
//		newRptBean.set
		// �����Ϻ� ��С���� ���ѭ��  ������������ͬʱ ��ֻ������ ����
		// ����
		int qty = incoopQty;
		
//		for(int m = 1; m <= currentBreedMaterials.size(); m++){
//			MaterialInfo currMaterial = currentBreedMaterials.get(Integer.valueOf(m));
//			if(StringUtils.isBlank(currMaterial.getName())){
//				currMaterial = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(currMaterial.getId()));
//				
//			}
		// �Ϻ� �ܺ���
//		BigDecimal currTheoryQty = new BigDecimal("0.00");
		// ������ι����
		int prediDays = 0;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(incoopDate);
		for(int i = 1; i <= days; i++){
			// ��ȡ ��Ӧ������������
			cal.add(Calendar.DATE, 1);
			Date currDate = cal.getTime();
			
			CCProductPlanRptBean newRptBean = new CCProductPlanRptBean();
			// ��������
			newRptBean.setCurrentDate(currDate);
			
			newRptBean.setStoOrgID(stoBatchInfo.getStoOrgID());
			newRptBean.setStoOrgName(stoBatchInfo.getStoOrgName());
			newRptBean.setStoOrgNumber(stoBatchInfo.getStoOrgNumber());
			
			newRptBean.setPlan(true);
			newRptBean.setBatchID(planID);
			newRptBean.setBatchEntryIDs(stoBatchInfo.getBatchEntryIDs());
			newRptBean.setBatchName(stoBatchInfo.getBatchName());
			newRptBean.setBatchNumber(stoBatchInfo.getBatchNumber());
			
			newRptBean.setCostObjectID(stoBatchInfo.getCostObjectID());
			
			newRptBean.setInhouseDate(incoopDate);
			newRptBean.setInhouseQty(incoopQty);
			newRptBean.setCurrDateNum(outDays);
			newRptBean.setDesc("");
			
			
			// ����ƥ��  ƥ�䵽�� ���ݵ����¼��ϸ���� ���������� ͬʱ���� ������
			BreedModelEntryInfo modelEntryInfo =  currentBreedModelDetails.get(Integer.valueOf(i));
			if(modelEntryInfo != null && modelEntryInfo.getMaterial() != null){
				MaterialInfo  modelEntryMaterial = modelEntryInfo.getMaterial();
				if(StringUtils.isBlank(modelEntryMaterial.getName())){
					modelEntryMaterial = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(modelEntryMaterial.getId()));
				}
				// ����ƥ�� 
//					if(currMaterial.getId().toString().equals(modelEntryMaterial.getId().toString())){
				// ���� ��������
				BigDecimal dcRate = modelEntryInfo.getDailyDCRate();
				// ����ι��
				BigDecimal perQtyEveryone = modelEntryInfo.getQtyPerday();
				
				// ���ܺ���
				BigDecimal perQtyAllday = perQtyEveryone.multiply(new BigDecimal(qty)).divide(new BigDecimal(1000),2,RoundingMode.HALF_UP);
				// �ۼƺ���
//						currTheoryQty = currTheoryQty.add(perQtyAllday);
				// �ۼ������ۺ�����
//				currTheoryQty = currTheoryQty.add(perQtyAllday);
				// ����������
				BigDecimal dayDCQty = ((new BigDecimal(qty)).multiply(dcRate)).divide(new BigDecimal(100),0,RoundingMode.HALF_UP);
				
				int dayDCQtyInt = dayDCQty.intValue();
				
				// ʣ������
				qty = qty - dayDCQtyInt;
				
				prediDays ++;
//					}
//				}
				
				newRptBean.setPredictOuthouseDate(outcoopDate);
				newRptBean.setPredictOuthouseQty(qty);
				
				// ��� �����������
//				String henhouseIDStr = getHenhouseStr(henhouseIDs);
				// ���ϵ�ʵ����ι�� ����ι����
//				BigDecimal actualQty = new BigDecimal("0.00");
//				int actualDays  = 0;
				// ��ȡʵ����ι��
//				String materialName = BREED_CONSTANTS.CC_RJ01;
//					if(m ==1) materialName = BREED_CONSTANTS.CC_RJ01;
//					if(m ==2) materialName = BREED_CONSTANTS.CC_RJ02;
//					if(m ==3) materialName = BREED_CONSTANTS.CC_RJ03;
				
				// ��ǰ����������ι�� ���õ�  ������� TODO �˴��������list��map�����~~~
				if(modelEntryMaterial.getName().indexOf(BREED_CONSTANTS.CC_RJ01) >= 0){
					newRptBean.setOneMaterialID(modelEntryMaterial.getId().toString());
					newRptBean.setOneMaterialName(modelEntryMaterial.getName());
					newRptBean.setOneMaterialNumber(modelEntryMaterial.getNumber());
					newRptBean.setOneMaterialPredictDays(prediDays);
					newRptBean.setOneMaterialPredictQty(perQtyAllday);
				}else if(modelEntryMaterial.getName().indexOf(BREED_CONSTANTS.CC_RJ02) >= 0){
					newRptBean.setTwoMaterialID(modelEntryMaterial.getId().toString());
					newRptBean.setTwoMaterialName(modelEntryMaterial.getName());
					newRptBean.setTwoMaterialNumber(modelEntryMaterial.getNumber());
					newRptBean.setTwoMaterialPredictDays(prediDays);
					newRptBean.setTwoMaterialPredictQty(perQtyAllday);
				}else if(modelEntryMaterial.getName().indexOf(BREED_CONSTANTS.CC_RJ03) >= 0){
					newRptBean.setThreeMaterialID(modelEntryMaterial.getId().toString());
					newRptBean.setThreeMaterialName(modelEntryMaterial.getName());
					newRptBean.setThreeMaterialNumber(modelEntryMaterial.getNumber());
					newRptBean.setThreeMaterialPredictDays(prediDays);
					newRptBean.setThreeMaterialPredictQty(perQtyAllday);
				}
				// ���ӵ��������
				result.add(newRptBean);
			}
		}
		return result;
	}
	/**
	 * �����ι��׼������������ ��� �ֱ� �ۼ� ����ι��׼ ��ι���� ����
	 * @param ctx
	 * @param stoBatchInfo
	 * @param batchID
	 * @param incoopDate
	 * @param outcoopDate
	 * @param incoopQty
	 * @param henhouseIDs
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws SQLException 
	 */
	private List<CCProductPlanRptBean> getBatchFodders(Context ctx,CCProductPlanRptBean stoBatchInfo, String batchID,Date incoopDate,Date outcoopDate,int incoopQty,List<String> henhouseIDs) throws EASBizException, BOSException, SQLException{
		long timeLong = outcoopDate.getTime()-incoopDate.getTime();
		long days = timeLong / (1000 * 60 * 60 * 24);
		int outDays = (new Long(days)).intValue();
		
		
		List<CCProductPlanRptBean> resutlRptBeans = new ArrayList<CCProductPlanRptBean>();
		
		// ��� �����������
		String henhouseIDStr = getHenhouseStr(henhouseIDs);
//		newRptBean.set
		// �����Ϻ� ��С���� ���ѭ��  ������������ͬʱ ��ֻ������ ����
		// ����
		int qty = incoopQty;
		
		// ��ȡ��Ӧ���� �ڹ�������ǰ����ֳ״̬���������䣬��������ǰ����ι�� ȡ������������ι���ں��ȡ ʵ�ʼ������������
		
		for(int m = 1; m <= currentBreedMaterials.size(); m++){
			MaterialInfo currMaterial = currentBreedMaterials.get(Integer.valueOf(m));
			if(StringUtils.isBlank(currMaterial.getName())){
				currMaterial = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(currMaterial.getId()));
				
			}
			// �Ϻ� �ܺ���
			BigDecimal currTheoryQty = new BigDecimal("0.00");
			// ������ι����
			int prediDays = 0;
			// ��¼��ǰ�������ڵ� ʱ���
			Calendar currCal = Calendar.getInstance();
			
			for(int i = 1; i <= days; i++){
				
				currCal.setTime(incoopDate);
				currCal.add(Calendar.DATE, i);
				// ��ȡ��ǰѭ����������
				Date currDate = currCal.getTime();
				// ��ȡ�����ʵ�ʴ���������ͷһ���ձ��� ��������ã����δȡ������ͷһ������� ������ ���������Ա��������ô�����
				qty = CCProductPlanRptCommonFacadeFactory.getLocalInstance(ctx).getCCPredateHenqty(stoBatchInfo.getStoOrgID(),batchID,currDate,henhouseIDStr,"",qty);
//				qty = getPredateHenqty(ctx,stoBatchInfo.getStoOrgID(),batchID,currDate,henhouseIDStr,qty);
				if(qty <= 0){
					continue;
				}
				// ����ƥ��  ƥ�䵽�� ���ݵ����¼��ϸ���� ���������� ͬʱ���� ������
				BreedModelEntryInfo modelEntryInfo =  currentBreedModelDetails.get(Integer.valueOf(i));
				if(modelEntryInfo != null && modelEntryInfo.getMaterial() != null){
					
					
					
					
					
					MaterialInfo  modelEntryMaterial = modelEntryInfo.getMaterial();
					// ����ƥ�� 
					if(currMaterial.getId().toString().equals(modelEntryMaterial.getId().toString())){
						
						CCProductPlanRptBean newRptBean = new CCProductPlanRptBean();
						newRptBean.setStoOrgID(stoBatchInfo.getStoOrgID());
						newRptBean.setStoOrgName(stoBatchInfo.getStoOrgName());
						newRptBean.setStoOrgNumber(stoBatchInfo.getStoOrgNumber());
						
						newRptBean.setBatchID(batchID);
						newRptBean.setBatchEntryIDs(stoBatchInfo.getBatchEntryIDs());
						newRptBean.setBatchName(stoBatchInfo.getBatchName());
						newRptBean.setBatchNumber(stoBatchInfo.getBatchNumber());
						
						newRptBean.setCostObjectID(stoBatchInfo.getCostObjectID());
						
						newRptBean.setInhouseDate(incoopDate);
						newRptBean.setInhouseQty(qty);
						newRptBean.setCurrDateNum(i);
						newRptBean.setDesc("");
						
						// ���ü�������
						newRptBean.setCurrentDate(currDate);
						
						
						// ���� ��������
						BigDecimal dcRate = modelEntryInfo.getDailyDCRate();
						// ����ι��
						BigDecimal perQtyEveryone = modelEntryInfo.getQtyPerday();
						
						// ���ܺ���
						BigDecimal perQtyAllday = perQtyEveryone.multiply(new BigDecimal(qty)).divide(new BigDecimal(1000),2,RoundingMode.HALF_UP);
						// �ۼƺ���
//						currTheoryQty = currTheoryQty.add(perQtyAllday);
						// �ۼ������ۺ�����
//						currTheoryQty = currTheoryQty.add(perQtyAllday);
						// ����������
						BigDecimal dayDCQty = ((new BigDecimal(qty)).multiply(dcRate)).divide(new BigDecimal(100),0,RoundingMode.HALF_UP);
						
						int dayDCQtyInt = dayDCQty.intValue();
						
						// ʣ������
						qty = qty - dayDCQtyInt;
						
						prediDays ++;
						
						
						
						
						// ���ϵ�ʵ����ι�� ����ι����
						BigDecimal actualQty = new BigDecimal("0.00");
						int actualDays  = 0;
						// ��ȡʵ����ι��
						String materialName = BREED_CONSTANTS.CC_RJ01;
						if(m ==1) materialName = BREED_CONSTANTS.CC_RJ01;
						if(m ==2) materialName = BREED_CONSTANTS.CC_RJ02;
						if(m ==3) materialName = BREED_CONSTANTS.CC_RJ03;
						// ����ʵ������
//						setOuthouseDays(ctx,newRptBean,m,batchID,materialName,henhouseIDStr);
						
						// ��ǰ����������ι�� ���õ�  �������TODO �˴��������list��map�����~~~
						if(m == 1){
							newRptBean.setOneMaterialID(currMaterial.getId().toString());
							newRptBean.setOneMaterialName(currMaterial.getName());
							newRptBean.setOneMaterialNumber(currMaterial.getNumber());
							newRptBean.setOneMaterialPredictDays(prediDays);
							newRptBean.setOneMaterialPredictQty(perQtyAllday);
						}else if(m == 2){
							newRptBean.setTwoMaterialID(currMaterial.getId().toString());
							newRptBean.setTwoMaterialName(currMaterial.getName());
							newRptBean.setTwoMaterialNumber(currMaterial.getNumber());
							newRptBean.setTwoMaterialPredictDays(prediDays);
							newRptBean.setTwoMaterialPredictQty(perQtyAllday);
						}else if(m == 3){
							newRptBean.setThreeMaterialID(currMaterial.getId().toString());
							newRptBean.setThreeMaterialName(currMaterial.getName());
							newRptBean.setThreeMaterialNumber(currMaterial.getNumber());
							newRptBean.setThreeMaterialPredictDays(prediDays);
							newRptBean.setThreeMaterialPredictQty(perQtyAllday);
						}
						
						// ������ ��ŵ��������
						resutlRptBeans.add(newRptBean);
					}
				}
			}
			
//			newRptBean.setPredictOuthouseDate(outcoopDate);
//			newRptBean.setPredictOuthouseQty(qty);
			
			
			
			
		}
		
		
//		// ����ڼ�����
//		for(int i = 1; i <= days; i++){
//			
//		}
		
		return resutlRptBeans;
	}
	
	
	
	/**
	 * ������ι��ϸ������ϼ� �����μ� �ܳ�������
	 * @param ctx
	 * @param stoBatchInfo
	 * @param batchID
	 * @param incoopDate
	 * @param outcoopDate
	 * @param incoopQty
	 * @param henhouseIDs
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws SQLException 
	 */
	private List<CCProductPlanRptBean> getBatchDetailFodders(Context ctx,CCProductPlanRptBean stoBatchInfo, String batchID,Date incoopDate,Date outcoopDate,int incoopQty,List<String> henhouseIDs) throws EASBizException, BOSException, SQLException{
		long timeLong = outcoopDate.getTime()-incoopDate.getTime();
		long days = timeLong / (1000 * 60 * 60 * 24);
		int outDays = (new Long(days)).intValue();
		
		
		List<CCProductPlanRptBean> result = new ArrayList<CCProductPlanRptBean>();
		

		
		
//		newRptBean.set
		// �����Ϻ� ��С���� ���ѭ��  ������������ͬ�� ��ֻ������ ����
		// ����
		int qty = incoopQty;
		
//		for(int m = 1; m <= currentBreedMaterials.size(); m++){
//			MaterialInfo currMaterial = currentBreedMaterials.get(Integer.valueOf(m));
//			if(StringUtils.isBlank(currMaterial.getName())){
//				currMaterial = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(currMaterial.getId()));
//				
//			}
			// �Ϻ� �ܺ���
//			BigDecimal currTheoryQty = new BigDecimal("0.00");
			// ������ι����
//			int prediDays = 0;
			for(int i = 1; i <= days; i++){
				// ����ƥ��  ƥ�䵽�� ���ݵ����¼��ϸ���� ���������� ͬʱ���� ������
				BreedModelEntryInfo modelEntryInfo =  currentBreedModelDetails.get(Integer.valueOf(i));
				if(modelEntryInfo != null && modelEntryInfo.getMaterial() != null){
					MaterialInfo  modelEntryMaterial = modelEntryInfo.getMaterial();
					
					
					CCProductPlanRptBean newRptBean = new CCProductPlanRptBean();
					newRptBean.setStoOrgID(stoBatchInfo.getStoOrgID());
					newRptBean.setStoOrgName(stoBatchInfo.getStoOrgName());
					newRptBean.setStoOrgNumber(stoBatchInfo.getStoOrgNumber());
					
					newRptBean.setBatchID(batchID);
					newRptBean.setBatchEntryIDs(stoBatchInfo.getBatchEntryIDs());
					newRptBean.setBatchName(stoBatchInfo.getBatchName());
					newRptBean.setBatchNumber(stoBatchInfo.getBatchNumber());
					
					newRptBean.setCostObjectID(stoBatchInfo.getCostObjectID());
					
					newRptBean.setInhouseDate(incoopDate);
					newRptBean.setInhouseQty(incoopQty);
					newRptBean.setCurrDateNum(outDays);
					newRptBean.setDesc("");
					
					// �����������Ϊ�� ���������
					if(StringUtils.isNotBlank(modelEntryMaterial.getName())){
						modelEntryMaterial = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(modelEntryMaterial.getId()));
					}
					// ����ƥ�� 
//					if(currMaterial.getId().toString().equals(modelEntryMaterial.getId().toString())){
						// ���� ��������
					BigDecimal dcRate = modelEntryInfo.getDailyDCRate();
					// ����ι��
					BigDecimal perQtyEveryone = modelEntryInfo.getQtyPerday();
					
					// ���ܺ���
					BigDecimal perQtyAllday = perQtyEveryone.multiply(new BigDecimal(qty)).divide(new BigDecimal(1000),2,RoundingMode.HALF_UP);
					// �ۼƺ���
//						currTheoryQty = currTheoryQty.add(perQtyAllday);
					// �ۼ������ۺ�����
//						currTheoryQty = currTheoryQty.add(perQtyAllday);
					// ����������
					BigDecimal dayDCQty = ((new BigDecimal(qty)).multiply(dcRate)).divide(new BigDecimal(100),0,RoundingMode.HALF_UP);
					
					int dayDCQtyInt = dayDCQty.intValue();
					
					// ʣ������
					qty = qty - dayDCQtyInt;
					
//						prediDays ++;
					
					

					newRptBean.setPredictOuthouseDate(outcoopDate);
					newRptBean.setPredictOuthouseQty(qty);
					
					// ��� �����������
					String henhouseIDStr = getHenhouseStr(henhouseIDs);
					// ���ϵ�ʵ����ι�� ����ι����
					BigDecimal actualQty = new BigDecimal("0.00");
					int actualDays  = 0;
					// ��ȡʵ����ι��
					String materialName = BREED_CONSTANTS.CC_RJ01;
				
					// ����ʵ������
//						setOuthouseDays(ctx,newRptBean,m,batchID,materialName,henhouseIDStr);
					
					// ��ǰ����������ι�� ���õ�  �������TODO �˴��������list��map�����~~~
					if(modelEntryMaterial.getName().indexOf(BREED_CONSTANTS.CC_RJ01) >= 0){
						newRptBean.setOneMaterialID(modelEntryMaterial.getId().toString());
						newRptBean.setOneMaterialName(modelEntryMaterial.getName());
						newRptBean.setOneMaterialNumber(modelEntryMaterial.getNumber());
//							newRptBean.setOneMaterialPredictDays(prediDays);
						newRptBean.setOneMaterialPredictQty(perQtyAllday);
					}else if(modelEntryMaterial.getName().indexOf(BREED_CONSTANTS.CC_RJ02) >= 0){
						newRptBean.setTwoMaterialID(modelEntryMaterial.getId().toString());
						newRptBean.setTwoMaterialName(modelEntryMaterial.getName());
						newRptBean.setTwoMaterialNumber(modelEntryMaterial.getNumber());
//							newRptBean.setTwoMaterialPredictDays(prediDays);
						newRptBean.setTwoMaterialPredictQty(perQtyAllday);
					}else if(modelEntryMaterial.getName().indexOf(BREED_CONSTANTS.CC_RJ03) >= 0){
						newRptBean.setThreeMaterialID(modelEntryMaterial.getId().toString());
						newRptBean.setThreeMaterialName(modelEntryMaterial.getName());
						newRptBean.setThreeMaterialNumber(modelEntryMaterial.getNumber());
//							newRptBean.setThreeMaterialPredictDays(prediDays);
						newRptBean.setThreeMaterialPredictQty(perQtyAllday);
					}
					
					// ���ӵ��������
					result.add(newRptBean);
				}
				
			}
			
		
		
		
//		// ����ڼ�����
//		for(int i = 1; i <= days; i++){
//			
//		}
		
		return result;
	}
	/**
	 * ����ʵ��ι��������ιʱ����ʵ�ʳ���ʱ�䡢ʵ�ʳ�����
	 * @param ctx
	 * @param batchID
	 * @param materialNames
	 * @param henhouseIDs
	 * @return
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	private CCProductPlanRptBean setOuthouseDays(Context ctx,CCProductPlanRptBean newRptBean,int mNum, String batchID, String materialName,String henhouseIDs) throws BOSException, SQLException{
		// ʵ��ι����
		BigDecimal actualFeedQty = new BigDecimal("0");
		// ʵ����ι�ճ�
		int actualDays = 0;
		// ʵ�ʳ�����
		int actualOutQty = 0;
		// ʵ�ʳ�������
		Date actualOutDate = null;
		
		if(StringUtils.isNotBlank(batchID)){
			StringBuilder sb  =  new StringBuilder();
			sb.append("select sum(te.CFDailyQtyAll) qty ");
			sb.append(" from  CT_FM_CommecialChilkenDaily t inner join CT_FM_CommecialCDE te on t.fid = te.fparentid ");
			sb.append(" inner join t_bd_material tm on te.cfmaterialid = tm.fid ");
			sb.append(" where t.CFBreedBatchID =? and tm.fname_l2 like '%");
			sb.append(materialName);
			sb.append("%' and te.CFHenhouseID in ");
			sb.append(henhouseIDs);
			
			Object[] args = {batchID};
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString(),args);
			
			if(rs.next()){
				actualFeedQty = rs.getBigDecimal("qty");
	//			 actualDays = rs.getInt("days");
			}
			// ��ȡʵ����ι����
			sb  =  new StringBuilder();
			sb.append("select count(distinct t.fbizdate) days ");
			sb.append(" from  CT_FM_CommecialChilkenDaily t inner join CT_FM_CommecialCDE te on t.fid = te.fparentid ");
			sb.append(" inner join t_bd_material tm on te.cfmaterialid = tm.fid ");
			sb.append(" where t.CFBreedBatchID =? and tm.fname_l2 like '%");
			sb.append(materialName);
			sb.append("%' and te.CFHenhouseID in ");
			sb.append(henhouseIDs);
			
			String[] args1 = {batchID};
			rs = DbUtil.executeQuery(ctx, sb.toString(),args1);
			if(rs.next()){
				 
				 actualDays = rs.getInt("days");
			}
			
			// ��ȡʵ�ʳ�������
			sb  =  new StringBuilder();
			sb.append("select min(t.fbizdate) outDate ");
			sb.append(" from  CT_FM_CommecialChilkenDaily t inner join CT_FM_CommecialCDAE te on t.fid = te.fparentid ");
	//		sb.append(" inner join t_bd_material tm on te.cfmaterialid = tm.fid ");
			sb.append(" where (te.CFIsMarketed = 1 or(te.CFMarketQty > 0 and te.CFBreedingStock=0))  and  t.CFBreedBatchID =? ");
	//		sb.append(materialName);
			sb.append(" and te.CFHenhouseID in ");
			sb.append(henhouseIDs);
			
			String[] args3 = {batchID};
			rs = DbUtil.executeQuery(ctx, sb.toString(),args3);
			Date outDate = null;
			if(rs.next()){
				 
				outDate = rs.getDate("outDate");
			}
			newRptBean.setActualOuthouseDate(outDate);
			
			
			// ��ȡʵ�ʳ�����
			sb  =  new StringBuilder();
			sb.append("select sum(te.CFMarketQty) outQty ");
			sb.append(" from  CT_FM_CommecialChilkenDaily t inner join CT_FM_CommecialCDAE te on t.fid = te.fparentid ");
	//		sb.append(" inner join t_bd_material tm on te.cfmaterialid = tm.fid ");
			sb.append(" where t.CFBreedBatchID =? ");
	//		sb.append(materialName);
			sb.append(" and te.CFHenhouseID in ");
			sb.append(henhouseIDs);
			
			String[] args2 = {batchID};
			rs = DbUtil.executeQuery(ctx, sb.toString(),args2);
			if(rs.next()){
				 
				 actualOutQty = rs.getInt("outQty");
			}
			// ʵ�ʳ�����
			newRptBean.setActualOuthouseQty(actualOutQty);
			// ��ǰ����������ι�� ���õ�  �������TODO �˴��������list��map�����~~~
			if(mNum == 1){
				
				newRptBean.setOneMaterialActualDays(actualDays);
				newRptBean.setOneMaterialActualQty(actualFeedQty);
			}else if(mNum == 2){
			
				newRptBean.setTwoMaterialActualDays(actualDays);
				newRptBean.setTwoMaterialActualQty(actualFeedQty);
			}else if(mNum == 3){
				
				newRptBean.setThreeMaterialActualDays(actualDays);
				newRptBean.setThreeMaterialActualQty(actualFeedQty);
			}
		}
		return newRptBean;
	}
	/**
	 * ���ָ�� �б��ļ���id�Ĺ�������  ��'','',''��
	 * @param henhouseIDs
	 * @return
	 */
	private String getHenhouseStr(List<String> henhouseIDs){
		StringBuilder sb = new StringBuilder("(");
		for(int i = 0; i < henhouseIDs.size(); i++){
			if(i != 0) {
				sb.append(",");
			}
			sb.append("'");
			sb.append(henhouseIDs.get(i));
			sb.append("'");
		}
		
		sb.append(")");
		
		return sb.toString();
	}
	
	/**
	 * ��ȡ��ǰ��ֳ�淶
	 * @param ctx
	 * @return
	 * @throws BOSException 
	 * @throws SQLException 
	 * @throws EASBizException 
	 */
	private BreedModelInfo getCurrentCCBreedModelInfo(Context ctx) throws BOSException, SQLException, EASBizException{
		String  sql = "select fid from CT_FM_BreedModel where CFHouseType = '3' and CFDeletedStatus = 1 ";
		IRowSet rs = DbUtil.executeQuery(ctx, sql);
		if(rs.size() > 1){
			throw new BOSException("��ǰ���õ���Ʒ����ֳ�淶������һ�����뽫���ڹ淶���ú��ٲ�ѯ");
		}else if(rs.size() == 0){
			throw new BOSException("û�����õ���Ʒ����ֳ�淶");
		}else{
			// ��ȡ����
			rs.next();
			String fid = rs.getString("fid");
			
			currentBreedModel = BreedModelFactory.getLocalInstance(ctx).getBreedModelInfo(new ObjectUuidPK(fid));
			
			BreedModelEntryCollection entryCol = currentBreedModel.getEntrys();
			
			if(entryCol != null && entryCol.size() > 0){
				if(currentBreedModelDetails == null){
					currentBreedModelDetails = new HashMap<Integer, BreedModelEntryInfo>();
				}
				for(int i =0; i < entryCol.size(); i++){
					BreedModelEntryInfo entryInfo = entryCol.get(i);
					entryInfo = BreedModelEntryFactory.getLocalInstance(ctx).getBreedModelEntryInfo(new ObjectUuidPK(entryInfo.getId()));
					// ������ϸ�浽�ڴ���
					//currentBreedModelDetails.put(Integer.valueOf(entryInfo.getWeekDay()), entryInfo);
					MaterialInfo currMaterial = entryInfo.getMaterial();
					// ���� ��ι �����б�
					addToCurrBreedMaterials(currMaterial);
					
				}
			}
			
			return currentBreedModel;
		}
		
	}
	
	/**
	 * �ж�ָ�������Ƿ��Ѿ������ڵ�ǰ��ι �����У������������������
	 * ˳�� ���� ��ֳ�淶 ��¼˳������
	 * @param currMaterial
	 */
	private void addToCurrBreedMaterials(MaterialInfo currMaterial) {
		if(this.currentBreedMaterials == null) currentBreedMaterials = new HashMap<Integer, MaterialInfo>();
		int i = currentBreedMaterials.size() + 1;
		
		Set<Integer> keySet = currentBreedMaterials.keySet();
		if(keySet != null && keySet.size() > 0){
			Iterator<Integer> keyIte = keySet.iterator();
			while(keyIte.hasNext()){
				MaterialInfo matInfo = currentBreedMaterials.get(keyIte.next());
				// ��������Ѿ����� �� ����
				if(matInfo.getId().toString().equals(currMaterial.getId().toString())){
					return;
				}
			}
		}
		
		// �б������ھ�����
		currentBreedMaterials.put(Integer.valueOf(i), currMaterial);
		
		
		
		
	}

	/**
	 * ��� ָ�����η�¼�� ʵ�ʳ�������
	 * @param ctx
	 * @param batchID
	 * @param henhouseid    ����id
	 * @return
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	private Date getBatchEntryOutcoopDate(Context ctx,String batchID,String henhouseid,Date incoopDate) throws BOSException, SQLException{
		StringBuilder sql = new StringBuilder("select top 1 t.fid billid,te.fid entryid, te.cfdays  ");
		sql.append(" from CT_FM_CommecialChilkenDaily t inner join CT_FM_CommecialCDAE te on t.fid = te.fparentid ");
//		sql.append("")
		sql.append(" where t.fid=? and te.cfhenhouseid=? and (te.CFBreedingStock is null or te.CFBreedingStock = 0) ");
		sql.append(" order by te.cfdays asc ");
		Object[] args = {batchID,henhouseid};
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(),args);
		if(rs.next()){
			String billid = rs.getString("billid");
			String entryid = rs.getString("entryid");
			int days = rs.getInt("cfdays");
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(incoopDate);
			cal.add(Calendar.DATE, days);
			
			return cal.getTime();
		}
		
		return null;
	}
	
	/**
	 * �����ֳ������Ϣ,�����������ֱ�� ���õ�ǰ������Ϣ
	 * ������  �Ѿ� ȡʵ����������������ȡ��������  
	 * @param ccRptBean
	 * @return
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	private List<CCProductPlanRptBean> getStoorgBatchInfo(Context ctx,CCProductPlanRptBean ccRptBean,HashMap param) throws BOSException, SQLException{
		
		// Ĭ����ֳ����
//		int preBreedDays = this.currentBreedModel.getBreedDays();
		
		List<CCProductPlanRptBean> batchs = new ArrayList<CCProductPlanRptBean>();
		
		// ȡ��ʼ����ǰ�����һ���ձ�����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder ssb = new StringBuilder();
		
		
	    ssb.append(" select top 1 t.cfstoorgid stoorgID, t.CFBreedBatchID batchID, ");
	    ssb.append(" max(t.fbizdate) bizdate , sum(te.CFBreedingStock) breedingStock , ");
	    ssb.append(" max(tbb.fnumber) batchNumber,max(tbc.fname_l2) batchName, max(tbb.CFCostObjectID) costObjectID,max(tbb.CFBreedPlanID) breedPlanID ");
	    
	    ssb.append(" from  ct_fm_commecialchilkendaily t ");
		ssb.append(" inner join CT_FM_CommecialCDAE te on t.fid = te.fparentid ");
		ssb.append(" inner join CT_FM_BreedBatch tbb on t.CFBreedBatchID = tbb.fid ");
		ssb.append(" inner join T_BD_CostObject tbc on tbb.CFCostObjectID = tbc.fid ");
		ssb.append(" where  ");
		ssb.append(" t.fbizdate <= {ts'");
		ssb.append(sdf.format(filterBeginDate));
		
		ssb.append("'} and  t.cfstoorgid='");
		ssb.append(ccRptBean.getStoOrgID());
		
		ssb.append("' group by t.cfstoorgid,t.CFBreedBatchID,t.fid ");
		ssb.append(" order by bizdate desc,breedingStock asc ");
	    
	    
		
		IRowSet rs = DbUtil.executeQuery(ctx, ssb.toString());
		if(rs.next()){
			// �ж� ��Ӧ
			int breedingStock = rs.getInt("breedingStock");
//			if(breedingStock > 0){
				
				String batchID = rs.getString("batchID");
				String batchNumber = rs.getString("batchNumber");
				String batchName = rs.getString("batchName");
				String costObjectID = rs.getString("costObjectID");
				String breedPlanID = rs.getString("breedPlanID");
				// �ж϶�Ӧ�����Ƿ��Ѿ���ȫ�����������ȫ����  �� ���� ���� �ƻ� �߼�
				CCProductPlanRptBean ccBean = new CCProductPlanRptBean();
				ccBean.setStoOrgID(ccRptBean.getStoOrgID());
				ccBean.setStoOrgName(ccRptBean.getStoOrgName());
				ccBean.setStoOrgNumber(ccRptBean.getStoOrgNumber());
				
				// ����������Ϣ
				ccBean.setPlan(false);
				ccBean.setPlanID(breedPlanID);
				ccBean.setBatchID(batchID);
				ccBean.setBatchNumber(batchNumber);
				ccBean.setBatchName(batchName);
				ccBean.setCostObjectID(costObjectID);
			
				batchs.add(ccBean);
				
				
//			}
			
			
		}
		
		// ȡ�ڹ���ʱ����� ����ձ�������
		ssb = new StringBuilder();
		 ssb.append(" select  t.cfstoorgid stoorgID, t.CFBreedBatchID batchID, ");
		    ssb.append(" max(t.fbizdate) bizdate , sum(te.CFBreedingStock) breedingStock , ");
		    ssb.append(" max(tbb.fnumber) batchNumber,max(tbc.fname_l2) batchName, max(tbb.CFCostObjectID) costObjectID ");
		    
		    ssb.append(" from  ct_fm_commecialchilkendaily t ");
			ssb.append(" inner join CT_FM_CommecialCDAE te on t.fid = te.fparentid ");
			ssb.append(" inner join CT_FM_BreedBatch tbb on t.CFBreedBatchID = tbb.fid ");
			ssb.append(" inner join T_BD_CostObject tbc on tbb.CFCostObjectID = tbc.fid ");
			ssb.append(" where  ");
			ssb.append(" t.fbizdate >= {ts'");
			ssb.append(sdf.format(filterBeginDate));
			ssb.append("'} and  t.fbizdate <= {ts'");
			ssb.append(sdf.format(filterEndDate));
			
			ssb.append("'} and  t.cfstoorgid='");
			ssb.append(ccRptBean.getStoOrgID());
			
			ssb.append("' group by t.cfstoorgid,t.CFBreedBatchID ");
			ssb.append(" order by bizdate desc,breedingStock asc ");
		    
		    
			
			rs = DbUtil.executeQuery(ctx, ssb.toString());
			while(rs.next()){
				// �ж� ��Ӧ
				int breedingStock = rs.getInt("breedingStock");
//				if(breedingStock > 0){
					
					String batchID = rs.getString("batchID");
					String batchNumber = rs.getString("batchNumber");
					String batchName = rs.getString("batchName");
					String costObjectID = rs.getString("costObjectID");
					
					// �ж϶�Ӧ�����Ƿ��Ѿ���ȫ�����������ȫ����  �� ���� ���� �ƻ� �߼�
					CCProductPlanRptBean ccBean = new CCProductPlanRptBean();
					ccBean.setStoOrgID(ccRptBean.getStoOrgID());
					ccBean.setStoOrgName(ccRptBean.getStoOrgName());
					ccBean.setStoOrgNumber(ccRptBean.getStoOrgNumber());
					
					// ����������Ϣ
					ccBean.setPlan(false);
					ccBean.setBatchID(batchID);
					ccBean.setBatchNumber(batchNumber);
					ccBean.setBatchName("��ֳ���Σ�"+batchName);
					ccBean.setCostObjectID(costObjectID);
				
					batchs.add(ccBean);
					
					
//				}
				
				
			}
		
		
		return batchs;
		
		
	}
	/**
	 * �����ֳ�ƻ���Ϣ,�ų����Ѿ����������εĽ��沿�֣��� �ƻ��Ѿ���ʼִ�еĲ���  �ų�����
	 * ������  ȡ��������  
	 * @param ccRptBean
	 * @return
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	private List<CCProductPlanRptBean> getStoorgPlanInfo(Context ctx,CCProductPlanRptBean ccRptBean,List<String> planIDs,HashMap param) throws BOSException, SQLException{
		
		// Ĭ����ֳ����
//		int preBreedDays = this.currentBreedModel.getBreedDays();

		List<CCProductPlanRptBean> plans = new ArrayList<CCProductPlanRptBean>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder ssb = new StringBuilder();
		
		String batchPlanID = "";
		if(planIDs != null && planIDs.size() > 0){
			batchPlanID = AppCommon.getIDRangeStr(planIDs);
			
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(filterBeginDate);
		cal.add(Calendar.DATE, -this.getBreedDays());
		Date filterLowDate = cal.getTime();
		
		// �����ֳ�ƻ� ����
		StringBuilder sql = new StringBuilder(" select distinct t.fid,t.fnumber from CT_FM_CCBreedPlan t ");
		sql.append(" inner join CT_FM_CCBreedPlanEntry te on t.fid = te.fparentid ");
		sql.append(" where t.CFStoOrgID = '");
		
		sql.append(ccRptBean.getStoOrgID());
		sql.append("' and  te.cfincoopdate >= {ts'");
		sql.append(sdf.format(filterLowDate));
		
		sql.append("'} ");
		sql.append(" and  te.cfincoopdate <= {ts'");
		sql.append(sdf.format(filterEndDate));
		
		sql.append("'} ");
		if(StringUtils.isNotBlank(batchPlanID)){
			sql.append(" and t.fid not in ");
			sql.append(batchPlanID);
		}
		
		IRowSet rs1 = DbUtil.executeQuery(ctx, sql.toString());
		while(rs1.next()){
			String fid = rs1.getString("fid");
			String fnumber = rs1.getString("fnumber");
			
			CCProductPlanRptBean newRptBean = new CCProductPlanRptBean();
			
			newRptBean.setStoOrgID(ccRptBean.getStoOrgID());
			newRptBean.setStoOrgName(ccRptBean.getStoOrgName());
			newRptBean.setStoOrgNumber(ccRptBean.getStoOrgNumber());
			
			newRptBean.setPlan(true);
			newRptBean.setBatchID(fid);
			newRptBean.setBatchNumber(fnumber);
			newRptBean.setBatchName("�����ƻ���"+fnumber);
			plans.add(newRptBean);
		}
			
		
		
		
		
		return plans;
	}
	
	
	
	/**
	 * ��� ���������� ��ֳ�����õ� �����
	 * @param param
	 * @return
	 * @throws BOSException 
	 */
	private List<CCProductPlanRptBean> getRptBeanStorageInfos(Context ctx,HashMap param) throws BOSException{
		// ��ֳ��
		String orgID = (String) param.get("stoOrgID");
		
		List<CCProductPlanRptBean> rptBeans = new ArrayList<CCProductPlanRptBean>();
		
		StringBuffer ssb  = new StringBuffer("select t.CFStoOrgID,max(ts.fnumber) stoOrgNumber,max(ts.fname_l2) stoOrgName from CT_FM_BreedStoorgSet t inner join t_org_storage ts on t.CFStoOrgID = ts.fid ");
//		ssb.append(" left join CT_FM_BreedBatch tb on ts.fid = tb.CFStoOrgID ");
		ssb.append(" where t.CFHenhouseType='3'  and CFStatus = 1 ");
		if(StringUtils.isNotBlank(orgID)){
			ssb.append(" and t.CFStoOrgID='");
			ssb.append(orgID);
			ssb.append("' ");
		}
		ssb.append(" group by t.CFStoOrgID ");
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, ssb.toString());
			while(rs.next()){
				String stoOrgID = rs.getString("CFStoOrgID");
				String stoOrgNumber = rs.getString("stoOrgNumber");
				String stoOrgName = rs.getString("stoOrgName");
				
				CCProductPlanRptBean bean = new CCProductPlanRptBean();
				bean.setStoOrgID(stoOrgID);
				bean.setStoOrgNumber(stoOrgNumber);
				bean.setStoOrgName(stoOrgName);
				
				rptBeans.add(bean);
			}
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
		return rptBeans;
	}
	
	/**
	 * ��ò������
	 * @param tempTableName
	 * @param columnCase
	 * @return
	 */
	private String getInsertSql(String tempTableName,CCProductPlanRptBean ccBean){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 StringBuffer sql = new StringBuffer();
		 
		 sql.append("insert into ");
		 sql.append(tempTableName);
		 sql.append(" values('");
		 sql.append(ccBean.getStoOrgID());
		 sql.append("','");
		 sql.append(ccBean.getStoOrgNumber());
		 sql.append("','");
		 sql.append(ccBean.getStoOrgName());
		 
		 // �Ƿ�ƻ�����
		 if(ccBean.isPlan()){
			 sql.append("','1','");
		 }else{
			 sql.append("','0','");
		 }
		 
		 sql.append(ccBean.getBatchID());
		 sql.append("','");
		 sql.append(ccBean.getBatchNumber());
		 sql.append("','");
		 sql.append(ccBean.getBatchName());
		 sql.append("',{ts'");
		 sql.append(sdf.format(ccBean.getInhouseDate()));
		 sql.append("'},");
		 sql.append(ccBean.getCurrDateNum());
		 sql.append(",");
		 sql.append(ccBean.getInhouseQty());
		 if(ccBean.getPredictOuthouseDate() != null){
			 sql.append(",{ts'");
			 sql.append(sdf.format(ccBean.getPredictOuthouseDate()));
			 sql.append("'},");
		 } else{
			 sql.append(",null,");
		 }
		 
		 sql.append(ccBean.getPredictOuthouseQty());
		 if(ccBean.getActualOuthouseDate() != null){
			 sql.append(",{ts'");
			 sql.append(sdf.format(ccBean.getActualOuthouseDate()));
			 sql.append("'},");
		 }else{
			 sql.append(",null,");
		 }
		 sql.append(ccBean.getActualOuthouseQty());
		 
		 // Ԥ������
		 if(ccBean.getCurrentDate() != null){
			 sql.append(",{ts'");
			 sql.append(sdf.format(ccBean.getCurrentDate()));
			 sql.append("'},");
		 }else{
			 sql.append(",null,");
		 }
		 sql.append("'");
		 sql.append(ccBean.getOneMaterialID());
		 sql.append("','");
		 sql.append(ccBean.getOneMaterialNumber());
		 sql.append("','");
		 sql.append(ccBean.getOneMaterialName());
		 sql.append("',");
		 sql.append(ccBean.getOneMaterialPredictDays());
		 sql.append(",");
		 sql.append(ccBean.getOneMaterialActualDays());
		 sql.append(",");
		 sql.append(ccBean.getOneMaterialPredictQty().toPlainString());
		 sql.append(",");
		 sql.append(ccBean.getOneMaterialActualQty().toPlainString());
		 sql.append(",'");
		 
		 sql.append(ccBean.getTwoMaterialID());
		 sql.append("','");
		 sql.append(ccBean.getTwoMaterialNumber());
		 sql.append("','");
		 sql.append(ccBean.getTwoMaterialName());
		 sql.append("',");
		 sql.append(ccBean.getTwoMaterialPredictDays());
		 sql.append(",");
		 sql.append(ccBean.getTwoMaterialActualDays());
		 sql.append(",");
		 sql.append(ccBean.getTwoMaterialPredictQty());
		 sql.append(",");
		 sql.append(ccBean.getTwoMaterialActualQty());
		 sql.append(",'");
		 
		 sql.append(ccBean.getThreeMaterialID());
		 sql.append("','");
		 sql.append(ccBean.getThreeMaterialNumber());
		 sql.append("','");
		 sql.append(ccBean.getThreeMaterialName());
		 sql.append("',");
		 sql.append(ccBean.getThreeMaterialPredictDays());
		 sql.append(",");
		 sql.append(ccBean.getThreeMaterialActualDays());
		 sql.append(",");
		 sql.append(ccBean.getThreeMaterialPredictQty());
		 sql.append(",");
		 sql.append(ccBean.getThreeMaterialActualQty());
		 sql.append(",'");
		 
		 
		 sql.append(ccBean.getDesc());
		 sql.append("')");
		  
		 return sql.toString();
	}
	
	/**
	 * ��ʱ���������
	 * @return
	 */
	private String getTempTableCreateSql(String temptableName)
	{
	  StringBuffer sql = new StringBuffer();
	  sql.append("create table ");
	  sql.append(temptableName);
	  sql.append("( stoorgID varchar(44), \r\n");
	  sql.append(" stoOrgNumber varchar(44), \r\n");
	  sql.append(" stoOrgName VARCHAR(80), \r\n");
	  
	  sql.append(" isPlan varchar(2), \r\n");
	  
	  sql.append(" batchID varchar(44), \r\n");
	  sql.append(" batchNumber varchar(44), \r\n");
	  sql.append(" batchName VARCHAR(80), \r\n");
	  
	  sql.append(" inhouseDate DATETIME, \r\n");
	  sql.append(" currDateNum int, \r\n");
	  sql.append(" inhouseQty int, \r\n");
	  sql.append(" predictOuthouseDate DATETIME, \r\n");
	  sql.append(" predictOuthouseQty int, \r\n");
	  sql.append(" actualOuthouseDate DATETIME, \r\n");
	  sql.append(" actualOuthouseQty int, \r\n");
	  
	  sql.append(" currentDate DATETIME, \r\n");
	  
	  sql.append(" OneMaterialID VARCHAR(44), \r\n");
	  sql.append(" OneMaterialNumber VARCHAR(44), \r\n");
	  sql.append(" OneMaterialName VARCHAR(80), \r\n");
	  sql.append(" OneMaterialPredictDays int, \r\n");
	  sql.append(" OneMaterialActualDays int, \r\n");
	  sql.append(" OneMaterialPredictQty DECIMAL(28,10), \r\n");
	  sql.append(" OneMaterialActualQty DECIMAL(28,10), \r\n");
	  
	  sql.append(" TwoMaterialID VARCHAR(44), \r\n");
	  sql.append(" TwoMaterialNumber VARCHAR(44), \r\n");
	  sql.append(" TwoMaterialName VARCHAR(44), \r\n");
	  sql.append(" TwoMaterialPredictDays int, \r\n");
	  sql.append(" TwoMaterialActualDays int, \r\n");
	  sql.append(" TwoMaterialPredictQty DECIMAL(28,10), \r\n");
	  sql.append(" TwoMaterialActualQty DECIMAL(28,10), \r\n");
	  
	  sql.append(" ThreeMaterialID VARCHAR(44), \r\n");
	  sql.append(" ThreeMaterialNumber VARCHAR(44), \r\n");
	  sql.append(" ThreeMaterialName VARCHAR(44), \r\n");
	  sql.append(" ThreeMaterialPredictDays int, \r\n");
	  sql.append(" ThreeMaterialActualDays int, \r\n");
	  sql.append(" ThreeMaterialPredictQty DECIMAL(28,10), \r\n");
	  sql.append(" ThreeMaterialActualQty DECIMAL(28,10), \r\n");
	  
	  sql.append(" FDESC VARCHAR(80) ");
	  sql.append(" )");
	  return sql.toString();
	}



	public Date getFilterBeginDate() {
		return filterBeginDate;
	}



	public void setFilterBeginDate(Date filterBeginDate) {
		this.filterBeginDate = filterBeginDate;
	}



	public Date getFilterEndDate() {
		return filterEndDate;
	}



	public void setFilterEndDate(Date filterEndDate) {
		this.filterEndDate = filterEndDate;
	}



	public void setBreedDays(int breedDays) {
		this.breedDays = breedDays;
	}



	public int getBreedDays() {
		return breedDays;
	}
	
    
    
}