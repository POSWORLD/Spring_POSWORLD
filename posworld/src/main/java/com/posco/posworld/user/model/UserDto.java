package com.posco.posworld.user.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserDto {
    private Integer id;
    private String userId;
    private String pw;
    private String gender;
    private String name;
    private String proPhoto;
}
