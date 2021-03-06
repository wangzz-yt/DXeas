package com.kingdee.eas.farm.food;

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

public interface IPersonDaily extends ICoreBillBase
{
    public PersonDailyCollection getPersonDailyCollection() throws BOSException;
    public PersonDailyCollection getPersonDailyCollection(EntityViewInfo view) throws BOSException;
    public PersonDailyCollection getPersonDailyCollection(String oql) throws BOSException;
    public PersonDailyInfo getPersonDailyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PersonDailyInfo getPersonDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PersonDailyInfo getPersonDailyInfo(String oql) throws BOSException, EASBizException;
    public void audit(PersonDailyInfo model) throws BOSException;
    public void unAudit(PersonDailyInfo model) throws BOSException;
}