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

public interface ICustomerViewType extends IDataBase
{
    public CustomerViewTypeInfo getCustomerViewTypeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CustomerViewTypeInfo getCustomerViewTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CustomerViewTypeInfo getCustomerViewTypeInfo(String oql) throws BOSException, EASBizException;
    public CustomerViewTypeCollection getCustomerViewTypeCollection() throws BOSException;
    public CustomerViewTypeCollection getCustomerViewTypeCollection(EntityViewInfo view) throws BOSException;
    public CustomerViewTypeCollection getCustomerViewTypeCollection(String oql) throws BOSException;
    public void audit(CustomerViewTypeInfo model) throws BOSException, EASBizException;
    public void unAudit(CustomerViewTypeInfo model) throws BOSException, EASBizException;
}