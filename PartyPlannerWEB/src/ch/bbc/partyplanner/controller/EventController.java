package ch.bbc.partyplanner.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.bbc.partyplanner.ejb.event.EventBean;
import ch.bbc.partyplanner.ejb.event.EventBeanLocal;
import ch.bbc.partyplanner.model.Event;

@Named
@SessionScoped
public class EventController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final static Logger LOGGER = Logger.getLogger(EventBean.class.getName());

    @EJB
    EventBeanLocal eventBean;
    
    List<Event> allEvents;
    
	public boolean isSearchStatus() {
		return searchStatus;
	}

	public void setSearchStatus(boolean searchStatus) {
		this.searchStatus = searchStatus;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getRequestedEvent() {
		return requestedEvent;
	}

	public void setRequestedEvent(String requestedEvent) {
		this.requestedEvent = requestedEvent;
	}
	
	@Inject
	Event event;
	String requestedEvent;
	boolean searchStatus =false;
	
	

	public String create() {
		eventBean.create(event);
		return "/index";
	}
	
	public List<Event> getAllEvents() {
		if(allEvents == null) {
			setAllEvents(eventBean.getAllEvents());
		}
		return allEvents;
	}

	public void setAllEvents(List<Event> allEvents) {
		this.allEvents = allEvents;
	}
	
	public void deleteById() {
		eventBean.deleteById (event);
	}
	
	//<< EventAddressSearch
	
	public String goToEvent(){
		if(eventBean.eventExists(requestedEvent)){
			LOGGER.info("Called Event: "+requestedEvent);
			LOGGER.info("/event?eventAdress="+requestedEvent);
			return "/event?eventAdress="+requestedEvent;
		}else{
			searchStatus=true;
			return "/index";
		}
	}
	
	//>>
}
