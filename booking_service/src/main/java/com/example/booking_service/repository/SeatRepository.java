package com.example.booking_service.repository;


import com.example.booking_service.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByShowtimeIdAndStatus(Long showtimeId, Seat.Status status);
}

