package com.kingdee.eas.custom.salepayment.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.salepayment.SalerStimulateSetFactory;
import com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.util.NumericExceptionSubItem;

public class SalerStimulateSetControllerBean extends AbstractSalerStimulateSetControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.salepayment.app.SalerStimulateSetControllerBean");
    
    

    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
    	SalerStimulateSetInfo billInfo = (SalerStimulateSetInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.NULL.equals(billInfo.getBaseStatus())  || BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) || BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) )){
    		billInfo.setBaseStatus( BillBaseStatusEnum.TEMPORARILYSAVED);
    		
    		return super._save(ctx, model);
    	}else{
//    		throw new BOSException("ֻ�ܱ��������򱣴�״̬�ĵ���");
    		throw  new EASBizException(new NumericExceptionSubItem("001","ֻ�ܱ��������򱣴�״̬�ĵ���"));
    	}
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		SalerStimulateSetInfo billInfo = (SalerStimulateSetInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.NULL.equals(billInfo.getBaseStatus())  || 
    					BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		
		
    		return super._submit(ctx, model);
    	}else{
//    		throw new BOSException("ֻ�ܱ��������򱣴�״̬�ĵ���");
    		throw  new EASBizException(new NumericExceptionSubItem("001","ֻ�ܱ��������򱣴�״̬�ĵ���"));
    	}
	}
	
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		SalerStimulateSetInfo billInfo = SalerStimulateSetFactory.getLocalInstance(ctx).getSalerStimulateSetInfo(pk);
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.NULL.equals(billInfo.getBaseStatus())  || 
    					BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		
    		super._delete(ctx, pk);
    		
    	}else{
//    		throw new BOSException("ֻ��ɾ�������򱣴�״̬�ĵ���");
    		throw  new EASBizException(new NumericExceptionSubItem("001","ֻ��ɾ�������򱣴�״̬�ĵ���"));
    	}
		
	}
	/**
     * ���
     */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		SalerStimulateSetInfo billInfo = (SalerStimulateSetInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new BOSException("�Ѿ��������ε��ݣ��������");
			}
			
			// ���µ���״̬
			AppCommon.updateBaseDataModelStatus(ctx, "CT_SP_SalerStimulateSet", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			
		}else{
			throw new BOSException("ֻ������ύ״̬�ĵ���");
		}
		
	}


	/**
	 * �����
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		
		SalerStimulateSetInfo billInfo = (SalerStimulateSetInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new BOSException("�Ѿ��������ε��ݣ����ܷ����");
			}else{

			}
			
			
			// ���µ���״̬
			AppCommon.updateBaseDataModelStatus(ctx, "CT_SP_SalerStimulateSet", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			
		}else{
			throw new BOSException("ֻ�ܷ�������״̬�ĵ���");
		}
	}
    
    
}