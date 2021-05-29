package com.CRUDPractice;

import org.testng.annotations.Test;

import com.crm.GenericUtils.EndPoint;
import com.crm.POJOClass.Project;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPOJO {
	
	@Test
	public void createProjectsUsingPOJOTest()
	{
		baseURI = "http://localhost";
		port = 8084;
		Project proj = new Project("Monisha", "TY_SDET", "Ongoing", 65);
		
		given()
		.contentType(ContentType.JSON)
		.body(proj)
		.when()
		.post(EndPoint.addProject)
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	
	}
}
