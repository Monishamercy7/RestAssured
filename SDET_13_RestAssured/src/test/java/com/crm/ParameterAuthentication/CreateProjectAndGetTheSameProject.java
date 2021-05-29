package com.crm.ParameterAuthentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.crm.GenericUtils.EndPoint;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CreateProjectAndGetTheSameProject {
	
	@Test
	public void createProjectAndGetTheSameProject()
	{
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Monisha");
		obj.put("projectName", "QSP");
		obj.put("status", "Ongoing");
		obj.put("teamSize", 3);
		
		 Response resp = given()
		.contentType(ContentType.JSON)
		.body(obj)
		.when()
		.post("http://localhost:8084/addProject");
		 
		 String projectId = resp.jsonPath().get("projectId");
		 
		 given()
			.pathParam("projectId", projectId)
			.when()
			.get("http://localhost:8084/projects/{projectId}")
			.then()
			.log().all()
			.assertThat().statusCode(200)
			.assertThat().contentType(ContentType.JSON);
	}
}
