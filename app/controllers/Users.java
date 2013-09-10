package controllers;


import javax.validation.Valid;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Users extends Controller {
	
	static final Form<User> productForm = Form.form(User.class);
	
	/**
	 * Called from template via ajax, return as json
	 */
	public static Result login() throws InterruptedException {
		Form<User> userForm = productForm.bindFromRequest();
		System.out.println(userForm.get());
		String response = User.authenticate(userForm.get().username, userForm.get().password);
		if(response != null) {
			return badRequest();
		} else 
		session().clear();
		session("username", userForm.get().username);
		return redirect(routes.Application.index());
	}
	
	public static Result renderRegisterPage() {
		return ok(views.html.register.render());
	}
	
	public static Result register() {
		Form<User> userForm = productForm.bindFromRequest();
		User newUser = userForm.get();
		User.save(newUser);
		
		return ok();
	}
}
