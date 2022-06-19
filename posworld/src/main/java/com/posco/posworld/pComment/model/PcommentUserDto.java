package com.posco.posworld.pComment.model;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@Component
public class PcommentUserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Integer pid;


    private String name;


    private String content;

    @UpdateTimestamp
    private LocalDateTime wdate = LocalDateTime.now();
}
