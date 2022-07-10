package controller;

import java.io.Serializable;

public class Citizen implements Serializable {
	private String firstName;
	private String lastName;
	private String identify;
	private Boolean gender;
	private String address;

	public Citizen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Citizen(String firstName, String lastName, String identify, Boolean gender, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.identify = identify;
		this.gender = gender;
		this.address = address;
	}

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

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
