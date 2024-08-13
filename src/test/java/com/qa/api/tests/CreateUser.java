package com.qa.api.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.qa.api.endpoints.UserEndpoints;
import com.qa.api.enums.StatusCode;
import com.qa.api.payload.User;
import com.qa.api.utilities.HelperClass;
import com.qa.api.utilities.SchemaPaths;

import io.restassured.response.Response;

public class CreateUser{
	
	private Faker faker;
	private User userPayload;
	private HelperClass helperService;

	/**
	 * Initializes the test setup by creating instances of Faker and HelperClass,
	 * and generating the necessary test data for user operations.
	 */
	@BeforeClass
	public void setUp() {
		faker = new Faker(); // Initialize Faker for generating random test data
		helperService = new HelperClass(); // Initialize the HelperClass for utility functions
		generateUserData(); // Generate random user data for the tests
	}

	/**
	 * Generates random user data using the Faker library. This data will be used as
	 * payload for API requests in the tests.
	 */
	private void generateUserData() {
		userPayload = new User(); // Create a new User object
		userPayload.setId(faker.idNumber().hashCode()); // Set a unique ID for the user
		userPayload.setUsername(faker.name().username()); // Set a random username
		userPayload.setFirstName(faker.name().firstName()); // Set a random first name
		userPayload.setLastName(faker.name().lastName()); // Set a random last name
		userPayload.setEmail(faker.internet().emailAddress()); // Set a random email address
		userPayload.setPassword(faker.internet().password(5, 10)); // Set a random password
		userPayload.setPhone(faker.phoneNumber().cellPhone()); // Set a random phone number
	}

	/**
	 * Validates that a user can be successfully created via the API. Asserts the
	 * response status code, content type, and validates the response schema.
	 */
	@Test()
	public void createUserTest(ITestContext context) {
		Response response = UserEndpoints.createUser(userPayload); // Send a request to create a user

		Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.getCode(), "Failed to create user.");
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
		Assert.assertTrue(helperService.validateSchema(response, SchemaPaths.CREATE_USER), "Schema validation failed.");
		
		/* Test Level Access of the Attribute */
		/* context.setAttribute("username", this.userPayload.getUsername().toString()); */
		
		/* Suite Level Access of the Attribute */
		context.getSuite().setAttribute("username", this.userPayload.getUsername().toString());
	}
}
