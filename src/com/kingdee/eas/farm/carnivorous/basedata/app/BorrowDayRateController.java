package com.kingdee.eas.farm.carnivorous.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.BorrowDayRateInfo;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.farm.carnivorous.basedata.BorrowDayRateCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BorrowDayRateController extends DataBaseController
{
    public BorrowDayRateInfo getBorrowDayRateInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BorrowDayRateInfo getBorrowDayRateInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BorrowDayRateInfo getBorrowDayRateInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public BorrowDayRateCollection getBorrowDayRateCollection(Context ctx) throws BOSException, RemoteException;
    public BorrowDayRateCollection getBorrowDayRateCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BorrowDayRateCollection getBorrowDayRateCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, BorrowDayRateInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, BorrowDayRateInfo model) throws BOSException, EASBizException, RemoteException;
}