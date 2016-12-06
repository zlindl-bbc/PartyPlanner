package ch.bbc.partyplanner.ejb.eventView;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.partyplanner.ejb.event.EventBean;
import ch.bbc.partyplanner.model.Event;
import ch.bbc.partyplanner.model.Product;

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
	public void create(Event event, Product product) {
		em.persist(event);
		em.persist(product);
	}


	@SuppressWarnings("unchecked")
	public List<Event> getAllEvents() {
        return (List<Event>) em.createNamedQuery("Event.findAll").getResultList();
  }

	public void deleteById(int eventId) {
		em.createNamedQuery("Event.deleteById").setParameter("eventId", eventId).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Event getEventbyAdress(String eventAdress) {
		return (Event) em.createNamedQuery("Event.findByAdress").setParameter("eventAdress", eventAdress).getSingleResult();
	}
}
