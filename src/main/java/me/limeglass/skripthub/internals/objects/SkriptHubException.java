package me.limeglass.skripthub.internals.objects;

public class SkriptHubException extends RuntimeException {

	private static final long serialVersionUID = -8013093035778965879L;
	private String message;

	public SkriptHubException(String message) {
		super(message);
		this.message = message;
	}

	public SkriptHubException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	/**
	 * Gets the error message.
	 *
	 * @return The error message.
	 */
	public String getErrorMessage() {
		return message;
	}

}
