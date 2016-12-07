package ch.bbc.partyplanner.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

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

	@Inject
	private Event event;

	private int currentEventId;
	private List<Event> allEvents;
	private String requestedEvent;
	private boolean searchStatus = false;

	@PostConstruct
	public void init() {
		List<Event> events = eventBean.getAllEventsByUserId(getUserController().getUser().getidUser());
		setAllEvents(events);
	}

	public String goToEvent() {
		HttpServletRequest origRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();

		String eventAdress = requestedEvent;
		if (eventBean.eventExists(eventAdress)) {
			LOGGER.info("Called Event: " + eventAdress);
			LOGGER.info("/catchEvent?eventAdress=" + eventAdress);

			return "/catchEvent?faces-redirect=true&eventAdress=" + eventAdress;
		} else {
			LOGGER.info("Called Event: " + eventAdress);
			LOGGER.info("Go To: /index");
			searchStatus = true;
			return "/index";
		}
	}

	public String create() {
		event.setEventAdress(generateEventAdress());
		eventBean.create(event);
		return "/index";
	}

	public String generateEventAdress() {
		String usableChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 14; i++) {
			sb.append(usableChars.charAt(random.nextInt(usableChars.length())));
		}
		return sb.toString();
	}

	public String deleteById() {
		eventBean.deleteById(getCurrentEventId());
		return "";
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

	public List<Event> getAllEvents() {
		return allEvents;
	}

	public void setAllEvents(List<Event> allEvents) {
		this.allEvents = allEvents;
	}

	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public int getCurrentEventId() {
		return currentEventId;
	}

	public void setCurrentEventId(int currentEventId) {
		this.currentEventId = currentEventId;
	}
}
