package com.onlinesShopingBackend.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlinesShopingBackend.D.CategoryDao;
import com.onlinesShopingBackend.model.Category;
@SuppressWarnings("unused")
public class CategoryDaoTest {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDao categoryDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.onlinesShopingBackend");
		context.refresh();
		categoryDao = (CategoryDao) context.getBean("categoryDao");
	}
	@Ignore
	@Test
	public void testAddCategory() {
		Category category = new Category();
		category.setcategoryName("MObile");
		category.setcategoryDesc("price range starting from 10000");

		assertTrue("Problem adding the categort", categoryDao.addCategory(category));
	}

	@Ignore
	@Test
	public void testDeleteCategory() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testUpdateCategory() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetcategory() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testListcategories() {
		List<Category> listCategories = categoryDao.listcategories();
		assertTrue("problem in printing list", categoryDao.listcategories().size()>0);

	
	}

}
