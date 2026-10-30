package ru.netology;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final Map<Long, User> users = Map.of(
            1L, new User(1L, "Иван Иванов", "ул. Ленина, 1", "+79990001122", "ivan@example.com"),
            2L, new User(2L, "Пётр Петров", "ул. Мира, 5", "+79993334455", "petr@example.com")
    );

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        return users.get(userId);
    }
}