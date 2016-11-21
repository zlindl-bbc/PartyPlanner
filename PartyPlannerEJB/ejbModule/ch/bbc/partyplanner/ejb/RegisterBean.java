package ch.bbc.partyplanner.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.partyplanner.model.User;

/**
 * Session Bean implementation class RegisterBean
 */
@Stateless
public class RegisterBean implements RegisterBeanLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public RegisterBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(User user) {
		em.persist(user);
	}

	public String checkLogin(User user) {

		if (em.createNamedQuery("Customer.checkLogin").setParameter("custMail", user.getEmail())
				.setParameter("custPW", user.getPassword()).getResultList().size() > 0) {
			return "/home";
		} else {

			return "";
		}
	}
	
	public List<User> getAllUser() {
        
        return (List<User>) em.createNamedQuery("Customer.findAll").getResultList();
  }

	@Override
	public void create(User user) {
		em.persist(user);
		
	}
}
