package cinema.showtime.dto;

import java.time.LocalDateTime;

public class ShowtimeRequest {

    private Long userId;
    private Long movieId;
    private Long theaterId;
    private LocalDateTime showtime;
    private String location;

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}

