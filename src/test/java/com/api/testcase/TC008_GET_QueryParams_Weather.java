package com.api.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC008_GET_QueryParams_Weather {

	@Test
	public void getCityWeather()
	{
		RestAssured.baseURI="https://samples.openweathermap.org/data/2.5";
		RequestSpecification httpRequest = RestAssured.given();
		RequestSpecification queryparam = httpRequest.queryParam("q", "London,UK").queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8");
		Response response = httpRequest.request(Method.GET,"/weather");
		String responseBody=response.getBody().asString();
		Assert.assertEquals(responseBody.contains("London"), true);
	}
}
