/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.hatch.client;

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
public abstract class AbstractEggReceiveBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractEggReceiveBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisInit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggSource;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPickDetail;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtPickDetail_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAddRows;
    protected com.kingdee.bos.ctrl.swing.KDButton btnAddRows;
    protected com.kingdee.bos.ctrl.swing.KDButton btnRefresh;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhasTakeAway;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contincubation;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisManuMin;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisOtherIn;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisBatchTrans;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDComboBox eggSource;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtAddRows;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtincubation;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnDelDownBill;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton toSettleBill;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator3;
    protected com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionShowPriceCol actionShowPriceCol = null;
    protected ActionViewAllBill actionViewAllBill = null;
    protected ActionDeleteDownBill actionDeleteDownBill = null;
    protected ActionToSettleBill actionToSettleBill = null;
    protected ActionSetColor actionSetColor = null;
    /**
     * output class constructor
     */
    public AbstractEggReceiveBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractEggReceiveBillEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionSubmit
        String _tempStr = null;
        actionSubmit.setEnabled(true);
        actionSubmit.setDaemonRun(false);

        actionSubmit.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
        _tempStr = resHelper.getString("ActionSubmit.SHORT_DESCRIPTION");
        actionSubmit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.LONG_DESCRIPTION");
        actionSubmit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.NAME");
        actionSubmit.putValue(ItemAction.NAME, _tempStr);
        this.actionSubmit.setBindWorkFlow(true);
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrint
        actionPrint.setEnabled(true);
        actionPrint.setDaemonRun(false);

        actionPrint.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl P"));
        _tempStr = resHelper.getString("ActionPrint.SHORT_DESCRIPTION");
        actionPrint.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.LONG_DESCRIPTION");
        actionPrint.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.NAME");
        actionPrint.putValue(ItemAction.NAME, _tempStr);
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrintPreview
        actionPrintPreview.setEnabled(true);
        actionPrintPreview.setDaemonRun(false);

        actionPrintPreview.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift ctrl P"));
        _tempStr = resHelper.getString("ActionPrintPreview.SHORT_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.LONG_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.NAME");
        actionPrintPreview.putValue(ItemAction.NAME, _tempStr);
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "false");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "false");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionShowPriceCol
        this.actionShowPriceCol = new ActionShowPriceCol(this);
        getActionManager().registerAction("actionShowPriceCol", actionShowPriceCol);
        this.actionShowPriceCol.setExtendProperty("canForewarn", "true");
        this.actionShowPriceCol.setExtendProperty("userDefined", "false");
        this.actionShowPriceCol.setExtendProperty("isObjectUpdateLock", "false");
         this.actionShowPriceCol.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionShowPriceCol.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionViewAllBill
        this.actionViewAllBill = new ActionViewAllBill(this);
        getActionManager().registerAction("actionViewAllBill", actionViewAllBill);
        this.actionViewAllBill.setExtendProperty("canForewarn", "true");
        this.actionViewAllBill.setExtendProperty("userDefined", "false");
        this.actionViewAllBill.setExtendProperty("isObjectUpdateLock", "false");
         this.actionViewAllBill.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionViewAllBill.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionDeleteDownBill
        this.actionDeleteDownBill = new ActionDeleteDownBill(this);
        getActionManager().registerAction("actionDeleteDownBill", actionDeleteDownBill);
        this.actionDeleteDownBill.setExtendProperty("canForewarn", "true");
        this.actionDeleteDownBill.setExtendProperty("userDefined", "false");
        this.actionDeleteDownBill.setExtendProperty("isObjectUpdateLock", "false");
         this.actionDeleteDownBill.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionDeleteDownBill.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionToSettleBill
        this.actionToSettleBill = new ActionToSettleBill(this);
        getActionManager().registerAction("actionToSettleBill", actionToSettleBill);
        this.actionToSettleBill.setExtendProperty("canForewarn", "true");
        this.actionToSettleBill.setExtendProperty("userDefined", "false");
        this.actionToSettleBill.setExtendProperty("isObjectUpdateLock", "false");
         this.actionToSettleBill.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionToSettleBill.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionSetColor
        this.actionSetColor = new ActionSetColor(this);
        getActionManager().registerAction("actionSetColor", actionSetColor);
        this.actionSetColor.setExtendProperty("canForewarn", "true");
        this.actionSetColor.setExtendProperty("userDefined", "false");
        this.actionSetColor.setExtendProperty("isObjectUpdateLock", "false");
         this.actionSetColor.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSetColor.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisInit = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.conteggSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtPickDetail = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contAddRows = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnAddRows = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnRefresh = new com.kingdee.bos.ctrl.swing.KDButton();
        this.chkhasTakeAway = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contincubation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisManuMin = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisOtherIn = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisBatchTrans = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtstorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.eggSource = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtAddRows = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtincubation = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnDelDownBill = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.toSettleBill = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.newSeparator3 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contbillStatus.setName("contbillStatus");
        this.contcompany.setName("contcompany");
        this.contauditTime.setName("contauditTime");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.kdtEntrys.setName("kdtEntrys");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.chkisInit.setName("chkisInit");
        this.conteggSource.setName("conteggSource");
        this.kdtPickDetail.setName("kdtPickDetail");
        this.contAddRows.setName("contAddRows");
        this.btnAddRows.setName("btnAddRows");
        this.btnRefresh.setName("btnRefresh");
        this.chkhasTakeAway.setName("chkhasTakeAway");
        this.contincubation.setName("contincubation");
        this.chkisManuMin.setName("chkisManuMin");
        this.chkisOtherIn.setName("chkisOtherIn");
        this.chkisBatchTrans.setName("chkisBatchTrans");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.billStatus.setName("billStatus");
        this.prmtcompany.setName("prmtcompany");
        this.pkauditTime.setName("pkauditTime");
        this.prmtstorageOrgUnit.setName("prmtstorageOrgUnit");
        this.eggSource.setName("eggSource");
        this.txtAddRows.setName("txtAddRows");
        this.prmtincubation.setName("prmtincubation");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.btnDelDownBill.setName("btnDelDownBill");
        this.toSettleBill.setName("toSettleBill");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        this.newSeparator3.setName("newSeparator3");
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
        // contCreator		
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);
        // contCreateTime		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);
        // contLastUpdateUser		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);
        // contLastUpdateTime		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // kDSeparator8
        // kDSeparator9
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol16\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol17\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol18\"><c:Protection locked=\"true\" /><c:NumberFormat>#.00</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:Protection hidden=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:Protection hidden=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:Protection hidden=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:Protection hidden=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:Protection hidden=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:Protection hidden=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:Protection hidden=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:Protection hidden=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:Protection hidden=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol33\"><c:Protection hidden=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol34\"><c:Protection hidden=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol35\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol36\"><c:Protection hidden=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol37\"><c:Protection hidden=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol38\"><c:Protection hidden=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol39\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol40\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol41\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol42\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol43\"><c:Protection locked=\"true\" /><c:NumberFormat>#.000</c:NumberFormat></c:Style><c:Style id=\"sCol44\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol45\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol46\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol47\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol48\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" t:styleID=\"sCol0\" /><t:Column t:key=\"internalFarm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"internalBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"lot\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"7\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"stockingBatch\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"farmerGroup\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" t:styleID=\"sCol9\" /><t:Column t:key=\"genderType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" /><t:Column t:key=\"sendDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" t:styleID=\"sCol11\" /><t:Column t:key=\"sendAllQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" t:styleID=\"sCol12\" /><t:Column t:key=\"weekAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" t:styleID=\"sCol13\" /><t:Column t:key=\"dayAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" t:styleID=\"sCol14\" /><t:Column t:key=\"isFormal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" t:styleID=\"sCol15\" /><t:Column t:key=\"statisticsType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"17\" t:styleID=\"sCol16\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"18\" t:styleID=\"sCol17\" /><t:Column t:key=\"allQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"19\" t:styleID=\"sCol18\" /><t:Column t:key=\"effectAllQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"20\" t:styleID=\"sCol19\" /><t:Column t:key=\"brokenQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"21\" t:styleID=\"sCol20\" /><t:Column t:key=\"wrongSharpEgg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"24\" t:styleID=\"sCol21\" /><t:Column t:key=\"eggLiquid\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"25\" t:styleID=\"sCol22\" /><t:Column t:key=\"qc1lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"26\" t:styleID=\"sCol23\" /><t:Column t:key=\"qc1lv2Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"27\" t:styleID=\"sCol24\" /><t:Column t:key=\"qc2lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"28\" t:styleID=\"sCol25\" /><t:Column t:key=\"qc2lv2Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"29\" t:styleID=\"sCol26\" /><t:Column t:key=\"qc3lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"30\" t:styleID=\"sCol27\" /><t:Column t:key=\"qc4lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"31\" t:styleID=\"sCol28\" /><t:Column t:key=\"qc5lv2Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"32\" t:styleID=\"sCol29\" /><t:Column t:key=\"qc6lv2Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"33\" t:styleID=\"sCol30\" /><t:Column t:key=\"greensQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"33\" t:styleID=\"sCol31\" /><t:Column t:key=\"dirtyQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"34\" t:styleID=\"sCol32\" /><t:Column t:key=\"doubleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"35\" t:styleID=\"sCol33\" /><t:Column t:key=\"mutantQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"36\" t:styleID=\"sCol34\" /><t:Column t:key=\"tinyEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"38\" t:styleID=\"sCol35\" /><t:Column t:key=\"brokenSingeQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"39\" t:styleID=\"sCol36\" /><t:Column t:key=\"flowQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"40\" t:styleID=\"sCol37\" /><t:Column t:key=\"brokenDoubleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"41\" t:styleID=\"sCol38\" /><t:Column t:key=\"qcRateFarmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"42\" t:styleID=\"sCol39\" /><t:Column t:key=\"qcRateWorkshop\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"43\" t:styleID=\"sCol40\" /><t:Column t:key=\"hiddenRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"44\" t:styleID=\"sCol41\" /><t:Column t:key=\"brokenRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"45\" t:styleID=\"sCol42\" /><t:Column t:key=\"diffQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"46\" t:styleID=\"sCol43\" /><t:Column t:key=\"warehouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"47\" t:styleID=\"sCol44\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol45\" /><t:Column t:key=\"costItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol46\" /><t:Column t:key=\"settleBillID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol47\" /><t:Column t:key=\"isExistDownBill\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol48\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{internalFarm}</t:Cell><t:Cell>$Resource{internalBatch}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{lot}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{stockingBatch}</t:Cell><t:Cell>$Resource{farmerGroup}</t:Cell><t:Cell>$Resource{genderType}</t:Cell><t:Cell>$Resource{sendDate}</t:Cell><t:Cell>$Resource{sendAllQty}</t:Cell><t:Cell>$Resource{weekAge}</t:Cell><t:Cell>$Resource{dayAge}</t:Cell><t:Cell>$Resource{isFormal}</t:Cell><t:Cell>$Resource{statisticsType}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{allQty}</t:Cell><t:Cell>$Resource{effectAllQty}</t:Cell><t:Cell>$Resource{brokenQty}</t:Cell><t:Cell>$Resource{wrongSharpEgg}</t:Cell><t:Cell>$Resource{eggLiquid}</t:Cell><t:Cell>$Resource{qc1lv1Qty}</t:Cell><t:Cell>$Resource{qc1lv2Qty}</t:Cell><t:Cell>$Resource{qc2lv1Qty}</t:Cell><t:Cell>$Resource{qc2lv2Qty}</t:Cell><t:Cell>$Resource{qc3lv1Qty}</t:Cell><t:Cell>$Resource{qc4lv1Qty}</t:Cell><t:Cell>$Resource{qc5lv2Qty}</t:Cell><t:Cell>$Resource{qc6lv2Qty}</t:Cell><t:Cell>$Resource{greensQty}</t:Cell><t:Cell>$Resource{dirtyQty}</t:Cell><t:Cell>$Resource{doubleQty}</t:Cell><t:Cell>$Resource{mutantQty}</t:Cell><t:Cell>$Resource{tinyEggQty}</t:Cell><t:Cell>$Resource{brokenSingeQty}</t:Cell><t:Cell>$Resource{flowQty}</t:Cell><t:Cell>$Resource{brokenDoubleQty}</t:Cell><t:Cell>$Resource{qcRateFarmer}</t:Cell><t:Cell>$Resource{qcRateWorkshop}</t:Cell><t:Cell>$Resource{hiddenRate}</t:Cell><t:Cell>$Resource{brokenRate}</t:Cell><t:Cell>$Resource{diffQty}</t:Cell><t:Cell>$Resource{warehouse}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{costItem}</t:Cell><t:Cell>$Resource{settleBillID}</t:Cell><t:Cell>$Resource{isExistDownBill}</t:Cell></t:Row><t:Row t:name=\"header2\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id_Row2}</t:Cell><t:Cell>$Resource{internalFarm_Row2}</t:Cell><t:Cell>$Resource{internalBatch_Row2}</t:Cell><t:Cell>$Resource{supplier_Row2}</t:Cell><t:Cell>$Resource{lot_Row2}</t:Cell><t:Cell>$Resource{farmer_Row2}</t:Cell><t:Cell>$Resource{farm_Row2}</t:Cell><t:Cell>$Resource{house_Row2}</t:Cell><t:Cell>$Resource{stockingBatch_Row2}</t:Cell><t:Cell>$Resource{farmerGroup_Row2}</t:Cell><t:Cell>$Resource{genderType_Row2}</t:Cell><t:Cell>$Resource{sendDate_Row2}</t:Cell><t:Cell>$Resource{sendAllQty_Row2}</t:Cell><t:Cell>$Resource{weekAge_Row2}</t:Cell><t:Cell>$Resource{dayAge_Row2}</t:Cell><t:Cell>$Resource{isFormal_Row2}</t:Cell><t:Cell>$Resource{statisticsType_Row2}</t:Cell><t:Cell>$Resource{unit_Row2}</t:Cell><t:Cell>$Resource{allQty_Row2}</t:Cell><t:Cell>$Resource{effectAllQty_Row2}</t:Cell><t:Cell>$Resource{brokenQty_Row2}</t:Cell><t:Cell>$Resource{wrongSharpEgg_Row2}</t:Cell><t:Cell>$Resource{eggLiquid_Row2}</t:Cell><t:Cell>$Resource{qc1lv1Qty_Row2}</t:Cell><t:Cell>$Resource{qc1lv2Qty_Row2}</t:Cell><t:Cell>$Resource{qc2lv1Qty_Row2}</t:Cell><t:Cell>$Resource{qc2lv2Qty_Row2}</t:Cell><t:Cell>$Resource{qc3lv1Qty_Row2}</t:Cell><t:Cell>$Resource{qc4lv1Qty_Row2}</t:Cell><t:Cell>$Resource{qc5lv2Qty_Row2}</t:Cell><t:Cell>$Resource{qc6lv2Qty_Row2}</t:Cell><t:Cell>$Resource{greensQty_Row2}</t:Cell><t:Cell>$Resource{dirtyQty_Row2}</t:Cell><t:Cell>$Resource{doubleQty_Row2}</t:Cell><t:Cell>$Resource{mutantQty_Row2}</t:Cell><t:Cell>$Resource{tinyEggQty_Row2}</t:Cell><t:Cell>$Resource{brokenSingeQty_Row2}</t:Cell><t:Cell>$Resource{flowQty_Row2}</t:Cell><t:Cell>$Resource{brokenDoubleQty_Row2}</t:Cell><t:Cell>$Resource{qcRateFarmer_Row2}</t:Cell><t:Cell>$Resource{qcRateWorkshop_Row2}</t:Cell><t:Cell>$Resource{hiddenRate_Row2}</t:Cell><t:Cell>$Resource{brokenRate_Row2}</t:Cell><t:Cell>$Resource{diffQty_Row2}</t:Cell><t:Cell>$Resource{warehouse_Row2}</t:Cell><t:Cell>$Resource{material_Row2}</t:Cell><t:Cell>$Resource{costItem_Row2}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head><t:Block t:top=\"0\" t:left=\"0\" t:bottom=\"1\" t:right=\"0\" /><t:Block t:top=\"0\" t:left=\"1\" t:bottom=\"1\" t:right=\"1\" /><t:Block t:top=\"0\" t:left=\"2\" t:bottom=\"1\" t:right=\"2\" /><t:Block t:top=\"0\" t:left=\"3\" t:bottom=\"1\" t:right=\"3\" /><t:Block t:top=\"0\" t:left=\"4\" t:bottom=\"1\" t:right=\"4\" /><t:Block t:top=\"0\" t:left=\"5\" t:bottom=\"1\" t:right=\"5\" /><t:Block t:top=\"0\" t:left=\"6\" t:bottom=\"1\" t:right=\"6\" /><t:Block t:top=\"0\" t:left=\"7\" t:bottom=\"1\" t:right=\"7\" /><t:Block t:top=\"0\" t:left=\"8\" t:bottom=\"1\" t:right=\"8\" /><t:Block t:top=\"0\" t:left=\"9\" t:bottom=\"1\" t:right=\"9\" /><t:Block t:top=\"0\" t:left=\"10\" t:bottom=\"1\" t:right=\"10\" /><t:Block t:top=\"0\" t:left=\"11\" t:bottom=\"1\" t:right=\"11\" /><t:Block t:top=\"0\" t:left=\"12\" t:bottom=\"1\" t:right=\"12\" /><t:Block t:top=\"0\" t:left=\"13\" t:bottom=\"1\" t:right=\"13\" /><t:Block t:top=\"0\" t:left=\"14\" t:bottom=\"1\" t:right=\"14\" /><t:Block t:top=\"0\" t:left=\"15\" t:bottom=\"1\" t:right=\"15\" /><t:Block t:top=\"0\" t:left=\"16\" t:bottom=\"1\" t:right=\"16\" /><t:Block t:top=\"0\" t:left=\"17\" t:bottom=\"1\" t:right=\"17\" /><t:Block t:top=\"0\" t:left=\"18\" t:bottom=\"1\" t:right=\"18\" /><t:Block t:top=\"0\" t:left=\"19\" t:bottom=\"1\" t:right=\"19\" /><t:Block t:top=\"0\" t:left=\"20\" t:bottom=\"1\" t:right=\"20\" /><t:Block t:top=\"0\" t:left=\"21\" t:bottom=\"1\" t:right=\"21\" /><t:Block t:top=\"0\" t:left=\"22\" t:bottom=\"1\" t:right=\"22\" /><t:Block t:top=\"0\" t:left=\"23\" t:bottom=\"0\" t:right=\"24\" /><t:Block t:top=\"0\" t:left=\"25\" t:bottom=\"0\" t:right=\"26\" /><t:Block t:top=\"0\" t:left=\"27\" t:bottom=\"0\" t:right=\"27\" /><t:Block t:top=\"0\" t:left=\"28\" t:bottom=\"0\" t:right=\"28\" /><t:Block t:top=\"0\" t:left=\"29\" t:bottom=\"0\" t:right=\"36\" /><t:Block t:top=\"0\" t:left=\"37\" t:bottom=\"0\" t:right=\"38\" /><t:Block t:top=\"0\" t:left=\"39\" t:bottom=\"1\" t:right=\"39\" /><t:Block t:top=\"0\" t:left=\"40\" t:bottom=\"1\" t:right=\"40\" /><t:Block t:top=\"0\" t:left=\"41\" t:bottom=\"1\" t:right=\"41\" /><t:Block t:top=\"0\" t:left=\"42\" t:bottom=\"1\" t:right=\"42\" /><t:Block t:top=\"0\" t:left=\"43\" t:bottom=\"1\" t:right=\"43\" /><t:Block t:top=\"0\" t:left=\"44\" t:bottom=\"1\" t:right=\"44\" /><t:Block t:top=\"0\" t:left=\"45\" t:bottom=\"1\" t:right=\"45\" /><t:Block t:top=\"0\" t:left=\"46\" t:bottom=\"1\" t:right=\"46\" /></t:Head></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));
        kdtEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEntrys.putBindContents("editData",new String[] {"id","internalFarm","internalBatch","supplier","lot","farmer","farm","house","stockingBatch","farmerGroup","genderType","sendDate","sendAllQty","weekAge","dayAge","isFormal","statisticsType","unit","allQty","effectAllQty","brokenQty","wrongSharpEgg","eggLiquid","qc1lv1Qty","qc1lv2Qty","qc2lv1Qty","qc2lv2Qty","qc3lv1Qty","qc4lv1Qty","qc5lv2Qty","qc6lv2Qty","greensQty","dirtyQty","doubleQty","mutantQty","tinyEggQty","brokenSingeQty","flowQty","brokenDoubleQty","qcRateFarmer","qcRateWorkshop","hiddenRate","brokenRate","diffQty","warehouse","material","costItem","settleBillID","isExistDownBill"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_internalFarm_PromptBox = new KDBizPromptBox();
        kdtEntrys_internalFarm_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
        kdtEntrys_internalFarm_PromptBox.setVisible(true);
        kdtEntrys_internalFarm_PromptBox.setEditable(true);
        kdtEntrys_internalFarm_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_internalFarm_PromptBox.setEditFormat("$number$");
        kdtEntrys_internalFarm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_internalFarm_CellEditor = new KDTDefaultCellEditor(kdtEntrys_internalFarm_PromptBox);
        this.kdtEntrys.getColumn("internalFarm").setEditor(kdtEntrys_internalFarm_CellEditor);
        ObjectValueRender kdtEntrys_internalFarm_OVR = new ObjectValueRender();
        kdtEntrys_internalFarm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("internalFarm").setRenderer(kdtEntrys_internalFarm_OVR);
        final KDBizPromptBox kdtEntrys_internalBatch_PromptBox = new KDBizPromptBox();
        kdtEntrys_internalBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.ParentBreedBatchQuery");
        kdtEntrys_internalBatch_PromptBox.setVisible(true);
        kdtEntrys_internalBatch_PromptBox.setEditable(true);
        kdtEntrys_internalBatch_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_internalBatch_PromptBox.setEditFormat("$number$");
        kdtEntrys_internalBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_internalBatch_CellEditor = new KDTDefaultCellEditor(kdtEntrys_internalBatch_PromptBox);
        this.kdtEntrys.getColumn("internalBatch").setEditor(kdtEntrys_internalBatch_CellEditor);
        ObjectValueRender kdtEntrys_internalBatch_OVR = new ObjectValueRender();
        kdtEntrys_internalBatch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("internalBatch").setRenderer(kdtEntrys_internalBatch_OVR);
        final KDBizPromptBox kdtEntrys_supplier_PromptBox = new KDBizPromptBox();
        kdtEntrys_supplier_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierDefaultQuery");
        kdtEntrys_supplier_PromptBox.setVisible(true);
        kdtEntrys_supplier_PromptBox.setEditable(true);
        kdtEntrys_supplier_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_supplier_PromptBox.setEditFormat("$number$");
        kdtEntrys_supplier_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_supplier_CellEditor = new KDTDefaultCellEditor(kdtEntrys_supplier_PromptBox);
        this.kdtEntrys.getColumn("supplier").setEditor(kdtEntrys_supplier_CellEditor);
        ObjectValueRender kdtEntrys_supplier_OVR = new ObjectValueRender();
        kdtEntrys_supplier_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("supplier").setRenderer(kdtEntrys_supplier_OVR);
        KDTextField kdtEntrys_lot_TextField = new KDTextField();
        kdtEntrys_lot_TextField.setName("kdtEntrys_lot_TextField");
        kdtEntrys_lot_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_lot_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lot_TextField);
        this.kdtEntrys.getColumn("lot").setEditor(kdtEntrys_lot_CellEditor);
        final KDBizPromptBox kdtEntrys_farmer_PromptBox = new KDBizPromptBox();
        kdtEntrys_farmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");
        kdtEntrys_farmer_PromptBox.setVisible(true);
        kdtEntrys_farmer_PromptBox.setEditable(true);
        kdtEntrys_farmer_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_farmer_PromptBox.setEditFormat("$number$");
        kdtEntrys_farmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_farmer_CellEditor = new KDTDefaultCellEditor(kdtEntrys_farmer_PromptBox);
        this.kdtEntrys.getColumn("farmer").setEditor(kdtEntrys_farmer_CellEditor);
        ObjectValueRender kdtEntrys_farmer_OVR = new ObjectValueRender();
        kdtEntrys_farmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("farmer").setRenderer(kdtEntrys_farmer_OVR);
        			kdtEntrys_farmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI kdtEntrys_farmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_farmer_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_farmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_farmer_PromptBox_F7ListUI));
					kdtEntrys_farmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_farmer_PromptBox.setSelector(kdtEntrys_farmer_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_farm_PromptBox = new KDBizPromptBox();
        kdtEntrys_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");
        kdtEntrys_farm_PromptBox.setVisible(true);
        kdtEntrys_farm_PromptBox.setEditable(true);
        kdtEntrys_farm_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_farm_PromptBox.setEditFormat("$number$");
        kdtEntrys_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_farm_CellEditor = new KDTDefaultCellEditor(kdtEntrys_farm_PromptBox);
        this.kdtEntrys.getColumn("farm").setEditor(kdtEntrys_farm_CellEditor);
        ObjectValueRender kdtEntrys_farm_OVR = new ObjectValueRender();
        kdtEntrys_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("farm").setRenderer(kdtEntrys_farm_OVR);
        			kdtEntrys_farm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI kdtEntrys_farm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_farm_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_farm_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_farm_PromptBox_F7ListUI));
					kdtEntrys_farm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_farm_PromptBox.setSelector(kdtEntrys_farm_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_house_PromptBox = new KDBizPromptBox();
        kdtEntrys_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtEntrys_house_PromptBox.setVisible(true);
        kdtEntrys_house_PromptBox.setEditable(true);
        kdtEntrys_house_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_house_PromptBox.setEditFormat("$number$");
        kdtEntrys_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_house_CellEditor = new KDTDefaultCellEditor(kdtEntrys_house_PromptBox);
        this.kdtEntrys.getColumn("house").setEditor(kdtEntrys_house_CellEditor);
        ObjectValueRender kdtEntrys_house_OVR = new ObjectValueRender();
        kdtEntrys_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("house").setRenderer(kdtEntrys_house_OVR);
        final KDBizPromptBox kdtEntrys_stockingBatch_PromptBox = new KDBizPromptBox();
        kdtEntrys_stockingBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");
        kdtEntrys_stockingBatch_PromptBox.setVisible(true);
        kdtEntrys_stockingBatch_PromptBox.setEditable(true);
        kdtEntrys_stockingBatch_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_stockingBatch_PromptBox.setEditFormat("$number$");
        kdtEntrys_stockingBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_stockingBatch_CellEditor = new KDTDefaultCellEditor(kdtEntrys_stockingBatch_PromptBox);
        this.kdtEntrys.getColumn("stockingBatch").setEditor(kdtEntrys_stockingBatch_CellEditor);
        ObjectValueRender kdtEntrys_stockingBatch_OVR = new ObjectValueRender();
        kdtEntrys_stockingBatch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("stockingBatch").setRenderer(kdtEntrys_stockingBatch_OVR);
        			kdtEntrys_stockingBatch_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI kdtEntrys_stockingBatch_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_stockingBatch_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_stockingBatch_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_stockingBatch_PromptBox_F7ListUI));
					kdtEntrys_stockingBatch_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_stockingBatch_PromptBox.setSelector(kdtEntrys_stockingBatch_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEntrys_farmerGroup_TextField = new KDTextField();
        kdtEntrys_farmerGroup_TextField.setName("kdtEntrys_farmerGroup_TextField");
        kdtEntrys_farmerGroup_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_farmerGroup_CellEditor = new KDTDefaultCellEditor(kdtEntrys_farmerGroup_TextField);
        this.kdtEntrys.getColumn("farmerGroup").setEditor(kdtEntrys_farmerGroup_CellEditor);
        KDComboBox kdtEntrys_genderType_ComboBox = new KDComboBox();
        kdtEntrys_genderType_ComboBox.setName("kdtEntrys_genderType_ComboBox");
        kdtEntrys_genderType_ComboBox.setVisible(true);
        kdtEntrys_genderType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());
        KDTDefaultCellEditor kdtEntrys_genderType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_genderType_ComboBox);
        this.kdtEntrys.getColumn("genderType").setEditor(kdtEntrys_genderType_CellEditor);
        KDDatePicker kdtEntrys_sendDate_DatePicker = new KDDatePicker();
        kdtEntrys_sendDate_DatePicker.setName("kdtEntrys_sendDate_DatePicker");
        kdtEntrys_sendDate_DatePicker.setVisible(true);
        kdtEntrys_sendDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_sendDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sendDate_DatePicker);
        this.kdtEntrys.getColumn("sendDate").setEditor(kdtEntrys_sendDate_CellEditor);
        KDFormattedTextField kdtEntrys_sendAllQty_TextField = new KDFormattedTextField();
        kdtEntrys_sendAllQty_TextField.setName("kdtEntrys_sendAllQty_TextField");
        kdtEntrys_sendAllQty_TextField.setVisible(true);
        kdtEntrys_sendAllQty_TextField.setEditable(true);
        kdtEntrys_sendAllQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_sendAllQty_TextField.setDataType(1);
        	kdtEntrys_sendAllQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_sendAllQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_sendAllQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_sendAllQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sendAllQty_TextField);
        this.kdtEntrys.getColumn("sendAllQty").setEditor(kdtEntrys_sendAllQty_CellEditor);
        KDTextField kdtEntrys_weekAge_TextField = new KDTextField();
        kdtEntrys_weekAge_TextField.setName("kdtEntrys_weekAge_TextField");
        kdtEntrys_weekAge_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_weekAge_CellEditor = new KDTDefaultCellEditor(kdtEntrys_weekAge_TextField);
        this.kdtEntrys.getColumn("weekAge").setEditor(kdtEntrys_weekAge_CellEditor);
        KDFormattedTextField kdtEntrys_dayAge_TextField = new KDFormattedTextField();
        kdtEntrys_dayAge_TextField.setName("kdtEntrys_dayAge_TextField");
        kdtEntrys_dayAge_TextField.setVisible(true);
        kdtEntrys_dayAge_TextField.setEditable(true);
        kdtEntrys_dayAge_TextField.setHorizontalAlignment(2);
        kdtEntrys_dayAge_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_dayAge_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dayAge_TextField);
        this.kdtEntrys.getColumn("dayAge").setEditor(kdtEntrys_dayAge_CellEditor);
        KDCheckBox kdtEntrys_isFormal_CheckBox = new KDCheckBox();
        kdtEntrys_isFormal_CheckBox.setName("kdtEntrys_isFormal_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isFormal_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isFormal_CheckBox);
        this.kdtEntrys.getColumn("isFormal").setEditor(kdtEntrys_isFormal_CellEditor);
        KDComboBox kdtEntrys_statisticsType_ComboBox = new KDComboBox();
        kdtEntrys_statisticsType_ComboBox.setName("kdtEntrys_statisticsType_ComboBox");
        kdtEntrys_statisticsType_ComboBox.setVisible(true);
        kdtEntrys_statisticsType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.StatisticsType").toArray());
        KDTDefaultCellEditor kdtEntrys_statisticsType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_statisticsType_ComboBox);
        this.kdtEntrys.getColumn("statisticsType").setEditor(kdtEntrys_statisticsType_CellEditor);
        final KDBizPromptBox kdtEntrys_unit_PromptBox = new KDBizPromptBox();
        kdtEntrys_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntrys_unit_PromptBox.setVisible(true);
        kdtEntrys_unit_PromptBox.setEditable(true);
        kdtEntrys_unit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_unit_PromptBox.setEditFormat("$number$");
        kdtEntrys_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_unit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unit_PromptBox);
        this.kdtEntrys.getColumn("unit").setEditor(kdtEntrys_unit_CellEditor);
        ObjectValueRender kdtEntrys_unit_OVR = new ObjectValueRender();
        kdtEntrys_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("unit").setRenderer(kdtEntrys_unit_OVR);
        KDFormattedTextField kdtEntrys_allQty_TextField = new KDFormattedTextField();
        kdtEntrys_allQty_TextField.setName("kdtEntrys_allQty_TextField");
        kdtEntrys_allQty_TextField.setVisible(true);
        kdtEntrys_allQty_TextField.setEditable(true);
        kdtEntrys_allQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_allQty_TextField.setDataType(1);
        	kdtEntrys_allQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_allQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_allQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_allQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_allQty_TextField);
        this.kdtEntrys.getColumn("allQty").setEditor(kdtEntrys_allQty_CellEditor);
        KDFormattedTextField kdtEntrys_effectAllQty_TextField = new KDFormattedTextField();
        kdtEntrys_effectAllQty_TextField.setName("kdtEntrys_effectAllQty_TextField");
        kdtEntrys_effectAllQty_TextField.setVisible(true);
        kdtEntrys_effectAllQty_TextField.setEditable(true);
        kdtEntrys_effectAllQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_effectAllQty_TextField.setDataType(1);
        	kdtEntrys_effectAllQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_effectAllQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_effectAllQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_effectAllQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_effectAllQty_TextField);
        this.kdtEntrys.getColumn("effectAllQty").setEditor(kdtEntrys_effectAllQty_CellEditor);
        KDFormattedTextField kdtEntrys_brokenQty_TextField = new KDFormattedTextField();
        kdtEntrys_brokenQty_TextField.setName("kdtEntrys_brokenQty_TextField");
        kdtEntrys_brokenQty_TextField.setVisible(true);
        kdtEntrys_brokenQty_TextField.setEditable(true);
        kdtEntrys_brokenQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_brokenQty_TextField.setDataType(1);
        	kdtEntrys_brokenQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_brokenQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_brokenQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_brokenQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_brokenQty_TextField);
        this.kdtEntrys.getColumn("brokenQty").setEditor(kdtEntrys_brokenQty_CellEditor);
        KDFormattedTextField kdtEntrys_wrongSharpEgg_TextField = new KDFormattedTextField();
        kdtEntrys_wrongSharpEgg_TextField.setName("kdtEntrys_wrongSharpEgg_TextField");
        kdtEntrys_wrongSharpEgg_TextField.setVisible(true);
        kdtEntrys_wrongSharpEgg_TextField.setEditable(true);
        kdtEntrys_wrongSharpEgg_TextField.setHorizontalAlignment(2);
        kdtEntrys_wrongSharpEgg_TextField.setDataType(1);
        	kdtEntrys_wrongSharpEgg_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_wrongSharpEgg_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_wrongSharpEgg_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_wrongSharpEgg_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wrongSharpEgg_TextField);
        this.kdtEntrys.getColumn("wrongSharpEgg").setEditor(kdtEntrys_wrongSharpEgg_CellEditor);
        KDFormattedTextField kdtEntrys_eggLiquid_TextField = new KDFormattedTextField();
        kdtEntrys_eggLiquid_TextField.setName("kdtEntrys_eggLiquid_TextField");
        kdtEntrys_eggLiquid_TextField.setVisible(true);
        kdtEntrys_eggLiquid_TextField.setEditable(true);
        kdtEntrys_eggLiquid_TextField.setHorizontalAlignment(2);
        kdtEntrys_eggLiquid_TextField.setDataType(1);
        	kdtEntrys_eggLiquid_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_eggLiquid_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_eggLiquid_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_eggLiquid_CellEditor = new KDTDefaultCellEditor(kdtEntrys_eggLiquid_TextField);
        this.kdtEntrys.getColumn("eggLiquid").setEditor(kdtEntrys_eggLiquid_CellEditor);
        KDFormattedTextField kdtEntrys_qc1lv1Qty_TextField = new KDFormattedTextField();
        kdtEntrys_qc1lv1Qty_TextField.setName("kdtEntrys_qc1lv1Qty_TextField");
        kdtEntrys_qc1lv1Qty_TextField.setVisible(true);
        kdtEntrys_qc1lv1Qty_TextField.setEditable(true);
        kdtEntrys_qc1lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qc1lv1Qty_TextField.setDataType(1);
        	kdtEntrys_qc1lv1Qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qc1lv1Qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qc1lv1Qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qc1lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qc1lv1Qty_TextField);
        this.kdtEntrys.getColumn("qc1lv1Qty").setEditor(kdtEntrys_qc1lv1Qty_CellEditor);
        KDFormattedTextField kdtEntrys_qc1lv2Qty_TextField = new KDFormattedTextField();
        kdtEntrys_qc1lv2Qty_TextField.setName("kdtEntrys_qc1lv2Qty_TextField");
        kdtEntrys_qc1lv2Qty_TextField.setVisible(true);
        kdtEntrys_qc1lv2Qty_TextField.setEditable(true);
        kdtEntrys_qc1lv2Qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qc1lv2Qty_TextField.setDataType(1);
        	kdtEntrys_qc1lv2Qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qc1lv2Qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qc1lv2Qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qc1lv2Qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qc1lv2Qty_TextField);
        this.kdtEntrys.getColumn("qc1lv2Qty").setEditor(kdtEntrys_qc1lv2Qty_CellEditor);
        KDFormattedTextField kdtEntrys_qc2lv1Qty_TextField = new KDFormattedTextField();
        kdtEntrys_qc2lv1Qty_TextField.setName("kdtEntrys_qc2lv1Qty_TextField");
        kdtEntrys_qc2lv1Qty_TextField.setVisible(true);
        kdtEntrys_qc2lv1Qty_TextField.setEditable(true);
        kdtEntrys_qc2lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qc2lv1Qty_TextField.setDataType(1);
        	kdtEntrys_qc2lv1Qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qc2lv1Qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qc2lv1Qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qc2lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qc2lv1Qty_TextField);
        this.kdtEntrys.getColumn("qc2lv1Qty").setEditor(kdtEntrys_qc2lv1Qty_CellEditor);
        KDFormattedTextField kdtEntrys_qc2lv2Qty_TextField = new KDFormattedTextField();
        kdtEntrys_qc2lv2Qty_TextField.setName("kdtEntrys_qc2lv2Qty_TextField");
        kdtEntrys_qc2lv2Qty_TextField.setVisible(true);
        kdtEntrys_qc2lv2Qty_TextField.setEditable(true);
        kdtEntrys_qc2lv2Qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qc2lv2Qty_TextField.setDataType(1);
        	kdtEntrys_qc2lv2Qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qc2lv2Qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qc2lv2Qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qc2lv2Qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qc2lv2Qty_TextField);
        this.kdtEntrys.getColumn("qc2lv2Qty").setEditor(kdtEntrys_qc2lv2Qty_CellEditor);
        KDFormattedTextField kdtEntrys_qc3lv1Qty_TextField = new KDFormattedTextField();
        kdtEntrys_qc3lv1Qty_TextField.setName("kdtEntrys_qc3lv1Qty_TextField");
        kdtEntrys_qc3lv1Qty_TextField.setVisible(true);
        kdtEntrys_qc3lv1Qty_TextField.setEditable(true);
        kdtEntrys_qc3lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qc3lv1Qty_TextField.setDataType(1);
        	kdtEntrys_qc3lv1Qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qc3lv1Qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qc3lv1Qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qc3lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qc3lv1Qty_TextField);
        this.kdtEntrys.getColumn("qc3lv1Qty").setEditor(kdtEntrys_qc3lv1Qty_CellEditor);
        KDFormattedTextField kdtEntrys_qc4lv1Qty_TextField = new KDFormattedTextField();
        kdtEntrys_qc4lv1Qty_TextField.setName("kdtEntrys_qc4lv1Qty_TextField");
        kdtEntrys_qc4lv1Qty_TextField.setVisible(true);
        kdtEntrys_qc4lv1Qty_TextField.setEditable(true);
        kdtEntrys_qc4lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qc4lv1Qty_TextField.setDataType(1);
        	kdtEntrys_qc4lv1Qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qc4lv1Qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qc4lv1Qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qc4lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qc4lv1Qty_TextField);
        this.kdtEntrys.getColumn("qc4lv1Qty").setEditor(kdtEntrys_qc4lv1Qty_CellEditor);
        KDFormattedTextField kdtEntrys_qc5lv2Qty_TextField = new KDFormattedTextField();
        kdtEntrys_qc5lv2Qty_TextField.setName("kdtEntrys_qc5lv2Qty_TextField");
        kdtEntrys_qc5lv2Qty_TextField.setVisible(true);
        kdtEntrys_qc5lv2Qty_TextField.setEditable(true);
        kdtEntrys_qc5lv2Qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qc5lv2Qty_TextField.setDataType(1);
        	kdtEntrys_qc5lv2Qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qc5lv2Qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qc5lv2Qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qc5lv2Qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qc5lv2Qty_TextField);
        this.kdtEntrys.getColumn("qc5lv2Qty").setEditor(kdtEntrys_qc5lv2Qty_CellEditor);
        KDFormattedTextField kdtEntrys_qc6lv2Qty_TextField = new KDFormattedTextField();
        kdtEntrys_qc6lv2Qty_TextField.setName("kdtEntrys_qc6lv2Qty_TextField");
        kdtEntrys_qc6lv2Qty_TextField.setVisible(true);
        kdtEntrys_qc6lv2Qty_TextField.setEditable(true);
        kdtEntrys_qc6lv2Qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qc6lv2Qty_TextField.setDataType(1);
        	kdtEntrys_qc6lv2Qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qc6lv2Qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qc6lv2Qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qc6lv2Qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qc6lv2Qty_TextField);
        this.kdtEntrys.getColumn("qc6lv2Qty").setEditor(kdtEntrys_qc6lv2Qty_CellEditor);
        KDFormattedTextField kdtEntrys_greensQty_TextField = new KDFormattedTextField();
        kdtEntrys_greensQty_TextField.setName("kdtEntrys_greensQty_TextField");
        kdtEntrys_greensQty_TextField.setVisible(true);
        kdtEntrys_greensQty_TextField.setEditable(true);
        kdtEntrys_greensQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_greensQty_TextField.setDataType(1);
        	kdtEntrys_greensQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_greensQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_greensQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_greensQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_greensQty_TextField);
        this.kdtEntrys.getColumn("greensQty").setEditor(kdtEntrys_greensQty_CellEditor);
        KDFormattedTextField kdtEntrys_dirtyQty_TextField = new KDFormattedTextField();
        kdtEntrys_dirtyQty_TextField.setName("kdtEntrys_dirtyQty_TextField");
        kdtEntrys_dirtyQty_TextField.setVisible(true);
        kdtEntrys_dirtyQty_TextField.setEditable(true);
        kdtEntrys_dirtyQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_dirtyQty_TextField.setDataType(1);
        	kdtEntrys_dirtyQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_dirtyQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_dirtyQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_dirtyQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dirtyQty_TextField);
        this.kdtEntrys.getColumn("dirtyQty").setEditor(kdtEntrys_dirtyQty_CellEditor);
        KDFormattedTextField kdtEntrys_doubleQty_TextField = new KDFormattedTextField();
        kdtEntrys_doubleQty_TextField.setName("kdtEntrys_doubleQty_TextField");
        kdtEntrys_doubleQty_TextField.setVisible(true);
        kdtEntrys_doubleQty_TextField.setEditable(true);
        kdtEntrys_doubleQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_doubleQty_TextField.setDataType(1);
        	kdtEntrys_doubleQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_doubleQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_doubleQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_doubleQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_doubleQty_TextField);
        this.kdtEntrys.getColumn("doubleQty").setEditor(kdtEntrys_doubleQty_CellEditor);
        KDFormattedTextField kdtEntrys_mutantQty_TextField = new KDFormattedTextField();
        kdtEntrys_mutantQty_TextField.setName("kdtEntrys_mutantQty_TextField");
        kdtEntrys_mutantQty_TextField.setVisible(true);
        kdtEntrys_mutantQty_TextField.setEditable(true);
        kdtEntrys_mutantQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_mutantQty_TextField.setDataType(1);
        	kdtEntrys_mutantQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_mutantQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_mutantQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_mutantQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_mutantQty_TextField);
        this.kdtEntrys.getColumn("mutantQty").setEditor(kdtEntrys_mutantQty_CellEditor);
        KDFormattedTextField kdtEntrys_tinyEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_tinyEggQty_TextField.setName("kdtEntrys_tinyEggQty_TextField");
        kdtEntrys_tinyEggQty_TextField.setVisible(true);
        kdtEntrys_tinyEggQty_TextField.setEditable(true);
        kdtEntrys_tinyEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_tinyEggQty_TextField.setDataType(1);
        	kdtEntrys_tinyEggQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_tinyEggQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_tinyEggQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_tinyEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_tinyEggQty_TextField);
        this.kdtEntrys.getColumn("tinyEggQty").setEditor(kdtEntrys_tinyEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_brokenSingeQty_TextField = new KDFormattedTextField();
        kdtEntrys_brokenSingeQty_TextField.setName("kdtEntrys_brokenSingeQty_TextField");
        kdtEntrys_brokenSingeQty_TextField.setVisible(true);
        kdtEntrys_brokenSingeQty_TextField.setEditable(true);
        kdtEntrys_brokenSingeQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_brokenSingeQty_TextField.setDataType(1);
        	kdtEntrys_brokenSingeQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_brokenSingeQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_brokenSingeQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_brokenSingeQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_brokenSingeQty_TextField);
        this.kdtEntrys.getColumn("brokenSingeQty").setEditor(kdtEntrys_brokenSingeQty_CellEditor);
        KDFormattedTextField kdtEntrys_flowQty_TextField = new KDFormattedTextField();
        kdtEntrys_flowQty_TextField.setName("kdtEntrys_flowQty_TextField");
        kdtEntrys_flowQty_TextField.setVisible(true);
        kdtEntrys_flowQty_TextField.setEditable(true);
        kdtEntrys_flowQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_flowQty_TextField.setDataType(1);
        	kdtEntrys_flowQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_flowQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_flowQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_flowQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_flowQty_TextField);
        this.kdtEntrys.getColumn("flowQty").setEditor(kdtEntrys_flowQty_CellEditor);
        KDFormattedTextField kdtEntrys_brokenDoubleQty_TextField = new KDFormattedTextField();
        kdtEntrys_brokenDoubleQty_TextField.setName("kdtEntrys_brokenDoubleQty_TextField");
        kdtEntrys_brokenDoubleQty_TextField.setVisible(true);
        kdtEntrys_brokenDoubleQty_TextField.setEditable(true);
        kdtEntrys_brokenDoubleQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_brokenDoubleQty_TextField.setDataType(1);
        	kdtEntrys_brokenDoubleQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_brokenDoubleQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_brokenDoubleQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_brokenDoubleQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_brokenDoubleQty_TextField);
        this.kdtEntrys.getColumn("brokenDoubleQty").setEditor(kdtEntrys_brokenDoubleQty_CellEditor);
        KDFormattedTextField kdtEntrys_qcRateFarmer_TextField = new KDFormattedTextField();
        kdtEntrys_qcRateFarmer_TextField.setName("kdtEntrys_qcRateFarmer_TextField");
        kdtEntrys_qcRateFarmer_TextField.setVisible(true);
        kdtEntrys_qcRateFarmer_TextField.setEditable(true);
        kdtEntrys_qcRateFarmer_TextField.setHorizontalAlignment(2);
        kdtEntrys_qcRateFarmer_TextField.setDataType(1);
        	kdtEntrys_qcRateFarmer_TextField.setMinimumValue(new java.math.BigDecimal("-999.99"));
        	kdtEntrys_qcRateFarmer_TextField.setMaximumValue(new java.math.BigDecimal("999.99"));
        kdtEntrys_qcRateFarmer_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_qcRateFarmer_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qcRateFarmer_TextField);
        this.kdtEntrys.getColumn("qcRateFarmer").setEditor(kdtEntrys_qcRateFarmer_CellEditor);
        KDFormattedTextField kdtEntrys_qcRateWorkshop_TextField = new KDFormattedTextField();
        kdtEntrys_qcRateWorkshop_TextField.setName("kdtEntrys_qcRateWorkshop_TextField");
        kdtEntrys_qcRateWorkshop_TextField.setVisible(true);
        kdtEntrys_qcRateWorkshop_TextField.setEditable(true);
        kdtEntrys_qcRateWorkshop_TextField.setHorizontalAlignment(2);
        kdtEntrys_qcRateWorkshop_TextField.setDataType(1);
        	kdtEntrys_qcRateWorkshop_TextField.setMinimumValue(new java.math.BigDecimal("-999.99"));
        	kdtEntrys_qcRateWorkshop_TextField.setMaximumValue(new java.math.BigDecimal("999.99"));
        kdtEntrys_qcRateWorkshop_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_qcRateWorkshop_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qcRateWorkshop_TextField);
        this.kdtEntrys.getColumn("qcRateWorkshop").setEditor(kdtEntrys_qcRateWorkshop_CellEditor);
        KDFormattedTextField kdtEntrys_hiddenRate_TextField = new KDFormattedTextField();
        kdtEntrys_hiddenRate_TextField.setName("kdtEntrys_hiddenRate_TextField");
        kdtEntrys_hiddenRate_TextField.setVisible(true);
        kdtEntrys_hiddenRate_TextField.setEditable(true);
        kdtEntrys_hiddenRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_hiddenRate_TextField.setDataType(1);
        	kdtEntrys_hiddenRate_TextField.setMinimumValue(new java.math.BigDecimal("-999.99"));
        	kdtEntrys_hiddenRate_TextField.setMaximumValue(new java.math.BigDecimal("999.99"));
        kdtEntrys_hiddenRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_hiddenRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_hiddenRate_TextField);
        this.kdtEntrys.getColumn("hiddenRate").setEditor(kdtEntrys_hiddenRate_CellEditor);
        KDFormattedTextField kdtEntrys_brokenRate_TextField = new KDFormattedTextField();
        kdtEntrys_brokenRate_TextField.setName("kdtEntrys_brokenRate_TextField");
        kdtEntrys_brokenRate_TextField.setVisible(true);
        kdtEntrys_brokenRate_TextField.setEditable(true);
        kdtEntrys_brokenRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_brokenRate_TextField.setDataType(1);
        	kdtEntrys_brokenRate_TextField.setMinimumValue(new java.math.BigDecimal("-999.99"));
        	kdtEntrys_brokenRate_TextField.setMaximumValue(new java.math.BigDecimal("999.99"));
        kdtEntrys_brokenRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_brokenRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_brokenRate_TextField);
        this.kdtEntrys.getColumn("brokenRate").setEditor(kdtEntrys_brokenRate_CellEditor);
        KDFormattedTextField kdtEntrys_diffQty_TextField = new KDFormattedTextField();
        kdtEntrys_diffQty_TextField.setName("kdtEntrys_diffQty_TextField");
        kdtEntrys_diffQty_TextField.setVisible(true);
        kdtEntrys_diffQty_TextField.setEditable(true);
        kdtEntrys_diffQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_diffQty_TextField.setDataType(1);
        	kdtEntrys_diffQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_diffQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_diffQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_diffQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_diffQty_TextField);
        this.kdtEntrys.getColumn("diffQty").setEditor(kdtEntrys_diffQty_CellEditor);
        final KDBizPromptBox kdtEntrys_warehouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_warehouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEntrys_warehouse_PromptBox.setVisible(true);
        kdtEntrys_warehouse_PromptBox.setEditable(true);
        kdtEntrys_warehouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_warehouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_warehouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_warehouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_warehouse_PromptBox);
        this.kdtEntrys.getColumn("warehouse").setEditor(kdtEntrys_warehouse_CellEditor);
        ObjectValueRender kdtEntrys_warehouse_OVR = new ObjectValueRender();
        kdtEntrys_warehouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("warehouse").setRenderer(kdtEntrys_warehouse_OVR);
        final KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
        kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_material_PromptBox.setVisible(true);
        kdtEntrys_material_PromptBox.setEditable(true);
        kdtEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_material_PromptBox.setEditFormat("$number$");
        kdtEntrys_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
        this.kdtEntrys.getColumn("material").setEditor(kdtEntrys_material_CellEditor);
        ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
        kdtEntrys_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("material").setRenderer(kdtEntrys_material_OVR);
        final KDBizPromptBox kdtEntrys_costItem_PromptBox = new KDBizPromptBox();
        kdtEntrys_costItem_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");
        kdtEntrys_costItem_PromptBox.setVisible(true);
        kdtEntrys_costItem_PromptBox.setEditable(true);
        kdtEntrys_costItem_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_costItem_PromptBox.setEditFormat("$number$");
        kdtEntrys_costItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_costItem_CellEditor = new KDTDefaultCellEditor(kdtEntrys_costItem_PromptBox);
        this.kdtEntrys.getColumn("costItem").setEditor(kdtEntrys_costItem_CellEditor);
        ObjectValueRender kdtEntrys_costItem_OVR = new ObjectValueRender();
        kdtEntrys_costItem_OVR.setFormat(new BizDataFormat("$relatedNumber$"));
        this.kdtEntrys.getColumn("costItem").setRenderer(kdtEntrys_costItem_OVR);
        KDTextField kdtEntrys_settleBillID_TextField = new KDTextField();
        kdtEntrys_settleBillID_TextField.setName("kdtEntrys_settleBillID_TextField");
        kdtEntrys_settleBillID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_settleBillID_CellEditor = new KDTDefaultCellEditor(kdtEntrys_settleBillID_TextField);
        this.kdtEntrys.getColumn("settleBillID").setEditor(kdtEntrys_settleBillID_CellEditor);
        KDCheckBox kdtEntrys_isExistDownBill_CheckBox = new KDCheckBox();
        kdtEntrys_isExistDownBill_CheckBox.setName("kdtEntrys_isExistDownBill_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isExistDownBill_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isExistDownBill_CheckBox);
        this.kdtEntrys.getColumn("isExistDownBill").setEditor(kdtEntrys_isExistDownBill_CellEditor);
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
        // chkisInit		
        this.chkisInit.setText(resHelper.getString("chkisInit.text"));		
        this.chkisInit.setHorizontalAlignment(2);
        // conteggSource		
        this.conteggSource.setBoundLabelText(resHelper.getString("conteggSource.boundLabelText"));		
        this.conteggSource.setBoundLabelLength(100);		
        this.conteggSource.setBoundLabelUnderline(true);		
        this.conteggSource.setVisible(true);
        // kdtPickDetail
		String kdtPickDetailStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"pickPerson\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol2\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{pickPerson}</t:Cell><t:Cell>$Resource{qty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPickDetail.setFormatXml(resHelper.translateString("kdtPickDetail",kdtPickDetailStrXML));

                this.kdtPickDetail.putBindContents("editData",new String[] {"PickDetail.seq","PickDetail.pickPerson","PickDetail.qty"});


        this.kdtPickDetail.checkParsed();
        final KDBizPromptBox kdtPickDetail_pickPerson_PromptBox = new KDBizPromptBox();
        kdtPickDetail_pickPerson_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtPickDetail_pickPerson_PromptBox.setVisible(true);
        kdtPickDetail_pickPerson_PromptBox.setEditable(true);
        kdtPickDetail_pickPerson_PromptBox.setDisplayFormat("$number$");
        kdtPickDetail_pickPerson_PromptBox.setEditFormat("$number$");
        kdtPickDetail_pickPerson_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPickDetail_pickPerson_CellEditor = new KDTDefaultCellEditor(kdtPickDetail_pickPerson_PromptBox);
        this.kdtPickDetail.getColumn("pickPerson").setEditor(kdtPickDetail_pickPerson_CellEditor);
        ObjectValueRender kdtPickDetail_pickPerson_OVR = new ObjectValueRender();
        kdtPickDetail_pickPerson_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPickDetail.getColumn("pickPerson").setRenderer(kdtPickDetail_pickPerson_OVR);
        KDFormattedTextField kdtPickDetail_qty_TextField = new KDFormattedTextField();
        kdtPickDetail_qty_TextField.setName("kdtPickDetail_qty_TextField");
        kdtPickDetail_qty_TextField.setVisible(true);
        kdtPickDetail_qty_TextField.setEditable(true);
        kdtPickDetail_qty_TextField.setHorizontalAlignment(2);
        kdtPickDetail_qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtPickDetail_qty_CellEditor = new KDTDefaultCellEditor(kdtPickDetail_qty_TextField);
        this.kdtPickDetail.getColumn("qty").setEditor(kdtPickDetail_qty_CellEditor);
        // contAddRows		
        this.contAddRows.setBoundLabelText(resHelper.getString("contAddRows.boundLabelText"));		
        this.contAddRows.setBoundLabelLength(100);		
        this.contAddRows.setBoundLabelUnderline(true);		
        this.contAddRows.setVisible(true);
        // btnAddRows		
        this.btnAddRows.setText(resHelper.getString("btnAddRows.text"));
        // btnRefresh		
        this.btnRefresh.setText(resHelper.getString("btnRefresh.text"));
        this.btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    btnRefresh_mouseClick(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // chkhasTakeAway		
        this.chkhasTakeAway.setText(resHelper.getString("chkhasTakeAway.text"));		
        this.chkhasTakeAway.setHorizontalAlignment(2);		
        this.chkhasTakeAway.setVisible(false);
        // contincubation		
        this.contincubation.setBoundLabelText(resHelper.getString("contincubation.boundLabelText"));		
        this.contincubation.setBoundLabelLength(100);		
        this.contincubation.setBoundLabelUnderline(true);		
        this.contincubation.setVisible(true);
        // chkisManuMin		
        this.chkisManuMin.setText(resHelper.getString("chkisManuMin.text"));		
        this.chkisManuMin.setVisible(true);		
        this.chkisManuMin.setHorizontalAlignment(2);		
        this.chkisManuMin.setEnabled(false);
        // chkisOtherIn		
        this.chkisOtherIn.setText(resHelper.getString("chkisOtherIn.text"));		
        this.chkisOtherIn.setVisible(true);		
        this.chkisOtherIn.setHorizontalAlignment(2);		
        this.chkisOtherIn.setEnabled(false);
        // chkisBatchTrans		
        this.chkisBatchTrans.setText(resHelper.getString("chkisBatchTrans.text"));		
        this.chkisBatchTrans.setVisible(true);		
        this.chkisBatchTrans.setHorizontalAlignment(2);		
        this.chkisBatchTrans.setEnabled(false);
        // prmtCreator		
        this.prmtCreator.setEnabled(false);
        // kDDateCreateTime		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // pkBizDate		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtstorageOrgUnit		
        this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrgUnit.setEditable(true);		
        this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtstorageOrgUnit.setEditFormat("$number$");		
        this.prmtstorageOrgUnit.setCommitFormat("$number$");		
        this.prmtstorageOrgUnit.setRequired(true);
        // eggSource		
        this.eggSource.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggSourceType").toArray());		
        this.eggSource.setRequired(false);
        // txtAddRows		
        this.txtAddRows.setHorizontalAlignment(2);		
        this.txtAddRows.setDataType(0);		
        this.txtAddRows.setSupportedEmpty(true);		
        this.txtAddRows.setRequired(false);
        // prmtincubation		
        this.prmtincubation.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchBaseDataQuery");		
        this.prmtincubation.setVisible(true);		
        this.prmtincubation.setEditable(true);		
        this.prmtincubation.setDisplayFormat("$name$");		
        this.prmtincubation.setEditFormat("$number$");		
        this.prmtincubation.setCommitFormat("$number$");		
        this.prmtincubation.setRequired(true);
        		prmtincubation.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchBaseDataListUI prmtincubation_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtincubation_F7ListUI == null) {
					try {
						prmtincubation_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchBaseDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtincubation_F7ListUI));
					prmtincubation_F7ListUI.setF7Use(true,ctx);
					prmtincubation.setSelector(prmtincubation_F7ListUI);
				}
			}
		});
					
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // btnDelDownBill
        this.btnDelDownBill.setAction((IItemAction)ActionProxyFactory.getProxy(actionDeleteDownBill, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnDelDownBill.setText(resHelper.getString("btnDelDownBill.text"));
        // toSettleBill
        this.toSettleBill.setAction((IItemAction)ActionProxyFactory.getProxy(actionToSettleBill, new Class[] { IItemAction.class }, getServiceContext()));		
        this.toSettleBill.setText(resHelper.getString("toSettleBill.text"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        // newSeparator3
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kdtPickDetail,txtAddRows,txtNumber,pkBizDate,prmtstorageOrgUnit,txtDescription,billStatus,prmtcompany,pkauditTime,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,chkisInit,eggSource,chkhasTakeAway,kdtEntrys,prmtincubation,chkisManuMin,chkisOtherIn,chkisBatchTrans}));
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
        contCreator.setBounds(new Rectangle(371, 570, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(371, 570, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(721, 570, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(721, 570, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(371, 598, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(371, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(721, 598, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(721, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(22, 9, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(22, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(371, 9, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(371, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(722, 30, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(722, 30, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(29, 570, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(29, 570, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(722, 9, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(722, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(22, 30, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(22, 30, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(29, 598, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(29, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(18, 566, 963, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(18, 566, 963, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(6, 76, 986, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(6, 76, 986, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtEntrys.setBounds(new Rectangle(22, 111, 970, 310));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(22, 111, 970, 310, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
		vo.put("farmerGroup","GrandParent");
vo.put("statisticsType",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contstorageOrgUnit.setBounds(new Rectangle(371, 30, 270, 19));
        this.add(contstorageOrgUnit, new KDLayout.Constraints(371, 30, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisInit.setBounds(new Rectangle(722, 54, 270, 19));
        this.add(chkisInit, new KDLayout.Constraints(722, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conteggSource.setBounds(new Rectangle(22, 54, 270, 19));
        this.add(conteggSource, new KDLayout.Constraints(22, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtPickDetail.setBounds(new Rectangle(22, 426, 969, 135));
        kdtPickDetail_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtPickDetail,new com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryPickDetailInfo(),null,false);
        this.add(kdtPickDetail_detailPanel, new KDLayout.Constraints(22, 426, 969, 135, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contAddRows.setBounds(new Rectangle(681, 84, 224, 19));
        this.add(contAddRows, new KDLayout.Constraints(681, 84, 224, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnAddRows.setBounds(new Rectangle(917, 84, 73, 21));
        this.add(btnAddRows, new KDLayout.Constraints(917, 84, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnRefresh.setBounds(new Rectangle(568, 86, 73, 21));
        this.add(btnRefresh, new KDLayout.Constraints(568, 86, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkhasTakeAway.setBounds(new Rectangle(582, 55, 48, 19));
        this.add(chkhasTakeAway, new KDLayout.Constraints(582, 55, 48, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contincubation.setBounds(new Rectangle(373, 54, 270, 19));
        this.add(contincubation, new KDLayout.Constraints(373, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisManuMin.setBounds(new Rectangle(22, 82, 144, 19));
        this.add(chkisManuMin, new KDLayout.Constraints(22, 82, 144, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisOtherIn.setBounds(new Rectangle(195, 82, 122, 19));
        this.add(chkisOtherIn, new KDLayout.Constraints(195, 82, 122, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisBatchTrans.setBounds(new Rectangle(373, 82, 164, 19));
        this.add(chkisBatchTrans, new KDLayout.Constraints(373, 82, 164, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contstorageOrgUnit
        contstorageOrgUnit.setBoundEditor(prmtstorageOrgUnit);
        //conteggSource
        conteggSource.setBoundEditor(eggSource);
        //contAddRows
        contAddRows.setBoundEditor(txtAddRows);
        //contincubation
        contincubation.setBoundEditor(prmtincubation);

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
        menuBiz.add(newSeparator3);
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(menuItemDelPCVoucher);
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
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
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
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnDelDownBill);
        this.toolBar.add(toSettleBill);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.warehouse", java.lang.Object.class, this.kdtEntrys, "warehouse.text");
		dataBinder.registerBinding("entrys.farmer", java.lang.Object.class, this.kdtEntrys, "farmer.text");
		dataBinder.registerBinding("entrys.farm", java.lang.Object.class, this.kdtEntrys, "farm.text");
		dataBinder.registerBinding("entrys.stockingBatch", java.lang.Object.class, this.kdtEntrys, "stockingBatch.text");
		dataBinder.registerBinding("entrys.brokenQty", java.math.BigDecimal.class, this.kdtEntrys, "brokenQty.text");
		dataBinder.registerBinding("entrys.allQty", java.math.BigDecimal.class, this.kdtEntrys, "allQty.text");
		dataBinder.registerBinding("entrys.effectAllQty", java.math.BigDecimal.class, this.kdtEntrys, "effectAllQty.text");
		dataBinder.registerBinding("entrys.qc1lv1Qty", java.math.BigDecimal.class, this.kdtEntrys, "qc1lv1Qty.text");
		dataBinder.registerBinding("entrys.qc1lv2Qty", java.math.BigDecimal.class, this.kdtEntrys, "qc1lv2Qty.text");
		dataBinder.registerBinding("entrys.qc2lv2Qty", java.math.BigDecimal.class, this.kdtEntrys, "qc2lv2Qty.text");
		dataBinder.registerBinding("entrys.qc2lv1Qty", java.math.BigDecimal.class, this.kdtEntrys, "qc2lv1Qty.text");
		dataBinder.registerBinding("entrys.qc3lv1Qty", java.math.BigDecimal.class, this.kdtEntrys, "qc3lv1Qty.text");
		dataBinder.registerBinding("entrys.qc4lv1Qty", java.math.BigDecimal.class, this.kdtEntrys, "qc4lv1Qty.text");
		dataBinder.registerBinding("entrys.qc5lv2Qty", java.math.BigDecimal.class, this.kdtEntrys, "qc5lv2Qty.text");
		dataBinder.registerBinding("entrys.qc6lv2Qty", java.math.BigDecimal.class, this.kdtEntrys, "qc6lv2Qty.text");
		dataBinder.registerBinding("entrys.greensQty", java.math.BigDecimal.class, this.kdtEntrys, "greensQty.text");
		dataBinder.registerBinding("entrys.dirtyQty", java.math.BigDecimal.class, this.kdtEntrys, "dirtyQty.text");
		dataBinder.registerBinding("entrys.doubleQty", java.math.BigDecimal.class, this.kdtEntrys, "doubleQty.text");
		dataBinder.registerBinding("entrys.mutantQty", java.math.BigDecimal.class, this.kdtEntrys, "mutantQty.text");
		dataBinder.registerBinding("entrys.brokenSingeQty", java.math.BigDecimal.class, this.kdtEntrys, "brokenSingeQty.text");
		dataBinder.registerBinding("entrys.flowQty", java.math.BigDecimal.class, this.kdtEntrys, "flowQty.text");
		dataBinder.registerBinding("entrys.brokenDoubleQty", java.math.BigDecimal.class, this.kdtEntrys, "brokenDoubleQty.text");
		dataBinder.registerBinding("entrys.qcRateFarmer", java.math.BigDecimal.class, this.kdtEntrys, "qcRateFarmer.text");
		dataBinder.registerBinding("entrys.qcRateWorkshop", java.math.BigDecimal.class, this.kdtEntrys, "qcRateWorkshop.text");
		dataBinder.registerBinding("entrys.hiddenRate", java.math.BigDecimal.class, this.kdtEntrys, "hiddenRate.text");
		dataBinder.registerBinding("entrys.brokenRate", java.math.BigDecimal.class, this.kdtEntrys, "brokenRate.text");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.costItem", java.lang.Object.class, this.kdtEntrys, "costItem.text");
		dataBinder.registerBinding("entrys.internalFarm", java.lang.Object.class, this.kdtEntrys, "internalFarm.text");
		dataBinder.registerBinding("entrys.internalBatch", java.lang.Object.class, this.kdtEntrys, "internalBatch.text");
		dataBinder.registerBinding("entrys.supplier", java.lang.Object.class, this.kdtEntrys, "supplier.text");
		dataBinder.registerBinding("entrys.unit", java.lang.Object.class, this.kdtEntrys, "unit.text");
		dataBinder.registerBinding("entrys.statisticsType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "statisticsType.text");
		dataBinder.registerBinding("entrys.weekAge", String.class, this.kdtEntrys, "weekAge.text");
		dataBinder.registerBinding("entrys.dayAge", int.class, this.kdtEntrys, "dayAge.text");
		dataBinder.registerBinding("entrys.isFormal", boolean.class, this.kdtEntrys, "isFormal.text");
		dataBinder.registerBinding("entrys.sendDate", java.util.Date.class, this.kdtEntrys, "sendDate.text");
		dataBinder.registerBinding("entrys.sendAllQty", java.math.BigDecimal.class, this.kdtEntrys, "sendAllQty.text");
		dataBinder.registerBinding("entrys.diffQty", java.math.BigDecimal.class, this.kdtEntrys, "diffQty.text");
		dataBinder.registerBinding("entrys.house", java.lang.Object.class, this.kdtEntrys, "house.text");
		dataBinder.registerBinding("entrys.farmerGroup", String.class, this.kdtEntrys, "farmerGroup.text");
		dataBinder.registerBinding("entrys.lot", String.class, this.kdtEntrys, "lot.text");
		dataBinder.registerBinding("entrys.settleBillID", String.class, this.kdtEntrys, "settleBillID.text");
		dataBinder.registerBinding("entrys.isExistDownBill", boolean.class, this.kdtEntrys, "isExistDownBill.text");
		dataBinder.registerBinding("entrys.genderType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "genderType.text");
		dataBinder.registerBinding("entrys.tinyEggQty", java.math.BigDecimal.class, this.kdtEntrys, "tinyEggQty.text");
		dataBinder.registerBinding("entrys.wrongSharpEgg", java.math.BigDecimal.class, this.kdtEntrys, "wrongSharpEgg.text");
		dataBinder.registerBinding("entrys.eggLiquid", java.math.BigDecimal.class, this.kdtEntrys, "eggLiquid.text");
		dataBinder.registerBinding("isInit", boolean.class, this.chkisInit, "selected");
		dataBinder.registerBinding("entrys.PickDetail.seq", int.class, this.kdtPickDetail, "seq.text");
		dataBinder.registerBinding("entrys.PickDetail", com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryPickDetailInfo.class, this.kdtPickDetail, "userObject");
		dataBinder.registerBinding("entrys.PickDetail.pickPerson", java.lang.Object.class, this.kdtPickDetail, "pickPerson.text");
		dataBinder.registerBinding("entrys.PickDetail.qty", int.class, this.kdtPickDetail, "qty.text");
		dataBinder.registerBinding("hasTakeAway", boolean.class, this.chkhasTakeAway, "selected");
		dataBinder.registerBinding("isManuMin", boolean.class, this.chkisManuMin, "selected");
		dataBinder.registerBinding("isOtherIn", boolean.class, this.chkisOtherIn, "selected");
		dataBinder.registerBinding("isBatchTrans", boolean.class, this.chkisBatchTrans, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrgUnit, "data");
		dataBinder.registerBinding("eggSource", com.kingdee.eas.farm.hatch.EggSourceType.class, this.eggSource, "selectedItem");
		dataBinder.registerBinding("BIMUDF0129", int.class, this.txtAddRows, "value");
		dataBinder.registerBinding("incubation", com.kingdee.eas.farm.hatch.HatchBaseDataInfo.class, this.prmtincubation, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.hatch.app.EggReceiveBillEditUIHandler";
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
        this.kdtPickDetail.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.warehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.stockingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.brokenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.allQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.effectAllQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qc1lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qc1lv2Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qc2lv2Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qc2lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qc3lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qc4lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qc5lv2Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qc6lv2Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.greensQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dirtyQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.doubleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.mutantQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.brokenSingeQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.flowQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.brokenDoubleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qcRateFarmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qcRateWorkshop", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hiddenRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.brokenRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.costItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.internalFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.internalBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.statisticsType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.weekAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dayAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isFormal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sendDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sendAllQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.diffQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farmerGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lot", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.settleBillID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isExistDownBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.genderType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.tinyEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wrongSharpEgg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.eggLiquid", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isInit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PickDetail.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PickDetail", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PickDetail.pickPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PickDetail.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hasTakeAway", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isManuMin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isOtherIn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isBatchTrans", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggSource", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0129", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("incubation", ValidateHelper.ON_SAVE);    		
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
     * output btnRefresh_mouseClick method
     */
    protected void btnRefresh_mouseClick(java.awt.event.MouseEvent e) throws Exception
    {
    }


    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("farmer".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"farmerGroup").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"farmer").getValue(),"treeid.name")));

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
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.warehouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.warehouse.id"));
			sic.add(new SelectorItemInfo("entrys.warehouse.name"));
        	sic.add(new SelectorItemInfo("entrys.warehouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.farmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.farmer.id"));
			sic.add(new SelectorItemInfo("entrys.farmer.name"));
        	sic.add(new SelectorItemInfo("entrys.farmer.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.farm.id"));
			sic.add(new SelectorItemInfo("entrys.farm.name"));
        	sic.add(new SelectorItemInfo("entrys.farm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.stockingBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.stockingBatch.id"));
			sic.add(new SelectorItemInfo("entrys.stockingBatch.number"));
			sic.add(new SelectorItemInfo("entrys.stockingBatch.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.brokenQty"));
    	sic.add(new SelectorItemInfo("entrys.allQty"));
    	sic.add(new SelectorItemInfo("entrys.effectAllQty"));
    	sic.add(new SelectorItemInfo("entrys.qc1lv1Qty"));
    	sic.add(new SelectorItemInfo("entrys.qc1lv2Qty"));
    	sic.add(new SelectorItemInfo("entrys.qc2lv2Qty"));
    	sic.add(new SelectorItemInfo("entrys.qc2lv1Qty"));
    	sic.add(new SelectorItemInfo("entrys.qc3lv1Qty"));
    	sic.add(new SelectorItemInfo("entrys.qc4lv1Qty"));
    	sic.add(new SelectorItemInfo("entrys.qc5lv2Qty"));
    	sic.add(new SelectorItemInfo("entrys.qc6lv2Qty"));
    	sic.add(new SelectorItemInfo("entrys.greensQty"));
    	sic.add(new SelectorItemInfo("entrys.dirtyQty"));
    	sic.add(new SelectorItemInfo("entrys.doubleQty"));
    	sic.add(new SelectorItemInfo("entrys.mutantQty"));
    	sic.add(new SelectorItemInfo("entrys.brokenSingeQty"));
    	sic.add(new SelectorItemInfo("entrys.flowQty"));
    	sic.add(new SelectorItemInfo("entrys.brokenDoubleQty"));
    	sic.add(new SelectorItemInfo("entrys.qcRateFarmer"));
    	sic.add(new SelectorItemInfo("entrys.qcRateWorkshop"));
    	sic.add(new SelectorItemInfo("entrys.hiddenRate"));
    	sic.add(new SelectorItemInfo("entrys.brokenRate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.material.id"));
			sic.add(new SelectorItemInfo("entrys.material.name"));
        	sic.add(new SelectorItemInfo("entrys.material.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.costItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.costItem.id"));
			sic.add(new SelectorItemInfo("entrys.costItem.relatedNumber"));
			sic.add(new SelectorItemInfo("entrys.costItem.name"));
        	sic.add(new SelectorItemInfo("entrys.costItem.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.internalFarm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.internalFarm.id"));
			sic.add(new SelectorItemInfo("entrys.internalFarm.name"));
        	sic.add(new SelectorItemInfo("entrys.internalFarm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.internalBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.internalBatch.id"));
			sic.add(new SelectorItemInfo("entrys.internalBatch.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.supplier.id"));
			sic.add(new SelectorItemInfo("entrys.supplier.name"));
        	sic.add(new SelectorItemInfo("entrys.supplier.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.unit.id"));
			sic.add(new SelectorItemInfo("entrys.unit.name"));
        	sic.add(new SelectorItemInfo("entrys.unit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.statisticsType"));
    	sic.add(new SelectorItemInfo("entrys.weekAge"));
    	sic.add(new SelectorItemInfo("entrys.dayAge"));
    	sic.add(new SelectorItemInfo("entrys.isFormal"));
    	sic.add(new SelectorItemInfo("entrys.sendDate"));
    	sic.add(new SelectorItemInfo("entrys.sendAllQty"));
    	sic.add(new SelectorItemInfo("entrys.diffQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.house.id"));
			sic.add(new SelectorItemInfo("entrys.house.name"));
        	sic.add(new SelectorItemInfo("entrys.house.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.farmerGroup"));
    	sic.add(new SelectorItemInfo("entrys.lot"));
    	sic.add(new SelectorItemInfo("entrys.settleBillID"));
    	sic.add(new SelectorItemInfo("entrys.isExistDownBill"));
    	sic.add(new SelectorItemInfo("entrys.genderType"));
    	sic.add(new SelectorItemInfo("entrys.tinyEggQty"));
    	sic.add(new SelectorItemInfo("entrys.wrongSharpEgg"));
    	sic.add(new SelectorItemInfo("entrys.eggLiquid"));
        sic.add(new SelectorItemInfo("isInit"));
    	sic.add(new SelectorItemInfo("entrys.PickDetail.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.PickDetail.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.PickDetail.id"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.PickDetail.pickPerson.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.PickDetail.pickPerson.id"));
			sic.add(new SelectorItemInfo("entrys.PickDetail.pickPerson.name"));
        	sic.add(new SelectorItemInfo("entrys.PickDetail.pickPerson.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.PickDetail.qty"));
        sic.add(new SelectorItemInfo("hasTakeAway"));
        sic.add(new SelectorItemInfo("isManuMin"));
        sic.add(new SelectorItemInfo("isOtherIn"));
        sic.add(new SelectorItemInfo("isBatchTrans"));
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
        sic.add(new SelectorItemInfo("billStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("eggSource"));
        sic.add(new SelectorItemInfo("BIMUDF0129"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("incubation.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("incubation.id"));
        	sic.add(new SelectorItemInfo("incubation.number"));
        	sic.add(new SelectorItemInfo("incubation.name"));
		}
        return sic;
    }        
    	

    /**
     * output actionSubmit_actionPerformed method
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }
    	

    /**
     * output actionPrint_actionPerformed method
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
    	if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionPrintPreview_actionPerformed method
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
        if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.hatch.EggReceiveBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.hatch.EggReceiveBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionShowPriceCol_actionPerformed method
     */
    public void actionShowPriceCol_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.hatch.EggReceiveBillFactory.getRemoteInstance().showPriceCol(editData);
    }
    	

    /**
     * output actionViewAllBill_actionPerformed method
     */
    public void actionViewAllBill_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.hatch.EggReceiveBillFactory.getRemoteInstance().viewAllBill(editData);
    }
    	

    /**
     * output actionDeleteDownBill_actionPerformed method
     */
    public void actionDeleteDownBill_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.hatch.EggReceiveBillFactory.getRemoteInstance().deleteDownBill(editData);
    }
    	

    /**
     * output actionToSettleBill_actionPerformed method
     */
    public void actionToSettleBill_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.hatch.EggReceiveBillFactory.getRemoteInstance().toSettleBill(editData);
    }
    	

    /**
     * output actionSetColor_actionPerformed method
     */
    public void actionSetColor_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.hatch.EggReceiveBillFactory.getRemoteInstance().setColor(editData);
    }
	public RequestContext prepareActionSubmit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionSubmit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSubmit() {
    	return false;
    }
	public RequestContext prepareActionPrint(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrint(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrint() {
    	return false;
    }
	public RequestContext prepareActionPrintPreview(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrintPreview(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrintPreview() {
    	return false;
    }
	public RequestContext prepareActionAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAudit() {
    	return false;
    }
	public RequestContext prepareActionUnAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnAudit() {
    	return false;
    }
	public RequestContext prepareActionShowPriceCol(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionShowPriceCol() {
    	return false;
    }
	public RequestContext prepareActionViewAllBill(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionViewAllBill() {
    	return false;
    }
	public RequestContext prepareActionDeleteDownBill(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionDeleteDownBill() {
    	return false;
    }
	public RequestContext prepareActionToSettleBill(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionToSettleBill() {
    	return false;
    }
	public RequestContext prepareActionSetColor(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSetColor() {
    	return false;
    }

    /**
     * output ActionAudit class
     */     
    protected class ActionAudit extends ItemAction {     
    
        public ActionAudit()
        {
            this(null);
        }

        public ActionAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractEggReceiveBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionUnAudit class
     */     
    protected class ActionUnAudit extends ItemAction {     
    
        public ActionUnAudit()
        {
            this(null);
        }

        public ActionUnAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUnAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractEggReceiveBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionShowPriceCol class
     */     
    protected class ActionShowPriceCol extends ItemAction {     
    
        public ActionShowPriceCol()
        {
            this(null);
        }

        public ActionShowPriceCol(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionShowPriceCol.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionShowPriceCol.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionShowPriceCol.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractEggReceiveBillEditUI.this, "ActionShowPriceCol", "actionShowPriceCol_actionPerformed", e);
        }
    }

    /**
     * output ActionViewAllBill class
     */     
    protected class ActionViewAllBill extends ItemAction {     
    
        public ActionViewAllBill()
        {
            this(null);
        }

        public ActionViewAllBill(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionViewAllBill.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewAllBill.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewAllBill.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractEggReceiveBillEditUI.this, "ActionViewAllBill", "actionViewAllBill_actionPerformed", e);
        }
    }

    /**
     * output ActionDeleteDownBill class
     */     
    protected class ActionDeleteDownBill extends ItemAction {     
    
        public ActionDeleteDownBill()
        {
            this(null);
        }

        public ActionDeleteDownBill(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionDeleteDownBill.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionDeleteDownBill.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionDeleteDownBill.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractEggReceiveBillEditUI.this, "ActionDeleteDownBill", "actionDeleteDownBill_actionPerformed", e);
        }
    }

    /**
     * output ActionToSettleBill class
     */     
    protected class ActionToSettleBill extends ItemAction {     
    
        public ActionToSettleBill()
        {
            this(null);
        }

        public ActionToSettleBill(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionToSettleBill.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionToSettleBill.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionToSettleBill.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractEggReceiveBillEditUI.this, "ActionToSettleBill", "actionToSettleBill_actionPerformed", e);
        }
    }

    /**
     * output ActionSetColor class
     */     
    protected class ActionSetColor extends ItemAction {     
    
        public ActionSetColor()
        {
            this(null);
        }

        public ActionSetColor(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionSetColor.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSetColor.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSetColor.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractEggReceiveBillEditUI.this, "ActionSetColor", "actionSetColor_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.hatch.client", "EggReceiveBillEditUI");
    }
    /**
     * output isBindWorkFlow method
     */
    public boolean isBindWorkFlow()
    {
        return true;
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.stocking.hatch.client.EggReceiveBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.hatch.EggReceiveBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo objectValue = new com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/stocking/hatch/EggReceiveBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.stocking.hatch.app.EggReceiveBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"farm").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
			}
		}
		for (int i=0,n=kdtPickDetail.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtPickDetail.getCell(i,"pickPerson").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"挑选人"});
			}
		}
		for (int i=0,n=kdtPickDetail.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtPickDetail.getCell(i,"qty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"挑选蛋数"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstorageOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"库存组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtincubation.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"孵化厂"});
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
		vo.put("billStatus",new Integer(-1));
vo.put("eggSource",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}        
				protected void setTableToSumField() {
			setTableToSumField(kdtEntrys,new String[] {"effectAllQty","brokenQty","wrongSharpEgg","diffQty"});
		}


}