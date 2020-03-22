/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

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
public abstract class AbstractBHatchBabyBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBHatchBabyBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttransDescription;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthealthQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdeathQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunhatchedEggQty;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contselectBabyPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimmunePerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchFactory;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchArea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contadminOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthealthQtyB;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnoHealthQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthealthQtyA1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthealthQtyA2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthealthQtyA3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchDate;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisAllOut;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcandlingDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttrayingDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgenderTy;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cboxFarmersTree;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cboxQcEggType;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisManuIn;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisOtherIn;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisGiftOtherIn;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisMaterOut;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPanetransDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txttransDescription;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel6;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel7;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtImmuneEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtImmuneEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtSaleEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtSaleEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtMatUserEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtMatUserEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtGoEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtGoEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthealthQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdeathQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtunhatchedEggQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtselectBabyPerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtimmunePerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthatchFactory;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthatchArea;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtadminOrg;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthealthQtyB;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnoHealthQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthealthQtyA1;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthealthQtyA2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthealthQtyA3;
    protected com.kingdee.bos.ctrl.swing.KDComboBox eggType;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkhatchDate;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton radioHorizon;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton radioVertical;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton radioOrigin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlossQty;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlossQty;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtSourceEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtSourceEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDButton btnViewUp;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cBoxFarmersTree;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cBoxQcEggType;
    protected com.kingdee.bos.ctrl.swing.KDButton btnGetMaoQty;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcandlingDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pktrayingDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox genderTy;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.hatch.BHatchBabyBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractBHatchBabyBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBHatchBabyBillEditUI.class.getName());
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
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttransDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contstorageOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthealthQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdeathQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunhatchedEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contselectBabyPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimmunePerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchFactory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contadminOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthealthQtyB = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnoHealthQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthealthQtyA1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthealthQtyA2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthealthQtyA3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisAllOut = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDPanel5 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contcandlingDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttrayingDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgenderTy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.cboxFarmersTree = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.cboxQcEggType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.chkisManuIn = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisOtherIn = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisGiftOtherIn = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisMaterOut = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.scrollPanetransDescription = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txttransDescription = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel6 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel7 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtImmuneEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtSaleEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtMatUserEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtGoEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtstorageOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txthealthQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdeathQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtunhatchedEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtselectBabyPerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtimmunePerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmthatchFactory = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmthatchArea = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtadminOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txthealthQtyB = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnoHealthQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthealthQtyA1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthealthQtyA2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthealthQtyA3 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.eggType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkhatchDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.radioHorizon = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.radioVertical = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.radioOrigin = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.contlossQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.txtlossQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kdtSourceEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnViewUp = new com.kingdee.bos.ctrl.swing.KDButton();
        this.cBoxFarmersTree = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.cBoxQcEggType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.btnGetMaoQty = new com.kingdee.bos.ctrl.swing.KDButton();
        this.pkcandlingDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pktrayingDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.genderTy = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contauditTime.setName("contauditTime");
        this.contbaseStatus.setName("contbaseStatus");
        this.conttransDescription.setName("conttransDescription");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contstorageOrg.setName("contstorageOrg");
        this.contcompany.setName("contcompany");
        this.conthealthQty.setName("conthealthQty");
        this.contdeathQty.setName("contdeathQty");
        this.contunhatchedEggQty.setName("contunhatchedEggQty");
        this.kDSeparator8.setName("kDSeparator8");
        this.contselectBabyPerson.setName("contselectBabyPerson");
        this.contimmunePerson.setName("contimmunePerson");
        this.conthatchFactory.setName("conthatchFactory");
        this.conthatchArea.setName("conthatchArea");
        this.contadminOrg.setName("contadminOrg");
        this.conthealthQtyB.setName("conthealthQtyB");
        this.contnoHealthQty.setName("contnoHealthQty");
        this.conthealthQtyA1.setName("conthealthQtyA1");
        this.conthealthQtyA2.setName("conthealthQtyA2");
        this.conthealthQtyA3.setName("conthealthQtyA3");
        this.conteggType.setName("conteggType");
        this.conthatchDate.setName("conthatchDate");
        this.chkisAllOut.setName("chkisAllOut");
        this.kDPanel5.setName("kDPanel5");
        this.contcandlingDate.setName("contcandlingDate");
        this.conttrayingDate.setName("conttrayingDate");
        this.contgenderTy.setName("contgenderTy");
        this.cboxFarmersTree.setName("cboxFarmersTree");
        this.cboxQcEggType.setName("cboxQcEggType");
        this.chkisManuIn.setName("chkisManuIn");
        this.chkisOtherIn.setName("chkisOtherIn");
        this.chkisGiftOtherIn.setName("chkisGiftOtherIn");
        this.chkisMaterOut.setName("chkisMaterOut");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditTime.setName("pkauditTime");
        this.baseStatus.setName("baseStatus");
        this.scrollPanetransDescription.setName("scrollPanetransDescription");
        this.txttransDescription.setName("txttransDescription");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel6.setName("kDPanel6");
        this.kDPanel7.setName("kDPanel7");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtImmuneEntrys.setName("kdtImmuneEntrys");
        this.kdtSaleEntry.setName("kdtSaleEntry");
        this.kdtMatUserEntry.setName("kdtMatUserEntry");
        this.kdtGoEntrys.setName("kdtGoEntrys");
        this.prmtstorageOrg.setName("prmtstorageOrg");
        this.prmtcompany.setName("prmtcompany");
        this.txthealthQty.setName("txthealthQty");
        this.txtdeathQty.setName("txtdeathQty");
        this.txtunhatchedEggQty.setName("txtunhatchedEggQty");
        this.prmtselectBabyPerson.setName("prmtselectBabyPerson");
        this.prmtimmunePerson.setName("prmtimmunePerson");
        this.prmthatchFactory.setName("prmthatchFactory");
        this.prmthatchArea.setName("prmthatchArea");
        this.prmtadminOrg.setName("prmtadminOrg");
        this.txthealthQtyB.setName("txthealthQtyB");
        this.txtnoHealthQty.setName("txtnoHealthQty");
        this.txthealthQtyA1.setName("txthealthQtyA1");
        this.txthealthQtyA2.setName("txthealthQtyA2");
        this.txthealthQtyA3.setName("txthealthQtyA3");
        this.eggType.setName("eggType");
        this.pkhatchDate.setName("pkhatchDate");
        this.radioHorizon.setName("radioHorizon");
        this.radioVertical.setName("radioVertical");
        this.radioOrigin.setName("radioOrigin");
        this.contlossQty.setName("contlossQty");
        this.kDPanel4.setName("kDPanel4");
        this.txtlossQty.setName("txtlossQty");
        this.kdtSourceEntrys.setName("kdtSourceEntrys");
        this.btnViewUp.setName("btnViewUp");
        this.cBoxFarmersTree.setName("cBoxFarmersTree");
        this.cBoxQcEggType.setName("cBoxQcEggType");
        this.btnGetMaoQty.setName("btnGetMaoQty");
        this.pkcandlingDate.setName("pkcandlingDate");
        this.pktrayingDate.setName("pktrayingDate");
        this.genderTy.setName("genderTy");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
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
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // conttransDescription		
        this.conttransDescription.setBoundLabelText(resHelper.getString("conttransDescription.boundLabelText"));		
        this.conttransDescription.setBoundLabelLength(100);		
        this.conttransDescription.setBoundLabelUnderline(true);		
        this.conttransDescription.setVisible(true);
        // kDTabbedPane1
        // contstorageOrg		
        this.contstorageOrg.setBoundLabelText(resHelper.getString("contstorageOrg.boundLabelText"));		
        this.contstorageOrg.setBoundLabelLength(100);		
        this.contstorageOrg.setBoundLabelUnderline(true);		
        this.contstorageOrg.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // conthealthQty		
        this.conthealthQty.setBoundLabelText(resHelper.getString("conthealthQty.boundLabelText"));		
        this.conthealthQty.setBoundLabelLength(100);		
        this.conthealthQty.setBoundLabelUnderline(true);		
        this.conthealthQty.setVisible(true);
        // contdeathQty		
        this.contdeathQty.setBoundLabelText(resHelper.getString("contdeathQty.boundLabelText"));		
        this.contdeathQty.setBoundLabelLength(100);		
        this.contdeathQty.setBoundLabelUnderline(true);		
        this.contdeathQty.setVisible(true);
        // contunhatchedEggQty		
        this.contunhatchedEggQty.setBoundLabelText(resHelper.getString("contunhatchedEggQty.boundLabelText"));		
        this.contunhatchedEggQty.setBoundLabelLength(100);		
        this.contunhatchedEggQty.setBoundLabelUnderline(true);		
        this.contunhatchedEggQty.setVisible(true);
        // kDSeparator8
        // contselectBabyPerson		
        this.contselectBabyPerson.setBoundLabelText(resHelper.getString("contselectBabyPerson.boundLabelText"));		
        this.contselectBabyPerson.setBoundLabelLength(100);		
        this.contselectBabyPerson.setBoundLabelUnderline(true);		
        this.contselectBabyPerson.setVisible(true);
        // contimmunePerson		
        this.contimmunePerson.setBoundLabelText(resHelper.getString("contimmunePerson.boundLabelText"));		
        this.contimmunePerson.setBoundLabelLength(100);		
        this.contimmunePerson.setBoundLabelUnderline(true);		
        this.contimmunePerson.setVisible(true);
        // conthatchFactory		
        this.conthatchFactory.setBoundLabelText(resHelper.getString("conthatchFactory.boundLabelText"));		
        this.conthatchFactory.setBoundLabelLength(100);		
        this.conthatchFactory.setBoundLabelUnderline(true);		
        this.conthatchFactory.setVisible(true);
        // conthatchArea		
        this.conthatchArea.setBoundLabelText(resHelper.getString("conthatchArea.boundLabelText"));		
        this.conthatchArea.setBoundLabelLength(100);		
        this.conthatchArea.setBoundLabelUnderline(true);		
        this.conthatchArea.setVisible(false);
        // contadminOrg		
        this.contadminOrg.setBoundLabelText(resHelper.getString("contadminOrg.boundLabelText"));		
        this.contadminOrg.setBoundLabelLength(100);		
        this.contadminOrg.setBoundLabelUnderline(true);		
        this.contadminOrg.setVisible(false);
        // conthealthQtyB		
        this.conthealthQtyB.setBoundLabelText(resHelper.getString("conthealthQtyB.boundLabelText"));		
        this.conthealthQtyB.setBoundLabelLength(100);		
        this.conthealthQtyB.setBoundLabelUnderline(true);		
        this.conthealthQtyB.setVisible(false);
        // contnoHealthQty		
        this.contnoHealthQty.setBoundLabelText(resHelper.getString("contnoHealthQty.boundLabelText"));		
        this.contnoHealthQty.setBoundLabelLength(100);		
        this.contnoHealthQty.setBoundLabelUnderline(true);		
        this.contnoHealthQty.setVisible(false);
        // conthealthQtyA1		
        this.conthealthQtyA1.setBoundLabelText(resHelper.getString("conthealthQtyA1.boundLabelText"));		
        this.conthealthQtyA1.setBoundLabelLength(100);		
        this.conthealthQtyA1.setBoundLabelUnderline(true);		
        this.conthealthQtyA1.setVisible(false);
        // conthealthQtyA2		
        this.conthealthQtyA2.setBoundLabelText(resHelper.getString("conthealthQtyA2.boundLabelText"));		
        this.conthealthQtyA2.setBoundLabelLength(100);		
        this.conthealthQtyA2.setBoundLabelUnderline(true);		
        this.conthealthQtyA2.setVisible(false);
        // conthealthQtyA3		
        this.conthealthQtyA3.setBoundLabelText(resHelper.getString("conthealthQtyA3.boundLabelText"));		
        this.conthealthQtyA3.setBoundLabelLength(100);		
        this.conthealthQtyA3.setBoundLabelUnderline(true);		
        this.conthealthQtyA3.setVisible(false);
        // conteggType		
        this.conteggType.setBoundLabelText(resHelper.getString("conteggType.boundLabelText"));		
        this.conteggType.setBoundLabelLength(100);		
        this.conteggType.setBoundLabelUnderline(true);		
        this.conteggType.setVisible(true);
        // conthatchDate		
        this.conthatchDate.setBoundLabelText(resHelper.getString("conthatchDate.boundLabelText"));		
        this.conthatchDate.setBoundLabelLength(100);		
        this.conthatchDate.setBoundLabelUnderline(true);		
        this.conthatchDate.setVisible(true);
        // chkisAllOut		
        this.chkisAllOut.setText(resHelper.getString("chkisAllOut.text"));		
        this.chkisAllOut.setHorizontalAlignment(2);		
        this.chkisAllOut.setVisible(false);
        // kDPanel5		
        this.kDPanel5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel5.border.title")));
        // contcandlingDate		
        this.contcandlingDate.setBoundLabelText(resHelper.getString("contcandlingDate.boundLabelText"));		
        this.contcandlingDate.setBoundLabelLength(100);		
        this.contcandlingDate.setBoundLabelUnderline(true);		
        this.contcandlingDate.setVisible(true);
        // conttrayingDate		
        this.conttrayingDate.setBoundLabelText(resHelper.getString("conttrayingDate.boundLabelText"));		
        this.conttrayingDate.setBoundLabelLength(100);		
        this.conttrayingDate.setBoundLabelUnderline(true);		
        this.conttrayingDate.setVisible(true);
        // contgenderTy		
        this.contgenderTy.setBoundLabelText(resHelper.getString("contgenderTy.boundLabelText"));		
        this.contgenderTy.setBoundLabelLength(100);		
        this.contgenderTy.setBoundLabelUnderline(true);		
        this.contgenderTy.setVisible(true);
        // cboxFarmersTree		
        this.cboxFarmersTree.setVisible(false);
        // cboxQcEggType		
        this.cboxQcEggType.setVisible(false);
        // chkisManuIn		
        this.chkisManuIn.setText(resHelper.getString("chkisManuIn.text"));		
        this.chkisManuIn.setVisible(true);		
        this.chkisManuIn.setHorizontalAlignment(2);		
        this.chkisManuIn.setEnabled(false);
        // chkisOtherIn		
        this.chkisOtherIn.setText(resHelper.getString("chkisOtherIn.text"));		
        this.chkisOtherIn.setVisible(true);		
        this.chkisOtherIn.setHorizontalAlignment(2);		
        this.chkisOtherIn.setEnabled(false);
        // chkisGiftOtherIn		
        this.chkisGiftOtherIn.setText(resHelper.getString("chkisGiftOtherIn.text"));		
        this.chkisGiftOtherIn.setVisible(true);		
        this.chkisGiftOtherIn.setHorizontalAlignment(2);		
        this.chkisGiftOtherIn.setEnabled(false);
        // chkisMaterOut		
        this.chkisMaterOut.setText(resHelper.getString("chkisMaterOut.text"));		
        this.chkisMaterOut.setVisible(true);		
        this.chkisMaterOut.setHorizontalAlignment(2);		
        this.chkisMaterOut.setEnabled(false);
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
        this.txtNumber.setRequired(true);
        // pkBizDate		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(true);		
        this.baseStatus.setEnabled(false);
        // scrollPanetransDescription
        // txttransDescription		
        this.txttransDescription.setRequired(false);		
        this.txttransDescription.setMaxLength(500);
        // kDPanel1
        // kDPanel2		
        this.kDPanel2.setVisible(false);
        // kDPanel3		
        this.kDPanel3.setVisible(false);
        // kDPanel6		
        this.kDPanel6.setVisible(false);
        // kDPanel7
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol34\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol35\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol36\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol37\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"hatchHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"incubator\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"outHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"hatchingBox\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"outAreaPP\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"strockbatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"ferm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"CostObject\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"eggSourceType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"genderType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qcEggType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"hatchQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"zdhps\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"lphps\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"healthQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"healthQty2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"germQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"femaleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"ksMaleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"gjMaleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"maleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"maoEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"deadGermQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"allOutQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"healthRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"lphralthRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"maoEggRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"germRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"eggBabyRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"maleFemaleRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"description\" t:width=\"300\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"lossDiff\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"gifts\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"week\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"day\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{hatchHouse}</t:Cell><t:Cell>$Resource{incubator}</t:Cell><t:Cell>$Resource{outHouse}</t:Cell><t:Cell>$Resource{hatchingBox}</t:Cell><t:Cell>$Resource{outAreaPP}</t:Cell><t:Cell>$Resource{strockbatch}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{ferm}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{CostObject}</t:Cell><t:Cell>$Resource{eggSourceType}</t:Cell><t:Cell>$Resource{genderType}</t:Cell><t:Cell>$Resource{qcEggType}</t:Cell><t:Cell>$Resource{hatchQty}</t:Cell><t:Cell>$Resource{zdhps}</t:Cell><t:Cell>$Resource{lphps}</t:Cell><t:Cell>$Resource{healthQty}</t:Cell><t:Cell>$Resource{healthQty2}</t:Cell><t:Cell>$Resource{germQty}</t:Cell><t:Cell>$Resource{femaleQty}</t:Cell><t:Cell>$Resource{ksMaleQty}</t:Cell><t:Cell>$Resource{gjMaleQty}</t:Cell><t:Cell>$Resource{maleQty}</t:Cell><t:Cell>$Resource{maoEggQty}</t:Cell><t:Cell>$Resource{deadGermQty}</t:Cell><t:Cell>$Resource{allOutQty}</t:Cell><t:Cell>$Resource{healthRate}</t:Cell><t:Cell>$Resource{lphralthRate}</t:Cell><t:Cell>$Resource{maoEggRate}</t:Cell><t:Cell>$Resource{germRate}</t:Cell><t:Cell>$Resource{eggBabyRate}</t:Cell><t:Cell>$Resource{maleFemaleRate}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{lossDiff}</t:Cell><t:Cell>$Resource{gifts}</t:Cell><t:Cell>$Resource{week}</t:Cell><t:Cell>$Resource{day}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","hatchHouse","incubator","outHouse","hatchingBox","outAreaPP","strockbatch","farmer","ferm","supplier","CostObject","eggSourceType","genderType","qcEggType","hatchQty","zdhps","lphps","healthQty","healthQty2","germQty","femaleQty","ksMaleQty","gjMaleQty","maleQty","maoEggQty","deadGermQty","allOutQty","healthRate","lphralthRate","maoEggRate","germRate","eggBabyRate","maleFemaleRate","description","lossDiff","gifts","week","day"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_hatchHouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_hatchHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchHouseQuery");
        kdtEntrys_hatchHouse_PromptBox.setVisible(true);
        kdtEntrys_hatchHouse_PromptBox.setEditable(true);
        kdtEntrys_hatchHouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_hatchHouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_hatchHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_hatchHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_hatchHouse_PromptBox);
        this.kdtEntrys.getColumn("hatchHouse").setEditor(kdtEntrys_hatchHouse_CellEditor);
        ObjectValueRender kdtEntrys_hatchHouse_OVR = new ObjectValueRender();
        kdtEntrys_hatchHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("hatchHouse").setRenderer(kdtEntrys_hatchHouse_OVR);
        			kdtEntrys_hatchHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchHouseListUI kdtEntrys_hatchHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_hatchHouse_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_hatchHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_hatchHouse_PromptBox_F7ListUI));
					kdtEntrys_hatchHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_hatchHouse_PromptBox.setSelector(kdtEntrys_hatchHouse_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_incubator_PromptBox = new KDBizPromptBox();
        kdtEntrys_incubator_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7IncubatorQuery");
        kdtEntrys_incubator_PromptBox.setVisible(true);
        kdtEntrys_incubator_PromptBox.setEditable(true);
        kdtEntrys_incubator_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_incubator_PromptBox.setEditFormat("$number$");
        kdtEntrys_incubator_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_incubator_CellEditor = new KDTDefaultCellEditor(kdtEntrys_incubator_PromptBox);
        this.kdtEntrys.getColumn("incubator").setEditor(kdtEntrys_incubator_CellEditor);
        ObjectValueRender kdtEntrys_incubator_OVR = new ObjectValueRender();
        kdtEntrys_incubator_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("incubator").setRenderer(kdtEntrys_incubator_OVR);
        			kdtEntrys_incubator_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.IncubatorListUI kdtEntrys_incubator_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_incubator_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_incubator_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.IncubatorListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_incubator_PromptBox_F7ListUI));
					kdtEntrys_incubator_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_incubator_PromptBox.setSelector(kdtEntrys_incubator_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_outHouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_outHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchHouseQuery");
        kdtEntrys_outHouse_PromptBox.setVisible(true);
        kdtEntrys_outHouse_PromptBox.setEditable(true);
        kdtEntrys_outHouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_outHouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_outHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_outHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_outHouse_PromptBox);
        this.kdtEntrys.getColumn("outHouse").setEditor(kdtEntrys_outHouse_CellEditor);
        ObjectValueRender kdtEntrys_outHouse_OVR = new ObjectValueRender();
        kdtEntrys_outHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("outHouse").setRenderer(kdtEntrys_outHouse_OVR);
        			kdtEntrys_outHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchHouseListUI kdtEntrys_outHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_outHouse_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_outHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_outHouse_PromptBox_F7ListUI));
					kdtEntrys_outHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_outHouse_PromptBox.setSelector(kdtEntrys_outHouse_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_hatchingBox_PromptBox = new KDBizPromptBox();
        kdtEntrys_hatchingBox_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7HatchingBoxQuery");
        kdtEntrys_hatchingBox_PromptBox.setVisible(true);
        kdtEntrys_hatchingBox_PromptBox.setEditable(true);
        kdtEntrys_hatchingBox_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_hatchingBox_PromptBox.setEditFormat("$number$");
        kdtEntrys_hatchingBox_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_hatchingBox_CellEditor = new KDTDefaultCellEditor(kdtEntrys_hatchingBox_PromptBox);
        this.kdtEntrys.getColumn("hatchingBox").setEditor(kdtEntrys_hatchingBox_CellEditor);
        ObjectValueRender kdtEntrys_hatchingBox_OVR = new ObjectValueRender();
        kdtEntrys_hatchingBox_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("hatchingBox").setRenderer(kdtEntrys_hatchingBox_OVR);
        			kdtEntrys_hatchingBox_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchingBoxListUI kdtEntrys_hatchingBox_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_hatchingBox_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_hatchingBox_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchingBoxListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_hatchingBox_PromptBox_F7ListUI));
					kdtEntrys_hatchingBox_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_hatchingBox_PromptBox.setSelector(kdtEntrys_hatchingBox_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_outAreaPP_PromptBox = new KDBizPromptBox();
        kdtEntrys_outAreaPP_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
        kdtEntrys_outAreaPP_PromptBox.setVisible(true);
        kdtEntrys_outAreaPP_PromptBox.setEditable(true);
        kdtEntrys_outAreaPP_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_outAreaPP_PromptBox.setEditFormat("$number$");
        kdtEntrys_outAreaPP_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_outAreaPP_CellEditor = new KDTDefaultCellEditor(kdtEntrys_outAreaPP_PromptBox);
        this.kdtEntrys.getColumn("outAreaPP").setEditor(kdtEntrys_outAreaPP_CellEditor);
        ObjectValueRender kdtEntrys_outAreaPP_OVR = new ObjectValueRender();
        kdtEntrys_outAreaPP_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("outAreaPP").setRenderer(kdtEntrys_outAreaPP_OVR);
        final KDBizPromptBox kdtEntrys_strockbatch_PromptBox = new KDBizPromptBox();
        kdtEntrys_strockbatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");
        kdtEntrys_strockbatch_PromptBox.setVisible(true);
        kdtEntrys_strockbatch_PromptBox.setEditable(true);
        kdtEntrys_strockbatch_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_strockbatch_PromptBox.setEditFormat("$number$");
        kdtEntrys_strockbatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_strockbatch_CellEditor = new KDTDefaultCellEditor(kdtEntrys_strockbatch_PromptBox);
        this.kdtEntrys.getColumn("strockbatch").setEditor(kdtEntrys_strockbatch_CellEditor);
        ObjectValueRender kdtEntrys_strockbatch_OVR = new ObjectValueRender();
        kdtEntrys_strockbatch_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("strockbatch").setRenderer(kdtEntrys_strockbatch_OVR);
        			kdtEntrys_strockbatch_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI kdtEntrys_strockbatch_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_strockbatch_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_strockbatch_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_strockbatch_PromptBox_F7ListUI));
					kdtEntrys_strockbatch_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_strockbatch_PromptBox.setSelector(kdtEntrys_strockbatch_PromptBox_F7ListUI);
				}
			}
		});
					
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
					
        final KDBizPromptBox kdtEntrys_ferm_PromptBox = new KDBizPromptBox();
        kdtEntrys_ferm_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");
        kdtEntrys_ferm_PromptBox.setVisible(true);
        kdtEntrys_ferm_PromptBox.setEditable(true);
        kdtEntrys_ferm_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_ferm_PromptBox.setEditFormat("$number$");
        kdtEntrys_ferm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_ferm_CellEditor = new KDTDefaultCellEditor(kdtEntrys_ferm_PromptBox);
        this.kdtEntrys.getColumn("ferm").setEditor(kdtEntrys_ferm_CellEditor);
        ObjectValueRender kdtEntrys_ferm_OVR = new ObjectValueRender();
        kdtEntrys_ferm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("ferm").setRenderer(kdtEntrys_ferm_OVR);
        			kdtEntrys_ferm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI kdtEntrys_ferm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_ferm_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_ferm_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_ferm_PromptBox_F7ListUI));
					kdtEntrys_ferm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_ferm_PromptBox.setSelector(kdtEntrys_ferm_PromptBox_F7ListUI);
				}
			}
		});
					
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
        final KDBizPromptBox kdtEntrys_CostObject_PromptBox = new KDBizPromptBox();
        kdtEntrys_CostObject_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");
        kdtEntrys_CostObject_PromptBox.setVisible(true);
        kdtEntrys_CostObject_PromptBox.setEditable(true);
        kdtEntrys_CostObject_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_CostObject_PromptBox.setEditFormat("$number$");
        kdtEntrys_CostObject_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_CostObject_CellEditor = new KDTDefaultCellEditor(kdtEntrys_CostObject_PromptBox);
        this.kdtEntrys.getColumn("CostObject").setEditor(kdtEntrys_CostObject_CellEditor);
        ObjectValueRender kdtEntrys_CostObject_OVR = new ObjectValueRender();
        kdtEntrys_CostObject_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("CostObject").setRenderer(kdtEntrys_CostObject_OVR);
        KDComboBox kdtEntrys_eggSourceType_ComboBox = new KDComboBox();
        kdtEntrys_eggSourceType_ComboBox.setName("kdtEntrys_eggSourceType_ComboBox");
        kdtEntrys_eggSourceType_ComboBox.setVisible(true);
        kdtEntrys_eggSourceType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggSourceType").toArray());
        KDTDefaultCellEditor kdtEntrys_eggSourceType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_eggSourceType_ComboBox);
        this.kdtEntrys.getColumn("eggSourceType").setEditor(kdtEntrys_eggSourceType_CellEditor);
        KDComboBox kdtEntrys_genderType_ComboBox = new KDComboBox();
        kdtEntrys_genderType_ComboBox.setName("kdtEntrys_genderType_ComboBox");
        kdtEntrys_genderType_ComboBox.setVisible(true);
        kdtEntrys_genderType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());
        KDTDefaultCellEditor kdtEntrys_genderType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_genderType_ComboBox);
        this.kdtEntrys.getColumn("genderType").setEditor(kdtEntrys_genderType_CellEditor);
        KDComboBox kdtEntrys_qcEggType_ComboBox = new KDComboBox();
        kdtEntrys_qcEggType_ComboBox.setName("kdtEntrys_qcEggType_ComboBox");
        kdtEntrys_qcEggType_ComboBox.setVisible(true);
        kdtEntrys_qcEggType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.QcEggTypeEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_qcEggType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qcEggType_ComboBox);
        this.kdtEntrys.getColumn("qcEggType").setEditor(kdtEntrys_qcEggType_CellEditor);
        KDFormattedTextField kdtEntrys_hatchQty_TextField = new KDFormattedTextField();
        kdtEntrys_hatchQty_TextField.setName("kdtEntrys_hatchQty_TextField");
        kdtEntrys_hatchQty_TextField.setVisible(true);
        kdtEntrys_hatchQty_TextField.setEditable(true);
        kdtEntrys_hatchQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_hatchQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_hatchQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_hatchQty_TextField);
        this.kdtEntrys.getColumn("hatchQty").setEditor(kdtEntrys_hatchQty_CellEditor);
        KDFormattedTextField kdtEntrys_zdhps_TextField = new KDFormattedTextField();
        kdtEntrys_zdhps_TextField.setName("kdtEntrys_zdhps_TextField");
        kdtEntrys_zdhps_TextField.setVisible(true);
        kdtEntrys_zdhps_TextField.setEditable(true);
        kdtEntrys_zdhps_TextField.setHorizontalAlignment(2);
        kdtEntrys_zdhps_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_zdhps_CellEditor = new KDTDefaultCellEditor(kdtEntrys_zdhps_TextField);
        this.kdtEntrys.getColumn("zdhps").setEditor(kdtEntrys_zdhps_CellEditor);
        KDFormattedTextField kdtEntrys_lphps_TextField = new KDFormattedTextField();
        kdtEntrys_lphps_TextField.setName("kdtEntrys_lphps_TextField");
        kdtEntrys_lphps_TextField.setVisible(true);
        kdtEntrys_lphps_TextField.setEditable(true);
        kdtEntrys_lphps_TextField.setHorizontalAlignment(2);
        kdtEntrys_lphps_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_lphps_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lphps_TextField);
        this.kdtEntrys.getColumn("lphps").setEditor(kdtEntrys_lphps_CellEditor);
        KDFormattedTextField kdtEntrys_healthQty_TextField = new KDFormattedTextField();
        kdtEntrys_healthQty_TextField.setName("kdtEntrys_healthQty_TextField");
        kdtEntrys_healthQty_TextField.setVisible(true);
        kdtEntrys_healthQty_TextField.setEditable(true);
        kdtEntrys_healthQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_healthQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_healthQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_healthQty_TextField);
        this.kdtEntrys.getColumn("healthQty").setEditor(kdtEntrys_healthQty_CellEditor);
        KDFormattedTextField kdtEntrys_healthQty2_TextField = new KDFormattedTextField();
        kdtEntrys_healthQty2_TextField.setName("kdtEntrys_healthQty2_TextField");
        kdtEntrys_healthQty2_TextField.setVisible(true);
        kdtEntrys_healthQty2_TextField.setEditable(true);
        kdtEntrys_healthQty2_TextField.setHorizontalAlignment(2);
        kdtEntrys_healthQty2_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_healthQty2_CellEditor = new KDTDefaultCellEditor(kdtEntrys_healthQty2_TextField);
        this.kdtEntrys.getColumn("healthQty2").setEditor(kdtEntrys_healthQty2_CellEditor);
        KDFormattedTextField kdtEntrys_germQty_TextField = new KDFormattedTextField();
        kdtEntrys_germQty_TextField.setName("kdtEntrys_germQty_TextField");
        kdtEntrys_germQty_TextField.setVisible(true);
        kdtEntrys_germQty_TextField.setEditable(true);
        kdtEntrys_germQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_germQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_germQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_germQty_TextField);
        this.kdtEntrys.getColumn("germQty").setEditor(kdtEntrys_germQty_CellEditor);
        KDFormattedTextField kdtEntrys_femaleQty_TextField = new KDFormattedTextField();
        kdtEntrys_femaleQty_TextField.setName("kdtEntrys_femaleQty_TextField");
        kdtEntrys_femaleQty_TextField.setVisible(true);
        kdtEntrys_femaleQty_TextField.setEditable(true);
        kdtEntrys_femaleQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_femaleQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_femaleQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_femaleQty_TextField);
        this.kdtEntrys.getColumn("femaleQty").setEditor(kdtEntrys_femaleQty_CellEditor);
        KDFormattedTextField kdtEntrys_ksMaleQty_TextField = new KDFormattedTextField();
        kdtEntrys_ksMaleQty_TextField.setName("kdtEntrys_ksMaleQty_TextField");
        kdtEntrys_ksMaleQty_TextField.setVisible(true);
        kdtEntrys_ksMaleQty_TextField.setEditable(true);
        kdtEntrys_ksMaleQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_ksMaleQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_ksMaleQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_ksMaleQty_TextField);
        this.kdtEntrys.getColumn("ksMaleQty").setEditor(kdtEntrys_ksMaleQty_CellEditor);
        KDFormattedTextField kdtEntrys_gjMaleQty_TextField = new KDFormattedTextField();
        kdtEntrys_gjMaleQty_TextField.setName("kdtEntrys_gjMaleQty_TextField");
        kdtEntrys_gjMaleQty_TextField.setVisible(true);
        kdtEntrys_gjMaleQty_TextField.setEditable(true);
        kdtEntrys_gjMaleQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_gjMaleQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_gjMaleQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_gjMaleQty_TextField);
        this.kdtEntrys.getColumn("gjMaleQty").setEditor(kdtEntrys_gjMaleQty_CellEditor);
        KDFormattedTextField kdtEntrys_maleQty_TextField = new KDFormattedTextField();
        kdtEntrys_maleQty_TextField.setName("kdtEntrys_maleQty_TextField");
        kdtEntrys_maleQty_TextField.setVisible(true);
        kdtEntrys_maleQty_TextField.setEditable(true);
        kdtEntrys_maleQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_maleQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_maleQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_maleQty_TextField);
        this.kdtEntrys.getColumn("maleQty").setEditor(kdtEntrys_maleQty_CellEditor);
        KDFormattedTextField kdtEntrys_maoEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_maoEggQty_TextField.setName("kdtEntrys_maoEggQty_TextField");
        kdtEntrys_maoEggQty_TextField.setVisible(true);
        kdtEntrys_maoEggQty_TextField.setEditable(true);
        kdtEntrys_maoEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_maoEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_maoEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_maoEggQty_TextField);
        this.kdtEntrys.getColumn("maoEggQty").setEditor(kdtEntrys_maoEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_deadGermQty_TextField = new KDFormattedTextField();
        kdtEntrys_deadGermQty_TextField.setName("kdtEntrys_deadGermQty_TextField");
        kdtEntrys_deadGermQty_TextField.setVisible(true);
        kdtEntrys_deadGermQty_TextField.setEditable(true);
        kdtEntrys_deadGermQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_deadGermQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_deadGermQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_deadGermQty_TextField);
        this.kdtEntrys.getColumn("deadGermQty").setEditor(kdtEntrys_deadGermQty_CellEditor);
        KDFormattedTextField kdtEntrys_allOutQty_TextField = new KDFormattedTextField();
        kdtEntrys_allOutQty_TextField.setName("kdtEntrys_allOutQty_TextField");
        kdtEntrys_allOutQty_TextField.setVisible(true);
        kdtEntrys_allOutQty_TextField.setEditable(true);
        kdtEntrys_allOutQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_allOutQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_allOutQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_allOutQty_TextField);
        this.kdtEntrys.getColumn("allOutQty").setEditor(kdtEntrys_allOutQty_CellEditor);
        KDFormattedTextField kdtEntrys_healthRate_TextField = new KDFormattedTextField();
        kdtEntrys_healthRate_TextField.setName("kdtEntrys_healthRate_TextField");
        kdtEntrys_healthRate_TextField.setVisible(true);
        kdtEntrys_healthRate_TextField.setEditable(true);
        kdtEntrys_healthRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_healthRate_TextField.setDataType(1);
        	kdtEntrys_healthRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_healthRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_healthRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_healthRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_healthRate_TextField);
        this.kdtEntrys.getColumn("healthRate").setEditor(kdtEntrys_healthRate_CellEditor);
        KDFormattedTextField kdtEntrys_lphralthRate_TextField = new KDFormattedTextField();
        kdtEntrys_lphralthRate_TextField.setName("kdtEntrys_lphralthRate_TextField");
        kdtEntrys_lphralthRate_TextField.setVisible(true);
        kdtEntrys_lphralthRate_TextField.setEditable(true);
        kdtEntrys_lphralthRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_lphralthRate_TextField.setDataType(1);
        	kdtEntrys_lphralthRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_lphralthRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_lphralthRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_lphralthRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lphralthRate_TextField);
        this.kdtEntrys.getColumn("lphralthRate").setEditor(kdtEntrys_lphralthRate_CellEditor);
        KDFormattedTextField kdtEntrys_maoEggRate_TextField = new KDFormattedTextField();
        kdtEntrys_maoEggRate_TextField.setName("kdtEntrys_maoEggRate_TextField");
        kdtEntrys_maoEggRate_TextField.setVisible(true);
        kdtEntrys_maoEggRate_TextField.setEditable(true);
        kdtEntrys_maoEggRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_maoEggRate_TextField.setDataType(1);
        	kdtEntrys_maoEggRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_maoEggRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_maoEggRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_maoEggRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_maoEggRate_TextField);
        this.kdtEntrys.getColumn("maoEggRate").setEditor(kdtEntrys_maoEggRate_CellEditor);
        KDFormattedTextField kdtEntrys_germRate_TextField = new KDFormattedTextField();
        kdtEntrys_germRate_TextField.setName("kdtEntrys_germRate_TextField");
        kdtEntrys_germRate_TextField.setVisible(true);
        kdtEntrys_germRate_TextField.setEditable(true);
        kdtEntrys_germRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_germRate_TextField.setDataType(1);
        	kdtEntrys_germRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_germRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_germRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_germRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_germRate_TextField);
        this.kdtEntrys.getColumn("germRate").setEditor(kdtEntrys_germRate_CellEditor);
        KDFormattedTextField kdtEntrys_eggBabyRate_TextField = new KDFormattedTextField();
        kdtEntrys_eggBabyRate_TextField.setName("kdtEntrys_eggBabyRate_TextField");
        kdtEntrys_eggBabyRate_TextField.setVisible(true);
        kdtEntrys_eggBabyRate_TextField.setEditable(true);
        kdtEntrys_eggBabyRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_eggBabyRate_TextField.setDataType(1);
        	kdtEntrys_eggBabyRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_eggBabyRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_eggBabyRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_eggBabyRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_eggBabyRate_TextField);
        this.kdtEntrys.getColumn("eggBabyRate").setEditor(kdtEntrys_eggBabyRate_CellEditor);
        KDFormattedTextField kdtEntrys_maleFemaleRate_TextField = new KDFormattedTextField();
        kdtEntrys_maleFemaleRate_TextField.setName("kdtEntrys_maleFemaleRate_TextField");
        kdtEntrys_maleFemaleRate_TextField.setVisible(true);
        kdtEntrys_maleFemaleRate_TextField.setEditable(true);
        kdtEntrys_maleFemaleRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_maleFemaleRate_TextField.setDataType(1);
        	kdtEntrys_maleFemaleRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_maleFemaleRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_maleFemaleRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_maleFemaleRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_maleFemaleRate_TextField);
        this.kdtEntrys.getColumn("maleFemaleRate").setEditor(kdtEntrys_maleFemaleRate_CellEditor);
        KDTextArea kdtEntrys_description_TextArea = new KDTextArea();
        kdtEntrys_description_TextArea.setName("kdtEntrys_description_TextArea");
        kdtEntrys_description_TextArea.setMaxLength(255);
        KDTDefaultCellEditor kdtEntrys_description_CellEditor = new KDTDefaultCellEditor(kdtEntrys_description_TextArea);
        this.kdtEntrys.getColumn("description").setEditor(kdtEntrys_description_CellEditor);
        KDFormattedTextField kdtEntrys_lossDiff_TextField = new KDFormattedTextField();
        kdtEntrys_lossDiff_TextField.setName("kdtEntrys_lossDiff_TextField");
        kdtEntrys_lossDiff_TextField.setVisible(true);
        kdtEntrys_lossDiff_TextField.setEditable(true);
        kdtEntrys_lossDiff_TextField.setHorizontalAlignment(2);
        kdtEntrys_lossDiff_TextField.setDataType(1);
        	kdtEntrys_lossDiff_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_lossDiff_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_lossDiff_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_lossDiff_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lossDiff_TextField);
        this.kdtEntrys.getColumn("lossDiff").setEditor(kdtEntrys_lossDiff_CellEditor);
        KDFormattedTextField kdtEntrys_gifts_TextField = new KDFormattedTextField();
        kdtEntrys_gifts_TextField.setName("kdtEntrys_gifts_TextField");
        kdtEntrys_gifts_TextField.setVisible(true);
        kdtEntrys_gifts_TextField.setEditable(true);
        kdtEntrys_gifts_TextField.setHorizontalAlignment(2);
        kdtEntrys_gifts_TextField.setDataType(1);
        	kdtEntrys_gifts_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_gifts_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_gifts_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_gifts_CellEditor = new KDTDefaultCellEditor(kdtEntrys_gifts_TextField);
        this.kdtEntrys.getColumn("gifts").setEditor(kdtEntrys_gifts_CellEditor);
        KDFormattedTextField kdtEntrys_week_TextField = new KDFormattedTextField();
        kdtEntrys_week_TextField.setName("kdtEntrys_week_TextField");
        kdtEntrys_week_TextField.setVisible(true);
        kdtEntrys_week_TextField.setEditable(true);
        kdtEntrys_week_TextField.setHorizontalAlignment(2);
        kdtEntrys_week_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_week_CellEditor = new KDTDefaultCellEditor(kdtEntrys_week_TextField);
        this.kdtEntrys.getColumn("week").setEditor(kdtEntrys_week_CellEditor);
        KDFormattedTextField kdtEntrys_day_TextField = new KDFormattedTextField();
        kdtEntrys_day_TextField.setName("kdtEntrys_day_TextField");
        kdtEntrys_day_TextField.setVisible(true);
        kdtEntrys_day_TextField.setEditable(true);
        kdtEntrys_day_TextField.setHorizontalAlignment(2);
        kdtEntrys_day_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_day_CellEditor = new KDTDefaultCellEditor(kdtEntrys_day_TextField);
        this.kdtEntrys.getColumn("day").setEditor(kdtEntrys_day_CellEditor);
        // kdtImmuneEntrys
		String kdtImmuneEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"immuneMaterial\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"usedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"immuneUserQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"description\" t:width=\"400\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{immuneMaterial}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{usedQty}</t:Cell><t:Cell>$Resource{immuneUserQty}</t:Cell><t:Cell>$Resource{description}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtImmuneEntrys.setFormatXml(resHelper.translateString("kdtImmuneEntrys",kdtImmuneEntrysStrXML));
        kdtImmuneEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtImmuneEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtImmuneEntrys.putBindContents("editData",new String[] {"seq","immuneMaterial","unit","usedQty","immuneUserQty","description"});


        this.kdtImmuneEntrys.checkParsed();
        KDFormattedTextField kdtImmuneEntrys_seq_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_seq_TextField.setName("kdtImmuneEntrys_seq_TextField");
        kdtImmuneEntrys_seq_TextField.setVisible(true);
        kdtImmuneEntrys_seq_TextField.setEditable(true);
        kdtImmuneEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtImmuneEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_seq_TextField);
        this.kdtImmuneEntrys.getColumn("seq").setEditor(kdtImmuneEntrys_seq_CellEditor);
        final KDBizPromptBox kdtImmuneEntrys_immuneMaterial_PromptBox = new KDBizPromptBox();
        kdtImmuneEntrys_immuneMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtImmuneEntrys_immuneMaterial_PromptBox.setVisible(true);
        kdtImmuneEntrys_immuneMaterial_PromptBox.setEditable(true);
        kdtImmuneEntrys_immuneMaterial_PromptBox.setDisplayFormat("$number$");
        kdtImmuneEntrys_immuneMaterial_PromptBox.setEditFormat("$number$");
        kdtImmuneEntrys_immuneMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtImmuneEntrys_immuneMaterial_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_immuneMaterial_PromptBox);
        this.kdtImmuneEntrys.getColumn("immuneMaterial").setEditor(kdtImmuneEntrys_immuneMaterial_CellEditor);
        ObjectValueRender kdtImmuneEntrys_immuneMaterial_OVR = new ObjectValueRender();
        kdtImmuneEntrys_immuneMaterial_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtImmuneEntrys.getColumn("immuneMaterial").setRenderer(kdtImmuneEntrys_immuneMaterial_OVR);
        KDTextField kdtImmuneEntrys_unit_TextField = new KDTextField();
        kdtImmuneEntrys_unit_TextField.setName("kdtImmuneEntrys_unit_TextField");
        kdtImmuneEntrys_unit_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtImmuneEntrys_unit_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_unit_TextField);
        this.kdtImmuneEntrys.getColumn("unit").setEditor(kdtImmuneEntrys_unit_CellEditor);
        KDFormattedTextField kdtImmuneEntrys_usedQty_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_usedQty_TextField.setName("kdtImmuneEntrys_usedQty_TextField");
        kdtImmuneEntrys_usedQty_TextField.setVisible(true);
        kdtImmuneEntrys_usedQty_TextField.setEditable(true);
        kdtImmuneEntrys_usedQty_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_usedQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtImmuneEntrys_usedQty_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_usedQty_TextField);
        this.kdtImmuneEntrys.getColumn("usedQty").setEditor(kdtImmuneEntrys_usedQty_CellEditor);
        KDFormattedTextField kdtImmuneEntrys_immuneUserQty_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_immuneUserQty_TextField.setName("kdtImmuneEntrys_immuneUserQty_TextField");
        kdtImmuneEntrys_immuneUserQty_TextField.setVisible(true);
        kdtImmuneEntrys_immuneUserQty_TextField.setEditable(true);
        kdtImmuneEntrys_immuneUserQty_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_immuneUserQty_TextField.setDataType(1);
        	kdtImmuneEntrys_immuneUserQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtImmuneEntrys_immuneUserQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtImmuneEntrys_immuneUserQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtImmuneEntrys_immuneUserQty_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_immuneUserQty_TextField);
        this.kdtImmuneEntrys.getColumn("immuneUserQty").setEditor(kdtImmuneEntrys_immuneUserQty_CellEditor);
        KDTextField kdtImmuneEntrys_description_TextField = new KDTextField();
        kdtImmuneEntrys_description_TextField.setName("kdtImmuneEntrys_description_TextField");
        kdtImmuneEntrys_description_TextField.setMaxLength(255);
        KDTDefaultCellEditor kdtImmuneEntrys_description_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_description_TextField);
        this.kdtImmuneEntrys.getColumn("description").setEditor(kdtImmuneEntrys_description_CellEditor);
        // kdtSaleEntry
		String kdtSaleEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"customer\" t:width=\"350\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol4\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{price}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtSaleEntry.setFormatXml(resHelper.translateString("kdtSaleEntry",kdtSaleEntryStrXML));		
        this.kdtSaleEntry.setVisible(false);

                this.kdtSaleEntry.putBindContents("editData",new String[] {"seq","material","customer","qty","price"});


        this.kdtSaleEntry.checkParsed();
        KDFormattedTextField kdtSaleEntry_seq_TextField = new KDFormattedTextField();
        kdtSaleEntry_seq_TextField.setName("kdtSaleEntry_seq_TextField");
        kdtSaleEntry_seq_TextField.setVisible(true);
        kdtSaleEntry_seq_TextField.setEditable(true);
        kdtSaleEntry_seq_TextField.setHorizontalAlignment(2);
        kdtSaleEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSaleEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtSaleEntry_seq_TextField);
        this.kdtSaleEntry.getColumn("seq").setEditor(kdtSaleEntry_seq_CellEditor);
        final KDBizPromptBox kdtSaleEntry_material_PromptBox = new KDBizPromptBox();
        kdtSaleEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtSaleEntry_material_PromptBox.setVisible(true);
        kdtSaleEntry_material_PromptBox.setEditable(true);
        kdtSaleEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtSaleEntry_material_PromptBox.setEditFormat("$number$");
        kdtSaleEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSaleEntry_material_CellEditor = new KDTDefaultCellEditor(kdtSaleEntry_material_PromptBox);
        this.kdtSaleEntry.getColumn("material").setEditor(kdtSaleEntry_material_CellEditor);
        ObjectValueRender kdtSaleEntry_material_OVR = new ObjectValueRender();
        kdtSaleEntry_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtSaleEntry.getColumn("material").setRenderer(kdtSaleEntry_material_OVR);
        final KDBizPromptBox kdtSaleEntry_customer_PromptBox = new KDBizPromptBox();
        kdtSaleEntry_customer_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");
        kdtSaleEntry_customer_PromptBox.setVisible(true);
        kdtSaleEntry_customer_PromptBox.setEditable(true);
        kdtSaleEntry_customer_PromptBox.setDisplayFormat("$number$");
        kdtSaleEntry_customer_PromptBox.setEditFormat("$number$");
        kdtSaleEntry_customer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSaleEntry_customer_CellEditor = new KDTDefaultCellEditor(kdtSaleEntry_customer_PromptBox);
        this.kdtSaleEntry.getColumn("customer").setEditor(kdtSaleEntry_customer_CellEditor);
        ObjectValueRender kdtSaleEntry_customer_OVR = new ObjectValueRender();
        kdtSaleEntry_customer_OVR.setFormat(new BizDataFormat("$number$-$name$"));
        this.kdtSaleEntry.getColumn("customer").setRenderer(kdtSaleEntry_customer_OVR);
        KDFormattedTextField kdtSaleEntry_qty_TextField = new KDFormattedTextField();
        kdtSaleEntry_qty_TextField.setName("kdtSaleEntry_qty_TextField");
        kdtSaleEntry_qty_TextField.setVisible(true);
        kdtSaleEntry_qty_TextField.setEditable(true);
        kdtSaleEntry_qty_TextField.setHorizontalAlignment(2);
        kdtSaleEntry_qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSaleEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtSaleEntry_qty_TextField);
        this.kdtSaleEntry.getColumn("qty").setEditor(kdtSaleEntry_qty_CellEditor);
        KDFormattedTextField kdtSaleEntry_price_TextField = new KDFormattedTextField();
        kdtSaleEntry_price_TextField.setName("kdtSaleEntry_price_TextField");
        kdtSaleEntry_price_TextField.setVisible(true);
        kdtSaleEntry_price_TextField.setEditable(true);
        kdtSaleEntry_price_TextField.setHorizontalAlignment(2);
        kdtSaleEntry_price_TextField.setDataType(1);
        	kdtSaleEntry_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtSaleEntry_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtSaleEntry_price_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtSaleEntry_price_CellEditor = new KDTDefaultCellEditor(kdtSaleEntry_price_TextField);
        this.kdtSaleEntry.getColumn("price").setEditor(kdtSaleEntry_price_CellEditor);
        // kdtMatUserEntry
		String kdtMatUserEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"matNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"matName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"matModel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"matUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"matQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{matNum}</t:Cell><t:Cell>$Resource{matName}</t:Cell><t:Cell>$Resource{matModel}</t:Cell><t:Cell>$Resource{matUnit}</t:Cell><t:Cell>$Resource{matQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtMatUserEntry.setFormatXml(resHelper.translateString("kdtMatUserEntry",kdtMatUserEntryStrXML));
        kdtMatUserEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtMatUserEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtMatUserEntry.putBindContents("editData",new String[] {"seq","matNum","matName","matModel","matUnit","matQty"});


        this.kdtMatUserEntry.checkParsed();
        KDFormattedTextField kdtMatUserEntry_seq_TextField = new KDFormattedTextField();
        kdtMatUserEntry_seq_TextField.setName("kdtMatUserEntry_seq_TextField");
        kdtMatUserEntry_seq_TextField.setVisible(true);
        kdtMatUserEntry_seq_TextField.setEditable(true);
        kdtMatUserEntry_seq_TextField.setHorizontalAlignment(2);
        kdtMatUserEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtMatUserEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtMatUserEntry_seq_TextField);
        this.kdtMatUserEntry.getColumn("seq").setEditor(kdtMatUserEntry_seq_CellEditor);
        final KDBizPromptBox kdtMatUserEntry_matNum_PromptBox = new KDBizPromptBox();
        kdtMatUserEntry_matNum_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtMatUserEntry_matNum_PromptBox.setVisible(true);
        kdtMatUserEntry_matNum_PromptBox.setEditable(true);
        kdtMatUserEntry_matNum_PromptBox.setDisplayFormat("$number$");
        kdtMatUserEntry_matNum_PromptBox.setEditFormat("$number$");
        kdtMatUserEntry_matNum_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtMatUserEntry_matNum_CellEditor = new KDTDefaultCellEditor(kdtMatUserEntry_matNum_PromptBox);
        this.kdtMatUserEntry.getColumn("matNum").setEditor(kdtMatUserEntry_matNum_CellEditor);
        ObjectValueRender kdtMatUserEntry_matNum_OVR = new ObjectValueRender();
        kdtMatUserEntry_matNum_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtMatUserEntry.getColumn("matNum").setRenderer(kdtMatUserEntry_matNum_OVR);
        KDTextField kdtMatUserEntry_matName_TextField = new KDTextField();
        kdtMatUserEntry_matName_TextField.setName("kdtMatUserEntry_matName_TextField");
        kdtMatUserEntry_matName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtMatUserEntry_matName_CellEditor = new KDTDefaultCellEditor(kdtMatUserEntry_matName_TextField);
        this.kdtMatUserEntry.getColumn("matName").setEditor(kdtMatUserEntry_matName_CellEditor);
        KDTextField kdtMatUserEntry_matModel_TextField = new KDTextField();
        kdtMatUserEntry_matModel_TextField.setName("kdtMatUserEntry_matModel_TextField");
        kdtMatUserEntry_matModel_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtMatUserEntry_matModel_CellEditor = new KDTDefaultCellEditor(kdtMatUserEntry_matModel_TextField);
        this.kdtMatUserEntry.getColumn("matModel").setEditor(kdtMatUserEntry_matModel_CellEditor);
        KDTextField kdtMatUserEntry_matUnit_TextField = new KDTextField();
        kdtMatUserEntry_matUnit_TextField.setName("kdtMatUserEntry_matUnit_TextField");
        kdtMatUserEntry_matUnit_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtMatUserEntry_matUnit_CellEditor = new KDTDefaultCellEditor(kdtMatUserEntry_matUnit_TextField);
        this.kdtMatUserEntry.getColumn("matUnit").setEditor(kdtMatUserEntry_matUnit_CellEditor);
        KDFormattedTextField kdtMatUserEntry_matQty_TextField = new KDFormattedTextField();
        kdtMatUserEntry_matQty_TextField.setName("kdtMatUserEntry_matQty_TextField");
        kdtMatUserEntry_matQty_TextField.setVisible(true);
        kdtMatUserEntry_matQty_TextField.setEditable(true);
        kdtMatUserEntry_matQty_TextField.setHorizontalAlignment(2);
        kdtMatUserEntry_matQty_TextField.setDataType(1);
        	kdtMatUserEntry_matQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtMatUserEntry_matQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtMatUserEntry_matQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtMatUserEntry_matQty_CellEditor = new KDTDefaultCellEditor(kdtMatUserEntry_matQty_TextField);
        this.kdtMatUserEntry.getColumn("matQty").setEditor(kdtMatUserEntry_matQty_CellEditor);
        // kdtGoEntrys
		String kdtGoEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"goType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"drug\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"serviceItems\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{goType}</t:Cell><t:Cell>$Resource{billNumber}</t:Cell><t:Cell>$Resource{drug}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{serviceItems}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtGoEntrys.setFormatXml(resHelper.translateString("kdtGoEntrys",kdtGoEntrysStrXML));
        kdtGoEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtGoEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtGoEntrys.putBindContents("editData",new String[] {"seq","goType","billNumber","drug","model","unit","qty","serviceItems"});


        this.kdtGoEntrys.checkParsed();
        KDFormattedTextField kdtGoEntrys_seq_TextField = new KDFormattedTextField();
        kdtGoEntrys_seq_TextField.setName("kdtGoEntrys_seq_TextField");
        kdtGoEntrys_seq_TextField.setVisible(true);
        kdtGoEntrys_seq_TextField.setEditable(true);
        kdtGoEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtGoEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtGoEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtGoEntrys_seq_TextField);
        this.kdtGoEntrys.getColumn("seq").setEditor(kdtGoEntrys_seq_CellEditor);
        KDComboBox kdtGoEntrys_goType_ComboBox = new KDComboBox();
        kdtGoEntrys_goType_ComboBox.setName("kdtGoEntrys_goType_ComboBox");
        kdtGoEntrys_goType_ComboBox.setVisible(true);
        kdtGoEntrys_goType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.GoType").toArray());
        KDTDefaultCellEditor kdtGoEntrys_goType_CellEditor = new KDTDefaultCellEditor(kdtGoEntrys_goType_ComboBox);
        this.kdtGoEntrys.getColumn("goType").setEditor(kdtGoEntrys_goType_CellEditor);
        KDTextField kdtGoEntrys_billNumber_TextField = new KDTextField();
        kdtGoEntrys_billNumber_TextField.setName("kdtGoEntrys_billNumber_TextField");
        kdtGoEntrys_billNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtGoEntrys_billNumber_CellEditor = new KDTDefaultCellEditor(kdtGoEntrys_billNumber_TextField);
        this.kdtGoEntrys.getColumn("billNumber").setEditor(kdtGoEntrys_billNumber_CellEditor);
        final KDBizPromptBox kdtGoEntrys_drug_PromptBox = new KDBizPromptBox();
        kdtGoEntrys_drug_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtGoEntrys_drug_PromptBox.setVisible(true);
        kdtGoEntrys_drug_PromptBox.setEditable(true);
        kdtGoEntrys_drug_PromptBox.setDisplayFormat("$number$");
        kdtGoEntrys_drug_PromptBox.setEditFormat("$number$");
        kdtGoEntrys_drug_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtGoEntrys_drug_CellEditor = new KDTDefaultCellEditor(kdtGoEntrys_drug_PromptBox);
        this.kdtGoEntrys.getColumn("drug").setEditor(kdtGoEntrys_drug_CellEditor);
        ObjectValueRender kdtGoEntrys_drug_OVR = new ObjectValueRender();
        kdtGoEntrys_drug_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtGoEntrys.getColumn("drug").setRenderer(kdtGoEntrys_drug_OVR);
        KDTextField kdtGoEntrys_model_TextField = new KDTextField();
        kdtGoEntrys_model_TextField.setName("kdtGoEntrys_model_TextField");
        kdtGoEntrys_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtGoEntrys_model_CellEditor = new KDTDefaultCellEditor(kdtGoEntrys_model_TextField);
        this.kdtGoEntrys.getColumn("model").setEditor(kdtGoEntrys_model_CellEditor);
        final KDBizPromptBox kdtGoEntrys_unit_PromptBox = new KDBizPromptBox();
        kdtGoEntrys_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtGoEntrys_unit_PromptBox.setVisible(true);
        kdtGoEntrys_unit_PromptBox.setEditable(true);
        kdtGoEntrys_unit_PromptBox.setDisplayFormat("$number$");
        kdtGoEntrys_unit_PromptBox.setEditFormat("$number$");
        kdtGoEntrys_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtGoEntrys_unit_CellEditor = new KDTDefaultCellEditor(kdtGoEntrys_unit_PromptBox);
        this.kdtGoEntrys.getColumn("unit").setEditor(kdtGoEntrys_unit_CellEditor);
        ObjectValueRender kdtGoEntrys_unit_OVR = new ObjectValueRender();
        kdtGoEntrys_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtGoEntrys.getColumn("unit").setRenderer(kdtGoEntrys_unit_OVR);
        KDFormattedTextField kdtGoEntrys_qty_TextField = new KDFormattedTextField();
        kdtGoEntrys_qty_TextField.setName("kdtGoEntrys_qty_TextField");
        kdtGoEntrys_qty_TextField.setVisible(true);
        kdtGoEntrys_qty_TextField.setEditable(true);
        kdtGoEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtGoEntrys_qty_TextField.setDataType(1);
        	kdtGoEntrys_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtGoEntrys_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtGoEntrys_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtGoEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtGoEntrys_qty_TextField);
        this.kdtGoEntrys.getColumn("qty").setEditor(kdtGoEntrys_qty_CellEditor);
        final KDBizPromptBox kdtGoEntrys_serviceItems_PromptBox = new KDBizPromptBox();
        kdtGoEntrys_serviceItems_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.ServiceItemsQuery");
        kdtGoEntrys_serviceItems_PromptBox.setVisible(true);
        kdtGoEntrys_serviceItems_PromptBox.setEditable(true);
        kdtGoEntrys_serviceItems_PromptBox.setDisplayFormat("$number$");
        kdtGoEntrys_serviceItems_PromptBox.setEditFormat("$number$");
        kdtGoEntrys_serviceItems_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtGoEntrys_serviceItems_CellEditor = new KDTDefaultCellEditor(kdtGoEntrys_serviceItems_PromptBox);
        this.kdtGoEntrys.getColumn("serviceItems").setEditor(kdtGoEntrys_serviceItems_CellEditor);
        ObjectValueRender kdtGoEntrys_serviceItems_OVR = new ObjectValueRender();
        kdtGoEntrys_serviceItems_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtGoEntrys.getColumn("serviceItems").setRenderer(kdtGoEntrys_serviceItems_OVR);
        // prmtstorageOrg		
        this.prmtstorageOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrg.setEditable(true);		
        this.prmtstorageOrg.setDisplayFormat("$name$");		
        this.prmtstorageOrg.setEditFormat("$number$");		
        this.prmtstorageOrg.setCommitFormat("$number$");		
        this.prmtstorageOrg.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // txthealthQty		
        this.txthealthQty.setHorizontalAlignment(2);		
        this.txthealthQty.setDataType(0);		
        this.txthealthQty.setSupportedEmpty(true);		
        this.txthealthQty.setRequired(false);		
        this.txthealthQty.setEnabled(false);
        // txtdeathQty		
        this.txtdeathQty.setHorizontalAlignment(2);		
        this.txtdeathQty.setDataType(0);		
        this.txtdeathQty.setSupportedEmpty(true);		
        this.txtdeathQty.setRequired(false);		
        this.txtdeathQty.setEnabled(false);
        this.txtdeathQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txtdeathQty_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // txtunhatchedEggQty		
        this.txtunhatchedEggQty.setHorizontalAlignment(2);		
        this.txtunhatchedEggQty.setDataType(0);		
        this.txtunhatchedEggQty.setSupportedEmpty(true);		
        this.txtunhatchedEggQty.setRequired(false);		
        this.txtunhatchedEggQty.setEnabled(false);
        this.txtunhatchedEggQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txtunhatchedEggQty_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // prmtselectBabyPerson		
        this.prmtselectBabyPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtselectBabyPerson.setEditable(true);		
        this.prmtselectBabyPerson.setDisplayFormat("$name$");		
        this.prmtselectBabyPerson.setEditFormat("$number$");		
        this.prmtselectBabyPerson.setCommitFormat("$number$");		
        this.prmtselectBabyPerson.setRequired(false);
        // prmtimmunePerson		
        this.prmtimmunePerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtimmunePerson.setEditable(true);		
        this.prmtimmunePerson.setDisplayFormat("$name$");		
        this.prmtimmunePerson.setEditFormat("$number$");		
        this.prmtimmunePerson.setCommitFormat("$number$");		
        this.prmtimmunePerson.setRequired(false);
        // prmthatchFactory		
        this.prmthatchFactory.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchBaseDataQuery");		
        this.prmthatchFactory.setEditable(true);		
        this.prmthatchFactory.setDisplayFormat("$name$");		
        this.prmthatchFactory.setEditFormat("$number$");		
        this.prmthatchFactory.setCommitFormat("$number$");		
        this.prmthatchFactory.setRequired(false);		
        this.prmthatchFactory.setEnabled(false);
        		prmthatchFactory.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchBaseDataListUI prmthatchFactory_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmthatchFactory_F7ListUI == null) {
					try {
						prmthatchFactory_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchBaseDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmthatchFactory_F7ListUI));
					prmthatchFactory_F7ListUI.setF7Use(true,ctx);
					prmthatchFactory.setSelector(prmthatchFactory_F7ListUI);
				}
			}
		});
					
        // prmthatchArea		
        this.prmthatchArea.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchAreaQuery");		
        this.prmthatchArea.setEditable(true);		
        this.prmthatchArea.setDisplayFormat("$name$");		
        this.prmthatchArea.setEditFormat("$number$");		
        this.prmthatchArea.setCommitFormat("$number$");		
        this.prmthatchArea.setRequired(false);		
        this.prmthatchArea.setVisible(false);		
        this.prmthatchArea.setEnabled(false);
        // prmtadminOrg		
        this.prmtadminOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtadminOrg.setVisible(false);		
        this.prmtadminOrg.setEditable(true);		
        this.prmtadminOrg.setDisplayFormat("$name$");		
        this.prmtadminOrg.setEditFormat("$number$");		
        this.prmtadminOrg.setCommitFormat("$number$");		
        this.prmtadminOrg.setRequired(false);
        // txthealthQtyB		
        this.txthealthQtyB.setHorizontalAlignment(2);		
        this.txthealthQtyB.setDataType(0);		
        this.txthealthQtyB.setSupportedEmpty(true);		
        this.txthealthQtyB.setRequired(false);		
        this.txthealthQtyB.setVisible(false);		
        this.txthealthQtyB.setEnabled(false);
        // txtnoHealthQty		
        this.txtnoHealthQty.setHorizontalAlignment(2);		
        this.txtnoHealthQty.setDataType(0);		
        this.txtnoHealthQty.setSupportedEmpty(true);		
        this.txtnoHealthQty.setRequired(false);		
        this.txtnoHealthQty.setVisible(false);		
        this.txtnoHealthQty.setEnabled(false);
        // txthealthQtyA1		
        this.txthealthQtyA1.setHorizontalAlignment(2);		
        this.txthealthQtyA1.setDataType(0);		
        this.txthealthQtyA1.setSupportedEmpty(true);		
        this.txthealthQtyA1.setRequired(false);		
        this.txthealthQtyA1.setEnabled(false);		
        this.txthealthQtyA1.setVisible(false);
        // txthealthQtyA2		
        this.txthealthQtyA2.setHorizontalAlignment(2);		
        this.txthealthQtyA2.setDataType(0);		
        this.txthealthQtyA2.setSupportedEmpty(true);		
        this.txthealthQtyA2.setRequired(false);		
        this.txthealthQtyA2.setEnabled(false);		
        this.txthealthQtyA2.setVisible(false);
        // txthealthQtyA3		
        this.txthealthQtyA3.setHorizontalAlignment(2);		
        this.txthealthQtyA3.setDataType(0);		
        this.txthealthQtyA3.setSupportedEmpty(true);		
        this.txthealthQtyA3.setRequired(false);		
        this.txthealthQtyA3.setVisible(false);		
        this.txthealthQtyA3.setEnabled(false);
        // eggType		
        this.eggType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggType").toArray());		
        this.eggType.setRequired(false);		
        this.eggType.setEnabled(false);
        // pkhatchDate		
        this.pkhatchDate.setRequired(false);		
        this.pkhatchDate.setEnabled(false);
        // radioHorizon		
        this.radioHorizon.setText(resHelper.getString("radioHorizon.text"));
        // radioVertical		
        this.radioVertical.setText(resHelper.getString("radioVertical.text"));
        // radioOrigin		
        this.radioOrigin.setText(resHelper.getString("radioOrigin.text"));
        // contlossQty		
        this.contlossQty.setBoundLabelText(resHelper.getString("contlossQty.boundLabelText"));		
        this.contlossQty.setBoundLabelLength(100);		
        this.contlossQty.setBoundLabelUnderline(true);		
        this.contlossQty.setVisible(false);
        // kDPanel4		
        this.kDPanel4.setVisible(false);
        // txtlossQty		
        this.txtlossQty.setHorizontalAlignment(2);		
        this.txtlossQty.setDataType(0);		
        this.txtlossQty.setSupportedEmpty(true);		
        this.txtlossQty.setRequired(false);		
        this.txtlossQty.setEnabled(false);		
        this.txtlossQty.setVisible(false);
        this.txtlossQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txtlossQty_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kdtSourceEntrys
		String kdtSourceEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"outAreaP\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"genderType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"qcEggsType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"qcEggType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"eggSource\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"healthQtyA1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"littleChickQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"healthQtyA2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"healthQtyA3\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"healthQtyB\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"GermQty2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"deadGermQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"healthQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"outQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"hatchQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"trayingHealthEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"maoQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"kuiQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"allOutQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{outAreaP}</t:Cell><t:Cell>$Resource{genderType}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{qcEggsType}</t:Cell><t:Cell>$Resource{qcEggType}</t:Cell><t:Cell>$Resource{eggSource}</t:Cell><t:Cell>$Resource{healthQtyA1}</t:Cell><t:Cell>$Resource{littleChickQty}</t:Cell><t:Cell>$Resource{healthQtyA2}</t:Cell><t:Cell>$Resource{healthQtyA3}</t:Cell><t:Cell>$Resource{healthQtyB}</t:Cell><t:Cell>$Resource{GermQty2}</t:Cell><t:Cell>$Resource{deadGermQty}</t:Cell><t:Cell>$Resource{healthQty}</t:Cell><t:Cell>$Resource{outQty}</t:Cell><t:Cell>$Resource{hatchQty}</t:Cell><t:Cell>$Resource{trayingHealthEggQty}</t:Cell><t:Cell>$Resource{maoQty}</t:Cell><t:Cell>$Resource{kuiQty}</t:Cell><t:Cell>$Resource{allOutQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtSourceEntrys.setFormatXml(resHelper.translateString("kdtSourceEntrys",kdtSourceEntrysStrXML));		
        this.kdtSourceEntrys.setVisible(false);
        kdtSourceEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtSourceEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtSourceEntrys.putBindContents("editData",new String[] {"seq","outAreaP","genderType","supplier","qcEggsType","qcEggType","eggSource","healthQtyA1","littleChickQty","healthQtyA2","healthQtyA3","healthQtyB","GermQty2","deadGermQty","healthQty","outQty","hatchQty","trayingHealthEggQty","maoQty","kuiQty","allOutQty"});


        this.kdtSourceEntrys.checkParsed();
        KDFormattedTextField kdtSourceEntrys_seq_TextField = new KDFormattedTextField();
        kdtSourceEntrys_seq_TextField.setName("kdtSourceEntrys_seq_TextField");
        kdtSourceEntrys_seq_TextField.setVisible(true);
        kdtSourceEntrys_seq_TextField.setEditable(true);
        kdtSourceEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtSourceEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSourceEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_seq_TextField);
        this.kdtSourceEntrys.getColumn("seq").setEditor(kdtSourceEntrys_seq_CellEditor);
        final KDBizPromptBox kdtSourceEntrys_outAreaP_PromptBox = new KDBizPromptBox();
        kdtSourceEntrys_outAreaP_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
        kdtSourceEntrys_outAreaP_PromptBox.setVisible(true);
        kdtSourceEntrys_outAreaP_PromptBox.setEditable(true);
        kdtSourceEntrys_outAreaP_PromptBox.setDisplayFormat("$number$");
        kdtSourceEntrys_outAreaP_PromptBox.setEditFormat("$number$");
        kdtSourceEntrys_outAreaP_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSourceEntrys_outAreaP_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_outAreaP_PromptBox);
        this.kdtSourceEntrys.getColumn("outAreaP").setEditor(kdtSourceEntrys_outAreaP_CellEditor);
        ObjectValueRender kdtSourceEntrys_outAreaP_OVR = new ObjectValueRender();
        kdtSourceEntrys_outAreaP_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtSourceEntrys.getColumn("outAreaP").setRenderer(kdtSourceEntrys_outAreaP_OVR);
        KDComboBox kdtSourceEntrys_genderType_ComboBox = new KDComboBox();
        kdtSourceEntrys_genderType_ComboBox.setName("kdtSourceEntrys_genderType_ComboBox");
        kdtSourceEntrys_genderType_ComboBox.setVisible(true);
        kdtSourceEntrys_genderType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());
        KDTDefaultCellEditor kdtSourceEntrys_genderType_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_genderType_ComboBox);
        this.kdtSourceEntrys.getColumn("genderType").setEditor(kdtSourceEntrys_genderType_CellEditor);
        final KDBizPromptBox kdtSourceEntrys_supplier_PromptBox = new KDBizPromptBox();
        kdtSourceEntrys_supplier_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierDefaultQuery");
        kdtSourceEntrys_supplier_PromptBox.setVisible(true);
        kdtSourceEntrys_supplier_PromptBox.setEditable(true);
        kdtSourceEntrys_supplier_PromptBox.setDisplayFormat("$number$");
        kdtSourceEntrys_supplier_PromptBox.setEditFormat("$number$");
        kdtSourceEntrys_supplier_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSourceEntrys_supplier_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_supplier_PromptBox);
        this.kdtSourceEntrys.getColumn("supplier").setEditor(kdtSourceEntrys_supplier_CellEditor);
        ObjectValueRender kdtSourceEntrys_supplier_OVR = new ObjectValueRender();
        kdtSourceEntrys_supplier_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtSourceEntrys.getColumn("supplier").setRenderer(kdtSourceEntrys_supplier_OVR);
        final KDBizPromptBox kdtSourceEntrys_qcEggsType_PromptBox = new KDBizPromptBox();
        kdtSourceEntrys_qcEggsType_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.QcEggTypeQuery");
        kdtSourceEntrys_qcEggsType_PromptBox.setVisible(true);
        kdtSourceEntrys_qcEggsType_PromptBox.setEditable(true);
        kdtSourceEntrys_qcEggsType_PromptBox.setDisplayFormat("$number$");
        kdtSourceEntrys_qcEggsType_PromptBox.setEditFormat("$number$");
        kdtSourceEntrys_qcEggsType_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSourceEntrys_qcEggsType_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_qcEggsType_PromptBox);
        this.kdtSourceEntrys.getColumn("qcEggsType").setEditor(kdtSourceEntrys_qcEggsType_CellEditor);
        ObjectValueRender kdtSourceEntrys_qcEggsType_OVR = new ObjectValueRender();
        kdtSourceEntrys_qcEggsType_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtSourceEntrys.getColumn("qcEggsType").setRenderer(kdtSourceEntrys_qcEggsType_OVR);
        KDComboBox kdtSourceEntrys_qcEggType_ComboBox = new KDComboBox();
        kdtSourceEntrys_qcEggType_ComboBox.setName("kdtSourceEntrys_qcEggType_ComboBox");
        kdtSourceEntrys_qcEggType_ComboBox.setVisible(true);
        kdtSourceEntrys_qcEggType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.QcEggTypeEnum").toArray());
        KDTDefaultCellEditor kdtSourceEntrys_qcEggType_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_qcEggType_ComboBox);
        this.kdtSourceEntrys.getColumn("qcEggType").setEditor(kdtSourceEntrys_qcEggType_CellEditor);
        KDComboBox kdtSourceEntrys_eggSource_ComboBox = new KDComboBox();
        kdtSourceEntrys_eggSource_ComboBox.setName("kdtSourceEntrys_eggSource_ComboBox");
        kdtSourceEntrys_eggSource_ComboBox.setVisible(true);
        kdtSourceEntrys_eggSource_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggSourceType").toArray());
        KDTDefaultCellEditor kdtSourceEntrys_eggSource_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_eggSource_ComboBox);
        this.kdtSourceEntrys.getColumn("eggSource").setEditor(kdtSourceEntrys_eggSource_CellEditor);
        KDFormattedTextField kdtSourceEntrys_healthQtyA1_TextField = new KDFormattedTextField();
        kdtSourceEntrys_healthQtyA1_TextField.setName("kdtSourceEntrys_healthQtyA1_TextField");
        kdtSourceEntrys_healthQtyA1_TextField.setVisible(true);
        kdtSourceEntrys_healthQtyA1_TextField.setEditable(true);
        kdtSourceEntrys_healthQtyA1_TextField.setHorizontalAlignment(2);
        kdtSourceEntrys_healthQtyA1_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSourceEntrys_healthQtyA1_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_healthQtyA1_TextField);
        this.kdtSourceEntrys.getColumn("healthQtyA1").setEditor(kdtSourceEntrys_healthQtyA1_CellEditor);
        KDFormattedTextField kdtSourceEntrys_littleChickQty_TextField = new KDFormattedTextField();
        kdtSourceEntrys_littleChickQty_TextField.setName("kdtSourceEntrys_littleChickQty_TextField");
        kdtSourceEntrys_littleChickQty_TextField.setVisible(true);
        kdtSourceEntrys_littleChickQty_TextField.setEditable(true);
        kdtSourceEntrys_littleChickQty_TextField.setHorizontalAlignment(2);
        kdtSourceEntrys_littleChickQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSourceEntrys_littleChickQty_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_littleChickQty_TextField);
        this.kdtSourceEntrys.getColumn("littleChickQty").setEditor(kdtSourceEntrys_littleChickQty_CellEditor);
        KDFormattedTextField kdtSourceEntrys_healthQtyA2_TextField = new KDFormattedTextField();
        kdtSourceEntrys_healthQtyA2_TextField.setName("kdtSourceEntrys_healthQtyA2_TextField");
        kdtSourceEntrys_healthQtyA2_TextField.setVisible(true);
        kdtSourceEntrys_healthQtyA2_TextField.setEditable(true);
        kdtSourceEntrys_healthQtyA2_TextField.setHorizontalAlignment(2);
        kdtSourceEntrys_healthQtyA2_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSourceEntrys_healthQtyA2_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_healthQtyA2_TextField);
        this.kdtSourceEntrys.getColumn("healthQtyA2").setEditor(kdtSourceEntrys_healthQtyA2_CellEditor);
        KDFormattedTextField kdtSourceEntrys_healthQtyA3_TextField = new KDFormattedTextField();
        kdtSourceEntrys_healthQtyA3_TextField.setName("kdtSourceEntrys_healthQtyA3_TextField");
        kdtSourceEntrys_healthQtyA3_TextField.setVisible(true);
        kdtSourceEntrys_healthQtyA3_TextField.setEditable(true);
        kdtSourceEntrys_healthQtyA3_TextField.setHorizontalAlignment(2);
        kdtSourceEntrys_healthQtyA3_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSourceEntrys_healthQtyA3_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_healthQtyA3_TextField);
        this.kdtSourceEntrys.getColumn("healthQtyA3").setEditor(kdtSourceEntrys_healthQtyA3_CellEditor);
        KDFormattedTextField kdtSourceEntrys_healthQtyB_TextField = new KDFormattedTextField();
        kdtSourceEntrys_healthQtyB_TextField.setName("kdtSourceEntrys_healthQtyB_TextField");
        kdtSourceEntrys_healthQtyB_TextField.setVisible(true);
        kdtSourceEntrys_healthQtyB_TextField.setEditable(true);
        kdtSourceEntrys_healthQtyB_TextField.setHorizontalAlignment(2);
        kdtSourceEntrys_healthQtyB_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSourceEntrys_healthQtyB_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_healthQtyB_TextField);
        this.kdtSourceEntrys.getColumn("healthQtyB").setEditor(kdtSourceEntrys_healthQtyB_CellEditor);
        KDFormattedTextField kdtSourceEntrys_GermQty2_TextField = new KDFormattedTextField();
        kdtSourceEntrys_GermQty2_TextField.setName("kdtSourceEntrys_GermQty2_TextField");
        kdtSourceEntrys_GermQty2_TextField.setVisible(true);
        kdtSourceEntrys_GermQty2_TextField.setEditable(true);
        kdtSourceEntrys_GermQty2_TextField.setHorizontalAlignment(2);
        kdtSourceEntrys_GermQty2_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSourceEntrys_GermQty2_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_GermQty2_TextField);
        this.kdtSourceEntrys.getColumn("GermQty2").setEditor(kdtSourceEntrys_GermQty2_CellEditor);
        KDFormattedTextField kdtSourceEntrys_deadGermQty_TextField = new KDFormattedTextField();
        kdtSourceEntrys_deadGermQty_TextField.setName("kdtSourceEntrys_deadGermQty_TextField");
        kdtSourceEntrys_deadGermQty_TextField.setVisible(true);
        kdtSourceEntrys_deadGermQty_TextField.setEditable(true);
        kdtSourceEntrys_deadGermQty_TextField.setHorizontalAlignment(2);
        kdtSourceEntrys_deadGermQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSourceEntrys_deadGermQty_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_deadGermQty_TextField);
        this.kdtSourceEntrys.getColumn("deadGermQty").setEditor(kdtSourceEntrys_deadGermQty_CellEditor);
        KDFormattedTextField kdtSourceEntrys_healthQty_TextField = new KDFormattedTextField();
        kdtSourceEntrys_healthQty_TextField.setName("kdtSourceEntrys_healthQty_TextField");
        kdtSourceEntrys_healthQty_TextField.setVisible(true);
        kdtSourceEntrys_healthQty_TextField.setEditable(true);
        kdtSourceEntrys_healthQty_TextField.setHorizontalAlignment(2);
        kdtSourceEntrys_healthQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSourceEntrys_healthQty_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_healthQty_TextField);
        this.kdtSourceEntrys.getColumn("healthQty").setEditor(kdtSourceEntrys_healthQty_CellEditor);
        KDFormattedTextField kdtSourceEntrys_outQty_TextField = new KDFormattedTextField();
        kdtSourceEntrys_outQty_TextField.setName("kdtSourceEntrys_outQty_TextField");
        kdtSourceEntrys_outQty_TextField.setVisible(true);
        kdtSourceEntrys_outQty_TextField.setEditable(true);
        kdtSourceEntrys_outQty_TextField.setHorizontalAlignment(2);
        kdtSourceEntrys_outQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSourceEntrys_outQty_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_outQty_TextField);
        this.kdtSourceEntrys.getColumn("outQty").setEditor(kdtSourceEntrys_outQty_CellEditor);
        KDFormattedTextField kdtSourceEntrys_hatchQty_TextField = new KDFormattedTextField();
        kdtSourceEntrys_hatchQty_TextField.setName("kdtSourceEntrys_hatchQty_TextField");
        kdtSourceEntrys_hatchQty_TextField.setVisible(true);
        kdtSourceEntrys_hatchQty_TextField.setEditable(true);
        kdtSourceEntrys_hatchQty_TextField.setHorizontalAlignment(2);
        kdtSourceEntrys_hatchQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSourceEntrys_hatchQty_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_hatchQty_TextField);
        this.kdtSourceEntrys.getColumn("hatchQty").setEditor(kdtSourceEntrys_hatchQty_CellEditor);
        KDFormattedTextField kdtSourceEntrys_trayingHealthEggQty_TextField = new KDFormattedTextField();
        kdtSourceEntrys_trayingHealthEggQty_TextField.setName("kdtSourceEntrys_trayingHealthEggQty_TextField");
        kdtSourceEntrys_trayingHealthEggQty_TextField.setVisible(true);
        kdtSourceEntrys_trayingHealthEggQty_TextField.setEditable(true);
        kdtSourceEntrys_trayingHealthEggQty_TextField.setHorizontalAlignment(2);
        kdtSourceEntrys_trayingHealthEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSourceEntrys_trayingHealthEggQty_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_trayingHealthEggQty_TextField);
        this.kdtSourceEntrys.getColumn("trayingHealthEggQty").setEditor(kdtSourceEntrys_trayingHealthEggQty_CellEditor);
        KDFormattedTextField kdtSourceEntrys_maoQty_TextField = new KDFormattedTextField();
        kdtSourceEntrys_maoQty_TextField.setName("kdtSourceEntrys_maoQty_TextField");
        kdtSourceEntrys_maoQty_TextField.setVisible(true);
        kdtSourceEntrys_maoQty_TextField.setEditable(true);
        kdtSourceEntrys_maoQty_TextField.setHorizontalAlignment(2);
        kdtSourceEntrys_maoQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSourceEntrys_maoQty_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_maoQty_TextField);
        this.kdtSourceEntrys.getColumn("maoQty").setEditor(kdtSourceEntrys_maoQty_CellEditor);
        KDFormattedTextField kdtSourceEntrys_kuiQty_TextField = new KDFormattedTextField();
        kdtSourceEntrys_kuiQty_TextField.setName("kdtSourceEntrys_kuiQty_TextField");
        kdtSourceEntrys_kuiQty_TextField.setVisible(true);
        kdtSourceEntrys_kuiQty_TextField.setEditable(true);
        kdtSourceEntrys_kuiQty_TextField.setHorizontalAlignment(2);
        kdtSourceEntrys_kuiQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSourceEntrys_kuiQty_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_kuiQty_TextField);
        this.kdtSourceEntrys.getColumn("kuiQty").setEditor(kdtSourceEntrys_kuiQty_CellEditor);
        KDFormattedTextField kdtSourceEntrys_allOutQty_TextField = new KDFormattedTextField();
        kdtSourceEntrys_allOutQty_TextField.setName("kdtSourceEntrys_allOutQty_TextField");
        kdtSourceEntrys_allOutQty_TextField.setVisible(true);
        kdtSourceEntrys_allOutQty_TextField.setEditable(true);
        kdtSourceEntrys_allOutQty_TextField.setHorizontalAlignment(2);
        kdtSourceEntrys_allOutQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSourceEntrys_allOutQty_CellEditor = new KDTDefaultCellEditor(kdtSourceEntrys_allOutQty_TextField);
        this.kdtSourceEntrys.getColumn("allOutQty").setEditor(kdtSourceEntrys_allOutQty_CellEditor);
        // btnViewUp		
        this.btnViewUp.setText(resHelper.getString("btnViewUp.text"));		
        this.btnViewUp.setVisible(false);
        // cBoxFarmersTree		
        this.cBoxFarmersTree.setVisible(false);
        // cBoxQcEggType		
        this.cBoxQcEggType.setVisible(false);
        // btnGetMaoQty		
        this.btnGetMaoQty.setText(resHelper.getString("btnGetMaoQty.text"));		
        this.btnGetMaoQty.setVisible(false);
        // pkcandlingDate		
        this.pkcandlingDate.setRequired(false);		
        this.pkcandlingDate.setEnabled(false);
        // pktrayingDate		
        this.pktrayingDate.setRequired(false);		
        this.pktrayingDate.setEnabled(false);
        // genderTy		
        this.genderTy.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());		
        this.genderTy.setRequired(false);		
        this.genderTy.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,pkauditTime,baseStatus,txttransDescription,prmtstorageOrg,prmtcompany,txthealthQty,txtdeathQty,txtlossQty,txtunhatchedEggQty,prmtselectBabyPerson,prmtimmunePerson,prmthatchFactory,prmthatchArea,prmtadminOrg,txthealthQtyB,txtnoHealthQty,txthealthQtyA1,txthealthQtyA2,txthealthQtyA3,eggType,pkhatchDate,chkisAllOut,pkcandlingDate,pktrayingDate,genderTy,kdtEntrys,kdtImmuneEntrys,kdtSaleEntry,kdtSourceEntrys,kdtMatUserEntry,kdtGoEntrys,chkisManuIn,chkisOtherIn,chkisGiftOtherIn,chkisMaterOut}));
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
        contCreator.setBounds(new Rectangle(13, 558, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(13, 558, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(13, 587, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(13, 587, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(370, 558, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(370, 558, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(370, 587, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(370, 587, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(13, 7, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(13, 7, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(365, 7, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(365, 7, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(13, -118, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(13, -118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(727, 558, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(727, 558, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(727, 587, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(727, 587, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(719, 30, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(719, 30, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttransDescription.setBounds(new Rectangle(13, 164, 978, 20));
        this.add(conttransDescription, new KDLayout.Constraints(13, 164, 978, 20, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(11, 250, 986, 302));
        this.add(kDTabbedPane1, new KDLayout.Constraints(11, 250, 986, 302, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contstorageOrg.setBounds(new Rectangle(0, -100, 270, 19));
        this.add(contstorageOrg, new KDLayout.Constraints(0, -100, 270, 19, 0));
        contcompany.setBounds(new Rectangle(0, -100, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(0, -100, 270, 19, 0));
        conthealthQty.setBounds(new Rectangle(13, 56, 270, 19));
        this.add(conthealthQty, new KDLayout.Constraints(13, 56, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdeathQty.setBounds(new Rectangle(366, 30, 270, 19));
        this.add(contdeathQty, new KDLayout.Constraints(366, 30, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contunhatchedEggQty.setBounds(new Rectangle(14, 30, 270, 19));
        this.add(contunhatchedEggQty, new KDLayout.Constraints(14, 30, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(11, 158, 1000, 10));
        this.add(kDSeparator8, new KDLayout.Constraints(11, 158, 1000, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contselectBabyPerson.setBounds(new Rectangle(719, 56, 270, 19));
        this.add(contselectBabyPerson, new KDLayout.Constraints(719, 56, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contimmunePerson.setBounds(new Rectangle(719, 81, 270, 19));
        this.add(contimmunePerson, new KDLayout.Constraints(719, 81, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conthatchFactory.setBounds(new Rectangle(719, 7, 270, 19));
        this.add(conthatchFactory, new KDLayout.Constraints(719, 7, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conthatchArea.setBounds(new Rectangle(682, 166, 270, 19));
        this.add(conthatchArea, new KDLayout.Constraints(682, 166, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contadminOrg.setBounds(new Rectangle(996, 138, 270, 19));
        this.add(contadminOrg, new KDLayout.Constraints(996, 138, 270, 19, 0));
        conthealthQtyB.setBounds(new Rectangle(837, 145, 270, 19));
        this.add(conthealthQtyB, new KDLayout.Constraints(837, 145, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contnoHealthQty.setBounds(new Rectangle(807, 164, 270, 19));
        this.add(contnoHealthQty, new KDLayout.Constraints(807, 164, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conthealthQtyA1.setBounds(new Rectangle(876, 156, 270, 19));
        this.add(conthealthQtyA1, new KDLayout.Constraints(876, 156, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthealthQtyA2.setBounds(new Rectangle(689, 151, 270, 19));
        this.add(conthealthQtyA2, new KDLayout.Constraints(689, 151, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthealthQtyA3.setBounds(new Rectangle(700, 142, 270, 19));
        this.add(conthealthQtyA3, new KDLayout.Constraints(700, 142, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conteggType.setBounds(new Rectangle(13, 81, 270, 19));
        this.add(conteggType, new KDLayout.Constraints(13, 81, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthatchDate.setBounds(new Rectangle(13, 106, 270, 19));
        this.add(conthatchDate, new KDLayout.Constraints(13, 106, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisAllOut.setBounds(new Rectangle(854, 143, 270, 19));
        this.add(chkisAllOut, new KDLayout.Constraints(854, 143, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel5.setBounds(new Rectangle(12, 197, 985, 45));
        this.add(kDPanel5, new KDLayout.Constraints(12, 197, 985, 45, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcandlingDate.setBounds(new Rectangle(367, 81, 270, 19));
        this.add(contcandlingDate, new KDLayout.Constraints(367, 81, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttrayingDate.setBounds(new Rectangle(368, 106, 270, 19));
        this.add(conttrayingDate, new KDLayout.Constraints(368, 106, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contgenderTy.setBounds(new Rectangle(367, 56, 270, 19));
        this.add(contgenderTy, new KDLayout.Constraints(367, 56, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        cboxFarmersTree.setBounds(new Rectangle(954, 178, 170, 19));
        this.add(cboxFarmersTree, new KDLayout.Constraints(954, 178, 170, 19, 0));
        cboxQcEggType.setBounds(new Rectangle(892, 178, 170, 19));
        this.add(cboxQcEggType, new KDLayout.Constraints(892, 178, 170, 19, 0));
        chkisManuIn.setBounds(new Rectangle(837, 107, 117, 19));
        this.add(chkisManuIn, new KDLayout.Constraints(837, 107, 117, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisOtherIn.setBounds(new Rectangle(13, 131, 134, 19));
        this.add(chkisOtherIn, new KDLayout.Constraints(13, 131, 134, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisGiftOtherIn.setBounds(new Rectangle(159, 131, 122, 19));
        this.add(chkisGiftOtherIn, new KDLayout.Constraints(159, 131, 122, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisMaterOut.setBounds(new Rectangle(718, 107, 102, 19));
        this.add(chkisMaterOut, new KDLayout.Constraints(718, 107, 102, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //conttransDescription
        conttransDescription.setBoundEditor(scrollPanetransDescription);
        //scrollPanetransDescription
        scrollPanetransDescription.getViewport().add(txttransDescription, null);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane1.add(kDPanel6, resHelper.getString("kDPanel6.constraints"));
        kDTabbedPane1.add(kDPanel7, resHelper.getString("kDPanel7.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 985, 269));        kdtEntrys.setBounds(new Rectangle(0, 5, 982, 253));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.hatch.BHatchBabyBillEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(0, 5, 982, 253, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("eggSourceType",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 985, 269));        kdtImmuneEntrys.setBounds(new Rectangle(0, 1, 981, 223));
        kdtImmuneEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtImmuneEntrys,new com.kingdee.eas.farm.hatch.BHatchBabyBillImmuneEntryInfo(),null,false);
        kDPanel2.add(kdtImmuneEntrys_detailPanel, new KDLayout.Constraints(0, 1, 981, 223, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 985, 269));        kdtSaleEntry.setBounds(new Rectangle(4, 5, 974, 219));
        kdtSaleEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtSaleEntry,new com.kingdee.eas.farm.hatch.BHatchBabyBillSaleEntryInfo(),null,false);
        kDPanel3.add(kdtSaleEntry_detailPanel, new KDLayout.Constraints(4, 5, 974, 219, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel6
        kDPanel6.setLayout(null);        kdtMatUserEntry.setBounds(new Rectangle(0, -2, 972, 227));
        kdtMatUserEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtMatUserEntry,new com.kingdee.eas.farm.hatch.BHatchBabyBillMatUserEntryInfo(),null,false);
        kDPanel6.add(kdtMatUserEntry_detailPanel, null);
        //kDPanel7
        kDPanel7.setLayout(new KDLayout());
        kDPanel7.putClientProperty("OriginalBounds", new Rectangle(0, 0, 985, 269));        kdtGoEntrys.setBounds(new Rectangle(2, 1, 980, 224));
        kdtGoEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtGoEntrys,new com.kingdee.eas.farm.hatch.BHatchBabyBillGoEntryInfo(),null,false);
        kDPanel7.add(kdtGoEntrys_detailPanel, new KDLayout.Constraints(2, 1, 980, 224, 0));
		kdtGoEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("goType","1");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //contstorageOrg
        contstorageOrg.setBoundEditor(prmtstorageOrg);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //conthealthQty
        conthealthQty.setBoundEditor(txthealthQty);
        //contdeathQty
        contdeathQty.setBoundEditor(txtdeathQty);
        //contunhatchedEggQty
        contunhatchedEggQty.setBoundEditor(txtunhatchedEggQty);
        //contselectBabyPerson
        contselectBabyPerson.setBoundEditor(prmtselectBabyPerson);
        //contimmunePerson
        contimmunePerson.setBoundEditor(prmtimmunePerson);
        //conthatchFactory
        conthatchFactory.setBoundEditor(prmthatchFactory);
        //conthatchArea
        conthatchArea.setBoundEditor(prmthatchArea);
        //contadminOrg
        contadminOrg.setBoundEditor(prmtadminOrg);
        //conthealthQtyB
        conthealthQtyB.setBoundEditor(txthealthQtyB);
        //contnoHealthQty
        contnoHealthQty.setBoundEditor(txtnoHealthQty);
        //conthealthQtyA1
        conthealthQtyA1.setBoundEditor(txthealthQtyA1);
        //conthealthQtyA2
        conthealthQtyA2.setBoundEditor(txthealthQtyA2);
        //conthealthQtyA3
        conthealthQtyA3.setBoundEditor(txthealthQtyA3);
        //conteggType
        conteggType.setBoundEditor(eggType);
        //conthatchDate
        conthatchDate.setBoundEditor(pkhatchDate);
        //kDPanel5
        kDPanel5.setLayout(new KDLayout());
        kDPanel5.putClientProperty("OriginalBounds", new Rectangle(12, 197, 985, 45));        radioHorizon.setBounds(new Rectangle(28, 15, 140, 19));
        kDPanel5.add(radioHorizon, new KDLayout.Constraints(28, 15, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        radioVertical.setBounds(new Rectangle(258, 15, 140, 19));
        kDPanel5.add(radioVertical, new KDLayout.Constraints(258, 15, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        radioOrigin.setBounds(new Rectangle(484, 15, 140, 19));
        kDPanel5.add(radioOrigin, new KDLayout.Constraints(484, 15, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contlossQty.setBounds(new Rectangle(870, 1, 270, 19));
        kDPanel5.add(contlossQty, new KDLayout.Constraints(870, 1, 270, 19, 0));
        kDPanel4.setBounds(new Rectangle(488, 35, 982, 271));
        kDPanel5.add(kDPanel4, new KDLayout.Constraints(488, 35, 982, 271, 0));
        //contlossQty
        contlossQty.setBoundEditor(txtlossQty);
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(488, 35, 982, 271));        kdtSourceEntrys.setBounds(new Rectangle(1, 31, 974, 187));
        kdtSourceEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtSourceEntrys,new com.kingdee.eas.farm.hatch.BHatchBabyBillSourceEntryInfo(),null,false);
        kDPanel4.add(kdtSourceEntrys_detailPanel, new KDLayout.Constraints(1, 31, 974, 187, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtSourceEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("eggSource",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        btnViewUp.setBounds(new Rectangle(859, 6, 111, 21));
        kDPanel4.add(btnViewUp, new KDLayout.Constraints(859, 6, 111, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        cBoxFarmersTree.setBounds(new Rectangle(320, 7, 170, 19));
        kDPanel4.add(cBoxFarmersTree, new KDLayout.Constraints(320, 7, 170, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        cBoxQcEggType.setBounds(new Rectangle(516, 7, 170, 19));
        kDPanel4.add(cBoxQcEggType, new KDLayout.Constraints(516, 7, 170, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnGetMaoQty.setBounds(new Rectangle(730, 6, 111, 21));
        kDPanel4.add(btnGetMaoQty, new KDLayout.Constraints(730, 6, 111, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contcandlingDate
        contcandlingDate.setBoundEditor(pkcandlingDate);
        //conttrayingDate
        conttrayingDate.setBoundEditor(pktrayingDate);
        //contgenderTy
        contgenderTy.setBoundEditor(genderTy);

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
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(menuItemDelPCVoucher);
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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
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
		dataBinder.registerBinding("isAllOut", boolean.class, this.chkisAllOut, "selected");
		dataBinder.registerBinding("isManuIn", boolean.class, this.chkisManuIn, "selected");
		dataBinder.registerBinding("isOtherIn", boolean.class, this.chkisOtherIn, "selected");
		dataBinder.registerBinding("isGiftOtherIn", boolean.class, this.chkisGiftOtherIn, "selected");
		dataBinder.registerBinding("isMaterOut", boolean.class, this.chkisMaterOut, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("transDescription", String.class, this.txttransDescription, "text");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.hatch.BHatchBabyBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.hatchingBox", java.lang.Object.class, this.kdtEntrys, "hatchingBox.text");
		dataBinder.registerBinding("entrys.description", String.class, this.kdtEntrys, "description.text");
		dataBinder.registerBinding("entrys.incubator", java.lang.Object.class, this.kdtEntrys, "incubator.text");
		dataBinder.registerBinding("entrys.hatchHouse", java.lang.Object.class, this.kdtEntrys, "hatchHouse.text");
		dataBinder.registerBinding("entrys.hatchQty", int.class, this.kdtEntrys, "hatchQty.text");
		dataBinder.registerBinding("entrys.qcEggType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "qcEggType.text");
		dataBinder.registerBinding("entrys.maoEggQty", int.class, this.kdtEntrys, "maoEggQty.text");
		dataBinder.registerBinding("entrys.eggSourceType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "eggSourceType.text");
		dataBinder.registerBinding("entrys.outHouse", java.lang.Object.class, this.kdtEntrys, "outHouse.text");
		dataBinder.registerBinding("entrys.supplier", java.lang.Object.class, this.kdtEntrys, "supplier.text");
		dataBinder.registerBinding("entrys.outAreaPP", java.lang.Object.class, this.kdtEntrys, "outAreaPP.text");
		dataBinder.registerBinding("entrys.genderType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "genderType.text");
		dataBinder.registerBinding("entrys.zdhps", int.class, this.kdtEntrys, "zdhps.text");
		dataBinder.registerBinding("entrys.lphps", int.class, this.kdtEntrys, "lphps.text");
		dataBinder.registerBinding("entrys.farmer", java.lang.Object.class, this.kdtEntrys, "farmer.text");
		dataBinder.registerBinding("entrys.ferm", java.lang.Object.class, this.kdtEntrys, "ferm.text");
		dataBinder.registerBinding("entrys.CostObject", java.lang.Object.class, this.kdtEntrys, "CostObject.text");
		dataBinder.registerBinding("entrys.healthQty", int.class, this.kdtEntrys, "healthQty.text");
		dataBinder.registerBinding("entrys.healthQty2", int.class, this.kdtEntrys, "healthQty2.text");
		dataBinder.registerBinding("entrys.deadGermQty", int.class, this.kdtEntrys, "deadGermQty.text");
		dataBinder.registerBinding("entrys.germQty", int.class, this.kdtEntrys, "germQty.text");
		dataBinder.registerBinding("entrys.allOutQty", int.class, this.kdtEntrys, "allOutQty.text");
		dataBinder.registerBinding("entrys.strockbatch", java.lang.Object.class, this.kdtEntrys, "strockbatch.text");
		dataBinder.registerBinding("entrys.healthRate", java.math.BigDecimal.class, this.kdtEntrys, "healthRate.text");
		dataBinder.registerBinding("entrys.lphralthRate", java.math.BigDecimal.class, this.kdtEntrys, "lphralthRate.text");
		dataBinder.registerBinding("entrys.maleQty", int.class, this.kdtEntrys, "maleQty.text");
		dataBinder.registerBinding("entrys.femaleQty", int.class, this.kdtEntrys, "femaleQty.text");
		dataBinder.registerBinding("entrys.maoEggRate", java.math.BigDecimal.class, this.kdtEntrys, "maoEggRate.text");
		dataBinder.registerBinding("entrys.germRate", java.math.BigDecimal.class, this.kdtEntrys, "germRate.text");
		dataBinder.registerBinding("entrys.eggBabyRate", java.math.BigDecimal.class, this.kdtEntrys, "eggBabyRate.text");
		dataBinder.registerBinding("entrys.maleFemaleRate", java.math.BigDecimal.class, this.kdtEntrys, "maleFemaleRate.text");
		dataBinder.registerBinding("entrys.ksMaleQty", int.class, this.kdtEntrys, "ksMaleQty.text");
		dataBinder.registerBinding("entrys.gjMaleQty", int.class, this.kdtEntrys, "gjMaleQty.text");
		dataBinder.registerBinding("entrys.lossDiff", java.math.BigDecimal.class, this.kdtEntrys, "lossDiff.text");
		dataBinder.registerBinding("entrys.gifts", java.math.BigDecimal.class, this.kdtEntrys, "gifts.text");
		dataBinder.registerBinding("entrys.week", int.class, this.kdtEntrys, "week.text");
		dataBinder.registerBinding("entrys.day", int.class, this.kdtEntrys, "day.text");
		dataBinder.registerBinding("ImmuneEntrys.seq", int.class, this.kdtImmuneEntrys, "seq.text");
		dataBinder.registerBinding("ImmuneEntrys", com.kingdee.eas.farm.hatch.BHatchBabyBillImmuneEntryInfo.class, this.kdtImmuneEntrys, "userObject");
		dataBinder.registerBinding("ImmuneEntrys.immuneMaterial", java.lang.Object.class, this.kdtImmuneEntrys, "immuneMaterial.text");
		dataBinder.registerBinding("ImmuneEntrys.usedQty", int.class, this.kdtImmuneEntrys, "usedQty.text");
		dataBinder.registerBinding("ImmuneEntrys.description", String.class, this.kdtImmuneEntrys, "description.text");
		dataBinder.registerBinding("ImmuneEntrys.unit", String.class, this.kdtImmuneEntrys, "unit.text");
		dataBinder.registerBinding("ImmuneEntrys.immuneUserQty", java.math.BigDecimal.class, this.kdtImmuneEntrys, "immuneUserQty.text");
		dataBinder.registerBinding("SaleEntry.seq", int.class, this.kdtSaleEntry, "seq.text");
		dataBinder.registerBinding("SaleEntry", com.kingdee.eas.farm.hatch.BHatchBabyBillSaleEntryInfo.class, this.kdtSaleEntry, "userObject");
		dataBinder.registerBinding("SaleEntry.customer", java.lang.Object.class, this.kdtSaleEntry, "customer.text");
		dataBinder.registerBinding("SaleEntry.qty", int.class, this.kdtSaleEntry, "qty.text");
		dataBinder.registerBinding("SaleEntry.price", java.math.BigDecimal.class, this.kdtSaleEntry, "price.text");
		dataBinder.registerBinding("SaleEntry.material", java.lang.Object.class, this.kdtSaleEntry, "material.text");
		dataBinder.registerBinding("MatUserEntry.seq", int.class, this.kdtMatUserEntry, "seq.text");
		dataBinder.registerBinding("MatUserEntry", com.kingdee.eas.farm.hatch.BHatchBabyBillMatUserEntryInfo.class, this.kdtMatUserEntry, "userObject");
		dataBinder.registerBinding("MatUserEntry.matNum", java.lang.Object.class, this.kdtMatUserEntry, "matNum.text");
		dataBinder.registerBinding("MatUserEntry.matName", String.class, this.kdtMatUserEntry, "matName.text");
		dataBinder.registerBinding("MatUserEntry.matModel", String.class, this.kdtMatUserEntry, "matModel.text");
		dataBinder.registerBinding("MatUserEntry.matUnit", String.class, this.kdtMatUserEntry, "matUnit.text");
		dataBinder.registerBinding("MatUserEntry.matQty", java.math.BigDecimal.class, this.kdtMatUserEntry, "matQty.text");
		dataBinder.registerBinding("GoEntrys.seq", int.class, this.kdtGoEntrys, "seq.text");
		dataBinder.registerBinding("GoEntrys", com.kingdee.eas.farm.hatch.BHatchBabyBillGoEntryInfo.class, this.kdtGoEntrys, "userObject");
		dataBinder.registerBinding("GoEntrys.goType", com.kingdee.util.enums.Enum.class, this.kdtGoEntrys, "goType.text");
		dataBinder.registerBinding("GoEntrys.billNumber", String.class, this.kdtGoEntrys, "billNumber.text");
		dataBinder.registerBinding("GoEntrys.drug", java.lang.Object.class, this.kdtGoEntrys, "drug.text");
		dataBinder.registerBinding("GoEntrys.model", String.class, this.kdtGoEntrys, "model.text");
		dataBinder.registerBinding("GoEntrys.unit", java.lang.Object.class, this.kdtGoEntrys, "unit.text");
		dataBinder.registerBinding("GoEntrys.qty", java.math.BigDecimal.class, this.kdtGoEntrys, "qty.text");
		dataBinder.registerBinding("GoEntrys.serviceItems", java.lang.Object.class, this.kdtGoEntrys, "serviceItems.text");
		dataBinder.registerBinding("storageOrg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrg, "data");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("healthQty", int.class, this.txthealthQty, "value");
		dataBinder.registerBinding("deathQty", int.class, this.txtdeathQty, "value");
		dataBinder.registerBinding("unhatchedEggQty", int.class, this.txtunhatchedEggQty, "value");
		dataBinder.registerBinding("selectBabyPerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtselectBabyPerson, "data");
		dataBinder.registerBinding("immunePerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtimmunePerson, "data");
		dataBinder.registerBinding("hatchFactory", com.kingdee.eas.farm.hatch.HatchBaseDataInfo.class, this.prmthatchFactory, "data");
		dataBinder.registerBinding("hatchArea", com.kingdee.eas.farm.hatch.HatchAreaInfo.class, this.prmthatchArea, "data");
		dataBinder.registerBinding("adminOrg", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtadminOrg, "data");
		dataBinder.registerBinding("healthQtyB", int.class, this.txthealthQtyB, "value");
		dataBinder.registerBinding("noHealthQty", int.class, this.txtnoHealthQty, "value");
		dataBinder.registerBinding("healthQtyA1", int.class, this.txthealthQtyA1, "value");
		dataBinder.registerBinding("healthQtyA2", int.class, this.txthealthQtyA2, "value");
		dataBinder.registerBinding("healthQtyA3", int.class, this.txthealthQtyA3, "value");
		dataBinder.registerBinding("eggType", com.kingdee.eas.farm.hatch.EggType.class, this.eggType, "selectedItem");
		dataBinder.registerBinding("hatchDate", java.util.Date.class, this.pkhatchDate, "value");
		dataBinder.registerBinding("lossQty", int.class, this.txtlossQty, "value");
		dataBinder.registerBinding("SourceEntrys.seq", int.class, this.kdtSourceEntrys, "seq.text");
		dataBinder.registerBinding("SourceEntrys", com.kingdee.eas.farm.hatch.BHatchBabyBillSourceEntryInfo.class, this.kdtSourceEntrys, "userObject");
		dataBinder.registerBinding("SourceEntrys.deadGermQty", int.class, this.kdtSourceEntrys, "deadGermQty.text");
		dataBinder.registerBinding("SourceEntrys.healthQty", int.class, this.kdtSourceEntrys, "healthQty.text");
		dataBinder.registerBinding("SourceEntrys.supplier", java.lang.Object.class, this.kdtSourceEntrys, "supplier.text");
		dataBinder.registerBinding("SourceEntrys.healthQtyB", int.class, this.kdtSourceEntrys, "healthQtyB.text");
		dataBinder.registerBinding("SourceEntrys.healthQtyA1", int.class, this.kdtSourceEntrys, "healthQtyA1.text");
		dataBinder.registerBinding("SourceEntrys.healthQtyA2", int.class, this.kdtSourceEntrys, "healthQtyA2.text");
		dataBinder.registerBinding("SourceEntrys.healthQtyA3", int.class, this.kdtSourceEntrys, "healthQtyA3.text");
		dataBinder.registerBinding("SourceEntrys.qcEggType", com.kingdee.util.enums.Enum.class, this.kdtSourceEntrys, "qcEggType.text");
		dataBinder.registerBinding("SourceEntrys.GermQty2", int.class, this.kdtSourceEntrys, "GermQty2.text");
		dataBinder.registerBinding("SourceEntrys.outQty", int.class, this.kdtSourceEntrys, "outQty.text");
		dataBinder.registerBinding("SourceEntrys.outAreaP", java.lang.Object.class, this.kdtSourceEntrys, "outAreaP.text");
		dataBinder.registerBinding("SourceEntrys.hatchQty", int.class, this.kdtSourceEntrys, "hatchQty.text");
		dataBinder.registerBinding("SourceEntrys.trayingHealthEggQty", int.class, this.kdtSourceEntrys, "trayingHealthEggQty.text");
		dataBinder.registerBinding("SourceEntrys.allOutQty", int.class, this.kdtSourceEntrys, "allOutQty.text");
		dataBinder.registerBinding("SourceEntrys.genderType", com.kingdee.util.enums.Enum.class, this.kdtSourceEntrys, "genderType.text");
		dataBinder.registerBinding("SourceEntrys.eggSource", com.kingdee.util.enums.Enum.class, this.kdtSourceEntrys, "eggSource.text");
		dataBinder.registerBinding("SourceEntrys.qcEggsType", java.lang.Object.class, this.kdtSourceEntrys, "qcEggsType.text");
		dataBinder.registerBinding("SourceEntrys.maoQty", int.class, this.kdtSourceEntrys, "maoQty.text");
		dataBinder.registerBinding("SourceEntrys.kuiQty", int.class, this.kdtSourceEntrys, "kuiQty.text");
		dataBinder.registerBinding("SourceEntrys.littleChickQty", int.class, this.kdtSourceEntrys, "littleChickQty.text");
		dataBinder.registerBinding("candlingDate", java.util.Date.class, this.pkcandlingDate, "value");
		dataBinder.registerBinding("trayingDate", java.util.Date.class, this.pktrayingDate, "value");
		dataBinder.registerBinding("genderTy", com.kingdee.eas.farm.stocking.hatch.GenderType.class, this.genderTy, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.hatch.app.BHatchBabyBillEditUIHandler";
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
        this.kDDateLastUpdateTime.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.hatch.BHatchBabyBillInfo)ov;
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
		getValidateHelper().registerBindProperty("isAllOut", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isManuIn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isOtherIn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isGiftOtherIn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isMaterOut", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("transDescription", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hatchingBox", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.incubator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hatchHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hatchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qcEggType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.maoEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.eggSourceType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.outHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.outAreaPP", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.genderType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.zdhps", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lphps", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.ferm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CostObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.healthQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.healthQty2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.deadGermQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.germQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.allOutQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.strockbatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.healthRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lphralthRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.maleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.femaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.maoEggRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.germRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.eggBabyRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.maleFemaleRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.ksMaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.gjMaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lossDiff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.gifts", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.day", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.immuneMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.usedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.immuneUserQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntry.customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntry.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MatUserEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MatUserEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MatUserEntry.matNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MatUserEntry.matName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MatUserEntry.matModel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MatUserEntry.matUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MatUserEntry.matQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GoEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GoEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GoEntrys.goType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GoEntrys.billNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GoEntrys.drug", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GoEntrys.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GoEntrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GoEntrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GoEntrys.serviceItems", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("healthQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("deathQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unhatchedEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("selectBabyPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immunePerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchFactory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("adminOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("healthQtyB", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("noHealthQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("healthQtyA1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("healthQtyA2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("healthQtyA3", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lossQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.deadGermQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.healthQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.healthQtyB", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.healthQtyA1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.healthQtyA2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.healthQtyA3", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.qcEggType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.GermQty2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.outQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.outAreaP", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.hatchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.trayingHealthEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.allOutQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.genderType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.eggSource", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.qcEggsType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.maoQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.kuiQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SourceEntrys.littleChickQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("candlingDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("trayingDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("genderTy", ValidateHelper.ON_SAVE);    		
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
     * output txtdeathQty_actionPerformed method
     */
    protected void txtdeathQty_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output txtunhatchedEggQty_actionPerformed method
     */
    protected void txtunhatchedEggQty_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output txtlossQty_actionPerformed method
     */
    protected void txtlossQty_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output kdtImmuneEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtImmuneEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("immuneMaterial".equalsIgnoreCase(kdtImmuneEntrys.getColumn(colIndex).getKey())) {
kdtImmuneEntrys.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtImmuneEntrys.getCell(rowIndex,"immuneMaterial").getValue(),"baseUnit.name")));

}


    }

    /**
     * output kdtMatUserEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtMatUserEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("matNum".equalsIgnoreCase(kdtMatUserEntry.getColumn(colIndex).getKey())) {
kdtMatUserEntry.getCell(rowIndex,"matName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtMatUserEntry.getCell(rowIndex,"matNum").getValue(),"name")));

}

    if ("matNum".equalsIgnoreCase(kdtMatUserEntry.getColumn(colIndex).getKey())) {
kdtMatUserEntry.getCell(rowIndex,"matModel").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtMatUserEntry.getCell(rowIndex,"matNum").getValue(),"model")));

}

    if ("matNum".equalsIgnoreCase(kdtMatUserEntry.getColumn(colIndex).getKey())) {
kdtMatUserEntry.getCell(rowIndex,"matUnit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtMatUserEntry.getCell(rowIndex,"matNum").getValue(),"baseUnit.name")));

}


    }

    /**
     * output kdtGoEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtGoEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("drug".equalsIgnoreCase(kdtGoEntrys.getColumn(colIndex).getKey())) {
kdtGoEntrys.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtGoEntrys.getCell(rowIndex,"drug").getValue(),"model")));

}


    }

    /**
     * output kdtSourceEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtSourceEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("healthQtyA1".equalsIgnoreCase(kdtSourceEntrys.getColumn(colIndex).getKey())) {
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));

}

    if ("healthQtyA1".equalsIgnoreCase(kdtSourceEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"allQty").getValue())> 0) 
{
    kdtSourceEntrys.getCell(rowIndex,"healthRate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(100* ((com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())))/ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"allQty").getValue()))));
}
else
{
    kdtSourceEntrys.getCell(rowIndex,"healthRate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(0));
}

}

    if ("healthQtyA1".equalsIgnoreCase(kdtSourceEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"candingHealthQty").getValue())> 0) 
{
    kdtSourceEntrys.getCell(rowIndex,"fertilityHealthRate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(100* ((com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())))/ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"candingHealthQty").getValue()))));
}
else
{
    kdtSourceEntrys.getCell(rowIndex,"fertilityHealthRate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(0));
}

}

    if ("healthQtyA2".equalsIgnoreCase(kdtSourceEntrys.getColumn(colIndex).getKey())) {
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));

}

    if ("healthQtyA2".equalsIgnoreCase(kdtSourceEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtSourceEntrys.getCell(rowIndex,"healthRate").getValue())> 0) 
{
    kdtSourceEntrys.getCell(rowIndex,"healthRate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(100* ((com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())))/ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"allQty").getValue()))));
    kdtSourceEntrys.getCell(rowIndex,"healthRate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(100* ((com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())))/ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"allQty").getValue()))));
}
else
{
    kdtSourceEntrys.getCell(rowIndex,"healthRate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(0));
}

}

    if ("healthQtyA2".equalsIgnoreCase(kdtSourceEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"candingHealthQty").getValue())> 0) 
{
    kdtSourceEntrys.getCell(rowIndex,"fertilityHealthRate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(100* ((com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())))/ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"candingHealthQty").getValue()))));
    kdtSourceEntrys.getCell(rowIndex,"fertilityHealthRate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(100* ((com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())))/ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"candingHealthQty").getValue()))));
}
else
{
    kdtSourceEntrys.getCell(rowIndex,"fertilityHealthRate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(0));
}

}

    if ("healthQtyA3".equalsIgnoreCase(kdtSourceEntrys.getColumn(colIndex).getKey())) {
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));

}

    if ("healthQtyB".equalsIgnoreCase(kdtSourceEntrys.getColumn(colIndex).getKey())) {
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));

}

    if ("GermQty2".equalsIgnoreCase(kdtSourceEntrys.getColumn(colIndex).getKey())) {
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));

}

    if ("deadGermQty".equalsIgnoreCase(kdtSourceEntrys.getColumn(colIndex).getKey())) {
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));

}

    if ("healthQty".equalsIgnoreCase(kdtSourceEntrys.getColumn(colIndex).getKey())) {
kdtSourceEntrys.getCell(rowIndex,"allQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA3").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyB").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"deadGermQty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"GermQty2").getValue()))))))));

}

    if ("healthQty".equalsIgnoreCase(kdtSourceEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"allQty").getValue())> 0) 
{
    kdtSourceEntrys.getCell(rowIndex,"healthRate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(100* ((com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())))/ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"allQty").getValue()))));
}
else
{
    kdtSourceEntrys.getCell(rowIndex,"healthRate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(0));
}

}

    if ("healthQty".equalsIgnoreCase(kdtSourceEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"candingHealthQty").getValue())> 0) 
{
    kdtSourceEntrys.getCell(rowIndex,"fertilityHealthRate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(100* ((com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA1").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"healthQtyA2").getValue())))/ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtSourceEntrys.getCell(rowIndex,"candingHealthQty").getValue()))));
}
else
{
    kdtSourceEntrys.getCell(rowIndex,"fertilityHealthRate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(0));
}

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
        sic.add(new SelectorItemInfo("isAllOut"));
        sic.add(new SelectorItemInfo("isManuIn"));
        sic.add(new SelectorItemInfo("isOtherIn"));
        sic.add(new SelectorItemInfo("isGiftOtherIn"));
        sic.add(new SelectorItemInfo("isMaterOut"));
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
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("transDescription"));
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.hatchingBox.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.hatchingBox.id"));
			sic.add(new SelectorItemInfo("entrys.hatchingBox.name"));
        	sic.add(new SelectorItemInfo("entrys.hatchingBox.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.incubator.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.incubator.id"));
			sic.add(new SelectorItemInfo("entrys.incubator.name"));
        	sic.add(new SelectorItemInfo("entrys.incubator.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.hatchHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.hatchHouse.id"));
			sic.add(new SelectorItemInfo("entrys.hatchHouse.name"));
        	sic.add(new SelectorItemInfo("entrys.hatchHouse.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.hatchQty"));
    	sic.add(new SelectorItemInfo("entrys.qcEggType"));
    	sic.add(new SelectorItemInfo("entrys.maoEggQty"));
    	sic.add(new SelectorItemInfo("entrys.eggSourceType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.outHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.outHouse.id"));
			sic.add(new SelectorItemInfo("entrys.outHouse.name"));
        	sic.add(new SelectorItemInfo("entrys.outHouse.number"));
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
			sic.add(new SelectorItemInfo("entrys.outAreaPP.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.outAreaPP.id"));
			sic.add(new SelectorItemInfo("entrys.outAreaPP.name"));
        	sic.add(new SelectorItemInfo("entrys.outAreaPP.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.genderType"));
    	sic.add(new SelectorItemInfo("entrys.zdhps"));
    	sic.add(new SelectorItemInfo("entrys.lphps"));
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
			sic.add(new SelectorItemInfo("entrys.ferm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.ferm.id"));
			sic.add(new SelectorItemInfo("entrys.ferm.name"));
        	sic.add(new SelectorItemInfo("entrys.ferm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.CostObject.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.CostObject.id"));
			sic.add(new SelectorItemInfo("entrys.CostObject.name"));
        	sic.add(new SelectorItemInfo("entrys.CostObject.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.healthQty"));
    	sic.add(new SelectorItemInfo("entrys.healthQty2"));
    	sic.add(new SelectorItemInfo("entrys.deadGermQty"));
    	sic.add(new SelectorItemInfo("entrys.germQty"));
    	sic.add(new SelectorItemInfo("entrys.allOutQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.strockbatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.strockbatch.id"));
			sic.add(new SelectorItemInfo("entrys.strockbatch.name"));
        	sic.add(new SelectorItemInfo("entrys.strockbatch.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.healthRate"));
    	sic.add(new SelectorItemInfo("entrys.lphralthRate"));
    	sic.add(new SelectorItemInfo("entrys.maleQty"));
    	sic.add(new SelectorItemInfo("entrys.femaleQty"));
    	sic.add(new SelectorItemInfo("entrys.maoEggRate"));
    	sic.add(new SelectorItemInfo("entrys.germRate"));
    	sic.add(new SelectorItemInfo("entrys.eggBabyRate"));
    	sic.add(new SelectorItemInfo("entrys.maleFemaleRate"));
    	sic.add(new SelectorItemInfo("entrys.ksMaleQty"));
    	sic.add(new SelectorItemInfo("entrys.gjMaleQty"));
    	sic.add(new SelectorItemInfo("entrys.lossDiff"));
    	sic.add(new SelectorItemInfo("entrys.gifts"));
    	sic.add(new SelectorItemInfo("entrys.week"));
    	sic.add(new SelectorItemInfo("entrys.day"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.immuneMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ImmuneEntrys.immuneMaterial.id"));
			sic.add(new SelectorItemInfo("ImmuneEntrys.immuneMaterial.name"));
        	sic.add(new SelectorItemInfo("ImmuneEntrys.immuneMaterial.number"));
		}
    	sic.add(new SelectorItemInfo("ImmuneEntrys.usedQty"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.description"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.unit"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.immuneUserQty"));
    	sic.add(new SelectorItemInfo("SaleEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SaleEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SaleEntry.customer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SaleEntry.customer.id"));
			sic.add(new SelectorItemInfo("SaleEntry.customer.number"));
			sic.add(new SelectorItemInfo("SaleEntry.customer.-"));
			sic.add(new SelectorItemInfo("SaleEntry.customer.name"));
		}
    	sic.add(new SelectorItemInfo("SaleEntry.qty"));
    	sic.add(new SelectorItemInfo("SaleEntry.price"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SaleEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SaleEntry.material.id"));
			sic.add(new SelectorItemInfo("SaleEntry.material.name"));
        	sic.add(new SelectorItemInfo("SaleEntry.material.number"));
		}
    	sic.add(new SelectorItemInfo("MatUserEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MatUserEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MatUserEntry.matNum.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("MatUserEntry.matNum.id"));
			sic.add(new SelectorItemInfo("MatUserEntry.matNum.number"));
			sic.add(new SelectorItemInfo("MatUserEntry.matNum.name"));
		}
    	sic.add(new SelectorItemInfo("MatUserEntry.matName"));
    	sic.add(new SelectorItemInfo("MatUserEntry.matModel"));
    	sic.add(new SelectorItemInfo("MatUserEntry.matUnit"));
    	sic.add(new SelectorItemInfo("MatUserEntry.matQty"));
    	sic.add(new SelectorItemInfo("GoEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("GoEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("GoEntrys.goType"));
    	sic.add(new SelectorItemInfo("GoEntrys.billNumber"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("GoEntrys.drug.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("GoEntrys.drug.id"));
			sic.add(new SelectorItemInfo("GoEntrys.drug.name"));
        	sic.add(new SelectorItemInfo("GoEntrys.drug.number"));
		}
    	sic.add(new SelectorItemInfo("GoEntrys.model"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("GoEntrys.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("GoEntrys.unit.id"));
			sic.add(new SelectorItemInfo("GoEntrys.unit.name"));
        	sic.add(new SelectorItemInfo("GoEntrys.unit.number"));
		}
    	sic.add(new SelectorItemInfo("GoEntrys.qty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("GoEntrys.serviceItems.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("GoEntrys.serviceItems.id"));
			sic.add(new SelectorItemInfo("GoEntrys.serviceItems.name"));
        	sic.add(new SelectorItemInfo("GoEntrys.serviceItems.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storageOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrg.id"));
        	sic.add(new SelectorItemInfo("storageOrg.number"));
        	sic.add(new SelectorItemInfo("storageOrg.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("healthQty"));
        sic.add(new SelectorItemInfo("deathQty"));
        sic.add(new SelectorItemInfo("unhatchedEggQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("selectBabyPerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("selectBabyPerson.id"));
        	sic.add(new SelectorItemInfo("selectBabyPerson.number"));
        	sic.add(new SelectorItemInfo("selectBabyPerson.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("immunePerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("immunePerson.id"));
        	sic.add(new SelectorItemInfo("immunePerson.number"));
        	sic.add(new SelectorItemInfo("immunePerson.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("hatchFactory.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("hatchFactory.id"));
        	sic.add(new SelectorItemInfo("hatchFactory.number"));
        	sic.add(new SelectorItemInfo("hatchFactory.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("hatchArea.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("hatchArea.id"));
        	sic.add(new SelectorItemInfo("hatchArea.number"));
        	sic.add(new SelectorItemInfo("hatchArea.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("adminOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("adminOrg.id"));
        	sic.add(new SelectorItemInfo("adminOrg.number"));
        	sic.add(new SelectorItemInfo("adminOrg.name"));
		}
        sic.add(new SelectorItemInfo("healthQtyB"));
        sic.add(new SelectorItemInfo("noHealthQty"));
        sic.add(new SelectorItemInfo("healthQtyA1"));
        sic.add(new SelectorItemInfo("healthQtyA2"));
        sic.add(new SelectorItemInfo("healthQtyA3"));
        sic.add(new SelectorItemInfo("eggType"));
        sic.add(new SelectorItemInfo("hatchDate"));
        sic.add(new SelectorItemInfo("lossQty"));
    	sic.add(new SelectorItemInfo("SourceEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SourceEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("SourceEntrys.deadGermQty"));
    	sic.add(new SelectorItemInfo("SourceEntrys.healthQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SourceEntrys.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SourceEntrys.supplier.id"));
			sic.add(new SelectorItemInfo("SourceEntrys.supplier.name"));
        	sic.add(new SelectorItemInfo("SourceEntrys.supplier.number"));
		}
    	sic.add(new SelectorItemInfo("SourceEntrys.healthQtyB"));
    	sic.add(new SelectorItemInfo("SourceEntrys.healthQtyA1"));
    	sic.add(new SelectorItemInfo("SourceEntrys.healthQtyA2"));
    	sic.add(new SelectorItemInfo("SourceEntrys.healthQtyA3"));
    	sic.add(new SelectorItemInfo("SourceEntrys.qcEggType"));
    	sic.add(new SelectorItemInfo("SourceEntrys.GermQty2"));
    	sic.add(new SelectorItemInfo("SourceEntrys.outQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SourceEntrys.outAreaP.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SourceEntrys.outAreaP.id"));
			sic.add(new SelectorItemInfo("SourceEntrys.outAreaP.name"));
        	sic.add(new SelectorItemInfo("SourceEntrys.outAreaP.number"));
		}
    	sic.add(new SelectorItemInfo("SourceEntrys.hatchQty"));
    	sic.add(new SelectorItemInfo("SourceEntrys.trayingHealthEggQty"));
    	sic.add(new SelectorItemInfo("SourceEntrys.allOutQty"));
    	sic.add(new SelectorItemInfo("SourceEntrys.genderType"));
    	sic.add(new SelectorItemInfo("SourceEntrys.eggSource"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SourceEntrys.qcEggsType.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SourceEntrys.qcEggsType.id"));
			sic.add(new SelectorItemInfo("SourceEntrys.qcEggsType.name"));
        	sic.add(new SelectorItemInfo("SourceEntrys.qcEggsType.number"));
		}
    	sic.add(new SelectorItemInfo("SourceEntrys.maoQty"));
    	sic.add(new SelectorItemInfo("SourceEntrys.kuiQty"));
    	sic.add(new SelectorItemInfo("SourceEntrys.littleChickQty"));
        sic.add(new SelectorItemInfo("candlingDate"));
        sic.add(new SelectorItemInfo("trayingDate"));
        sic.add(new SelectorItemInfo("genderTy"));
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
        com.kingdee.eas.farm.hatch.BHatchBabyBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.hatch.BHatchBabyBillFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractBHatchBabyBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBHatchBabyBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.hatch.client", "BHatchBabyBillEditUI");
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
        return com.kingdee.eas.farm.hatch.client.BHatchBabyBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.hatch.BHatchBabyBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.hatch.BHatchBabyBillInfo objectValue = new com.kingdee.eas.farm.hatch.BHatchBabyBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/hatch/BHatchBabyBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.hatch.app.BHatchBabyBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(baseStatus.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"状态"});
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"qcEggType").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"合格蛋类型"});
			}
		}
		for (int i=0,n=kdtSaleEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtSaleEntry.getCell(i,"customer").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"客户"});
			}
		}
		for (int i=0,n=kdtSaleEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtSaleEntry.getCell(i,"qty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"数量"});
			}
		}
		for (int i=0,n=kdtSaleEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtSaleEntry.getCell(i,"price").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单价"});
			}
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
		vo.put("baseStatus",new Integer(-1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}        
				protected void setTableToSumField() {
			setTableToSumField(kdtEntrys,new String[] {"hatchQty","zdhps","lphps","healthQty","healthQty2","femaleQty","maleQty","maoEggQty","deadGermQty","allOutQty"});
		}


}