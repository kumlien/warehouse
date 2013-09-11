package controllers;


import java.util.Date;

import models.User;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class Users extends Controller {
	
	static final Form<User> USER_FORM = Form.form(User.class);
	
	/**
	 * Called from template via ajax, return as json
	 */
	/**
	 * @return
	 * @throws InterruptedException
	 */
	public static Result login() throws InterruptedException {
		Form<User> userForm = USER_FORM.bindFromRequest();
		User user = userForm.get();
		System.out.println(user);
		String response = User.authenticate(user.username, user.password); 
		if(response != null) {
			return badRequest(response);
		} 
		
		session().clear();
		session("username", userForm.get().username);
		System.out.println("Redirecting to index");
		return ok();
	}
	
	public static Result renderRegisterPage() {
		return ok(views.html.register.render());
	}
	
	public static Result register() {
		Form<User> userForm = USER_FORM.bindFromRequest();
		User newUser = userForm.get();
		System.out.println("Register new user: " + newUser);
		String errMsg = newUser.validateNewUser();
		if(errMsg == null) {
			newUser.joined = new Date();
			User.save(newUser);			
			return ok();
		} else {
			System.out.println("Something went wrong: " + errMsg);
			return badRequest(errMsg);
		}
	}
}
