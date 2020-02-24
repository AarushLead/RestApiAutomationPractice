package com.api.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_GET_request {
    
	@Test
	public void getWeatherDetail()
	{
		
		//Specify the Base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Specify the Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Specify the response object
		Response response=httpRequest.request(Method.GET, "/Hyderabad");
		
		//Print the response body
		String responseBody=response.getBody().asString();
		System.out.println("Response body is :" +responseBody);
		
		//Validate the Status code
		int statusCode=response.getStatusCode();
		System.out.println("Status code is :" +statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Verify the Status Line		
		String statusLine=response.getStatusLine();
		System.out.println("StatusLine is :" +statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
			 
	}
}
