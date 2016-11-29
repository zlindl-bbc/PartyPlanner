package ch.bbc.partyplanner.ejb.event;

import java.util.List;

import javax.ejb.Local;

import ch.bbc.partyplanner.model.Event;

@Local
public interface EventBeanLocal {

	/**
	 * 
	 * @param event
	 */
	public abstract void create(Event event);

	public abstract List<Event> getAllEvents();

	public abstract void deleteById (Event event);
	
	public abstract List<Event> getAllEventsByUserId(int userId);
	
	public abstract boolean eventExists(String eventAdress);

}
