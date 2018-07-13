package com.onlinesShopingBackend.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlinesShopingBackend.D.ProductDao;
import com.onlinesShopingBackend.model.Product;

public class ProductDaoTest {
	private static AnnotationConfigApplicationContext context;
	private static ProductDao productdao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.onlinesShopingBackend");
		context.refresh();
		productdao = (ProductDao) context.getBean("productDAO");
	}

	
	@Test
	public void testAddProduct() {
		Product product = new Product();
		product.setPrice(10000);
		product.setProdName("Mi Redme 4");
		product.setProdDesc("Mobile");
		product.setStock(20);
		product.setcategoryId(1001);
		product.setCategoryName("Mobile");
		product.setSupplierId(12345);
product.setSupplierName("mobile shop");
		assertTrue("Problem in adding the value", productdao.addProduct(product));

	}

	@Ignore
	@Test
	public void testUpdateProduct() {
		Product product = productdao.getProduct(43);
		product.setPrice(15000);

		assertTrue("Problem in adding product", productdao.updateProduct(product));
	}

	@Ignore
	@Test
	public void testDeleteProduct() {
		Product product = productdao.getProduct(44);
		assertTrue("Problem in deleting the product", productdao.deleteProduct(product));
	}

	@Ignore
	@Test
	public void testGetProduct() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testListProduct() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testListProductByCatagory() {
		fail("Not yet implemented");
	}

}
