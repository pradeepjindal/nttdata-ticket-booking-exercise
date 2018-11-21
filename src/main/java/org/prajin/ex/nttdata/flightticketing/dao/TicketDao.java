package org.prajin.ex.nttdata.flightticketing.dao;

import org.prajin.ex.nttdata.flightticketing.entity.TicketEntity;

import java.time.LocalDateTime;
import java.util.Map;

public interface TicketDao {
    TicketEntity findTicket(String passportCode, LocalDateTime dateOfJourney);
    TicketEntity saveTicket(TicketEntity ticketEntity);
}
