package Bai2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass {
	@BeforeTest
	public void beforeTest() {
		System.out.println("TestClass: before method");
	}

	@Test
	public void unitLevel1() {
		System.out.println("TestClass: Unit Level1 testing");
	}

	@Test
	public void unitLevel2() {
		System.out.println("TestClass: Unit Level2 testing");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("TestClass: before method");
	}

	@BeforeMethod
	public static void staticBeforeMethod() {
		System.out.println("TestClass: static before method");
	}

	@Parameters({ "param" })
	@BeforeMethod
	public void beforeMethodWithParam(String p) {
		System.out.println("TestClass: before method with param " + p);
	}

	@AfterMethod
	public void afterNethod() {
		System.out.println("TestClass: after method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("TestClass: before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("TestClass: after class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("TestClass: after test");
	}

}
