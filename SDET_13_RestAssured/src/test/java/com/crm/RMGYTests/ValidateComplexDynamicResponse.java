package com.crm.RMGYTests;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class ValidateComplexDynamicResponse {
	@Test
	public void validateComplexDynamicResponseTest()
	{
		String expData = "Monisha";
		
//		get all the projects
		Response resp = when().get("http://localhost:8084/projects");
		
//		store the response using json path
		List<String> list = resp.jsonPath().get("createdBy");
		for(String str:list)
		{
			if(str.equals(expData))
			{
				System.out.println(expData+"is present in dynamic response");
				break;
			}
		}
		resp.then().log().all();
		
		
	}

}
