package com.crm.ParameterAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Pathparameter {
	@Test
	public void pathParameterTest()
	{

		given()
		.pathParam("projectID", "TY_PROJ_603")
		.when()
		.delete("http://localhost:8084/projects/{projectID}")
		.then()
		.log().all()
		.assertThat().statusCode(204);
	
	}

}
