package com.kingdee.eas.custom.emt.app.webservice;

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

public class WSWSEmtDataFacadeSrvProxy { 

    public String getUserInComeInfo( String lastUpdateTime ) throws WSInvokeException {
        try {
            return getController().getUserInComeInfo(
            lastUpdateTime);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getUserPayInfo( String lastUpdateTime ) throws WSInvokeException {
        try {
            return getController().getUserPayInfo(
            lastUpdateTime);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getUserFeedInfo( String lastUpdateDate ) throws WSInvokeException {
        try {
            return getController().getUserFeedInfo(
            lastUpdateDate);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getUserFeedBatchInfo( String lastUpdateTime ) throws WSInvokeException {
        try {
            return getController().getUserFeedBatchInfo(
            lastUpdateTime);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    private com.kingdee.eas.custom.emt.IWSEmtDataFacade getController() {
        try {
        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
            Message message =MessageContext.getCurrentContext().getRequestMessage();
            SOAPEnvelope soap =message.getSOAPEnvelope();
            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
            String SessionId=headerElement.getValue();
            return ( com.kingdee.eas.custom.emt.IWSEmtDataFacade )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.custom.emt.WSEmtDataFacade") ; 
        } else {
            return ( com.kingdee.eas.custom.emt.IWSEmtDataFacade )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.emt.WSEmtDataFacade" , com.kingdee.eas.custom.emt.IWSEmtDataFacade.class ) ; 
        }
        }
        catch( Throwable e ) {
            return ( com.kingdee.eas.custom.emt.IWSEmtDataFacade )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.emt.WSEmtDataFacade" , com.kingdee.eas.custom.emt.IWSEmtDataFacade.class ) ; 
        }
    }

    private BeanConvertHelper getBeanConvertor() {
        return new BeanConvertHelper(); 
    }

}