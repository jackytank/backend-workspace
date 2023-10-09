package main.java.Bai2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJUnit {

	@Test
	public void testSetup() {
		String string = "I have finish JUnit setup!!";
		assertEquals("I have finish JUnit setup!!", string);
	}
}
