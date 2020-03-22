package com.kingdee.eas.farm.breed.brood;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBroodDailyVaccineEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBroodDailyVaccineEntryInfo()
    {
        this("id");
    }
    protected AbstractBroodDailyVaccineEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 疫苗信息 's null property 
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
     * Object: 疫苗信息 's 疫苗 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getVaccineMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("vaccineMaterial");
    }
    public void setVaccineMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("vaccineMaterial", item);
    }
    /**
     * Object:疫苗信息's 领用量property 
     */
    public java.math.BigDecimal getQuantity()
    {
        return getBigDecimal("quantity");
    }
    public void setQuantity(java.math.BigDecimal item)
    {
        setBigDecimal("quantity", item);
    }
    /**
     * Object: 疫苗信息 's 鸡舍 property 
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
     * Object:疫苗信息's 鸡舍名称property 
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
     * Object:疫苗信息's 使用量property 
     */
    public java.math.BigDecimal getUsedQty()
    {
        return getBigDecimal("usedQty");
    }
    public void setUsedQty(java.math.BigDecimal item)
    {
        setBigDecimal("usedQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("48E13EB6");
    }
}