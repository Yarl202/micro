package com.example.user_service.Service;

import com.example.user_service.DTO.UserDto;
import com.example.user_service.Entity.UserEntity;
import com.example.user_service.Mapper.UserMapper;
import com.example.user_service.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;


    public UserDto convertToDto(UserEntity userEntity) {
        return userMapper.userToUserDto(userEntity); // Преобразование User в UserDto
    }

    public UserEntity convertToEntity(UserDto userDto) {
        return userMapper.userDtoToUser(userDto); // Преобразование UserDto в User
    }

    public UserDto getUserById(Long id) {
        log.info("Получение пользователя по ID: {}", id);
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Пользователь с ID {} не найден", id);
                    return new RuntimeException("User not found");
                });
        log.debug("Преобразование пользователя в DTO: {}", userEntity); // Убедитесь, что используете подходящее исключение
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
