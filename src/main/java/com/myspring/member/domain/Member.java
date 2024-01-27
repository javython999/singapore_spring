package com.myspring.member.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId;
    private String loginPw;
    private String nickname;
    private LocalDateTime regDateTime;

    public Member(String loginId, String loginPw, String nickname, LocalDateTime regDateTime) {
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.nickname = nickname;
        this.regDateTime = regDateTime;
    }
}
