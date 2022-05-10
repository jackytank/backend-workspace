package Bai1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fpoly {
	@Test
	public void verifyHomepageTitle() {
		WebDriver driver = null;
		try {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);

			String url = "https://lms.poly.edu.vn/";

			String title_website = "Learning Management System | Hệ thống quản trị học tập | FPT Polytechnic Việt Nam";
			String title_expected = "";

			driver.get(url);

			title_expected = driver.getTitle();
			if (title_expected.contentEquals(title_website)) {
				System.out.println("Test Pass!");
			} else {
				System.out.println("Test Failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}

	}
}
