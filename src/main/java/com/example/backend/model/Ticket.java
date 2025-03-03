package com.example.backend.model;

import jakarta.persistence.*;

@Entity

public class Ticket {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int ticketID;
    private int order_date;
    private double ticket_price;
    private int seatID;
    private int phoneNumber;

    @OneToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "seatId", nullable = false)
    private Seat seat;

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getOrder_date() {
        return order_date;
    }

    public void setOrder_date(int order_date) {
        this.order_date = order_date;
    }

    public double getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(double ticket_price) {
        this.ticket_price = ticket_price;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
