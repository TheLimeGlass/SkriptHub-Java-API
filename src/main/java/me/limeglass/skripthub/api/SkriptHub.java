package me.limeglass.skripthub.api;

import java.util.Set;

import me.limeglass.skripthub.api.objects.Addon;
import me.limeglass.skripthub.api.objects.Syntax;

public interface SkriptHub {
	
	/**
	 * @return The syntaxes of all addons.
	 */
	Set<Syntax> getSyntaxes();
	
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
