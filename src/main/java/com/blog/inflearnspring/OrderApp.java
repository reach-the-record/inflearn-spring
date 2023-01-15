package com.blog.inflearnspring;

import com.blog.inflearnspring.member.Grade;
import com.blog.inflearnspring.member.Member;
import com.blog.inflearnspring.member.MemberService;
import com.blog.inflearnspring.member.MemberServiceImpl;
import com.blog.inflearnspring.order.Order;
import com.blog.inflearnspring.order.OrderService;
import com.blog.inflearnspring.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = annotationConfigApplicationContext.getBean(MemberService.class);
        OrderService orderService = annotationConfigApplicationContext.getBean(OrderService.class);
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
