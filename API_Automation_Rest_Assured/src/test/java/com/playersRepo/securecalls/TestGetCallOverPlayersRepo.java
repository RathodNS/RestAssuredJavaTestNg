package com.playersRepo.securecalls;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import freemarker.core._DelayedConversionToString;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo_classes.Players;
import reportManager.ExtentLogger;
import static org.hamcrest.Matchers.equalTo;

public class TestGetCallOverPlayersRepo {

	@Test(description = "Validate json schema using pojo class")
	public void validateJsonScheaUsingPojo() {
		String BaseURI = Constants.BASE_URL;
		String Endpoint = Constants.GetALLPlayers_EndPoint;
		List<Players> player = RestAssured.given().baseUri(BaseURI).when().get(Endpoint).then().extract().jsonPath()
				.getList(".", Players.class);
		Assert.assertEquals("Sachin Tendulkar", player.get(0).getName());
		Assert.assertEquals("Cricket", player.get(0).getSport());
		Assert.assertEquals(48, player.get(0).getAge());
		Assert.assertEquals(10, player.get(0).getJersyNumber());
		Assert.assertFalse(player.get(0).getNetworth().isBlank(), "Player net worth was not null");
	}

	@Test(description = "Get profile of all the players")
	public void testGetAllPlayersProfile() {

		Response res = RestAssured.given().baseUri(Constants.BASE_URL).when().get(Constants.GetPlayers_INFO_End_Point)
				.then().extract().response();
		ExtentLogger.logResponseInReport("Players", res.body().asPrettyString());
		Assert.assertEquals(res.getStatusCode(), 200);
	}

	@Test(description = "Get Player Profile by his/Her jersy Number")
	public void getPlayerInfoByJerSeyNumber() {

		Response res = RestAssured.given().baseUri(Constants.BASE_URL).queryParam("JersyNumber", 23)
				.when().get(Constants.GetPlayers_INFO_End_Point).then().extract()
				.response();

		ExtentLogger.logResponseInReport("Player by Jersy Number", res.body().asPrettyString());
		Assert.assertEquals(res.statusCode(), 200);
	}
	
	@Test(description = "Validate response is in json format")
	public void verifyThatResponseIsInJsonFormat() {

		Response res = RestAssured.given().baseUri(Constants.BASE_URL).queryParam("JersyNumber", 23)
				.when().get(Constants.GetPlayers_INFO_End_Point);
			
		res.then().statusCode(200);
		
		res.then().assertThat().contentType(equalTo(("application/json")));
		
		System.out.println(res.body().asPrettyString());
		
		System.out.println(res.getHeaders().toString());

	}
}
