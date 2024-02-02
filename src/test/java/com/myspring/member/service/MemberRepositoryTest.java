package com.myspring.member.service;

import com.myspring.TestEnv;
import com.myspring.member.domain.Member;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
public class MemberRepositoryTest extends TestEnv {

    @Autowired
    MemberRepository memberRepository;


    @Test
    @DisplayName("Member를 저장 할 수 있다.")
    public void save() {
        // given
        Member member = Member.builder()
                .loginId("memberId")
                .loginPw("memberPw")
                .nickname("memberNickname")
                .regDateTime(LocalDateTime.now())
                .build();

        // when
        memberRepository.save(member);
        Optional<Member> findMember = memberRepository.findById(member.getId());
        
        // then
        assertThat(findMember.get().getId()).isEqualTo(member.getId());
        assertThat(findMember.get().getLoginPw()).isEqualTo(member.getLoginPw());
        assertThat(findMember.get().getNickname()).isEqualTo(member.getNickname());
        assertThat(findMember.get().getRegDateTime()).isEqualTo(member.getRegDateTime());
    }
    
    @Test
    public void delete() {
        // given
        Member member = Member.builder()
                .loginId("memberId")
                .loginPw("memberPw")
                .nickname("memberNickname")
                .regDateTime(LocalDateTime.now())
                .build();
        
        // when
        memberRepository.save(member);
        memberRepository.delete(member);
        Optional<Member> findMember = memberRepository.findById(member.getId());
        
        // then
        assertThat(findMember.isPresent()).isFalse();
    }

    @Test
    @DisplayName("Member의 memberId로 조회를 할 수 있다.")
    public void findById() {
        // given
        Member member = Member.builder()
                .loginId("memberId")
                .loginPw("memberPw")
                .nickname("memberNickname")
                .regDateTime(LocalDateTime.now())
                .build();

        // when
        memberRepository.save(member);
        Member findMember = memberRepository.findById(member.getId()).get();

        // then
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    public void loginCheckSuccess() {
        // given
        Member member = Member.builder()
                .loginId("memberId")
                .loginPw("memberPw")
                .nickname("memberNickname")
                .regDateTime(LocalDateTime.now())
                .build();

        // when
        memberRepository.save(member);
        Member loginMember = memberRepository.findByLoginIdAndLoginPw("memberId", "memberPw");

        // then
        assertThat(loginMember).isEqualTo(member);
    }

    @Test
    public void loginCheckFail() {
        // given
        Member member = Member.builder()
                .loginId("memberId")
                .loginPw("memberPw")
                .nickname("memberNickname")
                .regDateTime(LocalDateTime.now())
                .build();

        // when
        memberRepository.save(member);
        Member loginMember = memberRepository.findByLoginIdAndLoginPw("fail", "fail");

        // then
        assertThat(loginMember).isNotEqualTo(member);
    }

}