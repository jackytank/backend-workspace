package Bai1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArithemicTest {
	public String message = "FPOLY Exception!";

	JunitMessage junitMessage = new JunitMessage(message);

	@Test(expected = ArithmeticException.class)
	public void testJunitMessage() {
		System.out.println("JUnitMessage is printing!!");
		junitMessage.printMessage();
	}

	@Test
	public void testJUnitMessage() {
		message = "Hi!" + message;
		System.out.println("JUnitHiMessage is printing!!");
		assertEquals(message, junitMessage.printHiMessage());
	}
}
