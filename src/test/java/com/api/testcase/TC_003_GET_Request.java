package com.api.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003_GET_Request {
    
	@Test
	public void getGoogleMap()
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//Specify the Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Specify the Response Object		
		Response response=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		//Print response to console
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is :" +responseBody);
		
		//Verify the Response Header
		String contentType=response.getHeader("Content-Type");
		System.out.println("Content Type is:"+contentType);
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
		
		//capture the content-Encoding
		String contentEncoding=response.getHeader("Content-Encoding");
		System.out.println("Content Encoding is:"+contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
	}
}
