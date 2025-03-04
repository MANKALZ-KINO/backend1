package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity

public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketID;
    private LocalDate order_date;
    private double ticket_price;
    private int seatID;
    private int phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id", referencedColumnName = "seatId")
    @JsonBackReference
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "movieplan_id", nullable = false)
    @JsonBackReference
    private MoviePlan moviePlan;

    public MoviePlan getMoviePlan() {
        return moviePlan;
    }

    public void setMoviePlan(MoviePlan moviePlan) {
        this.moviePlan = moviePlan;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
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
