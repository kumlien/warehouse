package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Users extends Controller {
	
	static final Form<User> productForm = Form.form(User.class);
	
	public static Result login() {
		Form<User> userForm = productForm.bindFromRequest();
		return ok("logging in..." + userForm.get());
	}
}
