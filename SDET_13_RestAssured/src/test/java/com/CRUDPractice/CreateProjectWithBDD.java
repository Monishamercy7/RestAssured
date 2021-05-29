package com.CRUDPractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectWithBDD {
	@Test
	public void  createProjectWithBDDTest()
	{
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Monisha");
		obj.put("projectName", "QSP");
		obj.put("status", "Ongoing");
		obj.put("teamSize", 3);
		
		given()
		.contentType(ContentType.JSON)
		.and()
		.body(obj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
	}

}
