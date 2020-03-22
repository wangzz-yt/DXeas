package com.kingdee.eas.custom.szcount;

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

public interface ISzCountPositionSet extends IDataBase
{
    public SzCountPositionSetInfo getSzCountPositionSetInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SzCountPositionSetInfo getSzCountPositionSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SzCountPositionSetInfo getSzCountPositionSetInfo(String oql) throws BOSException, EASBizException;
    public SzCountPositionSetCollection getSzCountPositionSetCollection() throws BOSException;
    public SzCountPositionSetCollection getSzCountPositionSetCollection(EntityViewInfo view) throws BOSException;
    public SzCountPositionSetCollection getSzCountPositionSetCollection(String oql) throws BOSException;
    public void importforEx(SzCountPositionSetInfo model) throws BOSException;
}