package com.testersconnect.apitests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class HSTestClass extends TestCaseBase {
	
	String companyID="";
	String contactId="";
	
	@Test (priority=1)
	public void verifyCreateCompany() {
		logger = extent.createTest("VerifyCreateCompany");
		 
		 
		System.out.println("===========================");
		System.out.println("Started verifyCreateCompany");
		
		HttpClient hc=HttpClientBuilder.create().build();
		String CreateCompanyURL="https://api.hubapi.com/companies/v2/companies?hapikey=8df375b5-2632-4d8c-a195-a464849040df";
		
		HttpPost post = new HttpPost(CreateCompanyURL);

		StringEntity params = null;
		try {
			params = new StringEntity("{ \"properties\": [{ \"name\": \"name\", \"value\": \"TestersConnect\" }, {\"name\": \"description\",  \"value\": \"Software Services & Consulting\" } ]}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    post.addHeader("content-type", "application/json");
	    post.setEntity(params);
	    String json = null;
	    try {
			HttpResponse response = hc.execute(post);
			System.out.println(response);
			System.out.println(response.getStatusLine().toString());
			
			int result = response.getStatusLine().getStatusCode();
			
			if (result == 200){
				logger.log(Status.PASS, MarkupHelper.createLabel("VerifyCreateCompany test is passed", ExtentColor.GREEN));
			}
			else {
				logger.log(Status.FAIL, MarkupHelper.createLabel("VerifyCreateCompany test is Failed", ExtentColor.RED));
			}
			
				
			json = EntityUtils.toString(response.getEntity());
			
			System.out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    JSONParser parser=new JSONParser();
		try {
			    Object obj=parser.parse(json.toString());
				JSONObject jsonObj=(JSONObject)obj;
				
				System.out.println(jsonObj.get("companyId"));
				companyID=jsonObj.get("companyId").toString();
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Ended verifyCreateCompany");
	}
	
	@Test(priority=2)
	public void verifyUpdateCompany() {
		logger = extent.createTest("VerifyUpdateCompany");
		System.out.println("===========================");
		System.out.println("Started verifyUpdateCompany");
	
		HttpClient hc=HttpClientBuilder.create().build();
		String UpdateCompanyURL="https://api.hubapi.com/companies/v2/companies/"+companyID+"?hapikey=8df375b5-2632-4d8c-a195-a464849040df";
		
		HttpPut put = new HttpPut(UpdateCompanyURL);

		StringEntity params = null;
		try {
			params = new StringEntity("{ \"properties\": [{\"name\": \"name\", \"value\": \"Herbalife\" },{\"name\": \"description\", \"value\": \"Product based company modified\" },{\"name\": \"city\", \"value\": \"Bangalore\"},{\"name\": \"domain\", \"value\":\"herbalife.com\"}]}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    put.addHeader("content-type", "application/json");
	    put.setEntity(params);
	    try {
			HttpResponse response = hc.execute(put);
			System.out.println(response);
			System.out.println(response.getStatusLine().toString());
			
			int result = response.getStatusLine().getStatusCode();
						
			if (result == 200){
				logger.log(Status.PASS, MarkupHelper.createLabel("VerifyUpdateCompany test is passed", ExtentColor.GREEN));
			}
			else {
				logger.log(Status.FAIL, MarkupHelper.createLabel("VerifyUpdateCompany test is Failed", ExtentColor.RED));
			}
			
			
			String json = EntityUtils.toString(response.getEntity());
			
			System.out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("Ended verifyUpdateCompany");
	}
	
	
	@Test (priority=3)
	public void verifyCreateContact() {
		logger = extent.createTest("VerifyCreateContact");
		System.out.println("===========================");
		System.out.println("Started verifyCreateContact");
	
		HttpClient hc=HttpClientBuilder.create().build();
		String CreateContactURL = "https://api.hubapi.com/contacts/v1/contact/?hapikey=8df375b5-2632-4d8c-a195-a464849040df";
		HttpPost post = new HttpPost(CreateContactURL);

		StringEntity params = null;
		try {
			params = new StringEntity("{\"properties\": [{\"property\": \"email\",\"value\": \"apiqa@herbalife.com\"},{\"property\": \"firstname\",\"value\": \"Sridhara\"},{\"property\": \"lastname\",\"value\": \"Varma\"}]}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    post.addHeader("content-type", "application/json");
	    post.setEntity(params);
	    String json = null;
	    try {
			HttpResponse response = hc.execute(post);
			System.out.println(response);
			System.out.println(response.getStatusLine().toString());
			
			int result = response.getStatusLine().getStatusCode();
			
			if (result == 200){
				logger.log(Status.PASS, MarkupHelper.createLabel("VerifyCreateContact test is passed", ExtentColor.GREEN));
			}
			else {
				logger.log(Status.FAIL, MarkupHelper.createLabel("VerifyCreateContact test is Failed", ExtentColor.RED));
			}
			
			json = EntityUtils.toString(response.getEntity());
			
			System.out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    
	    JSONParser parser=new JSONParser();
		try {
			    Object obj=parser.parse(json.toString());
				JSONObject jsonObj=(JSONObject)obj;
				
				//System.out.println(jsonObj.toString());
				//System.out.println(jsonObj.get("identityProfile"));
				//obj=jsonObj.get("identityProfile");
				//jsonObj=(JSONObject)obj;
				System.out.println(jsonObj.get("vid"));
				
				
				contactId=jsonObj.get("vid").toString();
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Ended verifyCreateContact");
		
	}
	
	
	@Test(priority=4)
	public void verifyCompanyContacts() {
		logger = extent.createTest("verifyCompanyContacts");
		System.out.println("===========================");
		System.out.println("Started verifyCompanyContacts");
	
		HttpClient hc=HttpClientBuilder.create().build();
		String GetCompanyContactsURL="https://api.hubapi.com/companies/v2/companies/"+companyID+"/contacts?hapikey=8df375b5-2632-4d8c-a195-a464849040df";
		
		HttpGet get = new HttpGet(GetCompanyContactsURL);

		/*StringEntity params = null;
		try {
			params = new StringEntity("{ \"properties\": [{\"name\": \"name\", \"value\": \"Herbalife\" },{\"name\": \"description\", \"value\": \"Product based company modified\" },{\"name\": \"city\", \"value\": \"Bangalore\"},{\"name\": \"domain\", \"value\":\"herbalife.com\"}]}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    get.addHeader("content-type", "application/json");
	    get.setEntity(params);*/
		
		String json="";
	    try {
			HttpResponse response = hc.execute(get);
			System.out.println(response);
			System.out.println(response.getStatusLine().toString());
			
			int result = response.getStatusLine().getStatusCode();
			
			if (result == 200){
				logger.log(Status.PASS, MarkupHelper.createLabel("verifyCompanyContacts test is passed", ExtentColor.GREEN));
			}
			else {
				logger.log(Status.FAIL, MarkupHelper.createLabel("verifyCompanyContacts test is Failed", ExtentColor.RED));
			}
			
			json = EntityUtils.toString(response.getEntity());
			
			System.out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    JSONParser parser=new JSONParser();
	    String actualContactId = null;
		try {
			    Object obj=parser.parse(json.toString());
				JSONObject jsonObj=(JSONObject)obj;
				
				System.out.println(jsonObj.toString());
				
				System.out.println(jsonObj.get("vidOffset"));
				actualContactId=jsonObj.get("vidOffset").toString();
	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(actualContactId, contactId);
		
		System.out.println("Ended verifyCompanyContacts");
	    
	}
	
	
	@Test(priority=5)
	public void verifyDeleteCompany() {
		logger = extent.createTest("verifyDeleteCompany");
		System.out.println("===========================");
		System.out.println("Started verifyDeleteCompany");
	
		HttpClient hc=HttpClientBuilder.create().build();
		String DeleteCompanyURL="https://api.hubapi.com/companies/v2/companies/"+companyID+"?hapikey=8df375b5-2632-4d8c-a195-a464849040df";
		
		HttpDelete del = new HttpDelete(DeleteCompanyURL);

		//StringEntity params = null;
		try {
			//params = new StringEntity("{\"companyId\": 806133201, \"deleted\": true}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    del.addHeader("content-type", "application/json");
	    //del.setEntity(params);
	    try {
			HttpResponse response = hc.execute(del);
			System.out.println(response);
			System.out.println(response.getStatusLine().toString());
			
			int result = response.getStatusLine().getStatusCode();
			
			if (result == 200){
				logger.log(Status.PASS, MarkupHelper.createLabel("verifyDeleteCompany test is passed", ExtentColor.GREEN));
			}
			else {
				logger.log(Status.FAIL, MarkupHelper.createLabel("verifyDeleteCompany test is Failed", ExtentColor.RED));
			}
			
			String json = EntityUtils.toString(response.getEntity());
			Assert.assertEquals(response.getStatusLine().toString(), "HTTP/1.1 200 OK");
			
			System.out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("Ended verifyDeleteCompany");
	}
	
	@Test(priority=6)
	public void verifyDeleteContact() {
		logger = extent.createTest("verifyDeleteContact");
		System.out.println("===========================");
		System.out.println("Started verifyDeleteContact");
	
		HttpClient hc=HttpClientBuilder.create().build();
		String DeleteContactURL="https://api.hubapi.com/contacts/v1/contact/vid/"+contactId+"?hapikey=8df375b5-2632-4d8c-a195-a464849040df";
		
		
		HttpDelete del = new HttpDelete(DeleteContactURL);

		//StringEntity params = null;
		try {
			//params = new StringEntity("{\"companyId\": 806133201, \"deleted\": true}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    del.addHeader("content-type", "application/json");
	    //del.setEntity(params);
	    try {
			HttpResponse response = hc.execute(del);
			System.out.println(response);
			System.out.println(response.getStatusLine().toString());
			
			int result = response.getStatusLine().getStatusCode();
			
			if (result == 200){
				logger.log(Status.PASS, MarkupHelper.createLabel("verifyDeleteContact test is passed", ExtentColor.GREEN));
			}
			else {
				logger.log(Status.FAIL, MarkupHelper.createLabel("verifyDeleteContact test is Failed", ExtentColor.RED));
			}
			
			String json = EntityUtils.toString(response.getEntity());
			Assert.assertEquals(response.getStatusLine().toString(), "HTTP/1.1 200 OK");
			
			System.out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("Ended verifyDeleteCompany");
	}
	
	
	
}