package com.kingdee.eas.weighbridge;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOutStorageBillEntryDetailInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractOutStorageBillEntryDetailInfo()
    {
        this("id");
    }
    protected AbstractOutStorageBillEntryDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 过磅分配明细 's null property 
     */
    public com.kingdee.eas.weighbridge.OutStorageBillEntryInfo getParent1()
    {
        return (com.kingdee.eas.weighbridge.OutStorageBillEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.weighbridge.OutStorageBillEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object: 过磅分配明细 's 来源单据类型 property 
     */
    public com.kingdee.eas.basedata.scm.common.BillTypeInfo getBillType()
    {
        return (com.kingdee.eas.basedata.scm.common.BillTypeInfo)get("billType");
    }
    public void setBillType(com.kingdee.eas.basedata.scm.common.BillTypeInfo item)
    {
        put("billType", item);
    }
    /**
     * Object:过磅分配明细's 来源单据IDproperty 
     */
    public String getSourceBillID()
    {
        return getString("sourceBillID");
    }
    public void setSourceBillID(String item)
    {
        setString("sourceBillID", item);
    }
    /**
     * Object:过磅分配明细's 来源单据分录IDproperty 
     */
    public String getSourceEntryID()
    {
        return getString("sourceEntryID");
    }
    public void setSourceEntryID(String item)
    {
        setString("sourceEntryID", item);
    }
    /**
     * Object:过磅分配明细's 来源单据编码property 
     */
    public String getSourceBillNum()
    {
        return getString("sourceBillNum");
    }
    public void setSourceBillNum(String item)
    {
        setString("sourceBillNum", item);
    }
    /**
     * Object:过磅分配明细's 来源单据分录号property 
     */
    public String getSourceEntrySeq()
    {
        return getString("sourceEntrySeq");
    }
    public void setSourceEntrySeq(String item)
    {
        setString("sourceEntrySeq", item);
    }
    /**
     * Object:过磅分配明细's 来源单据数量property 
     */
    public java.math.BigDecimal getSourceEntryQty()
    {
        return getBigDecimal("sourceEntryQty");
    }
    public void setSourceEntryQty(java.math.BigDecimal item)
    {
        setBigDecimal("sourceEntryQty", item);
    }
    /**
     * Object:过磅分配明细's 来源单据BOSTYPEproperty 
     */
    public String getSourceBillBosType()
    {
        return getString("sourceBillBosType");
    }
    public void setSourceBillBosType(String item)
    {
        setString("sourceBillBosType", item);
    }
    /**
     * Object:过磅分配明细's 来源分录BOSTYPEproperty 
     */
    public String getSourceEntryBosType()
    {
        return getString("sourceEntryBosType");
    }
    public void setSourceEntryBosType(String item)
    {
        setString("sourceEntryBosType", item);
    }
    /**
     * Object:过磅分配明细's 不含税单价property 
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
     * Object:过磅分配明细's 税率property 
     */
    public java.math.BigDecimal getTaxRate()
    {
        return getBigDecimal("taxRate");
    }
    public void setTaxRate(java.math.BigDecimal item)
    {
        setBigDecimal("taxRate", item);
    }
    /**
     * Object:过磅分配明细's 含税单价property 
     */
    public java.math.BigDecimal getTaxPrice()
    {
        return getBigDecimal("taxPrice");
    }
    public void setTaxPrice(java.math.BigDecimal item)
    {
        setBigDecimal("taxPrice", item);
    }
    /**
     * Object:过磅分配明细's 不含税金额property 
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
     * Object:过磅分配明细's 税额property 
     */
    public java.math.BigDecimal getTaxAmount()
    {
        return getBigDecimal("taxAmount");
    }
    public void setTaxAmount(java.math.BigDecimal item)
    {
        setBigDecimal("taxAmount", item);
    }
    /**
     * Object:过磅分配明细's 含税金额property 
     */
    public java.math.BigDecimal getAllAmount()
    {
        return getBigDecimal("allAmount");
    }
    public void setAllAmount(java.math.BigDecimal item)
    {
        setBigDecimal("allAmount", item);
    }
    /**
     * Object:过磅分配明细's 过磅数量property 
     */
    public java.math.BigDecimal getWeighQty()
    {
        return getBigDecimal("weighQty");
    }
    public void setWeighQty(java.math.BigDecimal item)
    {
        setBigDecimal("weighQty", item);
    }
    /**
     * Object: 过磅分配明细 's 目标库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getOrderStorageOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("orderStorageOrg");
    }
    public void setOrderStorageOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("orderStorageOrg", item);
    }
    /**
     * Object:过磅分配明细's 包数property 
     */
    public java.math.BigDecimal getSourceEntryBag()
    {
        return getBigDecimal("sourceEntryBag");
    }
    public void setSourceEntryBag(java.math.BigDecimal item)
    {
        setBigDecimal("sourceEntryBag", item);
    }
    /**
     * Object:过磅分配明细's 物料名称property 
     */
    public String getMateiralName()
    {
        return getString("mateiralName");
    }
    public void setMateiralName(String item)
    {
        setString("mateiralName", item);
    }
    /**
     * Object:过磅分配明细's 规格型号property 
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
     * Object:过磅分配明细's 物料编码property 
     */
    public String getMaterialNum()
    {
        return getString("materialNum");
    }
    public void setMaterialNum(String item)
    {
        setString("materialNum", item);
    }
    /**
     * Object:过磅分配明细's 客户名称property 
     */
    public String getCustomerName()
    {
        return getString("customerName");
    }
    public void setCustomerName(String item)
    {
        setString("customerName", item);
    }
    /**
     * Object:过磅分配明细's 客户编码property 
     */
    public String getCustomerNum()
    {
        return getString("customerNum");
    }
    public void setCustomerNum(String item)
    {
        setString("customerNum", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E577EA54");
    }
}