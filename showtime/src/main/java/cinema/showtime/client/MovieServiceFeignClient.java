package cinema.showtime.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie-service", url = "http://localhost:8080")
public interface MovieServiceFeignClient {

    @GetMapping("/movies/{id}")
    MovieDetails getMovieDetails(@PathVariable("id") Long movieId);

    class MovieDetails {
        private Long id;
        private String title;
        private String genre;
        private String synopsis;

        // Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public String getSynopsis() {
            return synopsis;
        }

        public void setSynopsis(String synopsis) {
            this.synopsis = synopsis;
        }
    }
}