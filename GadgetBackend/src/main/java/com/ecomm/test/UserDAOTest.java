package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.DAO.UserDAO;

import com.ecomm.model.UserDetail;

public class UserDAOTest 
{
	static UserDAO userDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	@Test
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
		user.setCustomerName("Aarav");
		user.setAddress("Kolkata");
		user.setEnable(false);
		user.setPassword("789");
		user.setRole("xyzde");
		user.setUsername("cutomer3");
		assertTrue("Problem in registering the user",userDAO.registerUser(user));
	}
	@Ignore
	@Test
	public void updateUserTest()
	{
		UserDetail user=new UserDetail();
		user.setRole("ab");
		user.setAddress("Kochi");
		assertTrue("Problem in updating user",userDAO.updateUser(user));
	}
	

}
