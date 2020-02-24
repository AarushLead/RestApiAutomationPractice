package com.api.testcase;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC009_PUT_UpdateEmployee {

	
	int empID=15410;
	@SuppressWarnings("unchecked")
	@Test
	public void updateSingleRecord()
	{   
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject params=new JSONObject();
		params.put("name", "John");
		params.put("age","76");
		params.put("salary","36486384");
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(params.toJSONString());
		Response response = httpRequest.request(Method.PUT,"/update/"+empID);
		String responseBody=response.getBody().asString();
		int status = response.getStatusCode();
		Assert.assertEquals(status, 200);
		Assert.assertEquals(responseBody.contains("John"),true);
	}
}
