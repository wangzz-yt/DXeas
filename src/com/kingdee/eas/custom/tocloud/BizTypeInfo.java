package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;

public class BizTypeInfo extends AbstractBizTypeInfo implements Serializable 
{
    public BizTypeInfo()
    {
        super();
    }
    protected BizTypeInfo(String pkField)
    {
        super(pkField);
    }
}