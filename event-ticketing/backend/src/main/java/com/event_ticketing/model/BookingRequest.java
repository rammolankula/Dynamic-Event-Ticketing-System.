package com.event_ticketing.model;

import java.util.List;

public class BookingRequest {
    private List<Integer> seatIds;
    private String userName;

    public void setSeatIds(List<Integer> seatIds) {
        this.seatIds = seatIds;
    }

    public List<Integer> getSeatIds() {
        return seatIds;
    }

    public String getUserName() {
        return userName;
    }
// getters & setters
}
