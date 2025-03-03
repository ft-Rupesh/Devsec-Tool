package com.rupesh.doa;

public interface ILoginDAO {
public int authenticate(String username,String password);
public String addUser(String username, String role);
}
