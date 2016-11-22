package ch.bbc.partyplanner.ejb.user;

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
public class UserBean implements UserBeanLocal {

	private final static Logger LOGGER = Logger.getLogger(UserBean.class.getName());

	@PersistenceContext
	EntityManager em;

	public UserBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String login(User user) {

		if (em.createNamedQuery("User.login")
				.setParameter("userMail", user.getEmail())
				.setParameter("userPassword", user.getPassword())
				.getResultList().size() > 0) {
			LOGGER.info("User " + user.getEmail() + " successfully logged in.");
			return "/index";
		} else {
			return "";
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
        
        return (List<User>) em.createNamedQuery("User.findAll").getResultList();
  }

	public void create(User user) {
		em.persist(user);
	}
}
