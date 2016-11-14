package ch.bbc.partyplanner.model;

import java.io.Serializable;
import java.sql.Date;

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
@NamedQueries({ @NamedQuery(name = "Event.findAll", query = "SELECT c FROM Event c"), })
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int eventId;
	private Date eventDate;
	private String product;

	public Event() {

	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

}