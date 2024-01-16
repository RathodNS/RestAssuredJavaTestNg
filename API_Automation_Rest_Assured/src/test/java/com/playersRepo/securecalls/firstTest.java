package com.playersRepo.securecalls;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class firstTest {

	@Test
	public void test1() {
		
		String baseurl = "https://bookstore.toolsqa.com/BookStore/v1";
//		RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
		
//		RequestSpecification http_Request = RestAssured.given();
		
//		Response response = http_Request.request(Method.GET,"");
//		Response response = RestAssured.given().baseUri(baseurl).get().then().extract().response();
		Response response = RestAssured.given().baseUri(baseurl).queryParam("ISBN","9781449325862").when().get("/Books").then().extract().response();
		int status_Code = response.getStatusCode();
		
		Assert.assertEquals(status_Code, 200,"Response Stauts not as expected");
		System.out.println("received response status is:"+status_Code);
		System.out.println("Response message is:"+response.asPrettyString());
//		System.out.println("Response message as string:"+response.asString());
		System.out.println(response.getStatusLine());
		
//		ResponseBody body=response.body();
//		String stringBody = body.asString();
//		System.out.println("response body in string:"+stringBody);
		
		//to find a specific node
//		JsonPath jsonEvalutor = response.jsonPath();
		
//		String[] city = jsonEvalutor.get("books[*].author");
//		List<Object> books=jsonEvalutor.getList("books[*].author");
//		System.out.println("Total number of authors are:"+books.size());
//		System.out.println("City is:"+books.get(0));
	Headers headers=	response.headers();
		
	
//		for(Header h:headers) {
//			System.out.println("Header name is:"+h);
//		}
		
//		response.geth
	}
}
