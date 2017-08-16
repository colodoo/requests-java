package com.huangty.http.test;

import java.io.IOException;

import org.json.JSONObject;

import com.huangty.http.Requests;

public class Test {
	
	public static void main(String[] args) throws IOException {
		Requests requestss = new Requests("https://plive.48.cn/livesystem/api/live/v1/memberLivePage");
		requestss.addHeader("Content-Type", "application/json;charset=utf-8");
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
		System.out.println("{"
				+ "\"lastTime\":0,"
				+ "\"groupId\":0, "
				+ "\"type\":0,"
				+ "\"memberId\":0,"
				+ "\"giftUpdTime\":1490857731001,"
				+ "\"limit\":1"
				+ "}");
		System.out.println(requestss.get().text);
	}
}
