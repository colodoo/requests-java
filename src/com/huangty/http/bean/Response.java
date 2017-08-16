package com.huangty.http.bean;

import java.util.Map;

public class Response {
	
	// 返回的数据实体
	public String text = null;
	
	// 头部信息
	@SuppressWarnings("rawtypes")
	public Map header = null;
}