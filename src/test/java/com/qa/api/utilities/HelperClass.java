package com.qa.api.utilities;

import org.json.JSONException;
import org.json.JSONObject;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

/**
 * Utility class providing helper methods for API response validation.
 */
public class HelperClass {

    /**
     * Verifies if the response contains a specific value for a given key.
     * 
     * @param response The API response to check
     * @param key The key in the JSON response to look for
     * @param value The value to verify against
     * @return true if the value is found for the key, false otherwise
     */
    public boolean verifyResponseMessage(Response response, String key, String value) {
        if (response != null && !key.isBlank()) {
            try {
                String jsonBody = response.getBody().asString();
                JSONObject jsonObject = new JSONObject(jsonBody);
                return jsonObject.get(key).toString().contains(value);
            } catch (JSONException e) {
                e.printStackTrace();
                return false; // Return false if JSON parsing fails
            }
        }
        return false;
    }

    /**
     * Validates the response against a JSON schema.
     * 
     * @param response The API response to validate
     * @param schemaPath The classpath location of the JSON schema file
     * @return true if the response schema is valid, false otherwise
     */
    public boolean validateSchema(Response response, String schemaPath) {
        try {
            response.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
            return response.getStatusCode() == 200;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false if schema validation fails or an exception occurs
        }
    }
}
