package com.event_ticketing.controller;

import com.event_ticketing.model.BookingRequest;
import com.event_ticketing.model.Seat;
import com.event_ticketing.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EventController {

    Logger logger= LoggerFactory.getLogger(EventController.class);

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping("/initialize")
    public void initialize() {
        logger.info("initialize the seats");
        service.initialize();
    }

    @GetMapping("/seats")
    public Collection<Seat> seats() {
        logger.info("Number of seats");
        return service.getSeats();
    }

    @PostMapping("/book")
    public Map<String, Object> book(@RequestBody BookingRequest req) {
        logger.info("Booking Process");
        int total = service.bookSeats(req.getSeatIds(), req.getUserName());
        logger.info("SeatID::" +req.getSeatIds()+"Price::::"+total);
        return Map.of("totalPrice", total);
    }
}
