package com.kingdee.eas.farm.carnivorous.basedata;

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

public interface ISettleDataBase extends IDataBase
{
    public SettleDataBaseInfo getSettleDataBaseInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SettleDataBaseInfo getSettleDataBaseInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SettleDataBaseInfo getSettleDataBaseInfo(String oql) throws BOSException, EASBizException;
    public SettleDataBaseCollection getSettleDataBaseCollection() throws BOSException;
    public SettleDataBaseCollection getSettleDataBaseCollection(EntityViewInfo view) throws BOSException;
    public SettleDataBaseCollection getSettleDataBaseCollection(String oql) throws BOSException;
    public void audit(SettleDataBaseInfo model) throws BOSException, EASBizException;
    public void unAudit(SettleDataBaseInfo model) throws BOSException, EASBizException;
}