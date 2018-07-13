package com.onlinesShopingBackend.D;

import java.util.List;

import com.onlinesShopingBackend.model.Product;

public interface ProductDao {

	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	
	public Product getProduct(int prodId);
	public List<Product> listProduct ();
	public List<Product> listProductByCategory(int categoryId);
}
