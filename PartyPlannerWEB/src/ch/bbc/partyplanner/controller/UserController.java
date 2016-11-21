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
    UserBeanLocal userBean;
    
	@Inject
	User user;
	
	List<User> allUsers;
	
//	@PostConstruct
//	public void init() {
//		setAllUsers(registerEjb.getAllUser());
//		System.out.println(getAllUsers());
//	}
	
	public String create() {
		userBean.create(user);
		return "/login";
	}
	
	public String login() {
		return userBean.login(user);
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
