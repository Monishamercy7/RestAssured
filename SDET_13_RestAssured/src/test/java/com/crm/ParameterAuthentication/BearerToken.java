package com.crm.ParameterAuthentication;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {
	@Test
	public void bearerTokenTest()
	{
		HashMap map = new HashMap();
		map.put("name", "Monisha");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		.when()
		.post("https://api.github.com/user/repos")
		.then()
		.log().all()
		.assertThat().statusCode(201);
		
	}

}
