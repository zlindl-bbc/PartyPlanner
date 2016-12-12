package ch.bbc.partyplanner.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the event database table.
 * 
 */
@Named
@Entity
@NamedQueries({ 
	@NamedQuery(name="Event.findAll", query ="SELECT e FROM Event e"), 
	@NamedQuery(name="Event.findByAdress", query="SELECT e FROM Event e WHERE e.eventAdress = :eventAdress"),
	@NamedQuery(name="Event.deleteById", query="DELETE FROM Event e WHERE e.idEvent = :eventId"),
	@NamedQuery(name="Event.createEvent", query="UPDATE Event e SET e.eventAdress = :eventAdress, e.eventDate = :eventDate, e.eventName = :eventName, e.eventDescription = :eventDescription, e.userId = :eventUserId"),			
    @NamedQuery(name="Event.findAllByUserId", query="SELECT e FROM Event e WHERE e.userId = :userId"),
})
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd.MM.yyyy");

	@Id
	private int idEvent;

	@Temporal(TemporalType.DATE)
	private Date eventDate;
	private String eventAdress;
	private String eventName;
	private String eventDescription;
	private int userId;

	public Event() {
	}

	public int getIdEvent() {
		return this.idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public String getEventAdress() {
		return this.eventAdress;
	}

	public void setEventAdress(String eventAdress) {
		this.eventAdress = eventAdress;
	}

	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventDescription() {
		return this.eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getEventDateAsString() {
		return SDF.format(getEventDate());
	}
}