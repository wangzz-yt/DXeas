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
public abstract class AbstractEggSettleBillCompanyEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractEggSettleBillCompanyEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisInit;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPriceEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtPriceEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contamount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompensateAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpaymentAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchEndDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbyProductAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdestCompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggSource;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplier;
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
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtamount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcompensateAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpaymentAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherAmount;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkhatchBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkhatchEndDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbyProductAmount;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdestCompany;
    protected com.kingdee.bos.ctrl.swing.KDComboBox eggSource;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsupplier;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnExeSettle;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnExeSettle;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator3;
    protected com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionShowPriceCol actionShowPriceCol = null;
    protected ActionExeSettle actionExeSettle = null;
    /**
     * output class constructor
     */
    public AbstractEggSettleBillCompanyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractEggSettleBillCompanyEditUI.class.getName());
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
        //actionExeSettle
        this.actionExeSettle = new ActionExeSettle(this);
        getActionManager().registerAction("actionExeSettle", actionExeSettle);
        this.actionExeSettle.setExtendProperty("canForewarn", "true");
        this.actionExeSettle.setExtendProperty("userDefined", "false");
        this.actionExeSettle.setExtendProperty("isObjectUpdateLock", "false");
         this.actionExeSettle.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionExeSettle.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
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
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisInit = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtPriceEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contamount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompensateAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpaymentAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchBeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbyProductAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdestCompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsupplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.txtamount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcompensateAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpaymentAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkhatchBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkhatchEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtbyProductAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtdestCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.eggSource = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtsupplier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnExeSettle = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnExeSettle = new com.kingdee.bos.ctrl.swing.KDMenuItem();
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
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.chkisInit.setName("chkisInit");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtPriceEntry.setName("kdtPriceEntry");
        this.contamount.setName("contamount");
        this.contcompensateAmount.setName("contcompensateAmount");
        this.contpaymentAmount.setName("contpaymentAmount");
        this.contactualAmount.setName("contactualAmount");
        this.contotherAmount.setName("contotherAmount");
        this.conthatchBeginDate.setName("conthatchBeginDate");
        this.conthatchEndDate.setName("conthatchEndDate");
        this.contbyProductAmount.setName("contbyProductAmount");
        this.contdestCompany.setName("contdestCompany");
        this.conteggSource.setName("conteggSource");
        this.contsupplier.setName("contsupplier");
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
        this.txtamount.setName("txtamount");
        this.txtcompensateAmount.setName("txtcompensateAmount");
        this.txtpaymentAmount.setName("txtpaymentAmount");
        this.txtactualAmount.setName("txtactualAmount");
        this.txtotherAmount.setName("txtotherAmount");
        this.pkhatchBeginDate.setName("pkhatchBeginDate");
        this.pkhatchEndDate.setName("pkhatchEndDate");
        this.txtbyProductAmount.setName("txtbyProductAmount");
        this.prmtdestCompany.setName("prmtdestCompany");
        this.eggSource.setName("eggSource");
        this.prmtsupplier.setName("prmtsupplier");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.tBtnExeSettle.setName("tBtnExeSettle");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        this.mBtnExeSettle.setName("mBtnExeSettle");
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
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
        // chkisInit		
        this.chkisInit.setText(resHelper.getString("chkisInit.text"));		
        this.chkisInit.setHorizontalAlignment(2);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol17\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol18\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol19\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" t:styleID=\"sCol0\" /><t:Column t:key=\"internalFarm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"internalBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"internalHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"lot\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"stockingBatch\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" /><t:Column t:key=\"farmerGroup\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" t:styleID=\"sCol10\" /><t:Column t:key=\"sendDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" t:styleID=\"sCol11\" /><t:Column t:key=\"weekAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" t:styleID=\"sCol12\" /><t:Column t:key=\"dayAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"isFormal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"eggBatchNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"settleItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"originalQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"eggPriceType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"warehouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"costItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"policy\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"num\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"hatchQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"insteadFee\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{internalFarm}</t:Cell><t:Cell>$Resource{internalBatch}</t:Cell><t:Cell>$Resource{internalHouse}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{lot}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{stockingBatch}</t:Cell><t:Cell>$Resource{farmerGroup}</t:Cell><t:Cell>$Resource{sendDate}</t:Cell><t:Cell>$Resource{weekAge}</t:Cell><t:Cell>$Resource{dayAge}</t:Cell><t:Cell>$Resource{isFormal}</t:Cell><t:Cell>$Resource{eggBatchNumber}</t:Cell><t:Cell>$Resource{settleItem}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{originalQty}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{eggPriceType}</t:Cell><t:Cell>$Resource{warehouse}</t:Cell><t:Cell>$Resource{costItem}</t:Cell><t:Cell>$Resource{policy}</t:Cell><t:Cell>$Resource{num}</t:Cell><t:Cell>$Resource{hatchQty}</t:Cell><t:Cell>$Resource{insteadFee}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","internalFarm","internalBatch","internalHouse","supplier","lot","farmer","farm","house","stockingBatch","farmerGroup","sendDate","weekAge","dayAge","isFormal","eggBatchNumber","settleItem","material","unit","originalQty","qty","price","amount","eggPriceType","warehouse","costItem","policy","num","hatchQty","insteadFee"});


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
        final KDBizPromptBox kdtEntrys_internalHouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_internalHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtEntrys_internalHouse_PromptBox.setVisible(true);
        kdtEntrys_internalHouse_PromptBox.setEditable(true);
        kdtEntrys_internalHouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_internalHouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_internalHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_internalHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_internalHouse_PromptBox);
        this.kdtEntrys.getColumn("internalHouse").setEditor(kdtEntrys_internalHouse_CellEditor);
        ObjectValueRender kdtEntrys_internalHouse_OVR = new ObjectValueRender();
        kdtEntrys_internalHouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("internalHouse").setRenderer(kdtEntrys_internalHouse_OVR);
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
        KDDatePicker kdtEntrys_sendDate_DatePicker = new KDDatePicker();
        kdtEntrys_sendDate_DatePicker.setName("kdtEntrys_sendDate_DatePicker");
        kdtEntrys_sendDate_DatePicker.setVisible(true);
        kdtEntrys_sendDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_sendDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sendDate_DatePicker);
        this.kdtEntrys.getColumn("sendDate").setEditor(kdtEntrys_sendDate_CellEditor);
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
        KDTextField kdtEntrys_eggBatchNumber_TextField = new KDTextField();
        kdtEntrys_eggBatchNumber_TextField.setName("kdtEntrys_eggBatchNumber_TextField");
        kdtEntrys_eggBatchNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_eggBatchNumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_eggBatchNumber_TextField);
        this.kdtEntrys.getColumn("eggBatchNumber").setEditor(kdtEntrys_eggBatchNumber_CellEditor);
        final KDBizPromptBox kdtEntrys_settleItem_PromptBox = new KDBizPromptBox();
        kdtEntrys_settleItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.SettlementItemQuery");
        kdtEntrys_settleItem_PromptBox.setVisible(true);
        kdtEntrys_settleItem_PromptBox.setEditable(true);
        kdtEntrys_settleItem_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_settleItem_PromptBox.setEditFormat("$number$");
        kdtEntrys_settleItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_settleItem_CellEditor = new KDTDefaultCellEditor(kdtEntrys_settleItem_PromptBox);
        this.kdtEntrys.getColumn("settleItem").setEditor(kdtEntrys_settleItem_CellEditor);
        ObjectValueRender kdtEntrys_settleItem_OVR = new ObjectValueRender();
        kdtEntrys_settleItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("settleItem").setRenderer(kdtEntrys_settleItem_OVR);
        			kdtEntrys_settleItem_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI kdtEntrys_settleItem_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_settleItem_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_settleItem_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_settleItem_PromptBox_F7ListUI));
					kdtEntrys_settleItem_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_settleItem_PromptBox.setSelector(kdtEntrys_settleItem_PromptBox_F7ListUI);
				}
			}
		});
					
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
        KDFormattedTextField kdtEntrys_originalQty_TextField = new KDFormattedTextField();
        kdtEntrys_originalQty_TextField.setName("kdtEntrys_originalQty_TextField");
        kdtEntrys_originalQty_TextField.setVisible(true);
        kdtEntrys_originalQty_TextField.setEditable(true);
        kdtEntrys_originalQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_originalQty_TextField.setDataType(1);
        	kdtEntrys_originalQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_originalQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_originalQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_originalQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_originalQty_TextField);
        this.kdtEntrys.getColumn("originalQty").setEditor(kdtEntrys_originalQty_CellEditor);
        KDFormattedTextField kdtEntrys_qty_TextField = new KDFormattedTextField();
        kdtEntrys_qty_TextField.setName("kdtEntrys_qty_TextField");
        kdtEntrys_qty_TextField.setVisible(true);
        kdtEntrys_qty_TextField.setEditable(true);
        kdtEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qty_TextField.setDataType(1);
        	kdtEntrys_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qty_TextField);
        this.kdtEntrys.getColumn("qty").setEditor(kdtEntrys_qty_CellEditor);
        KDFormattedTextField kdtEntrys_price_TextField = new KDFormattedTextField();
        kdtEntrys_price_TextField.setName("kdtEntrys_price_TextField");
        kdtEntrys_price_TextField.setVisible(true);
        kdtEntrys_price_TextField.setEditable(true);
        kdtEntrys_price_TextField.setHorizontalAlignment(2);
        kdtEntrys_price_TextField.setDataType(1);
        	kdtEntrys_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_price_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_price_CellEditor = new KDTDefaultCellEditor(kdtEntrys_price_TextField);
        this.kdtEntrys.getColumn("price").setEditor(kdtEntrys_price_CellEditor);
        KDFormattedTextField kdtEntrys_amount_TextField = new KDFormattedTextField();
        kdtEntrys_amount_TextField.setName("kdtEntrys_amount_TextField");
        kdtEntrys_amount_TextField.setVisible(true);
        kdtEntrys_amount_TextField.setEditable(true);
        kdtEntrys_amount_TextField.setHorizontalAlignment(2);
        kdtEntrys_amount_TextField.setDataType(1);
        	kdtEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_amount_TextField);
        this.kdtEntrys.getColumn("amount").setEditor(kdtEntrys_amount_CellEditor);
        KDComboBox kdtEntrys_eggPriceType_ComboBox = new KDComboBox();
        kdtEntrys_eggPriceType_ComboBox.setName("kdtEntrys_eggPriceType_ComboBox");
        kdtEntrys_eggPriceType_ComboBox.setVisible(true);
        kdtEntrys_eggPriceType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.EggPriceType").toArray());
        KDTDefaultCellEditor kdtEntrys_eggPriceType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_eggPriceType_ComboBox);
        this.kdtEntrys.getColumn("eggPriceType").setEditor(kdtEntrys_eggPriceType_CellEditor);
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
        final KDBizPromptBox kdtEntrys_policy_PromptBox = new KDBizPromptBox();
        kdtEntrys_policy_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.hatch.app.EggSettlePolicyQuery");
        kdtEntrys_policy_PromptBox.setVisible(true);
        kdtEntrys_policy_PromptBox.setEditable(true);
        kdtEntrys_policy_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_policy_PromptBox.setEditFormat("$number$");
        kdtEntrys_policy_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_policy_CellEditor = new KDTDefaultCellEditor(kdtEntrys_policy_PromptBox);
        this.kdtEntrys.getColumn("policy").setEditor(kdtEntrys_policy_CellEditor);
        ObjectValueRender kdtEntrys_policy_OVR = new ObjectValueRender();
        kdtEntrys_policy_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("policy").setRenderer(kdtEntrys_policy_OVR);
        			kdtEntrys_policy_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.hatch.client.EggSettlePolicyListUI kdtEntrys_policy_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_policy_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_policy_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.hatch.client.EggSettlePolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_policy_PromptBox_F7ListUI));
					kdtEntrys_policy_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_policy_PromptBox.setSelector(kdtEntrys_policy_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtEntrys_num_TextField = new KDFormattedTextField();
        kdtEntrys_num_TextField.setName("kdtEntrys_num_TextField");
        kdtEntrys_num_TextField.setVisible(true);
        kdtEntrys_num_TextField.setEditable(true);
        kdtEntrys_num_TextField.setHorizontalAlignment(2);
        kdtEntrys_num_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_num_CellEditor = new KDTDefaultCellEditor(kdtEntrys_num_TextField);
        this.kdtEntrys.getColumn("num").setEditor(kdtEntrys_num_CellEditor);
        KDFormattedTextField kdtEntrys_hatchQty_TextField = new KDFormattedTextField();
        kdtEntrys_hatchQty_TextField.setName("kdtEntrys_hatchQty_TextField");
        kdtEntrys_hatchQty_TextField.setVisible(true);
        kdtEntrys_hatchQty_TextField.setEditable(true);
        kdtEntrys_hatchQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_hatchQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_hatchQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_hatchQty_TextField);
        this.kdtEntrys.getColumn("hatchQty").setEditor(kdtEntrys_hatchQty_CellEditor);
        KDFormattedTextField kdtEntrys_insteadFee_TextField = new KDFormattedTextField();
        kdtEntrys_insteadFee_TextField.setName("kdtEntrys_insteadFee_TextField");
        kdtEntrys_insteadFee_TextField.setVisible(true);
        kdtEntrys_insteadFee_TextField.setEditable(true);
        kdtEntrys_insteadFee_TextField.setHorizontalAlignment(2);
        kdtEntrys_insteadFee_TextField.setDataType(1);
        	kdtEntrys_insteadFee_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_insteadFee_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_insteadFee_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_insteadFee_CellEditor = new KDTDefaultCellEditor(kdtEntrys_insteadFee_TextField);
        this.kdtEntrys.getColumn("insteadFee").setEditor(kdtEntrys_insteadFee_CellEditor);
        // kdtPriceEntry
		String kdtPriceEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"num\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" t:styleID=\"sCol4\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol6\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol7\" /><t:Column t:key=\"remark\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"lossQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{num}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{lossQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPriceEntry.setFormatXml(resHelper.translateString("kdtPriceEntry",kdtPriceEntryStrXML));
        kdtPriceEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtPriceEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtPriceEntry.putBindContents("editData",new String[] {"PriceEntry.seq","PriceEntry.material","PriceEntry.materialName","PriceEntry.model","PriceEntry.num","PriceEntry.qty","PriceEntry.price","PriceEntry.amount","PriceEntry.remark","PriceEntry.lossQty"});


        this.kdtPriceEntry.checkParsed();
        final KDBizPromptBox kdtPriceEntry_material_PromptBox = new KDBizPromptBox();
        kdtPriceEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtPriceEntry_material_PromptBox.setVisible(true);
        kdtPriceEntry_material_PromptBox.setEditable(true);
        kdtPriceEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtPriceEntry_material_PromptBox.setEditFormat("$number$");
        kdtPriceEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPriceEntry_material_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_material_PromptBox);
        this.kdtPriceEntry.getColumn("material").setEditor(kdtPriceEntry_material_CellEditor);
        ObjectValueRender kdtPriceEntry_material_OVR = new ObjectValueRender();
        kdtPriceEntry_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtPriceEntry.getColumn("material").setRenderer(kdtPriceEntry_material_OVR);
        KDTextField kdtPriceEntry_materialName_TextField = new KDTextField();
        kdtPriceEntry_materialName_TextField.setName("kdtPriceEntry_materialName_TextField");
        kdtPriceEntry_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtPriceEntry_materialName_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_materialName_TextField);
        this.kdtPriceEntry.getColumn("materialName").setEditor(kdtPriceEntry_materialName_CellEditor);
        KDTextField kdtPriceEntry_model_TextField = new KDTextField();
        kdtPriceEntry_model_TextField.setName("kdtPriceEntry_model_TextField");
        kdtPriceEntry_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtPriceEntry_model_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_model_TextField);
        this.kdtPriceEntry.getColumn("model").setEditor(kdtPriceEntry_model_CellEditor);
        KDFormattedTextField kdtPriceEntry_num_TextField = new KDFormattedTextField();
        kdtPriceEntry_num_TextField.setName("kdtPriceEntry_num_TextField");
        kdtPriceEntry_num_TextField.setVisible(true);
        kdtPriceEntry_num_TextField.setEditable(true);
        kdtPriceEntry_num_TextField.setHorizontalAlignment(2);
        kdtPriceEntry_num_TextField.setDataType(0);
        KDTDefaultCellEditor kdtPriceEntry_num_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_num_TextField);
        this.kdtPriceEntry.getColumn("num").setEditor(kdtPriceEntry_num_CellEditor);
        KDFormattedTextField kdtPriceEntry_qty_TextField = new KDFormattedTextField();
        kdtPriceEntry_qty_TextField.setName("kdtPriceEntry_qty_TextField");
        kdtPriceEntry_qty_TextField.setVisible(true);
        kdtPriceEntry_qty_TextField.setEditable(true);
        kdtPriceEntry_qty_TextField.setHorizontalAlignment(2);
        kdtPriceEntry_qty_TextField.setDataType(1);
        	kdtPriceEntry_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPriceEntry_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPriceEntry_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPriceEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_qty_TextField);
        this.kdtPriceEntry.getColumn("qty").setEditor(kdtPriceEntry_qty_CellEditor);
        KDFormattedTextField kdtPriceEntry_price_TextField = new KDFormattedTextField();
        kdtPriceEntry_price_TextField.setName("kdtPriceEntry_price_TextField");
        kdtPriceEntry_price_TextField.setVisible(true);
        kdtPriceEntry_price_TextField.setEditable(true);
        kdtPriceEntry_price_TextField.setHorizontalAlignment(2);
        kdtPriceEntry_price_TextField.setDataType(1);
        	kdtPriceEntry_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPriceEntry_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPriceEntry_price_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPriceEntry_price_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_price_TextField);
        this.kdtPriceEntry.getColumn("price").setEditor(kdtPriceEntry_price_CellEditor);
        KDFormattedTextField kdtPriceEntry_amount_TextField = new KDFormattedTextField();
        kdtPriceEntry_amount_TextField.setName("kdtPriceEntry_amount_TextField");
        kdtPriceEntry_amount_TextField.setVisible(true);
        kdtPriceEntry_amount_TextField.setEditable(true);
        kdtPriceEntry_amount_TextField.setHorizontalAlignment(2);
        kdtPriceEntry_amount_TextField.setDataType(1);
        	kdtPriceEntry_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPriceEntry_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPriceEntry_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPriceEntry_amount_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_amount_TextField);
        this.kdtPriceEntry.getColumn("amount").setEditor(kdtPriceEntry_amount_CellEditor);
        KDTextField kdtPriceEntry_remark_TextField = new KDTextField();
        kdtPriceEntry_remark_TextField.setName("kdtPriceEntry_remark_TextField");
        kdtPriceEntry_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtPriceEntry_remark_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_remark_TextField);
        this.kdtPriceEntry.getColumn("remark").setEditor(kdtPriceEntry_remark_CellEditor);
        KDFormattedTextField kdtPriceEntry_lossQty_TextField = new KDFormattedTextField();
        kdtPriceEntry_lossQty_TextField.setName("kdtPriceEntry_lossQty_TextField");
        kdtPriceEntry_lossQty_TextField.setVisible(true);
        kdtPriceEntry_lossQty_TextField.setEditable(true);
        kdtPriceEntry_lossQty_TextField.setHorizontalAlignment(2);
        kdtPriceEntry_lossQty_TextField.setDataType(1);
        	kdtPriceEntry_lossQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPriceEntry_lossQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPriceEntry_lossQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPriceEntry_lossQty_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_lossQty_TextField);
        this.kdtPriceEntry.getColumn("lossQty").setEditor(kdtPriceEntry_lossQty_CellEditor);
        // contamount		
        this.contamount.setBoundLabelText(resHelper.getString("contamount.boundLabelText"));		
        this.contamount.setBoundLabelLength(100);		
        this.contamount.setBoundLabelUnderline(true);		
        this.contamount.setVisible(true);
        // contcompensateAmount		
        this.contcompensateAmount.setBoundLabelText(resHelper.getString("contcompensateAmount.boundLabelText"));		
        this.contcompensateAmount.setBoundLabelLength(100);		
        this.contcompensateAmount.setBoundLabelUnderline(true);		
        this.contcompensateAmount.setVisible(true);
        // contpaymentAmount		
        this.contpaymentAmount.setBoundLabelText(resHelper.getString("contpaymentAmount.boundLabelText"));		
        this.contpaymentAmount.setBoundLabelLength(100);		
        this.contpaymentAmount.setBoundLabelUnderline(true);		
        this.contpaymentAmount.setVisible(true);
        // contactualAmount		
        this.contactualAmount.setBoundLabelText(resHelper.getString("contactualAmount.boundLabelText"));		
        this.contactualAmount.setBoundLabelLength(100);		
        this.contactualAmount.setBoundLabelUnderline(true);		
        this.contactualAmount.setVisible(true);
        // contotherAmount		
        this.contotherAmount.setBoundLabelText(resHelper.getString("contotherAmount.boundLabelText"));		
        this.contotherAmount.setBoundLabelLength(100);		
        this.contotherAmount.setBoundLabelUnderline(true);		
        this.contotherAmount.setVisible(true);
        // conthatchBeginDate		
        this.conthatchBeginDate.setBoundLabelText(resHelper.getString("conthatchBeginDate.boundLabelText"));		
        this.conthatchBeginDate.setBoundLabelLength(100);		
        this.conthatchBeginDate.setBoundLabelUnderline(true);		
        this.conthatchBeginDate.setVisible(true);
        // conthatchEndDate		
        this.conthatchEndDate.setBoundLabelText(resHelper.getString("conthatchEndDate.boundLabelText"));		
        this.conthatchEndDate.setBoundLabelLength(100);		
        this.conthatchEndDate.setBoundLabelUnderline(true);		
        this.conthatchEndDate.setVisible(true);
        // contbyProductAmount		
        this.contbyProductAmount.setBoundLabelText(resHelper.getString("contbyProductAmount.boundLabelText"));		
        this.contbyProductAmount.setBoundLabelLength(100);		
        this.contbyProductAmount.setBoundLabelUnderline(true);		
        this.contbyProductAmount.setVisible(true);
        // contdestCompany		
        this.contdestCompany.setBoundLabelText(resHelper.getString("contdestCompany.boundLabelText"));		
        this.contdestCompany.setBoundLabelLength(100);		
        this.contdestCompany.setBoundLabelUnderline(true);
        // conteggSource		
        this.conteggSource.setBoundLabelText(resHelper.getString("conteggSource.boundLabelText"));		
        this.conteggSource.setBoundLabelLength(100);		
        this.conteggSource.setBoundLabelUnderline(true);		
        this.conteggSource.setVisible(true);
        // contsupplier		
        this.contsupplier.setBoundLabelText(resHelper.getString("contsupplier.boundLabelText"));		
        this.contsupplier.setBoundLabelLength(100);		
        this.contsupplier.setBoundLabelUnderline(true);		
        this.contsupplier.setVisible(false);
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
        // txtamount		
        this.txtamount.setHorizontalAlignment(2);		
        this.txtamount.setDataType(1);		
        this.txtamount.setSupportedEmpty(true);		
        this.txtamount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtamount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtamount.setPrecision(2);		
        this.txtamount.setRequired(false);		
        this.txtamount.setEnabled(false);
        // txtcompensateAmount		
        this.txtcompensateAmount.setHorizontalAlignment(2);		
        this.txtcompensateAmount.setDataType(1);		
        this.txtcompensateAmount.setSupportedEmpty(true);		
        this.txtcompensateAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcompensateAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcompensateAmount.setPrecision(2);		
        this.txtcompensateAmount.setRequired(false);
        // txtpaymentAmount		
        this.txtpaymentAmount.setHorizontalAlignment(2);		
        this.txtpaymentAmount.setDataType(1);		
        this.txtpaymentAmount.setSupportedEmpty(true);		
        this.txtpaymentAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpaymentAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpaymentAmount.setPrecision(2);		
        this.txtpaymentAmount.setRequired(false);
        // txtactualAmount		
        this.txtactualAmount.setHorizontalAlignment(2);		
        this.txtactualAmount.setDataType(1);		
        this.txtactualAmount.setSupportedEmpty(true);		
        this.txtactualAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualAmount.setPrecision(2);		
        this.txtactualAmount.setRequired(false);		
        this.txtactualAmount.setEnabled(false);
        // txtotherAmount		
        this.txtotherAmount.setHorizontalAlignment(2);		
        this.txtotherAmount.setDataType(1);		
        this.txtotherAmount.setSupportedEmpty(true);		
        this.txtotherAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherAmount.setPrecision(2);		
        this.txtotherAmount.setRequired(false);
        // pkhatchBeginDate		
        this.pkhatchBeginDate.setRequired(true);
        // pkhatchEndDate		
        this.pkhatchEndDate.setRequired(true);
        // txtbyProductAmount		
        this.txtbyProductAmount.setHorizontalAlignment(2);		
        this.txtbyProductAmount.setDataType(1);		
        this.txtbyProductAmount.setSupportedEmpty(true);		
        this.txtbyProductAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbyProductAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbyProductAmount.setPrecision(2);		
        this.txtbyProductAmount.setRequired(false);
        // prmtdestCompany		
        this.prmtdestCompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtdestCompany.setEditable(true);		
        this.prmtdestCompany.setDisplayFormat("$name$");		
        this.prmtdestCompany.setEditFormat("$number$");		
        this.prmtdestCompany.setCommitFormat("$number$");		
        this.prmtdestCompany.setRequired(false);
        // eggSource		
        this.eggSource.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggSourceType").toArray());		
        this.eggSource.setRequired(true);
        // prmtsupplier		
        this.prmtsupplier.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");		
        this.prmtsupplier.setEditable(true);		
        this.prmtsupplier.setDisplayFormat("$name$");		
        this.prmtsupplier.setEditFormat("$number$");		
        this.prmtsupplier.setCommitFormat("$number$");		
        this.prmtsupplier.setRequired(false);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // tBtnExeSettle
        this.tBtnExeSettle.setAction((IItemAction)ActionProxyFactory.getProxy(actionExeSettle, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnExeSettle.setText(resHelper.getString("tBtnExeSettle.text"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        // mBtnExeSettle
        this.mBtnExeSettle.setAction((IItemAction)ActionProxyFactory.getProxy(actionExeSettle, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnExeSettle.setText(resHelper.getString("mBtnExeSettle.text"));
        // newSeparator3
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kdtPriceEntry,txtNumber,pkBizDate,prmtstorageOrgUnit,txtDescription,billStatus,prmtcompany,pkauditTime,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,chkisInit,txtamount,txtpaymentAmount,txtcompensateAmount,txtactualAmount,txtotherAmount,pkhatchBeginDate,pkhatchEndDate,txtbyProductAmount,prmtdestCompany,eggSource,prmtsupplier,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1016, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1016, 629));
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
        contBizDate.setBounds(new Rectangle(365, 9, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(365, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        contstorageOrgUnit.setBounds(new Rectangle(365, 30, 270, 19));
        this.add(contstorageOrgUnit, new KDLayout.Constraints(365, 30, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisInit.setBounds(new Rectangle(722, 129, 194, 19));
        this.add(chkisInit, new KDLayout.Constraints(722, 129, 194, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(22, 167, 970, 393));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(22, 167, 970, 393, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("eggPriceType",new Integer(0));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        kdtPriceEntry.setBounds(new Rectangle(1041, 363, 971, 170));
        kdtPriceEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtPriceEntry,new com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryPriceEntryInfo(),null,false);
        this.add(kdtPriceEntry_detailPanel, new KDLayout.Constraints(1041, 363, 971, 170, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contamount.setBounds(new Rectangle(365, 54, 270, 19));
        this.add(contamount, new KDLayout.Constraints(365, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompensateAmount.setBounds(new Rectangle(22, 102, 270, 19));
        this.add(contcompensateAmount, new KDLayout.Constraints(22, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpaymentAmount.setBounds(new Rectangle(722, 78, 270, 19));
        this.add(contpaymentAmount, new KDLayout.Constraints(722, 78, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contactualAmount.setBounds(new Rectangle(722, 54, 270, 19));
        this.add(contactualAmount, new KDLayout.Constraints(722, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contotherAmount.setBounds(new Rectangle(365, 78, 270, 19));
        this.add(contotherAmount, new KDLayout.Constraints(365, 78, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthatchBeginDate.setBounds(new Rectangle(365, 102, 270, 19));
        this.add(conthatchBeginDate, new KDLayout.Constraints(365, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthatchEndDate.setBounds(new Rectangle(722, 102, 270, 19));
        this.add(conthatchEndDate, new KDLayout.Constraints(722, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbyProductAmount.setBounds(new Rectangle(22, 78, 270, 19));
        this.add(contbyProductAmount, new KDLayout.Constraints(22, 78, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdestCompany.setBounds(new Rectangle(22, 129, 270, 19));
        this.add(contdestCompany, new KDLayout.Constraints(22, 129, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conteggSource.setBounds(new Rectangle(22, 54, 270, 19));
        this.add(conteggSource, new KDLayout.Constraints(22, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsupplier.setBounds(new Rectangle(22, 129, 270, 19));
        this.add(contsupplier, new KDLayout.Constraints(22, 129, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contamount
        contamount.setBoundEditor(txtamount);
        //contcompensateAmount
        contcompensateAmount.setBoundEditor(txtcompensateAmount);
        //contpaymentAmount
        contpaymentAmount.setBoundEditor(txtpaymentAmount);
        //contactualAmount
        contactualAmount.setBoundEditor(txtactualAmount);
        //contotherAmount
        contotherAmount.setBoundEditor(txtotherAmount);
        //conthatchBeginDate
        conthatchBeginDate.setBoundEditor(pkhatchBeginDate);
        //conthatchEndDate
        conthatchEndDate.setBoundEditor(pkhatchEndDate);
        //contbyProductAmount
        contbyProductAmount.setBoundEditor(txtbyProductAmount);
        //contdestCompany
        contdestCompany.setBoundEditor(prmtdestCompany);
        //conteggSource
        conteggSource.setBoundEditor(eggSource);
        //contsupplier
        contsupplier.setBoundEditor(prmtsupplier);

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
        menuBiz.add(mBtnExeSettle);
        menuBiz.add(newSeparator3);
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(menuItemCancel);
        menuBiz.add(menuItemDelPCVoucher);
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
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
        this.toolBar.add(tBtnExeSettle);
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
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isInit", boolean.class, this.chkisInit, "selected");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.warehouse", java.lang.Object.class, this.kdtEntrys, "warehouse.text");
		dataBinder.registerBinding("entrys.farmer", java.lang.Object.class, this.kdtEntrys, "farmer.text");
		dataBinder.registerBinding("entrys.farm", java.lang.Object.class, this.kdtEntrys, "farm.text");
		dataBinder.registerBinding("entrys.stockingBatch", java.lang.Object.class, this.kdtEntrys, "stockingBatch.text");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.costItem", java.lang.Object.class, this.kdtEntrys, "costItem.text");
		dataBinder.registerBinding("entrys.internalFarm", java.lang.Object.class, this.kdtEntrys, "internalFarm.text");
		dataBinder.registerBinding("entrys.internalBatch", java.lang.Object.class, this.kdtEntrys, "internalBatch.text");
		dataBinder.registerBinding("entrys.supplier", java.lang.Object.class, this.kdtEntrys, "supplier.text");
		dataBinder.registerBinding("entrys.unit", java.lang.Object.class, this.kdtEntrys, "unit.text");
		dataBinder.registerBinding("entrys.weekAge", String.class, this.kdtEntrys, "weekAge.text");
		dataBinder.registerBinding("entrys.dayAge", int.class, this.kdtEntrys, "dayAge.text");
		dataBinder.registerBinding("entrys.isFormal", boolean.class, this.kdtEntrys, "isFormal.text");
		dataBinder.registerBinding("entrys.house", java.lang.Object.class, this.kdtEntrys, "house.text");
		dataBinder.registerBinding("entrys.farmerGroup", String.class, this.kdtEntrys, "farmerGroup.text");
		dataBinder.registerBinding("entrys.qty", java.math.BigDecimal.class, this.kdtEntrys, "qty.text");
		dataBinder.registerBinding("entrys.price", java.math.BigDecimal.class, this.kdtEntrys, "price.text");
		dataBinder.registerBinding("entrys.amount", java.math.BigDecimal.class, this.kdtEntrys, "amount.text");
		dataBinder.registerBinding("entrys.sendDate", java.util.Date.class, this.kdtEntrys, "sendDate.text");
		dataBinder.registerBinding("entrys.eggPriceType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "eggPriceType.text");
		dataBinder.registerBinding("entrys.lot", String.class, this.kdtEntrys, "lot.text");
		dataBinder.registerBinding("entrys.settleItem", java.lang.Object.class, this.kdtEntrys, "settleItem.text");
		dataBinder.registerBinding("entrys.originalQty", java.math.BigDecimal.class, this.kdtEntrys, "originalQty.text");
		dataBinder.registerBinding("entrys.internalHouse", java.lang.Object.class, this.kdtEntrys, "internalHouse.text");
		dataBinder.registerBinding("entrys.num", int.class, this.kdtEntrys, "num.text");
		dataBinder.registerBinding("entrys.policy", java.lang.Object.class, this.kdtEntrys, "policy.text");
		dataBinder.registerBinding("entrys.eggBatchNumber", String.class, this.kdtEntrys, "eggBatchNumber.text");
		dataBinder.registerBinding("entrys.hatchQty", int.class, this.kdtEntrys, "hatchQty.text");
		dataBinder.registerBinding("entrys.insteadFee", java.math.BigDecimal.class, this.kdtEntrys, "insteadFee.text");
		dataBinder.registerBinding("entrys.PriceEntry.seq", int.class, this.kdtPriceEntry, "seq.text");
		dataBinder.registerBinding("entrys.PriceEntry", com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryPriceEntryInfo.class, this.kdtPriceEntry, "userObject");
		dataBinder.registerBinding("entrys.PriceEntry.material", java.lang.Object.class, this.kdtPriceEntry, "material.text");
		dataBinder.registerBinding("entrys.PriceEntry.materialName", String.class, this.kdtPriceEntry, "materialName.text");
		dataBinder.registerBinding("entrys.PriceEntry.model", String.class, this.kdtPriceEntry, "model.text");
		dataBinder.registerBinding("entrys.PriceEntry.qty", java.math.BigDecimal.class, this.kdtPriceEntry, "qty.text");
		dataBinder.registerBinding("entrys.PriceEntry.price", java.math.BigDecimal.class, this.kdtPriceEntry, "price.text");
		dataBinder.registerBinding("entrys.PriceEntry.amount", java.math.BigDecimal.class, this.kdtPriceEntry, "amount.text");
		dataBinder.registerBinding("entrys.PriceEntry.remark", String.class, this.kdtPriceEntry, "remark.text");
		dataBinder.registerBinding("entrys.PriceEntry.num", int.class, this.kdtPriceEntry, "num.text");
		dataBinder.registerBinding("entrys.PriceEntry.lossQty", java.math.BigDecimal.class, this.kdtPriceEntry, "lossQty.text");
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
		dataBinder.registerBinding("amount", java.math.BigDecimal.class, this.txtamount, "value");
		dataBinder.registerBinding("compensateAmount", java.math.BigDecimal.class, this.txtcompensateAmount, "value");
		dataBinder.registerBinding("paymentAmount", java.math.BigDecimal.class, this.txtpaymentAmount, "value");
		dataBinder.registerBinding("actualAmount", java.math.BigDecimal.class, this.txtactualAmount, "value");
		dataBinder.registerBinding("otherAmount", java.math.BigDecimal.class, this.txtotherAmount, "value");
		dataBinder.registerBinding("hatchBeginDate", java.util.Date.class, this.pkhatchBeginDate, "value");
		dataBinder.registerBinding("hatchEndDate", java.util.Date.class, this.pkhatchEndDate, "value");
		dataBinder.registerBinding("byProductAmount", java.math.BigDecimal.class, this.txtbyProductAmount, "value");
		dataBinder.registerBinding("destCompany", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtdestCompany, "data");
		dataBinder.registerBinding("eggSource", com.kingdee.eas.farm.hatch.EggSourceType.class, this.eggSource, "selectedItem");
		dataBinder.registerBinding("supplier", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtsupplier, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.hatch.app.EggSettleBillCompanyEditUIHandler";
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
        this.kdtPriceEntry.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyInfo)ov;
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
		getValidateHelper().registerBindProperty("isInit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.warehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.stockingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.costItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.internalFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.internalBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.weekAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dayAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isFormal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farmerGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sendDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.eggPriceType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lot", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.settleItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.originalQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.internalHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.num", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.policy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.eggBatchNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hatchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.insteadFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PriceEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PriceEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PriceEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PriceEntry.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PriceEntry.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PriceEntry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PriceEntry.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PriceEntry.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PriceEntry.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PriceEntry.num", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PriceEntry.lossQty", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("compensateAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("paymentAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchBeginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchEndDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("byProductAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("destCompany", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggSource", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplier", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("farmer".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"farmerGroup").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"farmer").getValue(),"treeid.name")));

}

    if ("settleItem".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"settleItem").getValue(),"settleUnit"));

}

    if ("qty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"amount").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"price").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"qty").getValue())));

}

    if ("price".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"amount").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"price").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"qty").getValue())));

}


    }

    /**
     * output kdtPriceEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtPriceEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {
kdtPriceEntry.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPriceEntry.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {
kdtPriceEntry.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPriceEntry.getCell(rowIndex,"material").getValue(),"model")));

}

    if ("qty".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {

}

    if ("price".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {

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
        sic.add(new SelectorItemInfo("isInit"));
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
    	sic.add(new SelectorItemInfo("entrys.weekAge"));
    	sic.add(new SelectorItemInfo("entrys.dayAge"));
    	sic.add(new SelectorItemInfo("entrys.isFormal"));
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
    	sic.add(new SelectorItemInfo("entrys.qty"));
    	sic.add(new SelectorItemInfo("entrys.price"));
    	sic.add(new SelectorItemInfo("entrys.amount"));
    	sic.add(new SelectorItemInfo("entrys.sendDate"));
    	sic.add(new SelectorItemInfo("entrys.eggPriceType"));
    	sic.add(new SelectorItemInfo("entrys.lot"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.settleItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.settleItem.id"));
			sic.add(new SelectorItemInfo("entrys.settleItem.name"));
        	sic.add(new SelectorItemInfo("entrys.settleItem.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.originalQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.internalHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.internalHouse.id"));
			sic.add(new SelectorItemInfo("entrys.internalHouse.number"));
			sic.add(new SelectorItemInfo("entrys.internalHouse.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.num"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.policy.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.policy.id"));
			sic.add(new SelectorItemInfo("entrys.policy.name"));
        	sic.add(new SelectorItemInfo("entrys.policy.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.eggBatchNumber"));
    	sic.add(new SelectorItemInfo("entrys.hatchQty"));
    	sic.add(new SelectorItemInfo("entrys.insteadFee"));
    	sic.add(new SelectorItemInfo("entrys.PriceEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.PriceEntry.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.PriceEntry.id"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.PriceEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.PriceEntry.material.id"));
			sic.add(new SelectorItemInfo("entrys.PriceEntry.material.number"));
			sic.add(new SelectorItemInfo("entrys.PriceEntry.material.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.PriceEntry.materialName"));
    	sic.add(new SelectorItemInfo("entrys.PriceEntry.model"));
    	sic.add(new SelectorItemInfo("entrys.PriceEntry.qty"));
    	sic.add(new SelectorItemInfo("entrys.PriceEntry.price"));
    	sic.add(new SelectorItemInfo("entrys.PriceEntry.amount"));
    	sic.add(new SelectorItemInfo("entrys.PriceEntry.remark"));
    	sic.add(new SelectorItemInfo("entrys.PriceEntry.num"));
    	sic.add(new SelectorItemInfo("entrys.PriceEntry.lossQty"));
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
        sic.add(new SelectorItemInfo("amount"));
        sic.add(new SelectorItemInfo("compensateAmount"));
        sic.add(new SelectorItemInfo("paymentAmount"));
        sic.add(new SelectorItemInfo("actualAmount"));
        sic.add(new SelectorItemInfo("otherAmount"));
        sic.add(new SelectorItemInfo("hatchBeginDate"));
        sic.add(new SelectorItemInfo("hatchEndDate"));
        sic.add(new SelectorItemInfo("byProductAmount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("destCompany.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("destCompany.id"));
        	sic.add(new SelectorItemInfo("destCompany.number"));
        	sic.add(new SelectorItemInfo("destCompany.name"));
		}
        sic.add(new SelectorItemInfo("eggSource"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("supplier.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("supplier.id"));
        	sic.add(new SelectorItemInfo("supplier.number"));
        	sic.add(new SelectorItemInfo("supplier.name"));
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
        com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionShowPriceCol_actionPerformed method
     */
    public void actionShowPriceCol_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyFactory.getRemoteInstance().showPriceCol(editData);
    }
    	

    /**
     * output actionExeSettle_actionPerformed method
     */
    public void actionExeSettle_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyFactory.getRemoteInstance().exeSettle(editData);
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
	public RequestContext prepareActionExeSettle(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionExeSettle() {
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
            innerActionPerformed("eas", AbstractEggSettleBillCompanyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractEggSettleBillCompanyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractEggSettleBillCompanyEditUI.this, "ActionShowPriceCol", "actionShowPriceCol_actionPerformed", e);
        }
    }

    /**
     * output ActionExeSettle class
     */     
    protected class ActionExeSettle extends ItemAction {     
    
        public ActionExeSettle()
        {
            this(null);
        }

        public ActionExeSettle(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionExeSettle.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExeSettle.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExeSettle.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractEggSettleBillCompanyEditUI.this, "ActionExeSettle", "actionExeSettle_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.hatch.client", "EggSettleBillCompanyEditUI");
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
        return com.kingdee.eas.farm.stocking.hatch.client.EggSettleBillCompanyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyInfo objectValue = new com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/stocking/hatch/EggSettleBillCompany";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.stocking.hatch.app.EggSettleBillCompanyQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"settleItem").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结算项目"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"unit").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"计量单位"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"eggPriceType").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"蛋品价格来源"});
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
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkhatchBeginDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"出雏日期(从)"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkhatchEndDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"出雏日期(至)"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(eggSource.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"种蛋来源"});
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
		vo.put("billStatus",new Integer(0));
vo.put("eggSource",new Integer(5));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}