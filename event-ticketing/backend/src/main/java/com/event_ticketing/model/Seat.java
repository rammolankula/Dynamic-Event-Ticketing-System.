package com.event_ticketing.model;


public class Seat {
    private int id;
    private boolean booked;
    private String bookedBy;

    public Seat(int id) {
        this.id = id;
        this.booked = false;
    }

    public int getId() {
        return id;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public boolean isBooked() {
        return booked;
    }
// getters & setters

    public void setId(int id) {
        this.id = id;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }
}
