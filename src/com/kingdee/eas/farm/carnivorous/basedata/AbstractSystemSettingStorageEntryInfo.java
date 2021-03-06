package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSystemSettingStorageEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSystemSettingStorageEntryInfo()
    {
        this("id");
    }
    protected AbstractSystemSettingStorageEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 饲料厂分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 饲料厂分录 's 库存组织编码 property 
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
     * Object:饲料厂分录's 库存组织名称property 
     */
    public String getStorageOrgUnitName()
    {
        return getString("storageOrgUnitName");
    }
    public void setStorageOrgUnitName(String item)
    {
        setString("storageOrgUnitName", item);
    }
    /**
     * Object:饲料厂分录's 类型property 
     */
    public com.kingdee.eas.farm.stocking.basedata.OutOrgEnum getOutOrgType()
    {
        return com.kingdee.eas.farm.stocking.basedata.OutOrgEnum.getEnum(getInt("outOrgType"));
    }
    public void setOutOrgType(com.kingdee.eas.farm.stocking.basedata.OutOrgEnum item)
    {
		if (item != null) {
        setInt("outOrgType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AA25AF16");
    }
}