package com.example.user_service.code;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    // Метод для преобразования User в UserDto
    public UserDto userToUserDto(User user) {
        if (user == null) {
            return null; // Возвращаем null, если пользователь не найден
        }
        return new UserDto(user.getTelegramId(),
                user.getFirstName(), user.getLastName(),
                user.getUserName(),
                user.getText(),
                user.getPhone());

    }

    // Метод для преобразования UserDto в User
    public User userDtoToUser(UserDto userDto) {
        if (userDto == null) {
            return null; // Возвращаем null, если UserDto не найден
        }
        User user = new User();
        user.setTelegramId(userDto.getTelegramId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUserName(userDto.getUserName());
        user.setText(userDto.getText());
        user.setPhone(userDto.getPhone());
        return user; // Возвращаем заполненный User
    }
}
