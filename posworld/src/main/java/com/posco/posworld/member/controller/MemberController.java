package com.posco.posworld.member.controller;

import com.posco.posworld.member.dto.ChangePasswordRequestDto;
import com.posco.posworld.member.dto.UserRequestDto;
import com.posco.posworld.member.dto.UserResponseDto;
import com.posco.posworld.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/member")

public class MemberController {

    private final MemberService memberService;

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


}