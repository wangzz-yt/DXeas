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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IBreedStoorgSet extends ICoreBillBase
{
    public BreedStoorgSetCollection getBreedStoorgSetCollection() throws BOSException;
    public BreedStoorgSetCollection getBreedStoorgSetCollection(EntityViewInfo view) throws BOSException;
    public BreedStoorgSetCollection getBreedStoorgSetCollection(String oql) throws BOSException;
    public BreedStoorgSetInfo getBreedStoorgSetInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BreedStoorgSetInfo getBreedStoorgSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BreedStoorgSetInfo getBreedStoorgSetInfo(String oql) throws BOSException, EASBizException;
}