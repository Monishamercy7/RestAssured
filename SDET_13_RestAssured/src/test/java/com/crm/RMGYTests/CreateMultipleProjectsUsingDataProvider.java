package com.crm.RMGYTests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericUtils.EndPoint;
import com.crm.POJOClass.Project;

import io.restassured.http.ContentType;

public class CreateMultipleProjectsUsingDataProvider {

	@Test (dataProvider = "provideData")
	public void createMultipleProjects(String createdBy, String projectName, int teamSize)
	{
		baseURI = "http://localhost";
		port= 8084;
		Project proj = new Project(createdBy, projectName, "On_Going", teamSize);
		
		
		given()
		.contentType(ContentType.JSON)
		.body(proj)
		.when()
		.post(EndPoint.addProject)
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}
	
	@DataProvider
	public Object[][] provideData()
	{
		Object[][] objArray = new Object [5][3];
		
		objArray[0][0] = "Monisha";
		objArray[0][1] = "Accenture";
		objArray[0][2] = 23;
		
		objArray[1][0] = "Madhu";
		objArray[1][1] = "Accenture";
		objArray[1][2] = 20;
		
		objArray[2][0] = "Supriya";
		objArray[2][1] = "Accenture";
		objArray[2][2] = 16;
		
		objArray[3][0] = "Monu";
		objArray[3][1] = "Accenture";
		objArray[3][2] = 7;
		
		objArray[4][0] = "Mercy";
		objArray[4][1] = "Accenture";
		objArray[4][2] = 56;
		
		return objArray;
		
		
	}
	
	


}
