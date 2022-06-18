package com.posco.posworld.board.controller;

import com.posco.posworld.board.model.BoardDto;
import com.posco.posworld.board.service.BoardServiceImpl;
import com.posco.posworld.config.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
    @Autowired
    BoardDto boardDto;
    @Autowired
    SecurityService securityService;
    @Autowired
    BoardServiceImpl boardService;
    @GetMapping("/{homeId}")
    public List<BoardDto> getBoards(@PathVariable String homeId){
        boardDto.setHomeId(Integer.valueOf(homeId));
        return boardService.getBoards(boardDto);
    }

    @PostMapping("/{id}")
    public Integer insertBoard(@RequestBody BoardDto boardDto, @PathVariable String id){
       boardDto.setFriendId(Integer.valueOf(id));
       return boardService.insertBoard(boardDto);

    }
    @DeleteMapping("/{num}")
    public Integer deletePost(@PathVariable String num){
        boardDto.setNum(Integer.valueOf(num));
        boardDto.setFriendId(securityService.getIdAtToken());
        return boardService.deleteBoard(boardDto);
    }
    @PutMapping("/{num}")
    public Integer updateBoard(@RequestBody BoardDto boardDto, @PathVariable String num){
        boardDto.setFriendId(securityService.getIdAtToken());
        boardDto.setNum(Integer.valueOf(num));
        return boardService.updateBoard(boardDto);
    }



}
