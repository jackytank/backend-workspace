package Bai1_fpoly;

import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SaveTestNGResultToExcel {
	public WebDriver driver;
	public UIMap uiMap;
	public UIMap datafile;
	public String workingDir;

	HSSFWorkbook workbook;

	HSSFSheet sheet;

	Map<String, Object[]> TestNGResults;

	public void LaunchWebsite() throws Exception {
		try {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
			driver.get("https://phptravels.org/login");
			driver.manage().window().maximize();

			TestNGResults.put("2", new Object[] { 1d, "Navigate to demo website", "Site gets opened", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("2", new Object[] { 1d, "Navigate to demo website", "Site gets opened", "Fail" });
			assertTrue(false);
		}
	}

	@Test(description = "Fill the login details", priority = 2)
	public void FillLoginDetails() throws Exception {
		try {
			WebElement username = driver.findElement(uiMap.getLocator("Username_field"));
			username.sendKeys(datafile.getData("username"));

			WebElement password = driver.findElement(uiMap.getLocator("Password_field"));
			username.sendKeys(datafile.getData("password"));

			Thread.sleep(1000);

			TestNGResults.put("3",
					new Object[] { 2d, "Fill Login form data(Username/Password)", "Login form get filled!", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("3",
					new Object[] { 2d, "Fill Login form data(Username/Password)", "Login form get filled!", "Fail" });
			assertTrue(false);
		}
	}

	@Test(description = "Perform login", priority = 3)
	public void DoLogin() throws Exception {
		try {
			WebElement login = driver.findElement(uiMap.getLocator("Login_button"));
			login.click();

			Thread.sleep(1000);

			WebElement onlineuser = driver.findElement(uiMap.getLocator("online_user"));

			TestNGResults.put("4",
					new Object[] { 3d, "Click login and verify welcome message", "Login success", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("4",
					new Object[] { 3d, "Click login and verify welcome message", "Login success", "Fail" });
			assertTrue(false);
		}
	}

	@BeforeClass(alwaysRun = true)
	public void suiteSetUp() {
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet("TestNG Result Summary");
		TestNGResults = new LinkedHashMap<String, Object[]>();

		TestNGResults.put("1", new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output" });

		try {
			workingDir = System.getProperty("user.dir");
			datafile = new UIMap(workingDir + "\\Resources\\datafile.properties");

			uiMap = new UIMap(workingDir + "\\Resources\\locator.properties");

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new IllegalStateException("Can't start the chrome web driver", e);
		}
	}

}
