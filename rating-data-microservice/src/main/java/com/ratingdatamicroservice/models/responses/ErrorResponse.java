package com.ratingdatamicroservice.models.responses;

import java.util.Date;

public class ErrorResponse {
	private Date timeStamp;
	private String errorMessage;
	
	public ErrorResponse() {
		super();
	}

	public ErrorResponse(Date timeStamp, String errorMessage) {
		super();
		this.timeStamp = timeStamp;
		this.errorMessage = errorMessage;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
