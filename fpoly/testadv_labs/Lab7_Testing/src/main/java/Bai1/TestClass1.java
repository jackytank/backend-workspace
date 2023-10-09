package Bai1;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClass1 {
	@Test(groups = "myGroup")
	public void t1() {
		assertTrue(false);
	}

	@Test(groups = "myGroup")
	public void t2() {
		assertTrue(false);
	}

	@Test(groups = "myGroup")
	public void t3() {
	}

	@Test
	public void t4() {
	}

	@Test(dataProvider = "dp")
	public void t5(String param) {
		assertTrue(false);
	}

	@DataProvider
	private Object[][] dp() {
		return new Object[][] { { "one" }, { "two" } };
	}
}
