package ch.bbc.partyplanner.ejb.product;

import java.util.List;

import javax.ejb.Local;

import ch.bbc.partyplanner.model.Event;
import ch.bbc.partyplanner.model.Product;

@Local
public interface ProductBeanLocal {

	List<Product> getAllProductsByEventID(int idEvent);

	/**
	 * 
	 * @param event
	 */
}
