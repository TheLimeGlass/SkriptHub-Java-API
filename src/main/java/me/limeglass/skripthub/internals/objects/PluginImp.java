package me.limeglass.skripthub.internals.objects;

import me.limeglass.skripthub.api.objects.Plugin;

public class PluginImp implements Plugin {

	private final String url, name;
	
	public PluginImp(String name, String url) {
		this.name = name;
		this.url = url;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getURL() {
		return url;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("name=" + name);
		builder.append(",url=" + url);
		return builder.toString();
	}

}
