package Bai2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SuiteTest1 {
	public String message = "FPOLY";

	JUnitMessage jUnitMessage = new JUnitMessage(message);

	@Test(expected = ArithmeticException.class)
	public void testJUnitMessage() {
		System.out.println("JUnitMessage is printing...");
		jUnitMessage.printMessage();
	}

	@Test
	public void testJUnitHiMessage() {
		message = "Hi! " + message;

		System.out.println("JUnitMessage is printing...");
		assertEquals(message, jUnitMessage.printHiMessage());
		System.out.println("Suite Test 1 is successful!");
	}
}
