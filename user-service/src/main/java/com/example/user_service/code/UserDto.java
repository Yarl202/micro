package com.example.user_service.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {


    @JsonProperty("telegramId")
    private Long telegramId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("text")
    private String text;

    @JsonProperty("number")
    private String phone;


}
