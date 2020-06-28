package com.usermicroservice.models.responses;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
	
	private static final long serialVersionUID = -5713163838025456305L;
	
	private final String jwt;

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

    public String getJwt() {
        return jwt;
    }

	@Override
	public String toString() {
		return "AuthenticationResponse [jwt=" + jwt + "]";
	}
}