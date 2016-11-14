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
	@NamedQuery(name="Bring.findAll", query="SELECT c FROM Bring c"),
})
public class Bring implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTableOne;
	private int idEvent;
	private int idProduct;
	private int idUser;
	private String tempUsername;

	
	
	public Bring() {
		
	}



	public int getIdTableOne() {
		return idTableOne;
	}



	public void setIdTableOne(int idTableOne) {
		this.idTableOne = idTableOne;
	}



	public int getIdEvent() {
		return idEvent;
	}



	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}



	public int getIdProduct() {
		return idProduct;
	}



	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}



	public int getIdUser() {
		return idUser;
	}



	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}



	public String getTempUsername() {
		return tempUsername;
	}



	public void setTempUsername(String tempUsername) {
		this.tempUsername = tempUsername;
	}

	
}