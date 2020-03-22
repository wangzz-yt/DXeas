package com.kingdee.eas.custom.taihe.vehicledetection.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.taihe.vehicledetection.VcWhiteListCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.taihe.vehicledetection.VcWhiteListInfo;
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

public interface VcWhiteListController extends DataBaseController
{
    public VcWhiteListInfo getVcWhiteListInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public VcWhiteListInfo getVcWhiteListInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public VcWhiteListInfo getVcWhiteListInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public VcWhiteListCollection getVcWhiteListCollection(Context ctx) throws BOSException, RemoteException;
    public VcWhiteListCollection getVcWhiteListCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public VcWhiteListCollection getVcWhiteListCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, VcWhiteListInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, VcWhiteListInfo model) throws BOSException, RemoteException;
}