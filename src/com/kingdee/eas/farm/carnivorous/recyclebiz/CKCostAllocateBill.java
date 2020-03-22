package com.kingdee.eas.farm.carnivorous.recyclebiz;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CKCostAllocateBill extends CoreBillBase implements ICKCostAllocateBill
{
    public CKCostAllocateBill()
    {
        super();
        registerInterface(ICKCostAllocateBill.class, this);
    }
    public CKCostAllocateBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICKCostAllocateBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EDCBFD16");
    }
    private CKCostAllocateBillController getController() throws BOSException
    {
        return (CKCostAllocateBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CKCostAllocateBillCollection getCKCostAllocateBillCollection() throws BOSException
    {
        try {
            return getController().getCKCostAllocateBillCollection(getContext());
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
    public CKCostAllocateBillCollection getCKCostAllocateBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCKCostAllocateBillCollection(getContext(), view);
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
    public CKCostAllocateBillCollection getCKCostAllocateBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCKCostAllocateBillCollection(getContext(), oql);
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
    public CKCostAllocateBillInfo getCKCostAllocateBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCKCostAllocateBillInfo(getContext(), pk);
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
    public CKCostAllocateBillInfo getCKCostAllocateBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCKCostAllocateBillInfo(getContext(), pk, selector);
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
    public CKCostAllocateBillInfo getCKCostAllocateBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCKCostAllocateBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *执行分摊-User defined method
     *@param model model
     */
    public void execAllocate(CKCostAllocateBillInfo model) throws BOSException
    {
        try {
            getController().execAllocate(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CKCostAllocateBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(CKCostAllocateBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取费用金额-User defined method
     *@param model model
     */
    public void costAmt(CKCostAllocateBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().costAmt(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}