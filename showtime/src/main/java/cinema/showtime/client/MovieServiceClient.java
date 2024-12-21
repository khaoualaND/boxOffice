package cinema.showtime.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieServiceClient {

    private final MovieServiceFeignClient movieServiceFeignClient;

    @Autowired
    public MovieServiceClient(MovieServiceFeignClient movieServiceFeignClient) {
        this.movieServiceFeignClient = movieServiceFeignClient;
    }

    public MovieServiceFeignClient.MovieDetails getMovieDetails(Long movieId) {
        return movieServiceFeignClient.getMovieDetails(movieId);
    }
}