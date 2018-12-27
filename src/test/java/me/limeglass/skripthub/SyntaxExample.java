package me.limeglass.skripthub;

import java.util.Set;

import me.limeglass.skripthub.api.SkriptHub;
import me.limeglass.skripthub.api.objects.Syntax;

public class SyntaxExample {

	public static void execute(SkriptHub instance) {
		
		//Grab all of the syntaxes on SkriptHub.
		Set<Syntax> syntaxes = instance.getSyntaxes();
		
		syntaxes.forEach(syntax -> System.out.println(syntax.toString()));
	}
	
}
