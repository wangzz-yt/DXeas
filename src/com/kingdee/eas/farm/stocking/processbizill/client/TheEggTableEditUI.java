/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;


import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.data.query.QuerySort.SortItem;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.farm.hatch.EggSourceType;
import com.kingdee.eas.farm.hatch.HatchBaseData;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.Farm;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntry;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryCollection;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.hr.base.EntityFieldInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * 交蛋表
 * output class name
 */
public class TheEggTableEditUI extends AbstractTheEggTableEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(TheEggTableEditUI.class);

	/**
	 * output class constructor
	 */
	public TheEggTableEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
		setSupplierHided();
	}
	@Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)){
			MsgBox.showWarning("审核状态下禁止编辑！");
			SysUtil.abort();
		}


		super.actionEdit_actionPerformed(arg0);
	}
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		setUITitle("交蛋表");
		//修改图标
		tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		//全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		//初始化事件
		initListeners();
		apendFootRow(kdtEntrys);
		UIUtil.setQualityPhaseDisplayFormat(new KDTable[]{kdtEntrys});

		KDBizPromptBox entryFarmersTree = ((KDBizPromptBox)kdtEntrys.getColumn("farmersTree").getEditor().getComponent());
		entryFarmersTree.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmerGroupQuery");
		entryFarmersTree.setCommitFormat("$name$");
		entryFarmersTree.setDisplayFormat("$name$");
		entryFarmersTree.setEnabled(false);
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)){
			this.btnAddLine.setEnabled(false);
			this.btnRemoveLine.setEnabled(false);
			this.btnInsertLine.setEnabled(false);
		}
		this.btnTraceUp.setVisible(true);
		this.btnTraceDown.setVisible(true);
		this.btnCopy.setVisible(true);




		this.prmtstockingBillNum.setQueryInfo("com.kingdee.eas.farm.stocking.processbizill.app.F7StockingBreedDailyQuery");		
		this.prmtstockingBillNum.setVisible(true);		
		this.prmtstockingBillNum.setEditable(true);		
		this.prmtstockingBillNum.setDisplayFormat("$number$");		
		this.prmtstockingBillNum.setEditFormat("$number$");		
		this.prmtstockingBillNum.setCommitFormat("$number$");		
		this.prmtstockingBillNum.setRequired(false);



		//默认为放养
		if(oprtState.equals("ADDNEW"))
			eggSource.setSelectedItem(EggSourceType.InternalFarm);

		kdtEntrys.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStarted(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStarted(e);
				kdteditStarted(e);
			}

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				String curStorageOrgUnitID = "";
				if(prmtstorageOrgUnit.getValue()!=null)
					curStorageOrgUnitID=((StorageOrgUnitInfo)prmtstorageOrgUnit.getValue()).getString("id");

				if("sendBasketQty".equalsIgnoreCase(kdtEntrys.getColumnKey(e.getColIndex()))){
					kdtEntrys.getCell(e.getRowIndex(), "confirmBasketQty").setValue(e.getValue());
				}
				if("sendAllQty".equalsIgnoreCase(kdtEntrys.getColumnKey(e.getColIndex()))){
					kdtEntrys.getCell(e.getRowIndex(), "confirmAllQty").setValue(e.getValue());
				}
				try {

					//由批次带出其他相关信息
					if("stockingBatch".equalsIgnoreCase(kdtEntrys.getColumnKey(e.getColIndex()))){
						if(kdtEntrys.getCell(e.getRowIndex(),"stockingBatch").getValue()!=null){
//							kdtEntrys.getCell(e.getRowIndex(), "farmer").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(e.getRowIndex(),"stockingBatch").getValue(), "farmer"));
							kdtEntrys.getCell(e.getRowIndex(), "farm").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(e.getRowIndex(),"stockingBatch").getValue(), "farm"));
							kdtEntrys.getCell(e.getRowIndex(), "breedData").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(e.getRowIndex(),"stockingBatch").getValue(), "breedData"));
							kdtEntrys.getCell(e.getRowIndex(), "serial").setValue(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(e.getRowIndex(),"breedData").getValue(), "genderType"));
//							if(kdtEntrys.getCell(e.getRowIndex(), "farmer").getValue()!=null){
//								FarmersInfo farmersInfo = FarmersFactory.getRemoteInstance().getFarmersInfo(new ObjectUuidPK(UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(e.getRowIndex(),"farmer").getValue(), "id").toString()));
//								FarmersTreeInfo treeInfo = null;
//								if(farmersInfo.getTreeid()!=null)
//									treeInfo=FarmersTreeFactory.getRemoteInstance().getFarmersTreeInfo(new ObjectUuidPK(farmersInfo.getTreeid().getString("id")));
//								kdtEntrys.getCell(e.getRowIndex(), "farmersTree").setValue(treeInfo);
//							}

							if(pkBizDate.getValue()!=null){
								StockingBatchInfo batchInfo=(StockingBatchInfo) kdtEntrys.getCell(e.getRowIndex(),"stockingBatch").getValue();
								if(batchInfo.getFormalDate()!=null&&!batchInfo.getFormalDate().after((Date)pkBizDate.getValue()))
									kdtEntrys.getCell(e.getRowIndex(), "isFormal").setValue(true);
							}


						}
						setEntryAge(e.getRowIndex());
					}
				} catch (DataAccessException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (BOSException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (EASBizException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}


				//yumignxu  20180830
				//BigDecimal runQty=UIRuleUtil.getBigDecimal(kdtEggEntry.getCell(rowIndex,"runQty").getValue());
				BigDecimal qcEggQty=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"qualified").getValue());
				//BigDecimal dissharpEgg=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"dissharpEgg").getValue());
				//BigDecimal doubleEgg=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"doubleEgg").getValue());
				BigDecimal dissharpEgg=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"jxd").getValue());
				BigDecimal doubleEgg=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"shd").getValue());
				BigDecimal BBQty=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"BBQty").getValue());

				
//				BigDecimal ccd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"ccd").getValue());
//				BigDecimal jxd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"jxd").getValue());
//				BigDecimal shd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"shd").getValue());
//				BigDecimal zd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"zd").getValue());
//				BigDecimal rd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"rd").getValue());
				BigDecimal dpd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"dpd").getValue());
//				BigDecimal pd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"pd").getValue());
//				BigDecimal fxd=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(e.getRowIndex(),"fxd").getValue());
				BigDecimal allQty = qcEggQty.add(dissharpEgg).add(doubleEgg).add(BBQty).add(dpd);
				kdtEntrys.getCell(e.getRowIndex(), "sendAllQty").setValue(allQty);	
			}
		});
		FilterInfo filter1=new FilterInfo();
		filter1.getFilterItems().add(new FilterItemInfo("name","%栋%",CompareType.NOTLIKE));
		EntityViewInfo ev1=new EntityViewInfo();
		ev1.setFilter(filter1);
		prmtstorageOrgUnit.setEntityViewInfo(ev1);







		//界面加载的时候需要过滤养殖日报
		if(this.pkBizDate.getValue() != null && this.prmtcompany.getValue() != null){
			setfieldOfStocking();
		}

		//日期改变添加监听事件，过滤养殖日报
		pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(pkBizDate.getValue() != null && prmtcompany.getValue() != null){
					setfieldOfStocking();
				}
			}
		});

		//公司改变添加监听事件，过滤养殖日报
		prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(pkBizDate.getValue() != null && prmtcompany.getValue() != null){
					setfieldOfStocking();
				}
			}
		});

		//养殖日报字段添加监听事件

		prmtstockingBillNum.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				//将养殖日报信息添加到交蛋表的分录中来
				addEntry();
			}
		});


		kdtEntrys.getColumn("farmer").getStyleAttributes().setHided(true);
		kdtEntrys.getColumn("farmer").getStyleAttributes().isHided();

	}


	/**
	 * 界面加载的时候根据日期和财务组织过滤养殖日报
	 */
	private void setfieldOfStocking() {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date bizdate = (Date) this.pkBizDate.getValue();
		CompanyOrgUnitInfo companyInfo = (CompanyOrgUnitInfo) this.prmtcompany.getValue();
		String companyid = companyInfo.getId().toString();
		String sq = "/*dialect*/ select t1.fid  billid  from T_FM_StockingBreedDaily t1  where to_char(t1.fbizdate,'yyyy-mm-dd')='"+sdf.format(bizdate)+"' and t1.FCompanyID='"+companyid+"'";
		ISQLExecutor executor = SQLExecutorFactory.getRemoteInstance(sq);
		IRowSet rs = null;
		String billid = null;
		//定义一个List用来存放查询到的养殖日报id
		List<String> billidList = new ArrayList<String>();
		try {
			rs = executor.executeSQL();
			while(rs.next()){
				billid = rs.getString("billid");
				billidList.add(billid);

			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//为养殖日报设置过滤条件
		//定义一个过滤视图
		EntityViewInfo viewInfo = new EntityViewInfo();
		//设置过滤条件
		FilterInfo filterInfo = new FilterInfo();
		//参数
		//		 filterInfo.getFilterItems().add(new FilterItemInfo("id",billidList.toString(),CompareType.INCLUDE));
		filterInfo.getFilterItems().add(new FilterItemInfo("bizDate",bizdate,CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("company.id",companyid,CompareType.EQUALS));
		filterInfo.setMaskString("#0 and #1");
		//设置筛选过的养殖日报过滤
		SorterItemCollection sortCol = new SorterItemCollection();
		SorterItemInfo itemInfo = new SorterItemInfo("number");
		itemInfo.setSortType(SortType.DESCEND);
		sortCol.add(itemInfo);

		//指定查询字段
		//		 SelectorItemCollection selector = new SelectorItemCollection(); //将查询指定字段
		//	     selector.add(new SelectorItemInfo("number"));


		viewInfo.setSorter(sortCol);
		viewInfo.setFilter(filterInfo);
		//		 viewInfo.setSelector(selector);
		prmtstockingBillNum.setEntityViewInfo(viewInfo);

	}

	/**
	 * 将养殖日报中的信息添加到交蛋表分录中来
	 */
	protected void addEntry() {
		// TODO Auto-generated method stub
		//首先删除分录中的行
//		kdtEntrys.removeRows();
//		if(prmtstockingBillNum.getValue() == null){
//			return;
//		}else{
//			//获取养殖日报的Info
//			StockingBreedDailyInfo stockingInfo = (StockingBreedDailyInfo) prmtstockingBillNum.getValue();
//			//获取养殖日报的产蛋信息分录
//			StockingBreedDailyEggEntryCollection eggClo = stockingInfo.getEggEntry();
//
//			//获取周龄，日龄
//			int week = stockingInfo.getWeek();
//			int weekDay = stockingInfo.getWeekDay();
//			//获取总日龄
//			String allDay = stockingInfo.getSumWeekDay();
//
//
//			//获取批次信息
//			String batchid = stockingInfo.getStockingBatch().getId().toString();
//			StockingBatchInfo batchInfo = null;
//
//			//获取养殖场信息
//			String farmid = stockingInfo.getFarm().getId().toString();
//			FarmInfo farmInfo = null;
//			//获取养殖户信息
//			FarmersInfo farmerInfo = null;
//
//			try {
//				batchInfo = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(batchid));
//				farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farmid));
//
//				//根据养殖场设置养殖户
//				String s1 = " /*dialect*/ select t1.fid farmerid from T_FM_Farmers t1 inner join T_FM_FarmersFarmEntry t2 on t2.FParentID = t1.fid where t2.FFarmID ='"+farmInfo.getId()+"'";
//				IRowSet r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
//				String farmerid = null;
//				if(r1.next()){
//					farmerid = r1.getString("farmerid");
//					farmerInfo = FarmersFactory.getRemoteInstance().getFarmersInfo(new ObjectUuidPK(farmerid));
//				}
//			} catch (EASBizException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (BOSException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//
//
//			//产蛋信息分录
//			StockingBreedDailyEggEntryInfo eggInfo = null;
//			//棚舍
//			String houseid = null;
//			FarmHouseEntryInfo houseInfo = null;
//			//品种资料
//			BreedDataInfo breedDataInfo = null;
//			//合格蛋数量
//			BigDecimal healthEgg = BigDecimal.ZERO;
//			//畸形蛋数量
//			BigDecimal dissharpEgg = BigDecimal.ZERO;
//			//双黄蛋数量
//			BigDecimal doubleEgg = BigDecimal.ZERO;
//			
//			//获取交蛋日期
//			Date sendDate = (Date) this.pkBizDate.getValue(); 
//
//			//遍历养殖日报的产蛋信息分录，并且将值添加到交蛋表的分录中来
//			for(int i=0,eggSize = eggClo.size();i<eggSize;i++){
//				eggInfo = eggClo.get(i);
//				//获取棚舍
//				houseid = eggInfo.getHouse().getId().toString();
//				try {
//					houseInfo = FarmHouseEntryFactory.getRemoteInstance().getFarmHouseEntryInfo(new ObjectUuidPK(houseid));
//					breedDataInfo = BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(batchInfo.getBreedData().getId()));
//				} catch (EASBizException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (BOSException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				//获取合格蛋数量
//				healthEgg = UIRuleUtil.getBigDecimal(eggInfo.getQcEggQty());
//				//畸形蛋数量
//				dissharpEgg = UIRuleUtil.getBigDecimal(eggInfo.getMutnatQty());
//				//双黄蛋数量
//				doubleEgg = UIRuleUtil.getBigDecimal(eggInfo.getDoubleQty());
//				//每次遍历交蛋表新增一行
//				kdtEntrys.addRow();
//				//设置批次
//				kdtEntrys.getCell(i, "stockingBatch").setValue(batchInfo);
//				//设置养殖场
//				kdtEntrys.getCell(i, "farm").setValue(farmInfo);
//				//设置养殖户
//				kdtEntrys.getCell(i, "farmer").setValue(farmerInfo);
//				//设置棚舍
//				kdtEntrys.getCell(i, "house").setValue(houseInfo);
//				//设置品种资料
//				kdtEntrys.getCell(i, "breedData").setValue(breedDataInfo);
//				//设置合格蛋数量
//				kdtEntrys.getCell(i, "qualified").setValue(healthEgg);
//				//设置畸形蛋数量
//				kdtEntrys.getCell(i, "dissharpEgg").setValue(dissharpEgg);
//				//设置双黄蛋数量
//				kdtEntrys.getCell(i, "doubleEgg").setValue(doubleEgg);
//				//设置报送数量
//				kdtEntrys.getCell(i, "sendAllQty").setValue(healthEgg.add(dissharpEgg).add(doubleEgg));
//				//设置周龄
//				kdtEntrys.getCell(i, "weekAge").setValue(week+"周"+weekDay);
//				//设置日龄
//				kdtEntrys.getCell(i, "dayAge").setValue(allDay);
//			}
//
//		}
	}
	/**
	 * 初始化事件
	 */
	private void initListeners() {
		// TODO Auto-generated method stub
		this.txtAddRows.setText("3");
		//新增多行
		btnAddRows.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				if(txtAddRows.getIntegerValue()>0)
					if(editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)){
						MsgBox.showWarning("审核状态下禁止编辑！");
						SysUtil.abort();
					}

				for(int i=0;i<txtAddRows.getIntegerValue();i++){
					kdtEntrys.addRow();
					kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "sendDate").setValue(new Date());
					kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "isFormal").setValue(false);
				}
			}
		});

		eggSource.addItemListener(new ItemListener(){

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				setSupplierHided();
			}
		});

		//合计行
		kdtEntrys.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){

			public void propertyChange(KDTPropertyChangeEvent e) {
				// TODO Auto-generated method stub
				apendFootRow(kdtEntrys);
			}});
		//默认带出日期为今天
		kdtEntrys_detailPanel.getAddNewLineButton().addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				if(kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "sendDate").getValue()==null){
					kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "sendDate").setValue(new Date());
					kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "isFormal").setValue(false);
				}
			}});
		prmthatchfactory.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				HatchBaseDataInfo hinfo = (HatchBaseDataInfo) prmthatchfactory.getValue();
				StorageOrgUnitInfo info;
				try {
					info = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK( hinfo.getHatchFactory().getId().toString()));
					prmtstorageOrgUnit.setValue(info);
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		});	
		//根据库存组织过滤批次
		prmtstorageOrgUnit.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				StorageOrgUnitInfo info = (StorageOrgUnitInfo) prmtstorageOrgUnit.getValue();
				KDBizPromptBox entryStockBatch = ((KDBizPromptBox)kdtEntrys.getColumn("stockingBatch").getEditor().getComponent());
				//entryStockBatch.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmerGroupQuery");
				FilterInfo filter=new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("farm.name",info.getName(),CompareType.EQUALS));
				EntityViewInfo ev=new EntityViewInfo();
				ev.setFilter(filter);
				entryStockBatch.setEntityViewInfo(ev);
			}
		});

	}
	/**
	 * 设置分录的供应商和批次可见性
	 */
	private void setSupplierHided() {
		// TODO Auto-generated method stub
		if(!eggSource.getSelectedItem().equals(EggSourceType.Purchase)){
			for(int i=0;i<kdtEntrys.getRowCount();i++){
				kdtEntrys.getCell(i, "supplier").setValue(null);
				kdtEntrys.getCell(i, "lot").setValue(null);
			}
			kdtEntrys.getColumn("supplier").getStyleAttributes().setHided(true);
			kdtEntrys.getColumn("lot").getStyleAttributes().setHided(true);
		}else{
			kdtEntrys.getColumn("supplier").getStyleAttributes().setHided(false);
			kdtEntrys.getColumn("lot").getStyleAttributes().setHided(false);
			//yumingxu 必填项
			kdtEntrys.getColumn("supplier").setRequired(true);
			kdtEntrys.getColumn("lot").setRequired(true);
		}
		
		kdtEntrys.getColumn("farmer").getStyleAttributes().setHided(true);
		kdtEntrys.getColumn("farmer").getStyleAttributes().isHided();
		
	}


	/**
	 * 审核操作
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		UIUtil.refreshEditUI(this);
		MsgBox.showInfo("审核成功");
		this.showMessage();
		lockUIForViewStatus();
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);	
		reloadData();
	}
	/**
	 * 提交
	 */
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		//		UIUtil.refreshEditUI(this);
	}
	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		UIUtil.refreshEditUI(this);
		MsgBox.showInfo("反审核成功");
		this.showMessage();
		this.btnEdit.setEnabled(true);
		reloadData();
	}
	/**
	 * 重载单据内容
	 * @throws EASBizException
	 * @throws BOSException
	 * @throws Exception
	 */
	private void reloadData() throws EASBizException, BOSException, Exception{

		if ((this.editData == null) || (this.editData.getId() == null)) {
			return;
		}
		IObjectPK pk = new ObjectUuidPK(this.editData.getId());
		setDataObject(getValue(pk));
		EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
		loadFields();
		restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
		initOldData(this.editData);
		setSave(true);
		setSaved(true);
		// 中断
		SysUtil.abort();



	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.processbizill.TheEggTableFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setBizDate(new Date());

		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setBillStatus(BillBaseStatusEnum.ADD);
		objectValue.setEggSource(EggSourceType .InternalFarm);

		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		return objectValue;
	}
	/**
	 * 开始编辑
	 * @param e
	 */
	private void kdteditStarted(KDTEditEvent e) {
		int rowIndex=e.getRowIndex();
		if(rowIndex<0) {
			return;
		}
		String key=this.kdtEntrys.getColumnKey(e.getColIndex());
		if(key.equals("farmer")||key.equals("farm")||key.equals("stockingBatch")||key.equals("house")) {
			//			KDBizPromptBox prmtFarmer = (KDBizPromptBox) this.kdtEntrys.getColumn("farmer").getEditor().getComponent();
			KDBizPromptBox prmtFarm = (KDBizPromptBox) this.kdtEntrys.getColumn("farm").getEditor().getComponent();
			KDBizPromptBox prmtBatch = (KDBizPromptBox) this.kdtEntrys.getColumn("stockingBatch").getEditor().getComponent();
			String batchID=null,farmerID=null,farmID=null,houseID=null;
			if(this.kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {
				batchID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getString("id");
			}
//			if(this.kdtEntrys.getCell(rowIndex, "farmer").getValue()!=null) {
//				farmerID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "farmer").getValue()).getString("id");
//			}
			if(this.kdtEntrys.getCell(rowIndex, "farm").getValue()!=null) {
				farmID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "farm").getValue()).getString("id");
			}
			if(this.kdtEntrys.getCell(rowIndex, "house").getValue()!=null) {
				houseID=((IPropertyContainer) this.kdtEntrys.getCell(rowIndex, "house").getValue()).getString("id");
			}

			String curCompanyID = "";
			if(prmtcompany.getValue()!=null)
				curCompanyID=((CompanyOrgUnitInfo)prmtcompany.getValue()).getString("id");
			StockingClientComm.setStockingBatchFilter(prmtBatch,curCompanyID,farmerID,farmID,houseID);
			//养殖场过滤
			StockingClientComm.setFarmFilter(prmtFarm, curCompanyID, farmerID);
			//棚舍过滤
			HashSet set = StockingClientComm.getAllOutHouseIDsByBatchID(curCompanyID, batchID, farmID,false);
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
			ev.setFilter(filter);
			((KDBizPromptBox)this.kdtEntrys.getColumn("house").getEditor().getComponent()).setEntityViewInfo(ev);
		}
	}
	private void setEntryAge(int rowIndex) throws DataAccessException, BOSException, EASBizException {
		int week=0;
		int weekDay=0;
		//		if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null&&kdtEntrys.getCell(rowIndex, "sendDate").getValue()!=null) {
		if(kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()!=null) {
			Date inDate=null;
			if(kdtEntrys.getCell(rowIndex, "house").getValue()==null) {//禽舍为空 
				inDate= (Date) UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue(), "inDate");
			}else{//禽舍不为空
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("HouseEntry.*");
				StockingBatchInfo batchInfo = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(((IPropertyContainer) kdtEntrys.getCell(rowIndex, "stockingBatch").getValue()).getString("id")),slor);

				for(int index=0;index<batchInfo.getHouseEntry().size();index++) {
					if(batchInfo.getHouseEntry().get(index).getHouse().getString("id").equals(((IPropertyContainer) kdtEntrys.getCell(rowIndex, "house").getValue()).getString("id"))) {
						inDate=batchInfo.getHouseEntry().get(index).getInData();
						break;
					}
				}
			}

			Date sendDate = (Date) this.pkBizDate.getValue();

			//			int[] result = StockingComm.getBreedWeekAndDay((Date) kdtEntrys.getCell(rowIndex, "sendDate").getValue(), inDate);
			int[] result = StockingComm.getBreedWeekAndDay(sendDate, inDate);
			week=result[0];
			weekDay=result[1];
		}

		kdtEntrys.getCell(rowIndex, "weekAge").setValue(week+"周"+weekDay);
		kdtEntrys.getCell(rowIndex, "dayAge").setValue(week>0?(week-1)*7+weekDay:0);
	}
	/** 
	 * 功能：添加合计行 
	 *  
	 * @param table 
	 *            指定的KDTable 
	 * @param fields 
	 *            需要合计的列 
	 */  
	public static void apendFootRow(KDTable table, String fields[]) {  
		int size = fields.length;  
		if (size == 0)  
			return;  
		Map sumValue = new HashMap();  
		// 利用getRowCount得到的行可能不正确  
		int count = table.getRowCount();  
		if(count == 0){
			count = table.getRowCount1();
		}
		if(count == 0){
			count = table.getRowCount3();
		}
		for (int i = 0; i < fields.length; i++) {  
			sumValue.put(fields[i], new BigDecimal("0"));  
		}  
		IRow footRow = null;  
		KDTFootManager footManager = table.getFootManager();  
		if (footManager == null) {  
			footManager = new KDTFootManager(table);  
			footManager.addFootView();  
			table.setFootManager(footManager);  
		}  
		// 计算所有指定行的合计值  
		footRow = footManager.getFootRow(0);  
		for (int i = 0; i < count; i++) {  
			IRow row = table.getRow(i);
			if(row.getStyleAttributes().isHided())
				continue;
			for (int j = 0; j < fields.length; j++) {  
				sumValueForCell(row, fields[j], sumValue);  
			}  
		}  

		if (footRow == null) {  
			footRow = footManager.addFootRow(0);  
		}  
		// 设置合计行显示样式  
		String colFormat = "%{0}f";  

		String total = com.kingdee.eas.util.client.EASResource.getString(FrameWorkClientUtils.strResource  
				+ "Msg_Total");  

		table.getIndexColumn().setWidthAdjustMode(KDTIndexColumn.WIDTH_MANUAL);  
		table.getIndexColumn().setWidth(30);  
		footManager.addIndexText(0, total);  
		footRow.getStyleAttributes().setBackground(new Color(0xf6, 0xf6, 0xbf));  
		for (int i = 0; i < size; i++) {  
			String colName = fields[i];  
			footRow.getCell(colName).getStyleAttributes().setNumberFormat(  
					colFormat);  
			footRow.getCell(colName).getStyleAttributes().setHorizontalAlign(  
					HorizontalAlignment.RIGHT);  
			footRow.getCell(colName).getStyleAttributes().setFontColor(  
					Color.black);  
		}  

		// 设置合计行的值  
		for (int i = 0; i < fields.length; i++) {  
			footRow.getCell(fields[i]).setValue(sumValue.get(fields[i]));  
		}  
	}  

	private static void sumValueForCell(IRow row, String key, Map sumValue) {  
		ICell cell = row.getCell(key);  

		if (cell != null) {  
			Object obj = cell.getValue();  
			if (obj != null) {  
				BigDecimal keyValue = (BigDecimal) sumValue.get(key);  
				keyValue = keyValue.add(new BigDecimal(obj.toString()));  
				sumValue.put(key, keyValue);  
			}  
		}  
	}

	/**
	 * 表格【】  以amout，amt，qty结尾的字段添加合计行
	 * @param table
	 */
	public static void apendFootRow(KDTable table[]){
		ArrayList<String> columnName=new ArrayList<String>();
		for(int i=0;i<table.length;i++){
			columnName.clear();
			for(int j=0;j<table[i].getColumnCount();j++)
				if(table[i].getColumn(j).getKey().toLowerCase().contains("qty")
						||table[i].getColumn(j).getKey().toLowerCase().contains("amount")
						||table[i].getColumn(j).getKey().toLowerCase().contains("amt"))
					columnName.add(table[i].getColumn(j).getKey());
			apendFootRow(table[i], columnName.toArray(new String[columnName.size()]));
		}
	}

	/**
	 * 单个表格【】  以amout，amt，qty结尾的字段添加合计行
	 * @param table
	 */
	public static void apendFootRow(KDTable table){
		ArrayList<String> columnName=new ArrayList<String>();
		columnName.clear();
		for(int j=0;j<table.getColumnCount();j++)
			if(table.getColumn(j).getKey().toLowerCase().contains("qty")
					||table.getColumn(j).getKey().toLowerCase().contains("amount")
					||table.getColumn(j).getKey().toLowerCase().contains("amt")
					||table.getColumn(j).getKey().toLowerCase().contains("qualified")
					||table.getColumn(j).getKey().toLowerCase().contains("qualifieds")
					||table.getColumn(j).getKey().toLowerCase().contains("Squalified")
					||table.getColumn(j).getKey().toLowerCase().contains("ccd")
					||table.getColumn(j).getKey().toLowerCase().contains("jxd")
					||table.getColumn(j).getKey().toLowerCase().contains("jxds")
					||table.getColumn(j).getKey().toLowerCase().contains("shd")
					||table.getColumn(j).getKey().toLowerCase().contains("shds")
					||table.getColumn(j).getKey().toLowerCase().contains("dzd")
					||table.getColumn(j).getKey().toLowerCase().contains("rd")
					||table.getColumn(j).getKey().toLowerCase().contains("dpd")
					||table.getColumn(j).getKey().toLowerCase().contains("pd")
					||table.getColumn(j).getKey().toLowerCase().contains("fxd")


			)
				columnName.add(table.getColumn(j).getKey());
		apendFootRow(table, columnName.toArray(new String[columnName.size()]));
	}

	/**
	 * //设置复制之后新的单据的编号为空，单据状态为新增
	 */
	@Override
	protected void setFieldsNull(AbstractObjectValue arg0) {
		// TODO Auto-generated method stub
		super.setFieldsNull(arg0);
		arg0.put("billStatus", BillBaseStatusEnum.ADD);
		arg0.put("Number", "");
		arg0.put("Auditor", "");
		arg0.put("auditTime", "");
	}




}