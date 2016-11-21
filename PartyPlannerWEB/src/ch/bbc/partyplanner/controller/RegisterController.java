package ch.bbc.partyplanner.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.bbc.partyplanner.ejb.RegisterBeanLocal;
import ch.bbc.partyplanner.model.User;

@Named
@SessionScoped
public class RegisterController implements Serializable {

	private static final long serialVersionUID = 1L;

    @EJB
    RegisterBeanLocal registerBean;

	@Inject
	User user;

	public String save() {
		try {
			registerBean.save(user);
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
