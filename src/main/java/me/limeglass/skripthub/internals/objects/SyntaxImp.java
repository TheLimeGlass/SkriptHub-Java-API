package me.limeglass.skripthub.internals.objects;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.Nullable;

import me.limeglass.skripthub.api.objects.CompatibleVersion;
import me.limeglass.skripthub.api.objects.Plugin;
import me.limeglass.skripthub.api.objects.Syntax;

public abstract class SyntaxImp implements Syntax {

	private final String description, pattern, jsonId, title, css;
	private final Set<Plugin> plugins = new HashSet<>();
	private final CompatibleVersion compatible;
	private final int creatorId, id;
	private final Plugin addon;
	
	public SyntaxImp(String description, CompatibleVersion compatible, Set<Plugin> plugins, int creatorId, String pattern, String jsonId, String title, Plugin addon, String css, int id) {
		this.description = description;
		this.compatible = compatible;
		this.plugins.addAll(plugins);
		this.creatorId = creatorId;
		this.pattern = pattern;
		this.jsonId = jsonId;
		this.title = title;
		this.addon = addon;
		this.css = css;
		this.id = id;
	}
	
	@Override
	public CompatibleVersion getCompatibleVersions() {
		return compatible;
	}

	@Override
	public Set<Plugin> getRequiredPlugins() {
		return plugins;
	}

	@Override
	public boolean requiresPlugins() {
		return plugins.isEmpty();
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getPattern() {
		return pattern;
	}

	@Override
	public String getTypeCSS() {
		return css;
	}

	@Nullable
	@Override
	public String getJsonID() {
		return jsonId;
	}

	@Override
	public int getCreatorID() {
		return creatorId;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public Plugin getAddon() {
		return addon;
	}

	@Override
	public int getID() {
		return id;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("compatible=" + compatible.toString());
		builder.append(",plugins=[");
		plugins.forEach(plugin -> builder.append("[" + plugin.toString() + "]"));
		builder.append("]");
		builder.append(",jsonId=" + jsonId == null ? "" : jsonId);
		builder.append(",addon=" + addon == null ? "" : addon);
		builder.append(",description=" + description);
		builder.append(",creatorId=" + creatorId);
		builder.append(",pattern=" + pattern);
		builder.append(",title=" + title);
		builder.append(",css=" + css);
		builder.append(",id=" + id);
		return builder.toString();
	}

}
