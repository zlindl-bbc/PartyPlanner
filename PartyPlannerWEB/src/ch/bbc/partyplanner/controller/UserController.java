package ch.bbc.partyplanner.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.bbc.partyplanner.ejb.RegisterBeanLocal;
import ch.bbc.partyplanner.model.User;

@Named
@SessionScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = 1L;

    @EJB
    RegisterBeanLocal registerBean;
    
	@Inject
	User user;
	
	List<User> allUsers;
	
//	@PostConstruct
//	public void init() {
//		setAllUsers(registerEjb.getAllUser());
//		System.out.println(getAllUsers());
//	}
	
	public String create() {
		registerBean.create(user);
		return "/login";
	}
 
	public String save() {
		try {
			registerBean.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String login() {
		return registerBean.login(user);
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getAllUsers() {
		if(allUsers == null) {
			setAllUsers(registerBean.getAllUser());
		}
		return allUsers;
	}

	public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}
}
