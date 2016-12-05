package ch.bbc.partyplanner.ejb.eventView;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class RegisterBean
 */
@Stateless
public class EventViewBean implements EventViewBeanLocal {

	private final static Logger LOGGER = Logger.getLogger(EventViewBean.class.getName());
	
	@PersistenceContext
	EntityManager em;

	public EventViewBean() {
		
	}
}
