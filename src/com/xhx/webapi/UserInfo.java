package com.xhx.webapi;

import java.io.IOException;
import java.util.Base64;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/**
 * 
 * @author pavithra
 * 
 */

// @Path here defines class level path. Identifies the URI path that 
// a resource class will serve requests for.
@Path("UserInfoService")
public class UserInfo {
	
	private static String url = "http://WIN2012SRV/kaisakuapi/v1/formats/000000005/reports/000000001.json";
	private static String urlpost = "http://WIN2012SRV/kaisakuapi/v1/formats/000000005";
	private static String AuthorizationKey = "53a6423f321820d1729cc4460e6f01b3";

	// @GET here defines, this method will method will process HTTP GET
	 // requests.
	 @GET
	 // @Path here defines method level path. Identifies the URI path that a
	 // resource class method will serve requests for.
	 @Path("/name/{i}")
	 // @Produces here defines the media type(s) that the methods
	 // of a resource class can produce.
	 @Produces(MediaType.APPLICATION_JSON)
	 // @PathParam injects the value of URI parameter that defined in @Path
	 // expression, into the method.
	 public String userName(@PathParam("i") String i) {

	  String name = i;
	  return "<User>" + "<Name>" + name + "</Name>" + "</User>";
	 }

	 @GET 
	 @Path("/age/{j}") 
	 @Produces(MediaType.APPLICATION_JSON)
	 public String userAge(@PathParam("j") int j) {
		// 1.获得一个httpclient对象
			CloseableHttpClient httpclient = HttpClients.createDefault();
			// 2.生成一个get请求
			HttpResponse response = null;
			HttpGet httpGet = new HttpGet(url);
			String enCodedKey = Base64.getEncoder().encodeToString(
					AuthorizationKey.getBytes());
			try {
				httpGet.setHeader("X-KAISAKU-Authorization", enCodedKey);
				httpGet.setHeader("Accept", "application/json, text/plain, */*");
				httpGet.setHeader("Content-Type", "application/json");				

				response = httpclient.execute(httpGet);
				
				System.out.println(response.getStatusLine().getStatusCode() );
				System.out.println(response.getEntity().toString());
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			// 4.处理结果，这里将结果返回为字符串
			HttpEntity entity = response.getEntity();
			String result = null;
			try {
				result = EntityUtils.toString(entity);
			} catch (ParseException | IOException e) {
				e.printStackTrace();
			}
			
	  int age = j;
	  return result;
	 }
}
