package com.myspring.member.service;

import com.myspring.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByLoginIdAndLoginPw(String loginId, String loginPw);
}
