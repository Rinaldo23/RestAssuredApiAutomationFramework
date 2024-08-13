package com.qa.api.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.qa.api.endpoints.UserEndpoints;
import com.qa.api.enums.StatusCode;
import com.qa.api.utilities.HelperClass;
import com.qa.api.utilities.SchemaPaths;

import io.restassured.response.Response;

public class FetchUser extends HelperClass{

	/**
	 * Validates the retrieval of a user with a valid username via the API. Asserts
	 * the response status code, content type, and validates the response schema.
	 */
	@Test()
	public void GetUserTest(ITestContext context) {
		Response response = null;
		int counter = 0;
		do {
			if (counter++ >= 5)
				break;
			// Send a request to retrieve a user
			response = UserEndpoints.getUser(context.getSuite().getAttribute("username").toString());
		} while (response.getStatusCode() != 200);

		Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.getCode(), "Failed to retrieve user.");
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
		Assert.assertTrue(validateSchema(response, SchemaPaths.GET_USER), "Schema validation failed.");
	}
}
