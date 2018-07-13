package com.onlinesShopingBackend.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlinesShopingBackend.D.SupplierDao;
import com.onlinesShopingBackend.model.Supplier;

public class SupplierDaoTest {

	private static AnnotationConfigApplicationContext context;
	private static SupplierDao supplierDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.onlinesShopingBackend");
		context.refresh();
		supplierDao = (SupplierDao) context.getBean("supplierDAO");
	}
	
	@Test
	public void testAddSupplier() {
		Supplier supplier= new Supplier();
		supplier.setSupplierName("abc");
		supplier.setSupplierAdd("lko");
		
		assertTrue("problem in adding Supplier", supplierDao.addSupplier(supplier));
	}
	@Ignore
	@Test
	public void testUpdateSupplier() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testDeleteSupplier() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testGetSupplier() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testListSupplier() {
		fail("Not yet implemented");
	}

}
