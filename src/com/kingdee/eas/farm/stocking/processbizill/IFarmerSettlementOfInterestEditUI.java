package com.kingdee.eas.farm.stocking.processbizill;

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
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IFarmerSettlementOfInterestEditUI extends ICoreBillBase
{
    public FarmerSettlementOfInterestEditUICollection getFarmerSettlementOfInterestEditUICollection() throws BOSException;
    public FarmerSettlementOfInterestEditUICollection getFarmerSettlementOfInterestEditUICollection(EntityViewInfo view) throws BOSException;
    public FarmerSettlementOfInterestEditUICollection getFarmerSettlementOfInterestEditUICollection(String oql) throws BOSException;
    public FarmerSettlementOfInterestEditUIInfo getFarmerSettlementOfInterestEditUIInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmerSettlementOfInterestEditUIInfo getFarmerSettlementOfInterestEditUIInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmerSettlementOfInterestEditUIInfo getFarmerSettlementOfInterestEditUIInfo(String oql) throws BOSException, EASBizException;
}