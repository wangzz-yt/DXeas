package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRandPPolicyTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractRandPPolicyTreeInfo()
    {
        this("id");
    }
    protected AbstractRandPPolicyTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 奖惩政策组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.RandPPolicyTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.RandPPolicyTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.RandPPolicyTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("17D0AD39");
    }
}