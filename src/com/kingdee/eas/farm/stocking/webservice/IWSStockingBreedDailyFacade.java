package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.commonld.IWebServiceFacade;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public interface IWSStockingBreedDailyFacade extends IWebServiceFacade
{
    public String getDailyInitBillInfo(String param) throws BOSException;
}