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
import com.kingdee.eas.scm.im.inv.IInvBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICManufactureBill extends IInvBillBase
{
    public CManufactureBillInfo getCManufactureBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CManufactureBillInfo getCManufactureBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CManufactureBillInfo getCManufactureBillInfo(String oql) throws BOSException, EASBizException;
    public CManufactureBillCollection getCManufactureBillCollection() throws BOSException;
    public CManufactureBillCollection getCManufactureBillCollection(EntityViewInfo view) throws BOSException;
    public CManufactureBillCollection getCManufactureBillCollection(String oql) throws BOSException;
    public CManufactureBillInfo getDefaultCostObject(String materialId, String companyId, String lot) throws BOSException, EASBizException;
    public int associateManufactureRecBill(String fsourcebillid) throws BOSException, EASBizException;
}