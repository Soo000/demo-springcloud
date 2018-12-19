package com.kkwrite.demo.zuul.common;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RefreshConfig {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://localhost:1041/refresh");
		HttpResponse response = client.execute(post);
		String content = EntityUtils.toString(response.getEntity());
		System.out.println("content = " + content);
	}
	
}
