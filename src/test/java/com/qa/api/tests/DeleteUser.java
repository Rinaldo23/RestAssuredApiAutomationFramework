package com.qa.api.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.qa.api.endpoints.UserEndpoints;
import com.qa.api.enums.StatusCode;

import io.restassured.response.Response;

public class DeleteUser {

	/**
	 * Validates that a user can be successfully deleted via the API. Asserts the
	 * response status code and content type.
	 */
	@Test()
	public void deleteUserTest(ITestContext context) {
		Response response = UserEndpoints
				.deleteUser(context.getSuite().getAttribute("username").toString()); // Send a request to delete the user
		
		Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.getCode(), "Failed to delete user.");
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}

}
