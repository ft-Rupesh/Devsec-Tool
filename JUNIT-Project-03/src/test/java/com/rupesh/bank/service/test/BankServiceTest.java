package com.rupesh.bank.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.rupesh.bank.service.BankService; 

/*Question:- What is call back method ?
 * Answer :- The method that will be called automatically by underlaying server or container or JRE or framework is called call back method in your phone also there is a feature called call back featire right yes no so though you miss the call the moment you open the option it will give call back option guys.  
 * 
 * Usercase fo @BeforeAll and @AftreAll methods
 * @BeforeAll --->To initialize Service class object requried in the @Test methods
 * @AfterAll--->To nullify Service class object reference used in all the @Test methods
 * 
 * @BeforeEach---> To get new jdbc con object from the jdbc con pool required in @Test method execution
 * 
 * @AfterEach --> To return/close jdbc con object back to jdbc con pool that is used in @Test method
 */
@DisplayName("Test case class BankServiceTest")
public class BankServiceTest {

    private static BankService service=null;
    @BeforeAll
    public static void setupOnce() {
    	service =new BankService();
    }
    @BeforeEach
    public void setup() {
    	System.out.println("BankServiceTest.setup()");
    }
    @Test
    @DisplayName("Testing Simple Intrest Amount With High Values")
   @Tag("dev")
    public void testCalcSimpleIntrestWithHighValues() {
    	double expected=2400000.0;
    	double actual = service.calcSimpleIntrest(10000000.0, 12,2);
    	assertEquals(expected,actual);
    }
    @Test
    @DisplayName("testing Simple Intrest Amount With Low Values")
    @Tag("dev")
    public void testCalcSimpleIntrestWithLowValues() {
    	double expected =24000.0;
    	double actual=service.calcSimpleIntrest(100000.0, 12,2);
    	assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Testing Simple Intrest Amount With Wrong Values")
    @Tag("test")
    public void testCalcSimpleIntrestWithWrongValues() {
    	assertThrows( IllegalArgumentException.class, ()->{service.calcSimpleIntrest(0.0,120,2.0);});
    }
    @AfterEach
    public void teardown() {
    	System.out.println("BankServiceTest.setup()");
    }
    @AfterAll
    public static void tearDownOnce() {
    	service= null;
    }
}
