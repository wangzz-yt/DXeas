package com.kingdee.eas.custom.salepayment;

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

public interface ISalerStimulateSet extends IDataBase
{
    public SalerStimulateSetInfo getSalerStimulateSetInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SalerStimulateSetInfo getSalerStimulateSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SalerStimulateSetInfo getSalerStimulateSetInfo(String oql) throws BOSException, EASBizException;
    public SalerStimulateSetCollection getSalerStimulateSetCollection() throws BOSException;
    public SalerStimulateSetCollection getSalerStimulateSetCollection(EntityViewInfo view) throws BOSException;
    public SalerStimulateSetCollection getSalerStimulateSetCollection(String oql) throws BOSException;
    public void audit(SalerStimulateSetInfo model) throws BOSException;
    public void unAudit(SalerStimulateSetInfo model) throws BOSException;
}