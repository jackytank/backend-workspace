package Bai3;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class ParametersTesting {
	@Parameters({ "BrowserName" })
	@Test
	public void openBrowser(String BrowserName) {
		System.out.println("Browser passed as: " + BrowserName);
	}

	@Parameters({ "Username", "Passcode" })
	@Test
	public void FillLoginForm(String Username, String Passcode) {
		System.out.println("Username passed as: " + Username);
		System.out.println("Passcode passed as: " + Passcode);
	}
}
