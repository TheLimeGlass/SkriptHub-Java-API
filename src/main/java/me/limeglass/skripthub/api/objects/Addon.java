package me.limeglass.skripthub.api.objects;

public interface Addon {

	/**
	 * @return The authors of the addon.
	 */
	String[] getAuthors();
	
	/**
	 * @return The name of the addon.
	 */
	String getName();
	
	/**
	 * @return The main url/thread the addon is hosted on.
	 */
	String getURL();

}
