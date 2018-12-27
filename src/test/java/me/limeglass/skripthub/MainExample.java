package me.limeglass.skripthub;

import java.io.File;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import me.limeglass.skripthub.api.SkriptHub;
import me.limeglass.skripthub.api.SkriptHubBuilder;

public class MainExample {
	
	private static PropertiesConfiguration config;
	private static SkriptHub instance;
	
	public static void main(String[] args) {
		try {
			config = new Configurations().properties(new File("config.properties"));
		}
		catch (ConfigurationException exception) {}
		
		//alternative constructor if you please.
		//instance = new SkriptHubBuilder(config.getString("client.token")).build();
		instance = new SkriptHubBuilder()
				.withToken(config.getString("client.token"))
				.withConnectionTimeout(10000)
				.build();
		
		AddonsExample.execute(instance);
		SyntaxExample.execute(instance);
	}

	public static SkriptHub getSkriptHub() {
		return instance;
	}

}
