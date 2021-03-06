/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

import org.apache.log4j.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.event.*;
import javax.swing.KeyStroke;

import com.kingdee.bos.ctrl.swing.*;
import com.kingdee.bos.ctrl.kdf.table.*;
import com.kingdee.bos.ctrl.kdf.data.event.*;
import com.kingdee.bos.dao.*;
import com.kingdee.bos.dao.query.*;
import com.kingdee.bos.metadata.*;
import com.kingdee.bos.metadata.entity.*;
import com.kingdee.bos.ui.face.*;
import com.kingdee.bos.ui.util.ResourceBundleHelper;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.enums.EnumUtils;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.swing.event.*;
import com.kingdee.bos.ctrl.kdf.table.event.*;
import com.kingdee.bos.ctrl.extendcontrols.*;
import com.kingdee.bos.ctrl.kdf.util.render.*;
import com.kingdee.bos.ui.face.IItemAction;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.bos.ui.util.IUIActionPostman;
import com.kingdee.bos.appframework.client.servicebinding.ActionProxyFactory;
import com.kingdee.bos.appframework.uistatemanage.ActionStateConst;
import com.kingdee.bos.appframework.validator.ValidateHelper;
import com.kingdee.bos.appframework.uip.UINavigator;


/**
 * output class name
 */
public abstract class AbstractSettingEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSettingEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmac;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweighman;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweighbridge;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnGetMac;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtMaterialEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtMaterialEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contport;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmac;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtweighman;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtweighbridge;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDComboBox port;
    protected com.kingdee.eas.weighbridge.SettingInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractSettingEditUI() throws Exception
    {
        super();
        this.defaultObjectName = "editData";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractSettingEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmac = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweighman = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweighbridge = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnGetMac = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtMaterialEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contport = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtmac = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtweighman = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtweighbridge = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.port = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contmac.setName("contmac");
        this.contweighman.setName("contweighman");
        this.contweighbridge.setName("contweighbridge");
        this.btnGetMac.setName("btnGetMac");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtMaterialEntrys.setName("kdtMaterialEntrys");
        this.contport.setName("contport");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtmac.setName("txtmac");
        this.prmtweighman.setName("prmtweighman");
        this.prmtweighbridge.setName("prmtweighbridge");
        this.prmtstorageOrgUnit.setName("prmtstorageOrgUnit");
        this.port.setName("port");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // contmac		
        this.contmac.setBoundLabelText(resHelper.getString("contmac.boundLabelText"));		
        this.contmac.setBoundLabelLength(100);		
        this.contmac.setBoundLabelUnderline(true);		
        this.contmac.setVisible(true);
        // contweighman		
        this.contweighman.setBoundLabelText(resHelper.getString("contweighman.boundLabelText"));		
        this.contweighman.setBoundLabelLength(100);		
        this.contweighman.setBoundLabelUnderline(true);		
        this.contweighman.setVisible(true);
        // contweighbridge		
        this.contweighbridge.setBoundLabelText(resHelper.getString("contweighbridge.boundLabelText"));		
        this.contweighbridge.setBoundLabelLength(100);		
        this.contweighbridge.setBoundLabelUnderline(true);		
        this.contweighbridge.setVisible(true);
        // btnGetMac		
        this.btnGetMac.setText(resHelper.getString("btnGetMac.text"));
        this.btnGetMac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnGetMac_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"weighBillType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"defaultBizType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"defaultWeighType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"isAuto2Inv\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"range\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{weighBillType}</t:Cell><t:Cell>$Resource{defaultBizType}</t:Cell><t:Cell>$Resource{defaultWeighType}</t:Cell><t:Cell>$Resource{isAuto2Inv}</t:Cell><t:Cell>$Resource{range}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"seq","weighBillType","defaultBizType","defaultWeighType","isAuto2Inv","range"});


        this.kdtEntrys.checkParsed();
        KDFormattedTextField kdtEntrys_seq_TextField = new KDFormattedTextField();
        kdtEntrys_seq_TextField.setName("kdtEntrys_seq_TextField");
        kdtEntrys_seq_TextField.setVisible(true);
        kdtEntrys_seq_TextField.setEditable(true);
        kdtEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seq_TextField);
        this.kdtEntrys.getColumn("seq").setEditor(kdtEntrys_seq_CellEditor);
        KDComboBox kdtEntrys_weighBillType_ComboBox = new KDComboBox();
        kdtEntrys_weighBillType_ComboBox.setName("kdtEntrys_weighBillType_ComboBox");
        kdtEntrys_weighBillType_ComboBox.setVisible(true);
        kdtEntrys_weighBillType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBillType").toArray());
        KDTDefaultCellEditor kdtEntrys_weighBillType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_weighBillType_ComboBox);
        this.kdtEntrys.getColumn("weighBillType").setEditor(kdtEntrys_weighBillType_CellEditor);
        KDComboBox kdtEntrys_defaultBizType_ComboBox = new KDComboBox();
        kdtEntrys_defaultBizType_ComboBox.setName("kdtEntrys_defaultBizType_ComboBox");
        kdtEntrys_defaultBizType_ComboBox.setVisible(true);
        kdtEntrys_defaultBizType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBizType").toArray());
        KDTDefaultCellEditor kdtEntrys_defaultBizType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_defaultBizType_ComboBox);
        this.kdtEntrys.getColumn("defaultBizType").setEditor(kdtEntrys_defaultBizType_CellEditor);
        KDComboBox kdtEntrys_defaultWeighType_ComboBox = new KDComboBox();
        kdtEntrys_defaultWeighType_ComboBox.setName("kdtEntrys_defaultWeighType_ComboBox");
        kdtEntrys_defaultWeighType_ComboBox.setVisible(true);
        kdtEntrys_defaultWeighType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBaseType").toArray());
        KDTDefaultCellEditor kdtEntrys_defaultWeighType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_defaultWeighType_ComboBox);
        this.kdtEntrys.getColumn("defaultWeighType").setEditor(kdtEntrys_defaultWeighType_CellEditor);
        KDCheckBox kdtEntrys_isAuto2Inv_CheckBox = new KDCheckBox();
        kdtEntrys_isAuto2Inv_CheckBox.setName("kdtEntrys_isAuto2Inv_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isAuto2Inv_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isAuto2Inv_CheckBox);
        this.kdtEntrys.getColumn("isAuto2Inv").setEditor(kdtEntrys_isAuto2Inv_CellEditor);
        KDFormattedTextField kdtEntrys_range_TextField = new KDFormattedTextField();
        kdtEntrys_range_TextField.setName("kdtEntrys_range_TextField");
        kdtEntrys_range_TextField.setVisible(true);
        kdtEntrys_range_TextField.setEditable(true);
        kdtEntrys_range_TextField.setHorizontalAlignment(2);
        kdtEntrys_range_TextField.setDataType(1);
        	kdtEntrys_range_TextField.setMinimumValue(new java.math.BigDecimal("-999.99"));
        	kdtEntrys_range_TextField.setMaximumValue(new java.math.BigDecimal("999.99"));
        kdtEntrys_range_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_range_CellEditor = new KDTDefaultCellEditor(kdtEntrys_range_TextField);
        this.kdtEntrys.getColumn("range").setEditor(kdtEntrys_range_CellEditor);
        // kdtMaterialEntrys
		String kdtMaterialEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtMaterialEntrys.setFormatXml(resHelper.translateString("kdtMaterialEntrys",kdtMaterialEntrysStrXML));
        kdtMaterialEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtMaterialEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtMaterialEntrys.putBindContents("editData",new String[] {"MaterialEntrys.seq","MaterialEntrys.material","MaterialEntrys.materialName","MaterialEntrys.model"});


        this.kdtMaterialEntrys.checkParsed();
        KDFormattedTextField kdtMaterialEntrys_seq_TextField = new KDFormattedTextField();
        kdtMaterialEntrys_seq_TextField.setName("kdtMaterialEntrys_seq_TextField");
        kdtMaterialEntrys_seq_TextField.setVisible(true);
        kdtMaterialEntrys_seq_TextField.setEditable(true);
        kdtMaterialEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtMaterialEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtMaterialEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtMaterialEntrys_seq_TextField);
        this.kdtMaterialEntrys.getColumn("seq").setEditor(kdtMaterialEntrys_seq_CellEditor);
        final KDBizPromptBox kdtMaterialEntrys_material_PromptBox = new KDBizPromptBox();
        kdtMaterialEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtMaterialEntrys_material_PromptBox.setVisible(true);
        kdtMaterialEntrys_material_PromptBox.setEditable(true);
        kdtMaterialEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtMaterialEntrys_material_PromptBox.setEditFormat("$number$");
        kdtMaterialEntrys_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtMaterialEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtMaterialEntrys_material_PromptBox);
        this.kdtMaterialEntrys.getColumn("material").setEditor(kdtMaterialEntrys_material_CellEditor);
        ObjectValueRender kdtMaterialEntrys_material_OVR = new ObjectValueRender();
        kdtMaterialEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtMaterialEntrys.getColumn("material").setRenderer(kdtMaterialEntrys_material_OVR);
        KDTextField kdtMaterialEntrys_materialName_TextField = new KDTextField();
        kdtMaterialEntrys_materialName_TextField.setName("kdtMaterialEntrys_materialName_TextField");
        kdtMaterialEntrys_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtMaterialEntrys_materialName_CellEditor = new KDTDefaultCellEditor(kdtMaterialEntrys_materialName_TextField);
        this.kdtMaterialEntrys.getColumn("materialName").setEditor(kdtMaterialEntrys_materialName_CellEditor);
        KDTextField kdtMaterialEntrys_model_TextField = new KDTextField();
        kdtMaterialEntrys_model_TextField.setName("kdtMaterialEntrys_model_TextField");
        kdtMaterialEntrys_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtMaterialEntrys_model_CellEditor = new KDTDefaultCellEditor(kdtMaterialEntrys_model_TextField);
        this.kdtMaterialEntrys.getColumn("model").setEditor(kdtMaterialEntrys_model_CellEditor);
        // contport		
        this.contport.setBoundLabelText(resHelper.getString("contport.boundLabelText"));		
        this.contport.setBoundLabelLength(100);		
        this.contport.setBoundLabelUnderline(true);		
        this.contport.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setVisible(false);
        // txtName		
        this.txtName.setVisible(false);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setVisible(false);
        // txtDescription
        // txtmac		
        this.txtmac.setHorizontalAlignment(2);		
        this.txtmac.setMaxLength(100);		
        this.txtmac.setRequired(true);
        // prmtweighman		
        this.prmtweighman.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtweighman.setEditable(true);		
        this.prmtweighman.setDisplayFormat("$name$");		
        this.prmtweighman.setEditFormat("$number$");		
        this.prmtweighman.setCommitFormat("$number$");		
        this.prmtweighman.setRequired(false);
        // prmtweighbridge		
        this.prmtweighbridge.setQueryInfo("com.kingdee.eas.weighbridge.app.WeighBridgeQuery");		
        this.prmtweighbridge.setEditable(true);		
        this.prmtweighbridge.setDisplayFormat("$name$");		
        this.prmtweighbridge.setEditFormat("$number$");		
        this.prmtweighbridge.setCommitFormat("$number$");		
        this.prmtweighbridge.setRequired(true);
        		prmtweighbridge.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.weighbridge.client.WeighBridgeListUI prmtweighbridge_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtweighbridge_F7ListUI == null) {
					try {
						prmtweighbridge_F7ListUI = new com.kingdee.eas.weighbridge.client.WeighBridgeListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtweighbridge_F7ListUI));
					prmtweighbridge_F7ListUI.setF7Use(true,ctx);
					prmtweighbridge.setSelector(prmtweighbridge_F7ListUI);
				}
			}
		});
					
        // prmtstorageOrgUnit		
        this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrgUnit.setEditable(true);		
        this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtstorageOrgUnit.setEditFormat("$number$");		
        this.prmtstorageOrgUnit.setCommitFormat("$number$");		
        this.prmtstorageOrgUnit.setRequired(true);
        // port		
        this.port.setVisible(true);		
        this.port.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.PortNum").toArray());		
        this.port.setRequired(true);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kdtMaterialEntrys,txtName,txtNumber,txtDescription,txtSimpleName,txtmac,prmtweighman,prmtweighbridge,prmtstorageOrgUnit,kdtEntrys,port}));
        this.setFocusCycleRoot(true);
		//Register control's property binding
		registerBindings();
		registerUIState();


    }

	public com.kingdee.bos.ctrl.swing.KDToolBar[] getUIMultiToolBar(){
		java.util.List list = new java.util.ArrayList();
		com.kingdee.bos.ctrl.swing.KDToolBar[] bars = super.getUIMultiToolBar();
		if (bars != null) {
			list.addAll(java.util.Arrays.asList(bars));
		}
		return (com.kingdee.bos.ctrl.swing.KDToolBar[])list.toArray(new com.kingdee.bos.ctrl.swing.KDToolBar[list.size()]);
	}




    /**
     * output initUIContentLayout method
     */
    public void initUIContentLayout()
    {
        this.setBounds(new Rectangle(0, 0, 597, 398));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(611, 73, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(611, 110, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(611, 147, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(18, 119, 270, 19));
        this.add(kDLabelContainer4, null);
        contmac.setBounds(new Rectangle(18, 77, 234, 19));
        this.add(contmac, null);
        contweighman.setBounds(new Rectangle(306, 36, 270, 19));
        this.add(contweighman, null);
        contweighbridge.setBounds(new Rectangle(306, 77, 270, 19));
        this.add(contweighbridge, null);
        btnGetMac.setBounds(new Rectangle(253, 77, 35, 19));
        this.add(btnGetMac, null);
        contstorageOrgUnit.setBounds(new Rectangle(18, 36, 270, 19));
        this.add(contstorageOrgUnit, null);
        kdtEntrys.setBounds(new Rectangle(17, 158, 556, 98));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.weighbridge.SettingEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, null);
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("weighBillType","1");
vo.put("defaultBizType","1");
vo.put("defaultWeighType","1");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        kdtMaterialEntrys.setBounds(new Rectangle(17, 266, 556, 111));
        kdtMaterialEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtMaterialEntrys,new com.kingdee.eas.weighbridge.SettingEntryMaterialEntryInfo(),null,false);
        this.add(kdtMaterialEntrys_detailPanel, null);
        contport.setBounds(new Rectangle(306, 119, 270, 19));
        this.add(contport, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contmac
        contmac.setBoundEditor(txtmac);
        //contweighman
        contweighman.setBoundEditor(prmtweighman);
        //contweighbridge
        contweighbridge.setBoundEditor(prmtweighbridge);
        //contstorageOrgUnit
        contstorageOrgUnit.setBoundEditor(prmtstorageOrgUnit);
        //contport
        contport.setBoundEditor(port);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {
        this.menuBar.add(menuFile);
        this.menuBar.add(menuEdit);
        this.menuBar.add(MenuService);
        this.menuBar.add(menuView);
        this.menuBar.add(menuBiz);
        this.menuBar.add(menuTool);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(kDSeparator1);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(menuItemSubmit);
        menuFile.add(menuItemCloudShare);
        menuFile.add(menuSubmitOption);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(rMenuItemSubmit);
        menuFile.add(rMenuItemSubmitAndAddNew);
        menuFile.add(rMenuItemSubmitAndPrint);
        menuFile.add(separatorFile1);
        menuFile.add(MenuItemAttachment);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemPageSetup);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator3);
        menuFile.add(menuItemExitCurrent);
        //menuSubmitOption
        menuSubmitOption.add(chkMenuItemSubmitAndAddNew);
        menuSubmitOption.add(chkMenuItemSubmitAndPrint);
        //menuEdit
        menuEdit.add(menuItemCopy);
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(kDSeparator4);
        menuEdit.add(menuItemReset);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemFirst);
        menuView.add(menuItemPre);
        menuView.add(menuItemNext);
        menuView.add(menuItemLast);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        //menuTool
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuHelp
        menuHelp.add(menuItemHelp);
        menuHelp.add(kDSeparator12);
        menuHelp.add(menuItemRegPro);
        menuHelp.add(menuItemPersonalSite);
        menuHelp.add(helpseparatorDiv);
        menuHelp.add(menuitemProductval);
        menuHelp.add(kDSeparatorProduct);
        menuHelp.add(menuItemAbout);

    }

    /**
     * output initUIToolBarLayout method
     */
    public void initUIToolBarLayout()
    {
        this.toolBar.add(btnAddNew);
        this.toolBar.add(btnCloud);
        this.toolBar.add(btnEdit);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnReset);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnSave);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnFirst);
        this.toolBar.add(btnPre);
        this.toolBar.add(btnNext);
        this.toolBar.add(btnLast);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("Entrys.seq", int.class, this.kdtEntrys, "seq.text");
		dataBinder.registerBinding("Entrys", com.kingdee.eas.weighbridge.SettingEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("Entrys.weighBillType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "weighBillType.text");
		dataBinder.registerBinding("Entrys.defaultBizType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "defaultBizType.text");
		dataBinder.registerBinding("Entrys.defaultWeighType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "defaultWeighType.text");
		dataBinder.registerBinding("Entrys.isAuto2Inv", boolean.class, this.kdtEntrys, "isAuto2Inv.text");
		dataBinder.registerBinding("Entrys.range", java.math.BigDecimal.class, this.kdtEntrys, "range.text");
		dataBinder.registerBinding("Entrys.MaterialEntrys.seq", int.class, this.kdtMaterialEntrys, "seq.text");
		dataBinder.registerBinding("Entrys.MaterialEntrys", com.kingdee.eas.weighbridge.SettingEntryMaterialEntryInfo.class, this.kdtMaterialEntrys, "userObject");
		dataBinder.registerBinding("Entrys.MaterialEntrys.material", java.lang.Object.class, this.kdtMaterialEntrys, "material.text");
		dataBinder.registerBinding("Entrys.MaterialEntrys.materialName", String.class, this.kdtMaterialEntrys, "materialName.text");
		dataBinder.registerBinding("Entrys.MaterialEntrys.model", String.class, this.kdtMaterialEntrys, "model.text");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("mac", String.class, this.txtmac, "text");
		dataBinder.registerBinding("weighman", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtweighman, "data");
		dataBinder.registerBinding("weighbridge", com.kingdee.eas.weighbridge.WeighBridgeInfo.class, this.prmtweighbridge, "data");
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrgUnit, "data");
		dataBinder.registerBinding("port", com.kingdee.eas.weighbridge.PortNum.class, this.port, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtSimpleName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtSimpleName, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtDescription, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtSimpleName, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.weighbridge.app.SettingEditUIHandler";
	}
	public IUIActionPostman prepareInit() {
		IUIActionPostman clientHanlder = super.prepareInit();
		if (clientHanlder != null) {
			RequestContext request = new RequestContext();
    		request.setClassName(getUIHandlerClassName());
			clientHanlder.setRequestContext(request);
		}
		return clientHanlder;
    }
	
	public boolean isPrepareInit() {
    	return false;
    }
    protected void initUIP() {
        super.initUIP();
    }


    /**
     * output onShow method
     */
    public void onShow() throws Exception
    {
        super.onShow();
        this.kdtMaterialEntrys.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.weighbridge.SettingInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"NONE",editData.getString("number"));
    }
    
    protected void recycleNumberByOrg(IObjectValue editData,String orgType,String number) {
        if (!StringUtils.isEmpty(number))
        {
            try {
            	String companyID = null;            
            	com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID =com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}				
				if (!StringUtils.isEmpty(companyID) && iCodingRuleManager.isExist(editData, companyID) && iCodingRuleManager.isUseIntermitNumber(editData, companyID)) {
					iCodingRuleManager.recycleNumber(editData,companyID,number);					
				}
            }
            catch (Exception e)
            {
                handUIException(e);
            }
        }
    }
    protected void setAutoNumberByOrg(String orgType) {
    	if (editData == null) return;
		if (editData.getNumber() == null) {
            try {
            	String companyID = null;
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}
				com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
		        if (iCodingRuleManager.isExist(editData, companyID)) {
		            if (iCodingRuleManager.isAddView(editData, companyID)) {
		            	editData.setNumber(iCodingRuleManager.getNumber(editData,companyID));
		            }
	                txtNumber.setEnabled(false);
		        }
            }
            catch (Exception e) {
                handUIException(e);
                this.oldData = editData;
                com.kingdee.eas.util.SysUtil.abort();
            } 
        } 
        else {
            if (editData.getNumber().trim().length() > 0) {
                txtNumber.setText(editData.getNumber());
            }
        }
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("NONE");
        dataBinder.loadFields();
    }
		protected void setOrgF7(KDBizPromptBox f7,com.kingdee.eas.basedata.org.OrgType orgType) throws Exception
		{
			com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer oufip = new com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer(orgType);
			oufip.getModel().setIsCUFilter(true);
			f7.setFilterInfoProducer(oufip);
		}

    /**
     * output storeFields method
     */
    public void storeFields()
    {
		dataBinder.storeFields();
    }

	/**
	 * ????????У??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("Entrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.weighBillType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.defaultBizType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.defaultWeighType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.isAuto2Inv", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.range", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.MaterialEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.MaterialEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.MaterialEntrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.MaterialEntrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.MaterialEntrys.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mac", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weighman", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weighbridge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("port", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtDescription.setEnabled(false);
		            this.txtNumber.setEnabled(false);
		            this.txtSimpleName.setEnabled(false);
        }
    }

    /**
     * output btnGetMac_actionPerformed method
     */
    protected void btnGetMac_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output kdtMaterialEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtMaterialEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtMaterialEntrys.getColumn(colIndex).getKey())) {
kdtMaterialEntrys.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtMaterialEntrys.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtMaterialEntrys.getColumn(colIndex).getKey())) {
kdtMaterialEntrys.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtMaterialEntrys.getCell(rowIndex,"material").getValue(),"model")));

}


    }
    /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
		String selectorAll = System.getProperty("selector.all");
		if(StringUtils.isEmpty(selectorAll)){
			selectorAll = "true";
		}
    	sic.add(new SelectorItemInfo("Entrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Entrys.weighBillType"));
    	sic.add(new SelectorItemInfo("Entrys.defaultBizType"));
    	sic.add(new SelectorItemInfo("Entrys.defaultWeighType"));
    	sic.add(new SelectorItemInfo("Entrys.isAuto2Inv"));
    	sic.add(new SelectorItemInfo("Entrys.range"));
    	sic.add(new SelectorItemInfo("Entrys.MaterialEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.MaterialEntrys.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entrys.MaterialEntrys.id"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.MaterialEntrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entrys.MaterialEntrys.material.id"));
			sic.add(new SelectorItemInfo("Entrys.MaterialEntrys.material.number"));
			sic.add(new SelectorItemInfo("Entrys.MaterialEntrys.material.name"));
		}
    	sic.add(new SelectorItemInfo("Entrys.MaterialEntrys.materialName"));
    	sic.add(new SelectorItemInfo("Entrys.MaterialEntrys.model"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("mac"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("weighman.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("weighman.id"));
        	sic.add(new SelectorItemInfo("weighman.number"));
        	sic.add(new SelectorItemInfo("weighman.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("weighbridge.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("weighbridge.id"));
        	sic.add(new SelectorItemInfo("weighbridge.number"));
        	sic.add(new SelectorItemInfo("weighbridge.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("port"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.weighbridge.client", "SettingEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.weighbridge.client.SettingEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.weighbridge.SettingFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.weighbridge.SettingInfo objectValue = new com.kingdee.eas.weighbridge.SettingInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"weighBillType").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据类型"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"defaultBizType").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"默认业务类型"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"defaultWeighType").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"默认称重方式"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtmac.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"本机MAC地址"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtweighbridge.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"磅秤"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstorageOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"库存组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(port.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"端口"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntrys;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("port","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}