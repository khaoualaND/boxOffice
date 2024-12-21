package cinema.showtime.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8080")
public interface UserServiceFeignClient {

    @GetMapping("/users/{id}/role")
    String getUserRole(@PathVariable("id") Long userId);
}