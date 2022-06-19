package com.posco.posworld.photo.repository;

import com.posco.posworld.photo.model.PhotoDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface PhotoRepository extends JpaRepository<PhotoDto, Integer> {
    PhotoDto findById(int id);


    List<PhotoDto> findPhotoDtoByUserid(@Param("userid")int userid);

    @Modifying
    @Transactional
    @Query("Delete from PhotoDto p where p.id = ?1 and p.userid = ?2")
    Integer deleteByIds(@Param("id") Integer id, @Param("userid") Integer userid);

}