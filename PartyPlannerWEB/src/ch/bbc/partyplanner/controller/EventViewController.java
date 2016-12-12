package ch.bbc.partyplanner.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import ch.bbc.partyplanner.ejb.event.EventBeanLocal;
import ch.bbc.partyplanner.ejb.eventView.EventViewBeanLocal;
import ch.bbc.partyplanner.ejb.product.ProductBeanLocal;
import ch.bbc.partyplanner.model.Event;
import ch.bbc.partyplanner.model.Product;

@Named
@ViewScoped
public class EventViewController implements Serializable {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger(EventController.class.getName());
	private int currentEventId;
	private String currentEventAdress;
	@EJB
	private EventViewBeanLocal eventViewBean;

	@EJB
	private EventBeanLocal eventBean;

	@EJB
	private ProductBeanLocal productBean;

	@Inject
	private Event event;

	private String productToDeleteId;
	private String Amount;
	private List<Product> products;
	private String requestedEvent;
	private boolean searchStatus = false;

	public String getEventTitle() {
		init();

		LOGGER.info("Called EventName of: " + currentEventAdress);
		return event.getEventName();
	}

	private void init() {
		HttpServletRequest origRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		currentEventAdress = origRequest.getParameter("eventAdress");

		event = eventViewBean.getEventbyAdress(currentEventAdress);
		LOGGER.info("Called Event: " + currentEventAdress);
		
		initProducts();
	}

	public void bring(){
		
	}
	
	public String getEventDescription() {
		return event.getEventDescription();
	}

	public String getEventDate() {
		return event.getEventDate().toLocaleString();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> allProducts) {
		this.products = allProducts;
	}

	public void initProducts() {
		List<Product> products = productBean.getAllProductsByEventID(event.getIdEvent()); // eventBean.getAllEventsByUserId(getUserController().getUser().getidUser());
		setProducts(products);
	}
}
