package com.kingdee.eas.farm.breed.brood;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBroodDailyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBroodDailyEntryInfo()
    {
        this("id");
    }
    protected AbstractBroodDailyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 饲喂信息分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.breed.brood.BroodDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.brood.BroodDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.brood.BroodDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 饲喂信息分录 's 饲料 property 
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
     * Object:饲喂信息分录's 饲料名称property 
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
     * Object:饲喂信息分录's 日喂料量（kg）property 
     */
    public java.math.BigDecimal getDailyQtyAll()
    {
        return getBigDecimal("dailyQtyAll");
    }
    public void setDailyQtyAll(java.math.BigDecimal item)
    {
        setBigDecimal("dailyQtyAll", item);
    }
    /**
     * Object: 饲喂信息分录 's 鸡舍 property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getHenhouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("henhouse");
    }
    public void setHenhouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("henhouse", item);
    }
    /**
     * Object:饲喂信息分录's 饮水量property 
     */
    public java.math.BigDecimal getWaterQty()
    {
        return getBigDecimal("waterQty");
    }
    public void setWaterQty(java.math.BigDecimal item)
    {
        setBigDecimal("waterQty", item);
    }
    /**
     * Object:饲喂信息分录's 鸡舍名称property 
     */
    public String getHenhouseName()
    {
        return getString("henhouseName");
    }
    public void setHenhouseName(String item)
    {
        setString("henhouseName", item);
    }
    /**
     * Object:饲喂信息分录's 平均只重（g）property 
     */
    public java.math.BigDecimal getAverageWeight()
    {
        return getBigDecimal("averageWeight");
    }
    public void setAverageWeight(java.math.BigDecimal item)
    {
        setBigDecimal("averageWeight", item);
    }
    /**
     * Object:饲喂信息分录's 限饲方式property 
     */
    public String getLimitFeedType()
    {
        return getString("limitFeedType");
    }
    public void setLimitFeedType(String item)
    {
        setString("limitFeedType", item);
    }
    /**
     * Object:饲喂信息分录's 燃煤分摊property 
     */
    public java.math.BigDecimal getCoalShare()
    {
        return getBigDecimal("coalShare");
    }
    public void setCoalShare(java.math.BigDecimal item)
    {
        setBigDecimal("coalShare", item);
    }
    /**
     * Object:饲喂信息分录's 柴油分摊property 
     */
    public java.math.BigDecimal getDieselShare()
    {
        return getBigDecimal("dieselShare");
    }
    public void setDieselShare(java.math.BigDecimal item)
    {
        setBigDecimal("dieselShare", item);
    }
    /**
     * Object:饲喂信息分录's 规格property 
     */
    public String getMaterialModel()
    {
        return getString("materialModel");
    }
    public void setMaterialModel(String item)
    {
        setString("materialModel", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9E3A0D99");
    }
}