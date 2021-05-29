package com.CRUDPractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	@Test
	public void createProjectTest()
	{
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Monisha");
		obj.put("projectName", "SDET_13");
		obj.put("status", "Ongoing");
		obj.put("teamSize", "10");
		
		RequestSpecification res = RestAssured.given();
		res.contentType(ContentType.JSON);
		res.body(obj);
		Response response = res.post("http://localhost:8084/addProject");
		System.out.println(response.getStatusCode());
	}

}
