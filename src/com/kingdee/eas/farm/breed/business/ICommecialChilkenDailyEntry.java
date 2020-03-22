package com.kingdee.eas.farm.breed.business;

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

public interface ICommecialChilkenDailyEntry extends ICoreBillEntryBase
{
    public CommecialChilkenDailyEntryInfo getCommecialChilkenDailyEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CommecialChilkenDailyEntryInfo getCommecialChilkenDailyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CommecialChilkenDailyEntryInfo getCommecialChilkenDailyEntryInfo(String oql) throws BOSException, EASBizException;
    public CommecialChilkenDailyEntryCollection getCommecialChilkenDailyEntryCollection() throws BOSException;
    public CommecialChilkenDailyEntryCollection getCommecialChilkenDailyEntryCollection(EntityViewInfo view) throws BOSException;
    public CommecialChilkenDailyEntryCollection getCommecialChilkenDailyEntryCollection(String oql) throws BOSException;
}