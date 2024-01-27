package com.myspring.member.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String loginId;
    private String loginPw;
    private String nickname;
    private LocalDateTime regDateTime;

    @Builder
    public Member(String loginId, String loginPw, String nickname, LocalDateTime regDateTime) {
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.nickname = nickname;
        this.regDateTime = regDateTime;
    }
}
