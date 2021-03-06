package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmersTree extends TreeBase implements IFarmersTree
{
    public FarmersTree()
    {
        super();
        registerInterface(IFarmersTree.class, this);
    }
    public FarmersTree(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmersTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BFB8653D");
    }
    private FarmersTreeController getController() throws BOSException
    {
        return (FarmersTreeController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public FarmersTreeInfo getFarmersTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmersTreeInfo(getContext(), pk);
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
    public FarmersTreeInfo getFarmersTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmersTreeInfo(getContext(), pk, selector);
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
    public FarmersTreeInfo getFarmersTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmersTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public FarmersTreeCollection getFarmersTreeCollection() throws BOSException
    {
        try {
            return getController().getFarmersTreeCollection(getContext());
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
    public FarmersTreeCollection getFarmersTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmersTreeCollection(getContext(), view);
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
    public FarmersTreeCollection getFarmersTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmersTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}