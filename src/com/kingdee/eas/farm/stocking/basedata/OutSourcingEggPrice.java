package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class OutSourcingEggPrice extends DataBase implements IOutSourcingEggPrice
{
    public OutSourcingEggPrice()
    {
        super();
        registerInterface(IOutSourcingEggPrice.class, this);
    }
    public OutSourcingEggPrice(Context ctx)
    {
        super(ctx);
        registerInterface(IOutSourcingEggPrice.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("578FBAF9");
    }
    private OutSourcingEggPriceController getController() throws BOSException
    {
        return (OutSourcingEggPriceController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public OutSourcingEggPriceInfo getOutSourcingEggPriceInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getOutSourcingEggPriceInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public OutSourcingEggPriceInfo getOutSourcingEggPriceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getOutSourcingEggPriceInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public OutSourcingEggPriceInfo getOutSourcingEggPriceInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getOutSourcingEggPriceInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public OutSourcingEggPriceCollection getOutSourcingEggPriceCollection() throws BOSException
    {
        try {
            return getController().getOutSourcingEggPriceCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public OutSourcingEggPriceCollection getOutSourcingEggPriceCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getOutSourcingEggPriceCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public OutSourcingEggPriceCollection getOutSourcingEggPriceCollection(String oql) throws BOSException
    {
        try {
            return getController().getOutSourcingEggPriceCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��׼-User defined method
     *@param model model
     */
    public void audit(OutSourcingEggPriceInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����׼-User defined method
     *@param model model
     */
    public void unAudit(OutSourcingEggPriceInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}