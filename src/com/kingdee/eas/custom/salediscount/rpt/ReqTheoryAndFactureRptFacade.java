package com.kingdee.eas.custom.salediscount.rpt;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.salediscount.rpt.app.*;
import com.kingdee.eas.framework.report.CommRptBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class ReqTheoryAndFactureRptFacade extends CommRptBase implements IReqTheoryAndFactureRptFacade
{
    public ReqTheoryAndFactureRptFacade()
    {
        super();
        registerInterface(IReqTheoryAndFactureRptFacade.class, this);
    }
    public ReqTheoryAndFactureRptFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IReqTheoryAndFactureRptFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("24515A5B");
    }
    private ReqTheoryAndFactureRptFacadeController getController() throws BOSException
    {
        return (ReqTheoryAndFactureRptFacadeController)getBizController();
    }
}