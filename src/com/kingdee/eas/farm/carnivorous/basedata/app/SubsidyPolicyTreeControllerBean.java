package com.kingdee.eas.farm.carnivorous.basedata.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

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
import java.lang.String;
import com.kingdee.eas.framework.app.TreeBaseControllerBean;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.TreeBaseCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyTreeInfo;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.farm.carnivorous.basedata.SubsidyPolicyTreeCollection;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SubsidyPolicyTreeControllerBean extends AbstractSubsidyPolicyTreeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.carnivorous.basedata.app.SubsidyPolicyTreeControllerBean");
    
    @Override
   	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
   		// TODO Auto-generated method stub
   		try {
   			StringBuffer sql=new StringBuffer();
   			sql.append(" select count(*) FCount from CT_FM_SubsidyPolicy where FTreeID='").append(pk.toString()).append("'");
   			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
   			if(rs.next()&&rs.getInt("Fcount")>0) {
   				throw new EASBizException(new NumericExceptionSubItem("001","该节点下面已有基础资料，禁止删除！"));
   			}
   		}catch(SQLException err) {
   			err.printStackTrace();
   		}
   		super._delete(ctx, pk);
   	}

}