package com.CRUDPractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {
	@Test
	public void updateProjectTest() {
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Monisha");
		obj.put("projectName", "Qsp_to_TY");
		obj.put("status", "On_going");
		obj.put("teamSize", 3);
		
		given()
		.contentType(ContentType.JSON)
		.body(obj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_802")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
		
	}

}
