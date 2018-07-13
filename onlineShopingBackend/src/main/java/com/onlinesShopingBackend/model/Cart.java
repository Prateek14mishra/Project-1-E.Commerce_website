package com.onlinesShopingBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Cart")
public class Cart {

	@Id
	@GeneratedValue
	private int cartId;
	
	private int userId;
	private int cartLine;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCartLine() {
		return cartLine;
	}
	public void setCartLine(int cartLine) {
		this.cartLine = cartLine;
	}
	
}
