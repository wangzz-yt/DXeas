package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.dayratecost.app.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DayRateCostDetail extends CoreBillBase implements IDayRateCostDetail
{
    public DayRateCostDetail()
    {
        super();
        registerInterface(IDayRateCostDetail.class, this);
    }
    public DayRateCostDetail(Context ctx)
    {
        super(ctx);
        registerInterface(IDayRateCostDetail.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("18C12B75");
    }
    private DayRateCostDetailController getController() throws BOSException
    {
        return (DayRateCostDetailController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DayRateCostDetailCollection getDayRateCostDetailCollection() throws BOSException
    {
        try {
            return getController().getDayRateCostDetailCollection(getContext());
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
    public DayRateCostDetailCollection getDayRateCostDetailCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDayRateCostDetailCollection(getContext(), view);
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
    public DayRateCostDetailCollection getDayRateCostDetailCollection(String oql) throws BOSException
    {
        try {
            return getController().getDayRateCostDetailCollection(getContext(), oql);
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
    public DayRateCostDetailInfo getDayRateCostDetailInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDayRateCostDetailInfo(getContext(), pk);
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
    public DayRateCostDetailInfo getDayRateCostDetailInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDayRateCostDetailInfo(getContext(), pk, selector);
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
    public DayRateCostDetailInfo getDayRateCostDetailInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDayRateCostDetailInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(DayRateCostDetailInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(DayRateCostDetailInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}