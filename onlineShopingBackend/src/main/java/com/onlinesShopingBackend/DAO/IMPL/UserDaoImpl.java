package com.onlinesShopingBackend.DAO.IMPL;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinesShopingBackend.D.Userdao;
import com.onlinesShopingBackend.model.User;

@Repository("userdao")
@Transactional

public class UserDaoImpl implements Userdao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user)
	{
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getUser(int userID) {
		try {
			Session session=sessionFactory.getCurrentSession();
			User user=(User)session.get(User.class,userID);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<User> listUsers() {
		try {
			Session session =sessionFactory.openSession();
			Query query = session.createQuery("from User");
			List<User> listUser = query.list();
			session.close();
			return listUser;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
