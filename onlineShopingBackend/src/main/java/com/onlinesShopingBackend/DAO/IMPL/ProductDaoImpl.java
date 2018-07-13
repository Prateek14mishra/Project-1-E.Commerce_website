package com.onlinesShopingBackend.DAO.IMPL;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinesShopingBackend.D.ProductDao;
import com.onlinesShopingBackend.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Product getProduct(int prodId) {
		try {
			Session session=sessionFactory.getCurrentSession();
			Product product=(Product)session.get(Product.class,prodId);
			return product;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Product> listProduct() {
		try {
			Session session =sessionFactory.openSession();
			Query query = session.createQuery("from Product");
			List<Product> listProduct = query.list();
			session.close();
			return listProduct;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Product> listProductByCategory(int categoryId) {
		try {
			Session session =sessionFactory.openSession();
			Query query = session.createQuery("from Product where categoryId =:categoryId");
			query.setParameter("categoryId", categoryId);
			List<Product> listProduct = query.list();
			session.close();
			return listProduct;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
}
