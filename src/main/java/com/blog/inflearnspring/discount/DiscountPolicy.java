package com.blog.inflearnspring.discount;

import com.blog.inflearnspring.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
    /**
     * @return 할인 대상 금액
     */

}
