package db;

import java.util.List;

import models.Product;

public interface ProductRepo {
	
	List<Product> findAll();
	
	Product findById(Long ean);

	void saveOrUpdate(Product product);
}
