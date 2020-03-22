package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRawmaterialinfoEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractRawmaterialinfoEntryInfo()
    {
        this("id");
    }
    protected AbstractRawmaterialinfoEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.custom.foodtrac.RawmaterialinfoInfo getParent()
    {
        return (com.kingdee.eas.custom.foodtrac.RawmaterialinfoInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.foodtrac.RawmaterialinfoInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FDC9203A");
    }
}