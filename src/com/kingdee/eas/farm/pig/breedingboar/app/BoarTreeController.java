package com.kingdee.eas.farm.pig.breedingboar.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.pig.breedingboar.BoarTreeInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.pig.breedingboar.BoarTreeCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BoarTreeController extends TreeBaseController
{
    public BoarTreeInfo getBoarTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BoarTreeInfo getBoarTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BoarTreeInfo getBoarTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public BoarTreeCollection getBoarTreeCollection(Context ctx) throws BOSException, RemoteException;
    public BoarTreeCollection getBoarTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BoarTreeCollection getBoarTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}