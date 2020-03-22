package com.kingdee.eas.custom.taihe.server;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IReturnBillEntry extends ICoreBillEntryBase
{
    public ReturnBillEntryInfo getReturnBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ReturnBillEntryInfo getReturnBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ReturnBillEntryInfo getReturnBillEntryInfo(String oql) throws BOSException, EASBizException;
    public ReturnBillEntryCollection getReturnBillEntryCollection() throws BOSException;
    public ReturnBillEntryCollection getReturnBillEntryCollection(EntityViewInfo view) throws BOSException;
    public ReturnBillEntryCollection getReturnBillEntryCollection(String oql) throws BOSException;
}