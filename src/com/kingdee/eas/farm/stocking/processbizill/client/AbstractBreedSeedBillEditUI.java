/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

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
public abstract class AbstractBreedSeedBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBreedSeedBillEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstockingBatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstockingBatchNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfemaleQty;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisInit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvoucherNum;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhasComfirm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconfirmTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsex;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisMatOut;
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
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstockingBatch;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtstockingBatchNum;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfemaleQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthouse;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtvoucherNum;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkconfirmTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox sex;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator3;
    protected com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionChkVoucherAll actionChkVoucherAll = null;
    protected ActionChkVoucherFlag actionChkVoucherFlag = null;
    /**
     * output class constructor
     */
    public AbstractBreedSeedBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBreedSeedBillEditUI.class.getName());
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
        //actionChkVoucherAll
        this.actionChkVoucherAll = new ActionChkVoucherAll(this);
        getActionManager().registerAction("actionChkVoucherAll", actionChkVoucherAll);
        this.actionChkVoucherAll.setExtendProperty("canForewarn", "true");
        this.actionChkVoucherAll.setExtendProperty("userDefined", "false");
        this.actionChkVoucherAll.setExtendProperty("isObjectUpdateLock", "false");
         this.actionChkVoucherAll.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionChkVoucherAll.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionChkVoucherFlag
        this.actionChkVoucherFlag = new ActionChkVoucherFlag(this);
        getActionManager().registerAction("actionChkVoucherFlag", actionChkVoucherFlag);
        this.actionChkVoucherFlag.setExtendProperty("canForewarn", "true");
        this.actionChkVoucherFlag.setExtendProperty("userDefined", "false");
        this.actionChkVoucherFlag.setExtendProperty("isObjectUpdateLock", "false");
         this.actionChkVoucherFlag.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionChkVoucherFlag.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
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
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstockingBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstockingBatchNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfemaleQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisInit = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.conthouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvoucherNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkhasComfirm = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contconfirmTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsex = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisMatOut = new com.kingdee.bos.ctrl.swing.KDCheckBox();
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
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstockingBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtstockingBatchNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtqty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtbatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfemaleQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmthouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtvoucherNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkconfirmTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.sex = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
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
        this.contfarmer.setName("contfarmer");
        this.kdtEntrys.setName("kdtEntrys");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.contfarm.setName("contfarm");
        this.contstockingBatch.setName("contstockingBatch");
        this.contstockingBatchNum.setName("contstockingBatchNum");
        this.contbreedData.setName("contbreedData");
        this.contqty.setName("contqty");
        this.contbatchContract.setName("contbatchContract");
        this.contfemaleQty.setName("contfemaleQty");
        this.chkisInit.setName("chkisInit");
        this.conthouse.setName("conthouse");
        this.contvoucherNum.setName("contvoucherNum");
        this.chkhasComfirm.setName("chkhasComfirm");
        this.contconfirmTime.setName("contconfirmTime");
        this.contsex.setName("contsex");
        this.chkisMatOut.setName("chkisMatOut");
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
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtstorageOrgUnit.setName("prmtstorageOrgUnit");
        this.prmtfarm.setName("prmtfarm");
        this.prmtstockingBatch.setName("prmtstockingBatch");
        this.txtstockingBatchNum.setName("txtstockingBatchNum");
        this.prmtbreedData.setName("prmtbreedData");
        this.txtqty.setName("txtqty");
        this.prmtbatchContract.setName("prmtbatchContract");
        this.txtfemaleQty.setName("txtfemaleQty");
        this.prmthouse.setName("prmthouse");
        this.txtvoucherNum.setName("txtvoucherNum");
        this.pkconfirmTime.setName("pkconfirmTime");
        this.sex.setName("sex");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
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
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(false);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"receiveQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"lossQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"supplementQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"henQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"cockQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"allReceiveQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"confirmQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"basePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"receivePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"warehouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{receiveQty}</t:Cell><t:Cell>$Resource{lossQty}</t:Cell><t:Cell>$Resource{supplementQty}</t:Cell><t:Cell>$Resource{henQty}</t:Cell><t:Cell>$Resource{cockQty}</t:Cell><t:Cell>$Resource{allReceiveQty}</t:Cell><t:Cell>$Resource{confirmQty}</t:Cell><t:Cell>$Resource{basePrice}</t:Cell><t:Cell>$Resource{receivePrice}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{warehouse}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","house","material","materialName","model","unit","receiveQty","lossQty","supplementQty","henQty","cockQty","allReceiveQty","confirmQty","basePrice","receivePrice","amount","warehouse"});


        this.kdtEntrys.checkParsed();
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
        kdtEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("material").setRenderer(kdtEntrys_material_OVR);
        KDTextField kdtEntrys_materialName_TextField = new KDTextField();
        kdtEntrys_materialName_TextField.setName("kdtEntrys_materialName_TextField");
        kdtEntrys_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_materialName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialName_TextField);
        this.kdtEntrys.getColumn("materialName").setEditor(kdtEntrys_materialName_CellEditor);
        KDTextField kdtEntrys_model_TextField = new KDTextField();
        kdtEntrys_model_TextField.setName("kdtEntrys_model_TextField");
        kdtEntrys_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_model_CellEditor = new KDTDefaultCellEditor(kdtEntrys_model_TextField);
        this.kdtEntrys.getColumn("model").setEditor(kdtEntrys_model_CellEditor);
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
        KDFormattedTextField kdtEntrys_receiveQty_TextField = new KDFormattedTextField();
        kdtEntrys_receiveQty_TextField.setName("kdtEntrys_receiveQty_TextField");
        kdtEntrys_receiveQty_TextField.setVisible(true);
        kdtEntrys_receiveQty_TextField.setEditable(true);
        kdtEntrys_receiveQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_receiveQty_TextField.setDataType(1);
        	kdtEntrys_receiveQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_receiveQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_receiveQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_receiveQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_receiveQty_TextField);
        this.kdtEntrys.getColumn("receiveQty").setEditor(kdtEntrys_receiveQty_CellEditor);
        KDFormattedTextField kdtEntrys_lossQty_TextField = new KDFormattedTextField();
        kdtEntrys_lossQty_TextField.setName("kdtEntrys_lossQty_TextField");
        kdtEntrys_lossQty_TextField.setVisible(true);
        kdtEntrys_lossQty_TextField.setEditable(true);
        kdtEntrys_lossQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_lossQty_TextField.setDataType(1);
        	kdtEntrys_lossQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_lossQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_lossQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_lossQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lossQty_TextField);
        this.kdtEntrys.getColumn("lossQty").setEditor(kdtEntrys_lossQty_CellEditor);
        KDFormattedTextField kdtEntrys_supplementQty_TextField = new KDFormattedTextField();
        kdtEntrys_supplementQty_TextField.setName("kdtEntrys_supplementQty_TextField");
        kdtEntrys_supplementQty_TextField.setVisible(true);
        kdtEntrys_supplementQty_TextField.setEditable(true);
        kdtEntrys_supplementQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_supplementQty_TextField.setDataType(1);
        	kdtEntrys_supplementQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_supplementQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_supplementQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_supplementQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_supplementQty_TextField);
        this.kdtEntrys.getColumn("supplementQty").setEditor(kdtEntrys_supplementQty_CellEditor);
        KDFormattedTextField kdtEntrys_henQty_TextField = new KDFormattedTextField();
        kdtEntrys_henQty_TextField.setName("kdtEntrys_henQty_TextField");
        kdtEntrys_henQty_TextField.setVisible(true);
        kdtEntrys_henQty_TextField.setEditable(true);
        kdtEntrys_henQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_henQty_TextField.setDataType(1);
        	kdtEntrys_henQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_henQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_henQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_henQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henQty_TextField);
        this.kdtEntrys.getColumn("henQty").setEditor(kdtEntrys_henQty_CellEditor);
        KDFormattedTextField kdtEntrys_cockQty_TextField = new KDFormattedTextField();
        kdtEntrys_cockQty_TextField.setName("kdtEntrys_cockQty_TextField");
        kdtEntrys_cockQty_TextField.setVisible(true);
        kdtEntrys_cockQty_TextField.setEditable(true);
        kdtEntrys_cockQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_cockQty_TextField.setDataType(1);
        	kdtEntrys_cockQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_cockQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_cockQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_cockQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cockQty_TextField);
        this.kdtEntrys.getColumn("cockQty").setEditor(kdtEntrys_cockQty_CellEditor);
        KDFormattedTextField kdtEntrys_allReceiveQty_TextField = new KDFormattedTextField();
        kdtEntrys_allReceiveQty_TextField.setName("kdtEntrys_allReceiveQty_TextField");
        kdtEntrys_allReceiveQty_TextField.setVisible(true);
        kdtEntrys_allReceiveQty_TextField.setEditable(true);
        kdtEntrys_allReceiveQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_allReceiveQty_TextField.setDataType(1);
        	kdtEntrys_allReceiveQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_allReceiveQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_allReceiveQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_allReceiveQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_allReceiveQty_TextField);
        this.kdtEntrys.getColumn("allReceiveQty").setEditor(kdtEntrys_allReceiveQty_CellEditor);
        KDFormattedTextField kdtEntrys_confirmQty_TextField = new KDFormattedTextField();
        kdtEntrys_confirmQty_TextField.setName("kdtEntrys_confirmQty_TextField");
        kdtEntrys_confirmQty_TextField.setVisible(true);
        kdtEntrys_confirmQty_TextField.setEditable(true);
        kdtEntrys_confirmQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_confirmQty_TextField.setDataType(1);
        	kdtEntrys_confirmQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_confirmQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_confirmQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_confirmQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_confirmQty_TextField);
        this.kdtEntrys.getColumn("confirmQty").setEditor(kdtEntrys_confirmQty_CellEditor);
        KDFormattedTextField kdtEntrys_basePrice_TextField = new KDFormattedTextField();
        kdtEntrys_basePrice_TextField.setName("kdtEntrys_basePrice_TextField");
        kdtEntrys_basePrice_TextField.setVisible(true);
        kdtEntrys_basePrice_TextField.setEditable(true);
        kdtEntrys_basePrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_basePrice_TextField.setDataType(1);
        	kdtEntrys_basePrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_basePrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_basePrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_basePrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_basePrice_TextField);
        this.kdtEntrys.getColumn("basePrice").setEditor(kdtEntrys_basePrice_CellEditor);
        KDFormattedTextField kdtEntrys_receivePrice_TextField = new KDFormattedTextField();
        kdtEntrys_receivePrice_TextField.setName("kdtEntrys_receivePrice_TextField");
        kdtEntrys_receivePrice_TextField.setVisible(true);
        kdtEntrys_receivePrice_TextField.setEditable(true);
        kdtEntrys_receivePrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_receivePrice_TextField.setDataType(1);
        	kdtEntrys_receivePrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_receivePrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_receivePrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_receivePrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_receivePrice_TextField);
        this.kdtEntrys.getColumn("receivePrice").setEditor(kdtEntrys_receivePrice_CellEditor);
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
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contstockingBatch		
        this.contstockingBatch.setBoundLabelText(resHelper.getString("contstockingBatch.boundLabelText"));		
        this.contstockingBatch.setBoundLabelLength(100);		
        this.contstockingBatch.setBoundLabelUnderline(true);		
        this.contstockingBatch.setVisible(true);
        // contstockingBatchNum		
        this.contstockingBatchNum.setBoundLabelText(resHelper.getString("contstockingBatchNum.boundLabelText"));		
        this.contstockingBatchNum.setBoundLabelLength(100);		
        this.contstockingBatchNum.setBoundLabelUnderline(true);		
        this.contstockingBatchNum.setVisible(true);
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
        // contqty		
        this.contqty.setBoundLabelText(resHelper.getString("contqty.boundLabelText"));		
        this.contqty.setBoundLabelLength(100);		
        this.contqty.setBoundLabelUnderline(true);		
        this.contqty.setVisible(false);
        // contbatchContract		
        this.contbatchContract.setBoundLabelText(resHelper.getString("contbatchContract.boundLabelText"));		
        this.contbatchContract.setBoundLabelLength(100);		
        this.contbatchContract.setBoundLabelUnderline(true);		
        this.contbatchContract.setVisible(false);
        // contfemaleQty		
        this.contfemaleQty.setBoundLabelText(resHelper.getString("contfemaleQty.boundLabelText"));		
        this.contfemaleQty.setBoundLabelLength(100);		
        this.contfemaleQty.setBoundLabelUnderline(true);		
        this.contfemaleQty.setVisible(false);
        // chkisInit		
        this.chkisInit.setText(resHelper.getString("chkisInit.text"));		
        this.chkisInit.setHorizontalAlignment(2);
        // conthouse		
        this.conthouse.setBoundLabelText(resHelper.getString("conthouse.boundLabelText"));		
        this.conthouse.setBoundLabelLength(100);		
        this.conthouse.setBoundLabelUnderline(true);		
        this.conthouse.setVisible(false);
        // contvoucherNum		
        this.contvoucherNum.setBoundLabelText(resHelper.getString("contvoucherNum.boundLabelText"));		
        this.contvoucherNum.setBoundLabelLength(100);		
        this.contvoucherNum.setBoundLabelUnderline(true);		
        this.contvoucherNum.setVisible(false);
        // chkhasComfirm		
        this.chkhasComfirm.setText(resHelper.getString("chkhasComfirm.text"));		
        this.chkhasComfirm.setVisible(false);		
        this.chkhasComfirm.setHorizontalAlignment(2);		
        this.chkhasComfirm.setEnabled(false);
        // contconfirmTime		
        this.contconfirmTime.setBoundLabelText(resHelper.getString("contconfirmTime.boundLabelText"));		
        this.contconfirmTime.setBoundLabelLength(100);		
        this.contconfirmTime.setBoundLabelUnderline(true);		
        this.contconfirmTime.setVisible(false);
        // contsex		
        this.contsex.setBoundLabelText(resHelper.getString("contsex.boundLabelText"));		
        this.contsex.setBoundLabelLength(100);		
        this.contsex.setBoundLabelUnderline(true);		
        this.contsex.setVisible(true);
        // chkisMatOut		
        this.chkisMatOut.setText(resHelper.getString("chkisMatOut.text"));		
        this.chkisMatOut.setHorizontalAlignment(2);		
        this.chkisMatOut.setEnabled(false);
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
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(false);		
        this.prmtfarmer.setVisible(false);
        		prmtfarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI prmtfarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmer_F7ListUI == null) {
					try {
						prmtfarmer_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarmer_F7ListUI));
					prmtfarmer_F7ListUI.setF7Use(true,ctx);
					prmtfarmer.setSelector(prmtfarmer_F7ListUI);
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
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(true);
        		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarm_F7ListUI));
					prmtfarm_F7ListUI.setF7Use(true,ctx);
					prmtfarm.setSelector(prmtfarm_F7ListUI);
				}
			}
		});
					
        // prmtstockingBatch		
        this.prmtstockingBatch.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");		
        this.prmtstockingBatch.setEditable(true);		
        this.prmtstockingBatch.setDisplayFormat("$number$");		
        this.prmtstockingBatch.setEditFormat("$number$");		
        this.prmtstockingBatch.setCommitFormat("$number$");		
        this.prmtstockingBatch.setRequired(false);
        		prmtstockingBatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI prmtstockingBatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtstockingBatch_F7ListUI == null) {
					try {
						prmtstockingBatch_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtstockingBatch_F7ListUI));
					prmtstockingBatch_F7ListUI.setF7Use(true,ctx);
					prmtstockingBatch.setSelector(prmtstockingBatch_F7ListUI);
				}
			}
		});
					
        prmtstockingBatch.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtstockingBatch_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtstockingBatchNum		
        this.txtstockingBatchNum.setHorizontalAlignment(2);		
        this.txtstockingBatchNum.setMaxLength(100);		
        this.txtstockingBatchNum.setRequired(true);
        // prmtbreedData		
        this.prmtbreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
        this.prmtbreedData.setEditable(true);		
        this.prmtbreedData.setDisplayFormat("$name$");		
        this.prmtbreedData.setEditFormat("$number$");		
        this.prmtbreedData.setCommitFormat("$number$");		
        this.prmtbreedData.setRequired(true);
        		prmtbreedData.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI prmtbreedData_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbreedData_F7ListUI == null) {
					try {
						prmtbreedData_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbreedData_F7ListUI));
					prmtbreedData_F7ListUI.setF7Use(true,ctx);
					prmtbreedData.setSelector(prmtbreedData_F7ListUI);
				}
			}
		});
					
        // txtqty		
        this.txtqty.setHorizontalAlignment(2);		
        this.txtqty.setDataType(1);		
        this.txtqty.setSupportedEmpty(true);		
        this.txtqty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtqty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtqty.setPrecision(4);		
        this.txtqty.setRequired(false);
        // prmtbatchContract		
        this.prmtbatchContract.setQueryInfo("com.kingdee.eas.farm.stocking.processbizill.app.BatchContractQuery");		
        this.prmtbatchContract.setEditable(true);		
        this.prmtbatchContract.setDisplayFormat("$number$");		
        this.prmtbatchContract.setEditFormat("$number$");		
        this.prmtbatchContract.setCommitFormat("$number$");		
        this.prmtbatchContract.setRequired(false);		
        this.prmtbatchContract.setVisible(false);
        prmtbatchContract.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtbatchContract_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtfemaleQty		
        this.txtfemaleQty.setHorizontalAlignment(2);		
        this.txtfemaleQty.setDataType(1);		
        this.txtfemaleQty.setSupportedEmpty(true);		
        this.txtfemaleQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfemaleQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfemaleQty.setPrecision(4);		
        this.txtfemaleQty.setRequired(false);
        // prmthouse		
        this.prmthouse.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");		
        this.prmthouse.setEditable(true);		
        this.prmthouse.setDisplayFormat("$name$");		
        this.prmthouse.setEditFormat("$number$");		
        this.prmthouse.setCommitFormat("$number$");		
        this.prmthouse.setRequired(false);
        // txtvoucherNum		
        this.txtvoucherNum.setVisible(false);		
        this.txtvoucherNum.setHorizontalAlignment(2);		
        this.txtvoucherNum.setMaxLength(100);		
        this.txtvoucherNum.setRequired(false);		
        this.txtvoucherNum.setEnabled(false);
        // pkconfirmTime		
        this.pkconfirmTime.setVisible(false);		
        this.pkconfirmTime.setRequired(false);		
        this.pkconfirmTime.setEnabled(false);
        // sex		
        this.sex.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.app.sex").toArray());		
        this.sex.setRequired(true);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        // newSeparator3
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,billStatus,prmtcompany,pkauditTime,prmtfarmer,prmtstorageOrgUnit,prmtfarm,prmtstockingBatch,txtstockingBatchNum,prmtbreedData,txtqty,prmtbatchContract,txtfemaleQty,chkisInit,prmthouse,txtvoucherNum,chkhasComfirm,pkconfirmTime,sex,chkisMatOut,kdtEntrys}));
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
        contCreator.setBounds(new Rectangle(379, 547, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(379, 547, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(730, 547, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(730, 547, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(379, 580, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(379, 580, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(730, 580, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(730, 580, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(20, 13, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(20, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(371, 13, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(371, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(373, 106, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(373, 106, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(29, 547, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(29, 547, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(690, 13, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(690, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(690, 44, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(690, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(29, 580, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(29, 580, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(18, 532, 980, 10));
        this.add(kDSeparator8, new KDLayout.Constraints(18, 532, 980, 10, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(1, 135, 986, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(1, 135, 986, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmer.setBounds(new Rectangle(48, 151, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(48, 151, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(22, 144, 943, 373));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(22, 144, 943, 373, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contstorageOrgUnit.setBounds(new Rectangle(690, 75, 270, 19));
        this.add(contstorageOrgUnit, new KDLayout.Constraints(690, 75, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarm.setBounds(new Rectangle(18, 46, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(18, 46, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstockingBatch.setBounds(new Rectangle(372, 74, 270, 19));
        this.add(contstockingBatch, new KDLayout.Constraints(372, 74, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstockingBatchNum.setBounds(new Rectangle(18, 77, 270, 19));
        this.add(contstockingBatchNum, new KDLayout.Constraints(18, 77, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedData.setBounds(new Rectangle(372, 43, 270, 19));
        this.add(contbreedData, new KDLayout.Constraints(372, 43, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contqty.setBounds(new Rectangle(974, 109, 270, 19));
        this.add(contqty, new KDLayout.Constraints(974, 109, 270, 19, 0));
        contbatchContract.setBounds(new Rectangle(133, 140, 270, 19));
        this.add(contbatchContract, new KDLayout.Constraints(133, 140, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfemaleQty.setBounds(new Rectangle(970, 77, 270, 19));
        this.add(contfemaleQty, new KDLayout.Constraints(970, 77, 270, 19, 0));
        chkisInit.setBounds(new Rectangle(687, 1, 270, 19));
        this.add(chkisInit, new KDLayout.Constraints(687, 1, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conthouse.setBounds(new Rectangle(29, 167, 270, 19));
        this.add(conthouse, new KDLayout.Constraints(29, 167, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contvoucherNum.setBounds(new Rectangle(371, 137, 270, 19));
        this.add(contvoucherNum, new KDLayout.Constraints(371, 137, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkhasComfirm.setBounds(new Rectangle(20, 167, 270, 19));
        this.add(chkhasComfirm, new KDLayout.Constraints(20, 167, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contconfirmTime.setBounds(new Rectangle(371, 167, 270, 19));
        this.add(contconfirmTime, new KDLayout.Constraints(371, 167, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsex.setBounds(new Rectangle(18, 108, 270, 19));
        this.add(contsex, new KDLayout.Constraints(18, 108, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisMatOut.setBounds(new Rectangle(690, 106, 119, 19));
        this.add(chkisMatOut, new KDLayout.Constraints(690, 106, 119, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contstorageOrgUnit
        contstorageOrgUnit.setBoundEditor(prmtstorageOrgUnit);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contstockingBatch
        contstockingBatch.setBoundEditor(prmtstockingBatch);
        //contstockingBatchNum
        contstockingBatchNum.setBoundEditor(txtstockingBatchNum);
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //contqty
        contqty.setBoundEditor(txtqty);
        //contbatchContract
        contbatchContract.setBoundEditor(prmtbatchContract);
        //contfemaleQty
        contfemaleQty.setBoundEditor(txtfemaleQty);
        //conthouse
        conthouse.setBoundEditor(prmthouse);
        //contvoucherNum
        contvoucherNum.setBoundEditor(txtvoucherNum);
        //contconfirmTime
        contconfirmTime.setBoundEditor(pkconfirmTime);
        //contsex
        contsex.setBoundEditor(sex);

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


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.receiveQty", java.math.BigDecimal.class, this.kdtEntrys, "receiveQty.text");
		dataBinder.registerBinding("entrys.receivePrice", java.math.BigDecimal.class, this.kdtEntrys, "receivePrice.text");
		dataBinder.registerBinding("entrys.warehouse", java.lang.Object.class, this.kdtEntrys, "warehouse.text");
		dataBinder.registerBinding("entrys.confirmQty", java.math.BigDecimal.class, this.kdtEntrys, "confirmQty.text");
		dataBinder.registerBinding("entrys.basePrice", java.math.BigDecimal.class, this.kdtEntrys, "basePrice.text");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.materialName", String.class, this.kdtEntrys, "materialName.text");
		dataBinder.registerBinding("entrys.model", String.class, this.kdtEntrys, "model.text");
		dataBinder.registerBinding("entrys.unit", java.lang.Object.class, this.kdtEntrys, "unit.text");
		dataBinder.registerBinding("entrys.amount", java.math.BigDecimal.class, this.kdtEntrys, "amount.text");
		dataBinder.registerBinding("entrys.supplementQty", java.math.BigDecimal.class, this.kdtEntrys, "supplementQty.text");
		dataBinder.registerBinding("entrys.lossQty", java.math.BigDecimal.class, this.kdtEntrys, "lossQty.text");
		dataBinder.registerBinding("entrys.allReceiveQty", java.math.BigDecimal.class, this.kdtEntrys, "allReceiveQty.text");
		dataBinder.registerBinding("entrys.house", java.lang.Object.class, this.kdtEntrys, "house.text");
		dataBinder.registerBinding("entrys.henQty", java.math.BigDecimal.class, this.kdtEntrys, "henQty.text");
		dataBinder.registerBinding("entrys.cockQty", java.math.BigDecimal.class, this.kdtEntrys, "cockQty.text");
		dataBinder.registerBinding("isInit", boolean.class, this.chkisInit, "selected");
		dataBinder.registerBinding("hasComfirm", boolean.class, this.chkhasComfirm, "selected");
		dataBinder.registerBinding("isMatOut", boolean.class, this.chkisMatOut, "selected");
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
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.stocking.basedata.FarmersInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrgUnit, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.stocking.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("stockingBatch", com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo.class, this.prmtstockingBatch, "data");
		dataBinder.registerBinding("stockingBatchNum", String.class, this.txtstockingBatchNum, "text");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("qty", java.math.BigDecimal.class, this.txtqty, "value");
		dataBinder.registerBinding("batchContract", com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo.class, this.prmtbatchContract, "data");
		dataBinder.registerBinding("femaleQty", java.math.BigDecimal.class, this.txtfemaleQty, "value");
		dataBinder.registerBinding("house", com.kingdee.eas.farm.stocking.basedata.FarmInfo.class, this.prmthouse, "data");
		dataBinder.registerBinding("voucherNum", String.class, this.txtvoucherNum, "text");
		dataBinder.registerBinding("confirmTime", java.util.Date.class, this.pkconfirmTime, "value");
		dataBinder.registerBinding("sex", com.kingdee.eas.farm.stocking.basedata.app.sex.class, this.sex, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.processbizill.app.BreedSeedBillEditUIHandler";
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
        this.txtNumber.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.receiveQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.receivePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.warehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.confirmQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.basePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.supplementQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lossQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.allReceiveQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cockQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isInit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hasComfirm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isMatOut", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stockingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stockingBatchNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("femaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("voucherNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("confirmTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sex", ValidateHelper.ON_SAVE);    		
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
            if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"model")));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"baseUnit"));

}


    }

    /**
     * output prmtstockingBatch_Changed() method
     */
    public void prmtstockingBatch_Changed() throws Exception
    {
        System.out.println("prmtstockingBatch_Changed() Function is executed!");
            txtstockingBatchNum.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtstockingBatch.getData(),"number")));


    }

    /**
     * output prmtbatchContract_Changed() method
     */
    public void prmtbatchContract_Changed() throws Exception
    {
        System.out.println("prmtbatchContract_Changed() Function is executed!");
            prmtfarmer.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"farmer"));
;
prmtstockingBatch.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"stockingBatch"));
prmtfarm.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"farm"));


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
    	sic.add(new SelectorItemInfo("entrys.receiveQty"));
    	sic.add(new SelectorItemInfo("entrys.receivePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.warehouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.warehouse.id"));
			sic.add(new SelectorItemInfo("entrys.warehouse.name"));
        	sic.add(new SelectorItemInfo("entrys.warehouse.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.confirmQty"));
    	sic.add(new SelectorItemInfo("entrys.basePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.material.id"));
			sic.add(new SelectorItemInfo("entrys.material.number"));
			sic.add(new SelectorItemInfo("entrys.material.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.materialName"));
    	sic.add(new SelectorItemInfo("entrys.model"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.unit.id"));
			sic.add(new SelectorItemInfo("entrys.unit.name"));
        	sic.add(new SelectorItemInfo("entrys.unit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.amount"));
    	sic.add(new SelectorItemInfo("entrys.supplementQty"));
    	sic.add(new SelectorItemInfo("entrys.lossQty"));
    	sic.add(new SelectorItemInfo("entrys.allReceiveQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.house.id"));
			sic.add(new SelectorItemInfo("entrys.house.name"));
        	sic.add(new SelectorItemInfo("entrys.house.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.henQty"));
    	sic.add(new SelectorItemInfo("entrys.cockQty"));
        sic.add(new SelectorItemInfo("isInit"));
        sic.add(new SelectorItemInfo("hasComfirm"));
        sic.add(new SelectorItemInfo("isMatOut"));
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
			sic.add(new SelectorItemInfo("farmer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmer.id"));
        	sic.add(new SelectorItemInfo("farmer.number"));
        	sic.add(new SelectorItemInfo("farmer.name"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stockingBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stockingBatch.id"));
        	sic.add(new SelectorItemInfo("stockingBatch.number"));
        	sic.add(new SelectorItemInfo("stockingBatch.name"));
		}
        sic.add(new SelectorItemInfo("stockingBatchNum"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
		}
        sic.add(new SelectorItemInfo("qty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("batchContract.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("batchContract.id"));
        	sic.add(new SelectorItemInfo("batchContract.number"));
		}
        sic.add(new SelectorItemInfo("femaleQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("house.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("house.id"));
        	sic.add(new SelectorItemInfo("house.number"));
        	sic.add(new SelectorItemInfo("house.name"));
		}
        sic.add(new SelectorItemInfo("voucherNum"));
        sic.add(new SelectorItemInfo("confirmTime"));
        sic.add(new SelectorItemInfo("sex"));
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
        com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionChkVoucherAll_actionPerformed method
     */
    public void actionChkVoucherAll_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillFactory.getRemoteInstance().chkVoucherAll(editData);
    }
    	

    /**
     * output actionChkVoucherFlag_actionPerformed method
     */
    public void actionChkVoucherFlag_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillFactory.getRemoteInstance().chkVoucherFlag(editData);
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
	public RequestContext prepareActionChkVoucherAll(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionChkVoucherAll() {
    	return false;
    }
	public RequestContext prepareActionChkVoucherFlag(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionChkVoucherFlag() {
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
            innerActionPerformed("eas", AbstractBreedSeedBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBreedSeedBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionChkVoucherAll class
     */     
    protected class ActionChkVoucherAll extends ItemAction {     
    
        public ActionChkVoucherAll()
        {
            this(null);
        }

        public ActionChkVoucherAll(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionChkVoucherAll.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionChkVoucherAll.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionChkVoucherAll.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBreedSeedBillEditUI.this, "ActionChkVoucherAll", "actionChkVoucherAll_actionPerformed", e);
        }
    }

    /**
     * output ActionChkVoucherFlag class
     */     
    protected class ActionChkVoucherFlag extends ItemAction {     
    
        public ActionChkVoucherFlag()
        {
            this(null);
        }

        public ActionChkVoucherFlag(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionChkVoucherFlag.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionChkVoucherFlag.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionChkVoucherFlag.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBreedSeedBillEditUI.this, "ActionChkVoucherFlag", "actionChkVoucherFlag_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.client", "BreedSeedBillEditUI");
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
        return com.kingdee.eas.farm.stocking.processbizill.client.BreedSeedBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/stocking/processbizill/BreedSeedBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.app.BreedSeedBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"material").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"种苗编码"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"unit").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单位"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"warehouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"领用仓库"});
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
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtstockingBatchNum.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"批次号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedData.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"品种"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(sex.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"性别"});
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
vo.put("sex","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}