package com.kingdee.eas.farm.pig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPigBatchTypeTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractPigBatchTypeTreeInfo()
    {
        this("id");
    }
    protected AbstractPigBatchTypeTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 猪群分类组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.pig.PigBatchTypeTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.PigBatchTypeTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.PigBatchTypeTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E5765AA4");
    }
}