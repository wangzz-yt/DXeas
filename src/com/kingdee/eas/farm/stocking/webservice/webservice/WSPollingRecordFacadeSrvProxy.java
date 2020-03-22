package com.kingdee.eas.farm.stocking.webservice.webservice;

import org.apache.axis.Message;

import org.apache.axis.MessageContext;

import org.apache.axis.message.SOAPEnvelope;

import org.apache.axis.message.SOAPHeaderElement;

import com.kingdee.bos.webservice.WSConfig;

import com.kingdee.bos.webservice.WSInvokeException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ObjectMultiPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.orm.core.ORMEngine;
import com.kingdee.bos.webservice.BeanConvertHelper;
import com.kingdee.bos.webservice.BOSTypeConvertor;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.webservice.WSConfig;
import com.kingdee.bos.webservice.MetaDataHelper;
import com.kingdee.bos.BOSObjectFactory;

public class WSPollingRecordFacadeSrvProxy { 

    public String getBatchInfoByTechMan( String param ) throws WSInvokeException {
        try {
            return getController().getBatchInfoByTechMan(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getMaterial( String param ) throws WSInvokeException {
        try {
            return getController().getMaterial(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getBillDetailInfo( String param ) throws WSInvokeException {
        try {
            return getController().getBillDetailInfo(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String createNewBill( String param ) throws WSInvokeException {
        try {
            return getController().createNewBill(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getBillList( String param ) throws WSInvokeException {
        try {
            return getController().getBillList(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String deleteBill( String param ) throws WSInvokeException {
        try {
            return getController().deleteBill(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    private com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade getController() {
        try {
        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
            Message message =MessageContext.getCurrentContext().getRequestMessage();
            SOAPEnvelope soap =message.getSOAPEnvelope();
            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
            String SessionId=headerElement.getValue();
            return ( com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.farm.stocking.webservice.PollingRecordFacade") ; 
        } else {
            return ( com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.farm.stocking.webservice.PollingRecordFacade" , com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade.class ) ; 
        }
        }
        catch( Throwable e ) {
            return ( com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.farm.stocking.webservice.PollingRecordFacade" , com.kingdee.eas.farm.stocking.webservice.IPollingRecordFacade.class ) ; 
        }
    }

    private BeanConvertHelper getBeanConvertor() {
        return new BeanConvertHelper(); 
    }

}