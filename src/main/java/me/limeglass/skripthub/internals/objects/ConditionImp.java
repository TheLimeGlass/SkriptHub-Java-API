package me.limeglass.skripthub.internals.objects;

import java.util.Set;

import me.limeglass.skripthub.api.objects.CompatibleVersion;
import me.limeglass.skripthub.api.objects.Condition;
import me.limeglass.skripthub.api.objects.Plugin;

public class ConditionImp extends SyntaxImp implements Condition {
	
	public ConditionImp(String description, CompatibleVersion compatible, Set<Plugin> plugins, int creatorId, String pattern, String jsonId, String title, Plugin addon, String css, int id) {
		super(description, compatible, plugins, creatorId, pattern, jsonId, title, addon, css, id);
	}

	@Override
	public Type getSyntaxType() {
		return Type.CONDITION;
	}

}
