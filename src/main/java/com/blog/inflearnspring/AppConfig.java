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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
