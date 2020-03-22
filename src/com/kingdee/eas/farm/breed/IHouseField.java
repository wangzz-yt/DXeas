package com.kingdee.eas.farm.breed;

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

public interface IHouseField extends IDataBase
{
    public HouseFieldInfo getHouseFieldInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HouseFieldInfo getHouseFieldInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HouseFieldInfo getHouseFieldInfo(String oql) throws BOSException, EASBizException;
    public HouseFieldCollection getHouseFieldCollection() throws BOSException;
    public HouseFieldCollection getHouseFieldCollection(EntityViewInfo view) throws BOSException;
    public HouseFieldCollection getHouseFieldCollection(String oql) throws BOSException;
}