package controller;
import java.io.Serializable;

public class Company implements Serializable {
	private String name;
	private String address;
	private String registerNumber;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(String name, String address, String registerNumber) {
		super();
		this.name = name;
		this.address = address;
		this.registerNumber = registerNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

}
