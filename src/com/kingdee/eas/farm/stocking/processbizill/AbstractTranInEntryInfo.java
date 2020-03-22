package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTranInEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTranInEntryInfo()
    {
        this("id");
    }
    protected AbstractTranInEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.TranInInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.TranInInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.TranInInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ת����ֳ�� property 
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
     * Object: ��¼ 's ת������ property 
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
     * Object:��¼'s ת������property 
     */
    public String getOutWeek()
    {
        return getString("outWeek");
    }
    public void setOutWeek(String item)
    {
        setString("outWeek", item);
    }
    /**
     * Object:��¼'s ת������property 
     */
    public String getOutDay()
    {
        return getString("outDay");
    }
    public void setOutDay(String item)
    {
        setString("outDay", item);
    }
    /**
     * Object:��¼'s ת��������property 
     */
    public java.math.BigDecimal getOutmaleQty()
    {
        return getBigDecimal("outmaleQty");
    }
    public void setOutmaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("outmaleQty", item);
    }
    /**
     * Object:��¼'s ת��ĸ����property 
     */
    public java.math.BigDecimal getOutFemaleQty()
    {
        return getBigDecimal("outFemaleQty");
    }
    public void setOutFemaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("outFemaleQty", item);
    }
    /**
     * Object: ��¼ 's ת����ֳ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getInFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("inFarm");
    }
    public void setInFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("inFarm", item);
    }
    /**
     * Object: ��¼ 's ת������ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getInBbatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("inBbatch");
    }
    public void setInBbatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("inBbatch", item);
    }
    /**
     * Object: ��¼ 's ת������ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getInHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("inHouse");
    }
    public void setInHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("inHouse", item);
    }
    /**
     * Object: ��¼ 's ת������ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getOutHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("outHouse");
    }
    public void setOutHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("outHouse", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4803EC1D");
    }
}