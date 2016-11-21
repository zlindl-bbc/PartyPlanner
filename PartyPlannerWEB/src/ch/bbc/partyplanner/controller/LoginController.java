package ch.bbc.partyplanner.controller;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import ch.bbc.partyplanner.model.User;

@Named
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	EntityManager em;
	

	@Resource
	UserTransaction ut;

	@Inject
	User user;

	String query;

	public String checkLogin() {
		try {
			ut.begin();
			if (em.createNamedQuery("Customer.checkLogin")
					.setParameter("custMail", user.getEmail()).setParameter("custPW", user.getPassword())
					.getResultList().size() > 0) {
				return "/home";
			} else {

			}

			ut.commit();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}