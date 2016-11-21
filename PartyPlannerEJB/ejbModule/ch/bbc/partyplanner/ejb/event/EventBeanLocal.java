package ch.bbc.partyplanner.ejb.event;

import javax.ejb.Local;

import ch.bbc.partyplanner.model.Event;

@Local
public interface EventBeanLocal {

	/**
	 * 
	 * @param event
	 */
	public abstract void create(Event event);

}
