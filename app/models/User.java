package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	public String username;
	
	public String firstName;
	
	public String lastName;
	
	public Date joined;
	
	public String password;

	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", joined=" + joined
				+ ", password=" + password + "]";
	}

	public static void authenticate(String username, String password) {
		return ;
	}
	
	
}
