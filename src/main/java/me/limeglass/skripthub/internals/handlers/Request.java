package me.limeglass.skripthub.internals.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.stream.JsonReader;

import me.limeglass.skripthub.api.SkriptHub;
import me.limeglass.skripthub.internals.SkriptHubOptional;
import me.limeglass.skripthub.internals.dummy.Response;

public class Request {

	/**
	 * Represents the URL request method operation.
	 */
	public enum HttpMethod {
		GET,
		PUT,
		POST,
		HEAD,
		TRACE,
		DELETE,
		OPTIONS
	}
	
	/**
	 * Used internally.
	 */
	private static HttpURLConnection getConnection(SkriptHub instance, HttpMethod method, String url) throws IOException {
		URL request = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) request.openConnection();
		connection.setRequestProperty("Authorization", "Token " + instance.getToken());
		connection.setConnectTimeout(instance.getTimeout());
		connection.setRequestMethod(method.name());
		connection.setDoOutput(true);
		return connection;
	}
	
	/**
	 * Makes a request to StreamElements.
	 * 
	 * @param <T>
	 * @parm timeout The connection timeout of the request.
	 * @param predicted The predicted ElementsResponse return.
	 * @param method The URL request method (Contained within this class).
	 * @param url The formatted URL to request to.
	 * @return The predicted response as a List.
	 */
	public static <T extends Response> List<SkriptHubOptional<T>> makeRequest(SkriptHub instance, Class<T> predicted, HttpMethod method, String url) {
		return streamRequest(instance, predicted, method, url).collect(Collectors.toList());
	}
	
	/**
	 * Return a Stream of a request to StreamElements.
	 * 
	 * @param <T>
	 * @parm timeout The connection timeout of the request.
	 * @param predicted The predicted ElementsResponse return.
	 * @param method The URL request method (Contained within this class).
	 * @param url The formatted URL to request to.
	 * @return The predicted response. Only returns a valid response for GET HttpMethod calling.
	 */
	public static <T extends Response> Stream<SkriptHubOptional<T>> streamRequest(SkriptHub instance, Class<T> predicted, HttpMethod method, String url) {
		try {
			HttpURLConnection connection = getConnection(instance, method, url);
			if (method != HttpMethod.GET) {
				OutputStreamWriter output = new OutputStreamWriter(connection.getOutputStream());
				try {
					return UploaderHandler.handle(method, url, output, predicted);
				} finally {
					output.close();
					//TODO Handle this with the error messages.
					connection.getResponseCode();
				}
			} else {
				InputStream input = connection.getInputStream();
				JsonReader reader = new JsonReader(new InputStreamReader(input, "UTF-8"));
				try {
					return ReaderHandler.streamPredicted(reader, predicted);
				} finally {
					reader.close();
					input.close();
				}
			}
		} catch (IOException e) {
			return Stream.of(new SkriptHubOptional<T>(e));
		}
	}

}
