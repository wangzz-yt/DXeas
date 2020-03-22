package com.kingdee.eas.custom.tocloud.app;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;

public class DeleteCloudBillControllerBean extends AbstractDeleteCloudBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.tocloud.app.DeleteCloudBillControllerBean");


	private static String POST_K3CloudURL = null;//"http://60.212.47.112:88/K3Cloud/";
	//	private static String dbId = "5c1c5501b116cb";//测试  5c01dbdaf91e8d
	private static String dbId = "5c01dbdaf91e8d";//正式
	private static String user = "天源";
	private static String pwd = "852963";   //正式
	//	private static String pwd = "ty123456";   //测试
	private static int lang = 2052;

	private static String sessionkey = "kdservice-sessionid";
	private static String aspnetsessionkey = "ASP.NET_SessionId";
	private static String sessionValue = "";
	private static String aspnetsessionValue = "";
	private static Map map = new HashMap();
	static {
		map.put("Delete", 
		"Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Delete.common.kdsvc");
		map.put("ExecuteBillQuery", 
		"Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.ExecuteBillQuery.common.kdsvc");
		map.put("Login", 
		"Kingdee.BOS.WebApi.ServicesStub.AuthService.ValidateUser.common.kdsvc");
		map.put("Save",
		"Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Save.common.kdsvc");

		map.put("Submit",
		"Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Submit.common.kdsvc");
		map.put("Audit",
		"Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Audit.common.kdsvc");
	}

	/**
	 * 删除cloud对应单据
	 */
	@Override
	protected String _deleteCloudBill(Context ctx, String jsonParam)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return Invoke("Delete", jsonParam);
	}

	/**
	 * 获取Cloud领料出库单分录的总成本字段
	 */
	@Override
	protected String _getCostValue(Context ctx, String param)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return Invoke("ExecuteBillQuery", param);
	}



	

	@Override
	protected String _auditBill(Context ctx, String param) throws BOSException {
		// TODO Auto-generated method stub
		return Invoke("Audit", param);
	}

	@Override
	protected String _submitBill(Context ctx, String param) throws BOSException {
		// TODO Auto-generated method stub
		return Invoke("Submit", param);
	}

	@Override
	protected String _saveBill(Context ctx, String param) throws BOSException {
		// TODO Auto-generated method stub
		return Invoke("Save", param);
	}

	/**
	 * 
	 * @param method
	 * @param param
	 * @return
	 */
	private static String Invoke(String method, String jsonParam){

		// 定义httpClient的实例
		HttpClient httpclient = new DefaultHttpClient();
		try {
			String sUrl = map.get(method).toString();
			//参数不为空，并且登陆成功
			if(StringUtils.isNotBlank(sUrl) && loginToK3Cloud()){
				//设置需要连接的接口的地址
				URI uri = new URI(POST_K3CloudURL.concat(sUrl));

				//建立HttpPost对象，传递数据
				HttpPost httpPost = new HttpPost(uri);
				//添加参数
				StringEntity entity = new StringEntity(jsonParam, "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");

				//把成功登录的Session信息传进去，获取连接信息
				httpPost.setHeader(sessionkey, sessionValue);
				httpPost.setHeader(aspnetsessionkey, aspnetsessionValue);

				//设置参数
				httpPost.setEntity(entity);

				//调用HttpClient对象的execute(HttpUriRequest request)发送请求，该方法返回一个HttpResponse
				HttpResponse result = httpclient.execute(httpPost);
				// 请求发送成功，并得到响应
				if (result.getStatusLine().getStatusCode() == 200) {
					System.out.println("请求成功");
					//                        String str = "";
					// 读取服务器返回过来的json字符串数据
					//result.getEntity()--获取HttpEntity对象，该对象包装了服务器的响应内容
					String str = EntityUtils.toString(result.getEntity());
					System.out.println(str);
					return str;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}






	private static boolean loginToK3Cloud() {
		// 定义httpClient的实例
		HttpClient httpclient = new DefaultHttpClient();
		JSONObject jsonResult = null;

		/********** 用户登录Begin ************************/
		try {
			//登录，校验用户的API接地址
			String sUrl = map.get("Login").toString();
			//拼接之后的字符串
			URI uri = new URI(POST_K3CloudURL.concat(sUrl));
			//发送POST请求,创建HttpPost对象
			HttpPost method = new HttpPost(uri);
			// 登录请求参数
			JSONObject jsonParam = new JSONObject();
			jsonParam.put("acctID", dbId);
			jsonParam.put("userName", user);
			jsonParam.put("password", pwd);
			jsonParam.put("lcid", lang);
			//这里传入的是用户登陆的信息
			StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			method.setEntity(entity);          
			// 调用HttpClient对象的execute(HttpUriRequest request)发送请求，该方法返回一个HttpResponse
			HttpResponse result = httpclient.execute(method);
			// 请求发送成功，并得到响应
			if (result.getStatusLine().getStatusCode() == 200) {
				String str = "";
				// 读取服务器返回过来的json字符串数据
				str = EntityUtils.toString(result.getEntity());
				// 把json字符串转换成json对象
				jsonResult = JSONObject.fromObject(str);
				// 判断登录是否成功
				if (jsonResult.getInt("LoginResultType") == 1) {
					System.out.println("登录成功！");
					// 获取标头中的Cookie
					Header[] headers = result.getHeaders("Set-Cookie");
					for (int i = 1; i < headers.length; i++) {
						Header header = headers[i];
						String headerValue = header.getValue();
						// 登录成功返回的登录session信息，保存下来，下面再调用接口的时候传给服务端
						if (headerValue.trim().startsWith(sessionkey)) {
							int endIndex = headerValue.indexOf(';');
							sessionValue = headerValue.substring(20, endIndex);
						} else if (headerValue.trim().startsWith(
								aspnetsessionkey)) {
							int endIndex = headerValue.indexOf(';');
							aspnetsessionValue = headerValue.substring(18,
									endIndex);
						}

					}

					return true;
				}
				// 登录失败，不继续
				else {
					System.out.println("登录失败！"+jsonResult.getInt("LoginResultType"));
					return false;
				}
			} else {
				System.out.println("登录异常！"+result.getStatusLine().getStatusCode());
				return false;

			}
		} catch (Exception e) {
			System.out.println("post请求提交失败:" + e);
		}
		return false;

	}




}