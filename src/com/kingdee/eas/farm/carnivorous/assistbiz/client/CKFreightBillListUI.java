/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.assistbiz.client;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.base.core.util.KDTableUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillFactory;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillInfo;
import com.kingdee.eas.farm.carnivorous.assistbiz.ICKFreightBill;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.sd.sale.OrderException;
import com.kingdee.eas.scm.sd.sale.util.SaleUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * output class name
 */
public class CKFreightBillListUI extends AbstractCKFreightBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(CKFreightBillListUI.class);

	/**
	 * output class constructor
	 */
	public CKFreightBillListUI() throws Exception{
		super();
	}

	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception  {
		checkSelected();
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("�����Ѿ���ˣ���ֹ�޸ģ�");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}


	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{	
		checkSelected();
		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());
		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		selIDs=commUtils.arrayListClearSamevalue(selIDs);
		ICKFreightBill iBill = CKFreightBillFactory.getRemoteInstance();
		CKFreightBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBill.getCKFreightBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
				error+=info.getString("number")+"\t"+"ֻ���ύ״̬�ĵ��ݿ������"+"\n";
				num--;
				continue;
			}
			try{
				iBill.audit(info);
			}catch (Exception e1) {
				// TODO: handle exception
				error+=info.getString("number")+"\t"+e1.getMessage()+"\n";
				num--;
			}
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("��˳ɹ�");
			else if(num==selIDs.length)
				MsgBox.showInfo("��˳ɹ�(����������:"+selIDs.length+")");
			else if(num==0)
				throw new EASBizException(new NumericExceptionSubItem("","���ʧ��!\n"+error));
			else{
				throw new EASBizException(new NumericExceptionSubItem("","������ɵ������쳣������"+num+"�ŵ���������\n"+error));
			}
		} 
		finally{
			refreshList();
		}
	}

	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		checkSelected();
		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());
		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		selIDs=commUtils.arrayListClearSamevalue(selIDs);
		ICKFreightBill iBill = CKFreightBillFactory.getRemoteInstance();
		CKFreightBillInfo info;
		int num=selIDs.length;
		String error="";
		for (int i = 0;i<selIDs.length; i++) {
			info = iBill.getCKFreightBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)){
				error+=info.getString("number")+"\t"+"ֻ�����״̬�ĵ��ݿ��Է����"+"\n";
				num--;
				continue;
			}
			try{
				iBill.unAudit(info);
			}catch (Exception e1) {
				// TODO: handle exception
				error+=info.getString("number")+"\t"+e1.getMessage()+"\n";
				num--;
			}
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("����˳ɹ�");
			else if(num==selIDs.length)
				MsgBox.showInfo("����˳ɹ�(����������:"+selIDs.length+")");
			else if(num==0)
   			throw new EASBizException(new NumericExceptionSubItem("","�����ʧ��!\n"+error));
			else{
				throw new EASBizException(new NumericExceptionSubItem("","������ɵ������쳣������"+num+"�ŵ��ӷ�������\n"+error));
			}
		} 
		finally{
			refreshList();
		}
	}

	public void actionBatchSubmit_actionPerformed(ActionEvent e)
	throws Exception {	
		checkSelected();
		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());
		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		selIDs=commUtils.arrayListClearSamevalue(selIDs);
		ICKFreightBill iBill = CKFreightBillFactory.getRemoteInstance();
		CKFreightBillInfo info;
		int num=selIDs.length;
		String error="";

		for (int i = 0;i<selIDs.length; i++) {
			info = iBill.getCKFreightBillInfo(new ObjectUuidPK(selIDs[i]));
			if(!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)
					&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD)){
				error+=info.getString("number")+"\t"+"ֻ������/����/�ύ״̬�ĵ��ݿ����ύ"+"\n";
				num--;
				continue;
			}
			if(info.getDistance()==null){
				error+=info.getString("number")+"\t"+"δִ�����˷Ѽ���"+"\n";
				num--;
				continue;
			}
			try{
				iBill.submit(info);
			}catch (Exception e1) {
				// TODO: handle exception
				error+=info.getString("number")+"\t"+e1.getMessage()+"\n";
				num--;
			}
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("�ύ�ɹ�");
			else if(num==selIDs.length)
				MsgBox.showInfo("�ύ�ɹ�(����������:"+selIDs.length+")");
			else if(num==0)
			throw new EASBizException(new NumericExceptionSubItem("","�ύʧ��!\n"+error));
			else{
				throw new EASBizException(new NumericExceptionSubItem("","������ɵ������쳣������"+num+"�ŵ����ύ���\n"+error));
			}
		} 
		finally{
			refreshList();
		}
	}
	private void initControl() throws Exception{
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.ActionBatchSubmit.setEnabled(true);
		this.actionCalFreight.setEnabled(true);
		this.tblMain.addKDTSelectListener(new KDTSelectListener(){
			public void tableSelectChanged(KDTSelectEvent e) {
				selectedRowChanged(e.getSelectBlock().getBeginRow());
			}});
	}

	@Override
	public void actionCalFreight_actionPerformed(ActionEvent e)
	throws Exception {
		checkSelected();
		String[] selIDs = KDTableUtil.getSelectRowFieldValue(this.tblMain, getKeyFieldName());
		if (selIDs == null) {
			handleException(new OrderException(OrderException.ORDER_MUSTSELECT_ONERECORD, new String[] { SaleUtil.getUIResource("OPERATOR_AUDIT") }));
			return;
		}
		selIDs=commUtils.arrayListClearSamevalue(selIDs);
		ICKFreightBill iBill = CKFreightBillFactory.getRemoteInstance();
		CKFreightBillInfo info;
		int num=selIDs.length;
		String error="";

		for (int i = 0;i<selIDs.length; i++) {
			info = iBill.getCKFreightBillInfo(new ObjectUuidPK(selIDs[i]));
			if(info.getCalUnit()==null){
				error+=info.getString("number")+"\t"+"�˷Ѽ���㲻��Ϊ��"+"\n";
				num--;
				continue;
			}
			try{
				iBill.calFreight(info);
			}catch (Exception e1) {
				// TODO: handle exception
				error+=info.getString("number")+"\t"+e1.getMessage()+"\n";
				num--;
			}
		}
		try{
			if(num==selIDs.length&&num==1)
				MsgBox.showInfo("����ɹ�");
			else if(num==selIDs.length)
				MsgBox.showInfo("����ɹ�(����������:"+selIDs.length+")");
			else if(num==0)
				throw new EASBizException(new NumericExceptionSubItem("","����ʧ��!\n"+error));
			else{
				throw new EASBizException(new NumericExceptionSubItem("","������ɵ������쳣������"+num+"�ŵ��Ӽ������\n"+error));
			}
		} 
		finally{
			refreshList();
		}
	}

	/**
	 * ��ѡ�� �ı��¼�
	 * @param rowIndex
	 */
	private void selectedRowChanged(int rowIndex) {
		ArrayList list = this.getSelectedFieldValues("billStatus");
		if(list.size()>0) {
			if(list.get(0).equals("���")) {
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(true);
				this.actionEdit.setEnabled(false);
				this.ActionBatchSubmit.setEnabled(false);
			}else if(list.get(0).equals("�ύ")) {
				this.actionAudit.setEnabled(true);
				this.actionUnAudit.setEnabled(false);
				this.actionEdit.setEnabled(true);
				this.ActionBatchSubmit.setEnabled(true);
			}else{
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(false);
				this.actionEdit.setEnabled(true);
				this.ActionBatchSubmit.setEnabled(true);
			}
		}
	}

	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		return super.getDefaultFilterForQuery();
	}

	protected boolean initDefaultFilter() {
		return true;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initControl();
	}



	@Override
	protected CommonQueryDialog initCommonQueryDialog() {
		// TODO Auto-generated method stub
		CommonQueryDialog ds = super.initCommonQueryDialog();
		Date nowDate = new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(sdf.format(nowDate)));
			cal.set(Calendar.DAY_OF_MONTH,1);//����Ϊ1��,��ǰ���ڼ�Ϊ���µ�һ�� 
			Date beginDate = cal.getTime();
			cal.add(Calendar.MONTH,1);//������1�� 
			cal.add(Calendar.DAY_OF_MONTH,-1);//���ڵ���һ��,�ȵõ��������һ�� 
			Date endDate = cal.getTime();
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("bizDate",beginDate,CompareType.GREATER_EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("bizDate",endDate,CompareType.LESS_EQUALS));
			ev.setFilter(filter);
			ds.setDefalutEntityViewInfo(ev);		} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ds;
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillInfo();

		return objectValue;
	}

}