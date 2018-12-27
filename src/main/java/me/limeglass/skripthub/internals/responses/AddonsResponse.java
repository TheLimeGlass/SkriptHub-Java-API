package me.limeglass.skripthub.internals.responses;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

import me.limeglass.skripthub.api.objects.Addon;
import me.limeglass.skripthub.internals.dummy.Response;

public class AddonsResponse extends Response {
	
	private final Set<Addon> addons = new HashSet<>();
	
	public AddonsResponse(Addon... addons) {
		this.addons.addAll(Sets.newHashSet(addons));
	}
	
	/**
	 * @return The addons for the request.
	 */
	public Set<Addon> getAddons() {
		return addons;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		addons.forEach(activity -> builder.append(activity.toString()));
		return builder.toString();
	}

}
