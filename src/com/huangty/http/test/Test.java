package com.huangty.http.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.JSONObject;

import com.huangty.http.Requests;
import com.huangty.http.bean.Response;

public class Test {
	
	public static void main(String[] args) throws IOException {
		
//		String appSecret = "632feff1f4c838541ab75195d1ceb3fa";
//		String nonce = "1";
//		System.out.println(nonce);
//		String curTime = String.valueOf(System.currentTimeMillis());
//		System.out.println(curTime);
//		String CheckSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);
//		System.out.println(CheckSum);
//		String url = "https://api.netease.im/nimserver/stats/chatroom/topn.action";
//		Requests requests = new Requests(url);
//		requests.charset = "utf-8";
//		requests.addHeader("CheckSum", CheckSum);
//		requests.addHeader("AppKey", appSecret);
//		requests.addHeader("Nonce", nonce);
//		requests.addHeader("CurTime", curTime);
//		requests.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
//		requests.data = "timestamp="+ curTime +"&topn=100";
//		Response response = requests.post();
//		System.out.println(response.text);
//		
		String url = "https://plive.48.cn/livesystem/api/live/v1/memberLivePage";
		Requests requestss = new Requests();
		requestss.data = 
				new JSONObject("{"
				+ "\"lastTime\":0,"
				+ "\"groupId\":0, "
				+ "\"type\":0,"
				+ "\"memberId\":0,"
				+ "\"giftUpdTime\":1490857731001,"
				+ "\"limit\":1"
				+ "}"
				).toString();
		List<Map<String, String>> headers = new ArrayList<Map<String, String>>();
		HashMap<String, String> header = new HashMap<String, String>(){
			{
				put("Content-Type", "application/json;charset=utf-8");
			}
		};
		
		headers.add(header);
		requestss.headers = headers;
		System.out.println(requestss.post(url).text);
	}
}
