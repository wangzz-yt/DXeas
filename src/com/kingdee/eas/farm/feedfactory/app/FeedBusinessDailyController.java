package com.kingdee.eas.farm.feedfactory.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.feedfactory.FeedBusinessDailyCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.farm.feedfactory.FeedBusinessDailyInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FeedBusinessDailyController extends CoreBillBaseController
{
    public FeedBusinessDailyCollection getFeedBusinessDailyCollection(Context ctx) throws BOSException, RemoteException;
    public FeedBusinessDailyCollection getFeedBusinessDailyCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FeedBusinessDailyCollection getFeedBusinessDailyCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public FeedBusinessDailyInfo getFeedBusinessDailyInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FeedBusinessDailyInfo getFeedBusinessDailyInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FeedBusinessDailyInfo getFeedBusinessDailyInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, FeedBusinessDailyInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, FeedBusinessDailyInfo model) throws BOSException, RemoteException;
}