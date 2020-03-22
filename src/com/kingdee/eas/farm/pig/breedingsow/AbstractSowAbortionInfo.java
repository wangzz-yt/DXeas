package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSowAbortionInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSowAbortionInfo()
    {
        this("id");
    }
    protected AbstractSowAbortionInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.pig.breedingsow.SowAbortionEntryCollection());
    }
    /**
     * Object: ĸ��������¼�� 's ��¼ property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.SowAbortionEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.SowAbortionEntryCollection)get("entrys");
    }
    /**
     * Object:ĸ��������¼��'s �Ƿ�����ƾ֤property 
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
     * Object:ĸ��������¼��'s ���ʱ��property 
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
     * Object:ĸ��������¼��'s ״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: ĸ��������¼�� 's ������ property 
     */
    public com.kingdee.eas.farm.pig.PigFarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.pig.PigFarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.pig.PigFarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: ĸ��������¼�� 's ĸ����Ⱥ property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.SowPolulationInfo getPolulation()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.SowPolulationInfo)get("polulation");
    }
    public void setPolulation(com.kingdee.eas.farm.pig.breedingsow.SowPolulationInfo item)
    {
        put("polulation", item);
    }
    /**
     * Object: ĸ��������¼�� 's �Ӳ���Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getOperator()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("operator");
    }
    public void setOperator(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("operator", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5E8018D2");
    }
}