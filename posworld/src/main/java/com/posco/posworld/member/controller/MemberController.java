package com.posco.posworld.member.controller;

import com.posco.posworld.home.service.HomeServiceImpl;
import com.posco.posworld.member.dto.ChangePasswordRequestDto;
import com.posco.posworld.member.dto.UserRequestDto;
import com.posco.posworld.member.dto.UserResponseDto;
import com.posco.posworld.member.entity.Member;
import com.posco.posworld.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/member")

public class MemberController {

    private final MemberService memberService;

    @Autowired
    HomeServiceImpl homeService;

    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> getMyMemberInfo() {
        UserResponseDto myInfoBySecurity = memberService.getMyInfoBySecurity();
        return ResponseEntity.ok((myInfoBySecurity));
        // return ResponseEntity.ok(memberService.getMyInfoBySecurity());
    }

    @PostMapping("/name")
    public ResponseEntity<UserResponseDto> setMemberNickname(@RequestBody UserRequestDto request) {
        System.out.println(request);
        return ResponseEntity.ok(memberService.changeMemberNickname(request.getUserid(), request.getName(), request.getProphoto()));
    }

    @PostMapping("/password")
    public ResponseEntity<UserResponseDto> setMemberPassword(@RequestBody ChangePasswordRequestDto request) {
        return ResponseEntity.ok(memberService.changeMemberPassword(request.getExPw(), request.getNewPw()));
    }

    @GetMapping("/count")
    public Long getUserCount() {
        return memberService.getUserCount();
    }

    @GetMapping("/{id}")
    public Optional<Member> getUser(@PathVariable String id){
        return memberService.getUser(Long.parseLong(id));
    }


    @DeleteMapping("/{id}")
    public Integer deleteUser(@PathVariable String id){
        try {
            memberService.deleteUser(Long.parseLong(id));
            homeService.deleteHome(Integer.parseInt(id));
            return 1;
        } catch(Exception e) {
            return 0;
        }
    }
}