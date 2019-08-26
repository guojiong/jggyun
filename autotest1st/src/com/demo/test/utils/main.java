package com.demo.test.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class main {
	public static void main(String[] args) {
		SeleniumUtil seleniumUtil = new SeleniumUtil();
		try {
//			String testData = "{\"url\":\"http://171.221.203.106:8607/pub/order/queryOrderHisotry\", \"json\":\"{}\"}";//
			
			String testData = "{\"url\":\"http://test.jggyun.com:8080/jddjOrder/jd_cdymtxk/djsw/newOrder\", \"json\":{\"app_key\":\"1db5f8a8b1424d06a441b339f48e36bd\",\"format\":\"json\"}}";

			JSONObject jsonObj = (JSONObject)(new JSONParser().parse(testData));
			String returnValue = seleniumUtil.httpPostWithJson(jsonObj.get("url").toString(), "{}");
			System.out.println(returnValue);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
