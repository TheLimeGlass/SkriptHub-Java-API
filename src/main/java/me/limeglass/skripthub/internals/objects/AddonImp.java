package me.limeglass.skripthub.internals.objects;

import java.util.Arrays;

import me.limeglass.skripthub.api.objects.Addon;

public class AddonImp implements Addon {

	private final String[] authors;
	private final String url, name;
	
	public AddonImp(String name, String url, String... authors) {
		this.authors = authors;
		this.name = name;
		this.url = url;
	}

	@Override
	public String[] getAuthors() {
		return authors;
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
		builder.append("authors=" + Arrays.toString(authors));
		builder.append(",name=" + name);
		builder.append(",url=" + url);
		return builder.toString();
	}

}
