package cinema.showtime.service;

import cinema.showtime.client.MovieServiceFeignClient;
import cinema.showtime.client.UserServiceClient;
import cinema.showtime.dto.ShowtimeRequest;
import cinema.showtime.model.Showtime;
import cinema.showtime.repository.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final UserServiceClient userServiceClient;
    private final MovieServiceFeignClient movieServiceFeignClient;

    @PreAuthorize("hasRole('ADMIN')")
    public Showtime createShowtime(ShowtimeRequest request) throws IOException {
        String userRole = userServiceClient.getUserRole(request.getUserId());
        if (!"ADMIN".equalsIgnoreCase(userRole)) {
            throw new RuntimeException("You do not have the required role to create a showtime.");
        }

        MovieServiceFeignClient.MovieDetails movieDetails = movieServiceFeignClient.getMovieDetails(request.getMovieId());
        if (movieDetails == null) {
            throw new RuntimeException("Movie not found.");
        }

        List<Showtime> existingShowtimes = showtimeRepository.findByMovieIdAndStatus(request.getMovieId(), Showtime.Status.SCHEDULED);
        for (Showtime existingShowtime : existingShowtimes) {
            if (existingShowtime.getTheaterId().equals(request.getTheaterId()) && isOverlapping(existingShowtime.getShowtime(), request.getShowtime())) {
                throw new RuntimeException("Conflict detected: Overlapping showtimes.");
            }
        }

        Showtime showtime = new Showtime();
        showtime.setMovieId(request.getMovieId());
        showtime.setTheaterId(request.getTheaterId());
        showtime.setShowtime(request.getShowtime());
        showtime.setLocation(request.getLocation());
        showtime.setStatus(Showtime.Status.SCHEDULED);

        return showtimeRepository.save(showtime);
    }

    private boolean isOverlapping(LocalDateTime existingTime, LocalDateTime newTime) {
        return !existingTime.isAfter(newTime.plusHours(2)) && !newTime.isAfter(existingTime.plusHours(2));
    }

    public List<Showtime> getShowtimesForMovie(Long movieId) {
        return showtimeRepository.findByMovieIdAndStatus(movieId, Showtime.Status.SCHEDULED);
    }
}