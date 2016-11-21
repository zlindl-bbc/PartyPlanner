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
	private int numberOfItems;
	private String tempUsername;
	private int eventId;
	private int userId;
	private int productId;

	
	
	public Bring() {
		
	}



	public int getIdTableOne() {
		return idTableOne;
	}



	public void setIdTableOne(int idTableOne) {
		this.idTableOne = idTableOne;
	}



	public int getNumberOfItems() {
		return numberOfItems;
	}



	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}



	public String getTempUsername() {
		return tempUsername;
	}



	public void setTempUsername(String tempUsername) {
		this.tempUsername = tempUsername;
	}



	public int getEventId() {
		return eventId;
	}



	public void setEventId(int eventId) {
		this.eventId = eventId;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}

	
}