package ch.bbc.partyplanner.ejb;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.partyplanner.model.User;

/**
 * Session Bean implementation class RegisterBean
 */
@Stateless
public class RegisterBean implements RegisterBeanLocal {

	private final static Logger LOGGER = Logger.getLogger(RegisterBean.class.getName());

	@PersistenceContext
	EntityManager em;

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
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
        
        return (List<User>) em.createNamedQuery("Customer.findAll").getResultList();
  }

	public void create(User user) {
		em.persist(user);
	}
}
