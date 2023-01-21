package com.blog.inflearnspring.discount;

import com.blog.inflearnspring.member.Grade;
import com.blog.inflearnspring.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
