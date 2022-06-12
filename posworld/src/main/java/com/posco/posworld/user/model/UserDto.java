package com.posco.posworld.user.model;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String pw;
    private String userId;
    private String gender;
    private String name;
    private String proPhoto;
}
