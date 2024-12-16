package com.example.booking_service.service;


import com.example.booking_service.dto.ReservationRequest;
import com.example.booking_service.model.Reservation;
import com.example.booking_service.repository.ReservationRepository;
import com.example.booking_service.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final SeatRepository seatRepository;
    private final MockService mockService;

    public Reservation createReservation(ReservationRequest request) {
        // Mock validation
        mockService.getUserById(request.getUserId());
        mockService.getShowtimeById(request.getShowtimeId());

        // Business logic
        Reservation reservation = new Reservation();
        reservation.setUserId(request.getUserId());
        reservation.setShowtimeId(request.getShowtimeId());
        reservation.setSeatId(request.getSeatId());
        reservation.setStatus(Reservation.Status.PENDING);

        return reservationRepository.save(reservation);
    }
}