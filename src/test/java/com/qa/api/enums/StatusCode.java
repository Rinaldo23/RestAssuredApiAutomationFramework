package com.qa.api.enums;

/**
 * Enum representing HTTP status codes used in the PetStore API.
 */
public enum StatusCode {

	SUCCESS(200), /* HTTP status code for a successful request. */
	ERROR(404); /* HTTP status code indicating that the requested resource was not found. */

	private final int code;

	/**
	 * Constructor to initialize the status code.
	 * 
	 * @param code The HTTP status code
	 */
	StatusCode(int code) {
		this.code = code;
	}

	/**
	 * Gets the HTTP status code.
	 * 
	 * @return The HTTP status code
	 */
	public int getCode() {
		return code;
	}
}
