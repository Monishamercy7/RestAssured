package com.crm.RMGYTests;

import org.apache.http.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ValidateComplexResponse {
	@Test
	public void validateComplexResponseProjectNameTest()
	{

	String expData = "SDET_13_API";
	

//	get all the projects
	Response resp = when()
	.get("http://localhost:8084/projects");
	
//	store the static response using json path
	String actData = resp.jsonPath().get("[0].projectName");
	System.out.println(actData);
	
	resp.then()
	.log().all();
	
//	validate
	Assert.assertEquals(expData, actData);
	
	
	
	}

}
