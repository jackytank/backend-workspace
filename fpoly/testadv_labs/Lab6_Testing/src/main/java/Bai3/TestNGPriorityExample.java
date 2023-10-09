package Bai3;

import org.testng.annotations.Test;

public class TestNGPriorityExample {
	@Test
	public void registerAccount() {
		System.out.println("Please register your account!");
	}

	@Test(priority = 2)
	public void sendEmail() {
		System.out.println("Send email after login");
	}

	@Test(priority = 1)
	public void login() {
		System.out.println("Login to the account after registration!");
	}
}
