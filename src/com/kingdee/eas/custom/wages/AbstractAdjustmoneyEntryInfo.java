package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAdjustmoneyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAdjustmoneyEntryInfo()
    {
        this("id");
    }
    protected AbstractAdjustmoneyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.wages.AdjustmoneyInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.AdjustmoneyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.AdjustmoneyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 备注property 
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
     * Object: 分录 's 员工编码 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object:分录's 员工姓名property 
     */
    public String getPersonName()
    {
        return getString("personName");
    }
    public void setPersonName(String item)
    {
        setString("personName", item);
    }
    /**
     * Object:分录's 调整工资property 
     */
    public java.math.BigDecimal getAdjustmentWages()
    {
        return getBigDecimal("adjustmentWages");
    }
    public void setAdjustmentWages(java.math.BigDecimal item)
    {
        setBigDecimal("adjustmentWages", item);
    }
    /**
     * Object: 分录 's 员工岗位 property 
     */
    public com.kingdee.eas.custom.wages.BasicPostInfo getPersonPost()
    {
        return (com.kingdee.eas.custom.wages.BasicPostInfo)get("personPost");
    }
    public void setPersonPost(com.kingdee.eas.custom.wages.BasicPostInfo item)
    {
        put("personPost", item);
    }
    /**
     * Object: 分录 's 调整事由 property 
     */
    public com.kingdee.eas.custom.wages.AdjustCauseMonthInfo getAdjust()
    {
        return (com.kingdee.eas.custom.wages.AdjustCauseMonthInfo)get("Adjust");
    }
    public void setAdjust(com.kingdee.eas.custom.wages.AdjustCauseMonthInfo item)
    {
        put("Adjust", item);
    }
    /**
     * Object:分录's 房补property 
     */
    public String getHouse()
    {
        return getString("house");
    }
    public void setHouse(String item)
    {
        setString("house", item);
    }
    /**
     * Object:分录's 交通补助property 
     */
    public String getTrai()
    {
        return getString("trai");
    }
    public void setTrai(String item)
    {
        setString("trai", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B8180C69");
    }
}