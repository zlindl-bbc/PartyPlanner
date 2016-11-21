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
	private int idProduct;
	private String productName;
	private String description;
	private int numberOfItems;
	private int eventId;

	
	
	public Product() {
		
	}



	public int getIdProduct() {
		return idProduct;
	}



	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getNumberOfItems() {
		return numberOfItems;
	}



	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}



	public int getEventId() {
		return eventId;
	}



	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	

}