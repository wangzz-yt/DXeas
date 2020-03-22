package com.kingdee.eas.farm.feemanager.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.feemanager.basedata.OilStandPriceCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.feemanager.basedata.OilStandPriceInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface OilStandPriceController extends DataBaseController
{
    public OilStandPriceInfo getOilStandPriceInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public OilStandPriceInfo getOilStandPriceInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public OilStandPriceInfo getOilStandPriceInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public OilStandPriceCollection getOilStandPriceCollection(Context ctx) throws BOSException, RemoteException;
    public OilStandPriceCollection getOilStandPriceCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public OilStandPriceCollection getOilStandPriceCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void review(Context ctx, OilStandPriceInfo model) throws BOSException, RemoteException;
    public void unreview(Context ctx, OilStandPriceInfo model) throws BOSException, RemoteException;
}