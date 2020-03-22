package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BreedStoorgSet extends CoreBillBase implements IBreedStoorgSet
{
    public BreedStoorgSet()
    {
        super();
        registerInterface(IBreedStoorgSet.class, this);
    }
    public BreedStoorgSet(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedStoorgSet.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("03931B52");
    }
    private BreedStoorgSetController getController() throws BOSException
    {
        return (BreedStoorgSetController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BreedStoorgSetCollection getBreedStoorgSetCollection() throws BOSException
    {
        try {
            return getController().getBreedStoorgSetCollection(getContext());
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
    public BreedStoorgSetCollection getBreedStoorgSetCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedStoorgSetCollection(getContext(), view);
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
    public BreedStoorgSetCollection getBreedStoorgSetCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedStoorgSetCollection(getContext(), oql);
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
    public BreedStoorgSetInfo getBreedStoorgSetInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedStoorgSetInfo(getContext(), pk);
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
    public BreedStoorgSetInfo getBreedStoorgSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedStoorgSetInfo(getContext(), pk, selector);
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
    public BreedStoorgSetInfo getBreedStoorgSetInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedStoorgSetInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}