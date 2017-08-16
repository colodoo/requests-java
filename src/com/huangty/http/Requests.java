package com.huangty.http;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import com.huangty.http.bean.Response;
import com.huangty.http.core.RequestMethod;

public class Requests extends RequestMethod {
	
	////////////////////
	// 以下为构造方法   //
	////////////////////
	
	/**
	 * 构造方法,默认为带url参数
	 * @param url
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public Requests(String url) throws MalformedURLException, IOException {
		this.url = url;
		this.request = new URL(this.url).openConnection();
	}
	
	/**
	 * 构造方法,默认不带参数
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public Requests() throws MalformedURLException, IOException {
		this.request = new URL(this.url).openConnection();
	}
	
	////////////////////
	// 以下为实际方法   //
	////////////////////
	
	public Response open() throws IOException {
		if(this.url == null) {
			System.out.println("URL IS NULL!!");
		}
		return open(this.url);
	}
	
	/**
	 * POST方法,不带url参数
	 * @param url
	 * @return Response对象
	 * @throws IOException
	 */
	public Response post() throws IOException {
		this.method = "POST";
		return open(this.url);
	}
	
	/**
	 * get方法,不带url参数
	 * @param url
	 * @return Response对象
	 * @throws IOException
	 */
	public Response get() throws IOException {
		this.method = "GET";
		return open(this.url);
	}
	
	/**
	 * POST方法,带url参数
	 * @param url
	 * @return Response对象
	 * @throws IOException
	 */
	public Response post(String url) throws IOException {
		this.method = "POST";
		return this.open(url);
	}
	
	/**
	 * get方法,带url参数
	 * @param url
	 * @return Response对象
	 * @throws IOException
	 */
	public Response get(String url) throws IOException {
		this.method = "GET";
		return this.open(url);
	}
	
	/**
	 * 添加头部
	 * @param key
	 * @param value
	 */
	public void addHeader(String key, String value) {
		super.addHeader(key, value);
	}
	
	/**
	 * 打印响应的头部信息
	 * @param headerMaps
	 */
	public void printAllHeader(Map<String, List<String>> headerMaps) {
		for(Map.Entry<String, List<String>> header : headerMaps.entrySet()) {
			System.out.print(header.getKey() + ":");
			for(int i = 0; i < header.getValue().toArray().length; i++) {
				System.out.print(header.getValue().get(i) + " ");
			}
			System.out.println();
		}
	}
}
