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
public abstract class AbstractEggSettleBillListUI extends com.kingdee.eas.framework.client.CoreBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractEggSettleBillListUI.class);
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnBatchSubmit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator6;
    protected ActionTDPrint actionTDPrint = null;
    protected ActionTDPrintPreview actionTDPrintPreview = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionShowPriceCol actionShowPriceCol = null;
    protected ActionExeSettle actionExeSettle = null;
    protected ActionBatchSubmit actionBatchSubmit = null;
    public final static String STATUS_VIEW = "VIEW";
    /**
     * output class constructor
     */
    public AbstractEggSettleBillListUI() throws Exception
    {
        super();
        this.defaultObjectName = "mainQuery";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractEggSettleBillListUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        mainQueryPK = new MetaDataPK("com.kingdee.eas.farm.stocking.hatch.app", "EggSettleBillQuery");
        //actionRemove
        String _tempStr = null;
        actionRemove.setEnabled(true);
        actionRemove.setDaemonRun(false);

        actionRemove.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl D"));
        _tempStr = resHelper.getString("ActionRemove.SHORT_DESCRIPTION");
        actionRemove.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionRemove.LONG_DESCRIPTION");
        actionRemove.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionRemove.NAME");
        actionRemove.putValue(ItemAction.NAME, _tempStr);
        this.actionRemove.setBindWorkFlow(true);
         this.actionRemove.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionRemove.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionRemove.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionTDPrint
        this.actionTDPrint = new ActionTDPrint(this);
        getActionManager().registerAction("actionTDPrint", actionTDPrint);
         this.actionTDPrint.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionTDPrintPreview
        this.actionTDPrintPreview = new ActionTDPrintPreview(this);
        getActionManager().registerAction("actionTDPrintPreview", actionTDPrintPreview);
         this.actionTDPrintPreview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
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
        //actionBatchSubmit
        this.actionBatchSubmit = new ActionBatchSubmit(this);
        getActionManager().registerAction("actionBatchSubmit", actionBatchSubmit);
        this.actionBatchSubmit.setBindWorkFlow(true);
        this.actionBatchSubmit.setExtendProperty("canForewarn", "true");
        this.actionBatchSubmit.setExtendProperty("userDefined", "false");
        this.actionBatchSubmit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionBatchSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionBatchSubmit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionBatchSubmit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        this.btnBatchSubmit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.newSeparator6 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.btnBatchSubmit.setName("btnBatchSubmit");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        this.newSeparator6.setName("newSeparator6");
        // CoreUI
		String tblMainStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol14\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"company.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"storageOrgUnit.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"description\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isInit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"creator.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"createTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"auditor.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"auditTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" /><t:Column t:key=\"entrys.id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" t:styleID=\"sCol13\" /><t:Column t:key=\"entrys.seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" t:styleID=\"sCol14\" /><t:Column t:key=\"qualityRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" t:styleID=\"sCol15\" /><t:Column t:key=\"badRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" t:styleID=\"sCol16\" /><t:Column t:key=\"settleAmout\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"17\" /><t:Column t:key=\"entrys.sendDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"18\" /><t:Column t:key=\"entrys.weekAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"19\" /><t:Column t:key=\"entrys.dayAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"20\" /><t:Column t:key=\"entrys.isFormal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"21\" /><t:Column t:key=\"entrys.settleItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"22\" /><t:Column t:key=\"entrys.unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"23\" /><t:Column t:key=\"entrys.num\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"24\" /><t:Column t:key=\"entrys.settleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"25\" /><t:Column t:key=\"entrys.price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"26\" /><t:Column t:key=\"entrys.amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"27\" /><t:Column t:key=\"entrys.eggPriceSource\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"28\" /><t:Column t:key=\"entrys.wareHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"29\" /><t:Column t:key=\"entrys.costItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"30\" /><t:Column t:key=\"srcRecBill\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"31\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{company.name}</t:Cell><t:Cell>$Resource{storageOrgUnit.name}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{isInit}</t:Cell><t:Cell>$Resource{billStatus}</t:Cell><t:Cell>$Resource{creator.name}</t:Cell><t:Cell>$Resource{createTime}</t:Cell><t:Cell>$Resource{auditor.name}</t:Cell><t:Cell>$Resource{auditTime}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{entrys.id}</t:Cell><t:Cell>$Resource{entrys.seq}</t:Cell><t:Cell>$Resource{qualityRate}</t:Cell><t:Cell>$Resource{badRate}</t:Cell><t:Cell>$Resource{settleAmout}</t:Cell><t:Cell>$Resource{entrys.sendDate}</t:Cell><t:Cell>$Resource{entrys.weekAge}</t:Cell><t:Cell>$Resource{entrys.dayAge}</t:Cell><t:Cell>$Resource{entrys.isFormal}</t:Cell><t:Cell>$Resource{entrys.settleItem}</t:Cell><t:Cell>$Resource{entrys.unit}</t:Cell><t:Cell>$Resource{entrys.num}</t:Cell><t:Cell>$Resource{entrys.settleQty}</t:Cell><t:Cell>$Resource{entrys.price}</t:Cell><t:Cell>$Resource{entrys.amount}</t:Cell><t:Cell>$Resource{entrys.eggPriceSource}</t:Cell><t:Cell>$Resource{entrys.wareHouse}</t:Cell><t:Cell>$Resource{entrys.costItem}</t:Cell><t:Cell>$Resource{srcRecBill}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tblMain.setFormatXml(resHelper.translateString("tblMain",tblMainStrXML));
                this.tblMain.putBindContents("mainQuery",new String[] {"id","number","bizDate","company.name","storageOrgUnit.name","description","isInit","billStatus","creator.name","createTime","auditor.name","auditTime","farmer.name","","","qualityRate","badRate","amount","entrys.sendDate","entrys.weekAge","entrys.dayAge","entrys.isFormal","settleItem.name","unit.name","entrys.num","entrys.qty","entrys.price","entrys.amount","entrys.eggPriceType","warehouse.name","costItem.name","srcRecBill"});


        this.tblMain.checkParsed();
        this.tblMain.getGroupManager().setGroup(true);		
        this.separatorFW2.setVisible(true);		
        this.btnAuditResult.setVisible(false);		
        this.menuItemCopyTo.setVisible(false);		
        this.kDSeparator4.setVisible(false);		
        this.kDSeparator6.setVisible(false);		
        this.menuItemViewDoProccess.setVisible(false);		
        this.menuItemAuditResult.setVisible(false);
        // btnBatchSubmit
        this.btnBatchSubmit.setAction((IItemAction)ActionProxyFactory.getProxy(actionBatchSubmit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnBatchSubmit.setText(resHelper.getString("btnBatchSubmit.text"));
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
        // newSeparator6
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
        this.setBounds(new Rectangle(10, 10, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1013, 629));
        tblMain.setBounds(new Rectangle(10, 10, 996, 580));
        this.add(tblMain, new KDLayout.Constraints(10, 10, 996, 580, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));

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
        this.menuBar.add(menuTool);
        this.menuBar.add(menuWorkFlow);
        this.menuBar.add(menuTools);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(menuItemImportData);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemExportData);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(separatorFile1);
        menuFile.add(menuItemCloudShare);
        menuFile.add(MenuItemAttachment);
        menuFile.add(kDSeparator1);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(menuItemPageSetup);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemExitCurrent);
        //menuEdit
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(kDSeparator3);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(menuItemCopyTo);
        menuEdit.add(kDSeparator4);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemView);
        menuView.add(menuItemLocate);
        menuView.add(kDSeparator5);
        menuView.add(menuItemQuery);
        menuView.add(menuItemRefresh);
        menuView.add(menuItemSwitchView);
        menuView.add(separatorView1);
        menuView.add(menuItemTraceUp);
        menuView.add(menuItemTraceDown);
        menuView.add(menuItemQueryScheme);
        menuView.add(kDSeparator6);
        //menuBiz
        menuBiz.add(mBtnAudit);
        menuBiz.add(mBtnUnAudit);
        menuBiz.add(newSeparator6);
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(menuItemPCVoucher);
        menuBiz.add(menuItemVoucher);
        menuBiz.add(menuItemDelPCVoucher);
        menuBiz.add(menuItemDelVoucher);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuWorkFlow
        menuWorkFlow.add(menuItemViewDoProccess);
        menuWorkFlow.add(menuItemMultiapprove);
        menuWorkFlow.add(menuItemWorkFlowG);
        menuWorkFlow.add(menuItemWorkFlowList);
        menuWorkFlow.add(separatorWF1);
        menuWorkFlow.add(menuItemNextPerson);
        menuWorkFlow.add(menuItemAuditResult);
        menuWorkFlow.add(kDSeparator7);
        menuWorkFlow.add(menuItemSendSmsMessage);
        //menuTools
        menuTools.add(menuMail);
        menuTools.add(menuItemStartWorkFlow);
        menuTools.add(menuItemPublishReport);
        //menuMail
        menuMail.add(menuItemToHTML);
        menuMail.add(menuItemCopyScreen);
        menuMail.add(menuItemToExcel);
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
        this.toolBar.add(btnView);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnEdit);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnBatchSubmit);
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnRefresh);
        this.toolBar.add(btnQuery);
        this.toolBar.add(btnLocate);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(btnCopyTo);
        this.toolBar.add(btnQueryScheme);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnWorkFlowList);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnWFViewdoProccess);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.hatch.app.EggSettleBillListUIHandler";
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
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
    }
	protected void Remove() throws Exception {
    	IObjectValue editData = getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
    	super.Remove();
    	recycleNumberByOrg(editData,"",editData.getString("number"));
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

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        dataBinder.loadFields();
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
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
    }

	public SelectorItemCollection getBOTPSelectors() {
			SelectorItemCollection sic = new SelectorItemCollection();
			return sic;
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
        sic.add(new SelectorItemInfo("id"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("createTime"));
        sic.add(new SelectorItemInfo("lastUpdateTime"));
        sic.add(new SelectorItemInfo("auditor.number"));
        sic.add(new SelectorItemInfo("auditor.name"));
        sic.add(new SelectorItemInfo("creator.number"));
        sic.add(new SelectorItemInfo("creator.name"));
        sic.add(new SelectorItemInfo("lastUpdateUser.number"));
        sic.add(new SelectorItemInfo("lastUpdateUser.name"));
        sic.add(new SelectorItemInfo("handler.number"));
        sic.add(new SelectorItemInfo("handler.name"));
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("company.name"));
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("storageOrgUnit.name"));
        sic.add(new SelectorItemInfo("isInit"));
        sic.add(new SelectorItemInfo("qualityRate"));
        sic.add(new SelectorItemInfo("badRate"));
        sic.add(new SelectorItemInfo("settleItem.name"));
        sic.add(new SelectorItemInfo("entrys.weekAge"));
        sic.add(new SelectorItemInfo("entrys.dayAge"));
        sic.add(new SelectorItemInfo("entrys.amount"));
        sic.add(new SelectorItemInfo("entrys.isFormal"));
        sic.add(new SelectorItemInfo("unit.name"));
        sic.add(new SelectorItemInfo("entrys.num"));
        sic.add(new SelectorItemInfo("entrys.qty"));
        sic.add(new SelectorItemInfo("entrys.price"));
        sic.add(new SelectorItemInfo("entrys.eggPriceType"));
        sic.add(new SelectorItemInfo("costItem.name"));
        sic.add(new SelectorItemInfo("warehouse.name"));
        sic.add(new SelectorItemInfo("amount"));
        sic.add(new SelectorItemInfo("farmer.name"));
        sic.add(new SelectorItemInfo("srcRecBill"));
        sic.add(new SelectorItemInfo("entrys.sendDate"));
        return sic;
    }            protected java.util.List getQuerySorterFields() 
    { 
        java.util.List sorterFieldList = new ArrayList(); 
        sorterFieldList.add("number"); 
        return sorterFieldList; 
    } 
    protected java.util.List getQueryPKFields() 
    { 
        java.util.List pkList = new ArrayList(); 
        pkList.add("id"); 
        pkList.add("entrys.id"); 
        return pkList;
    }
    	

    /**
     * output actionRemove_actionPerformed method
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemove_actionPerformed(e);
    }
    	

    /**
     * output actionTDPrint_actionPerformed method
     */
    public void actionTDPrint_actionPerformed(ActionEvent e) throws Exception
    {
        checkSelected();        
    	ArrayList idList =super.getSelectedIdValues();
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.reportone.r1.print.data.AbstractPrintDataProvider data = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.DefaultNoteDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionTDPrintPreview_actionPerformed method
     */
    public void actionTDPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        checkSelected();
    	ArrayList idList =super.getSelectedIdValues();
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.reportone.r1.print.data.AbstractPrintDataProvider data = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.DefaultNoteDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo editData = (com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.stocking.hatch.EggSettleBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo editData = (com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.stocking.hatch.EggSettleBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionShowPriceCol_actionPerformed method
     */
    public void actionShowPriceCol_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo editData = (com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.stocking.hatch.EggSettleBillFactory.getRemoteInstance().showPriceCol(editData);
    }
    	

    /**
     * output actionExeSettle_actionPerformed method
     */
    public void actionExeSettle_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo editData = (com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.stocking.hatch.EggSettleBillFactory.getRemoteInstance().exeSettle(editData);
    }
    	

    /**
     * output actionBatchSubmit_actionPerformed method
     */
    public void actionBatchSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        if (getSelectedKeyValue() == null) return;
com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo editData = (com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo)getBizInterface().getValue(new com.kingdee.bos.dao.ormapping.ObjectUuidPK(BOSUuid.read(getSelectedKeyValue())));
com.kingdee.eas.farm.stocking.hatch.EggSettleBillFactory.getRemoteInstance().batchSubmit(editData);
    }
	public RequestContext prepareActionRemove(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionRemove(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRemove() {
    	return false;
    }
	public RequestContext prepareActionTDPrint(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionTDPrint() {
    	return false;
    }
	public RequestContext prepareActionTDPrintPreview(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionTDPrintPreview() {
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
	public RequestContext prepareActionBatchSubmit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBatchSubmit() {
    	return false;
    }

    /**
     * output ActionTDPrint class
     */     
    protected class ActionTDPrint extends ItemAction {     
    
        public ActionTDPrint()
        {
            this(null);
        }

        public ActionTDPrint(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionTDPrint.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionTDPrint.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionTDPrint.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractEggSettleBillListUI.this, "ActionTDPrint", "actionTDPrint_actionPerformed", e);
        }
    }

    /**
     * output ActionTDPrintPreview class
     */     
    protected class ActionTDPrintPreview extends ItemAction {     
    
        public ActionTDPrintPreview()
        {
            this(null);
        }

        public ActionTDPrintPreview(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionTDPrintPreview.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionTDPrintPreview.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionTDPrintPreview.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractEggSettleBillListUI.this, "ActionTDPrintPreview", "actionTDPrintPreview_actionPerformed", e);
        }
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
            innerActionPerformed("eas", AbstractEggSettleBillListUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractEggSettleBillListUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractEggSettleBillListUI.this, "ActionShowPriceCol", "actionShowPriceCol_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractEggSettleBillListUI.this, "ActionExeSettle", "actionExeSettle_actionPerformed", e);
        }
    }

    /**
     * output ActionBatchSubmit class
     */     
    protected class ActionBatchSubmit extends ItemAction {     
    
        public ActionBatchSubmit()
        {
            this(null);
        }

        public ActionBatchSubmit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionBatchSubmit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBatchSubmit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBatchSubmit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractEggSettleBillListUI.this, "ActionBatchSubmit", "actionBatchSubmit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.hatch.client", "EggSettleBillListUI");
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
        return com.kingdee.eas.farm.stocking.hatch.client.EggSettleBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.hatch.EggSettleBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo objectValue = new com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo();		
        return objectValue;
    }

    /**
     * output getMergeColumnKeys method
     */
    public String[] getMergeColumnKeys()
    {
        return new String[] {"id","number","bizDate","company.name","storageOrgUnit.name","description","isInit","billStatus","creator.name","createTime","auditor.name","auditTime","farmer","qualityRate","badRate","settleAmout","entrys.settleItem","entrys.unit","entrys.wareHouse","entrys.costItem","srcRecBill"};
    }



	protected String getTDFileName() {
    	return "/bim/farm/stocking/hatch/EggSettleBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.stocking.hatch.app.EggSettleBillQuery");
	}        
				protected boolean isFootVisible() {
			return true;
		}


}