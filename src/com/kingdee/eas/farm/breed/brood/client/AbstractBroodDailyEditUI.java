/**
 * output package name
 */
package com.kingdee.eas.farm.breed.brood.client;

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
public abstract class AbstractBroodDailyEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBroodDailyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane paneBIZLayerControl17;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutSideTFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutSideTTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweather;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutHumidityFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutHumidityTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfuel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweek;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweekDay;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstoOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedBatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostObject;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contelectricityQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoalFual;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdieselFual;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contentryPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contleavePersonQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contattendPersonQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDPanel baseTab;
    protected com.kingdee.bos.ctrl.swing.KDPanel assTab;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtAssEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtAssEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtImmuneEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtImmuneEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFodderEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtFodderEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedLog;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPanebreedLog;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtbreedLog;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutSideTFrom;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutSideTTo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtweather;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutHumidityFrom;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutHumidityTo;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfuel;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweek;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweekDay;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstoOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedBatch;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcostObject;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtelectricityQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcoalFual;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdieselFual;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtentryPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtleavePersonQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtattendPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnGenNextBill;
    protected com.kingdee.eas.farm.breed.brood.BroodDailyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionGenNextBill actionGenNextBill = null;
    protected ActionReShareCoalAndDiesel actionReShareCoalAndDiesel = null;
    /**
     * output class constructor
     */
    public AbstractBroodDailyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBroodDailyEditUI.class.getName());
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
        this.actionAudit.setBindWorkFlow(true);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setBindWorkFlow(true);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionGenNextBill
        this.actionGenNextBill = new ActionGenNextBill(this);
        getActionManager().registerAction("actionGenNextBill", actionGenNextBill);
        this.actionGenNextBill.setBindWorkFlow(true);
        this.actionGenNextBill.setExtendProperty("canForewarn", "true");
        this.actionGenNextBill.setExtendProperty("userDefined", "true");
        this.actionGenNextBill.setExtendProperty("isObjectUpdateLock", "false");
         this.actionGenNextBill.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionGenNextBill.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionGenNextBill.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionReShareCoalAndDiesel
        this.actionReShareCoalAndDiesel = new ActionReShareCoalAndDiesel(this);
        getActionManager().registerAction("actionReShareCoalAndDiesel", actionReShareCoalAndDiesel);
        this.actionReShareCoalAndDiesel.setExtendProperty("canForewarn", "true");
        this.actionReShareCoalAndDiesel.setExtendProperty("userDefined", "true");
        this.actionReShareCoalAndDiesel.setExtendProperty("isObjectUpdateLock", "false");
         this.actionReShareCoalAndDiesel.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionReShareCoalAndDiesel.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.paneBIZLayerControl17 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutSideTFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutSideTTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweather = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutHumidityFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutHumidityTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfuel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweek = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweekDay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contstoOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostObject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contelectricityQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoalFual = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdieselFual = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitPersonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contentryPersonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contleavePersonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contattendPersonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.baseTab = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.assTab = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtAssEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtImmuneEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtFodderEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contbreedLog = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.scrollPanebreedLog = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtbreedLog = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtoutSideTFrom = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoutSideTTo = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweather = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtoutHumidityFrom = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoutHumidityTo = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtfuel = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweek = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweekDay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtstoOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbreedBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtcostObject = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtelectricityQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcoalFual = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdieselFual = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinitPersonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtentryPersonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtleavePersonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtattendPersonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnGenNextBill = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.paneBIZLayerControl17.setName("paneBIZLayerControl17");
        this.contbaseStatus.setName("contbaseStatus");
        this.contoutSideTFrom.setName("contoutSideTFrom");
        this.contoutSideTTo.setName("contoutSideTTo");
        this.contweather.setName("contweather");
        this.contoutHumidityFrom.setName("contoutHumidityFrom");
        this.contoutHumidityTo.setName("contoutHumidityTo");
        this.contauditTime.setName("contauditTime");
        this.contfuel.setName("contfuel");
        this.contweek.setName("contweek");
        this.contweekDay.setName("contweekDay");
        this.kDLabel1.setName("kDLabel1");
        this.kDLabel2.setName("kDLabel2");
        this.contstoOrg.setName("contstoOrg");
        this.contbreedBatch.setName("contbreedBatch");
        this.contcostObject.setName("contcostObject");
        this.contelectricityQty.setName("contelectricityQty");
        this.contcoalFual.setName("contcoalFual");
        this.contdieselFual.setName("contdieselFual");
        this.continitPersonQty.setName("continitPersonQty");
        this.contentryPersonQty.setName("contentryPersonQty");
        this.contleavePersonQty.setName("contleavePersonQty");
        this.contattendPersonQty.setName("contattendPersonQty");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.baseTab.setName("baseTab");
        this.assTab.setName("assTab");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel4.setName("kDPanel4");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtAssEntrys.setName("kdtAssEntrys");
        this.kdtImmuneEntrys.setName("kdtImmuneEntrys");
        this.kdtFodderEntrys.setName("kdtFodderEntrys");
        this.contbreedLog.setName("contbreedLog");
        this.scrollPanebreedLog.setName("scrollPanebreedLog");
        this.txtbreedLog.setName("txtbreedLog");
        this.baseStatus.setName("baseStatus");
        this.txtoutSideTFrom.setName("txtoutSideTFrom");
        this.txtoutSideTTo.setName("txtoutSideTTo");
        this.txtweather.setName("txtweather");
        this.txtoutHumidityFrom.setName("txtoutHumidityFrom");
        this.txtoutHumidityTo.setName("txtoutHumidityTo");
        this.pkauditTime.setName("pkauditTime");
        this.txtfuel.setName("txtfuel");
        this.txtweek.setName("txtweek");
        this.txtweekDay.setName("txtweekDay");
        this.prmtstoOrg.setName("prmtstoOrg");
        this.prmtbreedBatch.setName("prmtbreedBatch");
        this.txtcostObject.setName("txtcostObject");
        this.txtelectricityQty.setName("txtelectricityQty");
        this.txtcoalFual.setName("txtcoalFual");
        this.txtdieselFual.setName("txtdieselFual");
        this.txtinitPersonQty.setName("txtinitPersonQty");
        this.txtentryPersonQty.setName("txtentryPersonQty");
        this.txtleavePersonQty.setName("txtleavePersonQty");
        this.txtattendPersonQty.setName("txtattendPersonQty");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.btnGenNextBill.setName("btnGenNextBill");
        // CoreUI		
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
        this.contCreator.setBoundLabelAlignment(7);		
        this.contCreator.setVisible(true);		
        this.contCreator.setForeground(new java.awt.Color(0,0,0));
        // contCreateTime		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);		
        this.contCreateTime.setBoundLabelAlignment(7);		
        this.contCreateTime.setVisible(true);		
        this.contCreateTime.setForeground(new java.awt.Color(0,0,0));
        // contLastUpdateUser		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(false);		
        this.contLastUpdateUser.setBoundLabelAlignment(7);		
        this.contLastUpdateUser.setForeground(new java.awt.Color(0,0,0));
        // contLastUpdateTime		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(false);		
        this.contLastUpdateTime.setBoundLabelAlignment(7);		
        this.contLastUpdateTime.setForeground(new java.awt.Color(0,0,0));
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);		
        this.contNumber.setBoundLabelAlignment(7);		
        this.contNumber.setVisible(true);		
        this.contNumber.setForeground(new java.awt.Color(0,0,0));
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);		
        this.contBizDate.setForeground(new java.awt.Color(0,0,0));
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);		
        this.contDescription.setBoundLabelAlignment(7);		
        this.contDescription.setVisible(true);		
        this.contDescription.setForeground(new java.awt.Color(0,0,0));
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contAuditor.setBoundLabelAlignment(7);		
        this.contAuditor.setVisible(true);		
        this.contAuditor.setForeground(new java.awt.Color(0,0,0));
        // paneBIZLayerControl17		
        this.paneBIZLayerControl17.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contoutSideTFrom		
        this.contoutSideTFrom.setBoundLabelText(resHelper.getString("contoutSideTFrom.boundLabelText"));		
        this.contoutSideTFrom.setBoundLabelLength(100);		
        this.contoutSideTFrom.setBoundLabelUnderline(true);		
        this.contoutSideTFrom.setVisible(true);
        // contoutSideTTo		
        this.contoutSideTTo.setBoundLabelText(resHelper.getString("contoutSideTTo.boundLabelText"));		
        this.contoutSideTTo.setBoundLabelLength(100);		
        this.contoutSideTTo.setBoundLabelUnderline(true);		
        this.contoutSideTTo.setVisible(true);
        // contweather		
        this.contweather.setBoundLabelText(resHelper.getString("contweather.boundLabelText"));		
        this.contweather.setBoundLabelLength(100);		
        this.contweather.setBoundLabelUnderline(true);		
        this.contweather.setVisible(true);
        // contoutHumidityFrom		
        this.contoutHumidityFrom.setBoundLabelText(resHelper.getString("contoutHumidityFrom.boundLabelText"));		
        this.contoutHumidityFrom.setBoundLabelLength(100);		
        this.contoutHumidityFrom.setBoundLabelUnderline(true);		
        this.contoutHumidityFrom.setVisible(true);
        // contoutHumidityTo		
        this.contoutHumidityTo.setBoundLabelText(resHelper.getString("contoutHumidityTo.boundLabelText"));		
        this.contoutHumidityTo.setBoundLabelLength(100);		
        this.contoutHumidityTo.setBoundLabelUnderline(true);		
        this.contoutHumidityTo.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contfuel		
        this.contfuel.setBoundLabelText(resHelper.getString("contfuel.boundLabelText"));		
        this.contfuel.setBoundLabelLength(100);		
        this.contfuel.setBoundLabelUnderline(true);		
        this.contfuel.setVisible(false);		
        this.contfuel.setEnabled(false);
        // contweek		
        this.contweek.setBoundLabelText(resHelper.getString("contweek.boundLabelText"));		
        this.contweek.setBoundLabelLength(100);		
        this.contweek.setBoundLabelUnderline(true);		
        this.contweek.setVisible(true);
        // contweekDay		
        this.contweekDay.setBoundLabelText(resHelper.getString("contweekDay.boundLabelText"));		
        this.contweekDay.setBoundLabelLength(0);		
        this.contweekDay.setBoundLabelUnderline(true);		
        this.contweekDay.setVisible(true);
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));
        // kDLabel2		
        this.kDLabel2.setText(resHelper.getString("kDLabel2.text"));
        // contstoOrg		
        this.contstoOrg.setBoundLabelText(resHelper.getString("contstoOrg.boundLabelText"));		
        this.contstoOrg.setBoundLabelLength(100);		
        this.contstoOrg.setBoundLabelUnderline(true);		
        this.contstoOrg.setVisible(true);
        // contbreedBatch		
        this.contbreedBatch.setBoundLabelText(resHelper.getString("contbreedBatch.boundLabelText"));		
        this.contbreedBatch.setBoundLabelLength(100);		
        this.contbreedBatch.setBoundLabelUnderline(true);		
        this.contbreedBatch.setVisible(true);
        // contcostObject		
        this.contcostObject.setBoundLabelText(resHelper.getString("contcostObject.boundLabelText"));		
        this.contcostObject.setBoundLabelLength(100);		
        this.contcostObject.setBoundLabelUnderline(true);		
        this.contcostObject.setVisible(true);
        // contelectricityQty		
        this.contelectricityQty.setBoundLabelText(resHelper.getString("contelectricityQty.boundLabelText"));		
        this.contelectricityQty.setBoundLabelLength(100);		
        this.contelectricityQty.setBoundLabelUnderline(true);		
        this.contelectricityQty.setVisible(true);
        // contcoalFual		
        this.contcoalFual.setBoundLabelText(resHelper.getString("contcoalFual.boundLabelText"));		
        this.contcoalFual.setBoundLabelLength(100);		
        this.contcoalFual.setBoundLabelUnderline(true);		
        this.contcoalFual.setVisible(true);
        // contdieselFual		
        this.contdieselFual.setBoundLabelText(resHelper.getString("contdieselFual.boundLabelText"));		
        this.contdieselFual.setBoundLabelLength(100);		
        this.contdieselFual.setBoundLabelUnderline(true);		
        this.contdieselFual.setVisible(true);
        // continitPersonQty		
        this.continitPersonQty.setBoundLabelText(resHelper.getString("continitPersonQty.boundLabelText"));		
        this.continitPersonQty.setBoundLabelLength(100);		
        this.continitPersonQty.setBoundLabelUnderline(true);		
        this.continitPersonQty.setVisible(true);
        // contentryPersonQty		
        this.contentryPersonQty.setBoundLabelText(resHelper.getString("contentryPersonQty.boundLabelText"));		
        this.contentryPersonQty.setBoundLabelLength(100);		
        this.contentryPersonQty.setBoundLabelUnderline(true);		
        this.contentryPersonQty.setVisible(true);
        // contleavePersonQty		
        this.contleavePersonQty.setBoundLabelText(resHelper.getString("contleavePersonQty.boundLabelText"));		
        this.contleavePersonQty.setBoundLabelLength(100);		
        this.contleavePersonQty.setBoundLabelUnderline(true);		
        this.contleavePersonQty.setVisible(true);
        // contattendPersonQty		
        this.contattendPersonQty.setBoundLabelText(resHelper.getString("contattendPersonQty.boundLabelText"));		
        this.contattendPersonQty.setBoundLabelLength(100);		
        this.contattendPersonQty.setBoundLabelUnderline(true);		
        this.contattendPersonQty.setVisible(true);
        // prmtCreator		
        this.prmtCreator.setEnabled(false);		
        this.prmtCreator.setRequired(false);		
        this.prmtCreator.setForeground(new java.awt.Color(0,0,0));
        // kDDateCreateTime		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.kDDateCreateTime.setRequired(false);		
        this.kDDateCreateTime.setForeground(new java.awt.Color(0,0,0));
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.prmtLastUpdateUser.setVisible(false);		
        this.prmtLastUpdateUser.setRequired(false);		
        this.prmtLastUpdateUser.setForeground(new java.awt.Color(0,0,0));
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.kDDateLastUpdateTime.setVisible(false);		
        this.kDDateLastUpdateTime.setRequired(false);		
        this.kDDateLastUpdateTime.setForeground(new java.awt.Color(0,0,0));
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(true);		
        this.txtNumber.setHorizontalAlignment(2);		
        this.txtNumber.setRequired(false);		
        this.txtNumber.setForeground(new java.awt.Color(0,0,0));
        // pkBizDate		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);		
        this.pkBizDate.setForeground(new java.awt.Color(0,0,0));
        // txtDescription		
        this.txtDescription.setMaxLength(80);		
        this.txtDescription.setEnabled(true);		
        this.txtDescription.setHorizontalAlignment(2);		
        this.txtDescription.setRequired(false);		
        this.txtDescription.setForeground(new java.awt.Color(0,0,0));
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);		
        this.prmtAuditor.setRequired(false);		
        this.prmtAuditor.setForeground(new java.awt.Color(0,0,0));
        // baseTab		
        this.baseTab.setVisible(true);
        // assTab		
        this.assTab.setVisible(true);
        // kDPanel1
        // kDPanel2
        // kDPanel4
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"henhouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"materialModel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"dailyQtyAll\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"limitFeedType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"waterQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"averageWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{henhouseName}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{materialModel}</t:Cell><t:Cell>$Resource{dailyQtyAll}</t:Cell><t:Cell>$Resource{limitFeedType}</t:Cell><t:Cell>$Resource{waterQty}</t:Cell><t:Cell>$Resource{averageWeight}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","henhouse","henhouseName","material","materialName","materialModel","dailyQtyAll","limitFeedType","waterQty","averageWeight"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtEntrys_henhouse_PromptBox.setVisible(true);
        kdtEntrys_henhouse_PromptBox.setEditable(true);
        kdtEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henhouse_PromptBox);
        this.kdtEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        ObjectValueRender kdtEntrys_henhouse_OVR = new ObjectValueRender();
        kdtEntrys_henhouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("henhouse").setRenderer(kdtEntrys_henhouse_OVR);
        KDTextField kdtEntrys_henhouseName_TextField = new KDTextField();
        kdtEntrys_henhouseName_TextField.setName("kdtEntrys_henhouseName_TextField");
        kdtEntrys_henhouseName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_henhouseName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henhouseName_TextField);
        this.kdtEntrys.getColumn("henhouseName").setEditor(kdtEntrys_henhouseName_CellEditor);
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
        KDTextField kdtEntrys_materialModel_TextField = new KDTextField();
        kdtEntrys_materialModel_TextField.setName("kdtEntrys_materialModel_TextField");
        kdtEntrys_materialModel_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_materialModel_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialModel_TextField);
        this.kdtEntrys.getColumn("materialModel").setEditor(kdtEntrys_materialModel_CellEditor);
        KDFormattedTextField kdtEntrys_dailyQtyAll_TextField = new KDFormattedTextField();
        kdtEntrys_dailyQtyAll_TextField.setName("kdtEntrys_dailyQtyAll_TextField");
        kdtEntrys_dailyQtyAll_TextField.setVisible(true);
        kdtEntrys_dailyQtyAll_TextField.setEditable(true);
        kdtEntrys_dailyQtyAll_TextField.setHorizontalAlignment(2);
        kdtEntrys_dailyQtyAll_TextField.setDataType(1);
        	kdtEntrys_dailyQtyAll_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_dailyQtyAll_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_dailyQtyAll_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_dailyQtyAll_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dailyQtyAll_TextField);
        this.kdtEntrys.getColumn("dailyQtyAll").setEditor(kdtEntrys_dailyQtyAll_CellEditor);
        KDTextField kdtEntrys_limitFeedType_TextField = new KDTextField();
        kdtEntrys_limitFeedType_TextField.setName("kdtEntrys_limitFeedType_TextField");
        kdtEntrys_limitFeedType_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_limitFeedType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_limitFeedType_TextField);
        this.kdtEntrys.getColumn("limitFeedType").setEditor(kdtEntrys_limitFeedType_CellEditor);
        KDFormattedTextField kdtEntrys_waterQty_TextField = new KDFormattedTextField();
        kdtEntrys_waterQty_TextField.setName("kdtEntrys_waterQty_TextField");
        kdtEntrys_waterQty_TextField.setVisible(true);
        kdtEntrys_waterQty_TextField.setEditable(true);
        kdtEntrys_waterQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_waterQty_TextField.setDataType(1);
        	kdtEntrys_waterQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_waterQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_waterQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_waterQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_waterQty_TextField);
        this.kdtEntrys.getColumn("waterQty").setEditor(kdtEntrys_waterQty_CellEditor);
        KDFormattedTextField kdtEntrys_averageWeight_TextField = new KDFormattedTextField();
        kdtEntrys_averageWeight_TextField.setName("kdtEntrys_averageWeight_TextField");
        kdtEntrys_averageWeight_TextField.setVisible(true);
        kdtEntrys_averageWeight_TextField.setEditable(true);
        kdtEntrys_averageWeight_TextField.setHorizontalAlignment(2);
        kdtEntrys_averageWeight_TextField.setDataType(1);
        	kdtEntrys_averageWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_averageWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_averageWeight_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_averageWeight_CellEditor = new KDTDefaultCellEditor(kdtEntrys_averageWeight_TextField);
        this.kdtEntrys.getColumn("averageWeight").setEditor(kdtEntrys_averageWeight_CellEditor);
        // kdtAssEntrys
		String kdtAssEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"henhouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"breedTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"lightingTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"temperatureTo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"temperatureFrom\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"humidityTo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"humidityFrom\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"cullQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"deathQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"breekingStock\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"isMarketed\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"marketQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{henhouseName}</t:Cell><t:Cell>$Resource{breedTime}</t:Cell><t:Cell>$Resource{lightingTime}</t:Cell><t:Cell>$Resource{temperatureTo}</t:Cell><t:Cell>$Resource{temperatureFrom}</t:Cell><t:Cell>$Resource{humidityTo}</t:Cell><t:Cell>$Resource{humidityFrom}</t:Cell><t:Cell>$Resource{cullQty}</t:Cell><t:Cell>$Resource{deathQty}</t:Cell><t:Cell>$Resource{breekingStock}</t:Cell><t:Cell>$Resource{isMarketed}</t:Cell><t:Cell>$Resource{marketQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtAssEntrys.setFormatXml(resHelper.translateString("kdtAssEntrys",kdtAssEntrysStrXML));
        kdtAssEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtAssEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtAssEntrys.putBindContents("editData",new String[] {"id","henhouse","henhouseName","breedTime","lightingTime","temperatureTo","temperatureFrom","humidityTo","humidityFrom","cullQty","deathQty","breekingStock","isMarketed","marketQty"});


        this.kdtAssEntrys.checkParsed();
        final KDBizPromptBox kdtAssEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtAssEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtAssEntrys_henhouse_PromptBox.setVisible(true);
        kdtAssEntrys_henhouse_PromptBox.setEditable(true);
        kdtAssEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtAssEntrys_henhouse_PromptBox.setEditFormat("$number$");
        kdtAssEntrys_henhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAssEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_henhouse_PromptBox);
        this.kdtAssEntrys.getColumn("henhouse").setEditor(kdtAssEntrys_henhouse_CellEditor);
        ObjectValueRender kdtAssEntrys_henhouse_OVR = new ObjectValueRender();
        kdtAssEntrys_henhouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtAssEntrys.getColumn("henhouse").setRenderer(kdtAssEntrys_henhouse_OVR);
        KDTextField kdtAssEntrys_henhouseName_TextField = new KDTextField();
        kdtAssEntrys_henhouseName_TextField.setName("kdtAssEntrys_henhouseName_TextField");
        kdtAssEntrys_henhouseName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtAssEntrys_henhouseName_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_henhouseName_TextField);
        this.kdtAssEntrys.getColumn("henhouseName").setEditor(kdtAssEntrys_henhouseName_CellEditor);
        KDFormattedTextField kdtAssEntrys_breedTime_TextField = new KDFormattedTextField();
        kdtAssEntrys_breedTime_TextField.setName("kdtAssEntrys_breedTime_TextField");
        kdtAssEntrys_breedTime_TextField.setVisible(true);
        kdtAssEntrys_breedTime_TextField.setEditable(true);
        kdtAssEntrys_breedTime_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_breedTime_TextField.setDataType(1);
        	kdtAssEntrys_breedTime_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtAssEntrys_breedTime_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtAssEntrys_breedTime_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtAssEntrys_breedTime_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_breedTime_TextField);
        this.kdtAssEntrys.getColumn("breedTime").setEditor(kdtAssEntrys_breedTime_CellEditor);
        KDFormattedTextField kdtAssEntrys_lightingTime_TextField = new KDFormattedTextField();
        kdtAssEntrys_lightingTime_TextField.setName("kdtAssEntrys_lightingTime_TextField");
        kdtAssEntrys_lightingTime_TextField.setVisible(true);
        kdtAssEntrys_lightingTime_TextField.setEditable(true);
        kdtAssEntrys_lightingTime_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_lightingTime_TextField.setDataType(1);
        	kdtAssEntrys_lightingTime_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_lightingTime_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_lightingTime_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_lightingTime_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_lightingTime_TextField);
        this.kdtAssEntrys.getColumn("lightingTime").setEditor(kdtAssEntrys_lightingTime_CellEditor);
        KDFormattedTextField kdtAssEntrys_temperatureTo_TextField = new KDFormattedTextField();
        kdtAssEntrys_temperatureTo_TextField.setName("kdtAssEntrys_temperatureTo_TextField");
        kdtAssEntrys_temperatureTo_TextField.setVisible(true);
        kdtAssEntrys_temperatureTo_TextField.setEditable(true);
        kdtAssEntrys_temperatureTo_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_temperatureTo_TextField.setDataType(1);
        	kdtAssEntrys_temperatureTo_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtAssEntrys_temperatureTo_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtAssEntrys_temperatureTo_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtAssEntrys_temperatureTo_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_temperatureTo_TextField);
        this.kdtAssEntrys.getColumn("temperatureTo").setEditor(kdtAssEntrys_temperatureTo_CellEditor);
        KDFormattedTextField kdtAssEntrys_temperatureFrom_TextField = new KDFormattedTextField();
        kdtAssEntrys_temperatureFrom_TextField.setName("kdtAssEntrys_temperatureFrom_TextField");
        kdtAssEntrys_temperatureFrom_TextField.setVisible(true);
        kdtAssEntrys_temperatureFrom_TextField.setEditable(true);
        kdtAssEntrys_temperatureFrom_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_temperatureFrom_TextField.setDataType(1);
        	kdtAssEntrys_temperatureFrom_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtAssEntrys_temperatureFrom_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtAssEntrys_temperatureFrom_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtAssEntrys_temperatureFrom_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_temperatureFrom_TextField);
        this.kdtAssEntrys.getColumn("temperatureFrom").setEditor(kdtAssEntrys_temperatureFrom_CellEditor);
        KDFormattedTextField kdtAssEntrys_humidityTo_TextField = new KDFormattedTextField();
        kdtAssEntrys_humidityTo_TextField.setName("kdtAssEntrys_humidityTo_TextField");
        kdtAssEntrys_humidityTo_TextField.setVisible(true);
        kdtAssEntrys_humidityTo_TextField.setEditable(true);
        kdtAssEntrys_humidityTo_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_humidityTo_TextField.setDataType(1);
        	kdtAssEntrys_humidityTo_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtAssEntrys_humidityTo_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtAssEntrys_humidityTo_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtAssEntrys_humidityTo_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_humidityTo_TextField);
        this.kdtAssEntrys.getColumn("humidityTo").setEditor(kdtAssEntrys_humidityTo_CellEditor);
        KDFormattedTextField kdtAssEntrys_humidityFrom_TextField = new KDFormattedTextField();
        kdtAssEntrys_humidityFrom_TextField.setName("kdtAssEntrys_humidityFrom_TextField");
        kdtAssEntrys_humidityFrom_TextField.setVisible(true);
        kdtAssEntrys_humidityFrom_TextField.setEditable(true);
        kdtAssEntrys_humidityFrom_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_humidityFrom_TextField.setDataType(1);
        	kdtAssEntrys_humidityFrom_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtAssEntrys_humidityFrom_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtAssEntrys_humidityFrom_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtAssEntrys_humidityFrom_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_humidityFrom_TextField);
        this.kdtAssEntrys.getColumn("humidityFrom").setEditor(kdtAssEntrys_humidityFrom_CellEditor);
        KDFormattedTextField kdtAssEntrys_cullQty_TextField = new KDFormattedTextField();
        kdtAssEntrys_cullQty_TextField.setName("kdtAssEntrys_cullQty_TextField");
        kdtAssEntrys_cullQty_TextField.setVisible(true);
        kdtAssEntrys_cullQty_TextField.setEditable(true);
        kdtAssEntrys_cullQty_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_cullQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_cullQty_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_cullQty_TextField);
        this.kdtAssEntrys.getColumn("cullQty").setEditor(kdtAssEntrys_cullQty_CellEditor);
        KDFormattedTextField kdtAssEntrys_deathQty_TextField = new KDFormattedTextField();
        kdtAssEntrys_deathQty_TextField.setName("kdtAssEntrys_deathQty_TextField");
        kdtAssEntrys_deathQty_TextField.setVisible(true);
        kdtAssEntrys_deathQty_TextField.setEditable(true);
        kdtAssEntrys_deathQty_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_deathQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_deathQty_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_deathQty_TextField);
        this.kdtAssEntrys.getColumn("deathQty").setEditor(kdtAssEntrys_deathQty_CellEditor);
        KDFormattedTextField kdtAssEntrys_breekingStock_TextField = new KDFormattedTextField();
        kdtAssEntrys_breekingStock_TextField.setName("kdtAssEntrys_breekingStock_TextField");
        kdtAssEntrys_breekingStock_TextField.setVisible(true);
        kdtAssEntrys_breekingStock_TextField.setEditable(true);
        kdtAssEntrys_breekingStock_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_breekingStock_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_breekingStock_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_breekingStock_TextField);
        this.kdtAssEntrys.getColumn("breekingStock").setEditor(kdtAssEntrys_breekingStock_CellEditor);
        KDCheckBox kdtAssEntrys_isMarketed_CheckBox = new KDCheckBox();
        kdtAssEntrys_isMarketed_CheckBox.setName("kdtAssEntrys_isMarketed_CheckBox");
        KDTDefaultCellEditor kdtAssEntrys_isMarketed_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_isMarketed_CheckBox);
        this.kdtAssEntrys.getColumn("isMarketed").setEditor(kdtAssEntrys_isMarketed_CellEditor);
        KDFormattedTextField kdtAssEntrys_marketQty_TextField = new KDFormattedTextField();
        kdtAssEntrys_marketQty_TextField.setName("kdtAssEntrys_marketQty_TextField");
        kdtAssEntrys_marketQty_TextField.setVisible(true);
        kdtAssEntrys_marketQty_TextField.setEditable(true);
        kdtAssEntrys_marketQty_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_marketQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_marketQty_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_marketQty_TextField);
        this.kdtAssEntrys.getColumn("marketQty").setEditor(kdtAssEntrys_marketQty_CellEditor);
        // kdtImmuneEntrys
		String kdtImmuneEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"henhouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"vaccineMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"vaccineUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"vaccineGetQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"vaccineUsedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{henhouseName}</t:Cell><t:Cell>$Resource{vaccineMaterial}</t:Cell><t:Cell>$Resource{vaccineUnit}</t:Cell><t:Cell>$Resource{vaccineGetQty}</t:Cell><t:Cell>$Resource{vaccineUsedQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtImmuneEntrys.putBindContents("editData",new String[] {"seq","henhouse","henhouseName","vaccineMaterial","vaccineUnit","vaccineGetQty","vaccineUsedQty"});


        this.kdtImmuneEntrys.checkParsed();
        KDFormattedTextField kdtImmuneEntrys_seq_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_seq_TextField.setName("kdtImmuneEntrys_seq_TextField");
        kdtImmuneEntrys_seq_TextField.setVisible(true);
        kdtImmuneEntrys_seq_TextField.setEditable(true);
        kdtImmuneEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtImmuneEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_seq_TextField);
        this.kdtImmuneEntrys.getColumn("seq").setEditor(kdtImmuneEntrys_seq_CellEditor);
        final KDBizPromptBox kdtImmuneEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtImmuneEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtImmuneEntrys_henhouse_PromptBox.setVisible(true);
        kdtImmuneEntrys_henhouse_PromptBox.setEditable(true);
        kdtImmuneEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtImmuneEntrys_henhouse_PromptBox.setEditFormat("$number$");
        kdtImmuneEntrys_henhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtImmuneEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_henhouse_PromptBox);
        this.kdtImmuneEntrys.getColumn("henhouse").setEditor(kdtImmuneEntrys_henhouse_CellEditor);
        ObjectValueRender kdtImmuneEntrys_henhouse_OVR = new ObjectValueRender();
        kdtImmuneEntrys_henhouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtImmuneEntrys.getColumn("henhouse").setRenderer(kdtImmuneEntrys_henhouse_OVR);
        KDTextField kdtImmuneEntrys_henhouseName_TextField = new KDTextField();
        kdtImmuneEntrys_henhouseName_TextField.setName("kdtImmuneEntrys_henhouseName_TextField");
        kdtImmuneEntrys_henhouseName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtImmuneEntrys_henhouseName_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_henhouseName_TextField);
        this.kdtImmuneEntrys.getColumn("henhouseName").setEditor(kdtImmuneEntrys_henhouseName_CellEditor);
        final KDBizPromptBox kdtImmuneEntrys_vaccineMaterial_PromptBox = new KDBizPromptBox();
        kdtImmuneEntrys_vaccineMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtImmuneEntrys_vaccineMaterial_PromptBox.setVisible(true);
        kdtImmuneEntrys_vaccineMaterial_PromptBox.setEditable(true);
        kdtImmuneEntrys_vaccineMaterial_PromptBox.setDisplayFormat("$number$");
        kdtImmuneEntrys_vaccineMaterial_PromptBox.setEditFormat("$number$");
        kdtImmuneEntrys_vaccineMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtImmuneEntrys_vaccineMaterial_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_vaccineMaterial_PromptBox);
        this.kdtImmuneEntrys.getColumn("vaccineMaterial").setEditor(kdtImmuneEntrys_vaccineMaterial_CellEditor);
        ObjectValueRender kdtImmuneEntrys_vaccineMaterial_OVR = new ObjectValueRender();
        kdtImmuneEntrys_vaccineMaterial_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtImmuneEntrys.getColumn("vaccineMaterial").setRenderer(kdtImmuneEntrys_vaccineMaterial_OVR);
        KDTextField kdtImmuneEntrys_vaccineUnit_TextField = new KDTextField();
        kdtImmuneEntrys_vaccineUnit_TextField.setName("kdtImmuneEntrys_vaccineUnit_TextField");
        kdtImmuneEntrys_vaccineUnit_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtImmuneEntrys_vaccineUnit_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_vaccineUnit_TextField);
        this.kdtImmuneEntrys.getColumn("vaccineUnit").setEditor(kdtImmuneEntrys_vaccineUnit_CellEditor);
        KDFormattedTextField kdtImmuneEntrys_vaccineGetQty_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_vaccineGetQty_TextField.setName("kdtImmuneEntrys_vaccineGetQty_TextField");
        kdtImmuneEntrys_vaccineGetQty_TextField.setVisible(true);
        kdtImmuneEntrys_vaccineGetQty_TextField.setEditable(true);
        kdtImmuneEntrys_vaccineGetQty_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_vaccineGetQty_TextField.setDataType(1);
        	kdtImmuneEntrys_vaccineGetQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtImmuneEntrys_vaccineGetQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtImmuneEntrys_vaccineGetQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtImmuneEntrys_vaccineGetQty_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_vaccineGetQty_TextField);
        this.kdtImmuneEntrys.getColumn("vaccineGetQty").setEditor(kdtImmuneEntrys_vaccineGetQty_CellEditor);
        KDFormattedTextField kdtImmuneEntrys_vaccineUsedQty_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_vaccineUsedQty_TextField.setName("kdtImmuneEntrys_vaccineUsedQty_TextField");
        kdtImmuneEntrys_vaccineUsedQty_TextField.setVisible(true);
        kdtImmuneEntrys_vaccineUsedQty_TextField.setEditable(true);
        kdtImmuneEntrys_vaccineUsedQty_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_vaccineUsedQty_TextField.setDataType(1);
        	kdtImmuneEntrys_vaccineUsedQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtImmuneEntrys_vaccineUsedQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtImmuneEntrys_vaccineUsedQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtImmuneEntrys_vaccineUsedQty_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_vaccineUsedQty_TextField);
        this.kdtImmuneEntrys.getColumn("vaccineUsedQty").setEditor(kdtImmuneEntrys_vaccineUsedQty_CellEditor);
        // kdtFodderEntrys
		String kdtFodderEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"fodderTower\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"fodderTowerName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"towerInventory\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"fodderMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"fodderMaterialName\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"fodderMaterialModel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"fodderDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"fodderQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"fodderDesc\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{fodderTower}</t:Cell><t:Cell>$Resource{fodderTowerName}</t:Cell><t:Cell>$Resource{towerInventory}</t:Cell><t:Cell>$Resource{fodderMaterial}</t:Cell><t:Cell>$Resource{fodderMaterialName}</t:Cell><t:Cell>$Resource{fodderMaterialModel}</t:Cell><t:Cell>$Resource{fodderDate}</t:Cell><t:Cell>$Resource{fodderQty}</t:Cell><t:Cell>$Resource{fodderDesc}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFodderEntrys.setFormatXml(resHelper.translateString("kdtFodderEntrys",kdtFodderEntrysStrXML));
        kdtFodderEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtFodderEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtFodderEntrys.putBindContents("editData",new String[] {"seq","fodderTower","fodderTowerName","towerInventory","fodderMaterial","fodderMaterialName","fodderMaterialModel","fodderDate","fodderQty","fodderDesc"});


        this.kdtFodderEntrys.checkParsed();
        KDFormattedTextField kdtFodderEntrys_seq_TextField = new KDFormattedTextField();
        kdtFodderEntrys_seq_TextField.setName("kdtFodderEntrys_seq_TextField");
        kdtFodderEntrys_seq_TextField.setVisible(true);
        kdtFodderEntrys_seq_TextField.setEditable(true);
        kdtFodderEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtFodderEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFodderEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_seq_TextField);
        this.kdtFodderEntrys.getColumn("seq").setEditor(kdtFodderEntrys_seq_CellEditor);
        final KDBizPromptBox kdtFodderEntrys_fodderTower_PromptBox = new KDBizPromptBox();
        kdtFodderEntrys_fodderTower_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtFodderEntrys_fodderTower_PromptBox.setVisible(true);
        kdtFodderEntrys_fodderTower_PromptBox.setEditable(true);
        kdtFodderEntrys_fodderTower_PromptBox.setDisplayFormat("$number$");
        kdtFodderEntrys_fodderTower_PromptBox.setEditFormat("$number$");
        kdtFodderEntrys_fodderTower_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFodderEntrys_fodderTower_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderTower_PromptBox);
        this.kdtFodderEntrys.getColumn("fodderTower").setEditor(kdtFodderEntrys_fodderTower_CellEditor);
        ObjectValueRender kdtFodderEntrys_fodderTower_OVR = new ObjectValueRender();
        kdtFodderEntrys_fodderTower_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtFodderEntrys.getColumn("fodderTower").setRenderer(kdtFodderEntrys_fodderTower_OVR);
        KDTextField kdtFodderEntrys_fodderTowerName_TextField = new KDTextField();
        kdtFodderEntrys_fodderTowerName_TextField.setName("kdtFodderEntrys_fodderTowerName_TextField");
        kdtFodderEntrys_fodderTowerName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtFodderEntrys_fodderTowerName_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderTowerName_TextField);
        this.kdtFodderEntrys.getColumn("fodderTowerName").setEditor(kdtFodderEntrys_fodderTowerName_CellEditor);
        KDFormattedTextField kdtFodderEntrys_towerInventory_TextField = new KDFormattedTextField();
        kdtFodderEntrys_towerInventory_TextField.setName("kdtFodderEntrys_towerInventory_TextField");
        kdtFodderEntrys_towerInventory_TextField.setVisible(true);
        kdtFodderEntrys_towerInventory_TextField.setEditable(true);
        kdtFodderEntrys_towerInventory_TextField.setHorizontalAlignment(2);
        kdtFodderEntrys_towerInventory_TextField.setDataType(1);
        	kdtFodderEntrys_towerInventory_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtFodderEntrys_towerInventory_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtFodderEntrys_towerInventory_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtFodderEntrys_towerInventory_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_towerInventory_TextField);
        this.kdtFodderEntrys.getColumn("towerInventory").setEditor(kdtFodderEntrys_towerInventory_CellEditor);
        final KDBizPromptBox kdtFodderEntrys_fodderMaterial_PromptBox = new KDBizPromptBox();
        kdtFodderEntrys_fodderMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtFodderEntrys_fodderMaterial_PromptBox.setVisible(true);
        kdtFodderEntrys_fodderMaterial_PromptBox.setEditable(true);
        kdtFodderEntrys_fodderMaterial_PromptBox.setDisplayFormat("$number$");
        kdtFodderEntrys_fodderMaterial_PromptBox.setEditFormat("$number$");
        kdtFodderEntrys_fodderMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFodderEntrys_fodderMaterial_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderMaterial_PromptBox);
        this.kdtFodderEntrys.getColumn("fodderMaterial").setEditor(kdtFodderEntrys_fodderMaterial_CellEditor);
        ObjectValueRender kdtFodderEntrys_fodderMaterial_OVR = new ObjectValueRender();
        kdtFodderEntrys_fodderMaterial_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtFodderEntrys.getColumn("fodderMaterial").setRenderer(kdtFodderEntrys_fodderMaterial_OVR);
        KDTextField kdtFodderEntrys_fodderMaterialName_TextField = new KDTextField();
        kdtFodderEntrys_fodderMaterialName_TextField.setName("kdtFodderEntrys_fodderMaterialName_TextField");
        kdtFodderEntrys_fodderMaterialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtFodderEntrys_fodderMaterialName_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderMaterialName_TextField);
        this.kdtFodderEntrys.getColumn("fodderMaterialName").setEditor(kdtFodderEntrys_fodderMaterialName_CellEditor);
        KDTextField kdtFodderEntrys_fodderMaterialModel_TextField = new KDTextField();
        kdtFodderEntrys_fodderMaterialModel_TextField.setName("kdtFodderEntrys_fodderMaterialModel_TextField");
        kdtFodderEntrys_fodderMaterialModel_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtFodderEntrys_fodderMaterialModel_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderMaterialModel_TextField);
        this.kdtFodderEntrys.getColumn("fodderMaterialModel").setEditor(kdtFodderEntrys_fodderMaterialModel_CellEditor);
        KDDatePicker kdtFodderEntrys_fodderDate_DatePicker = new KDDatePicker();
        kdtFodderEntrys_fodderDate_DatePicker.setName("kdtFodderEntrys_fodderDate_DatePicker");
        kdtFodderEntrys_fodderDate_DatePicker.setVisible(true);
        kdtFodderEntrys_fodderDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtFodderEntrys_fodderDate_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderDate_DatePicker);
        this.kdtFodderEntrys.getColumn("fodderDate").setEditor(kdtFodderEntrys_fodderDate_CellEditor);
        KDFormattedTextField kdtFodderEntrys_fodderQty_TextField = new KDFormattedTextField();
        kdtFodderEntrys_fodderQty_TextField.setName("kdtFodderEntrys_fodderQty_TextField");
        kdtFodderEntrys_fodderQty_TextField.setVisible(true);
        kdtFodderEntrys_fodderQty_TextField.setEditable(true);
        kdtFodderEntrys_fodderQty_TextField.setHorizontalAlignment(2);
        kdtFodderEntrys_fodderQty_TextField.setDataType(1);
        	kdtFodderEntrys_fodderQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtFodderEntrys_fodderQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtFodderEntrys_fodderQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtFodderEntrys_fodderQty_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderQty_TextField);
        this.kdtFodderEntrys.getColumn("fodderQty").setEditor(kdtFodderEntrys_fodderQty_CellEditor);
        KDTextField kdtFodderEntrys_fodderDesc_TextField = new KDTextField();
        kdtFodderEntrys_fodderDesc_TextField.setName("kdtFodderEntrys_fodderDesc_TextField");
        kdtFodderEntrys_fodderDesc_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtFodderEntrys_fodderDesc_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderDesc_TextField);
        this.kdtFodderEntrys.getColumn("fodderDesc").setEditor(kdtFodderEntrys_fodderDesc_CellEditor);
        // contbreedLog		
        this.contbreedLog.setBoundLabelText(resHelper.getString("contbreedLog.boundLabelText"));		
        this.contbreedLog.setBoundLabelLength(0);		
        this.contbreedLog.setBoundLabelUnderline(true);		
        this.contbreedLog.setVisible(true);
        // scrollPanebreedLog
        // txtbreedLog		
        this.txtbreedLog.setRequired(false);		
        this.txtbreedLog.setMaxLength(2000);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(true);		
        this.baseStatus.setEnabled(false);
        // txtoutSideTFrom		
        this.txtoutSideTFrom.setHorizontalAlignment(2);		
        this.txtoutSideTFrom.setDataType(1);		
        this.txtoutSideTFrom.setSupportedEmpty(true);		
        this.txtoutSideTFrom.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtoutSideTFrom.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtoutSideTFrom.setPrecision(2);		
        this.txtoutSideTFrom.setRequired(false);
        // txtoutSideTTo		
        this.txtoutSideTTo.setHorizontalAlignment(2);		
        this.txtoutSideTTo.setDataType(1);		
        this.txtoutSideTTo.setSupportedEmpty(true);		
        this.txtoutSideTTo.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtoutSideTTo.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtoutSideTTo.setPrecision(2);		
        this.txtoutSideTTo.setRequired(false);
        // txtweather		
        this.txtweather.setHorizontalAlignment(2);		
        this.txtweather.setMaxLength(200);		
        this.txtweather.setRequired(false);
        // txtoutHumidityFrom		
        this.txtoutHumidityFrom.setHorizontalAlignment(2);		
        this.txtoutHumidityFrom.setDataType(1);		
        this.txtoutHumidityFrom.setSupportedEmpty(true);		
        this.txtoutHumidityFrom.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtoutHumidityFrom.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtoutHumidityFrom.setPrecision(2);		
        this.txtoutHumidityFrom.setRequired(false);
        // txtoutHumidityTo		
        this.txtoutHumidityTo.setHorizontalAlignment(2);		
        this.txtoutHumidityTo.setDataType(1);		
        this.txtoutHumidityTo.setSupportedEmpty(true);		
        this.txtoutHumidityTo.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtoutHumidityTo.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtoutHumidityTo.setPrecision(2);		
        this.txtoutHumidityTo.setRequired(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // txtfuel		
        this.txtfuel.setHorizontalAlignment(2);		
        this.txtfuel.setDataType(1);		
        this.txtfuel.setSupportedEmpty(true);		
        this.txtfuel.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtfuel.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtfuel.setPrecision(2);		
        this.txtfuel.setRequired(false);		
        this.txtfuel.setEnabled(false);		
        this.txtfuel.setVisible(false);
        // txtweek		
        this.txtweek.setHorizontalAlignment(2);		
        this.txtweek.setDataType(0);		
        this.txtweek.setSupportedEmpty(true);		
        this.txtweek.setRequired(false);		
        this.txtweek.setEnabled(false);
        // txtweekDay		
        this.txtweekDay.setHorizontalAlignment(2);		
        this.txtweekDay.setDataType(0);		
        this.txtweekDay.setSupportedEmpty(true);		
        this.txtweekDay.setRequired(false);		
        this.txtweekDay.setEnabled(false);
        // prmtstoOrg		
        this.prmtstoOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstoOrg.setEditable(true);		
        this.prmtstoOrg.setDisplayFormat("$name$");		
        this.prmtstoOrg.setEditFormat("$number$");		
        this.prmtstoOrg.setCommitFormat("$number$");		
        this.prmtstoOrg.setRequired(true);		
        this.prmtstoOrg.setEnabled(false);
        // prmtbreedBatch		
        this.prmtbreedBatch.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedBatchF7Query");		
        this.prmtbreedBatch.setEditable(true);		
        this.prmtbreedBatch.setDisplayFormat("$number$");		
        this.prmtbreedBatch.setEditFormat("$number$");		
        this.prmtbreedBatch.setCommitFormat("$number$");		
        this.prmtbreedBatch.setRequired(true);
        prmtbreedBatch.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtbreedBatch_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        this.prmtbreedBatch.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtbreedBatch_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtcostObject		
        this.txtcostObject.setHorizontalAlignment(2);		
        this.txtcostObject.setMaxLength(80);		
        this.txtcostObject.setRequired(false);		
        this.txtcostObject.setEnabled(false);
        // txtelectricityQty		
        this.txtelectricityQty.setHorizontalAlignment(2);		
        this.txtelectricityQty.setDataType(1);		
        this.txtelectricityQty.setSupportedEmpty(true);		
        this.txtelectricityQty.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtelectricityQty.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtelectricityQty.setPrecision(2);		
        this.txtelectricityQty.setRequired(false);
        // txtcoalFual		
        this.txtcoalFual.setHorizontalAlignment(2);		
        this.txtcoalFual.setDataType(1);		
        this.txtcoalFual.setSupportedEmpty(true);		
        this.txtcoalFual.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcoalFual.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcoalFual.setPrecision(2);		
        this.txtcoalFual.setRequired(false);
        // txtdieselFual		
        this.txtdieselFual.setHorizontalAlignment(2);		
        this.txtdieselFual.setDataType(1);		
        this.txtdieselFual.setSupportedEmpty(true);		
        this.txtdieselFual.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtdieselFual.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtdieselFual.setPrecision(2);		
        this.txtdieselFual.setRequired(false);
        // txtinitPersonQty		
        this.txtinitPersonQty.setHorizontalAlignment(2);		
        this.txtinitPersonQty.setDataType(0);		
        this.txtinitPersonQty.setSupportedEmpty(true);		
        this.txtinitPersonQty.setRequired(true);
        // txtentryPersonQty		
        this.txtentryPersonQty.setHorizontalAlignment(2);		
        this.txtentryPersonQty.setDataType(0);		
        this.txtentryPersonQty.setSupportedEmpty(true);		
        this.txtentryPersonQty.setRequired(false);
        // txtleavePersonQty		
        this.txtleavePersonQty.setHorizontalAlignment(2);		
        this.txtleavePersonQty.setDataType(0);		
        this.txtleavePersonQty.setSupportedEmpty(true);		
        this.txtleavePersonQty.setRequired(false);
        // txtattendPersonQty		
        this.txtattendPersonQty.setHorizontalAlignment(2);		
        this.txtattendPersonQty.setDataType(0);		
        this.txtattendPersonQty.setSupportedEmpty(true);		
        this.txtattendPersonQty.setRequired(true);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnGenNextBill
        this.btnGenNextBill.setAction((IItemAction)ActionProxyFactory.getProxy(actionGenNextBill, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnGenNextBill.setText(resHelper.getString("btnGenNextBill.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,baseStatus,txtoutSideTFrom,txtoutSideTTo,txtweather,txtoutHumidityFrom,txtoutHumidityTo,pkauditTime,txtfuel,txtbreedLog,txtweek,txtweekDay,prmtstoOrg,prmtbreedBatch,txtcostObject,txtelectricityQty,txtcoalFual,txtdieselFual,txtinitPersonQty,txtentryPersonQty,txtleavePersonQty,txtattendPersonQty,kdtAssEntrys,kdtEntrys,kdtImmuneEntrys,kdtFodderEntrys}));
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
        contCreator.setBounds(new Rectangle(12, 563, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(12, 563, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(12, 592, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(12, 592, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(368, 563, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(368, 563, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(368, 592, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(368, 592, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(12, 16, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(12, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(724, 68, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(724, 68, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(368, 172, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(368, 172, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(724, 563, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(724, 563, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        paneBIZLayerControl17.setBounds(new Rectangle(15, 203, 993, 349));
        this.add(paneBIZLayerControl17, new KDLayout.Constraints(15, 203, 993, 349, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(724, 42, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(724, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contoutSideTFrom.setBounds(new Rectangle(12, 42, 270, 19));
        this.add(contoutSideTFrom, new KDLayout.Constraints(12, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutSideTTo.setBounds(new Rectangle(368, 42, 270, 19));
        this.add(contoutSideTTo, new KDLayout.Constraints(368, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweather.setBounds(new Rectangle(12, 94, 270, 19));
        this.add(contweather, new KDLayout.Constraints(12, 94, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutHumidityFrom.setBounds(new Rectangle(12, 68, 270, 19));
        this.add(contoutHumidityFrom, new KDLayout.Constraints(12, 68, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutHumidityTo.setBounds(new Rectangle(368, 68, 270, 19));
        this.add(contoutHumidityTo, new KDLayout.Constraints(368, 68, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(724, 592, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(724, 592, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfuel.setBounds(new Rectangle(380, -149, 270, 19));
        this.add(contfuel, new KDLayout.Constraints(380, -149, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweek.setBounds(new Rectangle(12, 119, 151, 19));
        this.add(contweek, new KDLayout.Constraints(12, 119, 151, 19, 0));
        contweekDay.setBounds(new Rectangle(201, 119, 53, 19));
        this.add(contweekDay, new KDLayout.Constraints(201, 119, 53, 19, 0));
        kDLabel1.setBounds(new Rectangle(171, 119, 26, 19));
        this.add(kDLabel1, new KDLayout.Constraints(171, 119, 26, 19, 0));
        kDLabel2.setBounds(new Rectangle(258, 119, 26, 19));
        this.add(kDLabel2, new KDLayout.Constraints(258, 119, 26, 19, 0));
        contstoOrg.setBounds(new Rectangle(368, 119, 270, 19));
        this.add(contstoOrg, new KDLayout.Constraints(368, 119, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedBatch.setBounds(new Rectangle(368, 16, 270, 19));
        this.add(contbreedBatch, new KDLayout.Constraints(368, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcostObject.setBounds(new Rectangle(724, 16, 270, 19));
        this.add(contcostObject, new KDLayout.Constraints(724, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contelectricityQty.setBounds(new Rectangle(724, 119, 270, 19));
        this.add(contelectricityQty, new KDLayout.Constraints(724, 119, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcoalFual.setBounds(new Rectangle(368, 95, 270, 19));
        this.add(contcoalFual, new KDLayout.Constraints(368, 95, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdieselFual.setBounds(new Rectangle(724, 95, 270, 19));
        this.add(contdieselFual, new KDLayout.Constraints(724, 95, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        continitPersonQty.setBounds(new Rectangle(12, 145, 270, 19));
        this.add(continitPersonQty, new KDLayout.Constraints(12, 145, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contentryPersonQty.setBounds(new Rectangle(368, 145, 270, 19));
        this.add(contentryPersonQty, new KDLayout.Constraints(368, 145, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contleavePersonQty.setBounds(new Rectangle(724, 145, 270, 19));
        this.add(contleavePersonQty, new KDLayout.Constraints(724, 145, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contattendPersonQty.setBounds(new Rectangle(12, 172, 270, 19));
        this.add(contattendPersonQty, new KDLayout.Constraints(12, 172, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //paneBIZLayerControl17
        paneBIZLayerControl17.add(baseTab, resHelper.getString("baseTab.constraints"));
        paneBIZLayerControl17.add(assTab, resHelper.getString("assTab.constraints"));
        paneBIZLayerControl17.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        paneBIZLayerControl17.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        paneBIZLayerControl17.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        //baseTab
        baseTab.setLayout(new KDLayout());
        baseTab.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 316));        kdtEntrys.setBounds(new Rectangle(1, 1, 982, 315));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.breed.brood.BroodDailyEntryInfo(),null,false);
        baseTab.add(kdtEntrys_detailPanel, new KDLayout.Constraints(1, 1, 982, 315, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //assTab
        assTab.setLayout(new KDLayout());
        assTab.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 316));        kdtAssEntrys.setBounds(new Rectangle(1, 1, 979, 315));
        kdtAssEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtAssEntrys,new com.kingdee.eas.farm.breed.brood.BroodDailyAssEntryInfo(),null,false);
        assTab.add(kdtAssEntrys_detailPanel, new KDLayout.Constraints(1, 1, 979, 315, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 316));        kdtImmuneEntrys.setBounds(new Rectangle(0, 0, 987, 317));
        kdtImmuneEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtImmuneEntrys,new com.kingdee.eas.farm.breed.brood.BroodDailyImmuneEntryInfo(),null,false);
        kDPanel1.add(kdtImmuneEntrys_detailPanel, new KDLayout.Constraints(0, 0, 987, 317, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 316));        kdtFodderEntrys.setBounds(new Rectangle(1, 2, 989, 314));
        kdtFodderEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFodderEntrys,new com.kingdee.eas.farm.breed.brood.BroodDailyFodderEntryInfo(),null,false);
        kDPanel2.add(kdtFodderEntrys_detailPanel, new KDLayout.Constraints(1, 2, 989, 314, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 316));        contbreedLog.setBounds(new Rectangle(-1, 0, 983, 316));
        kDPanel4.add(contbreedLog, new KDLayout.Constraints(-1, 0, 983, 316, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contbreedLog
        contbreedLog.setBoundEditor(scrollPanebreedLog);
        //scrollPanebreedLog
        scrollPanebreedLog.getViewport().add(txtbreedLog, null);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contoutSideTFrom
        contoutSideTFrom.setBoundEditor(txtoutSideTFrom);
        //contoutSideTTo
        contoutSideTTo.setBoundEditor(txtoutSideTTo);
        //contweather
        contweather.setBoundEditor(txtweather);
        //contoutHumidityFrom
        contoutHumidityFrom.setBoundEditor(txtoutHumidityFrom);
        //contoutHumidityTo
        contoutHumidityTo.setBoundEditor(txtoutHumidityTo);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contfuel
        contfuel.setBoundEditor(txtfuel);
        //contweek
        contweek.setBoundEditor(txtweek);
        //contweekDay
        contweekDay.setBoundEditor(txtweekDay);
        //contstoOrg
        contstoOrg.setBoundEditor(prmtstoOrg);
        //contbreedBatch
        contbreedBatch.setBoundEditor(prmtbreedBatch);
        //contcostObject
        contcostObject.setBoundEditor(txtcostObject);
        //contelectricityQty
        contelectricityQty.setBoundEditor(txtelectricityQty);
        //contcoalFual
        contcoalFual.setBoundEditor(txtcoalFual);
        //contdieselFual
        contdieselFual.setBoundEditor(txtdieselFual);
        //continitPersonQty
        continitPersonQty.setBoundEditor(txtinitPersonQty);
        //contentryPersonQty
        contentryPersonQty.setBoundEditor(txtentryPersonQty);
        //contleavePersonQty
        contleavePersonQty.setBoundEditor(txtleavePersonQty);
        //contattendPersonQty
        contattendPersonQty.setBoundEditor(txtattendPersonQty);

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
        this.toolBar.add(btnGenNextBill);


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
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.breed.brood.BroodDailyEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.materialName", String.class, this.kdtEntrys, "materialName.text");
		dataBinder.registerBinding("entrys.dailyQtyAll", java.math.BigDecimal.class, this.kdtEntrys, "dailyQtyAll.text");
		dataBinder.registerBinding("entrys.henhouse", java.lang.Object.class, this.kdtEntrys, "henhouse.text");
		dataBinder.registerBinding("entrys.waterQty", java.math.BigDecimal.class, this.kdtEntrys, "waterQty.text");
		dataBinder.registerBinding("entrys.henhouseName", String.class, this.kdtEntrys, "henhouseName.text");
		dataBinder.registerBinding("entrys.averageWeight", java.math.BigDecimal.class, this.kdtEntrys, "averageWeight.text");
		dataBinder.registerBinding("entrys.limitFeedType", String.class, this.kdtEntrys, "limitFeedType.text");
		dataBinder.registerBinding("entrys.materialModel", String.class, this.kdtEntrys, "materialModel.text");
		dataBinder.registerBinding("AssEntrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtAssEntrys, "id.text");
		dataBinder.registerBinding("AssEntrys", com.kingdee.eas.farm.breed.brood.BroodDailyAssEntryInfo.class, this.kdtAssEntrys, "userObject");
		dataBinder.registerBinding("AssEntrys.breedTime", java.math.BigDecimal.class, this.kdtAssEntrys, "breedTime.text");
		dataBinder.registerBinding("AssEntrys.lightingTime", java.math.BigDecimal.class, this.kdtAssEntrys, "lightingTime.text");
		dataBinder.registerBinding("AssEntrys.temperatureTo", java.math.BigDecimal.class, this.kdtAssEntrys, "temperatureTo.text");
		dataBinder.registerBinding("AssEntrys.temperatureFrom", java.math.BigDecimal.class, this.kdtAssEntrys, "temperatureFrom.text");
		dataBinder.registerBinding("AssEntrys.humidityTo", java.math.BigDecimal.class, this.kdtAssEntrys, "humidityTo.text");
		dataBinder.registerBinding("AssEntrys.humidityFrom", java.math.BigDecimal.class, this.kdtAssEntrys, "humidityFrom.text");
		dataBinder.registerBinding("AssEntrys.henhouse", java.lang.Object.class, this.kdtAssEntrys, "henhouse.text");
		dataBinder.registerBinding("AssEntrys.henhouseName", String.class, this.kdtAssEntrys, "henhouseName.text");
		dataBinder.registerBinding("AssEntrys.deathQty", int.class, this.kdtAssEntrys, "deathQty.text");
		dataBinder.registerBinding("AssEntrys.cullQty", int.class, this.kdtAssEntrys, "cullQty.text");
		dataBinder.registerBinding("AssEntrys.breekingStock", int.class, this.kdtAssEntrys, "breekingStock.text");
		dataBinder.registerBinding("AssEntrys.isMarketed", boolean.class, this.kdtAssEntrys, "isMarketed.text");
		dataBinder.registerBinding("AssEntrys.marketQty", int.class, this.kdtAssEntrys, "marketQty.text");
		dataBinder.registerBinding("ImmuneEntrys.seq", int.class, this.kdtImmuneEntrys, "seq.text");
		dataBinder.registerBinding("ImmuneEntrys", com.kingdee.eas.farm.breed.brood.BroodDailyImmuneEntryInfo.class, this.kdtImmuneEntrys, "userObject");
		dataBinder.registerBinding("ImmuneEntrys.henhouse", java.lang.Object.class, this.kdtImmuneEntrys, "henhouse.text");
		dataBinder.registerBinding("ImmuneEntrys.henhouseName", String.class, this.kdtImmuneEntrys, "henhouseName.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineMaterial", java.lang.Object.class, this.kdtImmuneEntrys, "vaccineMaterial.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineGetQty", java.math.BigDecimal.class, this.kdtImmuneEntrys, "vaccineGetQty.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineUsedQty", java.math.BigDecimal.class, this.kdtImmuneEntrys, "vaccineUsedQty.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineUnit", String.class, this.kdtImmuneEntrys, "vaccineUnit.text");
		dataBinder.registerBinding("FodderEntrys.seq", int.class, this.kdtFodderEntrys, "seq.text");
		dataBinder.registerBinding("FodderEntrys", com.kingdee.eas.farm.breed.brood.BroodDailyFodderEntryInfo.class, this.kdtFodderEntrys, "userObject");
		dataBinder.registerBinding("FodderEntrys.fodderTower", java.lang.Object.class, this.kdtFodderEntrys, "fodderTower.text");
		dataBinder.registerBinding("FodderEntrys.fodderMaterial", java.lang.Object.class, this.kdtFodderEntrys, "fodderMaterial.text");
		dataBinder.registerBinding("FodderEntrys.fodderMaterialName", String.class, this.kdtFodderEntrys, "fodderMaterialName.text");
		dataBinder.registerBinding("FodderEntrys.fodderMaterialModel", String.class, this.kdtFodderEntrys, "fodderMaterialModel.text");
		dataBinder.registerBinding("FodderEntrys.fodderDate", java.util.Date.class, this.kdtFodderEntrys, "fodderDate.text");
		dataBinder.registerBinding("FodderEntrys.fodderQty", java.math.BigDecimal.class, this.kdtFodderEntrys, "fodderQty.text");
		dataBinder.registerBinding("FodderEntrys.fodderDesc", String.class, this.kdtFodderEntrys, "fodderDesc.text");
		dataBinder.registerBinding("FodderEntrys.fodderTowerName", String.class, this.kdtFodderEntrys, "fodderTowerName.text");
		dataBinder.registerBinding("FodderEntrys.towerInventory", java.math.BigDecimal.class, this.kdtFodderEntrys, "towerInventory.text");
		dataBinder.registerBinding("breedLog", String.class, this.txtbreedLog, "text");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("outSideTFrom", java.math.BigDecimal.class, this.txtoutSideTFrom, "value");
		dataBinder.registerBinding("outSideTTo", java.math.BigDecimal.class, this.txtoutSideTTo, "value");
		dataBinder.registerBinding("weather", String.class, this.txtweather, "text");
		dataBinder.registerBinding("outHumidityFrom", java.math.BigDecimal.class, this.txtoutHumidityFrom, "value");
		dataBinder.registerBinding("outHumidityTo", java.math.BigDecimal.class, this.txtoutHumidityTo, "value");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("fuel", java.math.BigDecimal.class, this.txtfuel, "value");
		dataBinder.registerBinding("week", int.class, this.txtweek, "value");
		dataBinder.registerBinding("weekDay", int.class, this.txtweekDay, "value");
		dataBinder.registerBinding("stoOrg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstoOrg, "data");
		dataBinder.registerBinding("breedBatch", com.kingdee.eas.farm.breed.BreedBatchInfo.class, this.prmtbreedBatch, "data");
		dataBinder.registerBinding("costObject", String.class, this.txtcostObject, "text");
		dataBinder.registerBinding("electricityQty", java.math.BigDecimal.class, this.txtelectricityQty, "value");
		dataBinder.registerBinding("coalFual", java.math.BigDecimal.class, this.txtcoalFual, "value");
		dataBinder.registerBinding("dieselFual", java.math.BigDecimal.class, this.txtdieselFual, "value");
		dataBinder.registerBinding("initPersonQty", int.class, this.txtinitPersonQty, "value");
		dataBinder.registerBinding("entryPersonQty", int.class, this.txtentryPersonQty, "value");
		dataBinder.registerBinding("leavePersonQty", int.class, this.txtleavePersonQty, "value");
		dataBinder.registerBinding("attendPersonQty", int.class, this.txtattendPersonQty, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.breed.brood.app.BroodDailyEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.breed.brood.BroodDailyInfo)ov;
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
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dailyQtyAll", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.waterQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henhouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.averageWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.limitFeedType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialModel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.breedTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.lightingTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.temperatureTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.temperatureFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.humidityTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.humidityFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.henhouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.deathQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.cullQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.breekingStock", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.isMarketed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.marketQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.henhouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineGetQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineUsedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderTower", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderMaterialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderMaterialModel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderDesc", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderTowerName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.towerInventory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedLog", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outSideTFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outSideTTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weather", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outHumidityFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outHumidityTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fuel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weekDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stoOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("electricityQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coalFual", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dieselFual", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initPersonQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entryPersonQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("leavePersonQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("attendPersonQty", ValidateHelper.ON_SAVE);    		
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
     * output prmtbreedBatch_dataChanged method
     */
    protected void prmtbreedBatch_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("henhouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henhouse").getValue(),"warehouse.name")));

}

    if ("henhouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henhouse").getValue(),"warehouse.name")));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"materialModel").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"model")));

}


    }

    /**
     * output kdtAssEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtAssEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("henhouse".equalsIgnoreCase(kdtAssEntrys.getColumn(colIndex).getKey())) {
kdtAssEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtAssEntrys.getCell(rowIndex,"henhouse").getValue(),"warehouse.name")));

}

    if ("henhouse".equalsIgnoreCase(kdtAssEntrys.getColumn(colIndex).getKey())) {
kdtAssEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtAssEntrys.getCell(rowIndex,"henhouse").getValue(),"warehouse.name")));

}


    }

    /**
     * output kdtImmuneEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtImmuneEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("henhouse".equalsIgnoreCase(kdtImmuneEntrys.getColumn(colIndex).getKey())) {
kdtImmuneEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtImmuneEntrys.getCell(rowIndex,"henhouse").getValue(),"name")));

}

    if ("vaccineMaterial".equalsIgnoreCase(kdtImmuneEntrys.getColumn(colIndex).getKey())) {
kdtImmuneEntrys.getCell(rowIndex,"vaccineUnit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtImmuneEntrys.getCell(rowIndex,"vaccineMaterial").getValue(),"baseUnit.name")));

}


    }

    /**
     * output kdtFodderEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtFodderEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("fodderTower".equalsIgnoreCase(kdtFodderEntrys.getColumn(colIndex).getKey())) {
kdtFodderEntrys.getCell(rowIndex,"fodderTowerName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFodderEntrys.getCell(rowIndex,"fodderTower").getValue(),"name")));

}

    if ("fodderMaterial".equalsIgnoreCase(kdtFodderEntrys.getColumn(colIndex).getKey())) {
kdtFodderEntrys.getCell(rowIndex,"fodderMaterialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFodderEntrys.getCell(rowIndex,"fodderMaterial").getValue(),"name")));

}

    if ("fodderMaterial".equalsIgnoreCase(kdtFodderEntrys.getColumn(colIndex).getKey())) {
kdtFodderEntrys.getCell(rowIndex,"fodderMaterialModel").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFodderEntrys.getCell(rowIndex,"fodderMaterial").getValue(),"model")));

}


    }

    /**
     * output prmtbreedBatch_Changed() method
     */
    public void prmtbreedBatch_Changed() throws Exception
    {
        System.out.println("prmtbreedBatch_Changed() Function is executed!");
            txtcostObject.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbreedBatch.getData(),"costObject.name")));


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
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
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
    	sic.add(new SelectorItemInfo("entrys.dailyQtyAll"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.henhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.henhouse.id"));
			sic.add(new SelectorItemInfo("entrys.henhouse.number"));
			sic.add(new SelectorItemInfo("entrys.henhouse.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.waterQty"));
    	sic.add(new SelectorItemInfo("entrys.henhouseName"));
    	sic.add(new SelectorItemInfo("entrys.averageWeight"));
    	sic.add(new SelectorItemInfo("entrys.limitFeedType"));
    	sic.add(new SelectorItemInfo("entrys.materialModel"));
    	sic.add(new SelectorItemInfo("AssEntrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AssEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("AssEntrys.breedTime"));
    	sic.add(new SelectorItemInfo("AssEntrys.lightingTime"));
    	sic.add(new SelectorItemInfo("AssEntrys.temperatureTo"));
    	sic.add(new SelectorItemInfo("AssEntrys.temperatureFrom"));
    	sic.add(new SelectorItemInfo("AssEntrys.humidityTo"));
    	sic.add(new SelectorItemInfo("AssEntrys.humidityFrom"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AssEntrys.henhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AssEntrys.henhouse.id"));
			sic.add(new SelectorItemInfo("AssEntrys.henhouse.number"));
			sic.add(new SelectorItemInfo("AssEntrys.henhouse.name"));
		}
    	sic.add(new SelectorItemInfo("AssEntrys.henhouseName"));
    	sic.add(new SelectorItemInfo("AssEntrys.deathQty"));
    	sic.add(new SelectorItemInfo("AssEntrys.cullQty"));
    	sic.add(new SelectorItemInfo("AssEntrys.breekingStock"));
    	sic.add(new SelectorItemInfo("AssEntrys.isMarketed"));
    	sic.add(new SelectorItemInfo("AssEntrys.marketQty"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.henhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ImmuneEntrys.henhouse.id"));
			sic.add(new SelectorItemInfo("ImmuneEntrys.henhouse.number"));
			sic.add(new SelectorItemInfo("ImmuneEntrys.henhouse.name"));
		}
    	sic.add(new SelectorItemInfo("ImmuneEntrys.henhouseName"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineMaterial.id"));
			sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineMaterial.name"));
        	sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineMaterial.number"));
		}
    	sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineGetQty"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineUsedQty"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineUnit"));
    	sic.add(new SelectorItemInfo("FodderEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FodderEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FodderEntrys.fodderTower.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FodderEntrys.fodderTower.id"));
			sic.add(new SelectorItemInfo("FodderEntrys.fodderTower.name"));
        	sic.add(new SelectorItemInfo("FodderEntrys.fodderTower.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FodderEntrys.fodderMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FodderEntrys.fodderMaterial.id"));
			sic.add(new SelectorItemInfo("FodderEntrys.fodderMaterial.number"));
			sic.add(new SelectorItemInfo("FodderEntrys.fodderMaterial.name"));
		}
    	sic.add(new SelectorItemInfo("FodderEntrys.fodderMaterialName"));
    	sic.add(new SelectorItemInfo("FodderEntrys.fodderMaterialModel"));
    	sic.add(new SelectorItemInfo("FodderEntrys.fodderDate"));
    	sic.add(new SelectorItemInfo("FodderEntrys.fodderQty"));
    	sic.add(new SelectorItemInfo("FodderEntrys.fodderDesc"));
    	sic.add(new SelectorItemInfo("FodderEntrys.fodderTowerName"));
    	sic.add(new SelectorItemInfo("FodderEntrys.towerInventory"));
        sic.add(new SelectorItemInfo("breedLog"));
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("outSideTFrom"));
        sic.add(new SelectorItemInfo("outSideTTo"));
        sic.add(new SelectorItemInfo("weather"));
        sic.add(new SelectorItemInfo("outHumidityFrom"));
        sic.add(new SelectorItemInfo("outHumidityTo"));
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("fuel"));
        sic.add(new SelectorItemInfo("week"));
        sic.add(new SelectorItemInfo("weekDay"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stoOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stoOrg.id"));
        	sic.add(new SelectorItemInfo("stoOrg.number"));
        	sic.add(new SelectorItemInfo("stoOrg.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedBatch.id"));
        	sic.add(new SelectorItemInfo("breedBatch.number"));
		}
        sic.add(new SelectorItemInfo("costObject"));
        sic.add(new SelectorItemInfo("electricityQty"));
        sic.add(new SelectorItemInfo("coalFual"));
        sic.add(new SelectorItemInfo("dieselFual"));
        sic.add(new SelectorItemInfo("initPersonQty"));
        sic.add(new SelectorItemInfo("entryPersonQty"));
        sic.add(new SelectorItemInfo("leavePersonQty"));
        sic.add(new SelectorItemInfo("attendPersonQty"));
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
        com.kingdee.eas.farm.breed.brood.BroodDailyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.brood.BroodDailyFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionGenNextBill_actionPerformed method
     */
    public void actionGenNextBill_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.brood.BroodDailyFactory.getRemoteInstance().genNextBill(editData);
    }
    	

    /**
     * output actionReShareCoalAndDiesel_actionPerformed method
     */
    public void actionReShareCoalAndDiesel_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.brood.BroodDailyFactory.getRemoteInstance().reShareCoalAndDiesel(editData);
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
	public RequestContext prepareActionGenNextBill(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionGenNextBill() {
    	return false;
    }
	public RequestContext prepareActionReShareCoalAndDiesel(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionReShareCoalAndDiesel() {
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
            innerActionPerformed("eas", AbstractBroodDailyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBroodDailyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionGenNextBill class
     */     
    protected class ActionGenNextBill extends ItemAction {     
    
        public ActionGenNextBill()
        {
            this(null);
        }

        public ActionGenNextBill(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionGenNextBill.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGenNextBill.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGenNextBill.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBroodDailyEditUI.this, "ActionGenNextBill", "actionGenNextBill_actionPerformed", e);
        }
    }

    /**
     * output ActionReShareCoalAndDiesel class
     */     
    protected class ActionReShareCoalAndDiesel extends ItemAction {     
    
        public ActionReShareCoalAndDiesel()
        {
            this(null);
        }

        public ActionReShareCoalAndDiesel(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionReShareCoalAndDiesel.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionReShareCoalAndDiesel.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionReShareCoalAndDiesel.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBroodDailyEditUI.this, "ActionReShareCoalAndDiesel", "actionReShareCoalAndDiesel_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.breed.brood.client", "BroodDailyEditUI");
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
        return com.kingdee.eas.farm.breed.brood.client.BroodDailyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.brood.BroodDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.brood.BroodDailyInfo objectValue = new com.kingdee.eas.farm.breed.brood.BroodDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/breed/brood/BroodDaily";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.breed.brood.app.BroodDailyQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"material").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"饲料"});
			}
		}
		for (int i=0,n=kdtImmuneEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtImmuneEntrys.getCell(i,"henhouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"鸡舍"});
			}
		}
		for (int i=0,n=kdtImmuneEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtImmuneEntrys.getCell(i,"vaccineMaterial").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"疫苗"});
			}
		}
		for (int i=0,n=kdtImmuneEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtImmuneEntrys.getCell(i,"vaccineUsedQty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"使用量"});
			}
		}
		for (int i=0,n=kdtFodderEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderEntrys.getCell(i,"fodderTower").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"料塔"});
			}
		}
		for (int i=0,n=kdtFodderEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderEntrys.getCell(i,"towerInventory").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"当前剩余库存(公斤)"});
			}
		}
		for (int i=0,n=kdtFodderEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderEntrys.getCell(i,"fodderMaterial").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"饲料"});
			}
		}
		for (int i=0,n=kdtFodderEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderEntrys.getCell(i,"fodderDate").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"要料日期"});
			}
		}
		for (int i=0,n=kdtFodderEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderEntrys.getCell(i,"fodderQty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"数量(公斤)"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(baseStatus.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"状态"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstoOrg.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedBatch.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"批次"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtinitPersonQty.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"当天初始人数"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtattendPersonQty.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"出勤人数"});
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
			setTableToSumField(kdtEntrys,new String[] {"dailyQtyAll","waterQty"});
			setTableToSumField(kdtAssEntrys,new String[] {"cullQty","deathQty","marketQty"});
			setTableToSumField(kdtFodderEntrys,new String[] {"fodderQty"});
		}


}