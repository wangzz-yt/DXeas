package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchAdjustBillEggEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractHatchAdjustBillEggEntryInfo()
    {
        this("id");
    }
    protected AbstractHatchAdjustBillEggEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 种蛋来源 's null property 
     */
    public com.kingdee.eas.farm.hatch.HatchAdjustBillInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.HatchAdjustBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.HatchAdjustBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:种蛋来源's 种蛋来源property 
     */
    public com.kingdee.eas.farm.hatch.EggSourceType getEggSourceType()
    {
        return com.kingdee.eas.farm.hatch.EggSourceType.getEnum(getInt("eggSourceType"));
    }
    public void setEggSourceType(com.kingdee.eas.farm.hatch.EggSourceType item)
    {
		if (item != null) {
        setInt("eggSourceType", item.getValue());
		}
    }
    /**
     * Object: 种蛋来源 's 内部养殖场 property 
     */
    public com.kingdee.eas.farm.breed.BreedStoorgSetInfo getFarm()
    {
        return (com.kingdee.eas.farm.breed.BreedStoorgSetInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.breed.BreedStoorgSetInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: 种蛋来源 's 蛋库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getEggHouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("eggHouse");
    }
    public void setEggHouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("eggHouse", item);
    }
    /**
     * Object:种蛋来源's 种蛋批次号property 
     */
    public String getEggLog()
    {
        return getString("eggLog");
    }
    public void setEggLog(String item)
    {
        setString("eggLog", item);
    }
    /**
     * Object:种蛋来源's 上孵数量property 
     */
    public int getEggQty()
    {
        return getInt("eggQty");
    }
    public void setEggQty(int item)
    {
        setInt("eggQty", item);
    }
    /**
     * Object: 种蛋来源 's 外部养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getOutFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("outFarm");
    }
    public void setOutFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("outFarm", item);
    }
    /**
     * Object: 种蛋来源 's 养殖户 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: 种蛋来源 's 供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object: 种蛋来源 's 种蛋 property 
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
     * Object: 种蛋来源 's 种禽批次 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getBreedBatch()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("breedBatch");
    }
    public void setBreedBatch(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("breedBatch", item);
    }
    /**
     * Object:种蛋来源's 苗批次property 
     */
    public String getBabyBatch()
    {
        return getString("babyBatch");
    }
    public void setBabyBatch(String item)
    {
        setString("babyBatch", item);
    }
    /**
     * Object: 种蛋来源 's 放养批次 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getOutBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("outBatch");
    }
    public void setOutBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("outBatch", item);
    }
    /**
     * Object: 种蛋来源 's 栋舍 property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getHouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("house", item);
    }
    /**
     * Object: 种蛋来源 's 上孵厅 property 
     */
    public com.kingdee.eas.farm.hatch.HatchHouseInfo getHatchHouse()
    {
        return (com.kingdee.eas.farm.hatch.HatchHouseInfo)get("hatchHouse");
    }
    public void setHatchHouse(com.kingdee.eas.farm.hatch.HatchHouseInfo item)
    {
        put("hatchHouse", item);
    }
    /**
     * Object: 种蛋来源 's 孵化箱 property 
     */
    public com.kingdee.eas.farm.hatch.IncubatorInfo getIncubator()
    {
        return (com.kingdee.eas.farm.hatch.IncubatorInfo)get("incubator");
    }
    public void setIncubator(com.kingdee.eas.farm.hatch.IncubatorInfo item)
    {
        put("incubator", item);
    }
    /**
     * Object: 种蛋来源 's 棚舍 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getOutHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("outHouse");
    }
    public void setOutHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("outHouse", item);
    }
    /**
     * Object:种蛋来源's 合格一1级property 
     */
    public int getQc1lv1Qty()
    {
        return getInt("qc1lv1Qty");
    }
    public void setQc1lv1Qty(int item)
    {
        setInt("qc1lv1Qty", item);
    }
    /**
     * Object:种蛋来源's 合格一2级property 
     */
    public int getQc1lv2Qty()
    {
        return getInt("qc1lv2Qty");
    }
    public void setQc1lv2Qty(int item)
    {
        setInt("qc1lv2Qty", item);
    }
    /**
     * Object:种蛋来源's 合格二1级property 
     */
    public int getQc2lv1Qty()
    {
        return getInt("qc2lv1Qty");
    }
    public void setQc2lv1Qty(int item)
    {
        setInt("qc2lv1Qty", item);
    }
    /**
     * Object:种蛋来源's 合格二2级property 
     */
    public int getQc2lv2Qty()
    {
        return getInt("qc2lv2Qty");
    }
    public void setQc2lv2Qty(int item)
    {
        setInt("qc2lv2Qty", item);
    }
    /**
     * Object:种蛋来源's 合格四property 
     */
    public int getQc4lv1Qty()
    {
        return getInt("qc4lv1Qty");
    }
    public void setQc4lv1Qty(int item)
    {
        setInt("qc4lv1Qty", item);
    }
    /**
     * Object:种蛋来源's 合格三property 
     */
    public int getQc3lv1Qty()
    {
        return getInt("qc3lv1Qty");
    }
    public void setQc3lv1Qty(int item)
    {
        setInt("qc3lv1Qty", item);
    }
    /**
     * Object:种蛋来源's 合格五property 
     */
    public int getQc5lv1Qty()
    {
        return getInt("qc5lv1Qty");
    }
    public void setQc5lv1Qty(int item)
    {
        setInt("qc5lv1Qty", item);
    }
    /**
     * Object:种蛋来源's 合格六property 
     */
    public int getQc6lv1Qty()
    {
        return getInt("qc6lv1Qty");
    }
    public void setQc6lv1Qty(int item)
    {
        setInt("qc6lv1Qty", item);
    }
    /**
     * Object:种蛋来源's 孵化车号property 
     */
    public String getHatchCarNum()
    {
        return getString("hatchCarNum");
    }
    public void setHatchCarNum(String item)
    {
        setString("hatchCarNum", item);
    }
    /**
     * Object: 种蛋来源 's 片区 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo getOutArea()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)get("outArea");
    }
    public void setOutArea(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo item)
    {
        put("outArea", item);
    }
    /**
     * Object:种蛋来源's 混合上孵property 
     */
    public boolean isIsMix()
    {
        return getBoolean("isMix");
    }
    public void setIsMix(boolean item)
    {
        setBoolean("isMix", item);
    }
    /**
     * Object:种蛋来源's 合格蛋类型property 
     */
    public com.kingdee.eas.farm.hatch.QcEggTypeEnum getQcEggType()
    {
        return com.kingdee.eas.farm.hatch.QcEggTypeEnum.getEnum(getInt("qcEggType"));
    }
    public void setQcEggType(com.kingdee.eas.farm.hatch.QcEggTypeEnum item)
    {
		if (item != null) {
        setInt("qcEggType", item.getValue());
		}
    }
    /**
     * Object:种蛋来源's 交蛋日期property 
     */
    public java.util.Date getSendDate()
    {
        return getDate("sendDate");
    }
    public void setSendDate(java.util.Date item)
    {
        setDate("sendDate", item);
    }
    /**
     * Object:种蛋来源's 日龄property 
     */
    public int getDayAge()
    {
        return getInt("dayAge");
    }
    public void setDayAge(int item)
    {
        setInt("dayAge", item);
    }
    /**
     * Object:种蛋来源's 是否转正property 
     */
    public boolean isIsFormal()
    {
        return getBoolean("isFormal");
    }
    public void setIsFormal(boolean item)
    {
        setBoolean("isFormal", item);
    }
    /**
     * Object:种蛋来源's 周龄property 
     */
    public String getWeeklyAge()
    {
        return getString("weeklyAge");
    }
    public void setWeeklyAge(String item)
    {
        setString("weeklyAge", item);
    }
    /**
     * Object:种蛋来源's 品系property 
     */
    public com.kingdee.eas.farm.stocking.hatch.GenderType getGenderType()
    {
        return com.kingdee.eas.farm.stocking.hatch.GenderType.getEnum(getString("genderType"));
    }
    public void setGenderType(com.kingdee.eas.farm.stocking.hatch.GenderType item)
    {
		if (item != null) {
        setString("genderType", item.getValue());
		}
    }
    /**
     * Object:种蛋来源's 顺序号property 
     */
    public int getSeqNum()
    {
        return getInt("seqNum");
    }
    public void setSeqNum(int item)
    {
        setInt("seqNum", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("94AADC55");
    }
}