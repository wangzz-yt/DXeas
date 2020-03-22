package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFoodDailyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFoodDailyEntryInfo()
    {
        this("id");
    }
    protected AbstractFoodDailyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��Ʒ��ϸ 's null property 
     */
    public com.kingdee.eas.custom.dx.baseset.FoodDailyInfo getParent()
    {
        return (com.kingdee.eas.custom.dx.baseset.FoodDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.dx.baseset.FoodDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��Ʒ��ϸ 's ���ϱ��� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterialNum()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("materialNum");
    }
    public void setMaterialNum(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("materialNum", item);
    }
    /**
     * Object:��Ʒ��ϸ's ��������property 
     */
    public String getMaterialName()
    {
        return getString("materialName");
    }
    public void setMaterialName(String item)
    {
        setString("materialName", item);
    }
    /**
     * Object:��Ʒ��ϸ's ���property 
     */
    public String getModel()
    {
        return getString("model");
    }
    public void setModel(String item)
    {
        setString("model", item);
    }
    /**
     * Object: ��Ʒ��ϸ 's ������� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialGroupInfo getMaterialGroup()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialGroupInfo)get("materialGroup");
    }
    public void setMaterialGroup(com.kingdee.eas.basedata.master.material.MaterialGroupInfo item)
    {
        put("materialGroup", item);
    }
    /**
     * Object:��Ʒ��ϸ's ����property 
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
     * Object:��Ʒ��ϸ's ����property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    /**
     * Object:��Ʒ��ϸ's ���property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:��Ʒ��ϸ's ��עproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:��Ʒ��ϸ's ������property 
     */
    public java.math.BigDecimal getCcRate()
    {
        return getBigDecimal("ccRate");
    }
    public void setCcRate(java.math.BigDecimal item)
    {
        setBigDecimal("ccRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("25BFCE23");
    }
}