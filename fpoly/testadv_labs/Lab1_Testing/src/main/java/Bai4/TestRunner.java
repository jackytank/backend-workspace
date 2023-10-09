package main.java.Bai4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRunner {
	@Test
	public void checkPtBac1VN() {
		assertEquals("vn", new App().ptBac1(0, 3));
	}

	@Test
	public void checkPtBac1VSN() {
		assertEquals("vsn", new App().ptBac1(0, 0));
	}

	@Test
	public void checkPtBac1CN() {
		assertEquals("-2", new App().ptBac1(2, 4));
	}
}
