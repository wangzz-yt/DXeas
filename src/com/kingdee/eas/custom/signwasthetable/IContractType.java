package com.kingdee.eas.custom.signwasthetable;

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

public interface IContractType extends IDataBase
{
    public ContractTypeInfo getContractTypeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ContractTypeInfo getContractTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ContractTypeInfo getContractTypeInfo(String oql) throws BOSException, EASBizException;
    public ContractTypeCollection getContractTypeCollection() throws BOSException;
    public ContractTypeCollection getContractTypeCollection(EntityViewInfo view) throws BOSException;
    public ContractTypeCollection getContractTypeCollection(String oql) throws BOSException;
    public void audit(ContractTypeInfo model) throws BOSException;
    public void unAudit(ContractTypeInfo model) throws BOSException;
}