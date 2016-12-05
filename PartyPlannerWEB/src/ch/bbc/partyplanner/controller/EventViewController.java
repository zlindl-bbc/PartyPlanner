package ch.bbc.partyplanner.controller;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import ch.bbc.partyplanner.ejb.event.EventBeanLocal;
import ch.bbc.partyplanner.model.Event;

@Named
@ViewScoped
public class EventViewController implements Serializable{
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger(EventController.class.getName());
	private int currentEventId;

	@EJB
	private EventBeanLocal eventBean;

	@Inject
	private Event event;
	private String requestedEvent;
	private boolean searchStatus = false;

	public String getEventInfo() {
		HttpServletRequest origRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String eventAdress = origRequest.getParameter("eventAdress");

		if (!(eventAdress == null)) {
			if (eventBean.eventExists(eventAdress)) {
				LOGGER.info("Called Event: " + eventAdress);
			}
		}
		return "/index";
	}
}