package ch.bbc.partyplanner.ejb;

import java.util.List;

import javax.ejb.Local;

import ch.bbc.partyplanner.model.User;

@Local
public interface RegisterBeanLocal {
	
	/**
	 * 
	 * @return
	 */
	public abstract List<User> getAllUser();

}
