/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.weight.client;

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
public abstract class AbstractCarSendBillEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlCoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCarSendBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecycleDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurchaseType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurchaseMethod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contestRecycleQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contestRecycleWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcar;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandardMileage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerCell;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhouseBefore;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbasketQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplier;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkrecycleDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox purchaseType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox purchaseMethod;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtestRecycleQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtestRecycleWgt;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcar;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriver;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualReachDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriverCell;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreachFactoryDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweightNum;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdriver;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkactualReachDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdriverCell;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkreachFactoryDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtweightNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttareFirstTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttareSecondTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttareFirstQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttareSecondQty;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pktareFirstTime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pktareSecondTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttareFirstQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttareSecondQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandardMileage;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmer;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmerCell;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbasketQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsupplier;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmAddress;
    protected com.kingdee.eas.custom.taihe.weight.CarSendBillInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractCarSendBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCarSendBillEditUI.class.getName());
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
        this.contrecycleDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpurchaseType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpurchaseMethod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contestRecycleQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contestRecycleWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandardMileage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmerCell = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkhouseBefore = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contbasketQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsupplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.pkrecycleDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.purchaseType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.purchaseMethod = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtestRecycleQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtestRecycleWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contdriver = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualReachDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriverCell = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contreachFactoryDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweightNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtdriver = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkactualReachDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtdriverCell = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkreachFactoryDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtweightNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.conttareFirstTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttareSecondTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttareFirstQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttareSecondQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.pktareFirstTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pktareSecondTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txttareFirstQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttareSecondQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtstandardMileage = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfarmer = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfarmerCell = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbasketQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtsupplier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfarmAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contrecycleDate.setName("contrecycleDate");
        this.contpurchaseType.setName("contpurchaseType");
        this.contpurchaseMethod.setName("contpurchaseMethod");
        this.contestRecycleQty.setName("contestRecycleQty");
        this.contestRecycleWgt.setName("contestRecycleWgt");
        this.contcar.setName("contcar");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.kDSeparator8.setName("kDSeparator8");
        this.contcompany.setName("contcompany");
        this.contstandardMileage.setName("contstandardMileage");
        this.contfarmer.setName("contfarmer");
        this.contfarmerCell.setName("contfarmerCell");
        this.chkhouseBefore.setName("chkhouseBefore");
        this.contbasketQty.setName("contbasketQty");
        this.contsupplier.setName("contsupplier");
        this.contfarmAddress.setName("contfarmAddress");
        this.pkrecycleDate.setName("pkrecycleDate");
        this.purchaseType.setName("purchaseType");
        this.purchaseMethod.setName("purchaseMethod");
        this.txtestRecycleQty.setName("txtestRecycleQty");
        this.txtestRecycleWgt.setName("txtestRecycleWgt");
        this.prmtcar.setName("prmtcar");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.contdriver.setName("contdriver");
        this.contactualReachDate.setName("contactualReachDate");
        this.contdriverCell.setName("contdriverCell");
        this.contreachFactoryDate.setName("contreachFactoryDate");
        this.contweightNum.setName("contweightNum");
        this.prmtdriver.setName("prmtdriver");
        this.pkactualReachDate.setName("pkactualReachDate");
        this.txtdriverCell.setName("txtdriverCell");
        this.pkreachFactoryDate.setName("pkreachFactoryDate");
        this.txtweightNum.setName("txtweightNum");
        this.conttareFirstTime.setName("conttareFirstTime");
        this.conttareSecondTime.setName("conttareSecondTime");
        this.conttareFirstQty.setName("conttareFirstQty");
        this.conttareSecondQty.setName("conttareSecondQty");
        this.pktareFirstTime.setName("pktareFirstTime");
        this.pktareSecondTime.setName("pktareSecondTime");
        this.txttareFirstQty.setName("txttareFirstQty");
        this.txttareSecondQty.setName("txttareSecondQty");
        this.prmtcompany.setName("prmtcompany");
        this.txtstandardMileage.setName("txtstandardMileage");
        this.txtfarmer.setName("txtfarmer");
        this.txtfarmerCell.setName("txtfarmerCell");
        this.txtbasketQty.setName("txtbasketQty");
        this.prmtsupplier.setName("prmtsupplier");
        this.txtfarmAddress.setName("txtfarmAddress");
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
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
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
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);		
        this.prmtCreator.setEnabled(false);		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.txtNumber.setMaxLength(80);		
        this.pkBizDate.setVisible(true);		
        this.pkBizDate.setEnabled(true);		
        this.txtDescription.setMaxLength(80);		
        this.prmtAuditor.setEnabled(false);		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // contrecycleDate		
        this.contrecycleDate.setBoundLabelText(resHelper.getString("contrecycleDate.boundLabelText"));		
        this.contrecycleDate.setBoundLabelLength(100);		
        this.contrecycleDate.setBoundLabelUnderline(true);		
        this.contrecycleDate.setVisible(true);
        // contpurchaseType		
        this.contpurchaseType.setBoundLabelText(resHelper.getString("contpurchaseType.boundLabelText"));		
        this.contpurchaseType.setBoundLabelLength(100);		
        this.contpurchaseType.setBoundLabelUnderline(true);		
        this.contpurchaseType.setVisible(true);
        // contpurchaseMethod		
        this.contpurchaseMethod.setBoundLabelText(resHelper.getString("contpurchaseMethod.boundLabelText"));		
        this.contpurchaseMethod.setBoundLabelLength(100);		
        this.contpurchaseMethod.setBoundLabelUnderline(true);		
        this.contpurchaseMethod.setVisible(true);
        // contestRecycleQty		
        this.contestRecycleQty.setBoundLabelText(resHelper.getString("contestRecycleQty.boundLabelText"));		
        this.contestRecycleQty.setBoundLabelLength(100);		
        this.contestRecycleQty.setBoundLabelUnderline(true);		
        this.contestRecycleQty.setVisible(true);
        // contestRecycleWgt		
        this.contestRecycleWgt.setBoundLabelText(resHelper.getString("contestRecycleWgt.boundLabelText"));		
        this.contestRecycleWgt.setBoundLabelLength(100);		
        this.contestRecycleWgt.setBoundLabelUnderline(true);		
        this.contestRecycleWgt.setVisible(true);
        // contcar		
        this.contcar.setBoundLabelText(resHelper.getString("contcar.boundLabelText"));		
        this.contcar.setBoundLabelLength(100);		
        this.contcar.setBoundLabelUnderline(true);		
        this.contcar.setVisible(true);
        // kDTabbedPane1
        // kDSeparator8
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contstandardMileage		
        this.contstandardMileage.setBoundLabelText(resHelper.getString("contstandardMileage.boundLabelText"));		
        this.contstandardMileage.setBoundLabelLength(100);		
        this.contstandardMileage.setBoundLabelUnderline(true);		
        this.contstandardMileage.setVisible(true);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
        // contfarmerCell		
        this.contfarmerCell.setBoundLabelText(resHelper.getString("contfarmerCell.boundLabelText"));		
        this.contfarmerCell.setBoundLabelLength(100);		
        this.contfarmerCell.setBoundLabelUnderline(true);		
        this.contfarmerCell.setVisible(true);
        // chkhouseBefore		
        this.chkhouseBefore.setText(resHelper.getString("chkhouseBefore.text"));		
        this.chkhouseBefore.setVisible(false);		
        this.chkhouseBefore.setHorizontalAlignment(2);
        // contbasketQty		
        this.contbasketQty.setBoundLabelText(resHelper.getString("contbasketQty.boundLabelText"));		
        this.contbasketQty.setBoundLabelLength(100);		
        this.contbasketQty.setBoundLabelUnderline(true);		
        this.contbasketQty.setVisible(true);
        // contsupplier		
        this.contsupplier.setBoundLabelText(resHelper.getString("contsupplier.boundLabelText"));		
        this.contsupplier.setBoundLabelLength(100);		
        this.contsupplier.setBoundLabelUnderline(true);		
        this.contsupplier.setVisible(true);
        // contfarmAddress		
        this.contfarmAddress.setBoundLabelText(resHelper.getString("contfarmAddress.boundLabelText"));		
        this.contfarmAddress.setBoundLabelLength(100);		
        this.contfarmAddress.setBoundLabelUnderline(true);		
        this.contfarmAddress.setVisible(true);
        // pkrecycleDate		
        this.pkrecycleDate.setVisible(true);		
        this.pkrecycleDate.setRequired(true);
        // purchaseType		
        this.purchaseType.setVisible(true);		
        this.purchaseType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.taihe.weight.PurchaseType").toArray());		
        this.purchaseType.setRequired(true);
        // purchaseMethod		
        this.purchaseMethod.setVisible(true);		
        this.purchaseMethod.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.taihe.weight.PurchaseMethod").toArray());		
        this.purchaseMethod.setRequired(true);
        // txtestRecycleQty		
        this.txtestRecycleQty.setVisible(true);		
        this.txtestRecycleQty.setHorizontalAlignment(2);		
        this.txtestRecycleQty.setDataType(1);		
        this.txtestRecycleQty.setSupportedEmpty(true);		
        this.txtestRecycleQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtestRecycleQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtestRecycleQty.setPrecision(4);		
        this.txtestRecycleQty.setRequired(false);
        // txtestRecycleWgt		
        this.txtestRecycleWgt.setVisible(true);		
        this.txtestRecycleWgt.setHorizontalAlignment(2);		
        this.txtestRecycleWgt.setDataType(1);		
        this.txtestRecycleWgt.setSupportedEmpty(true);		
        this.txtestRecycleWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtestRecycleWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtestRecycleWgt.setPrecision(4);		
        this.txtestRecycleWgt.setRequired(false);
        // prmtcar		
        this.prmtcar.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");		
        this.prmtcar.setVisible(true);		
        this.prmtcar.setEditable(true);		
        this.prmtcar.setDisplayFormat("$number$");		
        this.prmtcar.setEditFormat("$number$");		
        this.prmtcar.setCommitFormat("$number$");		
        this.prmtcar.setRequired(true);
        		prmtcar.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI prmtcar_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtcar_F7ListUI == null) {
					try {
						prmtcar_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtcar_F7ListUI));
					prmtcar_F7ListUI.setF7Use(true,ctx);
					prmtcar.setSelector(prmtcar_F7ListUI);
				}
			}
		});
					
        // kDPanel1
        // kDPanel2
        // contdriver		
        this.contdriver.setBoundLabelText(resHelper.getString("contdriver.boundLabelText"));		
        this.contdriver.setBoundLabelLength(100);		
        this.contdriver.setBoundLabelUnderline(true);		
        this.contdriver.setVisible(true);
        // contactualReachDate		
        this.contactualReachDate.setBoundLabelText(resHelper.getString("contactualReachDate.boundLabelText"));		
        this.contactualReachDate.setBoundLabelLength(100);		
        this.contactualReachDate.setBoundLabelUnderline(true);		
        this.contactualReachDate.setVisible(true);
        // contdriverCell		
        this.contdriverCell.setBoundLabelText(resHelper.getString("contdriverCell.boundLabelText"));		
        this.contdriverCell.setBoundLabelLength(100);		
        this.contdriverCell.setBoundLabelUnderline(true);		
        this.contdriverCell.setVisible(true);
        // contreachFactoryDate		
        this.contreachFactoryDate.setBoundLabelText(resHelper.getString("contreachFactoryDate.boundLabelText"));		
        this.contreachFactoryDate.setBoundLabelLength(100);		
        this.contreachFactoryDate.setBoundLabelUnderline(true);		
        this.contreachFactoryDate.setVisible(true);
        // contweightNum		
        this.contweightNum.setBoundLabelText(resHelper.getString("contweightNum.boundLabelText"));		
        this.contweightNum.setBoundLabelLength(100);		
        this.contweightNum.setBoundLabelUnderline(true);		
        this.contweightNum.setVisible(true);
        // prmtdriver		
        this.prmtdriver.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");		
        this.prmtdriver.setVisible(true);		
        this.prmtdriver.setEditable(true);		
        this.prmtdriver.setDisplayFormat("$drivername$");		
        this.prmtdriver.setEditFormat("$number$");		
        this.prmtdriver.setCommitFormat("$number$");		
        this.prmtdriver.setRequired(false);
        		prmtdriver.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI prmtdriver_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtdriver_F7ListUI == null) {
					try {
						prmtdriver_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtdriver_F7ListUI));
					prmtdriver_F7ListUI.setF7Use(true,ctx);
					prmtdriver.setSelector(prmtdriver_F7ListUI);
				}
			}
		});
					
        prmtdriver.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtdriver_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // pkactualReachDate		
        this.pkactualReachDate.setVisible(true);		
        this.pkactualReachDate.setRequired(false);
        // txtdriverCell		
        this.txtdriverCell.setVisible(true);		
        this.txtdriverCell.setHorizontalAlignment(2);		
        this.txtdriverCell.setMaxLength(80);		
        this.txtdriverCell.setRequired(false);
        // pkreachFactoryDate		
        this.pkreachFactoryDate.setVisible(true);		
        this.pkreachFactoryDate.setRequired(true);
        // txtweightNum		
        this.txtweightNum.setVisible(true);		
        this.txtweightNum.setHorizontalAlignment(2);		
        this.txtweightNum.setMaxLength(100);		
        this.txtweightNum.setRequired(false);		
        this.txtweightNum.setEnabled(false);
        // conttareFirstTime		
        this.conttareFirstTime.setBoundLabelText(resHelper.getString("conttareFirstTime.boundLabelText"));		
        this.conttareFirstTime.setBoundLabelLength(100);		
        this.conttareFirstTime.setBoundLabelUnderline(true);		
        this.conttareFirstTime.setVisible(true);
        // conttareSecondTime		
        this.conttareSecondTime.setBoundLabelText(resHelper.getString("conttareSecondTime.boundLabelText"));		
        this.conttareSecondTime.setBoundLabelLength(100);		
        this.conttareSecondTime.setBoundLabelUnderline(true);		
        this.conttareSecondTime.setVisible(true);
        // conttareFirstQty		
        this.conttareFirstQty.setBoundLabelText(resHelper.getString("conttareFirstQty.boundLabelText"));		
        this.conttareFirstQty.setBoundLabelLength(100);		
        this.conttareFirstQty.setBoundLabelUnderline(true);		
        this.conttareFirstQty.setVisible(false);
        // conttareSecondQty		
        this.conttareSecondQty.setBoundLabelText(resHelper.getString("conttareSecondQty.boundLabelText"));		
        this.conttareSecondQty.setBoundLabelLength(100);		
        this.conttareSecondQty.setBoundLabelUnderline(true);		
        this.conttareSecondQty.setVisible(false);
        // pktareFirstTime		
        this.pktareFirstTime.setVisible(true);		
        this.pktareFirstTime.setRequired(false);
        // pktareSecondTime		
        this.pktareSecondTime.setVisible(true);		
        this.pktareSecondTime.setRequired(false);
        // txttareFirstQty		
        this.txttareFirstQty.setVisible(true);		
        this.txttareFirstQty.setHorizontalAlignment(2);		
        this.txttareFirstQty.setDataType(1);		
        this.txttareFirstQty.setSupportedEmpty(true);		
        this.txttareFirstQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttareFirstQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttareFirstQty.setPrecision(4);		
        this.txttareFirstQty.setRequired(false);
        // txttareSecondQty		
        this.txttareSecondQty.setVisible(true);		
        this.txttareSecondQty.setHorizontalAlignment(2);		
        this.txttareSecondQty.setDataType(1);		
        this.txttareSecondQty.setSupportedEmpty(true);		
        this.txttareSecondQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttareSecondQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttareSecondQty.setPrecision(4);		
        this.txttareSecondQty.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // txtstandardMileage		
        this.txtstandardMileage.setVisible(true);		
        this.txtstandardMileage.setHorizontalAlignment(2);		
        this.txtstandardMileage.setDataType(1);		
        this.txtstandardMileage.setSupportedEmpty(true);		
        this.txtstandardMileage.setMinimumValue( new java.math.BigDecimal("-3.4028234663852886E38"));		
        this.txtstandardMileage.setMaximumValue( new java.math.BigDecimal("3.4028234663852886E38"));		
        this.txtstandardMileage.setPrecision(10);		
        this.txtstandardMileage.setRequired(false);		
        this.txtstandardMileage.setEnabled(false);
        // txtfarmer		
        this.txtfarmer.setVisible(true);		
        this.txtfarmer.setHorizontalAlignment(2);		
        this.txtfarmer.setMaxLength(80);		
        this.txtfarmer.setRequired(false);		
        this.txtfarmer.setEnabled(false);
        // txtfarmerCell		
        this.txtfarmerCell.setVisible(true);		
        this.txtfarmerCell.setHorizontalAlignment(2);		
        this.txtfarmerCell.setMaxLength(80);		
        this.txtfarmerCell.setRequired(false);		
        this.txtfarmerCell.setEnabled(false);
        // txtbasketQty		
        this.txtbasketQty.setVisible(true);		
        this.txtbasketQty.setHorizontalAlignment(2);		
        this.txtbasketQty.setDataType(1);		
        this.txtbasketQty.setSupportedEmpty(true);		
        this.txtbasketQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbasketQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbasketQty.setPrecision(4);		
        this.txtbasketQty.setRequired(false);
        // prmtsupplier		
        this.prmtsupplier.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");		
        this.prmtsupplier.setVisible(true);		
        this.prmtsupplier.setEditable(true);		
        this.prmtsupplier.setDisplayFormat("$name$");		
        this.prmtsupplier.setEditFormat("$number$");		
        this.prmtsupplier.setCommitFormat("$number$");		
        this.prmtsupplier.setRequired(false);
        // txtfarmAddress		
        this.txtfarmAddress.setVisible(true);		
        this.txtfarmAddress.setHorizontalAlignment(2);		
        this.txtfarmAddress.setMaxLength(80);		
        this.txtfarmAddress.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkrecycleDate,purchaseType,purchaseMethod,txtestRecycleQty,txtestRecycleWgt,prmtcar,prmtdriver,txtdriverCell,pkreachFactoryDate,pkactualReachDate,billStatus,pkauditTime,txtweightNum,pktareFirstTime,pktareSecondTime,txttareFirstQty,txttareSecondQty,prmtcompany,txtstandardMileage,txtfarmer,txtfarmerCell,chkhouseBefore,txtbasketQty,prmtsupplier,txtfarmAddress}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 539));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 539));
        contCreator.setBounds(new Rectangle(373, 452, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(373, 452, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(712, 452, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(712, 452, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(373, 491, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(373, 491, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(712, 491, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(712, 491, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(35, 16, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(35, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(373, 16, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(373, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(35, 452, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(35, 452, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(35, 491, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(35, 491, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(712, 16, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(712, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contrecycleDate.setBounds(new Rectangle(35, 50, 270, 19));
        this.add(contrecycleDate, new KDLayout.Constraints(35, 50, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpurchaseType.setBounds(new Rectangle(373, 50, 270, 19));
        this.add(contpurchaseType, new KDLayout.Constraints(373, 50, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpurchaseMethod.setBounds(new Rectangle(712, 50, 270, 19));
        this.add(contpurchaseMethod, new KDLayout.Constraints(712, 50, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contestRecycleQty.setBounds(new Rectangle(712, 186, 270, 19));
        this.add(contestRecycleQty, new KDLayout.Constraints(712, 186, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contestRecycleWgt.setBounds(new Rectangle(35, 186, 270, 19));
        this.add(contestRecycleWgt, new KDLayout.Constraints(35, 186, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcar.setBounds(new Rectangle(35, 221, 270, 19));
        this.add(contcar, new KDLayout.Constraints(35, 221, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(35, 276, 959, 166));
        this.add(kDTabbedPane1, new KDLayout.Constraints(35, 276, 959, 166, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator8.setBounds(new Rectangle(35, 264, 960, 10));
        this.add(kDSeparator8, new KDLayout.Constraints(35, 264, 960, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(712, 84, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(712, 84, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contstandardMileage.setBounds(new Rectangle(712, 118, 270, 19));
        this.add(contstandardMileage, new KDLayout.Constraints(712, 118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmer.setBounds(new Rectangle(35, 118, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(35, 118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmerCell.setBounds(new Rectangle(374, 118, 270, 19));
        this.add(contfarmerCell, new KDLayout.Constraints(374, 118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkhouseBefore.setBounds(new Rectangle(373, 221, 270, 19));
        this.add(chkhouseBefore, new KDLayout.Constraints(373, 221, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbasketQty.setBounds(new Rectangle(374, 186, 270, 19));
        this.add(contbasketQty, new KDLayout.Constraints(374, 186, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsupplier.setBounds(new Rectangle(37, 152, 270, 19));
        this.add(contsupplier, new KDLayout.Constraints(37, 152, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmAddress.setBounds(new Rectangle(376, 152, 270, 19));
        this.add(contfarmAddress, new KDLayout.Constraints(376, 152, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contrecycleDate
        contrecycleDate.setBoundEditor(pkrecycleDate);
        //contpurchaseType
        contpurchaseType.setBoundEditor(purchaseType);
        //contpurchaseMethod
        contpurchaseMethod.setBoundEditor(purchaseMethod);
        //contestRecycleQty
        contestRecycleQty.setBoundEditor(txtestRecycleQty);
        //contestRecycleWgt
        contestRecycleWgt.setBoundEditor(txtestRecycleWgt);
        //contcar
        contcar.setBoundEditor(prmtcar);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 958, 133));        contDescription.setBounds(new Rectangle(341, 58, 600, 19));
        kDPanel1.add(contDescription, new KDLayout.Constraints(341, 58, 600, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdriver.setBounds(new Rectangle(9, 11, 270, 19));
        kDPanel1.add(contdriver, new KDLayout.Constraints(9, 11, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualReachDate.setBounds(new Rectangle(11, 58, 270, 19));
        kDPanel1.add(contactualReachDate, new KDLayout.Constraints(11, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdriverCell.setBounds(new Rectangle(673, 9, 270, 19));
        kDPanel1.add(contdriverCell, new KDLayout.Constraints(673, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contreachFactoryDate.setBounds(new Rectangle(341, 10, 270, 19));
        kDPanel1.add(contreachFactoryDate, new KDLayout.Constraints(341, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweightNum.setBounds(new Rectangle(11, 107, 270, 19));
        kDPanel1.add(contweightNum, new KDLayout.Constraints(11, 107, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contdriver
        contdriver.setBoundEditor(prmtdriver);
        //contactualReachDate
        contactualReachDate.setBoundEditor(pkactualReachDate);
        //contdriverCell
        contdriverCell.setBoundEditor(txtdriverCell);
        //contreachFactoryDate
        contreachFactoryDate.setBoundEditor(pkreachFactoryDate);
        //contweightNum
        contweightNum.setBoundEditor(txtweightNum);
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 958, 133));        conttareFirstTime.setBounds(new Rectangle(25, 15, 270, 19));
        kDPanel2.add(conttareFirstTime, new KDLayout.Constraints(25, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttareSecondTime.setBounds(new Rectangle(25, 52, 270, 19));
        kDPanel2.add(conttareSecondTime, new KDLayout.Constraints(25, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttareFirstQty.setBounds(new Rectangle(366, 15, 270, 19));
        kDPanel2.add(conttareFirstQty, new KDLayout.Constraints(366, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttareSecondQty.setBounds(new Rectangle(366, 52, 270, 19));
        kDPanel2.add(conttareSecondQty, new KDLayout.Constraints(366, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //conttareFirstTime
        conttareFirstTime.setBoundEditor(pktareFirstTime);
        //conttareSecondTime
        conttareSecondTime.setBoundEditor(pktareSecondTime);
        //conttareFirstQty
        conttareFirstQty.setBoundEditor(txttareFirstQty);
        //conttareSecondQty
        conttareSecondQty.setBoundEditor(txttareSecondQty);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contstandardMileage
        contstandardMileage.setBoundEditor(txtstandardMileage);
        //contfarmer
        contfarmer.setBoundEditor(txtfarmer);
        //contfarmerCell
        contfarmerCell.setBoundEditor(txtfarmerCell);
        //contbasketQty
        contbasketQty.setBoundEditor(txtbasketQty);
        //contsupplier
        contsupplier.setBoundEditor(prmtsupplier);
        //contfarmAddress
        contfarmAddress.setBoundEditor(txtfarmAddress);

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
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(menuItemDelVoucher);
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
		dataBinder.registerBinding("houseBefore", boolean.class, this.chkhouseBefore, "selected");
		dataBinder.registerBinding("recycleDate", java.util.Date.class, this.pkrecycleDate, "value");
		dataBinder.registerBinding("purchaseType", com.kingdee.eas.custom.taihe.weight.PurchaseType.class, this.purchaseType, "selectedItem");
		dataBinder.registerBinding("purchaseMethod", com.kingdee.eas.custom.taihe.weight.PurchaseMethod.class, this.purchaseMethod, "selectedItem");
		dataBinder.registerBinding("estRecycleQty", java.math.BigDecimal.class, this.txtestRecycleQty, "value");
		dataBinder.registerBinding("estRecycleWgt", java.math.BigDecimal.class, this.txtestRecycleWgt, "value");
		dataBinder.registerBinding("car", com.kingdee.eas.cp.carm.CarInfoInfo.class, this.prmtcar, "data");
		dataBinder.registerBinding("driver", com.kingdee.eas.farm.feemanager.basedata.DriverInfo.class, this.prmtdriver, "data");
		dataBinder.registerBinding("actualReachDate", java.util.Date.class, this.pkactualReachDate, "value");
		dataBinder.registerBinding("driverCell", String.class, this.txtdriverCell, "text");
		dataBinder.registerBinding("reachFactoryDate", java.util.Date.class, this.pkreachFactoryDate, "value");
		dataBinder.registerBinding("weightNum", String.class, this.txtweightNum, "text");
		dataBinder.registerBinding("tareFirstTime", java.util.Date.class, this.pktareFirstTime, "value");
		dataBinder.registerBinding("tareSecondTime", java.util.Date.class, this.pktareSecondTime, "value");
		dataBinder.registerBinding("tareFirstQty", java.math.BigDecimal.class, this.txttareFirstQty, "value");
		dataBinder.registerBinding("tareSecondQty", java.math.BigDecimal.class, this.txttareSecondQty, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("standardMileage", java.math.BigDecimal.class, this.txtstandardMileage, "value");
		dataBinder.registerBinding("farmer", String.class, this.txtfarmer, "text");
		dataBinder.registerBinding("farmerCell", String.class, this.txtfarmerCell, "text");
		dataBinder.registerBinding("basketQty", java.math.BigDecimal.class, this.txtbasketQty, "value");
		dataBinder.registerBinding("supplier", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtsupplier, "data");
		dataBinder.registerBinding("farmAddress", String.class, this.txtfarmAddress, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.taihe.weight.app.CarSendBillEditUIHandler";
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
        this.pkrecycleDate.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.taihe.weight.CarSendBillInfo)ov;
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
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("houseBefore", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recycleDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purchaseType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purchaseMethod", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("estRecycleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("estRecycleWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualReachDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driverCell", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("reachFactoryDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weightNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tareFirstTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tareSecondTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tareFirstQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tareSecondQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standardMileage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerCell", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("basketQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmAddress", ValidateHelper.ON_SAVE);    		
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
     * output prmtdriver_Changed() method
     */
    public void prmtdriver_Changed() throws Exception
    {
        System.out.println("prmtdriver_Changed() Function is executed!");
            txtdriverCell.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtdriver.getData(),"driverphone")));


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
        sic.add(new SelectorItemInfo("houseBefore"));
        sic.add(new SelectorItemInfo("recycleDate"));
        sic.add(new SelectorItemInfo("purchaseType"));
        sic.add(new SelectorItemInfo("purchaseMethod"));
        sic.add(new SelectorItemInfo("estRecycleQty"));
        sic.add(new SelectorItemInfo("estRecycleWgt"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("car.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("car.id"));
        	sic.add(new SelectorItemInfo("car.number"));
        	sic.add(new SelectorItemInfo("car.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("driver.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("driver.id"));
        	sic.add(new SelectorItemInfo("driver.number"));
        	sic.add(new SelectorItemInfo("driver.name"));
        	sic.add(new SelectorItemInfo("driver.drivername"));
		}
        sic.add(new SelectorItemInfo("actualReachDate"));
        sic.add(new SelectorItemInfo("driverCell"));
        sic.add(new SelectorItemInfo("reachFactoryDate"));
        sic.add(new SelectorItemInfo("weightNum"));
        sic.add(new SelectorItemInfo("tareFirstTime"));
        sic.add(new SelectorItemInfo("tareSecondTime"));
        sic.add(new SelectorItemInfo("tareFirstQty"));
        sic.add(new SelectorItemInfo("tareSecondQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("standardMileage"));
        sic.add(new SelectorItemInfo("farmer"));
        sic.add(new SelectorItemInfo("farmerCell"));
        sic.add(new SelectorItemInfo("basketQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("supplier.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("supplier.id"));
        	sic.add(new SelectorItemInfo("supplier.number"));
        	sic.add(new SelectorItemInfo("supplier.name"));
		}
        sic.add(new SelectorItemInfo("farmAddress"));
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

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.taihe.weight.client", "CarSendBillEditUI");
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
        return com.kingdee.eas.custom.taihe.weight.client.CarSendBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.weight.CarSendBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.weight.CarSendBillInfo objectValue = new com.kingdee.eas.custom.taihe.weight.CarSendBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/taihe/weight/CarSendBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.taihe.weight.app.CarSendBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkrecycleDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"回收日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(purchaseType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"收购类型"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(purchaseMethod.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"收购方式"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcar.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"车辆"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkreachFactoryDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"要求到厂日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {        
        return null;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("purchaseMethod","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}