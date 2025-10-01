package com.event.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="booking_date")
    private LocalDate bookingDate;

    @Column(name="number_of_tickets")
    private int numberOfTickets;

    public Booking() {
    }

    public Booking(LocalDate bookingDate, int numberOfTickets) {
        this.bookingDate = bookingDate;
        this.numberOfTickets = numberOfTickets;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
