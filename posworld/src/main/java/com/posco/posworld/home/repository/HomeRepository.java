package com.posco.posworld.home.repository;

import com.posco.posworld.home.model.HomeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<HomeDto, Integer> {

}
