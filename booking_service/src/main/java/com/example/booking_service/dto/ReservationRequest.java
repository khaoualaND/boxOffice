package com.example.booking_service.dto;


import lombok.Data;

@Data
public class ReservationRequest {
    private Long userId;
    private Long showtimeId;
    private Long seatId;
}
