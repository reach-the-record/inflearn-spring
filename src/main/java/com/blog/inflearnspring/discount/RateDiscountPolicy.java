package com.blog.inflearnspring.discount;

import com.blog.inflearnspring.annotation.MainDiscountPolicy;
import com.blog.inflearnspring.member.Grade;
import com.blog.inflearnspring.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
