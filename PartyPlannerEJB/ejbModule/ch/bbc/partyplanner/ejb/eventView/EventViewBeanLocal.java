package ch.bbc.partyplanner.ejb.eventView;

import javax.ejb.Local;

import ch.bbc.partyplanner.model.Event;
import ch.bbc.partyplanner.model.Product;
import ch.bbc.partyplanner.model.User;

@Local
public interface EventViewBeanLocal {

	void create(Event event, Product product, User user);

	Event getEventbyAdress(String eventAdress);

	void bring(int productToDeleteId, int amount);

	String getEventCreator(int currentEventId);

	/**
	 * 
	 * @param event
	 */
}
