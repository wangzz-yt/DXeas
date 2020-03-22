package com.kingdee.eas.custom.commld;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Rectangle;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.appframework.syncUI.MonitorInfo;
import com.kingdee.bos.appframework.syncUI.SwingWorker;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.reportone.r1.form.engine.x.util.SwingUtil;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDTextField;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.IUIObject;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.eas.base.uiframe.client.NewMainFrame;
import com.kingdee.eas.base.uiframe.client.UIFactoryHelper;
import com.kingdee.eas.base.uiframe.client.ui.IMainUIObject;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.framework.client.EditUI;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.framework.report.util.WindowMessage;
import java.lang.reflect.Method;

public class UIUtil {
	private Map uiContext;
	protected void addTabOnMainUI(IUIObject object) {
		IMainUIObject mainUI = getMainUIObject();
		IUIObject[] uiObjects = mainUI.getUiManager().findUIObject(getUIFullName());
		if ((uiObjects != null) && (uiObjects.length > 0)) {
			mainUI.getUiManager().changeTab(uiObjects[0]);
		} else {
			mainUI.getUiManager().addTab(object);
			mainUI.getUiManager().changeTab(object);
		}
	}
	protected IMainUIObject getMainUIObject()
	{
		IMainUIObject mainUI = null;
		try {
			Frame frame = UIFactoryHelper.getMainFrame(getUIContext());
			if (frame instanceof NewMainFrame)
				mainUI = ((NewMainFrame)frame).getMainUI();
			else
				mainUI = UIFactoryHelper.getMainUIObject(getUIContext());
		}
		catch (UIException e) {
			//handleException(e);
		}
		return mainUI;
	}
	public Map getUIContext() {
		return this.uiContext;
	}
	public void setUIContext(Map uiContext) {
		this.uiContext = uiContext;
	}

	protected String getUIFullName() {
		return null;
	}

	protected void removeTabOnMainUI() {
		IMainUIObject mainUI = getMainUIObject();
		IUIObject[] uiObjects = mainUI.getUiManager().findUIObject(getUIFullName());
		if ((uiObjects != null) && (uiObjects.length > 0))
			mainUI.getUiManager().removeTab(uiObjects[0]);
	}
	/**
	 * 右下角弹框
	 */
	private void  showWindowMsg() {
		MonitorInfo monitorInfo=new MonitorInfo("测试",null,this,false);
		SwingWorker worker=null;
		monitorInfo.setWorker(worker);
		WindowMessage windowMessage = new WindowMessage("250", "150", "title", MessageFormat.format("已经完成", new Object[] {"title"}) ,monitorInfo);
		windowMessage.show();
	}
	/**
	 * 在表格上方增加按钮
	 * @param btn
	 * @param table
	 */
	public static void addDetailButton(KDWorkButton btn,KDTable table) {
		JPanel controlPanel = (JPanel) table.getParent().getParent();
		if(controlPanel instanceof DetailPanel ){
			for(int index=0;index<controlPanel.getComponentCount();index++) {
				if(controlPanel.getComponent(index).getName().equalsIgnoreCase("controlPanel")) {
					JPanel  d = (JPanel )controlPanel.getComponent(index);
					Rectangle rect = table.getBounds();
					int x = rect.width - (btn.getWidth() + 86 + 5);
					d.add(btn,new com.kingdee.bos.ctrl.swing.KDLayout.Constraints(x, 5, btn.getWidth(), 19, 9));
					break;
				}
			}
		}
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
			sumValue.put(fields[i], new BigDecimal("0.00"));  
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
		String colFormat = "%{0.00}f";  

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
					||table.getColumn(j).getKey().toLowerCase().contains("amt"))
				columnName.add(table.getColumn(j).getKey());
		apendFootRow(table, columnName.toArray(new String[columnName.size()]));
	}
	/**
	 * 表格设置字段显示方向
	 * @param table
	 * @param siplayFormat
	 */
	public static void setQualityPhaseDisplayFormat(KDTable table[],HorizontalAlignment HorizontalAlignment){

		ArrayList<String> columnName=new ArrayList<String>();
		for(int i=0;i<table.length;i++){
			columnName.clear();
			for(int j=0;j<table[i].getColumnCount();j++)
				if(table[i].getColumn(j).getKey().toLowerCase().contains("qty")
						||table[i].getColumn(j).getKey().toLowerCase().contains("amount")
						||table[i].getColumn(j).getKey().toLowerCase().contains("amt")
						||table[i].getColumn(j).getKey().toLowerCase().contains("price")
						||table[i].getColumn(j).getKey().toLowerCase().contains("cost")
						||table[i].getColumn(j).getKey().toLowerCase().contains("wgt")
						||table[i].getColumn(j).getKey().toLowerCase().contains("weight")
						)
					table[i].getColumn(j).getStyleAttributes().setHorizontalAlign(HorizontalAlignment);
		}
	}


	/**
	 * 表格设置字段显示方向
	 * @param table
	 * @param siplayFormat
	 */
	public static void setQualityPhaseDisplayFormat(KDTable table[],String [] fields,HorizontalAlignment HorizontalAlignment){

		for(int i=0;i<table.length;i++){
			for(int j=0;j<fields.length;j++)
				table[i].getColumn(fields[j]).getStyleAttributes().setHorizontalAlign(HorizontalAlignment);
		}
	}

	/**
	 * 表格设置字段显示方向--默认居右
	 * @param table
	 * @param siplayFormat
	 * KDTextField
	 */
	public static void setQualityPhaseDisplayFormat(KDTextField [] textFieldArray,int diplayFormat){
		for(int i=0;i<textFieldArray.length;i++)
			textFieldArray[i].setHorizontalAlignment((diplayFormat<0||diplayFormat>13)?SwingConstants.RIGHT:diplayFormat);

	}
	/**
	 * 表格设置字段显示方向--默认居右
	 * @param table
	 * @param siplayFormat
	 * KDFormattedTextField
	 */
	public static void setQualityPhaseDisplayFormat(KDFormattedTextField [] textFieldArray,int diplayFormat){
		for(int i=0;i<textFieldArray.length;i++)
			textFieldArray[i].setHorizontalAlignment((diplayFormat<0||diplayFormat>13)?SwingConstants.RIGHT:diplayFormat);

	}

	/**
	 * 设置字段显示方向--默认居右
	 * @param table
	 * @param siplayFormat
	 */
	public static void setQualityPhaseDisplayFormat(KDTable table[]){
		setQualityPhaseDisplayFormat(table,HorizontalAlignment.RIGHT);
	}

	/**
	 * 刷新界面通用版
	 * @param coreBillEditUI
	 * @throws EASBizException
	 * @throws BOSException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static void refreshEditUI(com.kingdee.eas.framework.client.CoreBillEditUI coreBillEditUI) throws EASBizException, BOSException, Exception {
		CoreBillBaseInfo billInfo = coreBillEditUI.getEditData();
		if (billInfo.getId() != null) {
			com.kingdee.bos.dao.IObjectPK iObjectPk = new ObjectUuidPK(billInfo.getId());
			Method m = null;    
			Class clazz=coreBillEditUI.getClass();    
			while(true){    
				try {    
					m=clazz.getDeclaredMethod("getValue", new Class[]{IObjectPK.class});    
					break;    
				} catch (NoSuchMethodException e) {    
					clazz=clazz.getSuperclass();    
				}    
			}    
			m.setAccessible(true);    
			IObjectValue iObjectValue=(IObjectValue) m.invoke(coreBillEditUI, new Object[]{iObjectPk});   
			coreBillEditUI.setDataObject(iObjectValue);
			coreBillEditUI.loadFields();
			coreBillEditUI.setSave(true);
		}
	}
}
