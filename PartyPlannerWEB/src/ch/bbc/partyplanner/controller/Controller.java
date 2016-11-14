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
public class Controller implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	User user;
	
	@EJB
	RegisterBeanLocal registerBean;
	
	public List<User> getAllUser(){
		return registerBean.getAllUser();
	}
}
