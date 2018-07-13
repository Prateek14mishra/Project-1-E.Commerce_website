package com.onlinesShopingBackend.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlinesShopingBackend.D.Userdao;
import com.onlinesShopingBackend.model.User;

public class userdaotest {
	private static AnnotationConfigApplicationContext context;
	private static Userdao userdao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.onlinesShopingBackend");
		context.refresh();
		userdao = (Userdao) context.getBean("userdao");
	}

	@Ignore
	@Test
	public void testAddUser() {
		User user =new User();
		user.setAddress("lko");
		user.setEmail("abshek@abc.acb");
		user.setName("kashu");
		user.setPassword("qwertyui");
		user.setPh_no("1234567890");
		
		assertTrue("Problem in adding the user", userdao.addUser(user));
	}

	@Ignore
	@Test
	public void testUpdateUser() {
		User user =new User();
		user.setAddress("lko");
		user.setEmail("abc@abc.acb");
		user.setName("abcc");
		user.setPassword("qwertyui");
		user.setPh_no("1234567890");
		
		assertTrue("Problem in adding the user", userdao.updateUser(user));
	
	}

	
	@Test
	public void testDeleteUser() {
		User user =new User();
		user.setAddress("lko");
		user.setEmail("abc@abc.acb");
		user.setName("abcc");
		user.setPassword("qwertyui");
		user.setPh_no("1234567890");
		
		assertTrue("Problem in adding the user", userdao.deleteUser(user));
	
	}

	@Ignore
	@Test
	public void testGetUser() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testListUsers() {
		fail("Not yet implemented");
	}

}
