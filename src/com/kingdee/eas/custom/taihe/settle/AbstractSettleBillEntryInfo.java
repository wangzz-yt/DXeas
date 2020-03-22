package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettleBillEntryInfo()
    {
        this("id");
    }
    protected AbstractSettleBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������ϸ 's ����ͷ property 
     */
    public com.kingdee.eas.custom.taihe.settle.SettleBillInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.settle.SettleBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.settle.SettleBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:������ϸ's ��������property 
     */
    public String getBillType()
    {
        return getString("billType");
    }
    public void setBillType(String item)
    {
        setString("billType", item);
    }
    /**
     * Object:������ϸ's ���ݺ�property 
     */
    public String getBillNum()
    {
        return getString("billNum");
    }
    public void setBillNum(String item)
    {
        setString("billNum", item);
    }
    /**
     * Object:������ϸ's ��������property 
     */
    public java.util.Date getBillDate()
    {
        return getDate("billDate");
    }
    public void setBillDate(java.util.Date item)
    {
        setDate("billDate", item);
    }
    /**
     * Object:������ϸ's ��������property 
     */
    public com.kingdee.eas.custom.taihe.weight.CarcassType getWgtType()
    {
        return com.kingdee.eas.custom.taihe.weight.CarcassType.getEnum(getString("wgtType"));
    }
    public void setWgtType(com.kingdee.eas.custom.taihe.weight.CarcassType item)
    {
		if (item != null) {
        setString("wgtType", item.getValue());
		}
    }
    /**
     * Object:������ϸ's ����property 
     */
    public java.math.BigDecimal getWgt()
    {
        return getBigDecimal("wgt");
    }
    public void setWgt(java.math.BigDecimal item)
    {
        setBigDecimal("wgt", item);
    }
    /**
     * Object:������ϸ's ֻ��property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:������ϸ's ����ʱ��property 
     */
    public java.util.Date getWghTime()
    {
        return getDate("wghTime");
    }
    public void setWghTime(java.util.Date item)
    {
        setDate("wghTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F6EE81FD");
    }
}