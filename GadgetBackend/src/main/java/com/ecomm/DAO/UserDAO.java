package com.ecomm.DAO;

import com.ecomm.model.UserDetail;

public interface UserDAO 
{
	public boolean registerUser(UserDetail user);
	public boolean updateUser(UserDetail user);
	public UserDetail getUser(String username);
	public UserDetail getPassword(String password);
	public UserDetail getName(String customerName);
	public UserDetail getRole(String role);
	public UserDetail getAddress(String address);
}
