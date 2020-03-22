package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IDeliveryRecordBillEntry extends ICoreBillEntryBase
{
    public DeliveryRecordBillEntryInfo getDeliveryRecordBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DeliveryRecordBillEntryInfo getDeliveryRecordBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DeliveryRecordBillEntryInfo getDeliveryRecordBillEntryInfo(String oql) throws BOSException, EASBizException;
    public DeliveryRecordBillEntryCollection getDeliveryRecordBillEntryCollection() throws BOSException;
    public DeliveryRecordBillEntryCollection getDeliveryRecordBillEntryCollection(EntityViewInfo view) throws BOSException;
    public DeliveryRecordBillEntryCollection getDeliveryRecordBillEntryCollection(String oql) throws BOSException;
}