package com.akhi.store.dao;

import java.util.List;
import java.util.Map;

import com.akhi.store.general.Products;

public interface ProductDao extends GenericDAO<Products,Long> {

	List<Products> getProducts(int offset,int max);
	
	Products getById(String id);
	
	List<Products> getByCat(String cat,int offset, int max);
	
	Map<String,String> getCats();
}
