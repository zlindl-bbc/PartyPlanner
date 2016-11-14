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

	public RegisterBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public List<User> getAllUser() {
		return (List<User>) em.createNamedQuery("User.findAll").getResultList();
	}
}
