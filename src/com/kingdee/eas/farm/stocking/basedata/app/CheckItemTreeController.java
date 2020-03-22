package com.kingdee.eas.farm.stocking.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.stocking.basedata.CheckItemTreeInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.stocking.basedata.CheckItemTreeCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CheckItemTreeController extends TreeBaseController
{
    public CheckItemTreeInfo getCheckItemTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CheckItemTreeInfo getCheckItemTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CheckItemTreeInfo getCheckItemTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CheckItemTreeCollection getCheckItemTreeCollection(Context ctx) throws BOSException, RemoteException;
    public CheckItemTreeCollection getCheckItemTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CheckItemTreeCollection getCheckItemTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}