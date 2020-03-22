package com.kingdee.eas.custom.wlhllicensemanager.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface WlhlLicenseManagerController extends BizController
{
    public void checkLicense(Context ctx, BOSObjectType bosType) throws BOSException, EASBizException, RemoteException;
    public void releaseLicense(Context ctx, BOSObjectType bosType) throws BOSException, EASBizException, RemoteException;
}