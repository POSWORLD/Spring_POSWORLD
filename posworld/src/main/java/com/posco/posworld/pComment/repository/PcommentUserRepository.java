package com.posco.posworld.pComment.repository;

import com.posco.posworld.pComment.model.PcommentDto;
import com.posco.posworld.pComment.model.PcommentUserDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface PcommentUserRepository extends JpaRepository<PcommentUserDto, Integer> {

    @Query(value = " SELECT p.id,p.pid, u.name, p.content, p.wdate\n" +
            "        FROM pcommenttbl as p\n" +
            "        INNER JOIN usertbl as u on p.userid = u.id where p.pid = :pid", nativeQuery=true)
    List<PcommentUserDto> findByPid(@Param("pid") Integer pid);

}
