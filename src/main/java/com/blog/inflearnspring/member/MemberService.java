package com.blog.inflearnspring.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
