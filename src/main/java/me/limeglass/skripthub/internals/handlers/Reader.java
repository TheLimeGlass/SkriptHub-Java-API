package me.limeglass.skripthub.internals.handlers;

import java.io.IOException;
import java.io.OutputStreamWriter;

import com.google.gson.stream.JsonReader;

import me.limeglass.skripthub.internals.SkriptHubOptional;
import me.limeglass.skripthub.internals.dummy.Response;
import me.limeglass.skripthub.internals.handlers.Request.HttpMethod;

public abstract class Reader<T extends Response> {
	
	/**
	 * Grabs the wanted ElementsResponse from the ElementReader.
	 * 
	 * @return Read the current ElementsResponse.
	 */
	protected abstract SkriptHubOptional<T> read(JsonReader reader);
	
	/**
	 * Checks if the reader can accept other HttpMethods besides get.
	 * Override this method along with the `execute` method to add support.
	 * 
	 * @return Boolean if the reader accepted the HttpMethod.
	 */
	protected boolean acceptMethod(HttpMethod method) {
		return false;
	}
	
	/**
	 * Triggers the execute method of the reader, after checking if the acceptMethod method returned true.
	 * If you write to the OutputStreamWriter make sure you flush, gross.
	 */
	protected SkriptHubOptional<T> update(HttpMethod method, String url, OutputStreamWriter output) {
		return new SkriptHubOptional<T>();
	}

	/**
	 * Prime the JsonReader up to the defined named value.
	 */
	protected JsonReader prime(String prime, JsonReader reader) throws IOException {
		while (reader.hasNext())
			if (reader.nextName().equalsIgnoreCase(prime)) break;
		return reader;
	}

}
