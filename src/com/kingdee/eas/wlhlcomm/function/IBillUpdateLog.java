package com.kingdee.eas.wlhlcomm.function;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IBillUpdateLog extends ICoreBillBase
{
    public BillUpdateLogCollection getBillUpdateLogCollection() throws BOSException;
    public BillUpdateLogCollection getBillUpdateLogCollection(EntityViewInfo view) throws BOSException;
    public BillUpdateLogCollection getBillUpdateLogCollection(String oql) throws BOSException;
    public BillUpdateLogInfo getBillUpdateLogInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BillUpdateLogInfo getBillUpdateLogInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BillUpdateLogInfo getBillUpdateLogInfo(String oql) throws BOSException, EASBizException;
}