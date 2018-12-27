package me.limeglass.skripthub.api;

import me.limeglass.skripthub.internals.SkriptHubClient;
import me.limeglass.skripthub.internals.objects.SkriptHubException;

public final class SkriptHubBuilder {

	private int timeout = 20 * 1000;
	private String token;
	
	/**
	 * For those whom love keeping clean methods per line.
	 * 
	 * This requires that you set the token within the method though.
	 * The building process will error when finishing if these values are not set.
	 */
	public SkriptHubBuilder() {}
	
	/**
	 * The SkriptHubBuilder Constructor
	 * 
	 * @param token The token used from SkriptHub.
	 */
	public SkriptHubBuilder(String token) {
		this.token = token;
	}
	
	/**
	 * Set the connection timeout of the client.
	 */
	public SkriptHubBuilder withConnectionTimeout(int timeout) {
		this.timeout = timeout;
		return this;
	}

	/**
	 * Set the token of the SkriptHubBuilder.
	 */
	public SkriptHubBuilder withToken(String token) {
		this.token = token;
		return this;
	}

	/**
	 * @return The SkriptHub token of the client.
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * @return The timeout defined by the client.
	 */
	public int getTimeout() {
		return timeout;
	}
	
	public SkriptHub build() {
		if (token == null)
			throw new SkriptHubException("The SkriptHub token was not set!");
		return new SkriptHubClient(token, timeout);
	}

}
