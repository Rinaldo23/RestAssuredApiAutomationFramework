package com.qa.api.endpoints;

import static io.restassured.RestAssured.*;

import com.qa.api.payload.User;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * Provides methods to interact with the user-related endpoints of the PetStore API.
 * Each method corresponds to a specific API operation related to user management.
 */
public class UserEndpoints {

    /**
     * Creates a new user in the PetStore API.
     * 
     * @param userPayload The user data to be sent in the request body
     * @return Response from the API after creating the user
     */
    public static Response createUser(User userPayload) {
        return given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(userPayload)
        .when()
            .post(Routes.CREATE_USER);
    }

    /**
     * Retrieves user details from the PetStore API by username.
     * 
     * @param username The username of the user to be retrieved
     * @return Response from the API containing user details
     */
    public static Response getUser(String username) {
        return given()
            .accept(ContentType.JSON)
            .pathParam("username", username)
        .when()
            .get(Routes.GET_USER_BY_USERNAME);
    }

    /**
     * Updates the details of an existing user in the PetStore API.
     * 
     * @param username The username of the user to be updated
     * @param userPayload The updated user data to be sent in the request body
     * @return Response from the API after updating the user
     */
    public static Response updateUser(String username, User userPayload) {
        return given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .pathParam("username", username)
            .body(userPayload)
        .when()
            .put(Routes.UPDATE_USER_BY_USERNAME);
    }

    /**
     * Deletes a user from the PetStore API by username.
     * 
     * @param username The username of the user to be deleted
     * @return Response from the API after deleting the user
     */
    public static Response deleteUser(String username) {
        return given()
            .accept(ContentType.JSON)
            .pathParam("username", username)
        .when()
            .delete(Routes.DELETE_USER_BY_USERNAME);
    }

    /**
     * Logs in a user to the PetStore API.
     * 
     * @param username The username of the user to log in
     * @param password The password of the user to log in
     * @return Response from the API after attempting to log in
     */
    public static Response loginUser(String username, String password) {
        return given()
            .accept(ContentType.JSON)
            .queryParam("username", username)
            .queryParam("password", password)
        .when()
            .get(Routes.LOGIN_USER);
    }

    /**
     * Logs out the current user session from the PetStore API.
     * 
     * @return Response from the API after logging out
     */
    public static Response logoutUser() {
        return given()
            .accept(ContentType.JSON)
        .when()
            .get(Routes.LOGOUT_USER);
    }
}
