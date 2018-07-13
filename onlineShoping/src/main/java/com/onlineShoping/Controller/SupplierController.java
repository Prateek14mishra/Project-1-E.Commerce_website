package com.onlineShoping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinesShopingBackend.D.SupplierDao;
import com.onlinesShopingBackend.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	SupplierDao supplierDao;
	Boolean flag = false;

	@RequestMapping(value = "/supplier")
	public String showSupplperPage(Model model) {
		flag = false;
		List<Supplier> listSupplier = supplierDao.listSupplier();
		model.addAttribute("supplierlist", listSupplier);
		model.addAttribute("flag", flag);
		return "Supplier";
	}

	@RequestMapping(value = "/InsertSupplier", method = RequestMethod.POST)
	public String insertSupplier(@RequestParam("supplierName") String supplierName,
			@RequestParam("supplierAdd") String supplierAdd, Model model) {

		flag = false;
		Supplier supplier = new Supplier();

		supplier.setSupplierName(supplierName);

		supplier.setSupplierAdd(supplierAdd);

		supplierDao.addSupplier(supplier);

		List<Supplier> listSupplier = supplierDao.listSupplier();
		model.addAttribute("supplierlist", listSupplier);
		model.addAttribute("flag", flag);
		return "Supplier";
	}

	@RequestMapping(value = "/deleteSupplier/{SupplierID}")
	public String deleteSupplier(@PathVariable("SupplierID") int supplierId, Model model) {

		flag = false;
		Supplier supplier = supplierDao.getSupplier(supplierId);

		supplierDao.deleteSupplier(supplier);

		List<Supplier> listSupplier = supplierDao.listSupplier();
		model.addAttribute("supplierlist", listSupplier);
		model.addAttribute("flag", flag);
		return "Supplier";
	}

	@RequestMapping(value = "/editSupplier/{SupplierID}")
	public String editSupplier(@PathVariable("SupplierID") int supplierId, Model model) {
		Supplier supplier = supplierDao.getSupplier(supplierId);

		model.addAttribute("supplierData", supplier);
		model.addAttribute("flag", "true");
		return "Supplier";
	}

	@RequestMapping(value = "/updateSupplier", method = RequestMethod.POST)
	public String updateSupplier(@RequestParam("supplierId") int supplierId,
			@RequestParam("supplierName") String supplierName, @RequestParam("supplierAdd") String supplierAdd,
			Model model) {

		flag = false;
		Supplier supplier = supplierDao.getSupplier(supplierId);

		supplier.setSupplierName(supplierName);
		supplier.setSupplierAdd(supplierAdd);
		supplierDao.updateSupplier(supplier);

		List<Supplier> listSupplier = supplierDao.listSupplier();
		model.addAttribute("supplierlist", listSupplier);
		model.addAttribute("flag", flag);
		return "Supplier";
	}

}
