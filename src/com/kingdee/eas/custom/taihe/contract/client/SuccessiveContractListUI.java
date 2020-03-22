/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract.client;

import java.awt.Toolkit;
import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class SuccessiveContractListUI extends AbstractSuccessiveContractListUI
{
    private static final Logger logger = CoreUIObject.getLogger(SuccessiveContractListUI.class);
    
    /**
     * output class constructor
     */
    public SuccessiveContractListUI() throws Exception
    {
        super();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    

    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
//		btnAudit.setIcon(ClientUtils.AuditIcon);
//		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
	}

	/**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.contract.SuccessiveContractFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo objectValue = new com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo();
		
        return objectValue;
    }

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		refreshList();
		MsgBox.showInfo("������");
	}

	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		refreshList();
		MsgBox.showInfo("��������");
	}

}