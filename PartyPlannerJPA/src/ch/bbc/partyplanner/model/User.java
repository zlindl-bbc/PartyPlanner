package ch.bbc.partyplanner.model;

import java.io.Serializable;

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
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.login", query="SELECT u FROM User u WHERE u.email = :userMail AND u.password = :userPassword"),
	@NamedQuery(name="User.createUser", query="UPDATE User u SET u.idUser = :userId, u.username = :userUsername, u.email = :userEmail, u.password = :userPassword"),
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUser;
	private String username;
	private String email;
	private String password;

	
	
	public User() {
		
	}
	
	
	public int getidUser() {
		return idUser;
	}


	public void setidUser(int idUser) {
		this.idUser = idUser;
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