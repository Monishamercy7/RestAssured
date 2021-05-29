package com.CRUDPractice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProjectWithBDD {
	@Test
	public void deleteProjectWithBDDTest()
	{
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_602")
		.then()
		.assertThat().statusCode(204)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	
	}

}
