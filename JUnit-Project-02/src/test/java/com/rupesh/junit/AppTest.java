package com.rupesh.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/*
	 * Here service class object created only one time.when you use this annotations
	 */
	private static App a;
	@BeforeAll
	public static void setupOnce() {
		a=new App();
	}
	/*@BeforeEach
	public  void setup() {
		System.out.println("AppTest.setup()");
	}*/
	@Test
	public void testSumWithPositives() {
		System.out.println("AppTest.testSumWithPositives()");
		int x=100;
		int y=200;
		int expected =300;
		//App a = new App();
		float actual = a.sum(x,y);
		assertEquals(expected,actual);
	}
	public void testSumWithNegetives() {
		System.out.println("AppTest.testSumWithNegetives()");
		int x=100;
		int y=200;
		int expected =100;
		//App a=new App();
		float actual=a.sum(x, y);
		assertEquals(expected,actual);
	}
	@Test
	@Disabled//Ignore in on  temprere based.or skipped
	public void testSumWithZeroValues() {
		System.out.println("AppTest.testSumWithZeroValues()");
		int x=-100;
		int y=-00;
		int expected =-300;
		App a = new App();
		float actual =a.sum(x, y);
		assertEquals(expected,actual);
	}
	@Test
	public void testSumWithBigValue() {
		System.out.println("AppTest.testSumWithBigValue()");
		long x=100000000L;
		long y=200000000L;
		long expected =300000000L;
		//App a= new App();
		float actual =a.sum(x, y);
		assertEquals(expected,actual);
	}
	/*@AfterEach
	public static void tearDown() {
		System.out.println("AppTest.tearDown()");
	}*/
	@Test
	public void testSumWithFloatValues() {
		System.out.println("AppTest.testSumWithFloatValues()");
		float x=10.7878f;
		float y=23.567f;
		float expected=34.348f;
		//App a= new App();
		float actual=a.sum(x,y);
		assertEquals(expected,actual,0.5);
	}
	@AfterAll
	public  void tearDownOnce() {
		System.out.println("AppTest.tearDown()");
		a=null;
	}
}
