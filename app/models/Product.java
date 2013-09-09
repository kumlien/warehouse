package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	public Long ean;
	public String name;
	public String description;
	
	public Product(){}
	
	public Product(Long ean, String name, String description) {
		this.ean = ean;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [ean=" + ean + ", name=" + name + ", description="
				+ description + "]";
	}
	
	
	
}
