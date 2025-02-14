package com.ticket.exception;

@SuppressWarnings("serial")
public class TicketNotFoundException extends RuntimeException {

	public TicketNotFoundException(String message) {
		super(message);
	}

}
