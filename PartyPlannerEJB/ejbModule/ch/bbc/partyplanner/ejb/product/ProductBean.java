package ch.bbc.partyplanner.ejb.product;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.partyplanner.model.Event;
import ch.bbc.partyplanner.model.Product;

/**
 * Session Bean implementation class RegisterBean
 */
@Stateless
public class ProductBean implements ProductBeanLocal {

	private final static Logger LOGGER = Logger.getLogger(ProductBean.class.getName());

	@PersistenceContext
	EntityManager em;

	public ProductBean() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProductsByEventID(int eventId) {
		return (List<Product>) em.createNamedQuery("Product.findAll").setParameter("eventId", eventId).getResultList();
	}
}
