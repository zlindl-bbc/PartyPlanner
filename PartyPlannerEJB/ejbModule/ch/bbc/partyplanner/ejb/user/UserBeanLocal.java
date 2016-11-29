package ch.bbc.partyplanner.ejb.user;

import java.util.List;

import javax.ejb.Local;

import ch.bbc.partyplanner.model.User;

@Local
public interface UserBeanLocal {
	
	public abstract User login(User user); 
	
	public abstract List<User> getAllUser();

	public abstract String create(User user);

}
