package me.limeglass.skripthub.internals.objects;

import java.util.Set;

import org.eclipse.jdt.annotation.Nullable;

import me.limeglass.skripthub.api.objects.CompatibleVersion;
import me.limeglass.skripthub.api.objects.Expression;
import me.limeglass.skripthub.api.objects.Plugin;

public class ExpressionImp extends SyntaxImp implements Expression {
	
	private final String returnType;
	
	public ExpressionImp(String description, CompatibleVersion compatible, Set<Plugin> plugins, int creatorId, String pattern, String jsonId, String title, Plugin addon, String css, int id, String returnType) {
		super(description, compatible, plugins, creatorId, pattern, jsonId, title, addon, css, id);
		this.returnType = returnType;
	}

	@Nullable
	@Override
	public String getReturnType() {
		return returnType;
	}

	@Override
	public Type getSyntaxType() {
		return Type.EXPRESSION;
	}

}
