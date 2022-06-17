package com.posco.posworld.user.repository;


import com.posco.posworld.user.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Integer> {

    UserDto findByUseridAndPw(String userid, String pw);
    UserDto findByUserid(String userid);

}
