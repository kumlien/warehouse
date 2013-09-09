package util;

import com.avaje.ebean.Ebean;

import models.Product;

public class DummyProducLoader {
	
	static {
		Product p1 = new Product(1l,"Product 1", "A description");
		Ebean.save(p1);
		
		Product p2 = new Product(2l,"Product 2", "A description");
		Ebean.save(p2);
		
		Product p3 = new Product(3l,"Product 3", "A description");
		Ebean.save(p3);
		
		Product p4 = new Product(4l,"Product 4", "A description");
		Ebean.save(p4);
		
	}
}
