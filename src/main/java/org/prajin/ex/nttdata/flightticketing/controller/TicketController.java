package org.prajin.ex.nttdata.flightticketing.controller;

import javax.validation.Valid;

import org.prajin.ex.nttdata.flightticketing.entity.TicketEntity;
import org.prajin.ex.nttdata.flightticketing.model.ResponseDto;
import org.prajin.ex.nttdata.flightticketing.model.TicketDto;
import org.prajin.ex.nttdata.flightticketing.model.TicketRequestDto;
import org.prajin.ex.nttdata.flightticketing.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


//1.       User will sent passenger details ( Fname,LName,Passport,DOJ)
//2.       System validate these details (e.g. NULL & EMPTY values)
//3.       Check whether travel details are already  available for supplied date + passport
//4.       If not then create travel ticket and return response ( ticketId,PassportNumber)

/**
 *
 * @author Pradeep Jindal
 */
@RestController("/")
public class TicketController {
    private static Logger LOGGER = LoggerFactory.getLogger(TicketController.class);
    
    @Autowired
    private TicketService ticketService;
    
	@PostMapping(path = "/book", consumes = "application/json", produces = "application/json")
    public ResponseDto bookTicket(@Valid @RequestBody TicketRequestDto requestDto) {
	    //design choice, in place code preferred in place of central exception handling
	    try {
            LOGGER.info("ticket booking request: {}", requestDto);
            requestDto.trim();
            TicketDto result = ticketService.createTicket(requestDto);
            LOGGER.info("ticket booked: {}", result);
            return new ResponseDto("success", "", result);
        } catch(Exception ex) {
	        LOGGER.warn("Could not book ticket: {}", ex);
        }
        //design choice, for frontend, template response is preferred while for external api and standard http code response is official choice
        return new ResponseDto<TicketRequestDto>("failed", "could not process request, some error at server side", requestDto);
    }

}
