package ch.bbc.partyplanner.ejb.eventView;

import javax.ejb.Local;

import ch.bbc.partyplanner.model.Event;
import ch.bbc.partyplanner.model.Product;

@Local
public interface EventViewBeanLocal {

	void create(Event event, Product product);

	Event getEventbyAdress(String eventAdress);

	void bring(int productToDeleteId, int amount);

	/**
	 * 
	 * @param event
	 */
}
