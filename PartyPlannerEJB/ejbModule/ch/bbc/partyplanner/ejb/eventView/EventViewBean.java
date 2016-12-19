package ch.bbc.partyplanner.ejb.eventView;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.partyplanner.ejb.event.EventBean;
import ch.bbc.partyplanner.model.Event;
import ch.bbc.partyplanner.model.Product;
import ch.bbc.partyplanner.model.User;

/**
 * Session Bean implementation class RegisterBean
 */
@Stateless
public class EventViewBean implements EventViewBeanLocal {

	private final static Logger LOGGER = Logger.getLogger(EventBean.class.getName());

	@PersistenceContext
	EntityManager em;

	public EventViewBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Event event, Product product, User user) {
		em.persist(event);
		em.persist(product);
		em.persist(user);
	}

	public void deleteById(int eventId) {
		em.createNamedQuery("Event.deleteById").setParameter("eventId", eventId).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Event getEventbyAdress(String eventAdress) {
		return (Event) em.createNamedQuery("Event.findByAdress").setParameter("eventAdress", eventAdress)
				.getSingleResult();
	}

	@Override
	public void bring(int productToDeleteId, int amount) {
		int amountAfter;
		int amountBefore = (int) em.createNamedQuery("Product.findAmountById")
				.setParameter("productId", productToDeleteId).getSingleResult();
		if ((amountBefore - amount) >= 0) {
			amountAfter = (amountBefore - amount);
		} else {
			amountAfter = amountBefore;
		}
		Query query = em.createNamedQuery("Product.setAmountById");
		query.setParameter("amount", amountAfter);
		query.setParameter("productId", productToDeleteId);
		query.executeUpdate();
	}

	@Override
	public String getEventCreator(int idUser) {
		return (String) em.createNamedQuery("User.getUsernameById").setParameter("idUser", idUser).getSingleResult();
	}
}
