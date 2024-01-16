package com.playersRepo.securecalls;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FakedRestAPI {
	
	String baseUrl = "http://localhost:3000/";
	@Test(description="get the list of all the players")
	public void getPlayers() {
		
		
		String endpoint ="players";
		
		Response response = RestAssured.given().baseUri(baseUrl).get(endpoint).then().extract().response();
		
		System.out.println("Response status is:"+response.statusLine());
		System.out.println("Body is:"+response.asPrettyString());
		
	}
	
	@Test(description="add new Players in the league")
	public void addNewPlayers() {
		String endpoint ="players";
		Map<String,Object> map = new HashMap<>();
		map.put("id", 45);
		map.put("name", "Rohit Sharma");
		map.put("sport", "Cricket");
		map.put("age", 264);
		map.put("networth", "USD 4 Billion");
		
		JSONObject jsonObjet = new JSONObject(map);
		Response resposne = RestAssured.given().baseUri(baseUrl+endpoint).body(jsonObjet.toString()).post().then().extract().response();
		System.out.println("response status :"+resposne.getStatusLine());
		System.out.println("body:"+resposne.asPrettyString());
	}

}
