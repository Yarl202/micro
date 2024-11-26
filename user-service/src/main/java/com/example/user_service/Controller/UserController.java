package com.example.user_service.Controller;

import com.example.user_service.DTO.UserDto;
import com.example.user_service.Entity.UserEntity;
import com.example.user_service.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {


    private UserService userService;


    @PostMapping("/save")
    public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        log.info("Получен запрос на сохранение пользователя: {}", userDto);
        try {
            userService.saveOrUpdateUser(userDto);
            log.info("Пользователь успешно сохранен: {}", userDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Ошибка при сохранении пользователя: {}", userDto, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/find/{username}")
    public ResponseEntity<UserEntity> findUserByUsername(@PathVariable String username) {
        log.info("Получен запрос на поиск пользователя с username: {}", username);
        Optional<UserEntity> user = userService.findByUserName(username);
        if (user.isPresent()) {
            log.info("Пользователь найден: {}", user.get());
            return ResponseEntity.ok(user.get());
        } else {
            log.warn("Пользователь с username {} не найден", username);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
}
