package org.prajin.ex.nttdata.flightticketing.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


/*
 * {
	"Fname" : "Pradeep",
	"LName" : "Jindal",
	"Passport" : "AFGHIJK",
	"DOJ" : "2018-12-21T22:10"
}
*/


public class TicketRequestDto {

    @JsonProperty("Fname")
    @NotNull(message = "First Name can not be null")
    @NotEmpty(message = "First Name can not be empty")
    @NotBlank(message = "First Name can not be blank")
    private String firstName;

    @JsonProperty("LName")
    @NotNull(message = "Last Name can not be null")
    @NotEmpty(message = "Last Name can not be empty")
    @NotBlank(message = "Last Name can not be blank")
    private String lastName;

    @JsonProperty("Passport")
    @NotNull(message = "Passport Id can not be null")
    @NotEmpty(message = "Passport Id can not be empty")
    @NotBlank(message = "Passport Id can not be blank")
    private String passportCode;

    @JsonProperty("DOJ")
    @NotNull(message = "Date of Journey can not be null")
    //@NotEmpty(message = "Date of Journey can not be empty")
    private LocalDateTime dateOfJourney;


    @Override
    public String toString() {
        return "TicketDto [firstName=" + firstName
                + ", lastName=" + lastName
                + ", passportCode=" + passportCode
                + ", dateOfJourney=" + dateOfJourney
                + "]";
    }

    //here regex pattern should filter out all the non alphabatic characters
    public void trim() {
        firstName = firstName.trim();
        lastName = lastName.trim();
        passportCode = passportCode.trim();
    }


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
