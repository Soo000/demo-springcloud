package com.kkwrite.demo.config.util;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DecryptUtil {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://localhost:8888/decrypt");
		
		//String password = "dd2a9105661c9efe70a4151f60d6ca3554343f78889c75fc4286706f7d66c362"; // 对称加密后的字符串
		String password = "AQCgFH1lSnRT9oeeK9DITHhUtLcWDOVL1zIqJ1reEfa55UNzZ2E/JsQhXyQXqGeTuLP3" // 非对称加密后的字符串
				+ "d9xJUFlowbwCEMIoX5kkv63eGjHEbGA80eF24+TNOxdf2i0taz7xBnlcc3W7bz5CMiblAIDk6vwU"
				+ "wQ/rnPGgU2TfsAqVH5FGtlS2N4hlajOtV+uCPBWmu/YkLc2T2Bsl3Mz167n7xSi5etu7iu+6xXzG"
				+ "ulRQUl3jcoKhhD/quJiGtqmFhUWIEabrY2TiFy/KXdSSbvjXXxSWIgSHjty2ghxunffNS9508G27"
				+ "9sZVSc4sXs3T8wwYlkrIiwM4Xc2RWFxa+TLBIvFjew8+WOQJoGeWL7Pe3HyQ+Rt5I97Y9DO8yGdB"
				+ "r4SpGB+O+Df1pDQ=";
		HttpEntity entity = new StringEntity(password, Consts.UTF_8);
		post.setEntity(entity);
		
		HttpResponse response = client.execute(post);
		String content = EntityUtils.toString(response.getEntity());
		System.out.println("content = " + content);
	}
	
}
