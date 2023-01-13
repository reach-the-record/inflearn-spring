package com.blog.inflearnspring.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
