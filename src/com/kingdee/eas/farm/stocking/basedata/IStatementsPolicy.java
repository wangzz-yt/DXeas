package com.kingdee.eas.farm.stocking.basedata;

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

public interface IStatementsPolicy extends IDataBase
{
    public StatementsPolicyInfo getStatementsPolicyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StatementsPolicyInfo getStatementsPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StatementsPolicyInfo getStatementsPolicyInfo(String oql) throws BOSException, EASBizException;
    public StatementsPolicyCollection getStatementsPolicyCollection() throws BOSException;
    public StatementsPolicyCollection getStatementsPolicyCollection(EntityViewInfo view) throws BOSException;
    public StatementsPolicyCollection getStatementsPolicyCollection(String oql) throws BOSException;
    public void isTemplate(StatementsPolicyInfo model) throws BOSException;
    public void audit(StatementsPolicyInfo model) throws BOSException, EASBizException;
    public void unAudit(StatementsPolicyInfo model) throws BOSException, EASBizException;
}