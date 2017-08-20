package com.huangty.http.core;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.huangty.http.bean.Request;
import com.huangty.http.bean.Response;

public class RequestMethod extends Request {
	
	public Response open(String url) throws IOException {
		
		// 如果为空的url则初始化
		if(this.url == null)
			this.request = new URL(url).openConnection();
		
		// 初始化
		this.url = url;
		Response reponse = new Response();
			
		// 判断协议
		this.isHttps = this.ishttps(this.url);
		
		// 增加头部到request
		System.out.println(this.headers);
		if(this.headers != null) {
			for(Map<String, String> header : this.headers) {
				for(String key : header.keySet()) {
					this.addHeader(key, header.get(key));
				}
			}
		}
		
		// 判断是否存在数据
		// 存在则设置
		if(this.data != null)
			Util.setData(this.request, this.data);
		
		// 先关闭,解决一些问题
		// this.close();
		
		// 判断url字符串是否被覆盖,或者是否为空
		// ...
		
		// 再次请求
		this.request.connect();
			
		// 设置response
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
		System.out.println(this.request.getURL().toString());
		System.out.println(this.url);
		if(this.ishttps(this.url)) {
			((HttpsURLConnection)this.request).disconnect();
		}
		else {
			((HttpURLConnection)this.request).disconnect();
		}
	}

}
