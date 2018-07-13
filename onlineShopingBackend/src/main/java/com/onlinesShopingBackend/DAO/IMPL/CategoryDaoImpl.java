package com.onlinesShopingBackend.DAO.IMPL;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinesShopingBackend.D.CategoryDao;
import com.onlinesShopingBackend.model.Category;

@Repository("categoryDao")
@Transactional

public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Category getcategory(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		Category category = (Category) session.get(Category.class, categoryId);
		return category;
	}

	@Override
	public List<Category> listcategories() {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Category");
			List<Category> listCategories = query.list();
			session.close();
			return listCategories;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
