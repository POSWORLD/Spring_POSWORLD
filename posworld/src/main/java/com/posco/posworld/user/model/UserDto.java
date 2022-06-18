package com.posco.posworld.user.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Data
@Entity
@Component
@Table(name = "usertbl")
@DynamicInsert
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userid;
    private String pw;

    private String name;
    private String gender;
    private String prophoto;
}
