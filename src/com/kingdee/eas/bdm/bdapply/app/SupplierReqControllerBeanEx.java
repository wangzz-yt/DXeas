package com.kingdee.eas.bdm.bdapply.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.bdm.bdapply.SupplierReqCollection;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.bdm.bdapply.SupplierReqInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SupplierReqControllerBeanEx extends com.kingdee.eas.bdm.bdapply.app.SupplierReqControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.bdm.bdapply.app.SupplierReqControllerBeanEx");
    protected void _supplierAudit(Context ctx, IObjectValue model)throws BOSException
    {
	     super._supplierAudit(ctx, model);
    }
    protected void _basenotby(Context ctx, IObjectValue model)throws BOSException
    {
	     super._basenotby(ctx, model);
    }
    protected void _allAudit(Context ctx, IObjectValue model)throws BOSException
    {
	     super._allAudit(ctx, model);
    }
}				
