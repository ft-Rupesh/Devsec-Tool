package com.rupesh.service;

import com.rupesh.doa.ILoginDAO;

public class LoginMgmtServiceImpl implements ILoginMgmtService
{
private ILoginDAO dao;
public LoginMgmtServiceImpl(ILoginDAO dao) {
	this.dao=dao;
}
	@Override
	public boolean login(String user, String pwd) {
		if(user.equalsIgnoreCase("")|| pwd.equalsIgnoreCase(""))
			throw new IllegalArgumentException("Invalid inputs");
		//use DAO
		int count=dao.authenticate(user, pwd);
		
			
		return false;
		
	}

	@Override
	public String registerUser(String user, String role) {
		if(!user.equals("") && !role.equals("")) {
			//user DAO
			dao.addUser(user, role);
			return "user added";
		}
		else
		return "user not added";
	}

}
