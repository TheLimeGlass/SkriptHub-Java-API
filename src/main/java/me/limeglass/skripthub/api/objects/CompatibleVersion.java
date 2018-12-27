package me.limeglass.skripthub.api.objects;

public class CompatibleVersion {

	private final String minecraft, addon;
	
	public CompatibleVersion(String minecraft, String addon) {
		this.minecraft = minecraft;
		this.addon = addon;
	}
	
	/**
	 * @return The compatible version of minecraft for this syntax.
	 */
	public String getMinecraftVersion() {
		return minecraft;
	}
	
	/**
	 * @return The compatible version of the addon for this syntax.
	 */
	public String getAddonVersion() {
		return addon;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("minecraft=" + minecraft);
		builder.append(",addon=" + addon);
		return builder.toString();
	}
	
}
