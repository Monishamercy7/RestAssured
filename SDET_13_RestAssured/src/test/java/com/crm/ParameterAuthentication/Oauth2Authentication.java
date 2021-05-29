package com.crm.ParameterAuthentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2Authentication {
	
	@Test
	public void Oauth2Test()
	{
		Response resp = given()
		.formParam("client_id", "SDET_13")
		.formParam("client_secret", "245d5f48253312c0685c2d035cf2b007")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://myfarm.com")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
		.pathParam("USER_ID", 1922)
		.auth()
		.oauth2(token)
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then().log().all();
		
	}

}
