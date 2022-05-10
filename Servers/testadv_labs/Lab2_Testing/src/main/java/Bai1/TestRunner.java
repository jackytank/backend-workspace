package Bai1;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {
	public static void main(String[] args) throws Exception {
		JUnitCore runner = new JUnitCore();
		Result result = runner.run(MathFuncTest.class);
		System.out.println("Run Tests: " + result.getRunCount());
		System.out.println("Failed Tests: " + result.getFailureCount());
		System.out.println("Ignore Tests: " + result.getIgnoreCount());
		System.out.println("Success: " + result.wasSuccessful());
	}
}
