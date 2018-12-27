package me.limeglass.skripthub.internals.objects;

import java.util.Set;

import org.eclipse.jdt.annotation.Nullable;

import me.limeglass.skripthub.api.objects.CompatibleVersion;
import me.limeglass.skripthub.api.objects.Event;
import me.limeglass.skripthub.api.objects.Plugin;

public class EventImp extends SyntaxImp implements Event {
	
	private final boolean cancellable;
	private final String eventValues;
	
	public EventImp(String description, CompatibleVersion compatible, Set<Plugin> plugins, int creatorId, String pattern, String jsonId, String title, Plugin addon, String css, int id, boolean cancellable, String eventValues) {
		super(description, compatible, plugins, creatorId, pattern, jsonId, title, addon, css, id);
		this.cancellable = cancellable;
		this.eventValues = eventValues;
	}

	@Nullable
	@Override
	public String getEventValues() {
		return eventValues;
	}

	@Nullable
	@Override
	public boolean isCancellable() {
		return cancellable;
	}

	@Override
	public Type getSyntaxType() {
		return Type.EVENT;
	}

}
