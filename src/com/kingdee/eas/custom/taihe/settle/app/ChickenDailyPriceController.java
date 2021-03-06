package com.kingdee.eas.custom.taihe.settle.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlDataBaseController;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.taihe.settle.ChickenDailyPriceInfo;
import com.kingdee.eas.custom.taihe.settle.ChickenDailyPriceCollection;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ChickenDailyPriceController extends WlhlDataBaseController
{
    public ChickenDailyPriceInfo getChickenDailyPriceInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ChickenDailyPriceInfo getChickenDailyPriceInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ChickenDailyPriceInfo getChickenDailyPriceInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public ChickenDailyPriceCollection getChickenDailyPriceCollection(Context ctx) throws BOSException, RemoteException;
    public ChickenDailyPriceCollection getChickenDailyPriceCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ChickenDailyPriceCollection getChickenDailyPriceCollection(Context ctx, String oql) throws BOSException, RemoteException;
}