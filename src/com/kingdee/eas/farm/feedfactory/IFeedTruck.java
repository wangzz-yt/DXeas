package com.kingdee.eas.farm.feedfactory;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IFeedTruck extends IDataBase
{
    public FeedTruckInfo getFeedTruckInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FeedTruckInfo getFeedTruckInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FeedTruckInfo getFeedTruckInfo(String oql) throws BOSException, EASBizException;
    public FeedTruckCollection getFeedTruckCollection() throws BOSException;
    public FeedTruckCollection getFeedTruckCollection(EntityViewInfo view) throws BOSException;
    public FeedTruckCollection getFeedTruckCollection(String oql) throws BOSException;
}