package cinema.showtime.controller;

import cinema.showtime.dto.ShowtimeRequest;
import cinema.showtime.model.Showtime;
import cinema.showtime.service.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    @PostMapping("/create")
    public Showtime createShowtime(@RequestBody ShowtimeRequest request) throws IOException {
        return showtimeService.createShowtime(request);
    }

    @GetMapping("/movie/{movieId}")
    public List<Showtime> getShowtimesForMovie(@PathVariable Long movieId) {
        return showtimeService.getShowtimesForMovie(movieId);
    }
}

