/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

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
public abstract class AbstractMarginTypeEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractMarginTypeEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontext;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPanecontext;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtcontext;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.farm.stocking.basedata.MarginTypeInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractMarginTypeEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractMarginTypeEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
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
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontext = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.scrollPanecontext = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtcontext = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contcontext.setName("contcontext");
        this.contbaseStatus.setName("contbaseStatus");
        this.contcompany.setName("contcompany");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.scrollPanecontext.setName("scrollPanecontext");
        this.txtcontext.setName("txtcontext");
        this.baseStatus.setName("baseStatus");
        this.prmtcompany.setName("prmtcompany");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // contcontext		
        this.contcontext.setBoundLabelText(resHelper.getString("contcontext.boundLabelText"));		
        this.contcontext.setBoundLabelLength(100);		
        this.contcontext.setBoundLabelUnderline(true);		
        this.contcontext.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName		
        this.txtName.setRequired(true);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // scrollPanecontext
        // txtcontext		
        this.txtcontext.setVisible(true);		
        this.txtcontext.setRequired(false);		
        this.txtcontext.setMaxLength(200);
        // baseStatus		
        this.baseStatus.setVisible(true);		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtcontext,baseStatus,prmtcompany}));
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
        this.setBounds(new Rectangle(0, 0, 391, 285));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(66, 26, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(66, 57, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(629, 108, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(599, 148, 270, 19));
        this.add(kDLabelContainer4, null);
        contcontext.setBounds(new Rectangle(65, 150, 270, 96));
        this.add(contcontext, null);
        contbaseStatus.setBounds(new Rectangle(66, 88, 270, 19));
        this.add(contbaseStatus, null);
        contcompany.setBounds(new Rectangle(66, 119, 270, 19));
        this.add(contcompany, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contcontext
        contcontext.setBoundEditor(scrollPanecontext);
        //scrollPanecontext
        scrollPanecontext.getViewport().add(txtcontext, null);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);

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
        //menuBiz
        menuBiz.add(mBtnAudit);
        menuBiz.add(mBtnUnAudit);
        menuBiz.add(menuItemCancel);
        menuBiz.add(menuItemCancelCancel);
        //menuTool
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
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
        this.toolBar.add(btnReset);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnSave);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
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
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("context", String.class, this.txtcontext, "text");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtSimpleName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtSimpleName, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtDescription, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtSimpleName, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.basedata.app.MarginTypeEditUIHandler";
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
        this.txtcontext.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.stocking.basedata.MarginTypeInfo)ov;
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
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("context", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtDescription.setEnabled(false);
		            this.txtNumber.setEnabled(false);
		            this.txtSimpleName.setEnabled(false);
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
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("context"));
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.MarginTypeFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.MarginTypeFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractMarginTypeEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractMarginTypeEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.basedata.client", "MarginTypeEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.stocking.basedata.client.MarginTypeEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.MarginTypeFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.MarginTypeInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.MarginTypeInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtName.getItemDataByLang(new LanguageInfo(com.kingdee.eas.common.client.SysContext.getSysContext().getLocale())))) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
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
		vo.put("baseStatus",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}