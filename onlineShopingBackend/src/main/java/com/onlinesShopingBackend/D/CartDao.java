package com.onlinesShopingBackend.D;

import java.util.List;

import com.onlinesShopingBackend.model.Cart;

public interface CartDao {
	public boolean addCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public boolean updateCart(Cart cart);
	
	public List<Cart> listCart(); 

}
