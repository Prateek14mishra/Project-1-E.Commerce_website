package com.onlineShoping.Controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlinesShopingBackend.D.CategoryDao;
import com.onlinesShopingBackend.D.ProductDao;
import com.onlinesShopingBackend.D.SupplierDao;
import com.onlinesShopingBackend.model.Category;
import com.onlinesShopingBackend.model.Product;
import com.onlinesShopingBackend.model.Supplier;

@Controller
public class ProductController {

	@Autowired
	ProductDao productDao;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	SupplierDao supplierDao;

	@RequestMapping("/product")
	public String showProduct(Model model) {
		Product product = new Product();
		model.addAttribute(product);
		model.addAttribute("listcategory", this.getCategories());
		model.addAttribute("listSupplier", this.getSuppliers());
		model.addAttribute("productList", productDao.listProduct());
		return "Product";
	}

	@RequestMapping(value = "/productInsert", method = RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product") Product product,Model model) {
		productDao.addProduct(product);
		model.addAttribute("listcategory", this.getCategories());
		model.addAttribute("listSupplier", this.getSuppliers());
		model.addAttribute("productList", productDao.listProduct());
		return "Product";
	}

	public LinkedHashMap<Integer, String> getCategories() {
		List<Category> listcategory = categoryDao.listcategories();
		
		LinkedHashMap<Integer, String> categoryData = new LinkedHashMap<Integer, String>();

		for (Category category : listcategory) {
			categoryData.put(category.getcategoryId(), category.getcategoryName());
		}
		return categoryData;
	}
	
	public LinkedHashMap<Integer, String> getSuppliers() {
		List<Supplier> listSupplier = supplierDao.listSupplier();
		
		LinkedHashMap<Integer, String> supplierData = new LinkedHashMap<Integer, String>();
		
		for (Supplier supplier : listSupplier) {
			supplierData.put(supplier.getSupplierId(), supplier.getSupplierName());
		}
		return supplierData;
	}

	@RequestMapping(value = "/displayProduct")
	public String showAllProducts(Model model) {
		model.addAttribute("productList", productDao.listProduct());
		model.addAttribute("listcategory", this.getCategories());
		return "Product";
	}

	
}
