package com.kingdee.eas.custom.mobileRPT;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public interface ImobileRPTFacade extends IBizCtrl
{
    public String getData(String param) throws BOSException;
    public boolean sendPRT() throws BOSException;
}