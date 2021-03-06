/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

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
public abstract class AbstractWageOrganizationEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractWageOrganizationEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAttendanceDay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contTemAllowance;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNightAllowance;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contOverTimeH;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contOverTimeD;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contForemanname;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbasestatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlifeSubsidy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contattendance;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkoneDay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contEmployerInsur;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFiverisks;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtAttendanceDay;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtTemAllowance;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtNightAllowance;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtOverTimeH;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtOverTimeD;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtForemanname;
    protected com.kingdee.bos.ctrl.swing.KDComboBox basestatus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlifeSubsidy;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtattendance;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtEmployerInsur;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtFiverisks;
    protected com.kingdee.eas.custom.wages.WageOrganizationInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractWageOrganizationEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractWageOrganizationEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAttendanceDay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contTemAllowance = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNightAllowance = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contOverTimeH = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contOverTimeD = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contForemanname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbasestatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlifeSubsidy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contattendance = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkoneDay = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contEmployerInsur = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFiverisks = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtAttendanceDay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtTemAllowance = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtNightAllowance = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtOverTimeH = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtOverTimeD = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtForemanname = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.basestatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtlifeSubsidy = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtattendance = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtEmployerInsur = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtFiverisks = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contAttendanceDay.setName("contAttendanceDay");
        this.contTemAllowance.setName("contTemAllowance");
        this.contNightAllowance.setName("contNightAllowance");
        this.contOverTimeH.setName("contOverTimeH");
        this.contOverTimeD.setName("contOverTimeD");
        this.contForemanname.setName("contForemanname");
        this.contbasestatus.setName("contbasestatus");
        this.contlifeSubsidy.setName("contlifeSubsidy");
        this.contattendance.setName("contattendance");
        this.contcompany.setName("contcompany");
        this.chkoneDay.setName("chkoneDay");
        this.contEmployerInsur.setName("contEmployerInsur");
        this.contFiverisks.setName("contFiverisks");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtAttendanceDay.setName("txtAttendanceDay");
        this.txtTemAllowance.setName("txtTemAllowance");
        this.txtNightAllowance.setName("txtNightAllowance");
        this.txtOverTimeH.setName("txtOverTimeH");
        this.txtOverTimeD.setName("txtOverTimeD");
        this.prmtForemanname.setName("prmtForemanname");
        this.basestatus.setName("basestatus");
        this.txtlifeSubsidy.setName("txtlifeSubsidy");
        this.txtattendance.setName("txtattendance");
        this.prmtcompany.setName("prmtcompany");
        this.txtEmployerInsur.setName("txtEmployerInsur");
        this.txtFiverisks.setName("txtFiverisks");
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
        this.kDLabelContainer4.setVisible(false);
        // contAttendanceDay		
        this.contAttendanceDay.setBoundLabelText(resHelper.getString("contAttendanceDay.boundLabelText"));		
        this.contAttendanceDay.setBoundLabelLength(100);		
        this.contAttendanceDay.setBoundLabelUnderline(true);		
        this.contAttendanceDay.setVisible(true);
        // contTemAllowance		
        this.contTemAllowance.setBoundLabelText(resHelper.getString("contTemAllowance.boundLabelText"));		
        this.contTemAllowance.setBoundLabelLength(100);		
        this.contTemAllowance.setBoundLabelUnderline(true);		
        this.contTemAllowance.setVisible(true);
        // contNightAllowance		
        this.contNightAllowance.setBoundLabelText(resHelper.getString("contNightAllowance.boundLabelText"));		
        this.contNightAllowance.setBoundLabelLength(100);		
        this.contNightAllowance.setBoundLabelUnderline(true);		
        this.contNightAllowance.setVisible(true);
        // contOverTimeH		
        this.contOverTimeH.setBoundLabelText(resHelper.getString("contOverTimeH.boundLabelText"));		
        this.contOverTimeH.setBoundLabelLength(100);		
        this.contOverTimeH.setBoundLabelUnderline(true);		
        this.contOverTimeH.setVisible(true);
        // contOverTimeD		
        this.contOverTimeD.setBoundLabelText(resHelper.getString("contOverTimeD.boundLabelText"));		
        this.contOverTimeD.setBoundLabelLength(100);		
        this.contOverTimeD.setBoundLabelUnderline(true);		
        this.contOverTimeD.setVisible(true);
        // contForemanname		
        this.contForemanname.setBoundLabelText(resHelper.getString("contForemanname.boundLabelText"));		
        this.contForemanname.setBoundLabelLength(100);		
        this.contForemanname.setBoundLabelUnderline(true);		
        this.contForemanname.setVisible(true);
        // contbasestatus		
        this.contbasestatus.setBoundLabelText(resHelper.getString("contbasestatus.boundLabelText"));		
        this.contbasestatus.setBoundLabelLength(100);		
        this.contbasestatus.setBoundLabelUnderline(true);		
        this.contbasestatus.setVisible(true);
        // contlifeSubsidy		
        this.contlifeSubsidy.setBoundLabelText(resHelper.getString("contlifeSubsidy.boundLabelText"));		
        this.contlifeSubsidy.setBoundLabelLength(100);		
        this.contlifeSubsidy.setBoundLabelUnderline(true);		
        this.contlifeSubsidy.setVisible(true);
        // contattendance		
        this.contattendance.setBoundLabelText(resHelper.getString("contattendance.boundLabelText"));		
        this.contattendance.setBoundLabelLength(100);		
        this.contattendance.setBoundLabelUnderline(true);		
        this.contattendance.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // chkoneDay		
        this.chkoneDay.setText(resHelper.getString("chkoneDay.text"));		
        this.chkoneDay.setVisible(true);		
        this.chkoneDay.setHorizontalAlignment(2);
        // contEmployerInsur		
        this.contEmployerInsur.setBoundLabelText(resHelper.getString("contEmployerInsur.boundLabelText"));		
        this.contEmployerInsur.setBoundLabelLength(100);		
        this.contEmployerInsur.setBoundLabelUnderline(true);		
        this.contEmployerInsur.setVisible(true);
        // contFiverisks		
        this.contFiverisks.setBoundLabelText(resHelper.getString("contFiverisks.boundLabelText"));		
        this.contFiverisks.setBoundLabelLength(100);		
        this.contFiverisks.setBoundLabelUnderline(true);		
        this.contFiverisks.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription		
        this.txtDescription.setEnabled(false);		
        this.txtDescription.setVisible(false);
        // txtAttendanceDay		
        this.txtAttendanceDay.setVisible(true);		
        this.txtAttendanceDay.setHorizontalAlignment(2);		
        this.txtAttendanceDay.setDataType(0);		
        this.txtAttendanceDay.setSupportedEmpty(true);		
        this.txtAttendanceDay.setRequired(false);
        // txtTemAllowance		
        this.txtTemAllowance.setVisible(true);		
        this.txtTemAllowance.setHorizontalAlignment(2);		
        this.txtTemAllowance.setDataType(1);		
        this.txtTemAllowance.setSupportedEmpty(true);		
        this.txtTemAllowance.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtTemAllowance.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtTemAllowance.setPrecision(2);		
        this.txtTemAllowance.setRequired(false);
        // txtNightAllowance		
        this.txtNightAllowance.setVisible(true);		
        this.txtNightAllowance.setHorizontalAlignment(2);		
        this.txtNightAllowance.setDataType(1);		
        this.txtNightAllowance.setSupportedEmpty(true);		
        this.txtNightAllowance.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtNightAllowance.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtNightAllowance.setPrecision(2);		
        this.txtNightAllowance.setRequired(false);
        // txtOverTimeH		
        this.txtOverTimeH.setVisible(true);		
        this.txtOverTimeH.setHorizontalAlignment(2);		
        this.txtOverTimeH.setDataType(1);		
        this.txtOverTimeH.setSupportedEmpty(true);		
        this.txtOverTimeH.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtOverTimeH.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtOverTimeH.setPrecision(2);		
        this.txtOverTimeH.setRequired(false);
        // txtOverTimeD		
        this.txtOverTimeD.setVisible(true);		
        this.txtOverTimeD.setHorizontalAlignment(2);		
        this.txtOverTimeD.setDataType(1);		
        this.txtOverTimeD.setSupportedEmpty(true);		
        this.txtOverTimeD.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtOverTimeD.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtOverTimeD.setPrecision(2);		
        this.txtOverTimeD.setRequired(false);
        // prmtForemanname		
        this.prmtForemanname.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtForemanname.setVisible(true);		
        this.prmtForemanname.setEditable(true);		
        this.prmtForemanname.setDisplayFormat("$name$");		
        this.prmtForemanname.setEditFormat("$number$");		
        this.prmtForemanname.setCommitFormat("$number$");		
        this.prmtForemanname.setRequired(true);
        // basestatus		
        this.basestatus.setVisible(true);		
        this.basestatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wages.BasicStatus").toArray());		
        this.basestatus.setRequired(false);
        // txtlifeSubsidy		
        this.txtlifeSubsidy.setVisible(true);		
        this.txtlifeSubsidy.setHorizontalAlignment(2);		
        this.txtlifeSubsidy.setDataType(1);		
        this.txtlifeSubsidy.setSupportedEmpty(true);		
        this.txtlifeSubsidy.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtlifeSubsidy.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtlifeSubsidy.setPrecision(2);		
        this.txtlifeSubsidy.setRequired(false);
        // txtattendance		
        this.txtattendance.setVisible(true);		
        this.txtattendance.setHorizontalAlignment(2);		
        this.txtattendance.setDataType(1);		
        this.txtattendance.setSupportedEmpty(true);		
        this.txtattendance.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtattendance.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtattendance.setPrecision(2);		
        this.txtattendance.setRequired(true);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // txtEmployerInsur		
        this.txtEmployerInsur.setVisible(true);		
        this.txtEmployerInsur.setHorizontalAlignment(2);		
        this.txtEmployerInsur.setDataType(1);		
        this.txtEmployerInsur.setSupportedEmpty(true);		
        this.txtEmployerInsur.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtEmployerInsur.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtEmployerInsur.setPrecision(2);		
        this.txtEmployerInsur.setRequired(false);
        // txtFiverisks		
        this.txtFiverisks.setVisible(true);		
        this.txtFiverisks.setHorizontalAlignment(2);		
        this.txtFiverisks.setDataType(1);		
        this.txtFiverisks.setSupportedEmpty(true);		
        this.txtFiverisks.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtFiverisks.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtFiverisks.setPrecision(2);		
        this.txtFiverisks.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtAttendanceDay,txtTemAllowance,txtNightAllowance,txtOverTimeH,txtOverTimeD,prmtForemanname,basestatus,txtlifeSubsidy,txtattendance,prmtcompany,chkoneDay,txtEmployerInsur,txtFiverisks}));
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
        this.setBounds(new Rectangle(0, 0, 645, 433));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 645, 433));
        kDLabelContainer1.setBounds(new Rectangle(21, 39, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(21, 39, 270, 19, 0));
        kDLabelContainer2.setBounds(new Rectangle(341, 39, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(341, 39, 270, 19, 0));
        kDLabelContainer3.setBounds(new Rectangle(102, -118, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(102, -118, 270, 19, 0));
        kDLabelContainer4.setBounds(new Rectangle(-341, -391, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(-341, -391, 270, 19, 0));
        contAttendanceDay.setBounds(new Rectangle(341, 153, 270, 19));
        this.add(contAttendanceDay, new KDLayout.Constraints(341, 153, 270, 19, 0));
        contTemAllowance.setBounds(new Rectangle(21, 210, 270, 19));
        this.add(contTemAllowance, new KDLayout.Constraints(21, 210, 270, 19, 0));
        contNightAllowance.setBounds(new Rectangle(341, 210, 270, 19));
        this.add(contNightAllowance, new KDLayout.Constraints(341, 210, 270, 19, 0));
        contOverTimeH.setBounds(new Rectangle(21, 267, 270, 19));
        this.add(contOverTimeH, new KDLayout.Constraints(21, 267, 270, 19, 0));
        contOverTimeD.setBounds(new Rectangle(341, 267, 270, 19));
        this.add(contOverTimeD, new KDLayout.Constraints(341, 267, 270, 19, 0));
        contForemanname.setBounds(new Rectangle(21, 153, 270, 19));
        this.add(contForemanname, new KDLayout.Constraints(21, 153, 270, 19, 0));
        contbasestatus.setBounds(new Rectangle(341, 96, 270, 19));
        this.add(contbasestatus, new KDLayout.Constraints(341, 96, 270, 19, 0));
        contlifeSubsidy.setBounds(new Rectangle(21, 324, 270, 19));
        this.add(contlifeSubsidy, new KDLayout.Constraints(21, 324, 270, 19, 0));
        contattendance.setBounds(new Rectangle(341, 324, 270, 19));
        this.add(contattendance, new KDLayout.Constraints(341, 324, 270, 19, 0));
        contcompany.setBounds(new Rectangle(21, 96, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(21, 96, 270, 19, 0));
        chkoneDay.setBounds(new Rectangle(341, 359, 270, 19));
        this.add(chkoneDay, new KDLayout.Constraints(341, 359, 270, 19, 0));
        contEmployerInsur.setBounds(new Rectangle(22, 385, 270, 19));
        this.add(contEmployerInsur, new KDLayout.Constraints(22, 385, 270, 19, 0));
        contFiverisks.setBounds(new Rectangle(340, 386, 270, 19));
        this.add(contFiverisks, new KDLayout.Constraints(340, 386, 270, 19, 0));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contAttendanceDay
        contAttendanceDay.setBoundEditor(txtAttendanceDay);
        //contTemAllowance
        contTemAllowance.setBoundEditor(txtTemAllowance);
        //contNightAllowance
        contNightAllowance.setBoundEditor(txtNightAllowance);
        //contOverTimeH
        contOverTimeH.setBoundEditor(txtOverTimeH);
        //contOverTimeD
        contOverTimeD.setBoundEditor(txtOverTimeD);
        //contForemanname
        contForemanname.setBoundEditor(prmtForemanname);
        //contbasestatus
        contbasestatus.setBoundEditor(basestatus);
        //contlifeSubsidy
        contlifeSubsidy.setBoundEditor(txtlifeSubsidy);
        //contattendance
        contattendance.setBoundEditor(txtattendance);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contEmployerInsur
        contEmployerInsur.setBoundEditor(txtEmployerInsur);
        //contFiverisks
        contFiverisks.setBoundEditor(txtFiverisks);

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
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
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
		dataBinder.registerBinding("oneDay", boolean.class, this.chkoneDay, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("AttendanceDay", int.class, this.txtAttendanceDay, "value");
		dataBinder.registerBinding("TemAllowance", java.math.BigDecimal.class, this.txtTemAllowance, "value");
		dataBinder.registerBinding("NightAllowance", java.math.BigDecimal.class, this.txtNightAllowance, "value");
		dataBinder.registerBinding("OverTimeH", java.math.BigDecimal.class, this.txtOverTimeH, "value");
		dataBinder.registerBinding("OverTimeD", java.math.BigDecimal.class, this.txtOverTimeD, "value");
		dataBinder.registerBinding("Foremanname", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtForemanname, "data");
		dataBinder.registerBinding("basestatus", com.kingdee.eas.custom.wages.BasicStatus.class, this.basestatus, "selectedItem");
		dataBinder.registerBinding("lifeSubsidy", java.math.BigDecimal.class, this.txtlifeSubsidy, "value");
		dataBinder.registerBinding("attendance", java.math.BigDecimal.class, this.txtattendance, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("EmployerInsur", java.math.BigDecimal.class, this.txtEmployerInsur, "value");
		dataBinder.registerBinding("Fiverisks", java.math.BigDecimal.class, this.txtFiverisks, "value");		
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
	    return "com.kingdee.eas.custom.wages.app.WageOrganizationEditUIHandler";
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
        this.txtAttendanceDay.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.wages.WageOrganizationInfo)ov;
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
		getValidateHelper().registerBindProperty("oneDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AttendanceDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TemAllowance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("NightAllowance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OverTimeH", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OverTimeD", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Foremanname", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("basestatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lifeSubsidy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("attendance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EmployerInsur", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Fiverisks", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("oneDay"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("AttendanceDay"));
        sic.add(new SelectorItemInfo("TemAllowance"));
        sic.add(new SelectorItemInfo("NightAllowance"));
        sic.add(new SelectorItemInfo("OverTimeH"));
        sic.add(new SelectorItemInfo("OverTimeD"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Foremanname.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("Foremanname.id"));
        	sic.add(new SelectorItemInfo("Foremanname.number"));
        	sic.add(new SelectorItemInfo("Foremanname.name"));
		}
        sic.add(new SelectorItemInfo("basestatus"));
        sic.add(new SelectorItemInfo("lifeSubsidy"));
        sic.add(new SelectorItemInfo("attendance"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("EmployerInsur"));
        sic.add(new SelectorItemInfo("Fiverisks"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.wages.client", "WageOrganizationEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.wages.client.WageOrganizationEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.WageOrganizationFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.WageOrganizationInfo objectValue = new com.kingdee.eas.custom.wages.WageOrganizationInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtForemanname.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"班组长"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtattendance.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"全勤补助"});
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
		vo.put("basestatus","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}