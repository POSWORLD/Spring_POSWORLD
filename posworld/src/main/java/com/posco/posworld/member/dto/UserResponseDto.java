package com.posco.posworld.member.dto;

import com.posco.posworld.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    private Long id;
    private String userid;
    private String name;
    private String gender;
    private String prophoto;

    public static UserResponseDto of(Member member) {
        return UserResponseDto.builder()
                .id(member.getId())
                .userid(member.getUserid())
                .name(member.getName())
                .gender(member.getGender())
                .prophoto(member.getProphoto())
                .build();
    }
}