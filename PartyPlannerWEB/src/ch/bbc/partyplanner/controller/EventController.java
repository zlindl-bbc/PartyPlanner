package ch.bbc.partyplanner.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.bbc.partyplanner.ejb.event.EventBean;
import ch.bbc.partyplanner.ejb.event.EventBeanLocal;
import ch.bbc.partyplanner.model.Event;

@Named
@ViewScoped
public class EventController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final static Logger LOGGER = Logger.getLogger(EventController.class.getName());

	@EJB
	private EventBeanLocal eventBean;

	@Inject
	private UserController userController;

	private List<Event> allEvents;

	@PostConstruct
	public void init() {
		List<Event> events = eventBean.getAllEventsByUserId(getUserController().getUser().getidUser());
		setAllEvents(events);
	}
		
		
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
		return allEvents;
	}

	public void setAllEvents(List<Event> allEvents) {
		this.allEvents = allEvents;
	}

	public void deleteById() {
		eventBean.deleteById(event);
	}


	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public String goToEvent() {
		if (eventBean.eventExists(requestedEvent)) {
			LOGGER.info("Called Event: " + requestedEvent);
			LOGGER.info("/event?eventAdress=" + requestedEvent);
			return "/event?eventAdress=" + requestedEvent;
		} else {
			searchStatus = true;
			return "/index";
		}
	}
}
