package com.kingdee.eas.custom.taihe.weight;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarcassEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCarcassEntryInfo()
    {
        this("id");
    }
    protected AbstractCarcassEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 接收明细 's null property 
     */
    public com.kingdee.eas.custom.taihe.weight.CarcassInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.weight.CarcassInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.weight.CarcassInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:接收明细's 胴体类型property 
     */
    public com.kingdee.eas.custom.taihe.weight.CarcassType getCarcassType()
    {
        return com.kingdee.eas.custom.taihe.weight.CarcassType.getEnum(getString("carcassType"));
    }
    public void setCarcassType(com.kingdee.eas.custom.taihe.weight.CarcassType item)
    {
		if (item != null) {
        setString("carcassType", item.getValue());
		}
    }
    /**
     * Object:接收明细's 数量property 
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
     * Object:接收明细's 重量property 
     */
    public java.math.BigDecimal getWgt()
    {
        return getBigDecimal("wgt");
    }
    public void setWgt(java.math.BigDecimal item)
    {
        setBigDecimal("wgt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C3BBC7B6");
    }
}