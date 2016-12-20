package ch.bbc.partyplanner.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

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
	private boolean userLoggedIn = false;
	private int status = 0;
	CookieHelper cookieHelper = new CookieHelper();
	
	public String create() {
		userBean.create(user);
		User loggedIn = userBean.login(user);
		
		if(loggedIn != null){
			FacesContext facesContext = FacesContext.getCurrentInstance();
			cookieHelper.setLoggedInCookie(""+loggedIn.getidUser(), 6000, facesContext);
			return "home?faces-redirect=true";
		}
		else{
			return "";
		}
	}
	
	public String login() {
		User loggedIn = userBean.login(user);
		
		if(loggedIn != null) {
			setUserLoggedIn(true);
			setUser(loggedIn);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			cookieHelper.setLoggedInCookie(""+user.getidUser(), 6000, facesContext); // 6000 = 10 minutes
			return "/home?faces-redirect=true";
		} else {
			setStatus(-1);
			setUserLoggedIn(false);
			return "";
		}
	}
	
	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
	            .getExternalContext().getSession(false);
	    session.invalidate();
	    setUserLoggedIn(false);
	    return "index.xhtml";
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

	public boolean isUserLoggedIn() {
		return userLoggedIn;
	}

	public void setUserLoggedIn(boolean userLoggedIn) {
		this.userLoggedIn = userLoggedIn;
	}
}
