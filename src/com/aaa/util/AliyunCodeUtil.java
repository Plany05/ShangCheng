package com.aaa.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;


public class AliyunCodeUtil {
	public static String sendCode(String tel) {
		int code = (int)(Math.random()*10000);
		String host = "https://cxkjsms.market.alicloudapi.com";
	    String path = "/chuangxinsms/dxjk";
	    String method = "POST";
	    String appcode = "961a4cee7bb74278ba426b665fae99b0";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    //测试可用默认短信模板,测试模板为专用模板不可修改,如需自定义短信内容或改动任意字符,请联系旺旺或QQ726980650进行申请
        querys.put("content", "【创信】你的验证码是："+code+"，3分钟内有效！");
	    querys.put("mobile", tel);
	    Map<String, String> bodys = new HashMap<String, String>();
	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
	    	//获取response的body
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return String.valueOf(code);
	}

}
