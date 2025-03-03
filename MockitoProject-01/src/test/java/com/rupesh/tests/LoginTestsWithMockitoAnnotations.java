package com.rupesh.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rupesh.doa.ILoginDAO;
import com.rupesh.service.ILoginMgmtService;
import com.rupesh.service.LoginMgmtServiceImpl;

public class LoginTestsWithMockitoAnnotations {
@InjectMocks//)creates the Service class Object)
private static LoginMgmtServiceImpl loginService;

@Mock//creates the MockDAO class Object
private static ILoginDAO logindao;
public  LoginTestsWithMockitoAnnotations()
{
MockitoAnnotations.openMocks(this);
}
@Test
public void testLoginWithValidCredentials() {
	//provide some funcationality for autheticate method on the mock DAO object(Stub object)
	Mockito.when(logindao.authenticate("raja","rani1")).thenReturn(0);
	//perfrom testing
	assertFalse(loginService.login("raja","rani1"));
}
@Test
public void testLoginWithNoCrendentials() {
	assertThrows(IllegalArgumentException.class,()->loginService.login("",""));
}
@Test
public void testRegisterUserWithSpy() {
	//create Spy Object
	ILoginDAO loginDAOSpy=Mockito.spy(ILoginDAO.class);
	//create Service class object
	ILoginMgmtService loginSerivce=new LoginMgmtServiceImpl(loginDAOSpy);
	//invoke the methods
	loginService.registerUser("raja", "admin");
	loginService.registerUser("suresh", "customer");
	//Mockito verfie (LoginDAO,Spy,Mockito
	Mockito.verify(loginDAOSpy,Mockito.times(0)).addUser("jani","");
}
}
