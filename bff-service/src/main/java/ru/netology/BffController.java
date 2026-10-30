package ru.netology;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/site-bff")
public class BffController {

    private final RestTemplate restTemplate;

    @Value("${user-service.url}")
    private String userServiceUrl;

    @Value("${order-service.url}")
    private String orderServiceUrl;

    public BffController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/user/{userId}")
    public UserProfileDto getUserProfile(@PathVariable Long userId) {
        UserProfileDto.UserDto user = restTemplate.getForObject(
                userServiceUrl + "/" + userId, UserProfileDto.UserDto.class);

        UserProfileDto.OrderDto[] ordersArray = restTemplate.getForObject(
                orderServiceUrl + "/by-user/" + userId, UserProfileDto.OrderDto[].class);

        List<UserProfileDto.OrderDto> orders = ordersArray != null
                ? Arrays.asList(ordersArray)
                : List.of();

        return new UserProfileDto(user, orders);
    }
}