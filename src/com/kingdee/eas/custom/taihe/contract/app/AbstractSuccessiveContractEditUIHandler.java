/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractSuccessiveContractEditUIHandler extends com.kingdee.eas.framework.app.CoreBillEditUIHandler

{
	public void handleActionBalanceBond(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionBalanceBond(request,response,context);
	}
	protected void _handleActionBalanceBond(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionViewOtherContract(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionViewOtherContract(request,response,context);
	}
	protected void _handleActionViewOtherContract(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionAudit(request,response,context);
	}
	protected void _handleActionAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionUnAudit(request,response,context);
	}
	protected void _handleActionUnAudit(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}