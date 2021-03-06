/**
 * output package name
 */
package com.kingdee.eas.farm.food.client;

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
public abstract class AbstractCManufactureBillEditUI extends com.kingdee.eas.scm.im.inv.client.InvBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCManufactureBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kdCreatDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kdModifyDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contTransactionType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contStorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDepartment;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSourceBillType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contTotalAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAddStandardCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAddFactCost;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkIsOffset;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox cboxIsInitBill;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizInventory;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conCostCenter;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBackFlush;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labBizType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkCreatDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkModifyDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkAuditDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox comboBaseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtTransactionType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtStorageOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtDepartment;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSourceBillType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtTotalAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtAddStandardCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtAddFactCost;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prtmtCostCenter;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDComboBox comboxBackFlush;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPrmtBizType;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnOffSet;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnBackFlush;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnBackFlush;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnInteractionBackFlush;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnQuickAddLine;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemOffset;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemBackFlush;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemUnBackFlush;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemQuickAddLine;
    protected com.kingdee.eas.farm.food.CManufactureBillInfo editData = null;
    protected ActionOffSet actionOffSet = null;
    protected ActionQuickAddLine actionQuickAddLine = null;
    protected ActionBackFlush actionBackFlush = null;
    protected ActionUnBackFlush actionUnBackFlush = null;
    protected actionInteractionBackFlush actionInteractionBackFlush = null;
    /**
     * output class constructor
     */
    public AbstractCManufactureBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCManufactureBillEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionSubmit
        String _tempStr = null;
        actionSubmit.setEnabled(true);
        actionSubmit.setDaemonRun(false);

        actionSubmit.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
        actionSubmit.putValue(ItemAction.MNEMONIC_KEY, new Integer(KeyEvent.VK_S));
        _tempStr = resHelper.getString("ActionSubmit.SHORT_DESCRIPTION");
        actionSubmit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.LONG_DESCRIPTION");
        actionSubmit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.NAME");
        actionSubmit.putValue(ItemAction.NAME, _tempStr);
        this.actionSubmit.setBindWorkFlow(true);
        this.actionSubmit.setExtendProperty("Mutex", "Lock_SCMIM_CloseAccount,0");
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionAddNew
        actionAddNew.setEnabled(true);
        actionAddNew.setDaemonRun(false);

        actionAddNew.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl N"));
        _tempStr = resHelper.getString("ActionAddNew.SHORT_DESCRIPTION");
        actionAddNew.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAddNew.LONG_DESCRIPTION");
        actionAddNew.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAddNew.NAME");
        actionAddNew.putValue(ItemAction.NAME, _tempStr);
        this.actionAddNew.setExtendProperty("Mutex", "Lock_SCMIM_CloseAccount,0");
         this.actionAddNew.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAddNew.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionAddNew.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionEdit
        actionEdit.setEnabled(true);
        actionEdit.setDaemonRun(false);

        _tempStr = resHelper.getString("ActionEdit.SHORT_DESCRIPTION");
        actionEdit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionEdit.LONG_DESCRIPTION");
        actionEdit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionEdit.NAME");
        actionEdit.putValue(ItemAction.NAME, _tempStr);
        this.actionEdit.setExtendProperty("Mutex", "Lock_SCMIM_CloseAccount,0");
         this.actionEdit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionEdit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionEdit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionMultiapprove
        actionMultiapprove.setEnabled(true);
        actionMultiapprove.setDaemonRun(false);

        _tempStr = resHelper.getString("ActionMultiapprove.SHORT_DESCRIPTION");
        actionMultiapprove.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionMultiapprove.LONG_DESCRIPTION");
        actionMultiapprove.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionMultiapprove.NAME");
        actionMultiapprove.putValue(ItemAction.NAME, _tempStr);
         this.actionMultiapprove.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionNextPerson
        actionNextPerson.setEnabled(true);
        actionNextPerson.setDaemonRun(false);

        _tempStr = resHelper.getString("ActionNextPerson.SHORT_DESCRIPTION");
        actionNextPerson.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionNextPerson.LONG_DESCRIPTION");
        actionNextPerson.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionNextPerson.NAME");
        actionNextPerson.putValue(ItemAction.NAME, _tempStr);
         this.actionNextPerson.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionAudit
        actionAudit.setEnabled(true);
        actionAudit.setDaemonRun(false);

        actionAudit.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl F9"));
        _tempStr = resHelper.getString("ActionAudit.SHORT_DESCRIPTION");
        actionAudit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAudit.LONG_DESCRIPTION");
        actionAudit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAudit.NAME");
        actionAudit.putValue(ItemAction.NAME, _tempStr);
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionOffSet
        this.actionOffSet = new ActionOffSet(this);
        getActionManager().registerAction("actionOffSet", actionOffSet);
         this.actionOffSet.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionQuickAddLine
        this.actionQuickAddLine = new ActionQuickAddLine(this);
        getActionManager().registerAction("actionQuickAddLine", actionQuickAddLine);
         this.actionQuickAddLine.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionBackFlush
        this.actionBackFlush = new ActionBackFlush(this);
        getActionManager().registerAction("actionBackFlush", actionBackFlush);
         this.actionBackFlush.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionUnBackFlush
        this.actionUnBackFlush = new ActionUnBackFlush(this);
        getActionManager().registerAction("actionUnBackFlush", actionUnBackFlush);
         this.actionUnBackFlush.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionInteractionBackFlush
        this.actionInteractionBackFlush = new actionInteractionBackFlush(this);
        getActionManager().registerAction("actionInteractionBackFlush", actionInteractionBackFlush);
         this.actionInteractionBackFlush.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdCreatDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdModifyDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contTransactionType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contStorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDepartment = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSourceBillType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contTotalAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAddStandardCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAddFactCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkIsOffset = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.cboxIsInitBill = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.bizInventory = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.conCostCenter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBackFlush = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labBizType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkCreatDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkModifyDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkAuditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.comboBaseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtTransactionType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtStorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtDepartment = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtSourceBillType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtTotalAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtAddStandardCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtAddFactCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prtmtCostCenter = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.comboxBackFlush = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.bizPrmtBizType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnOffSet = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnBackFlush = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnBackFlush = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnInteractionBackFlush = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnQuickAddLine = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.menuItemOffset = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemBackFlush = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemUnBackFlush = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemQuickAddLine = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.contCreator.setName("contCreator");
        this.kdCreatDate.setName("kdCreatDate");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.kdModifyDate.setName("kdModifyDate");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contAuditor.setName("contAuditor");
        this.contAuditTime.setName("contAuditTime");
        this.contBaseStatus.setName("contBaseStatus");
        this.contTransactionType.setName("contTransactionType");
        this.contStorageOrgUnit.setName("contStorageOrgUnit");
        this.contDepartment.setName("contDepartment");
        this.contSourceBillType.setName("contSourceBillType");
        this.contTotalAmount.setName("contTotalAmount");
        this.contAddStandardCost.setName("contAddStandardCost");
        this.contAddFactCost.setName("contAddFactCost");
        this.chkIsOffset.setName("chkIsOffset");
        this.kdtEntry.setName("kdtEntry");
        this.cboxIsInitBill.setName("cboxIsInitBill");
        this.bizInventory.setName("bizInventory");
        this.conCostCenter.setName("conCostCenter");
        this.contDescription.setName("contDescription");
        this.contBackFlush.setName("contBackFlush");
        this.labBizType.setName("labBizType");
        this.prmtCreator.setName("prmtCreator");
        this.pkCreatDate.setName("pkCreatDate");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.pkModifyDate.setName("pkModifyDate");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkAuditDate.setName("pkAuditDate");
        this.comboBaseStatus.setName("comboBaseStatus");
        this.prmtTransactionType.setName("prmtTransactionType");
        this.prmtStorageOrgUnit.setName("prmtStorageOrgUnit");
        this.prmtDepartment.setName("prmtDepartment");
        this.prmtSourceBillType.setName("prmtSourceBillType");
        this.txtTotalAmount.setName("txtTotalAmount");
        this.txtAddStandardCost.setName("txtAddStandardCost");
        this.txtAddFactCost.setName("txtAddFactCost");
        this.prtmtCostCenter.setName("prtmtCostCenter");
        this.txtDescription.setName("txtDescription");
        this.comboxBackFlush.setName("comboxBackFlush");
        this.bizPrmtBizType.setName("bizPrmtBizType");
        this.btnOffSet.setName("btnOffSet");
        this.btnBackFlush.setName("btnBackFlush");
        this.btnUnBackFlush.setName("btnUnBackFlush");
        this.btnInteractionBackFlush.setName("btnInteractionBackFlush");
        this.btnQuickAddLine.setName("btnQuickAddLine");
        this.menuItemOffset.setName("menuItemOffset");
        this.menuItemBackFlush.setName("menuItemBackFlush");
        this.menuItemUnBackFlush.setName("menuItemUnBackFlush");
        this.menuItemQuickAddLine.setName("menuItemQuickAddLine");
        // CoreUI		
        this.setPreferredSize(new Dimension(1013,629));		
        this.btnCancelCancel.setVisible(false);		
        this.btnCancelCancel.setEnabled(false);		
        this.btnCancel.setEnabled(false);		
        this.btnCancel.setVisible(false);		
        this.kDSeparator3.setVisible(true);		
        this.separatorFile1.setVisible(false);		
        this.separatorFile1.setEnabled(false);		
        this.separatorFW7.setVisible(false);		
        this.btnCopyFrom.setVisible(false);		
        this.btnCopyFrom.setEnabled(false);		
        this.MenuItemVoucher.setVisible(true);		
        this.menuItemDelVoucher.setVisible(true);		
        this.separatorWF1.setVisible(true);		
        this.separatorWF1.setEnabled(true);		
        this.menuItemAuditResult.setVisible(false);		
        this.separator4.setOrientation(1);		
        this.separator5.setOrientation(1);		
        this.separator6.setOrientation(1);		
        this.separator7.setEnabled(true);		
        this.separator7.setVisible(true);		
        this.btnSplitLine.setVisible(true);		
        this.btnSplitLine.setToolTipText(resHelper.getString("btnSplitLine.toolTipText"));		
        this.menuItemQueryGeneralInventory.setText(resHelper.getString("menuItemQueryGeneralInventory.text"));		
        this.menuItemQueryGeneralInventory.setMnemonic(84);		
        this.menuItemQueryByMaterial.setText(resHelper.getString("menuItemQueryByMaterial.text"));		
        this.menuItemQueryByMaterial.setMnemonic(67);		
        this.menuItemMaterialView.setText(resHelper.getString("menuItemMaterialView.text"));		
        this.menuItemMaterialView.setMnemonic(65);		
        this.btnSerialNumber.setVisible(true);		
        this.menuItemSerialNumber.setVisible(true);
        // contCreator		
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setBoundLabelAlignment(7);		
        this.contCreator.setVisible(true);
        // kdCreatDate		
        this.kdCreatDate.setBoundLabelText(resHelper.getString("kdCreatDate.boundLabelText"));		
        this.kdCreatDate.setBoundLabelLength(100);		
        this.kdCreatDate.setBoundLabelUnderline(true);		
        this.kdCreatDate.setBoundLabelAlignment(7);		
        this.kdCreatDate.setVisible(true);
        // contLastUpdateUser		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setBoundLabelAlignment(7);		
        this.contLastUpdateUser.setVisible(true);
        // kdModifyDate		
        this.kdModifyDate.setBoundLabelText(resHelper.getString("kdModifyDate.boundLabelText"));		
        this.kdModifyDate.setBoundLabelLength(100);		
        this.kdModifyDate.setBoundLabelUnderline(true);		
        this.kdModifyDate.setBoundLabelAlignment(7);		
        this.kdModifyDate.setVisible(true);
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);		
        this.contNumber.setBoundLabelAlignment(7);		
        this.contNumber.setVisible(true);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contAuditor.setBoundLabelAlignment(7);		
        this.contAuditor.setVisible(true);
        // contAuditTime		
        this.contAuditTime.setBoundLabelText(resHelper.getString("contAuditTime.boundLabelText"));		
        this.contAuditTime.setBoundLabelLength(100);		
        this.contAuditTime.setBoundLabelUnderline(true);		
        this.contAuditTime.setBoundLabelAlignment(7);		
        this.contAuditTime.setVisible(true);
        // contBaseStatus		
        this.contBaseStatus.setBoundLabelText(resHelper.getString("contBaseStatus.boundLabelText"));		
        this.contBaseStatus.setBoundLabelLength(100);		
        this.contBaseStatus.setBoundLabelUnderline(true);		
        this.contBaseStatus.setBoundLabelAlignment(7);		
        this.contBaseStatus.setVisible(true);		
        this.contBaseStatus.setForeground(new java.awt.Color(0,0,0));
        // contTransactionType		
        this.contTransactionType.setBoundLabelText(resHelper.getString("contTransactionType.boundLabelText"));		
        this.contTransactionType.setBoundLabelLength(100);		
        this.contTransactionType.setBoundLabelUnderline(true);		
        this.contTransactionType.setBoundLabelAlignment(7);		
        this.contTransactionType.setVisible(true);
        // contStorageOrgUnit		
        this.contStorageOrgUnit.setBoundLabelText(resHelper.getString("contStorageOrgUnit.boundLabelText"));		
        this.contStorageOrgUnit.setBoundLabelLength(100);		
        this.contStorageOrgUnit.setBoundLabelUnderline(true);		
        this.contStorageOrgUnit.setBoundLabelAlignment(7);		
        this.contStorageOrgUnit.setVisible(true);
        // contDepartment		
        this.contDepartment.setBoundLabelText(resHelper.getString("contDepartment.boundLabelText"));		
        this.contDepartment.setBoundLabelLength(100);		
        this.contDepartment.setBoundLabelUnderline(true);		
        this.contDepartment.setBoundLabelAlignment(7);		
        this.contDepartment.setVisible(true);
        // contSourceBillType		
        this.contSourceBillType.setBoundLabelText(resHelper.getString("contSourceBillType.boundLabelText"));		
        this.contSourceBillType.setBoundLabelLength(100);		
        this.contSourceBillType.setBoundLabelUnderline(true);		
        this.contSourceBillType.setBoundLabelAlignment(7);		
        this.contSourceBillType.setVisible(true);
        // contTotalAmount		
        this.contTotalAmount.setBoundLabelText(resHelper.getString("contTotalAmount.boundLabelText"));		
        this.contTotalAmount.setBoundLabelLength(100);		
        this.contTotalAmount.setBoundLabelUnderline(true);		
        this.contTotalAmount.setVisible(false);		
        this.contTotalAmount.setBoundLabelAlignment(7);
        // contAddStandardCost		
        this.contAddStandardCost.setBoundLabelText(resHelper.getString("contAddStandardCost.boundLabelText"));		
        this.contAddStandardCost.setBoundLabelLength(100);		
        this.contAddStandardCost.setBoundLabelUnderline(true);		
        this.contAddStandardCost.setBoundLabelAlignment(7);		
        this.contAddStandardCost.setVisible(false);
        // contAddFactCost		
        this.contAddFactCost.setBoundLabelText(resHelper.getString("contAddFactCost.boundLabelText"));		
        this.contAddFactCost.setBoundLabelLength(100);		
        this.contAddFactCost.setBoundLabelUnderline(true);		
        this.contAddFactCost.setBoundLabelAlignment(7);		
        this.contAddFactCost.setVisible(false);
        // chkIsOffset		
        this.chkIsOffset.setText(resHelper.getString("chkIsOffset.text"));		
        this.chkIsOffset.setEnabled(false);		
        this.chkIsOffset.setVisible(true);		
        this.chkIsOffset.setHorizontalAlignment(2);
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol17\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol40\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" t:styleID=\"sCol0\" /><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" t:styleID=\"sCol1\" /><t:Column t:key=\"unitPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" t:styleID=\"sCol2\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" t:styleID=\"sCol3\" /><t:Column t:key=\"periodValid\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" t:styleID=\"sCol4\" /><t:Column t:key=\"periodValidUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"invUpdateType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"6\" /><t:Column t:key=\"material.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" /><t:Column t:key=\"material.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"material.model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"assistantAttr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" /><t:Column t:key=\"lot\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" /><t:Column t:key=\"mfg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" /><t:Column t:key=\"exp\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" /><t:Column t:key=\"mainAdminOrgUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" /><t:Column t:key=\"costCenterOrgUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" /><t:Column t:key=\"costObject\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" /><t:Column t:key=\"costObjectName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"17\" t:styleID=\"sCol17\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"18\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"19\" /><t:Column t:key=\"baseUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"20\" /><t:Column t:key=\"baseQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"21\" /><t:Column t:key=\"assistantUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"22\" /><t:Column t:key=\"assistantQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"23\" /><t:Column t:key=\"warehouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"24\" /><t:Column t:key=\"stocker\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"25\" /><t:Column t:key=\"location\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"26\" /><t:Column t:key=\"unitStandardCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"27\" /><t:Column t:key=\"standardCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"28\" /><t:Column t:key=\"unitFactCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"29\" /><t:Column t:key=\"factCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"30\" /><t:Column t:key=\"countervailQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"31\" /><t:Column t:key=\"manufactureBillNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"32\" /><t:Column t:key=\"manuBillEntrySeq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"33\" /><t:Column t:key=\"saleOrderNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"34\" /><t:Column t:key=\"saleOrderEntrySeq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"35\" /><t:Column t:key=\"projectNumCol\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"36\" /><t:Column t:key=\"trackNumCol\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"37\" /><t:Column t:key=\"receiveQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"38\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"39\" /><t:Column t:key=\"isSerialNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol40\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{unitPrice}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{periodValid}</t:Cell><t:Cell>$Resource{periodValidUnit}</t:Cell><t:Cell>$Resource{invUpdateType}</t:Cell><t:Cell>$Resource{material.number}</t:Cell><t:Cell>$Resource{material.name}</t:Cell><t:Cell>$Resource{material.model}</t:Cell><t:Cell>$Resource{assistantAttr}</t:Cell><t:Cell>$Resource{lot}</t:Cell><t:Cell>$Resource{mfg}</t:Cell><t:Cell>$Resource{exp}</t:Cell><t:Cell>$Resource{mainAdminOrgUnit}</t:Cell><t:Cell>$Resource{costCenterOrgUnit}</t:Cell><t:Cell>$Resource{costObject}</t:Cell><t:Cell>$Resource{costObjectName}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{baseUnit}</t:Cell><t:Cell>$Resource{baseQty}</t:Cell><t:Cell>$Resource{assistantUnit}</t:Cell><t:Cell>$Resource{assistantQty}</t:Cell><t:Cell>$Resource{warehouse}</t:Cell><t:Cell>$Resource{stocker}</t:Cell><t:Cell>$Resource{location}</t:Cell><t:Cell>$Resource{unitStandardCost}</t:Cell><t:Cell>$Resource{standardCost}</t:Cell><t:Cell>$Resource{unitFactCost}</t:Cell><t:Cell>$Resource{factCost}</t:Cell><t:Cell>$Resource{countervailQty}</t:Cell><t:Cell>$Resource{manufactureBillNumber}</t:Cell><t:Cell>$Resource{manuBillEntrySeq}</t:Cell><t:Cell>$Resource{saleOrderNum}</t:Cell><t:Cell>$Resource{saleOrderEntrySeq}</t:Cell><t:Cell>$Resource{projectNumCol}</t:Cell><t:Cell>$Resource{trackNumCol}</t:Cell><t:Cell>$Resource{receiveQty}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{isSerialNumber}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot> ";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));

                this.kdtEntry.putBindContents("editData",new String[] {"id","","","","","","invUpdateType","material","material.name","material.model","assistProperty","lot","mfg","exp","adminOrgUnit","costCenterOrgUnit","costObject","costObject.name","unit","qty","baseUnit","baseQty","assistUnit","assistQty","warehouse","stocker","location","unitStandardCost","standardCost","unitActualCost","actualCost","reverseQty","manuBillNumber","manuBillEntrySeq","saleOrderNum","saleOrderEntrySeq","project","trackNumber","receiveQty","remark",""});


        this.kdtEntry.checkParsed();
        final KDBizPromptBox kdtEntry_invUpdateType_PromptBox = new KDBizPromptBox();
        kdtEntry_invUpdateType_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7InvUpdateTypeQuery");
        kdtEntry_invUpdateType_PromptBox.setVisible(true);
        kdtEntry_invUpdateType_PromptBox.setEditable(true);
        kdtEntry_invUpdateType_PromptBox.setDisplayFormat("$number$");
        kdtEntry_invUpdateType_PromptBox.setEditFormat("$number$");
        kdtEntry_invUpdateType_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_invUpdateType_CellEditor = new KDTDefaultCellEditor(kdtEntry_invUpdateType_PromptBox);
        this.kdtEntry.getColumn("invUpdateType").setEditor(kdtEntry_invUpdateType_CellEditor);
        ObjectValueRender kdtEntry_invUpdateType_OVR = new ObjectValueRender();
        kdtEntry_invUpdateType_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("invUpdateType").setRenderer(kdtEntry_invUpdateType_OVR);
        final KDBizPromptBox kdtEntry_material_number_PromptBox = new KDBizPromptBox();
        kdtEntry_material_number_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntry_material_number_PromptBox.setVisible(true);
        kdtEntry_material_number_PromptBox.setEditable(true);
        kdtEntry_material_number_PromptBox.setDisplayFormat("$number$");
        kdtEntry_material_number_PromptBox.setEditFormat("$number$");
        kdtEntry_material_number_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_material_number_CellEditor = new KDTDefaultCellEditor(kdtEntry_material_number_PromptBox);
        this.kdtEntry.getColumn("material.number").setEditor(kdtEntry_material_number_CellEditor);
        ObjectValueRender kdtEntry_material_number_OVR = new ObjectValueRender();
        kdtEntry_material_number_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("material.number").setRenderer(kdtEntry_material_number_OVR);
        KDTextField kdtEntry_material_name_TextField = new KDTextField();
        kdtEntry_material_name_TextField.setName("kdtEntry_material_name_TextField");
        kdtEntry_material_name_TextField.setMaxLength(255);
        KDTDefaultCellEditor kdtEntry_material_name_CellEditor = new KDTDefaultCellEditor(kdtEntry_material_name_TextField);
        this.kdtEntry.getColumn("material.name").setEditor(kdtEntry_material_name_CellEditor);
        KDTextField kdtEntry_material_model_TextField = new KDTextField();
        kdtEntry_material_model_TextField.setName("kdtEntry_material_model_TextField");
        kdtEntry_material_model_TextField.setMaxLength(255);
        KDTDefaultCellEditor kdtEntry_material_model_CellEditor = new KDTDefaultCellEditor(kdtEntry_material_model_TextField);
        this.kdtEntry.getColumn("material.model").setEditor(kdtEntry_material_model_CellEditor);
        final KDBizPromptBox kdtEntry_assistantAttr_PromptBox = new KDBizPromptBox();
        kdtEntry_assistantAttr_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7AsstAttrValueQuery");
        kdtEntry_assistantAttr_PromptBox.setVisible(true);
        kdtEntry_assistantAttr_PromptBox.setEditable(true);
        kdtEntry_assistantAttr_PromptBox.setDisplayFormat("$number$");
        kdtEntry_assistantAttr_PromptBox.setEditFormat("$number$");
        kdtEntry_assistantAttr_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_assistantAttr_CellEditor = new KDTDefaultCellEditor(kdtEntry_assistantAttr_PromptBox);
        this.kdtEntry.getColumn("assistantAttr").setEditor(kdtEntry_assistantAttr_CellEditor);
        ObjectValueRender kdtEntry_assistantAttr_OVR = new ObjectValueRender();
        kdtEntry_assistantAttr_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("assistantAttr").setRenderer(kdtEntry_assistantAttr_OVR);
        KDTextField kdtEntry_lot_TextField = new KDTextField();
        kdtEntry_lot_TextField.setName("kdtEntry_lot_TextField");
        kdtEntry_lot_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_lot_CellEditor = new KDTDefaultCellEditor(kdtEntry_lot_TextField);
        this.kdtEntry.getColumn("lot").setEditor(kdtEntry_lot_CellEditor);
        KDDatePicker kdtEntry_mfg_DatePicker = new KDDatePicker();
        kdtEntry_mfg_DatePicker.setName("kdtEntry_mfg_DatePicker");
        kdtEntry_mfg_DatePicker.setVisible(true);
        kdtEntry_mfg_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntry_mfg_CellEditor = new KDTDefaultCellEditor(kdtEntry_mfg_DatePicker);
        this.kdtEntry.getColumn("mfg").setEditor(kdtEntry_mfg_CellEditor);
        KDDatePicker kdtEntry_exp_DatePicker = new KDDatePicker();
        kdtEntry_exp_DatePicker.setName("kdtEntry_exp_DatePicker");
        kdtEntry_exp_DatePicker.setVisible(true);
        kdtEntry_exp_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntry_exp_CellEditor = new KDTDefaultCellEditor(kdtEntry_exp_DatePicker);
        this.kdtEntry.getColumn("exp").setEditor(kdtEntry_exp_CellEditor);
        final KDBizPromptBox kdtEntry_mainAdminOrgUnit_PromptBox = new KDBizPromptBox();
        kdtEntry_mainAdminOrgUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntry_mainAdminOrgUnit_PromptBox.setVisible(true);
        kdtEntry_mainAdminOrgUnit_PromptBox.setEditable(true);
        kdtEntry_mainAdminOrgUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntry_mainAdminOrgUnit_PromptBox.setEditFormat("$number$");
        kdtEntry_mainAdminOrgUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_mainAdminOrgUnit_CellEditor = new KDTDefaultCellEditor(kdtEntry_mainAdminOrgUnit_PromptBox);
        this.kdtEntry.getColumn("mainAdminOrgUnit").setEditor(kdtEntry_mainAdminOrgUnit_CellEditor);
        ObjectValueRender kdtEntry_mainAdminOrgUnit_OVR = new ObjectValueRender();
        kdtEntry_mainAdminOrgUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("mainAdminOrgUnit").setRenderer(kdtEntry_mainAdminOrgUnit_OVR);
        final KDBizPromptBox kdtEntry_costCenterOrgUnit_PromptBox = new KDBizPromptBox();
        kdtEntry_costCenterOrgUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");
        kdtEntry_costCenterOrgUnit_PromptBox.setVisible(true);
        kdtEntry_costCenterOrgUnit_PromptBox.setEditable(true);
        kdtEntry_costCenterOrgUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntry_costCenterOrgUnit_PromptBox.setEditFormat("$number$");
        kdtEntry_costCenterOrgUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_costCenterOrgUnit_CellEditor = new KDTDefaultCellEditor(kdtEntry_costCenterOrgUnit_PromptBox);
        this.kdtEntry.getColumn("costCenterOrgUnit").setEditor(kdtEntry_costCenterOrgUnit_CellEditor);
        ObjectValueRender kdtEntry_costCenterOrgUnit_OVR = new ObjectValueRender();
        kdtEntry_costCenterOrgUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("costCenterOrgUnit").setRenderer(kdtEntry_costCenterOrgUnit_OVR);
        final KDBizPromptBox kdtEntry_costObject_PromptBox = new KDBizPromptBox();
        kdtEntry_costObject_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");
        kdtEntry_costObject_PromptBox.setVisible(true);
        kdtEntry_costObject_PromptBox.setEditable(true);
        kdtEntry_costObject_PromptBox.setDisplayFormat("$number$");
        kdtEntry_costObject_PromptBox.setEditFormat("$number$");
        kdtEntry_costObject_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_costObject_CellEditor = new KDTDefaultCellEditor(kdtEntry_costObject_PromptBox);
        this.kdtEntry.getColumn("costObject").setEditor(kdtEntry_costObject_CellEditor);
        ObjectValueRender kdtEntry_costObject_OVR = new ObjectValueRender();
        kdtEntry_costObject_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("costObject").setRenderer(kdtEntry_costObject_OVR);
        KDTextField kdtEntry_costObjectName_TextField = new KDTextField();
        kdtEntry_costObjectName_TextField.setName("kdtEntry_costObjectName_TextField");
        kdtEntry_costObjectName_TextField.setMaxLength(255);
        KDTDefaultCellEditor kdtEntry_costObjectName_CellEditor = new KDTDefaultCellEditor(kdtEntry_costObjectName_TextField);
        this.kdtEntry.getColumn("costObjectName").setEditor(kdtEntry_costObjectName_CellEditor);
        final KDBizPromptBox kdtEntry_unit_PromptBox = new KDBizPromptBox();
        kdtEntry_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntry_unit_PromptBox.setVisible(true);
        kdtEntry_unit_PromptBox.setEditable(true);
        kdtEntry_unit_PromptBox.setDisplayFormat("$number$");
        kdtEntry_unit_PromptBox.setEditFormat("$number$");
        kdtEntry_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_unit_CellEditor = new KDTDefaultCellEditor(kdtEntry_unit_PromptBox);
        this.kdtEntry.getColumn("unit").setEditor(kdtEntry_unit_CellEditor);
        ObjectValueRender kdtEntry_unit_OVR = new ObjectValueRender();
        kdtEntry_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("unit").setRenderer(kdtEntry_unit_OVR);
        KDFormattedTextField kdtEntry_qty_TextField = new KDFormattedTextField();
        kdtEntry_qty_TextField.setName("kdtEntry_qty_TextField");
        kdtEntry_qty_TextField.setVisible(true);
        kdtEntry_qty_TextField.setEditable(true);
        kdtEntry_qty_TextField.setHorizontalAlignment(2);
        kdtEntry_qty_TextField.setDataType(1);
        kdtEntry_qty_TextField.setPrecision(16);
        KDTDefaultCellEditor kdtEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtEntry_qty_TextField);
        this.kdtEntry.getColumn("qty").setEditor(kdtEntry_qty_CellEditor);
        final KDBizPromptBox kdtEntry_baseUnit_PromptBox = new KDBizPromptBox();
        kdtEntry_baseUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntry_baseUnit_PromptBox.setVisible(true);
        kdtEntry_baseUnit_PromptBox.setEditable(true);
        kdtEntry_baseUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntry_baseUnit_PromptBox.setEditFormat("$number$");
        kdtEntry_baseUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_baseUnit_CellEditor = new KDTDefaultCellEditor(kdtEntry_baseUnit_PromptBox);
        this.kdtEntry.getColumn("baseUnit").setEditor(kdtEntry_baseUnit_CellEditor);
        ObjectValueRender kdtEntry_baseUnit_OVR = new ObjectValueRender();
        kdtEntry_baseUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("baseUnit").setRenderer(kdtEntry_baseUnit_OVR);
        KDFormattedTextField kdtEntry_baseQty_TextField = new KDFormattedTextField();
        kdtEntry_baseQty_TextField.setName("kdtEntry_baseQty_TextField");
        kdtEntry_baseQty_TextField.setVisible(true);
        kdtEntry_baseQty_TextField.setEditable(true);
        kdtEntry_baseQty_TextField.setHorizontalAlignment(2);
        kdtEntry_baseQty_TextField.setDataType(1);
        kdtEntry_baseQty_TextField.setPrecision(16);
        KDTDefaultCellEditor kdtEntry_baseQty_CellEditor = new KDTDefaultCellEditor(kdtEntry_baseQty_TextField);
        this.kdtEntry.getColumn("baseQty").setEditor(kdtEntry_baseQty_CellEditor);
        final KDBizPromptBox kdtEntry_assistantUnit_PromptBox = new KDBizPromptBox();
        kdtEntry_assistantUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntry_assistantUnit_PromptBox.setVisible(true);
        kdtEntry_assistantUnit_PromptBox.setEditable(true);
        kdtEntry_assistantUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntry_assistantUnit_PromptBox.setEditFormat("$number$");
        kdtEntry_assistantUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_assistantUnit_CellEditor = new KDTDefaultCellEditor(kdtEntry_assistantUnit_PromptBox);
        this.kdtEntry.getColumn("assistantUnit").setEditor(kdtEntry_assistantUnit_CellEditor);
        ObjectValueRender kdtEntry_assistantUnit_OVR = new ObjectValueRender();
        kdtEntry_assistantUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("assistantUnit").setRenderer(kdtEntry_assistantUnit_OVR);
        KDFormattedTextField kdtEntry_assistantQty_TextField = new KDFormattedTextField();
        kdtEntry_assistantQty_TextField.setName("kdtEntry_assistantQty_TextField");
        kdtEntry_assistantQty_TextField.setVisible(true);
        kdtEntry_assistantQty_TextField.setEditable(true);
        kdtEntry_assistantQty_TextField.setHorizontalAlignment(2);
        kdtEntry_assistantQty_TextField.setDataType(1);
        kdtEntry_assistantQty_TextField.setPrecision(16);
        KDTDefaultCellEditor kdtEntry_assistantQty_CellEditor = new KDTDefaultCellEditor(kdtEntry_assistantQty_TextField);
        this.kdtEntry.getColumn("assistantQty").setEditor(kdtEntry_assistantQty_CellEditor);
        final KDBizPromptBox kdtEntry_warehouse_PromptBox = new KDBizPromptBox();
        kdtEntry_warehouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEntry_warehouse_PromptBox.setVisible(true);
        kdtEntry_warehouse_PromptBox.setEditable(true);
        kdtEntry_warehouse_PromptBox.setDisplayFormat("$number$");
        kdtEntry_warehouse_PromptBox.setEditFormat("$number$");
        kdtEntry_warehouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_warehouse_CellEditor = new KDTDefaultCellEditor(kdtEntry_warehouse_PromptBox);
        this.kdtEntry.getColumn("warehouse").setEditor(kdtEntry_warehouse_CellEditor);
        ObjectValueRender kdtEntry_warehouse_OVR = new ObjectValueRender();
        kdtEntry_warehouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("warehouse").setRenderer(kdtEntry_warehouse_OVR);
        final KDBizPromptBox kdtEntry_stocker_PromptBox = new KDBizPromptBox();
        kdtEntry_stocker_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtEntry_stocker_PromptBox.setVisible(true);
        kdtEntry_stocker_PromptBox.setEditable(true);
        kdtEntry_stocker_PromptBox.setDisplayFormat("$number$");
        kdtEntry_stocker_PromptBox.setEditFormat("$number$");
        kdtEntry_stocker_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_stocker_CellEditor = new KDTDefaultCellEditor(kdtEntry_stocker_PromptBox);
        this.kdtEntry.getColumn("stocker").setEditor(kdtEntry_stocker_CellEditor);
        ObjectValueRender kdtEntry_stocker_OVR = new ObjectValueRender();
        kdtEntry_stocker_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("stocker").setRenderer(kdtEntry_stocker_OVR);
        final KDBizPromptBox kdtEntry_location_PromptBox = new KDBizPromptBox();
        kdtEntry_location_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7LocationQuery");
        kdtEntry_location_PromptBox.setVisible(true);
        kdtEntry_location_PromptBox.setEditable(true);
        kdtEntry_location_PromptBox.setDisplayFormat("$number$");
        kdtEntry_location_PromptBox.setEditFormat("$number$");
        kdtEntry_location_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_location_CellEditor = new KDTDefaultCellEditor(kdtEntry_location_PromptBox);
        this.kdtEntry.getColumn("location").setEditor(kdtEntry_location_CellEditor);
        ObjectValueRender kdtEntry_location_OVR = new ObjectValueRender();
        kdtEntry_location_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("location").setRenderer(kdtEntry_location_OVR);
        KDFormattedTextField kdtEntry_unitStandardCost_TextField = new KDFormattedTextField();
        kdtEntry_unitStandardCost_TextField.setName("kdtEntry_unitStandardCost_TextField");
        kdtEntry_unitStandardCost_TextField.setVisible(true);
        kdtEntry_unitStandardCost_TextField.setEditable(true);
        kdtEntry_unitStandardCost_TextField.setHorizontalAlignment(2);
        kdtEntry_unitStandardCost_TextField.setDataType(1);
        kdtEntry_unitStandardCost_TextField.setPrecision(16);
        KDTDefaultCellEditor kdtEntry_unitStandardCost_CellEditor = new KDTDefaultCellEditor(kdtEntry_unitStandardCost_TextField);
        this.kdtEntry.getColumn("unitStandardCost").setEditor(kdtEntry_unitStandardCost_CellEditor);
        KDFormattedTextField kdtEntry_standardCost_TextField = new KDFormattedTextField();
        kdtEntry_standardCost_TextField.setName("kdtEntry_standardCost_TextField");
        kdtEntry_standardCost_TextField.setVisible(true);
        kdtEntry_standardCost_TextField.setEditable(true);
        kdtEntry_standardCost_TextField.setHorizontalAlignment(2);
        kdtEntry_standardCost_TextField.setDataType(1);
        	kdtEntry_standardCost_TextField.setMinimumValue(new java.math.BigDecimal("-9.999999999999E8"));
        	kdtEntry_standardCost_TextField.setMaximumValue(new java.math.BigDecimal("9.999999999999E8"));
        kdtEntry_standardCost_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntry_standardCost_CellEditor = new KDTDefaultCellEditor(kdtEntry_standardCost_TextField);
        this.kdtEntry.getColumn("standardCost").setEditor(kdtEntry_standardCost_CellEditor);
        KDFormattedTextField kdtEntry_unitFactCost_TextField = new KDFormattedTextField();
        kdtEntry_unitFactCost_TextField.setName("kdtEntry_unitFactCost_TextField");
        kdtEntry_unitFactCost_TextField.setVisible(true);
        kdtEntry_unitFactCost_TextField.setEditable(true);
        kdtEntry_unitFactCost_TextField.setHorizontalAlignment(2);
        kdtEntry_unitFactCost_TextField.setDataType(1);
        kdtEntry_unitFactCost_TextField.setPrecision(16);
        KDTDefaultCellEditor kdtEntry_unitFactCost_CellEditor = new KDTDefaultCellEditor(kdtEntry_unitFactCost_TextField);
        this.kdtEntry.getColumn("unitFactCost").setEditor(kdtEntry_unitFactCost_CellEditor);
        KDFormattedTextField kdtEntry_factCost_TextField = new KDFormattedTextField();
        kdtEntry_factCost_TextField.setName("kdtEntry_factCost_TextField");
        kdtEntry_factCost_TextField.setVisible(true);
        kdtEntry_factCost_TextField.setEditable(true);
        kdtEntry_factCost_TextField.setHorizontalAlignment(2);
        kdtEntry_factCost_TextField.setDataType(1);
        	kdtEntry_factCost_TextField.setMinimumValue(new java.math.BigDecimal("-9.999999999999E8"));
        	kdtEntry_factCost_TextField.setMaximumValue(new java.math.BigDecimal("9.999999999999E8"));
        kdtEntry_factCost_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntry_factCost_CellEditor = new KDTDefaultCellEditor(kdtEntry_factCost_TextField);
        this.kdtEntry.getColumn("factCost").setEditor(kdtEntry_factCost_CellEditor);
        KDFormattedTextField kdtEntry_countervailQty_TextField = new KDFormattedTextField();
        kdtEntry_countervailQty_TextField.setName("kdtEntry_countervailQty_TextField");
        kdtEntry_countervailQty_TextField.setVisible(true);
        kdtEntry_countervailQty_TextField.setEditable(true);
        kdtEntry_countervailQty_TextField.setHorizontalAlignment(2);
        kdtEntry_countervailQty_TextField.setDataType(1);
        kdtEntry_countervailQty_TextField.setPrecision(16);
        KDTDefaultCellEditor kdtEntry_countervailQty_CellEditor = new KDTDefaultCellEditor(kdtEntry_countervailQty_TextField);
        this.kdtEntry.getColumn("countervailQty").setEditor(kdtEntry_countervailQty_CellEditor);
        KDTextField kdtEntry_manufactureBillNumber_TextField = new KDTextField();
        kdtEntry_manufactureBillNumber_TextField.setName("kdtEntry_manufactureBillNumber_TextField");
        kdtEntry_manufactureBillNumber_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_manufactureBillNumber_CellEditor = new KDTDefaultCellEditor(kdtEntry_manufactureBillNumber_TextField);
        this.kdtEntry.getColumn("manufactureBillNumber").setEditor(kdtEntry_manufactureBillNumber_CellEditor);
        KDFormattedTextField kdtEntry_manuBillEntrySeq_TextField = new KDFormattedTextField();
        kdtEntry_manuBillEntrySeq_TextField.setName("kdtEntry_manuBillEntrySeq_TextField");
        kdtEntry_manuBillEntrySeq_TextField.setVisible(true);
        kdtEntry_manuBillEntrySeq_TextField.setEditable(true);
        kdtEntry_manuBillEntrySeq_TextField.setHorizontalAlignment(2);
        kdtEntry_manuBillEntrySeq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_manuBillEntrySeq_CellEditor = new KDTDefaultCellEditor(kdtEntry_manuBillEntrySeq_TextField);
        this.kdtEntry.getColumn("manuBillEntrySeq").setEditor(kdtEntry_manuBillEntrySeq_CellEditor);
        KDTextField kdtEntry_saleOrderNum_TextField = new KDTextField();
        kdtEntry_saleOrderNum_TextField.setName("kdtEntry_saleOrderNum_TextField");
        kdtEntry_saleOrderNum_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_saleOrderNum_CellEditor = new KDTDefaultCellEditor(kdtEntry_saleOrderNum_TextField);
        this.kdtEntry.getColumn("saleOrderNum").setEditor(kdtEntry_saleOrderNum_CellEditor);
        KDFormattedTextField kdtEntry_saleOrderEntrySeq_TextField = new KDFormattedTextField();
        kdtEntry_saleOrderEntrySeq_TextField.setName("kdtEntry_saleOrderEntrySeq_TextField");
        kdtEntry_saleOrderEntrySeq_TextField.setVisible(true);
        kdtEntry_saleOrderEntrySeq_TextField.setEditable(true);
        kdtEntry_saleOrderEntrySeq_TextField.setHorizontalAlignment(2);
        kdtEntry_saleOrderEntrySeq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_saleOrderEntrySeq_CellEditor = new KDTDefaultCellEditor(kdtEntry_saleOrderEntrySeq_TextField);
        this.kdtEntry.getColumn("saleOrderEntrySeq").setEditor(kdtEntry_saleOrderEntrySeq_CellEditor);
        final KDBizPromptBox kdtEntry_projectNumCol_PromptBox = new KDBizPromptBox();
        kdtEntry_projectNumCol_PromptBox.setQueryInfo("com.kingdee.eas.mm.project.app.F7ProjectQuery");
        kdtEntry_projectNumCol_PromptBox.setVisible(true);
        kdtEntry_projectNumCol_PromptBox.setEditable(true);
        kdtEntry_projectNumCol_PromptBox.setDisplayFormat("$number$");
        kdtEntry_projectNumCol_PromptBox.setEditFormat("$number$");
        kdtEntry_projectNumCol_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_projectNumCol_CellEditor = new KDTDefaultCellEditor(kdtEntry_projectNumCol_PromptBox);
        this.kdtEntry.getColumn("projectNumCol").setEditor(kdtEntry_projectNumCol_CellEditor);
        ObjectValueRender kdtEntry_projectNumCol_OVR = new ObjectValueRender();
        kdtEntry_projectNumCol_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("projectNumCol").setRenderer(kdtEntry_projectNumCol_OVR);
        final KDBizPromptBox kdtEntry_trackNumCol_PromptBox = new KDBizPromptBox();
        kdtEntry_trackNumCol_PromptBox.setQueryInfo("com.kingdee.eas.mm.basedata.app.TrackNumberQuery");
        kdtEntry_trackNumCol_PromptBox.setVisible(true);
        kdtEntry_trackNumCol_PromptBox.setEditable(true);
        kdtEntry_trackNumCol_PromptBox.setDisplayFormat("$number$");
        kdtEntry_trackNumCol_PromptBox.setEditFormat("$number$");
        kdtEntry_trackNumCol_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_trackNumCol_CellEditor = new KDTDefaultCellEditor(kdtEntry_trackNumCol_PromptBox);
        this.kdtEntry.getColumn("trackNumCol").setEditor(kdtEntry_trackNumCol_CellEditor);
        ObjectValueRender kdtEntry_trackNumCol_OVR = new ObjectValueRender();
        kdtEntry_trackNumCol_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("trackNumCol").setRenderer(kdtEntry_trackNumCol_OVR);
        KDFormattedTextField kdtEntry_receiveQty_TextField = new KDFormattedTextField();
        kdtEntry_receiveQty_TextField.setName("kdtEntry_receiveQty_TextField");
        kdtEntry_receiveQty_TextField.setVisible(true);
        kdtEntry_receiveQty_TextField.setEditable(true);
        kdtEntry_receiveQty_TextField.setHorizontalAlignment(2);
        kdtEntry_receiveQty_TextField.setDataType(1);
        	kdtEntry_receiveQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E20"));
        	kdtEntry_receiveQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E20"));
        kdtEntry_receiveQty_TextField.setPrecision(8);
        KDTDefaultCellEditor kdtEntry_receiveQty_CellEditor = new KDTDefaultCellEditor(kdtEntry_receiveQty_TextField);
        this.kdtEntry.getColumn("receiveQty").setEditor(kdtEntry_receiveQty_CellEditor);
        KDTextField kdtEntry_remark_TextField = new KDTextField();
        kdtEntry_remark_TextField.setName("kdtEntry_remark_TextField");
        kdtEntry_remark_TextField.setMaxLength(255);
        KDTDefaultCellEditor kdtEntry_remark_CellEditor = new KDTDefaultCellEditor(kdtEntry_remark_TextField);
        this.kdtEntry.getColumn("remark").setEditor(kdtEntry_remark_CellEditor);
        // cboxIsInitBill		
        this.cboxIsInitBill.setText(resHelper.getString("cboxIsInitBill.text"));		
        this.cboxIsInitBill.setVisible(false);		
        this.cboxIsInitBill.setEnabled(true);		
        this.cboxIsInitBill.setHorizontalAlignment(2);
        // bizInventory		
        this.bizInventory.setVisible(false);
        // conCostCenter		
        this.conCostCenter.setBoundLabelText(resHelper.getString("conCostCenter.boundLabelText"));		
        this.conCostCenter.setBoundLabelLength(100);		
        this.conCostCenter.setBoundLabelUnderline(true);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);		
        this.contDescription.setBoundLabelAlignment(7);		
        this.contDescription.setVisible(true);
        // contBackFlush		
        this.contBackFlush.setBoundLabelText(resHelper.getString("contBackFlush.boundLabelText"));		
        this.contBackFlush.setBoundLabelLength(100);		
        this.contBackFlush.setBoundLabelUnderline(true);		
        this.contBackFlush.setBoundLabelAlignment(7);		
        this.contBackFlush.setVisible(true);		
        this.contBackFlush.setForeground(new java.awt.Color(0,0,0));		
        this.contBackFlush.setEnabled(false);
        // labBizType		
        this.labBizType.setBoundLabelText(resHelper.getString("labBizType.boundLabelText"));		
        this.labBizType.setBoundLabelLength(100);		
        this.labBizType.setBoundLabelUnderline(true);
        // prmtCreator		
        this.prmtCreator.setDisplayFormat("$name$");		
        this.prmtCreator.setEditFormat("$number$");		
        this.prmtCreator.setCommitFormat("$number$");		
        this.prmtCreator.setQueryInfo("com.kingdee.eas.base.permission.app.UserSimpleQuery");		
        this.prmtCreator.setEnabled(false);		
        this.prmtCreator.setVisible(true);		
        this.prmtCreator.setRequired(false);
        // pkCreatDate		
        this.pkCreatDate.setEnabled(false);		
        this.pkCreatDate.setVisible(true);		
        this.pkCreatDate.setRequired(false);
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setDisplayFormat("$name$");		
        this.prmtLastUpdateUser.setEditFormat("$number$");		
        this.prmtLastUpdateUser.setCommitFormat("$number$");		
        this.prmtLastUpdateUser.setQueryInfo("com.kingdee.eas.base.permission.app.UserSimpleQuery");		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.prmtLastUpdateUser.setVisible(true);		
        this.prmtLastUpdateUser.setRequired(false);
        // pkModifyDate		
        this.pkModifyDate.setEnabled(false);		
        this.pkModifyDate.setVisible(true);		
        this.pkModifyDate.setRequired(false);
        // txtNumber		
        this.txtNumber.setRequired(true);		
        this.txtNumber.setVisible(true);		
        this.txtNumber.setEnabled(true);		
        this.txtNumber.setHorizontalAlignment(2);
        // pkBizDate		
        this.pkBizDate.setRequired(true);		
        this.pkBizDate.setVisible(true);		
        this.pkBizDate.setEnabled(true);
        // prmtAuditor		
        this.prmtAuditor.setDisplayFormat("$name$");		
        this.prmtAuditor.setEditFormat("$number$");		
        this.prmtAuditor.setCommitFormat("$number$");		
        this.prmtAuditor.setQueryInfo("com.kingdee.eas.base.permission.app.UserSimpleQuery");		
        this.prmtAuditor.setEnabled(false);		
        this.prmtAuditor.setVisible(true);		
        this.prmtAuditor.setRequired(false);
        // pkAuditDate		
        this.pkAuditDate.setEnabled(false);		
        this.pkAuditDate.setVisible(true);		
        this.pkAuditDate.setRequired(false);
        // comboBaseStatus		
        this.comboBaseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.comboBaseStatus.setEnabled(false);		
        this.comboBaseStatus.setVisible(true);		
        this.comboBaseStatus.setForeground(new java.awt.Color(0,0,0));		
        this.comboBaseStatus.setRequired(false);
        // prmtTransactionType		
        this.prmtTransactionType.setQueryInfo("com.kingdee.eas.basedata.scm.common.app.F7TransactionTypeInvQuery");		
        this.prmtTransactionType.setDisplayFormat("$name$");		
        this.prmtTransactionType.setEditFormat("$number$");		
        this.prmtTransactionType.setCommitFormat("$number$");		
        this.prmtTransactionType.setRequired(true);		
        this.prmtTransactionType.setLabelVisible(true);		
        this.prmtTransactionType.setEditable(true);		
        this.prmtTransactionType.setVisible(true);		
        this.prmtTransactionType.setEnabled(true);
        // prmtStorageOrgUnit		
        this.prmtStorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageOrgUnitQuery");		
        this.prmtStorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtStorageOrgUnit.setEditFormat("$number$");		
        this.prmtStorageOrgUnit.setCommitFormat("$number$");		
        this.prmtStorageOrgUnit.setRequired(true);		
        this.prmtStorageOrgUnit.setLabelVisible(true);		
        this.prmtStorageOrgUnit.setEditable(true);		
        this.prmtStorageOrgUnit.setVisible(true);		
        this.prmtStorageOrgUnit.setEnabled(true);
        // prmtDepartment		
        this.prmtDepartment.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminOrgUnitQuery");		
        this.prmtDepartment.setDisplayFormat("$name$");		
        this.prmtDepartment.setEditFormat("$number$");		
        this.prmtDepartment.setCommitFormat("$number$");		
        this.prmtDepartment.setLabelVisible(true);		
        this.prmtDepartment.setEditable(true);		
        this.prmtDepartment.setVisible(true);		
        this.prmtDepartment.setEnabled(true);		
        this.prmtDepartment.setRequired(false);
        // prmtSourceBillType		
        this.prmtSourceBillType.setQueryInfo("com.kingdee.eas.basedata.scm.common.app.F7BillTypeQuery");		
        this.prmtSourceBillType.setDisplayFormat("$name$");		
        this.prmtSourceBillType.setEditFormat("$number$");		
        this.prmtSourceBillType.setCommitFormat("$number$");		
        this.prmtSourceBillType.setEnabled(false);		
        this.prmtSourceBillType.setEditable(true);		
        this.prmtSourceBillType.setVisible(true);		
        this.prmtSourceBillType.setRequired(false);		
        this.prmtSourceBillType.setLabelVisible(true);
        // txtTotalAmount		
        this.txtTotalAmount.setEnabled(false);		
        this.txtTotalAmount.setDataType(1);		
        this.txtTotalAmount.setVisible(true);		
        this.txtTotalAmount.setHorizontalAlignment(2);		
        this.txtTotalAmount.setRequired(false);
        this.txtTotalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txtTotalAmount_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // txtAddStandardCost		
        this.txtAddStandardCost.setEnabled(false);		
        this.txtAddStandardCost.setDataType(1);		
        this.txtAddStandardCost.setVisible(true);		
        this.txtAddStandardCost.setHorizontalAlignment(2);		
        this.txtAddStandardCost.setRequired(false);
        // txtAddFactCost		
        this.txtAddFactCost.setEnabled(false);		
        this.txtAddFactCost.setDataType(1);		
        this.txtAddFactCost.setVisible(true);		
        this.txtAddFactCost.setHorizontalAlignment(2);		
        this.txtAddFactCost.setRequired(false);
        // prtmtCostCenter		
        this.prtmtCostCenter.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prtmtCostCenter.setLabelVisible(true);		
        this.prtmtCostCenter.setDisplayFormat("$number$");		
        this.prtmtCostCenter.setEditFormat("$number$");		
        this.prtmtCostCenter.setCommitFormat("$number$");
        // txtDescription		
        this.txtDescription.setVisible(true);		
        this.txtDescription.setEnabled(true);		
        this.txtDescription.setHorizontalAlignment(2);
        // comboxBackFlush		
        this.comboxBackFlush.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.im.inv.BackFlushSucceedEnum").toArray());		
        this.comboxBackFlush.setEnabled(false);
        // bizPrmtBizType		
        this.bizPrmtBizType.setDisplayFormat("$name$");		
        this.bizPrmtBizType.setEditFormat("$number$");		
        this.bizPrmtBizType.setLabelVisible(true);		
        this.bizPrmtBizType.setQueryInfo("com.kingdee.eas.basedata.scm.common.app.BizTypeQuery");		
        this.bizPrmtBizType.setRequired(true);		
        this.bizPrmtBizType.setCommitFormat("$number$");
        // btnOffSet
        this.btnOffSet.setAction((IItemAction)ActionProxyFactory.getProxy(actionOffSet, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnOffSet.setText(resHelper.getString("btnOffSet.text"));		
        this.btnOffSet.setToolTipText(resHelper.getString("btnOffSet.toolTipText"));
        // btnBackFlush
        this.btnBackFlush.setAction((IItemAction)ActionProxyFactory.getProxy(actionBackFlush, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnBackFlush.setText(resHelper.getString("btnBackFlush.text"));
        // btnUnBackFlush
        this.btnUnBackFlush.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnBackFlush, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnBackFlush.setText(resHelper.getString("btnUnBackFlush.text"));
        // btnInteractionBackFlush
        this.btnInteractionBackFlush.setAction((IItemAction)ActionProxyFactory.getProxy(actionInteractionBackFlush, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnInteractionBackFlush.setText(resHelper.getString("btnInteractionBackFlush.text"));
        // btnQuickAddLine
        this.btnQuickAddLine.setAction((IItemAction)ActionProxyFactory.getProxy(actionQuickAddLine, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnQuickAddLine.setText(resHelper.getString("btnQuickAddLine.text"));		
        this.btnQuickAddLine.setToolTipText(resHelper.getString("btnQuickAddLine.toolTipText"));
        // menuItemOffset
        this.menuItemOffset.setAction((IItemAction)ActionProxyFactory.getProxy(actionOffSet, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemOffset.setText(resHelper.getString("menuItemOffset.text"));		
        this.menuItemOffset.setMnemonic(87);
        // menuItemBackFlush
        this.menuItemBackFlush.setAction((IItemAction)ActionProxyFactory.getProxy(actionBackFlush, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemBackFlush.setText(resHelper.getString("menuItemBackFlush.text"));		
        this.menuItemBackFlush.setMnemonic(66);
        // menuItemUnBackFlush
        this.menuItemUnBackFlush.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnBackFlush, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemUnBackFlush.setText(resHelper.getString("menuItemUnBackFlush.text"));		
        this.menuItemUnBackFlush.setMnemonic(82);
        // menuItemQuickAddLine
        this.menuItemQuickAddLine.setAction((IItemAction)ActionProxyFactory.getProxy(actionQuickAddLine, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemQuickAddLine.setText(resHelper.getString("menuItemQuickAddLine.text"));		
        this.menuItemQuickAddLine.setToolTipText(resHelper.getString("menuItemQuickAddLine.toolTipText"));		
        this.menuItemQuickAddLine.setMnemonic(66);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,prmtTransactionType,pkBizDate,prmtAuditor,comboBaseStatus,prmtStorageOrgUnit,prmtDepartment,prmtSourceBillType,kdtEntry,cboxIsInitBill,bizInventory}));
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
        kDSeparator5.setBounds(new Rectangle(0, 568, 1013, 10));
        this.add(kDSeparator5, new KDLayout.Constraints(0, 568, 1013, 10, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contCreator.setBounds(new Rectangle(702, 578, 300, 19));
        this.add(contCreator, new KDLayout.Constraints(702, 578, 300, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kdCreatDate.setBounds(new Rectangle(702, 600, 300, 19));
        this.add(kdCreatDate, new KDLayout.Constraints(702, 600, 300, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(356, 578, 300, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(356, 578, 300, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdModifyDate.setBounds(new Rectangle(356, 600, 300, 19));
        this.add(kdModifyDate, new KDLayout.Constraints(356, 600, 300, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(10, 10, 300, 19));
        this.add(contNumber, new KDLayout.Constraints(10, 10, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(702, 10, 300, 19));
        this.add(contBizDate, new KDLayout.Constraints(702, 10, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(10, 578, 300, 19));
        this.add(contAuditor, new KDLayout.Constraints(10, 578, 300, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditTime.setBounds(new Rectangle(10, 600, 300, 19));
        this.add(contAuditTime, new KDLayout.Constraints(10, 600, 300, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBaseStatus.setBounds(new Rectangle(10, 54, 300, 19));
        this.add(contBaseStatus, new KDLayout.Constraints(10, 54, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contTransactionType.setBounds(new Rectangle(356, 32, 300, 19));
        this.add(contTransactionType, new KDLayout.Constraints(356, 32, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contStorageOrgUnit.setBounds(new Rectangle(356, 54, 300, 19));
        this.add(contStorageOrgUnit, new KDLayout.Constraints(356, 54, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDepartment.setBounds(new Rectangle(702, 32, 300, 19));
        this.add(contDepartment, new KDLayout.Constraints(702, 32, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contSourceBillType.setBounds(new Rectangle(10, 32, 300, 19));
        this.add(contSourceBillType, new KDLayout.Constraints(10, 32, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contTotalAmount.setBounds(new Rectangle(698, 541, 300, 19));
        this.add(contTotalAmount, new KDLayout.Constraints(698, 541, 300, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAddStandardCost.setBounds(new Rectangle(10, 538, 300, 19));
        this.add(contAddStandardCost, new KDLayout.Constraints(10, 538, 300, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAddFactCost.setBounds(new Rectangle(356, 538, 300, 19));
        this.add(contAddFactCost, new KDLayout.Constraints(356, 538, 300, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkIsOffset.setBounds(new Rectangle(702, 54, 131, 19));
        this.add(chkIsOffset, new KDLayout.Constraints(702, 54, 131, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtEntry.setBounds(new Rectangle(10, 103, 993, 465));
        this.add(kdtEntry, new KDLayout.Constraints(10, 103, 993, 465, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        cboxIsInitBill.setBounds(new Rectangle(806, 54, 101, 19));
        this.add(cboxIsInitBill, new KDLayout.Constraints(806, 54, 101, 19, 0));
        bizInventory.setBounds(new Rectangle(961, 54, 10, 19));
        this.add(bizInventory, new KDLayout.Constraints(961, 54, 10, 19, 0));
        conCostCenter.setBounds(new Rectangle(356, 78, 300, 19));
        this.add(conCostCenter, new KDLayout.Constraints(356, 78, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(9, 78, 300, 19));
        this.add(contDescription, new KDLayout.Constraints(9, 78, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBackFlush.setBounds(new Rectangle(702, 78, 300, 19));
        this.add(contBackFlush, new KDLayout.Constraints(702, 78, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        labBizType.setBounds(new Rectangle(356, 10, 300, 19));
        this.add(labBizType, new KDLayout.Constraints(356, 10, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //kdCreatDate
        kdCreatDate.setBoundEditor(pkCreatDate);
        //contLastUpdateUser
        contLastUpdateUser.setBoundEditor(prmtLastUpdateUser);
        //kdModifyDate
        kdModifyDate.setBoundEditor(pkModifyDate);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contAuditTime
        contAuditTime.setBoundEditor(pkAuditDate);
        //contBaseStatus
        contBaseStatus.setBoundEditor(comboBaseStatus);
        //contTransactionType
        contTransactionType.setBoundEditor(prmtTransactionType);
        //contStorageOrgUnit
        contStorageOrgUnit.setBoundEditor(prmtStorageOrgUnit);
        //contDepartment
        contDepartment.setBoundEditor(prmtDepartment);
        //contSourceBillType
        contSourceBillType.setBoundEditor(prmtSourceBillType);
        //contTotalAmount
        contTotalAmount.setBoundEditor(txtTotalAmount);
        //contAddStandardCost
        contAddStandardCost.setBoundEditor(txtAddStandardCost);
        //contAddFactCost
        contAddFactCost.setBoundEditor(txtAddFactCost);
        //conCostCenter
        conCostCenter.setBoundEditor(prtmtCostCenter);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contBackFlush
        contBackFlush.setBoundEditor(comboxBackFlush);
        //labBizType
        labBizType.setBoundEditor(bizPrmtBizType);

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
        this.menuBar.add(menuTable);
        this.menuBar.add(menuTool);
        this.menuBar.add(menuWorkflow);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(separator11);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(menuItemSubmit);
        menuFile.add(menuItemCloudShare);
        menuFile.add(menuSubmitOption);
        menuFile.add(menuItemPageSetup);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(separator9);
        menuFile.add(MenuItemAttachment);
        menuFile.add(separator10);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator3);
        menuFile.add(menuItemExitCurrent);
        menuFile.add(separatorFile1);
        menuFile.add(kDSeparator1);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemSendMail);
        menuFile.add(rMenuItemSubmit);
        menuFile.add(rMenuItemSubmitAndAddNew);
        menuFile.add(rMenuItemSubmitAndPrint);
        //menuSubmitOption
        menuSubmitOption.add(chkMenuItemSubmitAndAddNew);
        menuSubmitOption.add(chkMenuItemSubmitAndPrint);
        //menuEdit
        menuEdit.add(menuItemCopy);
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(separator1);
        menuEdit.add(menuItemReset);
        menuEdit.add(menuItemCreateFrom);
        menuEdit.add(menuItemCopyFrom);
        menuEdit.add(menuItemOffset);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(separatorEdit1);
        menuEdit.add(menuItemEnterToNextRow);
        menuEdit.add(menuItemInvBillOptin);
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
        menuView.add(kDSeparator4);
        menuView.add(kDSeparator7);
        menuView.add(separator2);
        menuView.add(menuItemLocate);
        menuView.add(menuItemQueryGeneralInventory);
        menuView.add(menuItemQueryByMaterial);
        menuView.add(menuItemDecompose);
        menuView.add(menuItemMaterialView);
        menuView.add(menuItemCustomerView);
        menuView.add(menuItemSupplierView);
        menuView.add(menuItemSerialNumber);
        menuView.add(menuItemInventorySum);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemBackFlush);
        menuBiz.add(menuItemUnBackFlush);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(kDSeparator6);
        menuBiz.add(menuBillReservation);
        menuBiz.add(menuItemCancel);
        menuBiz.add(menuObject2BillReservation);
        menuBiz.add(menuItemDelVoucher);
        menuBiz.add(menuItemBillReservation);
        menuBiz.add(menuBizProcess);
        menuBiz.add(menuItemBillReservationQuery);
        menuBiz.add(menuItemBill2BillReservation);
        menuBiz.add(menuItemObject2BillReservation);
        //menuTable1
        menuTable1.add(menuItemAddLine);
        menuTable1.add(menuItemCopyLine);
        menuTable1.add(menuItemInsertLine);
        menuTable1.add(menuItemRemoveLine);
        menuTable1.add(menuItemSplitLine);
        menuTable1.add(menuItemSplitOption);
        menuTable1.add(separator13);
        menuTable1.add(menuItemSNsplit);
        menuTable1.add(menuItemQuickAddLine);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuWorkflow
        menuWorkflow.add(menuItemStartWorkFlow);
        menuWorkflow.add(menuItemViewDoProccess);
        menuWorkflow.add(MenuItemWFG);
        menuWorkflow.add(separatorWF1);
        menuWorkflow.add(menuItemAudit);
        menuWorkflow.add(menuItemWorkFlowList);
        menuWorkflow.add(menuItemMultiapprove);
        menuWorkflow.add(menuItemNextPerson);
        menuWorkflow.add(menuItemAuditResult);
        menuWorkflow.add(menuItemViewSubmitProccess);
        menuWorkflow.add(separatorWF2);
        menuWorkflow.add(menuItemUnAudit);
        menuWorkflow.add(kDMenuItemSendMessage);
        //menuHelp
        menuHelp.add(menuItemHelp);
        menuHelp.add(kDSeparator12);
        menuHelp.add(menuItemRegPro);
        menuHelp.add(separator12);
        menuHelp.add(menuItemPersonalSite);
        menuHelp.add(menuItemAbout);
        menuHelp.add(helpseparatorDiv);
        menuHelp.add(menuitemProductval);
        menuHelp.add(kDSeparatorProduct);

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
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separator8);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(separator6);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnFirst);
        this.toolBar.add(btnPre);
        this.toolBar.add(btnNext);
        this.toolBar.add(btnLast);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnMaterialView);
        this.toolBar.add(separator7);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(btnOffSet);
        this.toolBar.add(btnCopyLine);
        this.toolBar.add(separator4);
        this.toolBar.add(btnBackFlush);
        this.toolBar.add(btnUnBackFlush);
        this.toolBar.add(btnInteractionBackFlush);
        this.toolBar.add(workbtnBizProcess);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(sp_bizProcess);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
        this.toolBar.add(btnQueryByMaterial);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnQueryGeneralInventory);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(separator5);
        this.toolBar.add(btnDecompose);
        this.toolBar.add(btnAddLine);
        this.toolBar.add(btnInsertLine);
        this.toolBar.add(btnRemoveLine);
        this.toolBar.add(btnSplitLine);
        this.toolBar.add(separatorFW5);
        this.toolBar.add(separatorFW8);
        this.toolBar.add(btnSplitOption);
        this.toolBar.add(btnQuickAddLine);
        this.toolBar.add(btnCopyFrom);
        this.toolBar.add(separatorFW6);
        this.toolBar.add(btnReservationQuery);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnBillReservation);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnObject2BillReservation);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnBill2BillReservation);
        this.toolBar.add(btnInventorySum);
        this.toolBar.add(btnSerialNumber);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnDiscard);
        this.toolBar.add(btnSNsplit);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isReversed", boolean.class, this.chkIsOffset, "selected");
		dataBinder.registerBinding("entry.material.name", String.class, this.kdtEntry, "material.name.text");
		dataBinder.registerBinding("entry", com.kingdee.eas.farm.food.CManufactureBillEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("entry.material.model", String.class, this.kdtEntry, "material.model.text");
		dataBinder.registerBinding("entry.unit", com.kingdee.eas.basedata.assistant.MeasureUnitInfo.class, this.kdtEntry, "unit.text");
		dataBinder.registerBinding("entry.qty", java.math.BigDecimal.class, this.kdtEntry, "qty.text");
		dataBinder.registerBinding("entry.warehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.kdtEntry, "warehouse.text");
		dataBinder.registerBinding("entry.location", com.kingdee.eas.basedata.scm.im.inv.LocationInfo.class, this.kdtEntry, "location.text");
		dataBinder.registerBinding("entry.stocker", com.kingdee.eas.basedata.person.PersonInfo.class, this.kdtEntry, "stocker.text");
		dataBinder.registerBinding("entry.unitStandardCost", java.math.BigDecimal.class, this.kdtEntry, "unitStandardCost.text");
		dataBinder.registerBinding("entry.standardCost", java.math.BigDecimal.class, this.kdtEntry, "standardCost.text");
		dataBinder.registerBinding("entry.material", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.kdtEntry, "material.number.text");
		dataBinder.registerBinding("entry.baseUnit", com.kingdee.eas.basedata.assistant.MeasureUnitInfo.class, this.kdtEntry, "baseUnit.text");
		dataBinder.registerBinding("entry.assistProperty", com.kingdee.eas.basedata.master.material.AsstAttrValueInfo.class, this.kdtEntry, "assistantAttr.text");
		dataBinder.registerBinding("entry.assistUnit", com.kingdee.eas.basedata.assistant.MeasureUnitInfo.class, this.kdtEntry, "assistantUnit.text");
		dataBinder.registerBinding("entry.assistQty", java.math.BigDecimal.class, this.kdtEntry, "assistantQty.text");
		dataBinder.registerBinding("entry.reverseQty", java.math.BigDecimal.class, this.kdtEntry, "countervailQty.text");
		dataBinder.registerBinding("entry.mfg", java.util.Date.class, this.kdtEntry, "mfg.text");
		dataBinder.registerBinding("entry.exp", java.util.Date.class, this.kdtEntry, "exp.text");
		dataBinder.registerBinding("entry.baseQty", java.math.BigDecimal.class, this.kdtEntry, "baseQty.text");
		dataBinder.registerBinding("entry.unitActualCost", java.math.BigDecimal.class, this.kdtEntry, "unitFactCost.text");
		dataBinder.registerBinding("entry.actualCost", java.math.BigDecimal.class, this.kdtEntry, "factCost.text");
		dataBinder.registerBinding("entry.remark", String.class, this.kdtEntry, "remark.text");
		dataBinder.registerBinding("entry.lot", String.class, this.kdtEntry, "lot.text");
		dataBinder.registerBinding("entry.costObject.name", String.class, this.kdtEntry, "costObjectName.text");
		dataBinder.registerBinding("entry.costObject", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.kdtEntry, "costObject.text");
		dataBinder.registerBinding("entry.manuBillNumber", String.class, this.kdtEntry, "manufactureBillNumber.text");
		dataBinder.registerBinding("entry.saleOrderNum", String.class, this.kdtEntry, "saleOrderNum.text");
		dataBinder.registerBinding("entry.receiveQty", java.math.BigDecimal.class, this.kdtEntry, "receiveQty.text");
		dataBinder.registerBinding("entry.manuBillEntrySeq", int.class, this.kdtEntry, "manuBillEntrySeq.text");
		dataBinder.registerBinding("entry.saleOrderEntrySeq", int.class, this.kdtEntry, "saleOrderEntrySeq.text");
		dataBinder.registerBinding("entry.trackNumber", com.kingdee.eas.mm.basedata.TrackNumberInfo.class, this.kdtEntry, "trackNumCol.text");
		dataBinder.registerBinding("entry.project", com.kingdee.eas.mm.project.ProjectInfo.class, this.kdtEntry, "projectNumCol.text");
		dataBinder.registerBinding("entry.adminOrgUnit", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.kdtEntry, "mainAdminOrgUnit.text");
		dataBinder.registerBinding("entry.costCenterOrgUnit", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.kdtEntry, "costCenterOrgUnit.text");
		dataBinder.registerBinding("entry.invUpdateType", com.kingdee.eas.basedata.scm.im.inv.InvUpdateTypeInfo.class, this.kdtEntry, "invUpdateType.text");
		dataBinder.registerBinding("entry.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntry, "id.text");
		dataBinder.registerBinding("isInitBill", boolean.class, this.cboxIsInitBill, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkCreatDate, "value");
		dataBinder.registerBinding("modifier", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("modificationTime", java.sql.Timestamp.class, this.pkModifyDate, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.sql.Timestamp.class, this.pkAuditDate, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.comboBaseStatus, "selectedItem");
		dataBinder.registerBinding("transactionType", com.kingdee.eas.basedata.scm.common.TransactionTypeInfo.class, this.prmtTransactionType, "data");
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtStorageOrgUnit, "data");
		dataBinder.registerBinding("adminOrgUnit", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtDepartment, "data");
		dataBinder.registerBinding("sourceBillType", com.kingdee.eas.basedata.scm.common.BillTypeInfo.class, this.prmtSourceBillType, "data");
		dataBinder.registerBinding("totalAmount", java.math.BigDecimal.class, this.txtTotalAmount, "value");
		dataBinder.registerBinding("totalStandardCost", java.math.BigDecimal.class, this.txtAddStandardCost, "value");
		dataBinder.registerBinding("totalActualCost", java.math.BigDecimal.class, this.txtAddFactCost, "value");
		dataBinder.registerBinding("costCenterOrgUnit", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prtmtCostCenter, "data");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("isBackFlushSucceed", com.kingdee.eas.scm.im.inv.BackFlushSucceedEnum.class, this.comboxBackFlush, "selectedItem");
		dataBinder.registerBinding("bizType", com.kingdee.eas.basedata.scm.common.BizTypeInfo.class, this.bizPrmtBizType, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.food.app.CManufactureBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.food.CManufactureBillInfo)ov;
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
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
		getValidateHelper().registerBindProperty("isReversed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.material.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.material.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.warehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.location", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.stocker", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.unitStandardCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.standardCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.baseUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.assistProperty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.assistUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.assistQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.reverseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.mfg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.exp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.baseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.unitActualCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.actualCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.lot", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.costObject.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.costObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.manuBillNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.saleOrderNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.receiveQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.manuBillEntrySeq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.saleOrderEntrySeq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.trackNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.project", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.adminOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.costCenterOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.invUpdateType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isInitBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("modifier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("modificationTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("transactionType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("adminOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sourceBillType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalStandardCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalActualCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costCenterOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isBackFlushSucceed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizType", ValidateHelper.ON_SAVE);    		
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
     * output txtTotalAmount_actionPerformed method
     */
    protected void txtTotalAmount_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
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
        sic.add(new SelectorItemInfo("isReversed"));
    	sic.add(new SelectorItemInfo("entry.material.name"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("entry.material.model"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.unit.id"));
			sic.add(new SelectorItemInfo("entry.unit.name"));
        	sic.add(new SelectorItemInfo("entry.unit.number"));
		}
    	sic.add(new SelectorItemInfo("entry.qty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.warehouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.warehouse.id"));
			sic.add(new SelectorItemInfo("entry.warehouse.name"));
        	sic.add(new SelectorItemInfo("entry.warehouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.location.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.location.id"));
			sic.add(new SelectorItemInfo("entry.location.name"));
        	sic.add(new SelectorItemInfo("entry.location.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.stocker.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.stocker.id"));
			sic.add(new SelectorItemInfo("entry.stocker.name"));
        	sic.add(new SelectorItemInfo("entry.stocker.number"));
		}
    	sic.add(new SelectorItemInfo("entry.unitStandardCost"));
    	sic.add(new SelectorItemInfo("entry.standardCost"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.material.id"));
        	sic.add(new SelectorItemInfo("entry.material.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.baseUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.baseUnit.id"));
			sic.add(new SelectorItemInfo("entry.baseUnit.name"));
        	sic.add(new SelectorItemInfo("entry.baseUnit.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.assistProperty.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.assistProperty.id"));
			sic.add(new SelectorItemInfo("entry.assistProperty.name"));
        	sic.add(new SelectorItemInfo("entry.assistProperty.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.assistUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.assistUnit.id"));
			sic.add(new SelectorItemInfo("entry.assistUnit.name"));
        	sic.add(new SelectorItemInfo("entry.assistUnit.number"));
		}
    	sic.add(new SelectorItemInfo("entry.assistQty"));
    	sic.add(new SelectorItemInfo("entry.reverseQty"));
    	sic.add(new SelectorItemInfo("entry.mfg"));
    	sic.add(new SelectorItemInfo("entry.exp"));
    	sic.add(new SelectorItemInfo("entry.baseQty"));
    	sic.add(new SelectorItemInfo("entry.unitActualCost"));
    	sic.add(new SelectorItemInfo("entry.actualCost"));
    	sic.add(new SelectorItemInfo("entry.remark"));
    	sic.add(new SelectorItemInfo("entry.lot"));
    	sic.add(new SelectorItemInfo("entry.costObject.name"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.costObject.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.costObject.id"));
        	sic.add(new SelectorItemInfo("entry.costObject.number"));
		}
    	sic.add(new SelectorItemInfo("entry.manuBillNumber"));
    	sic.add(new SelectorItemInfo("entry.saleOrderNum"));
    	sic.add(new SelectorItemInfo("entry.receiveQty"));
    	sic.add(new SelectorItemInfo("entry.manuBillEntrySeq"));
    	sic.add(new SelectorItemInfo("entry.saleOrderEntrySeq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.trackNumber.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.trackNumber.id"));
			sic.add(new SelectorItemInfo("entry.trackNumber.name"));
        	sic.add(new SelectorItemInfo("entry.trackNumber.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.project.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.project.id"));
			sic.add(new SelectorItemInfo("entry.project.name"));
        	sic.add(new SelectorItemInfo("entry.project.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.adminOrgUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.adminOrgUnit.id"));
			sic.add(new SelectorItemInfo("entry.adminOrgUnit.name"));
        	sic.add(new SelectorItemInfo("entry.adminOrgUnit.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.costCenterOrgUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.costCenterOrgUnit.id"));
			sic.add(new SelectorItemInfo("entry.costCenterOrgUnit.name"));
        	sic.add(new SelectorItemInfo("entry.costCenterOrgUnit.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.invUpdateType.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.invUpdateType.id"));
			sic.add(new SelectorItemInfo("entry.invUpdateType.name"));
        	sic.add(new SelectorItemInfo("entry.invUpdateType.number"));
		}
    	sic.add(new SelectorItemInfo("entry.id"));
        sic.add(new SelectorItemInfo("isInitBill"));
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
			sic.add(new SelectorItemInfo("modifier.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("modifier.id"));
        	sic.add(new SelectorItemInfo("modifier.number"));
        	sic.add(new SelectorItemInfo("modifier.name"));
		}
        sic.add(new SelectorItemInfo("modificationTime"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
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
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("transactionType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("transactionType.id"));
        	sic.add(new SelectorItemInfo("transactionType.number"));
        	sic.add(new SelectorItemInfo("transactionType.name"));
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
			sic.add(new SelectorItemInfo("adminOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("adminOrgUnit.id"));
        	sic.add(new SelectorItemInfo("adminOrgUnit.number"));
        	sic.add(new SelectorItemInfo("adminOrgUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("sourceBillType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("sourceBillType.id"));
        	sic.add(new SelectorItemInfo("sourceBillType.number"));
        	sic.add(new SelectorItemInfo("sourceBillType.name"));
		}
        sic.add(new SelectorItemInfo("totalAmount"));
        sic.add(new SelectorItemInfo("totalStandardCost"));
        sic.add(new SelectorItemInfo("totalActualCost"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("costCenterOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costCenterOrgUnit.id"));
        	sic.add(new SelectorItemInfo("costCenterOrgUnit.number"));
        	sic.add(new SelectorItemInfo("costCenterOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("isBackFlushSucceed"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("bizType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("bizType.id"));
        	sic.add(new SelectorItemInfo("bizType.number"));
        	sic.add(new SelectorItemInfo("bizType.name"));
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
     * output actionAddNew_actionPerformed method
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }
    	

    /**
     * output actionEdit_actionPerformed method
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionEdit_actionPerformed(e);
    }
    	

    /**
     * output actionMultiapprove_actionPerformed method
     */
    public void actionMultiapprove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMultiapprove_actionPerformed(e);
    }
    	

    /**
     * output actionNextPerson_actionPerformed method
     */
    public void actionNextPerson_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNextPerson_actionPerformed(e);
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAudit_actionPerformed(e);
    }
    	

    /**
     * output actionOffSet_actionPerformed method
     */
    public void actionOffSet_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionQuickAddLine_actionPerformed method
     */
    public void actionQuickAddLine_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionBackFlush_actionPerformed method
     */
    public void actionBackFlush_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionUnBackFlush_actionPerformed method
     */
    public void actionUnBackFlush_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionInteractionBackFlush_actionPerformed method
     */
    public void actionInteractionBackFlush_actionPerformed(ActionEvent e) throws Exception
    {
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
	public RequestContext prepareActionAddNew(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionAddNew(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAddNew() {
    	return false;
    }
	public RequestContext prepareActionEdit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionEdit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionEdit() {
    	return false;
    }
	public RequestContext prepareActionMultiapprove(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionMultiapprove(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionMultiapprove() {
    	return false;
    }
	public RequestContext prepareActionNextPerson(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionNextPerson(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionNextPerson() {
    	return false;
    }
	public RequestContext prepareActionAudit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionAudit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAudit() {
    	return false;
    }
	public RequestContext prepareActionOffSet(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionOffSet() {
    	return false;
    }
	public RequestContext prepareActionQuickAddLine(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionQuickAddLine() {
    	return false;
    }
	public RequestContext prepareActionBackFlush(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBackFlush() {
    	return false;
    }
	public RequestContext prepareActionUnBackFlush(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnBackFlush() {
    	return false;
    }
	public RequestContext prepareactionInteractionBackFlush(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareactionInteractionBackFlush() {
    	return false;
    }

    /**
     * output ActionOffSet class
     */     
    protected class ActionOffSet extends ItemAction {     
    
        public ActionOffSet()
        {
            this(null);
        }

        public ActionOffSet(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt O"));
            _tempStr = resHelper.getString("ActionOffSet.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionOffSet.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionOffSet.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCManufactureBillEditUI.this, "ActionOffSet", "actionOffSet_actionPerformed", e);
        }
    }

    /**
     * output ActionQuickAddLine class
     */     
    protected class ActionQuickAddLine extends ItemAction {     
    
        public ActionQuickAddLine()
        {
            this(null);
        }

        public ActionQuickAddLine(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift ctrl Q"));
            _tempStr = resHelper.getString("ActionQuickAddLine.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionQuickAddLine.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionQuickAddLine.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCManufactureBillEditUI.this, "ActionQuickAddLine", "actionQuickAddLine_actionPerformed", e);
        }
    }

    /**
     * output ActionBackFlush class
     */     
    protected class ActionBackFlush extends ItemAction {     
    
        public ActionBackFlush()
        {
            this(null);
        }

        public ActionBackFlush(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt F"));
            _tempStr = resHelper.getString("ActionBackFlush.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBackFlush.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBackFlush.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCManufactureBillEditUI.this, "ActionBackFlush", "actionBackFlush_actionPerformed", e);
        }
    }

    /**
     * output ActionUnBackFlush class
     */     
    protected class ActionUnBackFlush extends ItemAction {     
    
        public ActionUnBackFlush()
        {
            this(null);
        }

        public ActionUnBackFlush(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt B"));
            _tempStr = resHelper.getString("ActionUnBackFlush.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnBackFlush.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnBackFlush.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCManufactureBillEditUI.this, "ActionUnBackFlush", "actionUnBackFlush_actionPerformed", e);
        }
    }

    /**
     * output actionInteractionBackFlush class
     */     
    protected class actionInteractionBackFlush extends ItemAction {     
    
        public actionInteractionBackFlush()
        {
            this(null);
        }

        public actionInteractionBackFlush(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("actionInteractionBackFlush.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actionInteractionBackFlush.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actionInteractionBackFlush.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCManufactureBillEditUI.this, "actionInteractionBackFlush", "actionInteractionBackFlush_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.food.client", "CManufactureBillEditUI");
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
        return com.kingdee.eas.farm.food.client.CManufactureBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.food.CManufactureBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.food.CManufactureBillInfo objectValue = new com.kingdee.eas.farm.food.CManufactureBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
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