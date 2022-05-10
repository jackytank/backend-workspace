package Bai1;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firsttestngfile {
	String baseURL = "https://lms.poly.edu.vn/";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching chrome browser..");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.get(baseURL);
	}

	@Test
	public void verifyHomePageTitle() {
		String expectedTitle = "Learning Management System | Hệ thống quản trị học tập | FPT Polytechnic Việt Nam";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}
