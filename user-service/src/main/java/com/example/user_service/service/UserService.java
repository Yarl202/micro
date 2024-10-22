package com.example.user_service.service;

import com.example.user_service.code.User;
import com.example.user_service.code.UserDto;
import com.example.user_service.code.UserMapper;
import com.example.user_service.repository.UserRepository; // убедитесь, что вы импортируете UserRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository; // Конструкторное внедрение
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")); // Убедитесь, что используете подходящее исключение
        return userMapper.userToUserDto(user);
    }

    public void createUser(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        userRepository.save(user);
    }

    @Transactional
    public void saveOrUpdateUser(UserDto userDto) {
        Optional<User> existingUserOptional = userRepository.findByUserName(userDto.getUserName());

        if (existingUserOptional.isEmpty()) {
            userRepository.save(userMapper.userDtoToUser(userDto));
        } else {
            User existingUser = existingUserOptional.get();
            userMapper.updateUserFromDto(userDto, existingUser); // Обновляем существующего пользователя
            userRepository.save(existingUser);
        }
    }

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
