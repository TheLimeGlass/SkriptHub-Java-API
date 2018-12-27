package me.limeglass.skripthub.internals;

import java.io.IOException;
import java.util.Optional;

public class SkriptHubOptional<T> {

	private final Optional<T> optional;
	private IOException exception;
	
	public SkriptHubOptional() {
		this.optional = Optional.empty();
	}
	
	public SkriptHubOptional(Optional<T> optional) {
		this.optional = optional;
	}
	
	public SkriptHubOptional(IOException exception) {
		this.optional = Optional.empty();
		this.exception = exception;
	}

	public void setException(IOException exception) {
		this.exception = exception;
	}
	
	public IOException getException() {
		return exception;
	}
	
	public Optional<T> getOptional() {
		return optional;
	}
	
	public boolean isPresent() {
		return optional.isPresent();
	}
	
	public boolean hasError() {
		return exception != null;
	}
	
	public T get() {
		return optional.get();
	}

}
