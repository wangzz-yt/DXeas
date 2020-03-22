package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCTransFodderBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCTransFodderBillEntryInfo()
    {
        this("id");
    }
    protected AbstractCTransFodderBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.CTransFodderBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.CTransFodderBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.feedbiz.CTransFodderBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 饲料编码 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:分录's 饲料名称property 
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
     * Object:分录's 规格property 
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
     * Object: 分录 's 仓库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("warehouse");
    }
    public void setWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("warehouse", item);
    }
    /**
     * Object:分录's 转料数量property 
     */
    public java.math.BigDecimal getTransQty()
    {
        return getBigDecimal("transQty");
    }
    public void setTransQty(java.math.BigDecimal item)
    {
        setBigDecimal("transQty", item);
    }
    /**
     * Object: 分录 's 目标仓库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getOrderWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("orderWarehouse");
    }
    public void setOrderWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("orderWarehouse", item);
    }
    /**
     * Object:分录's 转出金额property 
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
     * Object:分录's 政策价格property 
     */
    public java.math.BigDecimal getBasePrice()
    {
        return getBigDecimal("basePrice");
    }
    public void setBasePrice(java.math.BigDecimal item)
    {
        setBigDecimal("basePrice", item);
    }
    /**
     * Object:分录's 目标领用金额property 
     */
    public java.math.BigDecimal getOrderAmount()
    {
        return getBigDecimal("orderAmount");
    }
    public void setOrderAmount(java.math.BigDecimal item)
    {
        setBigDecimal("orderAmount", item);
    }
    /**
     * Object:分录's 目标政策价格property 
     */
    public java.math.BigDecimal getOrderBasePrice()
    {
        return getBigDecimal("orderBasePrice");
    }
    public void setOrderBasePrice(java.math.BigDecimal item)
    {
        setBigDecimal("orderBasePrice", item);
    }
    /**
     * Object: 分录 's 计量单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("unit");
    }
    public void setUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("unit", item);
    }
    /**
     * Object:分录's 单包重property 
     */
    public java.math.BigDecimal getUnitQty()
    {
        return getBigDecimal("unitQty");
    }
    public void setUnitQty(java.math.BigDecimal item)
    {
        setBigDecimal("unitQty", item);
    }
    /**
     * Object:分录's 包数property 
     */
    public int getBagQty()
    {
        return getInt("bagQty");
    }
    public void setBagQty(int item)
    {
        setInt("bagQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BCC3AD2C");
    }
}