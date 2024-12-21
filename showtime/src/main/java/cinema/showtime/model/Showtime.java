package cinema.showtime.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long movieId;
    private Long theaterId;
    private LocalDateTime showtime;
    private String location;

    @Enumerated(EnumType.STRING) // Store ENUM as a string in the database
    private Status status;

    public enum Status {
        SCHEDULED, CANCELLED
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }

    public LocalDateTime getShowtime() {
        return showtime;
    }

    public void setShowtime(LocalDateTime showtime) {
        this.showtime = showtime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
