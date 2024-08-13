package com.qa.api.payload;

/**
 * This class represents the User entity that is used as the payload for various
 * API operations such as creating, updating, and retrieving user details. It
 * contains user-related fields, along with their respective getters and
 * setters.
 */
public class User {

	// Fields representing the user's properties
	private int id; // Unique identifier for the user
	private String username; // Username of the user
	private String firstName; // First name of the user
	private String lastName; // Last name of the user
	private String email; // Email address of the user
	private String password; // Password of the user
	private String phone; // Phone number of the user
	private int userStatus; // Status of the user (e.g., active, inactive)

	/**
	 * Gets the unique identifier of the user.
	 * 
	 * @return The user's ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the unique identifier of the user.
	 * 
	 * @param id The user's ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the username of the user.
	 * 
	 * @return The user's username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username of the user.
	 * 
	 * @param username The user's username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the first name of the user.
	 * 
	 * @return The user's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the user.
	 * 
	 * @param firstName The user's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name of the user.
	 * 
	 * @return The user's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the user.
	 * 
	 * @param lastName The user's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the email address of the user.
	 * 
	 * @return The user's email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address of the user.
	 * 
	 * @param email The user's email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password of the user.
	 * 
	 * @return The user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the user.
	 * 
	 * @param password The user's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the phone number of the user.
	 * 
	 * @return The user's phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone number of the user.
	 * 
	 * @param phone The user's phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the status of the user.
	 * 
	 * @return The user's status (e.g., 0 for inactive, 1 for active)
	 */
	public int getUserStatus() {
		return userStatus;
	}

	/**
	 * Sets the status of the user.
	 * 
	 * @param userStatus The user's status (e.g., 0 for inactive, 1 for active)
	 */
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
}
