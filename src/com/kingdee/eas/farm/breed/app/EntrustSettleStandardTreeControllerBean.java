package com.kingdee.eas.farm.breed.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.farm.breed.EntrustSettleStandardTreeCollection;
import java.lang.String;
import com.kingdee.eas.framework.app.TreeBaseControllerBean;
import com.kingdee.eas.farm.breed.EntrustSettleStandardTreeInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.TreeBaseCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EntrustSettleStandardTreeControllerBean extends AbstractEntrustSettleStandardTreeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.app.EntrustSettleStandardTreeControllerBean");
}