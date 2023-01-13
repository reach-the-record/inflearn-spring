package com.blog.inflearnspring;

import com.blog.inflearnspring.member.Grade;
import com.blog.inflearnspring.member.Member;
import com.blog.inflearnspring.member.MemberService;
import com.blog.inflearnspring.member.MemberServiceImpl;
import com.blog.inflearnspring.order.Order;
import com.blog.inflearnspring.order.OrderService;
import com.blog.inflearnspring.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
