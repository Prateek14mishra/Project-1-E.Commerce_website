package com.onlinesShopingBackend.DAO.IMPL;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinesShopingBackend.D.CartDao;
import com.onlinesShopingBackend.model.Cart;

@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Cart> listCart() {
		try {
			Session session =sessionFactory.openSession();
			Query query = session.createQuery("from Cart");
			List<Cart> listCart = query.list();
			session.close();
			return listCart;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
