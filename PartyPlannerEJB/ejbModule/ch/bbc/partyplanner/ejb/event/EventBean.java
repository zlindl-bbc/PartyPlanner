package ch.bbc.partyplanner.ejb.event;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.partyplanner.model.Event;
import ch.bbc.partyplanner.model.User;

/**
 * Session Bean implementation class RegisterBean
 */
@Stateless
public class EventBean implements EventBeanLocal {

	private final static Logger LOGGER = Logger.getLogger(EventBean.class.getName());

	@PersistenceContext
	EntityManager em;

	public EventBean() {
		// TODO Auto-generated constructor stub
	}

	public void create(Event event) {
		em.persist(event);
	}
}
