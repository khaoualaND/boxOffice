package cinema.showtime.repository;

import cinema.showtime.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    List<Showtime> findByMovieIdAndStatus(Long movieId, Showtime.Status status);
}

