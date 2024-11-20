package com.example.user_service.service;

import com.example.user_service.mapper.UserMapper;
import com.example.user_service.entity.UserEntity;
import com.example.user_service.DTO.UserDto;
import com.example.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
//    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper mapper, UserRepository userRepository, UserMapper userMapper) {
        this.userMapper = mapper;
        this.userRepository = userRepository;
//        this.userMapper = userMapper;
    }

    public UserDto convertToDto(UserEntity userEntity) {
        return userMapper.userToUserDto(userEntity); // Преобразование User в UserDto
    }

    public UserEntity convertToEntity(UserDto userDto) {
        return userMapper.userDtoToUser(userDto); // Преобразование UserDto в User
    }

    public UserDto getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")); // Убедитесь, что используете подходящее исключение
        return userMapper.userToUserDto(userEntity);
    }

    public void createUser(UserDto userDto) {
        UserEntity userEntity = userMapper.userDtoToUser(userDto);
        userRepository.save(userEntity);
    }

    @Transactional
    public void saveOrUpdateUser(UserDto userDto) {
        UserEntity userEntity = userMapper.userDtoToUser(userDto);
        userRepository.save(userEntity);

    }

    public Optional<UserEntity> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
