package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
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

public interface IMarginPolicyTree extends ITreeBase
{
    public MarginPolicyTreeInfo getMarginPolicyTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MarginPolicyTreeInfo getMarginPolicyTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MarginPolicyTreeInfo getMarginPolicyTreeInfo(String oql) throws BOSException, EASBizException;
    public MarginPolicyTreeCollection getMarginPolicyTreeCollection() throws BOSException;
    public MarginPolicyTreeCollection getMarginPolicyTreeCollection(EntityViewInfo view) throws BOSException;
    public MarginPolicyTreeCollection getMarginPolicyTreeCollection(String oql) throws BOSException;
}