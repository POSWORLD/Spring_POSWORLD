package com.posco.posworld.board.repository;

import com.posco.posworld.board.model.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    Integer insertBoard(BoardDto boardDto);
    List<BoardDto> getBoardByUser(BoardDto boardDto);
    List<BoardDto> getBoards();
}
