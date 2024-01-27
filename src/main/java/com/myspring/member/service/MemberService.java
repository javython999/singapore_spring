package com.myspring.member.service;

import com.myspring.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public void delete(Member member) {
        memberRepository.delete(member);
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);

    }

    public Member loginCheck(String loginId, String loginPw) {
        return memberRepository.findByLoginIdAndLoginPw(loginId, loginPw);
    }
}
