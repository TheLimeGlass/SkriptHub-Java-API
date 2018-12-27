package me.limeglass.skripthub.internals.objects;

import java.util.Set;

import org.eclipse.jdt.annotation.Nullable;

import me.limeglass.skripthub.api.objects.CompatibleVersion;
import me.limeglass.skripthub.api.objects.Plugin;

public class TypeImp extends SyntaxImp implements me.limeglass.skripthub.api.objects.Type {
	
	private final String usage;
	
	public TypeImp(String description, CompatibleVersion compatible, Set<Plugin> plugins, int creatorId, String pattern, String jsonId, String title, Plugin addon, String css, int id, String usage) {
		super(description, compatible, plugins, creatorId, pattern, jsonId, title, addon, css, id);
		this.usage = usage;
	}
	
	@Override
	public Type getSyntaxType() {
		return Type.TYPE;
	}

	@Nullable
	@Override
	public String getUsage() {
		return usage;
	}

}
