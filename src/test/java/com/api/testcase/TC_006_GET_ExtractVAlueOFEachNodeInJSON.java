package com.api.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_006_GET_ExtractVAlueOFEachNodeInJSON {
    
	@Test
	public void getWeatherDetail()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest=RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/Delhi");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is :" +responseBody );
		
		//Extracting value of Response Body Content
		JsonPath jsonPath = response.jsonPath();
		System.out.println(jsonPath.get("City"));
		System.out.println(jsonPath.get("Temperature"));
		System.out.println(jsonPath.get("Humidity"));
		
		//Validate the JSON body content
		Assert.assertEquals(jsonPath.get("City"), "Delhi");
	}
}
