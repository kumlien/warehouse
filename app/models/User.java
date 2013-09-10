package models;

import java.util.Date;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import play.data.validation.Constraints.Min;
import play.data.validation.Constraints.Required;
import play.libs.F.Option;
import play.mvc.QueryStringBindable;

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

	public static void authenticate(String username, String password) {
		return ;
	}
	
	
}
