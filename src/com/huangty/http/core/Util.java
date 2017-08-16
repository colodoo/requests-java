package com.huangty.http.core;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URLConnection;

/**
 * 工具方法
 * @author Administrator
 *
 */
public class Util {
	
	/**
	 * 设置发送的数据
	 * @param request
	 * @param data
	 * @return
	 */
	public static boolean setData(URLConnection request, String data) 
	{
		request.setDoOutput(true);
		OutputStream outputStream = null;
		DataOutputStream dataOutputStream = null;
		try {
			outputStream = request.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			dataOutputStream.writeBytes(data);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 取得响应的主体
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static String getText(URLConnection request, String charset) throws IOException
	{
		InputStream requestInputStream = null;
		StringBuffer responseStringBuf = new StringBuffer();
		String readLines = null;
		String responseContent = null;
		
		requestInputStream = request.getInputStream();
		BufferedReader bufferedReader = null;
		bufferedReader = new BufferedReader(new InputStreamReader(requestInputStream,"UTF-8"));
		while ((readLines = bufferedReader.readLine()) != null) {
			readLines = new String(readLines.getBytes(), charset);
			responseStringBuf.append(readLines);
		}
		responseContent = responseStringBuf.toString();

		return responseContent;
	}

}
