package org.prajin.ex.nttdata.flightticketing.service;

import org.prajin.ex.nttdata.flightticketing.entity.TicketEntity;
import org.prajin.ex.nttdata.flightticketing.model.TicketDto;
import org.prajin.ex.nttdata.flightticketing.model.TicketRequestDto;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketService {
    TicketDto createTicket(TicketRequestDto requestDto);
}
