package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.feedfactory.app.*;
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

public class QualityCheckBill extends CoreBillBase implements IQualityCheckBill
{
    public QualityCheckBill()
    {
        super();
        registerInterface(IQualityCheckBill.class, this);
    }
    public QualityCheckBill(Context ctx)
    {
        super(ctx);
        registerInterface(IQualityCheckBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D62CF0D2");
    }
    private QualityCheckBillController getController() throws BOSException
    {
        return (QualityCheckBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public QualityCheckBillCollection getQualityCheckBillCollection() throws BOSException
    {
        try {
            return getController().getQualityCheckBillCollection(getContext());
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
    public QualityCheckBillCollection getQualityCheckBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getQualityCheckBillCollection(getContext(), view);
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
    public QualityCheckBillCollection getQualityCheckBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getQualityCheckBillCollection(getContext(), oql);
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
    public QualityCheckBillInfo getQualityCheckBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getQualityCheckBillInfo(getContext(), pk);
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
    public QualityCheckBillInfo getQualityCheckBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getQualityCheckBillInfo(getContext(), pk, selector);
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
    public QualityCheckBillInfo getQualityCheckBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getQualityCheckBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(QualityCheckBillInfo model) throws BOSException
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
    public void unAudit(QualityCheckBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}