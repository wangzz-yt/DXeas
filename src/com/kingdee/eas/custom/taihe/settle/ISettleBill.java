package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ISettleBill extends IWlhlBillBase
{
    public SettleBillCollection getSettleBillCollection() throws BOSException;
    public SettleBillCollection getSettleBillCollection(EntityViewInfo view) throws BOSException;
    public SettleBillCollection getSettleBillCollection(String oql) throws BOSException;
    public SettleBillInfo getSettleBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SettleBillInfo getSettleBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SettleBillInfo getSettleBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(SettleBillInfo model) throws BOSException, EASBizException;
    public void unAudit(SettleBillInfo model) throws BOSException, EASBizException;
    public void execute(SettleBillInfo model) throws BOSException;
}