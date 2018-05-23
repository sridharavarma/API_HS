package com.testersconnect.apitests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class API_Test_Class {


	
	
	@Test
	public void verifyCreateCompany() {
	
//		HttpClient hc=new DefaultHttpClient();
		HttpClient hc=HttpClientBuilder.create().build();
		String CreateCompanyURL="https://api.hubapi.com/companies/v2/companies?hapikey=demo";
		
		HttpPost post = new HttpPost(CreateCompanyURL);

		StringEntity params = null;
		try {
			params = new StringEntity("{ \"properties\": [{ \"name\": \"name\", \"value\": \"EUROFINS India\" }, {\"name\": \"description\",  \"value\": \"Software Services & Consulting\" } ]}");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    post.addHeader("content-type", "application/json");
	    post.setEntity(params);
	    try {
			HttpResponse response = hc.execute(post);
			System.out.println(response);
			System.out.println(response.getStatusLine().toString());
			String json = EntityUtils.toString(response.getEntity());
			
			System.out.println(json.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
}