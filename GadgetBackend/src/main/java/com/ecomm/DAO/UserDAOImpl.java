package com.ecomm.DAO;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.UserDetail;
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean registerUser(UserDetail user) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean updateUser(UserDetail user) 
	{	
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public UserDetail getUser(String username) {
		Session session=sessionFactory.openSession();
		UserDetail userDetail=session.get(UserDetail.class, username);
		session.close();
		return userDetail;
	}

	@Override
	public UserDetail getPassword(String password) {
		Session session=sessionFactory.openSession();
		UserDetail userDetail=session.get(UserDetail.class, password);
		session.close();
		return userDetail;
		
	}

	@Override
	public UserDetail getName(String customerName) {
		Session session=sessionFactory.openSession();
		UserDetail userDetail=session.get(UserDetail.class, customerName);
		session.close();
		return userDetail;
	}

	@Override
	public UserDetail getRole(String role) {
		Session session=sessionFactory.openSession();
		UserDetail userDetail=session.get(UserDetail.class, role);
		session.close();
		return userDetail;
	}

	@Override
	public UserDetail getAddress(String address) {
		Session session=sessionFactory.openSession();
		UserDetail userDetail=session.get(UserDetail.class, address);
		session.close();
		return userDetail;
	}

}
