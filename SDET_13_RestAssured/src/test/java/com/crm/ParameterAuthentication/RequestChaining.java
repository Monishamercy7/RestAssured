package com.crm.ParameterAuthentication;

import org.testng.annotations.Test;

import com.crm.GenericUtils.EndPoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChaining {
	@Test
	
	public void requestChainingTest()
	{
		Response resp = when()
		.get("http://localhost:8084"+EndPoint.getProject);
		
		String firstProjectId = resp.jsonPath().get("[7].projectId");
		System.out.println(firstProjectId);
		given()
		.pathParam("projectId", firstProjectId)
		.when()
		.delete("http://localhost:8084/projects/{projectId}")
		.then()
		.log().all()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(204);
		
	}

}
