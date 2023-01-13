package com.blog.inflearnspring.discount;

import com.blog.inflearnspring.AppConfig;
import com.blog.inflearnspring.member.Grade;
import com.blog.inflearnspring.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        discountPolicy = appConfig.discountPolicy();
    }
    DiscountPolicy discountPolicy;
    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void discount() {
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        int discount = discountPolicy.discount(member, 20000);
        assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void noDiscount() {
        Member member = new Member(1L, "memberBASIC", Grade.BASIC);
        int discount = discountPolicy.discount(member, 20000);
        assertThat(discount).isEqualTo(0);
    }
}