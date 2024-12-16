package com.example.booking_service.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long showtimeId;
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        AVAILABLE, UNAVAILABLE, LOCKED
    }
}
