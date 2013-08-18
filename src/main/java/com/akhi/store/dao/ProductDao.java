package com.akhi.store.dao;

import java.util.List;

import com.akhi.store.general.Products;

public interface ProductDao extends GenericDAO<Products,Long> {

	List<Products> getProducts(int offset,int max);
}
