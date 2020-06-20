package com.ratingdatamicroservice.models.response;

import java.util.Date;

public class ErrorResponse {
	private Date date;
	private String errorMessage;
	
	public ErrorResponse() {
		super();
	}

	public ErrorResponse(Date date, String errorMessage) {
		super();
		this.date = date;
		this.errorMessage = errorMessage;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
