package org.prajin.ex.nttdata.flightticketing.service;

import org.prajin.ex.nttdata.flightticketing.dao.TicketDao;
import org.prajin.ex.nttdata.flightticketing.entity.TicketEntity;
import org.prajin.ex.nttdata.flightticketing.model.TicketDto;
import org.prajin.ex.nttdata.flightticketing.model.TicketRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Pradeep Jindal
 */
@Service
public class TicketServiceImpl implements TicketService {
    private static Logger LOGGER = LoggerFactory.getLogger(TicketServiceImpl.class);
	
    @Autowired
    TicketDao ticketDao;
	
    public TicketDto createTicket(TicketRequestDto requestDto) {
        TicketEntity ticketEntity = ticketDao.findTicket(requestDto.getPassportCode(), requestDto.getDateOfJourney());
        //
        if(ticketEntity == null) {
            LOGGER.debug("no existing ticket found, creating new");
            ticketEntity = ticketDao.saveTicket(
                    new TicketEntity(requestDto.getPassportCode(),
                            requestDto.getDateOfJourney(),
                            requestDto.getFirstName(),
                            requestDto.getLastName())
            );
            return new TicketDto(ticketEntity.getTicketCode(), ticketEntity.getPassportCode(), ticketEntity.getDateOfJourney());
        } else {
            LOGGER.debug("ticket already exist, using it");
            return new TicketDto(ticketEntity.getTicketCode(), ticketEntity.getPassportCode(), ticketEntity.getDateOfJourney());
        }
    }

}
