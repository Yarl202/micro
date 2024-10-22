package com.example.user_service.code;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("first_name") // Поле в JSON будет "first_name"
    private String firstName;

    @JsonProperty("last_name")  // Поле в JSON будет "last_name"
    private String lastName;

    @JsonProperty("user_name")  // Поле в JSON будет "user_name"
    private String userName;

    @JsonProperty("message_text")  // Поле в JSON будет "message_text"
    private String text;

    @JsonProperty("phone_number")  // Поле в JSON будет "phone_number"
    private String phone;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getText() {
        return text;
    }

    public String getPhone() {
        return phone;
    }
}
