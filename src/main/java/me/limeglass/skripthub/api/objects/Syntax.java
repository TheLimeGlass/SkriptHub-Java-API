package me.limeglass.skripthub.api.objects;

import java.util.Set;

public interface Syntax {

	public enum Type {
		EVENT,
		CONDITION,
		EFFECT,
		EXPRESSION,
		TYPE,
		FUNCTION,
		UNKNOWN;
	}
	
	/**
	 * @return The compatible versions of the addon for the syntax.
	 */
	CompatibleVersion getCompatibleVersions();
	
	/**
	 * @return The list of required plugins for this syntax.
	 */
	Set<Plugin> getRequiredPlugins();
	
	/**
	 * @return true if the syntax requires additional plugins.
	 */
	boolean requiresPlugins();
	
	/**
	 * @return The description of the syntax.
	 */
	String getDescription();
	
	/**
	 * @return The compatible versions of the addon for the syntax.
	 */
	Type getSyntaxType();
	
	default String[] getPatterns() {
		return new String[] {getPattern()};
	}
	
	/**
	 * @return The pattern of the syntax.
	 * @deprecated SkriptHub may change this to be multiple patterns in the future.
	 */
	String getPattern();
	
	/**
	 * @return The CSS of the syntax type of the syntax.
	 */
	String getTypeCSS();
	
	/**
	 * @return The JSON ID of the syntax.
	 */
	String getJsonID();
	
	/**
	 * @return The creator id of the syntax.
	 */
	int getCreatorID();
	
	/**
	 * @return The title of the syntax.
	 */
	String getTitle();
	
	/**
	 * @return The addon associated with this syntax.
	 */
	Plugin getAddon();
	
	/**
	 * @return The id of the syntax.
	 */
	int getID();

}
