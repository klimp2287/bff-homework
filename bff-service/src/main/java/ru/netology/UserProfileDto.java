package ru.netology;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDto {
    private UserDto user;
    private List<OrderDto> orders;

    @Setter
    @Getter
    public static class UserDto {
        private Long id;
        private String fullName;
        private String deliveryAddress;
        private String phone;
        private String email;
    }

    @Setter
    @Getter
    public static class OrderDto {
        private Long id;
        private BigDecimal amount;
        private String currency;
        private List<String> items;
    }
}