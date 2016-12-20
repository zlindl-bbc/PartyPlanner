package ch.bbc.partyplanner.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import ch.bbc.partyplanner.ejb.event.EventBeanLocal;
import ch.bbc.partyplanner.ejb.eventView.EventViewBeanLocal;
import ch.bbc.partyplanner.ejb.product.ProductBean;
import ch.bbc.partyplanner.ejb.product.ProductBeanLocal;
import ch.bbc.partyplanner.model.Event;
import ch.bbc.partyplanner.model.Product;

@Named
@ViewScoped
public class EventViewController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(EventController.class.getName());
	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd.MM.yyyy hh:mm");

	@EJB
	private EventViewBeanLocal eventViewBean;

	@EJB
	private EventBeanLocal eventBean;

	@EJB
	private ProductBeanLocal productBean;

	private int currentEventId;
	private String currentEventAdress;
	private Event event;
	private int productToDeleteId;
	private int amount;
	private List<Product> products;
	private String requestedEvent;
	private boolean searchStatus = false;
	private ArrayList<String> brought=new ArrayList<String>();

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

	public String bring() {
		eventViewBean.bring(productToDeleteId, amount);
		brought.add(eventViewBean.getProductNameById(productToDeleteId));
		brought.add(" "+amount);
		return "/catchEvent?faces-redirect=true&eventAdress=" + currentEventAdress;
	}
	
	public String getEventCreator() {
		LOGGER.info("Called EventCreator  --------->ID:: " + event.getUserId());
		return eventViewBean.getEventCreator(event.getUserId());
		
	}

	public String getBroughtList(){
		String returnString="<table>";
		
		for (int i = 0; i < brought.size(); i=(i+2)) {
			returnString=returnString+"<tr><th>"+brought.get(i)+"</th><th>"+brought.get((i+1))+"</th></tr>";
		}
		
		LOGGER.info("broughtlist: "+brought.toString());
		return (returnString+"</table>");
	}
	public String getEventDescription() {
		return event.getEventDescription();
	}

	public String getEventDate() {
		return SDF.format(event.getEventDate());
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

	public int getProductToDeleteId() {
		return productToDeleteId;
	}

	public void setProductToDeleteId(int productToDeleteId) {
		this.productToDeleteId = productToDeleteId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
