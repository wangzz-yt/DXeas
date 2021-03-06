package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCPigDailyDCEntryDeathEarNumberEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCCPigDailyDCEntryDeathEarNumberEntryInfo()
    {
        this("id");
    }
    protected AbstractCCPigDailyDCEntryDeathEarNumberEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ����������ϸ 's null property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigDailyDCEntryInfo getParent1()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigDailyDCEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.farm.pig.ccpig.CCPigDailyDCEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object:����������ϸ's ����property 
     */
    public String getPigNumber()
    {
        return getString("pigNumber");
    }
    public void setPigNumber(String item)
    {
        setString("pigNumber", item);
    }
    /**
     * Object:����������ϸ's ��עproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4187AD5F");
    }
}