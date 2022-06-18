package com.posco.posworld.member.service;

import com.posco.posworld.home.model.HomeDto;
import com.posco.posworld.home.service.HomeServiceImpl;
import com.posco.posworld.member.dto.TokenDto;
import com.posco.posworld.member.dto.UserRequestDto;
import com.posco.posworld.member.dto.UserResponseDto;
import com.posco.posworld.member.entity.Member;
import com.posco.posworld.member.jwt.TokenProvider;
import com.posco.posworld.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    @Autowired
    HomeDto homeDto;
    @Autowired
    HomeServiceImpl homeService;

    private final AuthenticationManagerBuilder managerBuilder;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public UserResponseDto signup(UserRequestDto requestDto) {
        if (memberRepository.existsByUserid(requestDto.getUserid())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }

        if (requestDto.getPw()==""){
            throw new RuntimeException("비밀번호를 입력해주세요.");
        }

        if (requestDto.getName()==""){
            throw new RuntimeException("이름을 입력해주세요.");
        }

        Member member = requestDto.toUser(passwordEncoder);
        member.setProphoto("/img/minimi.png");
        UserResponseDto newUser = UserResponseDto.of(memberRepository.save(member));
        Integer id = newUser.getId().intValue();

        HomeDto result = null;
        homeDto.setUserid(id);
        homeDto.setTitle("미니룸");
        homeDto.setPhoto("/img/miniroom.png");
        homeDto.setContent("㉠ㅣ억나ㄴ1 그 때 그 시절 ♡");
        homeDto.setBgm("좋은음악");
        homeService.insertHome(homeDto);

        return newUser;
    }

//    public UserResponseDto signup(UserRequestDto requestDto) {
//        if (memberRepository.existsByUserid(requestDto.getUserid())) {
//            throw new RuntimeException("이미 가입되어 있는 유저입니다");
//        }
//
//        if (requestDto.getPw()==""){
//            throw new RuntimeException("비밀번호를 입력해주세요.");
//        }
//
//        if (requestDto.getName()==""){
//            throw new RuntimeException("이름을 입력해주세요.");
//        }
//
//        Member member = requestDto.toUser(passwordEncoder);
//        member.setProphoto("/img/minimi.png");
//        UserResponseDto newUser = UserResponseDto.of(memberRepository.save(member));
//
//        HomeDto result = null;
//        homeDto.setUserid(newUser.getId());
//        homeDto.setTitle("미니룸");
//        homeDto.setPhoto("좋은사진");
//        homeDto.setContent("좋은주말");
//        homeDto.setBgm("좋은음악");
//        result = homeService.insertHome(homeDto);
//        if(result != null){
//            return 1;
//        }
//        return 0;
//
//        return UserResponseDto.of(memberRepository.save(member));
//    }

    public TokenDto login(UserRequestDto requestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();

        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);

        return tokenProvider.generateTokenDto(authentication);
    }

    public Boolean checkId(UserRequestDto requestDto) {
        return memberRepository.findByUserid(requestDto.getUserid()).isPresent();
    }
}
