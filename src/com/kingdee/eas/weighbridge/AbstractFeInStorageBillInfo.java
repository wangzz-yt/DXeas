package com.kingdee.eas.weighbridge;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeInStorageBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFeInStorageBillInfo()
    {
        this("id");
    }
    protected AbstractFeInStorageBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.weighbridge.FeInStorageBillEntryCollection());
    }
    /**
     * Object: 入库过磅单 's 过磅记录 property 
     */
    public com.kingdee.eas.weighbridge.FeInStorageBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.weighbridge.FeInStorageBillEntryCollection)get("entrys");
    }
    /**
     * Object:入库过磅单's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 入库过磅单 's 车辆 property 
     */
    public com.kingdee.eas.publicdata.CarInfo getCar()
    {
        return (com.kingdee.eas.publicdata.CarInfo)get("car");
    }
    public void setCar(com.kingdee.eas.publicdata.CarInfo item)
    {
        put("car", item);
    }
    /**
     * Object:入库过磅单's 入厂时间property 
     */
    public java.util.Date getInTime()
    {
        return getDate("inTime");
    }
    public void setInTime(java.util.Date item)
    {
        setDate("inTime", item);
    }
    /**
     * Object:入库过磅单's 出厂时间property 
     */
    public java.util.Date getOutTime()
    {
        return getDate("outTime");
    }
    public void setOutTime(java.util.Date item)
    {
        setDate("outTime", item);
    }
    /**
     * Object:入库过磅单's 车辆皮重property 
     */
    public java.math.BigDecimal getTareWeight()
    {
        return getBigDecimal("tareWeight");
    }
    public void setTareWeight(java.math.BigDecimal item)
    {
        setBigDecimal("tareWeight", item);
    }
    /**
     * Object: 入库过磅单 's 当前库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrgUnit", item);
    }
    /**
     * Object: 入库过磅单 's 目标库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getOrderStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("orderStorageOrgUnit");
    }
    public void setOrderStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("orderStorageOrgUnit", item);
    }
    /**
     * Object: 入库过磅单 's 客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object: 入库过磅单 's 司磅员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getWeighman()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("weighman");
    }
    public void setWeighman(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("weighman", item);
    }
    /**
     * Object:入库过磅单's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object:入库过磅单's 业务类型property 
     */
    public com.kingdee.eas.weighbridge.WeighBizType getBizType()
    {
        return com.kingdee.eas.weighbridge.WeighBizType.getEnum(getString("bizType"));
    }
    public void setBizType(com.kingdee.eas.weighbridge.WeighBizType item)
    {
		if (item != null) {
        setString("bizType", item.getValue());
		}
    }
    /**
     * Object:入库过磅单's 单据状态property 
     */
    public com.kingdee.eas.weighbridge.WeighBaseStatus getBillStatus()
    {
        return com.kingdee.eas.weighbridge.WeighBaseStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.weighbridge.WeighBaseStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object:入库过磅单's 过磅方式property 
     */
    public com.kingdee.eas.weighbridge.WeighBaseType getWeighType()
    {
        return com.kingdee.eas.weighbridge.WeighBaseType.getEnum(getString("weighType"));
    }
    public void setWeighType(com.kingdee.eas.weighbridge.WeighBaseType item)
    {
		if (item != null) {
        setString("weighType", item.getValue());
		}
    }
    /**
     * Object:入库过磅单's 是否自动生成库存单据property 
     */
    public boolean isIsAutoCreateToInvBill()
    {
        return getBoolean("isAutoCreateToInvBill");
    }
    public void setIsAutoCreateToInvBill(boolean item)
    {
        setBoolean("isAutoCreateToInvBill", item);
    }
    /**
     * Object: 入库过磅单 's 当前财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object: 入库过磅单 's 目标财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getOrderComopany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("orderComopany");
    }
    public void setOrderComopany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("orderComopany", item);
    }
    /**
     * Object:入库过磅单's 车牌号property 
     */
    public String getCarNum()
    {
        return getString("carNum");
    }
    public void setCarNum(String item)
    {
        setString("carNum", item);
    }
    /**
     * Object:入库过磅单's 采购订单编码property 
     */
    public String getPurnumber()
    {
        return getString("purnumber");
    }
    public void setPurnumber(String item)
    {
        setString("purnumber", item);
    }
    /**
     * Object:入库过磅单's 采购订单idproperty 
     */
    public String getPurid()
    {
        return getString("purid");
    }
    public void setPurid(String item)
    {
        setString("purid", item);
    }
    /**
     * Object: 入库过磅单 's 供应商 property 
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
     * Object:入库过磅单's 质检单编码property 
     */
    public String getQCNumber()
    {
        return getString("QCNumber");
    }
    public void setQCNumber(String item)
    {
        setString("QCNumber", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("17A5DF03");
    }
}