package me.limeglass.skripthub.internals.responses;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

import me.limeglass.skripthub.api.objects.Syntax;
import me.limeglass.skripthub.internals.dummy.Response;

public class SyntaxResponse extends Response {
	
	private final Set<Syntax> syntaxes = new HashSet<>();
	
	public SyntaxResponse(Syntax... syntaxes) {
		this.syntaxes.addAll(Sets.newHashSet(syntaxes));
	}
	
	/**
	 * @return The syntaxes for the request.
	 */
	public Set<Syntax> getSyntaxes() {
		return syntaxes;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		syntaxes.forEach(syntax -> builder.append(syntax.toString()));
		return builder.toString();
	}

}
