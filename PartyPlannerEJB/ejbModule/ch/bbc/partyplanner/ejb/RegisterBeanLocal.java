package ch.bbc.partyplanner.ejb;

import java.util.List;

import javax.ejb.Local;

import ch.bbc.partyplanner.model.User;

@Local
public interface RegisterBeanLocal {
	
	/**
	 * 
	 * @param user
	 */
	public void save(User user);
	
	public abstract String login(User user); 
	
	public abstract List<User> getAllUser();

	public abstract void create(User user);

}
