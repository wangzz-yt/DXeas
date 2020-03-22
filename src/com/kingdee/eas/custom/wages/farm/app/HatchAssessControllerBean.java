package com.kingdee.eas.custom.wages.farm.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.HashMap;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.eas.custom.wages.farm.HatchAssessCollection;
import com.kingdee.eas.custom.wages.farm.HatchAssessEntryCollection;
import com.kingdee.eas.custom.wages.farm.HatchAssessEntryInfo;
import com.kingdee.eas.custom.wages.farm.HatchAssessFactory;
import com.kingdee.eas.custom.wages.farm.MonthBillFarmFactory;
import com.kingdee.eas.custom.wages.farm.MonthBillFarmInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.custom.wages.farm.HatchAssessInfo;
import com.kingdee.eas.custom.wages.food.AssessmentMeasureEntryCollection;
import com.kingdee.eas.custom.wages.food.AssessmentMeasureEntryInfo;
import com.kingdee.eas.custom.wages.food.AssessmentMeasureInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class HatchAssessControllerBean extends AbstractHatchAssessControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.wages.farm.app.HatchAssessControllerBean");
    HashMap<String, String> map = new HashMap<String, String>();
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		HatchAssessInfo info = (HatchAssessInfo) model;
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		HatchAssessInfo info = (HatchAssessInfo) model;
		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		info = wagecalculation(ctx,model);
		return super._submit(ctx, info);
	}
	/**
	 *<p>Custom: ����Ͽ</p>
	 *<p>Company: �ൺδ������</p>
	 * @author ������
	 * ���˼���
	 */
	protected HatchAssessInfo wagecalculation(Context ctx, IObjectValue model){
		HatchAssessInfo info = (HatchAssessInfo) model;
		HatchAssessEntryCollection infoec = info.getEntrys();
		for(int i = 0;i<infoec.size();i++){
			HatchAssessEntryInfo infoe = infoec.get(i);
			BigDecimal AssessWages = infoe.getJjjs();
			if(new BigDecimal(infoe.getBlsx()).compareTo(BigDecimal.ZERO)!=0||infoe.getBzrs().compareTo(BigDecimal.ZERO)!=0){
				AssessWages = AssessWages.divide(infoe.getBzrs(),0,BigDecimal.ROUND_HALF_UP);
				BigDecimal rate = infoe.getBjdw();
				AssessWages = AssessWages.divide(rate,0,BigDecimal.ROUND_HALF_UP);
				AssessWages = AssessWages.multiply(new BigDecimal(infoe.getBlsx())).setScale(0, BigDecimal.ROUND_HALF_UP);
				infoe.setAssesswages(AssessWages);
			}else{
				infoe.setAssesswages(new BigDecimal("0"));
			}
		}
		return info;
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		HatchAssessInfo info = (HatchAssessInfo) model;
		// ��ֹ�ظ���� ���ύ�����
//		if (!info.getStatus().equals(BillBaseStatusEnum.SUBMITED)) {
//			return;
//		}
		try {
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			//info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.kingdee.eas.farm.food.stocount.app.AbstractPcakCountControllerBean#_unaudit(com.kingdee.bos.Context, com.kingdee.bos.dao.IObjectValue)
	 */
	@Override
	protected void _unaudit(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		HatchAssessInfo info = (HatchAssessInfo) model;
		// ����ֹ�ظ����
//		if (!info.getStatus().equals(BillBaseStatusEnum.AUDITED)) {
//			return;
//		}
		try {
			FarmCommUtils.isExitBTPBill(ctx, new ObjectUuidPK(info.getId()), info);
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			 //info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			logger.error(e);
			throw new BOSException(e);
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		HatchAssessInfo info = HatchAssessFactory.getLocalInstance(ctx).getHatchAssessInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":�����Ѿ���ˣ���ֹɾ��"));
		}
		super._delete(ctx, pk);
	}
}