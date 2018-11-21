package org.prajin.ex.nttdata.flightticketing.entity;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

//@Entity
public class TicketEntity implements Comparable {

    //private static final AtomicLong ticketCounter = new AtomicLong();

    private long pk;
    private long ticketNumber; // unique, not null
    private String ticketKey;
    private String ticketCode;
    private String passportCode;
    private LocalDateTime dateOfJourney;
    private String firstName;
    private String lastName;


    public TicketEntity(String passportCode, LocalDateTime dateOfJourney) {
        this(passportCode, dateOfJourney, null, null);
    }

    public TicketEntity(String passportCode, LocalDateTime dateOfJourney, String firstName, String lastName) {
        this.passportCode = passportCode;
        this.dateOfJourney = dateOfJourney;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Object o) {
        if(this == o || null == o) {
            return 0;
        }
        TicketEntity ticketEntity = (TicketEntity) o;
        if(null == ticketEntity.dateOfJourney && null != this.dateOfJourney) {
            return 1;
        } else if(null != ticketEntity.dateOfJourney && null == this.dateOfJourney) {
            return -1;
        }
        if(this.dateOfJourney.compareTo(ticketEntity.dateOfJourney) == 0) {
            //return this.passportCode.compareTo(ticketEntity.passportCode);
            if(null == ticketEntity.passportCode && null != ticketEntity.passportCode) {
                return 1;
            } else if(null != ticketEntity.passportCode && null == ticketEntity.passportCode) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return this.dateOfJourney.compareTo(ticketEntity.dateOfJourney);
        }
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "ticketNumber=" + ticketNumber +
                ", ticketCode='" + ticketCode + '\'' +
                ", passportCode='" + passportCode + '\'' +
                ", dateOfJourney=" + dateOfJourney +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public long getPk() {
        return pk;
    }

    public long getTicketNumber() {
        return ticketNumber;
    }

    void setTicketNumber(long ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketKey() {
        return ticketKey;
    }

    void setTicketKey(String ticketKey) {
        this.ticketKey = ticketKey;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getPassportCode() {
        return passportCode;
    }

    public LocalDateTime getDateOfJourney() {
        return dateOfJourney;
    }

    //public fields, can be changed anytime by dao as well as service
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
