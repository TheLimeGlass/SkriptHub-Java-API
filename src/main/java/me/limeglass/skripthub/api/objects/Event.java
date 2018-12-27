package me.limeglass.skripthub.api.objects;

public interface Event extends Syntax {

	/**
	 * @return The event values of the Event.
	 */
	String getEventValues();
	
	/**
	 * @return If the event can be cancelled.
	 */
	boolean isCancellable();
	
}
