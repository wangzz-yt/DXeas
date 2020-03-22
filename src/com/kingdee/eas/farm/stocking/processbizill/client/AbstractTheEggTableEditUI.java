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
public abstract class AbstractTheEggTableEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractTheEggTableEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggSource;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAddRows;
    protected com.kingdee.bos.ctrl.swing.KDButton btnAddRows;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrentP;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchfactory;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstockingBillNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriver;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarNum;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisinventory;
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
    protected com.kingdee.bos.ctrl.swing.KDComboBox GrentP;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthatchfactory;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstockingBillNum;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdriver;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcarNum;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator3;
    protected com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionShowPriceCol actionShowPriceCol = null;
    protected ActionViewAllBill actionViewAllBill = null;
    /**
     * output class constructor
     */
    public AbstractTheEggTableEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractTheEggTableEditUI.class.getName());
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
        this.conteggSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAddRows = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnAddRows = new com.kingdee.bos.ctrl.swing.KDButton();
        this.contGrentP = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchfactory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstockingBillNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriver = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcarNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisinventory = new com.kingdee.bos.ctrl.swing.KDCheckBox();
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
        this.GrentP = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmthatchfactory = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstockingBillNum = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtdriver = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcarNum = new com.kingdee.bos.ctrl.swing.KDTextField();
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
        this.kdtEntrys.setName("kdtEntrys");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.conteggSource.setName("conteggSource");
        this.contAddRows.setName("contAddRows");
        this.btnAddRows.setName("btnAddRows");
        this.contGrentP.setName("contGrentP");
        this.conthatchfactory.setName("conthatchfactory");
        this.contstockingBillNum.setName("contstockingBillNum");
        this.contdriver.setName("contdriver");
        this.contcarNum.setName("contcarNum");
        this.chkisinventory.setName("chkisinventory");
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
        this.GrentP.setName("GrentP");
        this.prmthatchfactory.setName("prmthatchfactory");
        this.prmtstockingBillNum.setName("prmtstockingBillNum");
        this.txtdriver.setName("txtdriver");
        this.txtcarNum.setName("txtcarNum");
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
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol33\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol34\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol35\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol36\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol37\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol38\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol39\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" t:styleID=\"sCol0\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" t:styleID=\"sCol1\" /><t:Column t:key=\"stockingBatch\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"lot\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol5\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol6\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"serial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"breedData\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" /><t:Column t:key=\"sendDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" t:styleID=\"sCol10\" /><t:Column t:key=\"weekAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" t:styleID=\"sCol11\" /><t:Column t:key=\"dayAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" t:styleID=\"sCol12\" /><t:Column t:key=\"isFormal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"sendAllQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"sendBasketQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"dz\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"qualifieds\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"jxds\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"shds\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"dpd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"BBQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"qualified\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"Squalified\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"ccd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"jxd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"shd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"zd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"rd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"pd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"fxd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"confirmAllQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"confirmBasketQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"costItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"farmersTree\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"hasConfirm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"confirmTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"bz\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"dissharpEgg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol38\" /><t:Column t:key=\"doubleEgg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol39\" /><t:Column t:key=\"bzz\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{stockingBatch}</t:Cell><t:Cell>$Resource{lot}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{serial}</t:Cell><t:Cell>$Resource{breedData}</t:Cell><t:Cell>$Resource{sendDate}</t:Cell><t:Cell>$Resource{weekAge}</t:Cell><t:Cell>$Resource{dayAge}</t:Cell><t:Cell>$Resource{isFormal}</t:Cell><t:Cell>$Resource{sendAllQty}</t:Cell><t:Cell>$Resource{sendBasketQty}</t:Cell><t:Cell>$Resource{dz}</t:Cell><t:Cell>$Resource{qualifieds}</t:Cell><t:Cell>$Resource{jxds}</t:Cell><t:Cell>$Resource{shds}</t:Cell><t:Cell>$Resource{dpd}</t:Cell><t:Cell>$Resource{BBQty}</t:Cell><t:Cell>$Resource{qualified}</t:Cell><t:Cell>$Resource{Squalified}</t:Cell><t:Cell>$Resource{ccd}</t:Cell><t:Cell>$Resource{jxd}</t:Cell><t:Cell>$Resource{shd}</t:Cell><t:Cell>$Resource{zd}</t:Cell><t:Cell>$Resource{rd}</t:Cell><t:Cell>$Resource{pd}</t:Cell><t:Cell>$Resource{fxd}</t:Cell><t:Cell>$Resource{confirmAllQty}</t:Cell><t:Cell>$Resource{confirmBasketQty}</t:Cell><t:Cell>$Resource{costItem}</t:Cell><t:Cell>$Resource{farmersTree}</t:Cell><t:Cell>$Resource{hasConfirm}</t:Cell><t:Cell>$Resource{confirmTime}</t:Cell><t:Cell>$Resource{bz}</t:Cell><t:Cell>$Resource{dissharpEgg}</t:Cell><t:Cell>$Resource{doubleEgg}</t:Cell><t:Cell>$Resource{bzz}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","","stockingBatch","lot","supplier","farmer","farm","house","serial","breedData","sendDate","weekAge","dayAge","isFormal","sendAllQty","sendBasketQty","dz","qualifieds","jxds","shds","dpd","BBQty","qualified","Squalified","ccd","jxd","shd","zd","rd","pd","fxd","confirmAllQty","confirmBasketQty","costItem","farmersTree","hasConfirm","confirmTime","bz","dissharpEgg","doubleEgg","bzz"});


        this.kdtEntrys.checkParsed();
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
					
        KDTextField kdtEntrys_lot_TextField = new KDTextField();
        kdtEntrys_lot_TextField.setName("kdtEntrys_lot_TextField");
        kdtEntrys_lot_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_lot_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lot_TextField);
        this.kdtEntrys.getColumn("lot").setEditor(kdtEntrys_lot_CellEditor);
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
        KDComboBox kdtEntrys_serial_ComboBox = new KDComboBox();
        kdtEntrys_serial_ComboBox.setName("kdtEntrys_serial_ComboBox");
        kdtEntrys_serial_ComboBox.setVisible(true);
        kdtEntrys_serial_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());
        KDTDefaultCellEditor kdtEntrys_serial_CellEditor = new KDTDefaultCellEditor(kdtEntrys_serial_ComboBox);
        this.kdtEntrys.getColumn("serial").setEditor(kdtEntrys_serial_CellEditor);
        final KDBizPromptBox kdtEntrys_breedData_PromptBox = new KDBizPromptBox();
        kdtEntrys_breedData_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");
        kdtEntrys_breedData_PromptBox.setVisible(true);
        kdtEntrys_breedData_PromptBox.setEditable(true);
        kdtEntrys_breedData_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_breedData_PromptBox.setEditFormat("$number$");
        kdtEntrys_breedData_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_breedData_CellEditor = new KDTDefaultCellEditor(kdtEntrys_breedData_PromptBox);
        this.kdtEntrys.getColumn("breedData").setEditor(kdtEntrys_breedData_CellEditor);
        ObjectValueRender kdtEntrys_breedData_OVR = new ObjectValueRender();
        kdtEntrys_breedData_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("breedData").setRenderer(kdtEntrys_breedData_OVR);
        			kdtEntrys_breedData_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI kdtEntrys_breedData_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_breedData_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_breedData_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_breedData_PromptBox_F7ListUI));
					kdtEntrys_breedData_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_breedData_PromptBox.setSelector(kdtEntrys_breedData_PromptBox_F7ListUI);
				}
			}
		});
					
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
        KDFormattedTextField kdtEntrys_sendBasketQty_TextField = new KDFormattedTextField();
        kdtEntrys_sendBasketQty_TextField.setName("kdtEntrys_sendBasketQty_TextField");
        kdtEntrys_sendBasketQty_TextField.setVisible(true);
        kdtEntrys_sendBasketQty_TextField.setEditable(true);
        kdtEntrys_sendBasketQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_sendBasketQty_TextField.setDataType(1);
        	kdtEntrys_sendBasketQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_sendBasketQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_sendBasketQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_sendBasketQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sendBasketQty_TextField);
        this.kdtEntrys.getColumn("sendBasketQty").setEditor(kdtEntrys_sendBasketQty_CellEditor);
        KDFormattedTextField kdtEntrys_dz_TextField = new KDFormattedTextField();
        kdtEntrys_dz_TextField.setName("kdtEntrys_dz_TextField");
        kdtEntrys_dz_TextField.setVisible(true);
        kdtEntrys_dz_TextField.setEditable(true);
        kdtEntrys_dz_TextField.setHorizontalAlignment(2);
        kdtEntrys_dz_TextField.setDataType(1);
        	kdtEntrys_dz_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_dz_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_dz_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_dz_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dz_TextField);
        this.kdtEntrys.getColumn("dz").setEditor(kdtEntrys_dz_CellEditor);
        KDFormattedTextField kdtEntrys_qualifieds_TextField = new KDFormattedTextField();
        kdtEntrys_qualifieds_TextField.setName("kdtEntrys_qualifieds_TextField");
        kdtEntrys_qualifieds_TextField.setVisible(true);
        kdtEntrys_qualifieds_TextField.setEditable(true);
        kdtEntrys_qualifieds_TextField.setHorizontalAlignment(2);
        kdtEntrys_qualifieds_TextField.setDataType(1);
        	kdtEntrys_qualifieds_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qualifieds_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qualifieds_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qualifieds_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qualifieds_TextField);
        this.kdtEntrys.getColumn("qualifieds").setEditor(kdtEntrys_qualifieds_CellEditor);
        KDFormattedTextField kdtEntrys_jxds_TextField = new KDFormattedTextField();
        kdtEntrys_jxds_TextField.setName("kdtEntrys_jxds_TextField");
        kdtEntrys_jxds_TextField.setVisible(true);
        kdtEntrys_jxds_TextField.setEditable(true);
        kdtEntrys_jxds_TextField.setHorizontalAlignment(2);
        kdtEntrys_jxds_TextField.setDataType(1);
        	kdtEntrys_jxds_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_jxds_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_jxds_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_jxds_CellEditor = new KDTDefaultCellEditor(kdtEntrys_jxds_TextField);
        this.kdtEntrys.getColumn("jxds").setEditor(kdtEntrys_jxds_CellEditor);
        KDFormattedTextField kdtEntrys_shds_TextField = new KDFormattedTextField();
        kdtEntrys_shds_TextField.setName("kdtEntrys_shds_TextField");
        kdtEntrys_shds_TextField.setVisible(true);
        kdtEntrys_shds_TextField.setEditable(true);
        kdtEntrys_shds_TextField.setHorizontalAlignment(2);
        kdtEntrys_shds_TextField.setDataType(1);
        	kdtEntrys_shds_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_shds_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_shds_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_shds_CellEditor = new KDTDefaultCellEditor(kdtEntrys_shds_TextField);
        this.kdtEntrys.getColumn("shds").setEditor(kdtEntrys_shds_CellEditor);
        KDFormattedTextField kdtEntrys_dpd_TextField = new KDFormattedTextField();
        kdtEntrys_dpd_TextField.setName("kdtEntrys_dpd_TextField");
        kdtEntrys_dpd_TextField.setVisible(true);
        kdtEntrys_dpd_TextField.setEditable(true);
        kdtEntrys_dpd_TextField.setHorizontalAlignment(2);
        kdtEntrys_dpd_TextField.setDataType(1);
        	kdtEntrys_dpd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_dpd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_dpd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_dpd_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dpd_TextField);
        this.kdtEntrys.getColumn("dpd").setEditor(kdtEntrys_dpd_CellEditor);
        KDFormattedTextField kdtEntrys_BBQty_TextField = new KDFormattedTextField();
        kdtEntrys_BBQty_TextField.setName("kdtEntrys_BBQty_TextField");
        kdtEntrys_BBQty_TextField.setVisible(true);
        kdtEntrys_BBQty_TextField.setEditable(true);
        kdtEntrys_BBQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_BBQty_TextField.setDataType(1);
        	kdtEntrys_BBQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_BBQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_BBQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_BBQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_BBQty_TextField);
        this.kdtEntrys.getColumn("BBQty").setEditor(kdtEntrys_BBQty_CellEditor);
        KDFormattedTextField kdtEntrys_qualified_TextField = new KDFormattedTextField();
        kdtEntrys_qualified_TextField.setName("kdtEntrys_qualified_TextField");
        kdtEntrys_qualified_TextField.setVisible(true);
        kdtEntrys_qualified_TextField.setEditable(true);
        kdtEntrys_qualified_TextField.setHorizontalAlignment(2);
        kdtEntrys_qualified_TextField.setDataType(1);
        	kdtEntrys_qualified_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qualified_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qualified_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qualified_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qualified_TextField);
        this.kdtEntrys.getColumn("qualified").setEditor(kdtEntrys_qualified_CellEditor);
        KDFormattedTextField kdtEntrys_Squalified_TextField = new KDFormattedTextField();
        kdtEntrys_Squalified_TextField.setName("kdtEntrys_Squalified_TextField");
        kdtEntrys_Squalified_TextField.setVisible(true);
        kdtEntrys_Squalified_TextField.setEditable(true);
        kdtEntrys_Squalified_TextField.setHorizontalAlignment(2);
        kdtEntrys_Squalified_TextField.setDataType(1);
        	kdtEntrys_Squalified_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_Squalified_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_Squalified_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_Squalified_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Squalified_TextField);
        this.kdtEntrys.getColumn("Squalified").setEditor(kdtEntrys_Squalified_CellEditor);
        KDFormattedTextField kdtEntrys_ccd_TextField = new KDFormattedTextField();
        kdtEntrys_ccd_TextField.setName("kdtEntrys_ccd_TextField");
        kdtEntrys_ccd_TextField.setVisible(true);
        kdtEntrys_ccd_TextField.setEditable(true);
        kdtEntrys_ccd_TextField.setHorizontalAlignment(2);
        kdtEntrys_ccd_TextField.setDataType(1);
        	kdtEntrys_ccd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_ccd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_ccd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_ccd_CellEditor = new KDTDefaultCellEditor(kdtEntrys_ccd_TextField);
        this.kdtEntrys.getColumn("ccd").setEditor(kdtEntrys_ccd_CellEditor);
        KDFormattedTextField kdtEntrys_jxd_TextField = new KDFormattedTextField();
        kdtEntrys_jxd_TextField.setName("kdtEntrys_jxd_TextField");
        kdtEntrys_jxd_TextField.setVisible(true);
        kdtEntrys_jxd_TextField.setEditable(true);
        kdtEntrys_jxd_TextField.setHorizontalAlignment(2);
        kdtEntrys_jxd_TextField.setDataType(1);
        	kdtEntrys_jxd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_jxd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_jxd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_jxd_CellEditor = new KDTDefaultCellEditor(kdtEntrys_jxd_TextField);
        this.kdtEntrys.getColumn("jxd").setEditor(kdtEntrys_jxd_CellEditor);
        KDFormattedTextField kdtEntrys_shd_TextField = new KDFormattedTextField();
        kdtEntrys_shd_TextField.setName("kdtEntrys_shd_TextField");
        kdtEntrys_shd_TextField.setVisible(true);
        kdtEntrys_shd_TextField.setEditable(true);
        kdtEntrys_shd_TextField.setHorizontalAlignment(2);
        kdtEntrys_shd_TextField.setDataType(1);
        	kdtEntrys_shd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_shd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_shd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_shd_CellEditor = new KDTDefaultCellEditor(kdtEntrys_shd_TextField);
        this.kdtEntrys.getColumn("shd").setEditor(kdtEntrys_shd_CellEditor);
        KDFormattedTextField kdtEntrys_zd_TextField = new KDFormattedTextField();
        kdtEntrys_zd_TextField.setName("kdtEntrys_zd_TextField");
        kdtEntrys_zd_TextField.setVisible(true);
        kdtEntrys_zd_TextField.setEditable(true);
        kdtEntrys_zd_TextField.setHorizontalAlignment(2);
        kdtEntrys_zd_TextField.setDataType(1);
        	kdtEntrys_zd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_zd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_zd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_zd_CellEditor = new KDTDefaultCellEditor(kdtEntrys_zd_TextField);
        this.kdtEntrys.getColumn("zd").setEditor(kdtEntrys_zd_CellEditor);
        KDFormattedTextField kdtEntrys_rd_TextField = new KDFormattedTextField();
        kdtEntrys_rd_TextField.setName("kdtEntrys_rd_TextField");
        kdtEntrys_rd_TextField.setVisible(true);
        kdtEntrys_rd_TextField.setEditable(true);
        kdtEntrys_rd_TextField.setHorizontalAlignment(2);
        kdtEntrys_rd_TextField.setDataType(1);
        	kdtEntrys_rd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_rd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_rd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_rd_CellEditor = new KDTDefaultCellEditor(kdtEntrys_rd_TextField);
        this.kdtEntrys.getColumn("rd").setEditor(kdtEntrys_rd_CellEditor);
        KDFormattedTextField kdtEntrys_pd_TextField = new KDFormattedTextField();
        kdtEntrys_pd_TextField.setName("kdtEntrys_pd_TextField");
        kdtEntrys_pd_TextField.setVisible(true);
        kdtEntrys_pd_TextField.setEditable(true);
        kdtEntrys_pd_TextField.setHorizontalAlignment(2);
        kdtEntrys_pd_TextField.setDataType(1);
        	kdtEntrys_pd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_pd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_pd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_pd_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pd_TextField);
        this.kdtEntrys.getColumn("pd").setEditor(kdtEntrys_pd_CellEditor);
        KDFormattedTextField kdtEntrys_fxd_TextField = new KDFormattedTextField();
        kdtEntrys_fxd_TextField.setName("kdtEntrys_fxd_TextField");
        kdtEntrys_fxd_TextField.setVisible(true);
        kdtEntrys_fxd_TextField.setEditable(true);
        kdtEntrys_fxd_TextField.setHorizontalAlignment(2);
        kdtEntrys_fxd_TextField.setDataType(1);
        	kdtEntrys_fxd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_fxd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_fxd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_fxd_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fxd_TextField);
        this.kdtEntrys.getColumn("fxd").setEditor(kdtEntrys_fxd_CellEditor);
        KDFormattedTextField kdtEntrys_confirmAllQty_TextField = new KDFormattedTextField();
        kdtEntrys_confirmAllQty_TextField.setName("kdtEntrys_confirmAllQty_TextField");
        kdtEntrys_confirmAllQty_TextField.setVisible(true);
        kdtEntrys_confirmAllQty_TextField.setEditable(true);
        kdtEntrys_confirmAllQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_confirmAllQty_TextField.setDataType(1);
        	kdtEntrys_confirmAllQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_confirmAllQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_confirmAllQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_confirmAllQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_confirmAllQty_TextField);
        this.kdtEntrys.getColumn("confirmAllQty").setEditor(kdtEntrys_confirmAllQty_CellEditor);
        KDFormattedTextField kdtEntrys_confirmBasketQty_TextField = new KDFormattedTextField();
        kdtEntrys_confirmBasketQty_TextField.setName("kdtEntrys_confirmBasketQty_TextField");
        kdtEntrys_confirmBasketQty_TextField.setVisible(true);
        kdtEntrys_confirmBasketQty_TextField.setEditable(true);
        kdtEntrys_confirmBasketQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_confirmBasketQty_TextField.setDataType(1);
        	kdtEntrys_confirmBasketQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_confirmBasketQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_confirmBasketQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_confirmBasketQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_confirmBasketQty_TextField);
        this.kdtEntrys.getColumn("confirmBasketQty").setEditor(kdtEntrys_confirmBasketQty_CellEditor);
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
        final KDBizPromptBox kdtEntrys_farmersTree_PromptBox = new KDBizPromptBox();
        kdtEntrys_farmersTree_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
        kdtEntrys_farmersTree_PromptBox.setVisible(true);
        kdtEntrys_farmersTree_PromptBox.setEditable(true);
        kdtEntrys_farmersTree_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_farmersTree_PromptBox.setEditFormat("$number$");
        kdtEntrys_farmersTree_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_farmersTree_CellEditor = new KDTDefaultCellEditor(kdtEntrys_farmersTree_PromptBox);
        this.kdtEntrys.getColumn("farmersTree").setEditor(kdtEntrys_farmersTree_CellEditor);
        ObjectValueRender kdtEntrys_farmersTree_OVR = new ObjectValueRender();
        kdtEntrys_farmersTree_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("farmersTree").setRenderer(kdtEntrys_farmersTree_OVR);
        KDCheckBox kdtEntrys_hasConfirm_CheckBox = new KDCheckBox();
        kdtEntrys_hasConfirm_CheckBox.setName("kdtEntrys_hasConfirm_CheckBox");
        KDTDefaultCellEditor kdtEntrys_hasConfirm_CellEditor = new KDTDefaultCellEditor(kdtEntrys_hasConfirm_CheckBox);
        this.kdtEntrys.getColumn("hasConfirm").setEditor(kdtEntrys_hasConfirm_CellEditor);
        KDDatePicker kdtEntrys_confirmTime_DatePicker = new KDDatePicker();
        kdtEntrys_confirmTime_DatePicker.setName("kdtEntrys_confirmTime_DatePicker");
        kdtEntrys_confirmTime_DatePicker.setVisible(true);
        kdtEntrys_confirmTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_confirmTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_confirmTime_DatePicker);
        this.kdtEntrys.getColumn("confirmTime").setEditor(kdtEntrys_confirmTime_CellEditor);
        KDTextArea kdtEntrys_bz_TextArea = new KDTextArea();
        kdtEntrys_bz_TextArea.setName("kdtEntrys_bz_TextArea");
        kdtEntrys_bz_TextArea.setMaxLength(255);
        KDTDefaultCellEditor kdtEntrys_bz_CellEditor = new KDTDefaultCellEditor(kdtEntrys_bz_TextArea);
        this.kdtEntrys.getColumn("bz").setEditor(kdtEntrys_bz_CellEditor);
        KDFormattedTextField kdtEntrys_dissharpEgg_TextField = new KDFormattedTextField();
        kdtEntrys_dissharpEgg_TextField.setName("kdtEntrys_dissharpEgg_TextField");
        kdtEntrys_dissharpEgg_TextField.setVisible(true);
        kdtEntrys_dissharpEgg_TextField.setEditable(true);
        kdtEntrys_dissharpEgg_TextField.setHorizontalAlignment(2);
        kdtEntrys_dissharpEgg_TextField.setDataType(1);
        	kdtEntrys_dissharpEgg_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_dissharpEgg_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_dissharpEgg_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_dissharpEgg_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dissharpEgg_TextField);
        this.kdtEntrys.getColumn("dissharpEgg").setEditor(kdtEntrys_dissharpEgg_CellEditor);
        KDFormattedTextField kdtEntrys_doubleEgg_TextField = new KDFormattedTextField();
        kdtEntrys_doubleEgg_TextField.setName("kdtEntrys_doubleEgg_TextField");
        kdtEntrys_doubleEgg_TextField.setVisible(true);
        kdtEntrys_doubleEgg_TextField.setEditable(true);
        kdtEntrys_doubleEgg_TextField.setHorizontalAlignment(2);
        kdtEntrys_doubleEgg_TextField.setDataType(1);
        	kdtEntrys_doubleEgg_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_doubleEgg_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_doubleEgg_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_doubleEgg_CellEditor = new KDTDefaultCellEditor(kdtEntrys_doubleEgg_TextField);
        this.kdtEntrys.getColumn("doubleEgg").setEditor(kdtEntrys_doubleEgg_CellEditor);
        KDTextArea kdtEntrys_bzz_TextArea = new KDTextArea();
        kdtEntrys_bzz_TextArea.setName("kdtEntrys_bzz_TextArea");
        kdtEntrys_bzz_TextArea.setMaxLength(255);
        KDTDefaultCellEditor kdtEntrys_bzz_CellEditor = new KDTDefaultCellEditor(kdtEntrys_bzz_TextArea);
        this.kdtEntrys.getColumn("bzz").setEditor(kdtEntrys_bzz_CellEditor);
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
        // conteggSource		
        this.conteggSource.setBoundLabelText(resHelper.getString("conteggSource.boundLabelText"));		
        this.conteggSource.setBoundLabelLength(100);		
        this.conteggSource.setBoundLabelUnderline(true);		
        this.conteggSource.setVisible(true);
        // contAddRows		
        this.contAddRows.setBoundLabelText(resHelper.getString("contAddRows.boundLabelText"));		
        this.contAddRows.setBoundLabelLength(100);		
        this.contAddRows.setBoundLabelUnderline(true);		
        this.contAddRows.setVisible(true);
        // btnAddRows		
        this.btnAddRows.setText(resHelper.getString("btnAddRows.text"));
        // contGrentP		
        this.contGrentP.setBoundLabelText(resHelper.getString("contGrentP.boundLabelText"));		
        this.contGrentP.setBoundLabelLength(100);		
        this.contGrentP.setBoundLabelUnderline(true);		
        this.contGrentP.setVisible(true);
        // conthatchfactory		
        this.conthatchfactory.setBoundLabelText(resHelper.getString("conthatchfactory.boundLabelText"));		
        this.conthatchfactory.setBoundLabelLength(100);		
        this.conthatchfactory.setBoundLabelUnderline(true);		
        this.conthatchfactory.setVisible(true);
        // contstockingBillNum		
        this.contstockingBillNum.setBoundLabelText(resHelper.getString("contstockingBillNum.boundLabelText"));		
        this.contstockingBillNum.setBoundLabelLength(100);		
        this.contstockingBillNum.setBoundLabelUnderline(true);		
        this.contstockingBillNum.setVisible(true);
        // contdriver		
        this.contdriver.setBoundLabelText(resHelper.getString("contdriver.boundLabelText"));		
        this.contdriver.setBoundLabelLength(100);		
        this.contdriver.setBoundLabelUnderline(true);		
        this.contdriver.setVisible(true);
        // contcarNum		
        this.contcarNum.setBoundLabelText(resHelper.getString("contcarNum.boundLabelText"));		
        this.contcarNum.setBoundLabelLength(100);		
        this.contcarNum.setBoundLabelUnderline(true);		
        this.contcarNum.setVisible(true);
        // chkisinventory		
        this.chkisinventory.setText(resHelper.getString("chkisinventory.text"));		
        this.chkisinventory.setHorizontalAlignment(2);		
        this.chkisinventory.setEnabled(false);
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
        this.pkBizDate.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    pkBizDate_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
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
        this.prmtstorageOrgUnit.setEnabled(false);
        // eggSource		
        this.eggSource.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggSourceType").toArray());		
        this.eggSource.setRequired(false);
        // txtAddRows		
        this.txtAddRows.setHorizontalAlignment(2);		
        this.txtAddRows.setDataType(0);		
        this.txtAddRows.setSupportedEmpty(true);		
        this.txtAddRows.setRequired(false);
        // GrentP		
        this.GrentP.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());		
        this.GrentP.setRequired(false);
        // prmthatchfactory		
        this.prmthatchfactory.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchBaseDataQuery");		
        this.prmthatchfactory.setEditable(true);		
        this.prmthatchfactory.setDisplayFormat("$name$");		
        this.prmthatchfactory.setEditFormat("$number$");		
        this.prmthatchfactory.setCommitFormat("$number$");		
        this.prmthatchfactory.setRequired(false);
        		prmthatchfactory.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchBaseDataListUI prmthatchfactory_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmthatchfactory_F7ListUI == null) {
					try {
						prmthatchfactory_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchBaseDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmthatchfactory_F7ListUI));
					prmthatchfactory_F7ListUI.setF7Use(true,ctx);
					prmthatchfactory.setSelector(prmthatchfactory_F7ListUI);
				}
			}
		});
					
        // prmtstockingBillNum		
        this.prmtstockingBillNum.setQueryInfo("com.kingdee.eas.farm.stocking.processbizill.app.StockingBreedDailyQuery");		
        this.prmtstockingBillNum.setEditable(true);		
        this.prmtstockingBillNum.setDisplayFormat("$number$");		
        this.prmtstockingBillNum.setEditFormat("$number$");		
        this.prmtstockingBillNum.setCommitFormat("$number$");		
        this.prmtstockingBillNum.setRequired(false);
        // txtdriver		
        this.txtdriver.setHorizontalAlignment(2);		
        this.txtdriver.setMaxLength(100);		
        this.txtdriver.setRequired(false);
        // txtcarNum		
        this.txtcarNum.setHorizontalAlignment(2);		
        this.txtcarNum.setMaxLength(100);		
        this.txtcarNum.setRequired(false);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtAddRows,txtNumber,pkBizDate,prmtstorageOrgUnit,txtDescription,billStatus,prmtcompany,pkauditTime,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,eggSource,GrentP,prmthatchfactory,prmtstockingBillNum,txtdriver,txtcarNum,chkisinventory,kdtEntrys}));
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
        contNumber.setBounds(new Rectangle(25, 12, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(25, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(372, 12, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(372, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(723, 37, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(723, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(29, 570, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(29, 570, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(723, 12, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(723, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(25, 37, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(25, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(29, 598, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(29, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(18, 566, 963, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(18, 566, 963, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(20, 135, 986, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(20, 135, 986, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtEntrys.setBounds(new Rectangle(22, 177, 970, 373));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.stocking.processbizill.TheEggTableEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(22, 177, 970, 373, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contstorageOrgUnit.setBounds(new Rectangle(723, 62, 270, 19));
        this.add(contstorageOrgUnit, new KDLayout.Constraints(723, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conteggSource.setBounds(new Rectangle(25, 62, 270, 19));
        this.add(conteggSource, new KDLayout.Constraints(25, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAddRows.setBounds(new Rectangle(686, 143, 224, 19));
        this.add(contAddRows, new KDLayout.Constraints(686, 143, 224, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnAddRows.setBounds(new Rectangle(922, 143, 73, 21));
        this.add(btnAddRows, new KDLayout.Constraints(922, 143, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contGrentP.setBounds(new Rectangle(372, 64, 270, 19));
        this.add(contGrentP, new KDLayout.Constraints(372, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthatchfactory.setBounds(new Rectangle(372, 38, 270, 19));
        this.add(conthatchfactory, new KDLayout.Constraints(372, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstockingBillNum.setBounds(new Rectangle(723, 88, 270, 19));
        this.add(contstockingBillNum, new KDLayout.Constraints(723, 88, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdriver.setBounds(new Rectangle(25, 89, 270, 19));
        this.add(contdriver, new KDLayout.Constraints(25, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcarNum.setBounds(new Rectangle(372, 90, 270, 19));
        this.add(contcarNum, new KDLayout.Constraints(372, 90, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisinventory.setBounds(new Rectangle(25, 115, 128, 19));
        this.add(chkisinventory, new KDLayout.Constraints(25, 115, 128, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contGrentP
        contGrentP.setBoundEditor(GrentP);
        //conthatchfactory
        conthatchfactory.setBoundEditor(prmthatchfactory);
        //contstockingBillNum
        contstockingBillNum.setBoundEditor(prmtstockingBillNum);
        //contdriver
        contdriver.setBoundEditor(txtdriver);
        //contcarNum
        contcarNum.setBoundEditor(txtcarNum);

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
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.stocking.processbizill.TheEggTableEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.farmer", java.lang.Object.class, this.kdtEntrys, "farmer.text");
		dataBinder.registerBinding("entrys.farm", java.lang.Object.class, this.kdtEntrys, "farm.text");
		dataBinder.registerBinding("entrys.stockingBatch", java.lang.Object.class, this.kdtEntrys, "stockingBatch.text");
		dataBinder.registerBinding("entrys.costItem", java.lang.Object.class, this.kdtEntrys, "costItem.text");
		dataBinder.registerBinding("entrys.supplier", java.lang.Object.class, this.kdtEntrys, "supplier.text");
		dataBinder.registerBinding("entrys.dayAge", int.class, this.kdtEntrys, "dayAge.text");
		dataBinder.registerBinding("entrys.isFormal", boolean.class, this.kdtEntrys, "isFormal.text");
		dataBinder.registerBinding("entrys.sendDate", java.util.Date.class, this.kdtEntrys, "sendDate.text");
		dataBinder.registerBinding("entrys.house", java.lang.Object.class, this.kdtEntrys, "house.text");
		dataBinder.registerBinding("entrys.lot", String.class, this.kdtEntrys, "lot.text");
		dataBinder.registerBinding("entrys.sendBasketQty", java.math.BigDecimal.class, this.kdtEntrys, "sendBasketQty.text");
		dataBinder.registerBinding("entrys.confirmAllQty", java.math.BigDecimal.class, this.kdtEntrys, "confirmAllQty.text");
		dataBinder.registerBinding("entrys.confirmBasketQty", java.math.BigDecimal.class, this.kdtEntrys, "confirmBasketQty.text");
		dataBinder.registerBinding("entrys.weekAge", String.class, this.kdtEntrys, "weekAge.text");
		dataBinder.registerBinding("entrys.sendAllQty", java.math.BigDecimal.class, this.kdtEntrys, "sendAllQty.text");
		dataBinder.registerBinding("entrys.farmersTree", java.lang.Object.class, this.kdtEntrys, "farmersTree.text");
		dataBinder.registerBinding("entrys.hasConfirm", boolean.class, this.kdtEntrys, "hasConfirm.text");
		dataBinder.registerBinding("entrys.confirmTime", java.util.Date.class, this.kdtEntrys, "confirmTime.text");
		dataBinder.registerBinding("entrys.qualified", java.math.BigDecimal.class, this.kdtEntrys, "qualified.text");
		dataBinder.registerBinding("entrys.Squalified", java.math.BigDecimal.class, this.kdtEntrys, "Squalified.text");
		dataBinder.registerBinding("entrys.ccd", java.math.BigDecimal.class, this.kdtEntrys, "ccd.text");
		dataBinder.registerBinding("entrys.jxd", java.math.BigDecimal.class, this.kdtEntrys, "jxd.text");
		dataBinder.registerBinding("entrys.shd", java.math.BigDecimal.class, this.kdtEntrys, "shd.text");
		dataBinder.registerBinding("entrys.zd", java.math.BigDecimal.class, this.kdtEntrys, "zd.text");
		dataBinder.registerBinding("entrys.rd", java.math.BigDecimal.class, this.kdtEntrys, "rd.text");
		dataBinder.registerBinding("entrys.dpd", java.math.BigDecimal.class, this.kdtEntrys, "dpd.text");
		dataBinder.registerBinding("entrys.pd", java.math.BigDecimal.class, this.kdtEntrys, "pd.text");
		dataBinder.registerBinding("entrys.dz", java.math.BigDecimal.class, this.kdtEntrys, "dz.text");
		dataBinder.registerBinding("entrys.fxd", java.math.BigDecimal.class, this.kdtEntrys, "fxd.text");
		dataBinder.registerBinding("entrys.bz", String.class, this.kdtEntrys, "bz.text");
		dataBinder.registerBinding("entrys.serial", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "serial.text");
		dataBinder.registerBinding("entrys.breedData", java.lang.Object.class, this.kdtEntrys, "breedData.text");
		dataBinder.registerBinding("entrys.dissharpEgg", java.math.BigDecimal.class, this.kdtEntrys, "dissharpEgg.text");
		dataBinder.registerBinding("entrys.doubleEgg", java.math.BigDecimal.class, this.kdtEntrys, "doubleEgg.text");
		dataBinder.registerBinding("entrys.qualifieds", java.math.BigDecimal.class, this.kdtEntrys, "qualifieds.text");
		dataBinder.registerBinding("entrys.jxds", java.math.BigDecimal.class, this.kdtEntrys, "jxds.text");
		dataBinder.registerBinding("entrys.shds", java.math.BigDecimal.class, this.kdtEntrys, "shds.text");
		dataBinder.registerBinding("entrys.bzz", String.class, this.kdtEntrys, "bzz.text");
		dataBinder.registerBinding("entrys.BBQty", java.math.BigDecimal.class, this.kdtEntrys, "BBQty.text");
		dataBinder.registerBinding("isinventory", boolean.class, this.chkisinventory, "selected");
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
		dataBinder.registerBinding("GrentP", com.kingdee.eas.farm.stocking.hatch.GenderType.class, this.GrentP, "selectedItem");
		dataBinder.registerBinding("hatchfactory", com.kingdee.eas.farm.hatch.HatchBaseDataInfo.class, this.prmthatchfactory, "data");
		dataBinder.registerBinding("stockingBillNum", com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo.class, this.prmtstockingBillNum, "data");
		dataBinder.registerBinding("driver", String.class, this.txtdriver, "text");
		dataBinder.registerBinding("carNum", String.class, this.txtcarNum, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.processbizill.app.TheEggTableEditUIHandler";
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
        this.txtAddRows.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.stockingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.costItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dayAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isFormal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sendDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lot", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sendBasketQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.confirmAllQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.confirmBasketQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.weekAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sendAllQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farmersTree", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hasConfirm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.confirmTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qualified", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Squalified", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.ccd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.jxd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.shd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.zd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.rd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dpd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fxd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.bz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.serial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dissharpEgg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.doubleEgg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qualifieds", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.jxds", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.shds", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.bzz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.BBQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isinventory", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("GrentP", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchfactory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stockingBillNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carNum", ValidateHelper.ON_SAVE);    		
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
     * output pkBizDate_dataChanged method
     */
    protected void pkBizDate_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
      pkBizDate_dataChanged(e);
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
			sic.add(new SelectorItemInfo("entrys.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.supplier.id"));
			sic.add(new SelectorItemInfo("entrys.supplier.name"));
        	sic.add(new SelectorItemInfo("entrys.supplier.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.dayAge"));
    	sic.add(new SelectorItemInfo("entrys.isFormal"));
    	sic.add(new SelectorItemInfo("entrys.sendDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.house.id"));
			sic.add(new SelectorItemInfo("entrys.house.name"));
        	sic.add(new SelectorItemInfo("entrys.house.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.lot"));
    	sic.add(new SelectorItemInfo("entrys.sendBasketQty"));
    	sic.add(new SelectorItemInfo("entrys.confirmAllQty"));
    	sic.add(new SelectorItemInfo("entrys.confirmBasketQty"));
    	sic.add(new SelectorItemInfo("entrys.weekAge"));
    	sic.add(new SelectorItemInfo("entrys.sendAllQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.farmersTree.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.farmersTree.id"));
			sic.add(new SelectorItemInfo("entrys.farmersTree.name"));
        	sic.add(new SelectorItemInfo("entrys.farmersTree.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.hasConfirm"));
    	sic.add(new SelectorItemInfo("entrys.confirmTime"));
    	sic.add(new SelectorItemInfo("entrys.qualified"));
    	sic.add(new SelectorItemInfo("entrys.Squalified"));
    	sic.add(new SelectorItemInfo("entrys.ccd"));
    	sic.add(new SelectorItemInfo("entrys.jxd"));
    	sic.add(new SelectorItemInfo("entrys.shd"));
    	sic.add(new SelectorItemInfo("entrys.zd"));
    	sic.add(new SelectorItemInfo("entrys.rd"));
    	sic.add(new SelectorItemInfo("entrys.dpd"));
    	sic.add(new SelectorItemInfo("entrys.pd"));
    	sic.add(new SelectorItemInfo("entrys.dz"));
    	sic.add(new SelectorItemInfo("entrys.fxd"));
    	sic.add(new SelectorItemInfo("entrys.bz"));
    	sic.add(new SelectorItemInfo("entrys.serial"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.breedData.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.breedData.id"));
			sic.add(new SelectorItemInfo("entrys.breedData.name"));
        	sic.add(new SelectorItemInfo("entrys.breedData.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.dissharpEgg"));
    	sic.add(new SelectorItemInfo("entrys.doubleEgg"));
    	sic.add(new SelectorItemInfo("entrys.qualifieds"));
    	sic.add(new SelectorItemInfo("entrys.jxds"));
    	sic.add(new SelectorItemInfo("entrys.shds"));
    	sic.add(new SelectorItemInfo("entrys.bzz"));
    	sic.add(new SelectorItemInfo("entrys.BBQty"));
        sic.add(new SelectorItemInfo("isinventory"));
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
        sic.add(new SelectorItemInfo("GrentP"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("hatchfactory.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("hatchfactory.id"));
        	sic.add(new SelectorItemInfo("hatchfactory.number"));
        	sic.add(new SelectorItemInfo("hatchfactory.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stockingBillNum.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stockingBillNum.id"));
        	sic.add(new SelectorItemInfo("stockingBillNum.number"));
		}
        sic.add(new SelectorItemInfo("driver"));
        sic.add(new SelectorItemInfo("carNum"));
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
        com.kingdee.eas.farm.stocking.processbizill.TheEggTableFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.TheEggTableFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionShowPriceCol_actionPerformed method
     */
    public void actionShowPriceCol_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.TheEggTableFactory.getRemoteInstance().showPriceCol(editData);
    }
    	

    /**
     * output actionViewAllBill_actionPerformed method
     */
    public void actionViewAllBill_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.TheEggTableFactory.getRemoteInstance().viewAllBill(editData);
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
            innerActionPerformed("eas", AbstractTheEggTableEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractTheEggTableEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractTheEggTableEditUI.this, "ActionShowPriceCol", "actionShowPriceCol_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractTheEggTableEditUI.this, "ActionViewAllBill", "actionViewAllBill_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.client", "TheEggTableEditUI");
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
        return com.kingdee.eas.farm.stocking.processbizill.client.TheEggTableEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.processbizill.TheEggTableFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/stocking/processbizill/TheEggTable";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.app.TheEggTableQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"sendAllQty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"报送数量"});
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
			setTableToSumField(kdtEntrys,new String[] {"qualified","jxd","shd","dissharpEgg","doubleEgg"});
		}


}