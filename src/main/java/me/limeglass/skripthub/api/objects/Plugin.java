package me.limeglass.skripthub.api.objects;

public interface Plugin {
	
	/**
	 * @return The name of the plugin.
	 */
	String getName();
	
	/**
	 * @return The main url/thread the plugin.
	 */
	String getURL();

}
