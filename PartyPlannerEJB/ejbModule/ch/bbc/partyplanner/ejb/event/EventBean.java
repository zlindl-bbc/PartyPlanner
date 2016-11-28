package ch.bbc.partyplanner.ejb.event;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.partyplanner.model.Event;

/**
 * Session Bean implementation class RegisterBean
 */
@Stateless
public class EventBean implements EventBeanLocal {


	@PersistenceContext
	EntityManager em;

	public EventBean() {
		// TODO Auto-generated constructor stub
	}

	public void create(Event event) {
		em.persist(event);
	}


	@SuppressWarnings("unchecked")
	public List<Event> getAllEvents() {
        return (List<Event>) em.createNamedQuery("Event.findAll").getResultList();
  }

	public void deleteById(Event event) {
		em.createNamedQuery("Event.deleteById");
	}
	
	
}
