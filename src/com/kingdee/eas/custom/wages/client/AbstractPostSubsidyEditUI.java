/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

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
public abstract class AbstractPostSubsidyEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlCoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPostSubsidyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDButton importPerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.eas.custom.wages.PostSubsidyInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractPostSubsidyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPostSubsidyEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.importPerson = new com.kingdee.bos.ctrl.swing.KDButton();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contcompany.setName("contcompany");
        this.kdtEntry.setName("kdtEntry");
        this.importPerson.setName("importPerson");
        this.prmtcompany.setName("prmtcompany");
        // CoreUI		
        this.btnTraceUp.setVisible(false);		
        this.btnTraceDown.setVisible(false);		
        this.btnCreateTo.setVisible(true);		
        this.btnAddLine.setVisible(false);		
        this.btnCopyLine.setVisible(false);		
        this.btnInsertLine.setVisible(false);		
        this.btnRemoveLine.setVisible(false);		
        this.btnAuditResult.setVisible(false);		
        this.separator1.setVisible(false);		
        this.menuItemCreateTo.setVisible(true);		
        this.separator3.setVisible(false);		
        this.menuItemTraceUp.setVisible(false);		
        this.menuItemTraceDown.setVisible(false);		
        this.menuTable1.setVisible(false);		
        this.menuItemAddLine.setVisible(false);		
        this.menuItemCopyLine.setVisible(false);		
        this.menuItemInsertLine.setVisible(false);		
        this.menuItemRemoveLine.setVisible(false);		
        this.menuItemViewSubmitProccess.setVisible(false);		
        this.menuItemViewDoProccess.setVisible(false);		
        this.menuItemAuditResult.setVisible(false);		
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(true);		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(true);		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.prmtCreator.setEnabled(false);		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.txtNumber.setMaxLength(80);		
        this.pkBizDate.setEnabled(true);		
        this.txtDescription.setMaxLength(80);		
        this.prmtAuditor.setEnabled(false);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:Protection hidden=\"true\" /><c:NumberFormat>yyyy-MM</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection hidden=\"true\" /><c:NumberFormat>yyyy-MM</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"person\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"personName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"psersonpost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"startMonthN\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"endMonthN\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"AlreadyMonthN\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"allMonth\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"allMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"AlreadyMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"postWages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"startMonth\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"endMonth\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"AlreadyMonth\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{person}</t:Cell><t:Cell>$Resource{personName}</t:Cell><t:Cell>$Resource{psersonpost}</t:Cell><t:Cell>$Resource{startMonthN}</t:Cell><t:Cell>$Resource{endMonthN}</t:Cell><t:Cell>$Resource{AlreadyMonthN}</t:Cell><t:Cell>$Resource{allMonth}</t:Cell><t:Cell>$Resource{allMoney}</t:Cell><t:Cell>$Resource{AlreadyMoney}</t:Cell><t:Cell>$Resource{postWages}</t:Cell><t:Cell>$Resource{startMonth}</t:Cell><t:Cell>$Resource{endMonth}</t:Cell><t:Cell>$Resource{AlreadyMonth}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));
        kdtEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEntry.putBindContents("editData",new String[] {"seq","person","personName","psersonpost","startMonthN","endMonthN","AlreadyMonthN","allMonth","allMoney","AlreadyMoney","postWages","startMonth","endMonth","AlreadyMonth"});


        this.kdtEntry.checkParsed();
        KDFormattedTextField kdtEntry_seq_TextField = new KDFormattedTextField();
        kdtEntry_seq_TextField.setName("kdtEntry_seq_TextField");
        kdtEntry_seq_TextField.setVisible(true);
        kdtEntry_seq_TextField.setEditable(true);
        kdtEntry_seq_TextField.setHorizontalAlignment(2);
        kdtEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtEntry_seq_TextField);
        this.kdtEntry.getColumn("seq").setEditor(kdtEntry_seq_CellEditor);
        final KDBizPromptBox kdtEntry_person_PromptBox = new KDBizPromptBox();
        kdtEntry_person_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtEntry_person_PromptBox.setVisible(true);
        kdtEntry_person_PromptBox.setEditable(true);
        kdtEntry_person_PromptBox.setDisplayFormat("$number$");
        kdtEntry_person_PromptBox.setEditFormat("$number$");
        kdtEntry_person_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_person_CellEditor = new KDTDefaultCellEditor(kdtEntry_person_PromptBox);
        this.kdtEntry.getColumn("person").setEditor(kdtEntry_person_CellEditor);
        ObjectValueRender kdtEntry_person_OVR = new ObjectValueRender();
        kdtEntry_person_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntry.getColumn("person").setRenderer(kdtEntry_person_OVR);
        KDTextField kdtEntry_personName_TextField = new KDTextField();
        kdtEntry_personName_TextField.setName("kdtEntry_personName_TextField");
        kdtEntry_personName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_personName_CellEditor = new KDTDefaultCellEditor(kdtEntry_personName_TextField);
        this.kdtEntry.getColumn("personName").setEditor(kdtEntry_personName_CellEditor);
        final KDBizPromptBox kdtEntry_psersonpost_PromptBox = new KDBizPromptBox();
        kdtEntry_psersonpost_PromptBox.setQueryInfo("com.kingdee.eas.custom.wages.app.BasicPostQuery");
        kdtEntry_psersonpost_PromptBox.setVisible(true);
        kdtEntry_psersonpost_PromptBox.setEditable(true);
        kdtEntry_psersonpost_PromptBox.setDisplayFormat("$number$");
        kdtEntry_psersonpost_PromptBox.setEditFormat("$number$");
        kdtEntry_psersonpost_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_psersonpost_CellEditor = new KDTDefaultCellEditor(kdtEntry_psersonpost_PromptBox);
        this.kdtEntry.getColumn("psersonpost").setEditor(kdtEntry_psersonpost_CellEditor);
        ObjectValueRender kdtEntry_psersonpost_OVR = new ObjectValueRender();
        kdtEntry_psersonpost_OVR.setFormat(new BizDataFormat("$postname$"));
        this.kdtEntry.getColumn("psersonpost").setRenderer(kdtEntry_psersonpost_OVR);
        KDTextField kdtEntry_startMonthN_TextField = new KDTextField();
        kdtEntry_startMonthN_TextField.setName("kdtEntry_startMonthN_TextField");
        kdtEntry_startMonthN_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_startMonthN_CellEditor = new KDTDefaultCellEditor(kdtEntry_startMonthN_TextField);
        this.kdtEntry.getColumn("startMonthN").setEditor(kdtEntry_startMonthN_CellEditor);
        KDTextField kdtEntry_endMonthN_TextField = new KDTextField();
        kdtEntry_endMonthN_TextField.setName("kdtEntry_endMonthN_TextField");
        kdtEntry_endMonthN_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_endMonthN_CellEditor = new KDTDefaultCellEditor(kdtEntry_endMonthN_TextField);
        this.kdtEntry.getColumn("endMonthN").setEditor(kdtEntry_endMonthN_CellEditor);
        KDTextField kdtEntry_AlreadyMonthN_TextField = new KDTextField();
        kdtEntry_AlreadyMonthN_TextField.setName("kdtEntry_AlreadyMonthN_TextField");
        kdtEntry_AlreadyMonthN_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_AlreadyMonthN_CellEditor = new KDTDefaultCellEditor(kdtEntry_AlreadyMonthN_TextField);
        this.kdtEntry.getColumn("AlreadyMonthN").setEditor(kdtEntry_AlreadyMonthN_CellEditor);
        KDFormattedTextField kdtEntry_allMonth_TextField = new KDFormattedTextField();
        kdtEntry_allMonth_TextField.setName("kdtEntry_allMonth_TextField");
        kdtEntry_allMonth_TextField.setVisible(true);
        kdtEntry_allMonth_TextField.setEditable(true);
        kdtEntry_allMonth_TextField.setHorizontalAlignment(2);
        kdtEntry_allMonth_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_allMonth_CellEditor = new KDTDefaultCellEditor(kdtEntry_allMonth_TextField);
        this.kdtEntry.getColumn("allMonth").setEditor(kdtEntry_allMonth_CellEditor);
        KDFormattedTextField kdtEntry_allMoney_TextField = new KDFormattedTextField();
        kdtEntry_allMoney_TextField.setName("kdtEntry_allMoney_TextField");
        kdtEntry_allMoney_TextField.setVisible(true);
        kdtEntry_allMoney_TextField.setEditable(true);
        kdtEntry_allMoney_TextField.setHorizontalAlignment(2);
        kdtEntry_allMoney_TextField.setDataType(1);
        	kdtEntry_allMoney_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_allMoney_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_allMoney_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_allMoney_CellEditor = new KDTDefaultCellEditor(kdtEntry_allMoney_TextField);
        this.kdtEntry.getColumn("allMoney").setEditor(kdtEntry_allMoney_CellEditor);
        KDFormattedTextField kdtEntry_AlreadyMoney_TextField = new KDFormattedTextField();
        kdtEntry_AlreadyMoney_TextField.setName("kdtEntry_AlreadyMoney_TextField");
        kdtEntry_AlreadyMoney_TextField.setVisible(true);
        kdtEntry_AlreadyMoney_TextField.setEditable(true);
        kdtEntry_AlreadyMoney_TextField.setHorizontalAlignment(2);
        kdtEntry_AlreadyMoney_TextField.setDataType(1);
        	kdtEntry_AlreadyMoney_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_AlreadyMoney_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_AlreadyMoney_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_AlreadyMoney_CellEditor = new KDTDefaultCellEditor(kdtEntry_AlreadyMoney_TextField);
        this.kdtEntry.getColumn("AlreadyMoney").setEditor(kdtEntry_AlreadyMoney_CellEditor);
        KDFormattedTextField kdtEntry_postWages_TextField = new KDFormattedTextField();
        kdtEntry_postWages_TextField.setName("kdtEntry_postWages_TextField");
        kdtEntry_postWages_TextField.setVisible(true);
        kdtEntry_postWages_TextField.setEditable(true);
        kdtEntry_postWages_TextField.setHorizontalAlignment(2);
        kdtEntry_postWages_TextField.setDataType(1);
        	kdtEntry_postWages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_postWages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_postWages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_postWages_CellEditor = new KDTDefaultCellEditor(kdtEntry_postWages_TextField);
        this.kdtEntry.getColumn("postWages").setEditor(kdtEntry_postWages_CellEditor);
        KDDatePicker kdtEntry_startMonth_DatePicker = new KDDatePicker();
        kdtEntry_startMonth_DatePicker.setName("kdtEntry_startMonth_DatePicker");
        kdtEntry_startMonth_DatePicker.setVisible(true);
        kdtEntry_startMonth_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntry_startMonth_CellEditor = new KDTDefaultCellEditor(kdtEntry_startMonth_DatePicker);
        this.kdtEntry.getColumn("startMonth").setEditor(kdtEntry_startMonth_CellEditor);
        KDDatePicker kdtEntry_endMonth_DatePicker = new KDDatePicker();
        kdtEntry_endMonth_DatePicker.setName("kdtEntry_endMonth_DatePicker");
        kdtEntry_endMonth_DatePicker.setVisible(true);
        kdtEntry_endMonth_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntry_endMonth_CellEditor = new KDTDefaultCellEditor(kdtEntry_endMonth_DatePicker);
        this.kdtEntry.getColumn("endMonth").setEditor(kdtEntry_endMonth_CellEditor);
        KDFormattedTextField kdtEntry_AlreadyMonth_TextField = new KDFormattedTextField();
        kdtEntry_AlreadyMonth_TextField.setName("kdtEntry_AlreadyMonth_TextField");
        kdtEntry_AlreadyMonth_TextField.setVisible(true);
        kdtEntry_AlreadyMonth_TextField.setEditable(true);
        kdtEntry_AlreadyMonth_TextField.setHorizontalAlignment(2);
        kdtEntry_AlreadyMonth_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_AlreadyMonth_CellEditor = new KDTDefaultCellEditor(kdtEntry_AlreadyMonth_TextField);
        this.kdtEntry.getColumn("AlreadyMonth").setEditor(kdtEntry_AlreadyMonth_CellEditor);
        // importPerson		
        this.importPerson.setText(resHelper.getString("importPerson.text"));
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkauditTime,billStatus,prmtcompany,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,kdtEntry}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 629));
        contCreator.setBounds(new Rectangle(370, 548, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(370, 548, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(370, 581, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(370, 581, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(717, 548, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(717, 548, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(717, 581, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(717, 581, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(23, 19, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(23, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(370, 19, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(370, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(717, 51, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(717, 51, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(23, 548, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(23, 548, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(23, 581, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(23, 581, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(717, 19, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(717, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(23, 51, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(23, 51, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntry.setBounds(new Rectangle(22, 117, 962, 396));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.custom.wages.PostSubsidyEntryInfo(),null,false);
        this.add(kdtEntry_detailPanel, new KDLayout.Constraints(22, 117, 962, 396, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        importPerson.setBounds(new Rectangle(874, 82, 110, 21));
        this.add(importPerson, new KDLayout.Constraints(874, 82, 110, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //contCreateTime
        contCreateTime.setBoundEditor(kDDateCreateTime);
        //contLastUpdateUser
        contLastUpdateUser.setBoundEditor(prmtLastUpdateUser);
        //contLastUpdateTime
        contLastUpdateTime.setBoundEditor(kDDateLastUpdateTime);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);

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
        this.menuBar.add(menuTable1);
        this.menuBar.add(menuTool);
        this.menuBar.add(menuWorkflow);
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
        menuFile.add(kDSeparator6);
        menuFile.add(menuItemSendMail);
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
        menuEdit.add(separator1);
        menuEdit.add(menuItemCreateFrom);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(menuItemCopyFrom);
        menuEdit.add(separatorEdit1);
        menuEdit.add(menuItemEnterToNextRow);
        menuEdit.add(separator2);
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
        menuView.add(separator3);
        menuView.add(menuItemTraceUp);
        menuView.add(menuItemTraceDown);
        menuView.add(kDSeparator7);
        menuView.add(menuItemLocate);
        //menuBiz
        menuBiz.add(mBtnAudit);
        menuBiz.add(mBtnUnAudit);
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
        //menuTable1
        menuTable1.add(menuItemAddLine);
        menuTable1.add(menuItemCopyLine);
        menuTable1.add(menuItemInsertLine);
        menuTable1.add(menuItemRemoveLine);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuWorkflow
        menuWorkflow.add(menuItemStartWorkFlow);
        menuWorkflow.add(separatorWF1);
        menuWorkflow.add(menuItemViewSubmitProccess);
        menuWorkflow.add(menuItemViewDoProccess);
        menuWorkflow.add(MenuItemWFG);
        menuWorkflow.add(menuItemWorkFlowList);
        menuWorkflow.add(separatorWF2);
        menuWorkflow.add(menuItemMultiapprove);
        menuWorkflow.add(menuItemNextPerson);
        menuWorkflow.add(menuItemAuditResult);
        menuWorkflow.add(kDSeparator5);
        menuWorkflow.add(kDMenuItemSendMessage);
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
        this.toolBar.add(btnSave);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnReset);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
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
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnCopyFrom);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(separatorFW5);
        this.toolBar.add(separatorFW8);
        this.toolBar.add(btnAddLine);
        this.toolBar.add(btnCopyLine);
        this.toolBar.add(btnInsertLine);
        this.toolBar.add(btnRemoveLine);
        this.toolBar.add(separatorFW6);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.custom.wages.PostSubsidyEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.person", java.lang.Object.class, this.kdtEntry, "person.text");
		dataBinder.registerBinding("Entry.personName", String.class, this.kdtEntry, "personName.text");
		dataBinder.registerBinding("Entry.startMonth", java.util.Date.class, this.kdtEntry, "startMonth.text");
		dataBinder.registerBinding("Entry.endMonth", java.util.Date.class, this.kdtEntry, "endMonth.text");
		dataBinder.registerBinding("Entry.allMonth", int.class, this.kdtEntry, "allMonth.text");
		dataBinder.registerBinding("Entry.AlreadyMonth", int.class, this.kdtEntry, "AlreadyMonth.text");
		dataBinder.registerBinding("Entry.AlreadyMoney", java.math.BigDecimal.class, this.kdtEntry, "AlreadyMoney.text");
		dataBinder.registerBinding("Entry.allMoney", java.math.BigDecimal.class, this.kdtEntry, "allMoney.text");
		dataBinder.registerBinding("Entry.psersonpost", java.lang.Object.class, this.kdtEntry, "psersonpost.text");
		dataBinder.registerBinding("Entry.postWages", java.math.BigDecimal.class, this.kdtEntry, "postWages.text");
		dataBinder.registerBinding("Entry.startMonthN", String.class, this.kdtEntry, "startMonthN.text");
		dataBinder.registerBinding("Entry.endMonthN", String.class, this.kdtEntry, "endMonthN.text");
		dataBinder.registerBinding("Entry.AlreadyMonthN", String.class, this.kdtEntry, "AlreadyMonthN.text");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.wages.app.PostSubsidyEditUIHandler";
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
        this.pkauditTime.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.wages.PostSubsidyInfo)ov;
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
	 * ????????��??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.personName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.startMonth", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.endMonth", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.allMonth", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.AlreadyMonth", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.AlreadyMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.allMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.psersonpost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.postWages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.startMonthN", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.endMonthN", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.AlreadyMonthN", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
        } else if (STATUS_EDIT.equals(this.oprtState)) {
        } else if (STATUS_VIEW.equals(this.oprtState)) {
        } else if (STATUS_FINDVIEW.equals(this.oprtState)) {
        }
    }


    /**
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("person".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"personName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"person").getValue(),"name")));

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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("creator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("creator.id"));
        	sic.add(new SelectorItemInfo("creator.number"));
        	sic.add(new SelectorItemInfo("creator.name"));
		}
        sic.add(new SelectorItemInfo("createTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("lastUpdateUser.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("lastUpdateUser.id"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.number"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.name"));
		}
        sic.add(new SelectorItemInfo("lastUpdateTime"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("auditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("auditor.id"));
        	sic.add(new SelectorItemInfo("auditor.number"));
        	sic.add(new SelectorItemInfo("auditor.name"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("billStatus"));
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.person.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.person.id"));
			sic.add(new SelectorItemInfo("Entry.person.number"));
			sic.add(new SelectorItemInfo("Entry.person.name"));
		}
    	sic.add(new SelectorItemInfo("Entry.personName"));
    	sic.add(new SelectorItemInfo("Entry.startMonth"));
    	sic.add(new SelectorItemInfo("Entry.endMonth"));
    	sic.add(new SelectorItemInfo("Entry.allMonth"));
    	sic.add(new SelectorItemInfo("Entry.AlreadyMonth"));
    	sic.add(new SelectorItemInfo("Entry.AlreadyMoney"));
    	sic.add(new SelectorItemInfo("Entry.allMoney"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.psersonpost.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.psersonpost.id"));
			sic.add(new SelectorItemInfo("Entry.psersonpost.postname"));
			sic.add(new SelectorItemInfo("Entry.psersonpost.name"));
        	sic.add(new SelectorItemInfo("Entry.psersonpost.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.postWages"));
    	sic.add(new SelectorItemInfo("Entry.startMonthN"));
    	sic.add(new SelectorItemInfo("Entry.endMonthN"));
    	sic.add(new SelectorItemInfo("Entry.AlreadyMonthN"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.wages.client", "PostSubsidyEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.wages.client.PostSubsidyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.PostSubsidyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.PostSubsidyInfo objectValue = new com.kingdee.eas.custom.wages.PostSubsidyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/wages/PostSubsidy";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.wages.app.PostSubsidyQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"��˾"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}