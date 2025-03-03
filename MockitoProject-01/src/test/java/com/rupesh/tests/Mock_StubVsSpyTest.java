package com.rupesh.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Mock_StubVsSpyTest 
{
	@Test
	public void testList() {
	List<String> listMock =Mockito.mock(ArrayList.class);//Mock
	List<String> listSpy =Mockito.spy(ArrayList.class);//Spy(or)
	listMock.add("table");
	Mockito.when(listMock.size()).thenReturn(10);//stub on Mock object
	
	listSpy.add("table");
	Mockito.when(listSpy.size()).thenReturn(10);
	//Test the size method
	System.out.println(listMock.size()+" "+listSpy.size());
	}
}
