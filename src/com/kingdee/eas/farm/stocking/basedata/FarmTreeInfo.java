package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;

public class FarmTreeInfo extends AbstractFarmTreeInfo implements Serializable 
{
    public FarmTreeInfo()
    {
        super();
    }
    protected FarmTreeInfo(String pkField)
    {
        super(pkField);
    }
}