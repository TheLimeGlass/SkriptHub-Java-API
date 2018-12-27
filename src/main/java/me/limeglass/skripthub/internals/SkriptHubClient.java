package me.limeglass.skripthub.internals;

import java.util.Set;
import me.limeglass.skripthub.api.SkriptHub;
import me.limeglass.skripthub.api.objects.Addon;
import me.limeglass.skripthub.api.objects.Syntax;
import me.limeglass.skripthub.internals.handlers.ReaderHandler;
import me.limeglass.skripthub.internals.handlers.Request;
import me.limeglass.skripthub.internals.handlers.Request.HttpMethod;
import me.limeglass.skripthub.internals.responses.AddonsResponse;
import me.limeglass.skripthub.internals.responses.SyntaxResponse;

public class SkriptHubClient implements SkriptHub {
	
	private final String token;
	private final int timeout;
	
	/**
	 * The SkriptHubClient Constructor
	 * 
	 * @param token The token used from SkriptHub.
	 * @param timeout Max time in milliseconds it takes before timeout on request.
	 */
	public SkriptHubClient(String token, int timeout) {
		ReaderHandler.load("me.limeglass.skripthub.internals.readers");
		this.timeout = timeout;
		this.token = token;
	}
	
	/**
	 * @return The token of the client.
	 */
	@Override
	public String getToken() {
		return token;
	}

	/**
	 * @return The timeout defined by the client.
	 */
	@Override
	public int getTimeout() {
		return timeout;
	}

	/**
	 * @return Grab all addons on SkriptHub.
	 */
	@Override
	public Set<Addon> getAddons() {
		return Request.streamRequest(this, AddonsResponse.class, HttpMethod.GET, Endpoints.ADDON_LIST)
				.filter(optional -> optional.isPresent())
				.map(optional -> optional.get().getAddons())
				.findFirst().get();
	}
	
	/**
	 * @return Grab all syntaxes on SkriptHub.
	 */
	@Override
	public Set<Syntax> getSyntaxes() {
		return Request.streamRequest(this, SyntaxResponse.class, HttpMethod.GET, Endpoints.SYNTAX_LIST)
				.filter(optional -> optional.isPresent())
				.map(optional -> optional.get().getSyntaxes())
				.findFirst().get();
	}

}
