package com.posco.posworld.board.service;

import com.posco.posworld.board.model.BoardDto;

import java.util.List;

public interface BoardService {
    Integer insertBoard(BoardDto boardDto);
    List<BoardDto> getBoardByUser(BoardDto boardDto);
    List<BoardDto> getBoards();
}
