package com.kingdee.eas.message.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.message.BaseSettingInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.message.BaseSettingCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BaseSettingController extends DataBaseController
{
    public BaseSettingInfo getBaseSettingInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BaseSettingInfo getBaseSettingInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BaseSettingInfo getBaseSettingInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public BaseSettingCollection getBaseSettingCollection(Context ctx) throws BOSException, RemoteException;
    public BaseSettingCollection getBaseSettingCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BaseSettingCollection getBaseSettingCollection(Context ctx, String oql) throws BOSException, RemoteException;
}