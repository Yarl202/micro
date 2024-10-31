package com.example.user_service;

import com.example.user_service.code.User;
import com.example.user_service.code.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    void updateUserFromDto(UserDto userDto, @MappingTarget User existingUser);
}
