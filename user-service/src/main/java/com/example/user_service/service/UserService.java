package com.example.user_service.service;

import com.example.user_service.code.Mapper;
import com.example.user_service.code.User;
import com.example.user_service.code.UserDto;
import com.example.user_service.UserMapper;
import com.example.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final Mapper mapper;
    private final UserRepository userRepository;
//    private final UserMapper userMapper;

    @Autowired
    public UserService(Mapper mapper, UserRepository userRepository, UserMapper userMapper) {
        this.mapper = mapper;
        this.userRepository = userRepository;
//        this.userMapper = userMapper;
    }

    public UserDto convertToDto(User user) {
        return mapper.userToUserDto(user); // Преобразование User в UserDto
    }

    public User convertToEntity(UserDto userDto) {
        return mapper.userDtoToUser(userDto); // Преобразование UserDto в User
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")); // Убедитесь, что используете подходящее исключение
        return mapper.userToUserDto(user);
    }

    public void createUser(UserDto userDto) {
        User user = mapper.userDtoToUser(userDto);
        userRepository.save(user);
    }

    @Transactional
    public void saveOrUpdateUser(UserDto userDto) {
        User user = mapper.userDtoToUser(userDto);
        userRepository.save(user);

    }

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
