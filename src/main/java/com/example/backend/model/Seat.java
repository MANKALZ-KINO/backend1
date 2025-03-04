package com.example.backend.model;

import jakarta.persistence.*;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;
    private int seatNumb;
    private int rowNum;


    @ManyToOne
    @JoinColumn(name = "theater_id", referencedColumnName = "theaterId", nullable = false)
    private Theater theater;


    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public int getSeatNumb() {
        return seatNumb;
    }


    public void setSeatNumb(int seatNumb) {
        this.seatNumb = seatNumb;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
