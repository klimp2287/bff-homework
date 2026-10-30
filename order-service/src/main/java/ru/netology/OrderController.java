package ru.netology;

import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final Map<Long, List<Order>> ordersByUser = Map.of(
            1L, List.of(
                    new Order(101L, 1L, new BigDecimal("1500.00"), "RUB", List.of("Книга", "Ручка")),
                    new Order(102L, 1L, new BigDecimal("300.00"), "RUB", List.of("Тетрадь"))
            ),
            2L, List.of(
                    new Order(201L, 2L, new BigDecimal("5000.00"), "RUB", List.of("Наушники"))
            )
    );

    @GetMapping("/by-user/{user}")
    public List<Order> getOrdersByUser(@PathVariable Long user) {
        return ordersByUser.getOrDefault(user, List.of());
    }
}