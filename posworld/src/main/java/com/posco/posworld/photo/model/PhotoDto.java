package com.posco.posworld.photo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Data
@Component
public class PhotoDto {
    private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private String img;
    private Timestamp wDate;
}
