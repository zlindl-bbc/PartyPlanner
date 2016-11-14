package ch.bbc.partyplanner.model;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the customer database table.
 * 
 */
@Named
@Entity
@Model
@NamedQueries({
	@NamedQuery(name="Product.findAll", query="SELECT c FROM Product c"),
})
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int userID;
	private String username;
	private String email;
	private String password;

	
	
	public Product() {
		
	}
	
	
	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}