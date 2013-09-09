package controllers;

import java.text.Format;

import models.Product;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.productdetail;
import views.html.productlist;
import db.EbeanProductRepo;
import db.ProductRepo;

public class Products extends Controller {
	
	static ProductRepo repo = new EbeanProductRepo();
	
	static final Form<Product> productForm = Form.form(Product.class);
	
	static {
		//new DummyProducLoader();
	}
	
	public static Result list() {
		return ok(productlist.render(repo.findAll()));
	}
	
	public static Result getProduct(Long id) {
		Product p = repo.findById(id);
		System.out.println("prod with id " + id + ": " + p);
		if(p==null) {
			return notFound("No product in db with id " + id);
		}
		return ok(productdetail.render(productForm.fill(p)));
	}
	
	public static Result create() {
		return ok(productdetail.render(productForm));
	}
	
	public static Result save() {
		Form<Product> form = productForm.bindFromRequest();
		if(!form.hasErrors()) {
			repo.save(form.get());
			return redirect(routes.Products.list());
		} else {
			flash("Error", "errors..." + form.errorsAsJson());
			return badRequest(productdetail.render(form));
		}
	}

}
