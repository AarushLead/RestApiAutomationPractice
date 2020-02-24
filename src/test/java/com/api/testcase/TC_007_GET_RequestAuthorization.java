package com.api.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_007_GET_RequestAuthorization {
    
	@Test
	public void AuthorizationTest()
	{   
		///base URI
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		
		//Basic authentication
		PreemptiveBasicAuthScheme authScheme=new PreemptiveBasicAuthScheme();
		authScheme.setUserName("ToolsQA");
		authScheme.setPassword("TestPassword");
		RestAssured.authentication=authScheme;
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/");
		
		//Getting Response Body 
		String requestBody=response.getBody().asString();
		System.out.println("Request Body is :" +requestBody);
	   
		//Status code validation	
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is :" +statusCode);
		Assert.assertEquals(statusCode, 200);
	}
}
