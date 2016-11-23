package ch.bbc.partyplanner.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.bbc.partyplanner.ejb.user.UserBeanLocal;
import ch.bbc.partyplanner.model.User;

@Named
@SessionScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = 1L;

    @EJB
    private UserBeanLocal userBean;
    
	@Inject
	private User user;
	
	private List<User> allUsers;
	
	private int status = 0;
	
	public String create() {
		return userBean.create(user);
	}
	
	public String login() {
		
		if(userBean.login(user)) {
			return "/home";
		} else {
			setStatus(-1);
			return "";
		}
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getAllUsers() {
		if(allUsers == null) {
			setAllUsers(userBean.getAllUser());
		}
		return allUsers;
	}

	public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}
}
