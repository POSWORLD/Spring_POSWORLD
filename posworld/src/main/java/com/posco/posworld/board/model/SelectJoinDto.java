package com.posco.posworld.board.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Data
@Component
public class SelectJoinDto {
    private Integer num;
    private Integer homeId;
    private String content;
    private Timestamp wDate;
    private Integer friendId;
    private String friendImg;
    private String friendName;
}
