/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.app;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.batchHandler.ResponseContext;


/**
 * output class name
 */
public abstract class AbstractDiscountAdjustPlatformHandler extends com.kingdee.eas.framework.app.CoreUIHandler

{
	public void handleSearch(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleSearch(request,response,context);
	}
	protected void _handleSearch(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
	public void handleConfirm(RequestContext request,ResponseContext response, Context context) throws Exception {
		_handleConfirm(request,response,context);
	}
	protected void _handleConfirm(RequestContext request,ResponseContext response, Context context) throws Exception {
	}
}