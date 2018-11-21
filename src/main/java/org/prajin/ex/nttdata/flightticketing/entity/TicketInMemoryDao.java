package org.prajin.ex.nttdata.flightticketing.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;

import org.prajin.ex.nttdata.flightticketing.dao.TicketDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * This class and its method are thread safe
 *
 * @author Pradeep Jindal
 */
@Component
public class TicketInMemoryDao implements TicketDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(TicketInMemoryDao.class);

	private final NavigableMap<TicketEntity, TicketEntity> ticketMap = new ConcurrentSkipListMap<>();
    private final AtomicLong ticketCounter;

    public TicketInMemoryDao() {
        ticketCounter = new AtomicLong(0);
    }


	public TicketEntity findTicket(String passportCode, LocalDateTime dateOfJourney) {
		LOGGER.debug("query for ticket: passportCode = {}, dateOfJourney = {}", passportCode);
        //if there are millions of requests per second then creating a new object for each ticket booking is not efficient
        //in this case there are ways to tackle this by re using ThreadLocal copy of same object or more exotically creating pool of reusable objects
		TicketEntity ticketEntity = ticketMap.get(new TicketEntity(passportCode, dateOfJourney));
        LOGGER.debug("query succeed with [{}] result", (ticketEntity==null?0:1));
        return ticketEntity;
	}
	
	public TicketEntity saveTicket(TicketEntity ticketEntity) {
		LOGGER.debug("saving new ticket: {}, total existing tickets = {}", ticketEntity, ticketMap.size());
		if(ticketMap.containsKey(ticketEntity)) {
			throw new RuntimeException("Ticket Already Exist");
		}
		long newTicketNumber = ticketCounter.incrementAndGet();
		    ticketEntity.setTicketNumber(newTicketNumber);
		String newTicketKey = ticketEntity.getDateOfJourney().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
		    ticketEntity.setTicketKey(newTicketKey);
		String newTicketCode = "N" + Long.toString(newTicketNumber) +"D"+ newTicketKey +"P"+ ticketEntity.getPassportCode();
		    ticketEntity.setTicketCode(newTicketCode);
        Object object = ticketMap.putIfAbsent(ticketEntity, ticketEntity);
        if(object != null) {
            throw new RuntimeException("Ticket Already Exist");
        }
		LOGGER.debug("saved: {}, total existing tickets = {}", ticketEntity, ticketMap.size());
		return ticketEntity;
	}

}
