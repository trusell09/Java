package com.russell.moviesite;

public class Actor {
	private String firstName;
	private String lastName;
	private int age;
	
	//constructor
	public Actor() {
		
	}

	public Actor(String firstNameInput, String lastNameInput, int age) {

		this.firstName = firstNameInput;
		this.lastName = lastNameInput;
		this.age = age;
	
	}


	//getters and setters (Source, getters and setters up top, select all)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
		

}
