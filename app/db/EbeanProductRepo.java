package db;

import java.util.List;

import models.Product;

import com.avaje.ebean.Ebean;

public class EbeanProductRepo implements ProductRepo {

	@Override
	public List<Product> findAll() {
		return Ebean.find(Product.class).findList();
	}

	@Override
	public Product findById(Long ean) {
		return Ebean.find(Product.class, ean);
	}

	@Override
	public void save(Product product) {
		Ebean.save(product);
	}

}
