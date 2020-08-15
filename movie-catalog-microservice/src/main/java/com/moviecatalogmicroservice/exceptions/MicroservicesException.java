package com.moviecatalogmicroservice.exceptions;

public class MicroservicesException extends RuntimeException {

	private static final long serialVersionUID = 277167830820375164L;

	public MicroservicesException(String exception) {
	    super(exception);
	}
}