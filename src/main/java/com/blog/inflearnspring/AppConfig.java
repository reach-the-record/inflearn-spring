package com.blog.inflearnspring;

import com.blog.inflearnspring.discount.DiscountPolicy;
import com.blog.inflearnspring.discount.FixDiscountPolicy;
import com.blog.inflearnspring.discount.RateDiscountPolicy;
import com.blog.inflearnspring.member.MemberRepository;
import com.blog.inflearnspring.member.MemberService;
import com.blog.inflearnspring.member.MemberServiceImpl;
import com.blog.inflearnspring.member.MemoryMemberRepository;
import com.blog.inflearnspring.order.OrderService;
import com.blog.inflearnspring.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
