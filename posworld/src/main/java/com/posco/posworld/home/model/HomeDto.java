package com.posco.posworld.home.model;

import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Data
@Entity
@Component
public class HomeDto {
    private Integer id;
    private Integer userId;
    private String title;
    private String photo;
    private String content;
    private String bgm;
    private String total;
}
