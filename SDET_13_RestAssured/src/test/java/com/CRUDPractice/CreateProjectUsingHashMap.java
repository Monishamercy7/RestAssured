package com.CRUDPractice;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.crm.GenericUtils.EndPoint;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashMap {
	@Test
	public void createProjectWithHashMapTest()
	{
		HashMap hash = new HashMap();
		hash.put("createBy", "Sam Imman");
		hash.put("projectName", "SDET_API2");
		hash.put("status", "Ongoing");
		hash.put("teamSize", 20);
		
		given()
		.contentType(ContentType.JSON)
		.and()
		.body(hash)
		.when()
		.post("http://localhost:8084"+EndPoint.addProject)
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}

}
