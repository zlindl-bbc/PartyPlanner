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
	@NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"), 
	@NamedQuery(name="Event.findAdress", query="SELECT e FROM Event e WHERE e.eventAdress = :eventAdress"),
	@NamedQuery(name="Event.deleteById", query="DELETE FROM Event e WHERE e.idEvent = :eventId"),
	@NamedQuery(name="Event.createEvent", query="UPDATE Event e SET e.eventDate = :eventDate, e.eventName = :eventName, e.eventDescription = :eventDescription, e.productId = :eventProductId, e.userId = :eventUserId"),			
})
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEvent;
	private String eventAdress;
	private String eventDate;
	private String eventName;
	private String eventDescription;
	private int productId;
	private int userId;

	public Event() {

	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEventAdress() {
		return eventAdress;
	}

	public void setEventAdress(String eventAdress) {
		this.eventAdress = eventAdress;
	}

	

}