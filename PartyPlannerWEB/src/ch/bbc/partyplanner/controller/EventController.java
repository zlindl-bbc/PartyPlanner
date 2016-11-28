package ch.bbc.partyplanner.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.bbc.partyplanner.ejb.event.EventBeanLocal;
import ch.bbc.partyplanner.model.Event;

@Named
@SessionScoped
public class EventController implements Serializable {

	private static final long serialVersionUID = 1L;

    @EJB
    EventBeanLocal eventBean;
    
    List<Event> allEvents;
    
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Inject
	Event event;

	public String create() {
		eventBean.create(event);
		return "/index";
	}
	
	public List<Event> getAllEvents() {
		if(allEvents == null) {
			setAllUsers(eventBean.getAllEvents());
		}
		return allEvents;
	}

	public void setAllUsers(List<Event> allEvents) {
		this.allEvents = allEvents;
	}
	
	public void deleteById() {
		eventBean.deleteById (event);
	}
	
	public void setAllEvents(List<Event> allEvents) {
		this.allEvents = allEvents;
	}
}
