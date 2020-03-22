package com.kingdee.eas.farm.carnivorous.basebiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FarmerGuaranteeBillController extends CoreBillBaseController
{
    public FarmerGuaranteeBillCollection getFarmerGuaranteeBillCollection(Context ctx) throws BOSException, RemoteException;
    public FarmerGuaranteeBillCollection getFarmerGuaranteeBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FarmerGuaranteeBillCollection getFarmerGuaranteeBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public FarmerGuaranteeBillInfo getFarmerGuaranteeBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FarmerGuaranteeBillInfo getFarmerGuaranteeBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FarmerGuaranteeBillInfo getFarmerGuaranteeBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, FarmerGuaranteeBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, FarmerGuaranteeBillInfo model) throws BOSException, EASBizException, RemoteException;
}