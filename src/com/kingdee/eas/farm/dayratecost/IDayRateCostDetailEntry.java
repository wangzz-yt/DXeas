package com.kingdee.eas.farm.dayratecost;

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

public interface IDayRateCostDetailEntry extends ICoreBillEntryBase
{
    public DayRateCostDetailEntryInfo getDayRateCostDetailEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DayRateCostDetailEntryInfo getDayRateCostDetailEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DayRateCostDetailEntryInfo getDayRateCostDetailEntryInfo(String oql) throws BOSException, EASBizException;
    public DayRateCostDetailEntryCollection getDayRateCostDetailEntryCollection() throws BOSException;
    public DayRateCostDetailEntryCollection getDayRateCostDetailEntryCollection(EntityViewInfo view) throws BOSException;
    public DayRateCostDetailEntryCollection getDayRateCostDetailEntryCollection(String oql) throws BOSException;
}