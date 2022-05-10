package Bai3;

import org.testng.annotations.Test;

public class groupExamples {
	@Test(groups = "Regression")
	public void testCaseOne() {
		System.out.println("I'm in test case 1 and in Regression group");
	}

	@Test(groups = "Regression")
	public void testCaseTwo() {
		System.out.println("I'm in test case 2 and in Regression group");
	}

	@Test(groups = "Regression")
	public void testCaseThree() {
		System.out.println("I'm in test case 3 and in Regression group");
	}

	@Test(groups = "Regression")
	public void testCaseFour() {
		System.out.println("I'm in test case 4 and in Regression group");
	}
}
