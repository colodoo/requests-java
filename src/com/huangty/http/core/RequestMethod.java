package com.huangty.http.core;

import java.io.IOException;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import com.huangty.http.bean.Request;
import com.huangty.http.bean.Response;

public class RequestMethod extends Request {
	
	public Response open(String url) throws IOException {
		
		// 初始化
		this.url = url;
		Response reponse = new Response();
			
		// 判断协议
		this.isHttps = this.ishttps(url);
			
		// 判断是否存在数据
		// 存在则设置
		if(this.data != null)
			Util.setData(this.request, this.data);
			
		// 分批处理
//		if(this.isHttps) {
//			((HttpsURLConnection)this.request).setRequestMethod(this.method);
//		}
//		else {
//			((HttpURLConnection)this.request).setRequestMethod(this.method);
//		}
		this.close();
			
		this.request.connect();
			
		// 设置response..
		reponse.text = Util.getText(this.request, this.charset);
		reponse.header = this.request.getHeaderFields();
	
		return reponse;
	}
	
	public boolean ishttps(String url) {
		return url.contains("https");
	}
	
	public void addHeader(String key, String value) {
		this.request.addRequestProperty(key, value);
	}
	
	public void close() {
		if(this.isHttps) {
			((HttpsURLConnection)this.request).disconnect();
		}
		else {
			((HttpURLConnection)this.request).disconnect();
		}
	}

}
