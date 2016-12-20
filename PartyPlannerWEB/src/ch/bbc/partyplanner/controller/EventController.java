package ch.bbc.partyplanner.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import com.sun.xml.fastinfoset.sax.Properties;

import ch.bbc.partyplanner.ejb.event.EventBeanLocal;
import ch.bbc.partyplanner.model.Event;

@Named
@RequestScoped
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
	CookieHelper cookieHelper = new CookieHelper();

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		List<Event> events = eventBean.getAllEventsByUserId(cookieHelper.getUserIdCookie(facesContext));
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
	
	public String takeMeHome(){
		return "index.xhtml";
	}
	
	public String goToCreateEvent(){
		return "createEvent.xhtml";
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

	public String createEvent() {
		// try {
		LOGGER.info("EventName: " + event.getEventName() + ", EventDate: " + event.getEventDate());
		FacesContext facesContext = FacesContext.getCurrentInstance();
		event.setUserId(cookieHelper.getUserIdCookie(facesContext));
		event.setEventAdress(this.generateEventAdress());
		eventBean.createEvent(event);
		sendMail("simon.k@bluewin.ch", "thisisanEventAdress");
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		return "";
	}

	public String testMsg() {
		System.out.println("Test");
		return "";
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
	
	 public static void sendMail(String receiver, String adress) {
	      
//	      String to = "abcd@gmail.com";
		  String to = receiver;
	      String from = "party@planner.com";
	      String host = "localhost";
	      
	      java.util.Properties properties = System.getProperties();
	      properties.setProperty("mail.smtp.host", host);
	      Session session = Session.getDefaultInstance(properties);

	      try {
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	         message.setSubject("Event Created");
	         message.setContent("<h1>You have succesfully created an Event</h1>", "text/html");
	         
	         Transport.send(message);
	         LOGGER.info("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
}
