package com.posco.posworld.pComment.repository;

import com.posco.posworld.pComment.model.PcommentDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import javax.transaction.Transactional;
import java.util.List;

@EnableJpaRepositories
public interface PcommentRepository extends JpaRepository<PcommentDto, Integer> {
    @Modifying
    @Transactional
    @Query("Delete from PcommentDto p where p.id = ?1 and p.userid = ?2")
    Integer deleteByIds(@Param("id") Integer id, @Param("userid") Integer userid);


    List<PcommentDto> findByPid(@Param("pid") Integer pid);

}