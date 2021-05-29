package com.crm.ParameterAuthentication;

import org.testng.annotations.Test;

import com.crm.GenericUtils.EndPoint;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameter {
	@Test
	
	public void formParamterTest()
	{
		given()
		.contentType(ContentType.JSON)
		.formParam("createdBy", "Monisha")
		.formParam("projectName", "API")
		.formParam("status", "ongoing")
		.formParam("teamSize", 3)
		.when()
		.post("http://localhost:8084"+EndPoint.addProject)
		.then()
		.log().all()
		.assertThat().statusCode(201);
		
		
	}

}
