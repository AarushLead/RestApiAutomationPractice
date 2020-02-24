package dataDriventest;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddNewEmployee {

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "empDataProvider")
	void postNewEmployee(String fname, String lname, String uname, String pwd, String email) {

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", fname);
		requestParams.put("LastName", lname);
		requestParams.put("UserName", uname);
		requestParams.put("Password", pwd);
		requestParams.put("Email", email);

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

		JsonPath json = response.jsonPath();
		String successCode = json.get("SuccessCode").toString();
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	}

	@DataProvider(name = "empDataProvider")
	String[][] getEmpData() throws IOException {
		String path=System.getProperty("user.dir")+"/excel/excelread.xlsx";
		int row =ExcelUtility.getRowCount(path, "Sheet2");
		int cell=ExcelUtility.getCellCount(path, "Sheet2", row);
		String[][] data = new String[row][cell];
		for (int i = 1; i <=row; i++) {
			for (int j = 0; j <cell; j++) {
				data[i-1][j]=ExcelUtility.getCellData(path, "Sheet2", i, j);
			}
		}
		return data;
		
	}
}
