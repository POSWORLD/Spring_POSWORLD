package com.posco.posworld.board.repository;

import com.posco.posworld.board.model.BoardDto;
import com.posco.posworld.board.model.SelectJoinDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardDto, Integer> {

    @Query(value = " SELECT b.num, b.homeid, b.content, b.wdate, b.friendid, u.name As friendname, u.prophoto As friendimg FROM boardtbl " +
            "as b INNER JOIN usertbl as u ON b.friendid = u.id WHERE homeid= ?", nativeQuery = true)
    List<BoardDto> getBoards(Integer homeid);
}

