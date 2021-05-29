package com.CRUDPractice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSigleProject {
	@Test
	public void getSingleProjectTest()
	{
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_608");
		System.out.println(resp.asString());
		System.out.println(resp.asPrettyString());
	}

}
