package com.example.user_service.Mapper;

import com.example.user_service.DTO.UserDto;
import com.example.user_service.Entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    // Метод для преобразования User в UserDto
    public UserDto userToUserDto(UserEntity userEntity) {
        if (userEntity == null) {
            return null; // Возвращаем null, если пользователь не найден
        }
        return new UserDto(userEntity.getTelegramId(),
                userEntity.getFirstName(), userEntity.getLastName(),
                userEntity.getUserName(),
                userEntity.getText(),
                userEntity.getPhone());

    }

    // Метод для преобразования UserDto в User
    public UserEntity userDtoToUser(UserDto userDto) {
        if (userDto == null) {
            return null; // Возвращаем null, если UserDto не найден
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setTelegramId(userDto.getTelegramId());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setUserName(userDto.getUserName());
        userEntity.setText(userDto.getText());
        userEntity.setPhone(userDto.getPhone());
        return userEntity; // Возвращаем заполненный User
    }
}
