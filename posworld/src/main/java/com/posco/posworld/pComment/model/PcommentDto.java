package com.posco.posworld.pComment.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Data
@Component
public class PcommentDto {
    private Integer id;
    private Integer pid;
    private Integer userId;
    private String content;
    private Timestamp wDate;

}
