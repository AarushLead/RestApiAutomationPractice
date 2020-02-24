package com.api.testcase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_POST_Request {
   
	@SuppressWarnings("unchecked")
	@Test
	public void RegistrationCustomer()
	{
		//Specify the BaseURI
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//Specify the requestObject
		RequestSpecification httpRequest=RestAssured.given();
		
        //Request Payload sending along with Post request
		JSONObject requestParams=new JSONObject();
		requestParams.put("FirstName", "hob812");
		requestParams.put("LastName", "Sharma");
		requestParams.put("UserName", "rush90");
		requestParams.put("Password", "abcd183");
		requestParams.put("Email", "abc0080@gmail.com");
		
		httpRequest.body(requestParams.toJSONString());
		
		httpRequest.headers("Content-Type", "application/json");
		
		//Specify the response object
		Response response = httpRequest.request(Method.POST, "/register");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);
		
		//validate the status code
		int statusCode = response.getStatusCode();
		System.out.println("Status code is :" +statusCode);
		Assert.assertEquals(statusCode, 201);
		
		 //Validate the Response Body Content      
		 JsonPath json = response.jsonPath();
		 String successCode = json.get("SuccessCode").toString();
		 Assert.assertEquals(successCode, "OPERATION_SUCCESS");
		
		
		
		
	}
}
