package com.event_ticketing.service;

import com.event_ticketing.controller.EventController;
import com.event_ticketing.model.Seat;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EventService {

    Logger logger= LoggerFactory.getLogger(EventController.class);


    private final Map<Integer, Seat> seats = new ConcurrentHashMap<>();
    private final AtomicInteger soldCount = new AtomicInteger(0);

    public void initialize() {
        seats.clear();
        soldCount.set(0);
        for (int i = 1; i <= 100; i++) {
            seats.put(i, new Seat(i));
        }
    }

    public Collection<Seat> getSeats() {
        return seats.values();
    }

    public synchronized int bookSeats(List<Integer> seatIds, String user) {

        // 1. Validate all seats first
        if (seats.isEmpty()) {
            throw new RuntimeException("Event not initialized");
        }

        // 1. Validate seat IDs and availability
        for (int id : seatIds) {
            if (id < 1 || id > seats.size()) {
                throw new RuntimeException("Invalid seat id: " + id);
            }

            Seat seat = seats.get(id - 1);
            if (seat == null || seat.isBooked()) {
                throw new RuntimeException("Seat " + id + " already booked");
            }
        }

        // 2. Calculate price based on booking order
        int price = 0;
        int startTicketNumber = soldCount.get();

        for (int i = 0; i < seatIds.size(); i++) {
            int ticketNumber = startTicketNumber + i + 1;
            price += ticketPrice(ticketNumber);
            logger.info("selected seat price:::{}",price);
        }

        // 3. Book seats and update soldCount
        for (int id : seatIds) {
            Seat seat = seats.get(id - 1);
            seat.setBooked(true);
            seat.setBookedBy(user);
            soldCount.incrementAndGet();
        }

        return price;
    }


    private int ticketPrice(int ticketNumber) {
        if (ticketNumber <= 50) {
            return 50;
        } else if (ticketNumber <= 80) {
            return 75;
        } else if (ticketNumber <= 100) {
            return 100;
        } else {
            throw new RuntimeException("Event sold out");
        }
    }
}
