package org.prajin.ex.nttdata.flightticketing.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class TicketDto {

	@JsonProperty("ticketId")
	private String ticketCode;

	@JsonProperty("passportId")
	private String passportCode;

	@JsonProperty("DOJ")
	//@JsonIgnore
	private LocalDateTime dateOfJourney;

	public TicketDto(String ticketCode, String passportCode, LocalDateTime dateOfJourney) {
		this.ticketCode = ticketCode;
		this.passportCode = passportCode;
		this.dateOfJourney = dateOfJourney;
	}


	@Override
	public String toString() {
		return "TicketDto{" +
				"ticketCode='" + ticketCode + '\'' +
				", passportCode='" + passportCode + '\'' +
				", dateOfJourney=" + dateOfJourney +
				'}';
	}


	public String getTicketCode() {
		return ticketCode;
	}

	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}

	public String getPassportCode() {
		return passportCode;
	}

	public void setPassportCode(String passportCode) {
		this.passportCode = passportCode;
	}

	public LocalDateTime getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDateTime dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

}
