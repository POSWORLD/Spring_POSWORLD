package com.posco.posworld.photo.repository;

import com.posco.posworld.photo.model.PhotoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoDto, Integer> {
    PhotoDto findById(int id);
}
