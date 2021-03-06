/**
 * output package name
 */
package com.kingdee.eas.farm.breed.layegg.client;

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
public abstract class AbstractLayEggPlanEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractLayEggPlanEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitWeek;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitHenQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDButton btnGenerateDetails;
    protected com.kingdee.bos.ctrl.swing.KDButton btnClearEntrys;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallDoubleYolkEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallFreakEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallUpEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallBrokenEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contquantityEggs;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperiod;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitWeek;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitDays;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitHenQty;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallDoubleYolkEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallFreakEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallUpEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallBrokenEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtquantityEggs;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.breed.layegg.LayEggPlanInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractLayEggPlanEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractLayEggPlanEditUI.class.getName());
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
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperiod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitWeek = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitHenQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnGenerateDetails = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnClearEntrys = new com.kingdee.bos.ctrl.swing.KDButton();
        this.contallDoubleYolkEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallFreakEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallUpEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallBrokenEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contquantityEggs = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtperiod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtinitWeek = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinitDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinitHenQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtallDoubleYolkEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallFreakEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallUpEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallBrokenEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtquantityEggs = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.kdtEntrys.setName("kdtEntrys");
        this.contfarm.setName("contfarm");
        this.contbaseStatus.setName("contbaseStatus");
        this.contperiod.setName("contperiod");
        this.contauditTime.setName("contauditTime");
        this.continitWeek.setName("continitWeek");
        this.continitDays.setName("continitDays");
        this.continitHenQty.setName("continitHenQty");
        this.contbeginDate.setName("contbeginDate");
        this.btnGenerateDetails.setName("btnGenerateDetails");
        this.btnClearEntrys.setName("btnClearEntrys");
        this.contallDoubleYolkEggQty.setName("contallDoubleYolkEggQty");
        this.contallEggQty.setName("contallEggQty");
        this.contallFreakEggQty.setName("contallFreakEggQty");
        this.contallUpEggQty.setName("contallUpEggQty");
        this.contallBrokenEggQty.setName("contallBrokenEggQty");
        this.contquantityEggs.setName("contquantityEggs");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtfarm.setName("prmtfarm");
        this.baseStatus.setName("baseStatus");
        this.prmtperiod.setName("prmtperiod");
        this.pkauditTime.setName("pkauditTime");
        this.txtinitWeek.setName("txtinitWeek");
        this.txtinitDays.setName("txtinitDays");
        this.txtinitHenQty.setName("txtinitHenQty");
        this.pkbeginDate.setName("pkbeginDate");
        this.txtallDoubleYolkEggQty.setName("txtallDoubleYolkEggQty");
        this.txtallEggQty.setName("txtallEggQty");
        this.txtallFreakEggQty.setName("txtallFreakEggQty");
        this.txtallUpEggQty.setName("txtallUpEggQty");
        this.txtallBrokenEggQty.setName("txtallBrokenEggQty");
        this.txtquantityEggs.setName("txtquantityEggs");
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
        this.contLastUpdateTime.setVisible(false);
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
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"planDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"week\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"weekDay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"henQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"layingRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"upRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"layEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"upEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"freakEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"doubleYolkEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"brokenEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{planDate}</t:Cell><t:Cell>$Resource{week}</t:Cell><t:Cell>$Resource{weekDay}</t:Cell><t:Cell>$Resource{henQty}</t:Cell><t:Cell>$Resource{layingRate}</t:Cell><t:Cell>$Resource{upRate}</t:Cell><t:Cell>$Resource{layEggQty}</t:Cell><t:Cell>$Resource{upEggQty}</t:Cell><t:Cell>$Resource{freakEggQty}</t:Cell><t:Cell>$Resource{doubleYolkEggQty}</t:Cell><t:Cell>$Resource{brokenEggQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","planDate","week","weekDay","henQty","layingRate","upRate","layEggQty","upEggQty","freakEggQty","doubleYolkEggQty","brokenEggQty"});


        this.kdtEntrys.checkParsed();
        KDDatePicker kdtEntrys_planDate_DatePicker = new KDDatePicker();
        kdtEntrys_planDate_DatePicker.setName("kdtEntrys_planDate_DatePicker");
        kdtEntrys_planDate_DatePicker.setVisible(true);
        kdtEntrys_planDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_planDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_planDate_DatePicker);
        this.kdtEntrys.getColumn("planDate").setEditor(kdtEntrys_planDate_CellEditor);
        KDFormattedTextField kdtEntrys_week_TextField = new KDFormattedTextField();
        kdtEntrys_week_TextField.setName("kdtEntrys_week_TextField");
        kdtEntrys_week_TextField.setVisible(true);
        kdtEntrys_week_TextField.setEditable(true);
        kdtEntrys_week_TextField.setHorizontalAlignment(2);
        kdtEntrys_week_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_week_CellEditor = new KDTDefaultCellEditor(kdtEntrys_week_TextField);
        this.kdtEntrys.getColumn("week").setEditor(kdtEntrys_week_CellEditor);
        KDFormattedTextField kdtEntrys_weekDay_TextField = new KDFormattedTextField();
        kdtEntrys_weekDay_TextField.setName("kdtEntrys_weekDay_TextField");
        kdtEntrys_weekDay_TextField.setVisible(true);
        kdtEntrys_weekDay_TextField.setEditable(true);
        kdtEntrys_weekDay_TextField.setHorizontalAlignment(2);
        kdtEntrys_weekDay_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_weekDay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_weekDay_TextField);
        this.kdtEntrys.getColumn("weekDay").setEditor(kdtEntrys_weekDay_CellEditor);
        KDFormattedTextField kdtEntrys_henQty_TextField = new KDFormattedTextField();
        kdtEntrys_henQty_TextField.setName("kdtEntrys_henQty_TextField");
        kdtEntrys_henQty_TextField.setVisible(true);
        kdtEntrys_henQty_TextField.setEditable(true);
        kdtEntrys_henQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_henQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_henQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henQty_TextField);
        this.kdtEntrys.getColumn("henQty").setEditor(kdtEntrys_henQty_CellEditor);
        KDFormattedTextField kdtEntrys_layingRate_TextField = new KDFormattedTextField();
        kdtEntrys_layingRate_TextField.setName("kdtEntrys_layingRate_TextField");
        kdtEntrys_layingRate_TextField.setVisible(true);
        kdtEntrys_layingRate_TextField.setEditable(true);
        kdtEntrys_layingRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_layingRate_TextField.setDataType(1);
        	kdtEntrys_layingRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_layingRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_layingRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_layingRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_layingRate_TextField);
        this.kdtEntrys.getColumn("layingRate").setEditor(kdtEntrys_layingRate_CellEditor);
        KDFormattedTextField kdtEntrys_upRate_TextField = new KDFormattedTextField();
        kdtEntrys_upRate_TextField.setName("kdtEntrys_upRate_TextField");
        kdtEntrys_upRate_TextField.setVisible(true);
        kdtEntrys_upRate_TextField.setEditable(true);
        kdtEntrys_upRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_upRate_TextField.setDataType(1);
        	kdtEntrys_upRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_upRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_upRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_upRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_upRate_TextField);
        this.kdtEntrys.getColumn("upRate").setEditor(kdtEntrys_upRate_CellEditor);
        KDFormattedTextField kdtEntrys_layEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_layEggQty_TextField.setName("kdtEntrys_layEggQty_TextField");
        kdtEntrys_layEggQty_TextField.setVisible(true);
        kdtEntrys_layEggQty_TextField.setEditable(true);
        kdtEntrys_layEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_layEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_layEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_layEggQty_TextField);
        this.kdtEntrys.getColumn("layEggQty").setEditor(kdtEntrys_layEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_upEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_upEggQty_TextField.setName("kdtEntrys_upEggQty_TextField");
        kdtEntrys_upEggQty_TextField.setVisible(true);
        kdtEntrys_upEggQty_TextField.setEditable(true);
        kdtEntrys_upEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_upEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_upEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_upEggQty_TextField);
        this.kdtEntrys.getColumn("upEggQty").setEditor(kdtEntrys_upEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_freakEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_freakEggQty_TextField.setName("kdtEntrys_freakEggQty_TextField");
        kdtEntrys_freakEggQty_TextField.setVisible(true);
        kdtEntrys_freakEggQty_TextField.setEditable(true);
        kdtEntrys_freakEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_freakEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_freakEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_freakEggQty_TextField);
        this.kdtEntrys.getColumn("freakEggQty").setEditor(kdtEntrys_freakEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_doubleYolkEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_doubleYolkEggQty_TextField.setName("kdtEntrys_doubleYolkEggQty_TextField");
        kdtEntrys_doubleYolkEggQty_TextField.setVisible(true);
        kdtEntrys_doubleYolkEggQty_TextField.setEditable(true);
        kdtEntrys_doubleYolkEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_doubleYolkEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_doubleYolkEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_doubleYolkEggQty_TextField);
        this.kdtEntrys.getColumn("doubleYolkEggQty").setEditor(kdtEntrys_doubleYolkEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_brokenEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_brokenEggQty_TextField.setName("kdtEntrys_brokenEggQty_TextField");
        kdtEntrys_brokenEggQty_TextField.setVisible(true);
        kdtEntrys_brokenEggQty_TextField.setEditable(true);
        kdtEntrys_brokenEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_brokenEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_brokenEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_brokenEggQty_TextField);
        this.kdtEntrys.getColumn("brokenEggQty").setEditor(kdtEntrys_brokenEggQty_CellEditor);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contperiod		
        this.contperiod.setBoundLabelText(resHelper.getString("contperiod.boundLabelText"));		
        this.contperiod.setBoundLabelLength(100);		
        this.contperiod.setBoundLabelUnderline(true);		
        this.contperiod.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // continitWeek		
        this.continitWeek.setBoundLabelText(resHelper.getString("continitWeek.boundLabelText"));		
        this.continitWeek.setBoundLabelLength(100);		
        this.continitWeek.setBoundLabelUnderline(true);		
        this.continitWeek.setVisible(true);
        // continitDays		
        this.continitDays.setBoundLabelText(resHelper.getString("continitDays.boundLabelText"));		
        this.continitDays.setBoundLabelLength(100);		
        this.continitDays.setBoundLabelUnderline(true);		
        this.continitDays.setVisible(true);
        // continitHenQty		
        this.continitHenQty.setBoundLabelText(resHelper.getString("continitHenQty.boundLabelText"));		
        this.continitHenQty.setBoundLabelLength(100);		
        this.continitHenQty.setBoundLabelUnderline(true);		
        this.continitHenQty.setVisible(true);
        // contbeginDate		
        this.contbeginDate.setBoundLabelText(resHelper.getString("contbeginDate.boundLabelText"));		
        this.contbeginDate.setBoundLabelLength(100);		
        this.contbeginDate.setBoundLabelUnderline(true);		
        this.contbeginDate.setVisible(true);
        // btnGenerateDetails		
        this.btnGenerateDetails.setText(resHelper.getString("btnGenerateDetails.text"));
        this.btnGenerateDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnGenerateDetails_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnClearEntrys		
        this.btnClearEntrys.setText(resHelper.getString("btnClearEntrys.text"));
        this.btnClearEntrys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnClearEntrys_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // contallDoubleYolkEggQty		
        this.contallDoubleYolkEggQty.setBoundLabelText(resHelper.getString("contallDoubleYolkEggQty.boundLabelText"));		
        this.contallDoubleYolkEggQty.setBoundLabelLength(100);		
        this.contallDoubleYolkEggQty.setBoundLabelUnderline(true);		
        this.contallDoubleYolkEggQty.setVisible(true);
        // contallEggQty		
        this.contallEggQty.setBoundLabelText(resHelper.getString("contallEggQty.boundLabelText"));		
        this.contallEggQty.setBoundLabelLength(100);		
        this.contallEggQty.setBoundLabelUnderline(true);		
        this.contallEggQty.setVisible(true);
        // contallFreakEggQty		
        this.contallFreakEggQty.setBoundLabelText(resHelper.getString("contallFreakEggQty.boundLabelText"));		
        this.contallFreakEggQty.setBoundLabelLength(100);		
        this.contallFreakEggQty.setBoundLabelUnderline(true);		
        this.contallFreakEggQty.setVisible(true);
        // contallUpEggQty		
        this.contallUpEggQty.setBoundLabelText(resHelper.getString("contallUpEggQty.boundLabelText"));		
        this.contallUpEggQty.setBoundLabelLength(100);		
        this.contallUpEggQty.setBoundLabelUnderline(true);		
        this.contallUpEggQty.setVisible(true);
        // contallBrokenEggQty		
        this.contallBrokenEggQty.setBoundLabelText(resHelper.getString("contallBrokenEggQty.boundLabelText"));		
        this.contallBrokenEggQty.setBoundLabelLength(100);		
        this.contallBrokenEggQty.setBoundLabelUnderline(true);		
        this.contallBrokenEggQty.setVisible(true);
        // contquantityEggs		
        this.contquantityEggs.setBoundLabelText(resHelper.getString("contquantityEggs.boundLabelText"));		
        this.contquantityEggs.setBoundLabelLength(100);		
        this.contquantityEggs.setBoundLabelUnderline(true);		
        this.contquantityEggs.setVisible(false);
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
        this.pkBizDate.setVisible(true);		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtfarm.setVisible(true);		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(true);
        // baseStatus		
        this.baseStatus.setVisible(true);		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(true);		
        this.baseStatus.setEnabled(false);
        // prmtperiod		
        this.prmtperiod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtperiod.setVisible(true);		
        this.prmtperiod.setEditable(true);		
        this.prmtperiod.setDisplayFormat("$periodNumber$");		
        this.prmtperiod.setEditFormat("$number$");		
        this.prmtperiod.setCommitFormat("$number$");		
        this.prmtperiod.setRequired(true);
        this.prmtperiod.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtperiod_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // pkauditTime		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // txtinitWeek		
        this.txtinitWeek.setVisible(true);		
        this.txtinitWeek.setHorizontalAlignment(2);		
        this.txtinitWeek.setDataType(0);		
        this.txtinitWeek.setSupportedEmpty(true);		
        this.txtinitWeek.setRequired(true);
        // txtinitDays		
        this.txtinitDays.setVisible(true);		
        this.txtinitDays.setHorizontalAlignment(2);		
        this.txtinitDays.setDataType(0);		
        this.txtinitDays.setSupportedEmpty(true);		
        this.txtinitDays.setRequired(true);
        // txtinitHenQty		
        this.txtinitHenQty.setVisible(true);		
        this.txtinitHenQty.setHorizontalAlignment(2);		
        this.txtinitHenQty.setDataType(0);		
        this.txtinitHenQty.setSupportedEmpty(true);		
        this.txtinitHenQty.setRequired(true);
        // pkbeginDate		
        this.pkbeginDate.setVisible(true);		
        this.pkbeginDate.setRequired(true);
        // txtallDoubleYolkEggQty		
        this.txtallDoubleYolkEggQty.setVisible(true);		
        this.txtallDoubleYolkEggQty.setHorizontalAlignment(2);		
        this.txtallDoubleYolkEggQty.setDataType(1);		
        this.txtallDoubleYolkEggQty.setSupportedEmpty(true);		
        this.txtallDoubleYolkEggQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallDoubleYolkEggQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallDoubleYolkEggQty.setPrecision(4);		
        this.txtallDoubleYolkEggQty.setRequired(false);		
        this.txtallDoubleYolkEggQty.setEnabled(false);
        // txtallEggQty		
        this.txtallEggQty.setVisible(true);		
        this.txtallEggQty.setHorizontalAlignment(2);		
        this.txtallEggQty.setDataType(1);		
        this.txtallEggQty.setSupportedEmpty(true);		
        this.txtallEggQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallEggQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallEggQty.setPrecision(4);		
        this.txtallEggQty.setRequired(false);		
        this.txtallEggQty.setEnabled(false);
        // txtallFreakEggQty		
        this.txtallFreakEggQty.setVisible(true);		
        this.txtallFreakEggQty.setHorizontalAlignment(2);		
        this.txtallFreakEggQty.setDataType(1);		
        this.txtallFreakEggQty.setSupportedEmpty(true);		
        this.txtallFreakEggQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallFreakEggQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallFreakEggQty.setPrecision(10);		
        this.txtallFreakEggQty.setRequired(false);		
        this.txtallFreakEggQty.setEnabled(false);
        // txtallUpEggQty		
        this.txtallUpEggQty.setVisible(true);		
        this.txtallUpEggQty.setHorizontalAlignment(2);		
        this.txtallUpEggQty.setDataType(1);		
        this.txtallUpEggQty.setSupportedEmpty(true);		
        this.txtallUpEggQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallUpEggQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallUpEggQty.setPrecision(10);		
        this.txtallUpEggQty.setRequired(false);		
        this.txtallUpEggQty.setEnabled(false);
        // txtallBrokenEggQty		
        this.txtallBrokenEggQty.setVisible(true);		
        this.txtallBrokenEggQty.setHorizontalAlignment(2);		
        this.txtallBrokenEggQty.setDataType(1);		
        this.txtallBrokenEggQty.setSupportedEmpty(true);		
        this.txtallBrokenEggQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallBrokenEggQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallBrokenEggQty.setPrecision(10);		
        this.txtallBrokenEggQty.setRequired(false);		
        this.txtallBrokenEggQty.setEnabled(false);
        // txtquantityEggs		
        this.txtquantityEggs.setVisible(false);		
        this.txtquantityEggs.setHorizontalAlignment(2);		
        this.txtquantityEggs.setDataType(1);		
        this.txtquantityEggs.setSupportedEmpty(true);		
        this.txtquantityEggs.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtquantityEggs.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtquantityEggs.setPrecision(4);		
        this.txtquantityEggs.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtfarm,baseStatus,prmtperiod,pkauditTime,txtinitWeek,txtinitDays,txtinitHenQty,pkbeginDate,txtallDoubleYolkEggQty,txtallEggQty,txtquantityEggs}));
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
        contCreator.setBounds(new Rectangle(374, 567, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(374, 567, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(374, 593, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(374, 593, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(734, 567, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(734, 567, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(734, 593, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(734, 593, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(18, 21, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(18, 21, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(732, 21, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(732, 21, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(732, 128, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(732, 128, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(14, 567, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(14, 567, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(12, 193, 991, 368));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.breed.layegg.LayEggPlanEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(12, 193, 991, 368, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarm.setBounds(new Rectangle(375, 21, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(375, 21, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbaseStatus.setBounds(new Rectangle(732, 73, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(732, 73, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contperiod.setBounds(new Rectangle(18, 47, 270, 19));
        this.add(contperiod, new KDLayout.Constraints(18, 47, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(14, 593, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(14, 593, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continitWeek.setBounds(new Rectangle(375, 47, 270, 19));
        this.add(continitWeek, new KDLayout.Constraints(375, 47, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continitDays.setBounds(new Rectangle(732, 47, 270, 19));
        this.add(continitDays, new KDLayout.Constraints(732, 47, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        continitHenQty.setBounds(new Rectangle(18, 73, 270, 19));
        this.add(continitHenQty, new KDLayout.Constraints(18, 73, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbeginDate.setBounds(new Rectangle(375, 73, 270, 19));
        this.add(contbeginDate, new KDLayout.Constraints(375, 73, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnGenerateDetails.setBounds(new Rectangle(15, 170, 154, 21));
        this.add(btnGenerateDetails, new KDLayout.Constraints(15, 170, 154, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnClearEntrys.setBounds(new Rectangle(184, 170, 151, 21));
        this.add(btnClearEntrys, new KDLayout.Constraints(184, 170, 151, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallDoubleYolkEggQty.setBounds(new Rectangle(18, 128, 270, 19));
        this.add(contallDoubleYolkEggQty, new KDLayout.Constraints(18, 128, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallEggQty.setBounds(new Rectangle(18, 99, 270, 19));
        this.add(contallEggQty, new KDLayout.Constraints(18, 99, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallFreakEggQty.setBounds(new Rectangle(732, 99, 270, 19));
        this.add(contallFreakEggQty, new KDLayout.Constraints(732, 99, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contallUpEggQty.setBounds(new Rectangle(375, 99, 270, 19));
        this.add(contallUpEggQty, new KDLayout.Constraints(375, 99, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallBrokenEggQty.setBounds(new Rectangle(375, 128, 270, 19));
        this.add(contallBrokenEggQty, new KDLayout.Constraints(375, 128, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contquantityEggs.setBounds(new Rectangle(732, 164, 270, 19));
        this.add(contquantityEggs, new KDLayout.Constraints(732, 164, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contperiod
        contperiod.setBoundEditor(prmtperiod);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //continitWeek
        continitWeek.setBoundEditor(txtinitWeek);
        //continitDays
        continitDays.setBoundEditor(txtinitDays);
        //continitHenQty
        continitHenQty.setBoundEditor(txtinitHenQty);
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contallDoubleYolkEggQty
        contallDoubleYolkEggQty.setBoundEditor(txtallDoubleYolkEggQty);
        //contallEggQty
        contallEggQty.setBoundEditor(txtallEggQty);
        //contallFreakEggQty
        contallFreakEggQty.setBoundEditor(txtallFreakEggQty);
        //contallUpEggQty
        contallUpEggQty.setBoundEditor(txtallUpEggQty);
        //contallBrokenEggQty
        contallBrokenEggQty.setBoundEditor(txtallBrokenEggQty);
        //contquantityEggs
        contquantityEggs.setBoundEditor(txtquantityEggs);

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
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.breed.layegg.LayEggPlanEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.planDate", java.util.Date.class, this.kdtEntrys, "planDate.text");
		dataBinder.registerBinding("entrys.week", int.class, this.kdtEntrys, "week.text");
		dataBinder.registerBinding("entrys.weekDay", int.class, this.kdtEntrys, "weekDay.text");
		dataBinder.registerBinding("entrys.henQty", int.class, this.kdtEntrys, "henQty.text");
		dataBinder.registerBinding("entrys.layingRate", java.math.BigDecimal.class, this.kdtEntrys, "layingRate.text");
		dataBinder.registerBinding("entrys.upRate", java.math.BigDecimal.class, this.kdtEntrys, "upRate.text");
		dataBinder.registerBinding("entrys.layEggQty", int.class, this.kdtEntrys, "layEggQty.text");
		dataBinder.registerBinding("entrys.upEggQty", int.class, this.kdtEntrys, "upEggQty.text");
		dataBinder.registerBinding("entrys.freakEggQty", int.class, this.kdtEntrys, "freakEggQty.text");
		dataBinder.registerBinding("entrys.doubleYolkEggQty", int.class, this.kdtEntrys, "doubleYolkEggQty.text");
		dataBinder.registerBinding("entrys.brokenEggQty", int.class, this.kdtEntrys, "brokenEggQty.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("period", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtperiod, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("initWeek", int.class, this.txtinitWeek, "value");
		dataBinder.registerBinding("initDays", int.class, this.txtinitDays, "value");
		dataBinder.registerBinding("initHenQty", int.class, this.txtinitHenQty, "value");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("txtallDoubleYolkEggQty", java.math.BigDecimal.class, this.txtallDoubleYolkEggQty, "value");
		dataBinder.registerBinding("allEggQty", java.math.BigDecimal.class, this.txtallEggQty, "value");
		dataBinder.registerBinding("allFreakEggQty", java.math.BigDecimal.class, this.txtallFreakEggQty, "value");
		dataBinder.registerBinding("allUpEggQty", java.math.BigDecimal.class, this.txtallUpEggQty, "value");
		dataBinder.registerBinding("allBrokenEggQty", java.math.BigDecimal.class, this.txtallBrokenEggQty, "value");
		dataBinder.registerBinding("quantityEggs", java.math.BigDecimal.class, this.txtquantityEggs, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.breed.layegg.app.LayEggPlanEditUIHandler";
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
        this.prmtfarm.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.breed.layegg.LayEggPlanInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.planDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.weekDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.layingRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.upRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.layEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.upEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.freakEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.doubleYolkEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.brokenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initWeek", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initHenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("txtallDoubleYolkEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allFreakEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allUpEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allBrokenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("quantityEggs", ValidateHelper.ON_SAVE);    		
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
     * output btnGenerateDetails_actionPerformed method
     */
    protected void btnGenerateDetails_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnClearEntrys_actionPerformed method
     */
    protected void btnClearEntrys_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output prmtperiod_dataChanged method
     */
    protected void prmtperiod_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
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
    	sic.add(new SelectorItemInfo("entrys.planDate"));
    	sic.add(new SelectorItemInfo("entrys.week"));
    	sic.add(new SelectorItemInfo("entrys.weekDay"));
    	sic.add(new SelectorItemInfo("entrys.henQty"));
    	sic.add(new SelectorItemInfo("entrys.layingRate"));
    	sic.add(new SelectorItemInfo("entrys.upRate"));
    	sic.add(new SelectorItemInfo("entrys.layEggQty"));
    	sic.add(new SelectorItemInfo("entrys.upEggQty"));
    	sic.add(new SelectorItemInfo("entrys.freakEggQty"));
    	sic.add(new SelectorItemInfo("entrys.doubleYolkEggQty"));
    	sic.add(new SelectorItemInfo("entrys.brokenEggQty"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
		}
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("period.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("period.id"));
        	sic.add(new SelectorItemInfo("period.number"));
        	sic.add(new SelectorItemInfo("period.periodNumber"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("initWeek"));
        sic.add(new SelectorItemInfo("initDays"));
        sic.add(new SelectorItemInfo("initHenQty"));
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("txtallDoubleYolkEggQty"));
        sic.add(new SelectorItemInfo("allEggQty"));
        sic.add(new SelectorItemInfo("allFreakEggQty"));
        sic.add(new SelectorItemInfo("allUpEggQty"));
        sic.add(new SelectorItemInfo("allBrokenEggQty"));
        sic.add(new SelectorItemInfo("quantityEggs"));
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
        com.kingdee.eas.farm.breed.layegg.LayEggPlanFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.layegg.LayEggPlanFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractLayEggPlanEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractLayEggPlanEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.breed.layegg.client", "LayEggPlanEditUI");
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
        return com.kingdee.eas.farm.breed.layegg.client.LayEggPlanEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.layegg.LayEggPlanFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.layegg.LayEggPlanInfo objectValue = new com.kingdee.eas.farm.breed.layegg.LayEggPlanInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/breed/layegg/LayEggPlan";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.breed.layegg.app.LayEggPlanQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"产蛋场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(baseStatus.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"状态"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtperiod.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"期间（月份）"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtinitWeek.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"月初周龄"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtinitDays.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"月初日龄"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtinitHenQty.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"月初存栏套数"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkbeginDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"开算日期"});
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

}