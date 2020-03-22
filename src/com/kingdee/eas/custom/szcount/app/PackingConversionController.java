package com.kingdee.eas.custom.szcount.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlDataBaseController;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.szcount.PackingConversionCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.szcount.PackingConversionInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface PackingConversionController extends WlhlDataBaseController
{
    public PackingConversionInfo getPackingConversionInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PackingConversionInfo getPackingConversionInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PackingConversionInfo getPackingConversionInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public PackingConversionCollection getPackingConversionCollection(Context ctx) throws BOSException, RemoteException;
    public PackingConversionCollection getPackingConversionCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PackingConversionCollection getPackingConversionCollection(Context ctx, String oql) throws BOSException, RemoteException;
}