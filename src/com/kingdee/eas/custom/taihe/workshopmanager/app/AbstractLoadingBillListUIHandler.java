/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.workshopmanager.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractLoadingBillListUIHandler extends com.kingdee.eas.custom.wlhllicensemanager.app.WlhlCoreBillListUIHandler

{
	public void handleActionTDPrint(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionTDPrint(request,response,context);
	}
	protected void _handleActionTDPrint(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionTDPrintPreview(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionTDPrintPreview(request,response,context);
	}
	protected void _handleActionTDPrintPreview(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionMobileQuery(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionMobileQuery(request,response,context);
	}
	protected void _handleActionMobileQuery(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleActionMobifyAddNew(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleActionMobifyAddNew(request,response,context);
	}
	protected void _handleActionMobifyAddNew(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}