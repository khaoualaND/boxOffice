package cinema.showtime.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceClient {

    private final UserServiceFeignClient userServiceFeignClient;

    @Autowired
    public UserServiceClient(UserServiceFeignClient userServiceFeignClient) {
        this.userServiceFeignClient = userServiceFeignClient;
    }

    public String getUserRole(Long userId) {
        return userServiceFeignClient.getUserRole(userId);
    }
}