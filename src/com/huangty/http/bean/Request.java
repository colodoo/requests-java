package com.huangty.http.bean;

import java.net.URLConnection;

public class Request {
	
	// 判断是否为HTTPS协议
	public boolean isHttps = false;
			
	// 默认请求的方法
	public String method = "GET";
			
	// url地址
	public String url = null;
			
	// 请求request
	public URLConnection request = null;
			
	// 编码
	public String charset = "UTF-8";
			
	// 发送的数据
	public String data = null;

}
