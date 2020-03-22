package com.kingdee.eas.farm.stocking.processbizill.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.processbizill.DrugReceptionBillInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.stocking.processbizill.DrugReceptionBillCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DrugReceptionBillController extends CoreBillBaseController
{
    public DrugReceptionBillCollection getDrugReceptionBillCollection(Context ctx) throws BOSException, RemoteException;
    public DrugReceptionBillCollection getDrugReceptionBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DrugReceptionBillCollection getDrugReceptionBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public DrugReceptionBillInfo getDrugReceptionBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DrugReceptionBillInfo getDrugReceptionBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DrugReceptionBillInfo getDrugReceptionBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, DrugReceptionBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, DrugReceptionBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void chkVoucherFlag(Context ctx, DrugReceptionBillInfo model) throws BOSException, RemoteException;
    public void chkVoucherAll(Context ctx, DrugReceptionBillInfo model) throws BOSException, RemoteException;
}