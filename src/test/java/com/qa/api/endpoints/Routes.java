package com.qa.api.endpoints;

/**
 * Contains API endpoint paths for user-related operations in the PetStore API.
 * Centralizes endpoint paths for ease of maintenance and consistency.
 */
public class Routes {

	// Base URL for the PetStore API
	private static final String BASE_URL = "https://petstore.swagger.io/v2";

	/* Endpoint for creating a new user */
	public static final String CREATE_USER = BASE_URL + "/user";

	/* Endpoint for retrieving a user's details by username */
	public static final String GET_USER_BY_USERNAME = BASE_URL + "/user/{username}";

	/* Endpoint for updating user information by username */
	public static final String UPDATE_USER_BY_USERNAME = BASE_URL + "/user/{username}";

	/* Endpoint for deleting a user by username */
	public static final String DELETE_USER_BY_USERNAME = BASE_URL + "/user/{username}";

	/* Endpoint for logging in a user */
	public static final String LOGIN_USER = BASE_URL + "/user/login";

	/* Endpoint for logging out the current user session */
	public static final String LOGOUT_USER = BASE_URL + "/user/logout";
}
