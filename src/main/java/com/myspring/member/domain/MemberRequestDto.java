package com.myspring.member.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequestDto {

    private Long id;
    private String loginId;
    private String loginPw;
    private String nickname;

}
