package com.example.user_service.code;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    User updateUserFromDto(UserDto userDto, @MappingTarget User existingUser);
}
