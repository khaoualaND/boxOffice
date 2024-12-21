package cinema.showtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EntityScan(basePackages = "cinema.showtime.model")
public class ShowtimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowtimeApplication.class, args);
    }

}
