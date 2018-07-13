package com.onlineShoping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinesShopingBackend.D.CategoryDao;
import com.onlinesShopingBackend.model.Category;

@Controller
public class CategoryController {
	@Autowired
	CategoryDao categoryDao;
	Boolean flag = false;

	@RequestMapping(value = "/category")
	public String showCategoryPage(Model model) {
		flag = false;
		List<Category> listcategory = categoryDao.listcategories();
		model.addAttribute("categorylist", listcategory);
		model.addAttribute("flag", flag);
		return "Category";
	}

	@RequestMapping(value = "/InsertCategory", method = RequestMethod.POST)
	public String insertCategory(@RequestParam("catName") String categoryName,
			@RequestParam("catDesc") String categoryDesc, Model model) {

		flag = false;
		Category category = new Category();
		category.setcategoryName(categoryName);
		category.setcategoryDesc(categoryDesc);

		categoryDao.addCategory(category);

		List<Category> listCategories = categoryDao.listcategories();
		model.addAttribute("categorylist", listCategories);
		model.addAttribute("flag", flag);
		return "Category";
	}

	@RequestMapping(value = "/deleteCategory/{categoryID}")

	public String deleteCategory(@PathVariable("categoryID") int categoryId, Model model) {

		flag = false;
		Category category = categoryDao.getcategory(categoryId);

		categoryDao.deleteCategory(category);

		List<Category> listCategories = categoryDao.listcategories();

		model.addAttribute("categorylist", listCategories);
		model.addAttribute("flag", flag);
		return "Category";
	}

	@RequestMapping(value = "/editCategory/{categoryID}")
	public String editCategory(@PathVariable("categoryID") int categoryId, Model model) {
		Category category = categoryDao.getcategory(categoryId);
		model.addAttribute("categoryData", category);
		model.addAttribute("flag", "true");
		return "Category";
	}

	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
	public String updateCategory(@RequestParam("catId") int categoryId, @RequestParam("catName") String categoryName,
			@RequestParam("catDesc") String categoryDesc, Model model) {

		flag = false;
		Category category = categoryDao.getcategory(categoryId);
		category.setcategoryName(categoryName);

		category.setcategoryDesc(categoryDesc);

		categoryDao.updateCategory(category);

		List<Category> listCategories = categoryDao.listcategories();

		model.addAttribute("categorylist", listCategories);
		model.addAttribute("flag", flag);
		return "Category";
	}
}
