package main.java.Bai3;

import org.junit.Test;

import junit.framework.TestCase;

public class AppTest extends TestCase {
	public AppTest(String testName) {
		super(testName);
	}

	public void testApp() {
		assertTrue(true);
	}

	@Test
	public void isEvenNumber2() {
		App app = new App();
		boolean result = app.isEvenNumber(2);
		assertTrue(result);
	}

	@Test
	public void isEvenNumber4() {
		App app = new App();
		boolean result = app.isEvenNumber(3);
		assertTrue(result);
	}
}
