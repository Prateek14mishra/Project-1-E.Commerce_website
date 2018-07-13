package com.onlinesShopingBackend.D;

import java.util.List;

import com.onlinesShopingBackend.model.Supplier;

public interface SupplierDao {
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public Supplier getSupplier(int supplierId);
	public List<Supplier> listSupplier ();
}
