package com.rupesh.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.rupesh.doa.ILoginDAO;
import com.rupesh.service.ILoginMgmtService;
import com.rupesh.service.LoginMgmtServiceImpl;

public class LoginTestsWithMockito{
private static ILoginDAO loginDAO;
private static ILoginMgmtService loginService;
	//Mock the LoginDAO
	@BeforeAll
	public static void setUP() {
	loginDAO=Mockito.mock(ILoginDAO.class);
	System.out.println("Mock object class name::"+loginDAO.getClass());
	//create Service class object
	loginService=new LoginMgmtServiceImpl(loginDAO);
	}
	
	@Test
	public void testLoginWithValidCredentials() {
		//provide some funcationality for autheticate method on the mock DAO object (Stub Object)
		Mockito.when(loginDAO.authenticate("raja", "rani1")).thenReturn(0);
		//perform testing
		assertFalse(loginService.login("raja","rani1"));
	}
	@Test
	public void testLoginWithNoCrendentials() {
		assertThrows(IllegalArgumentException.class,()->loginService.login("", "") );
	}
	@Test
	public void testRegisterUserWithSpy() {
		//create Spy Object
		ILoginDAO loginDAOSpy=Mockito.spy(ILoginDAO.class);
		//create Service class object
		loginService = new LoginMgmtServiceImpl(loginDAOSpy);
	//invoke the methods
		loginService.registerUser("raja","admin");
		loginService.registerUser("suresh","customer");
		loginService.registerUser("jani", "");
		
		//Check weather addUser(-,-) is called expected no of time or not
		Mockito.verify(loginDAOSpy,Mockito.times(1)).addUser("raja","admin");
		Mockito.verify(loginDAOSpy,Mockito.times(1)).addUser("suresh","customer");
		//Mockito verify(loginDAOSpy,Mockito.never()).addUser("jani","");
		Mockito.verify(loginDAOSpy,Mockito.times(0)).addUser("jani","");
	}
	@AfterAll
	public static void clearDown() {
		loginDAO=null;
		loginService=null;
	}
}
