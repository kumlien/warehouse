package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.avaje.ebean.Ebean;

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
	
	public User(String username, String firstName, String lastName, String password, String password2) {
		this.username=username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.password2 = password2;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", joined=" + joined
				+ ", password=" + password + "]";
	}

	public static String authenticate(String username, String password) {
		User user = Ebean.find(User.class, username);
		if(user != null) {
			System.out.println("found a user: " + user);
			if(user.password.equals(password)) {
				System.out.println("passwords match");
				return null;
			}
		}
		return "Unsuccessful authentication";
	}

	public static void save(User newUser) {
		Ebean.save(newUser);
	}
	
	
}
