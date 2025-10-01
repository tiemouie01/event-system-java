package com.bookstore.bookstore.model;

import jakarta.persistence.*;
import java.util.List;


import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate date;
    private String location;

    @Column(name="available_seats")
    private int availableSeats;

    @OneToMany
    @JoinColumn(name="event_id")
    private List<Booking> bookings;

    public Event() {
    }

    public Event(String title, String description, LocalDate date, String location, int availableSeats) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
        this.availableSeats = availableSeats;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
