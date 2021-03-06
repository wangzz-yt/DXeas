package com.kingdee.eas.custom.tocloud.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.tocloud.BizTypeCollection;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.tocloud.BizTypeInfo;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BizTypeController extends DataBaseController
{
    public BizTypeInfo getBizTypeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BizTypeInfo getBizTypeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BizTypeInfo getBizTypeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public BizTypeCollection getBizTypeCollection(Context ctx) throws BOSException, RemoteException;
    public BizTypeCollection getBizTypeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BizTypeCollection getBizTypeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}