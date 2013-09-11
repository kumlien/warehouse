package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import play.api.libs.iteratee.internal;

import com.avaje.ebean.Ebean;
import com.google.common.base.Strings;

@Entity
public class User {
	
	@Id
	public String username;
	
	
	public String firstName;
	
	
	public String lastName;
	
	public Date joined;
	
	public String password;
	
	@Transient
	public String password2;

	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", joined=" + joined
				+ ", password=" + password + "]";
	}

	public static String authenticate(String username, String password) {
		if(!Strings.isNullOrEmpty(username) && !Strings.isNullOrEmpty(password)) {
			User user = Ebean.find(User.class, username);
			if(user != null) {
				System.out.println("found a user: " + user);
				if(user.password.equals(password)) {
					System.out.println("passwords match");
					return null;
				}
			}
		}
		return "Unsuccessful authentication";
	}

	public static void save(User newUser) {
			Ebean.save(newUser);
	}
	
	/**
	 * Return an error string if something is weird, null otherwise. 
	 */
	public String validateNewUser() {
		StringBuilder sb = new StringBuilder();
		checkField(username, "username", 10, sb);
		checkField(firstName, "first name", 2, sb);
		checkField(lastName, "last name", 2, sb);
		checkField(password, "password", 8, sb);
		checkField(password2, "password2", 8, sb);
		
		if(!Strings.isNullOrEmpty(password) && !password.equals(password2)) {
			sb.append("The passwords doesn't match");
		}
		
		if(Ebean.find(User.class, username) != null) {
			sb.append("That username is already taken");
		}
		
		return sb.length() <1 ? null : sb.toString();
	}

	private static final void checkField(String field, String fieldName, int minLength, StringBuilder sb) {
		if(Strings.isNullOrEmpty(field) || field.length() < minLength) {
			if(sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(fieldName + " is not specified or too short.");
		}
	}
	
}
