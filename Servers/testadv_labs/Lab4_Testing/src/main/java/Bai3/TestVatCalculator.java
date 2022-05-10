package Bai3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.Test;

public class TestVatCalculator {
	@Test
	public void testGetVatOnAmount() {
		VatCalculator vatCalculator = new VatCalculator();
		double expected = 10;
		assertEquals(vatCalculator.getVatOnAmount(100), expected);
		assertNotEquals(vatCalculator.getVatOnAmount(120), expected);
	}
}
