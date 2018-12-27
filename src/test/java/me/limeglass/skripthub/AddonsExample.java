package me.limeglass.skripthub;

import java.util.Set;

import me.limeglass.skripthub.api.SkriptHub;
import me.limeglass.skripthub.api.objects.Addon;

public class AddonsExample {

	public static void execute(SkriptHub instance) {
		
		//Grab the Addons instance.
		Set<Addon> addons = instance.getAddons();
		
		addons.forEach(addon -> System.out.println(addon.toString()));
	}
	
}
