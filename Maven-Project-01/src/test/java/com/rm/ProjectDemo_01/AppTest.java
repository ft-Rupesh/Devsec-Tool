package com.rm.ProjectDemo_01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
	@Test
	public void testSumWithPositivies() {
		int val1=20;
		int val2=10;
		int expected =30;
		App  app = new App();
		int actual=app.sum(val1,val2);
		assertEquals(expected,actual);
	}
	@Test
	public void testSumWithNegetives() {
		int val1=-20;
		int val2=-10;
		int expected =-31;
		App  app = new App();
		int actual=app.sum(val1,val2);
		assertEquals(expected,actual);
	}
	@Test
	public void testSumWithZeros() {
		int val1=0;
		int val2=0;
		int expected =0;
		App  app = new App();
		int actual=app.sum(val1,val2);
		assertEquals(expected,actual);
	}
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
