package me.limeglass.skripthub.api;

import java.util.Set;

import me.limeglass.skripthub.api.objects.Addon;

public interface SkriptHub {
	
	/**
	 * @return The list of all addons.
	 */
	Set<Addon> getAddons();
	
	/**
	 * @return The authentication token for the client.
	 */
	String getToken();
	
	/**
	 * @return The connection timeout option.
	 */
	int getTimeout();
	
}
