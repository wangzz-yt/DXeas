package com.kingdee.eas.farm.stocking.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.stocking.basedata.MarginTypeCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.eas.farm.stocking.basedata.MarginTypeInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface MarginTypeController extends DataBaseController
{
    public MarginTypeInfo getMarginTypeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public MarginTypeInfo getMarginTypeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public MarginTypeInfo getMarginTypeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public MarginTypeCollection getMarginTypeCollection(Context ctx) throws BOSException, RemoteException;
    public MarginTypeCollection getMarginTypeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public MarginTypeCollection getMarginTypeCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, MarginTypeInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, MarginTypeInfo model) throws BOSException, EASBizException, RemoteException;
}