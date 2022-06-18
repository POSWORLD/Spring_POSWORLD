package com.posco.posworld.member.dto;

import com.posco.posworld.member.entity.Authority;
import com.posco.posworld.member.entity.Member;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {
    private String userid;
    private String pw;
    private String name;
    private String gender;
    private String prophoto;


    public Member toUser(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .userid(userid)
                .pw(passwordEncoder.encode(pw))
                .name(name)
                .gender(gender)
                .prophoto(prophoto)
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(userid, pw);
    }
}