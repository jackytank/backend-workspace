package Bai2;

import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PersonTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testExpectedException() {
		exception.expect(IllegalArgumentException.class);
		new Person("Superman", -2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExpectedException2() {
		new Person("Superman", -2);
	}

	@Test
	public void testExpectedException3() {
		try {
			new Person("Superman", -2);

			fail("Should have thrown an IllegalArgumentException because age is invalid!!");
		} catch (IllegalArgumentException e) {

		}
	}
}
