package com.onlinesShopingBackend.DAO.IMPL;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinesShopingBackend.D.SupplierDao;
import com.onlinesShopingBackend.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Supplier getSupplier(int supplierId) {
		try {
			Session session=sessionFactory.getCurrentSession();
			Supplier supplier=(Supplier)session.get(Supplier.class,supplierId);
			return supplier;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Supplier> listSupplier() {
		try {
			Session session =sessionFactory.openSession();
			Query query = session.createQuery("from Supplier");
			List<Supplier> listSupplier = query.list();
			session.close();
			return listSupplier;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
