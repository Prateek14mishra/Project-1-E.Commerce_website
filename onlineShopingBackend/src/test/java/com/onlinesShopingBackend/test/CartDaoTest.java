package com.onlinesShopingBackend.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlinesShopingBackend.D.CartDao;
import com.onlinesShopingBackend.model.Cart;

@SuppressWarnings("unused")
public class CartDaoTest {
	private static AnnotationConfigApplicationContext context;
	private static CartDao cartDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.onlinesShopingBackend");
		context.refresh();
		cartDao = (CartDao) context.getBean("cartDao");

	}


	@Test
	public void testAddCart() {
		Cart cart=new Cart();
		cart.setUserId(101);
		
		
	//	assertTrue("Problem in adding the cart", cartDao.);;
	}
@Ignore
	@Test
	public void testDeleteCart() {
		fail("Not yet implemented");
	}
@Ignore
	@Test
	public void testUpdateCart() {
		fail("Not yet implemented");
	}
@Ignore
	@Test
	public void testListCart() {
		fail("Not yet implemented");
	}

}
