package me.limeglass.skripthub.internals;

public class Endpoints {

	private static String verion = "v1";
	
	/**
	 * The main URL.
	 */
	public static final String API = "https://skripthub.net/api/" + verion;
	
	/**
	 * The addon syntax list endpoint.
	 */
	public static final String SYNTAX_LIST = API + "/addonsyntaxlist/";
	
	/**
	 * The addon list endpoint.
	 */
	public static final String ADDON_LIST = API + "/addon/";

}
