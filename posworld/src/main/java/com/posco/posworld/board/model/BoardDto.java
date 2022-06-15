package com.posco.posworld.board.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Component
public class BoardDto {

    private Integer num;

    private Integer homeId;

    private String content;

    private Timestamp wDate;
    
    private Integer friendId;

}
