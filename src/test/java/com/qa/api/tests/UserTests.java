package com.qa.api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import com.qa.api.endpoints.UserEndpoints;
import com.qa.api.enums.StatusCode;
import com.qa.api.payload.User;
import com.qa.api.utilities.HelperClass;
import com.qa.api.utilities.SchemaPaths;

import io.restassured.response.Response;

public class UserTests {

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
	@Test(priority = 1)
	public void createUserTest() {
		Response response = UserEndpoints.createUser(userPayload); // Send a request to create a user
		Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.getCode(), "Failed to create user.");
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
		Assert.assertTrue(helperService.validateSchema(response, SchemaPaths.CREATE_USER), "Schema validation failed.");
	}

	/**
	 * Validates the retrieval of a user with a valid username via the API. Asserts
	 * the response status code, content type, and validates the response schema.
	 */
	@Test(priority = 2)
	public void getUserWithValidNameTest() {
		Response response = null;
		int counter = 0;
		do {
			if(counter++ >= 5) break;
			response = UserEndpoints.getUser(this.userPayload.getUsername()); // Send a request to retrieve a user
		}while(response.getStatusCode() != 200);
		
		Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.getCode(), "Failed to retrieve user.");
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
		Assert.assertTrue(helperService.validateSchema(response, SchemaPaths.GET_USER), "Schema validation failed.");
	}

	/**
	 * Validates the retrieval of a user with an invalid username via the API.
	 * Asserts the response status code, content type, response message, and schema
	 * validation.
	 */
	@Test(priority = 3)
	public void getUserWithInvalidNameTest() {
		Response response = UserEndpoints.getUser(this.userPayload.getUsername() + "**"); // Send a request with an invalid username
		Assert.assertEquals(response.getStatusCode(), StatusCode.ERROR.getCode(),
				"Unexpected status code for invalid user.");
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
		Assert.assertTrue(helperService.verifyResponseMessage(response, "message", "User not found"),
				"Unexpected response message.");
	}

	/**
	 * Validates that a user can be successfully updated via the API. Asserts the
	 * response status code, content type, and validates the response schema.
	 */
	@Test(priority = 4)
	public void updateUserTest() {
		userPayload.setFirstName(faker.name().firstName()); // Update the user's first name
		userPayload.setLastName(faker.name().lastName()); // Update the user's last name
		userPayload.setEmail(faker.internet().emailAddress()); // Update the user's email

		Response response = UserEndpoints.updateUser(userPayload.getUsername(), userPayload); // Send a request to update the user
		Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.getCode(), "Failed to update user.");
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
		Assert.assertTrue(helperService.validateSchema(response, SchemaPaths.UPDATE_USER), "Schema validation failed.");
	}

	/**
	 * Validates that a user can successfully log in via the API. Asserts the
	 * response status code, response message, and validates the response schema.
	 */
	@Test(priority = 5)
	public void loginUserTest() {
		Response response = UserEndpoints
				.loginUser(userPayload.getUsername(), userPayload.getPassword()); // Send a login request
		Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.getCode(), "Failed to log in user.");
		Assert.assertTrue(helperService.verifyResponseMessage(response, "message", "logged in user session:"),
				"Login message validation failed.");
		Assert.assertTrue(helperService.validateSchema(response, SchemaPaths.LOGIN_USER), "Schema validation failed.");
	}

	/**
	 * Validates that a user can successfully log out via the API. Asserts the
	 * response status code, response message, and validates the response schema.
	 */
	@Test(priority = 6)
	public void logoutUserTest() {
		Response response = UserEndpoints.logoutUser(); // Send a logout request
		Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.getCode(), "Failed to log out user.");
		Assert.assertTrue(helperService.verifyResponseMessage(response, "message", "ok"),
				"Logout message validation failed.");
		Assert.assertTrue(helperService.validateSchema(response, SchemaPaths.LOGOUT_USER), "Schema validation failed.");
	}

	/**
	 * Validates that a user can be successfully deleted via the API. Asserts the
	 * response status code and content type.
	 */
	@Test(priority = 7)
	public void deleteUserTest() {
		Response response = UserEndpoints.deleteUser(userPayload.getUsername()); // Send a request to delete the user
		Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.getCode(), "Failed to delete user.");
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	}
}