package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.salediscount.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DiscountGridLog extends CoreBillBase implements IDiscountGridLog
{
    public DiscountGridLog()
    {
        super();
        registerInterface(IDiscountGridLog.class, this);
    }
    public DiscountGridLog(Context ctx)
    {
        super(ctx);
        registerInterface(IDiscountGridLog.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("886C3F42");
    }
    private DiscountGridLogController getController() throws BOSException
    {
        return (DiscountGridLogController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DiscountGridLogCollection getDiscountGridLogCollection() throws BOSException
    {
        try {
            return getController().getDiscountGridLogCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param view 取集合
     *@return
     */
    public DiscountGridLogCollection getDiscountGridLogCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDiscountGridLogCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param oql 取集合
     *@return
     */
    public DiscountGridLogCollection getDiscountGridLogCollection(String oql) throws BOSException
    {
        try {
            return getController().getDiscountGridLogCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DiscountGridLogInfo getDiscountGridLogInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountGridLogInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@param selector 取值
     *@return
     */
    public DiscountGridLogInfo getDiscountGridLogInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountGridLogInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param oql 取值
     *@return
     */
    public DiscountGridLogInfo getDiscountGridLogInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountGridLogInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}