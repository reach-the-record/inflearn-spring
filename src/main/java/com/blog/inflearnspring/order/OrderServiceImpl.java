package com.blog.inflearnspring.order;

import com.blog.inflearnspring.discount.DiscountPolicy;
import com.blog.inflearnspring.discount.FixDiscountPolicy;
import com.blog.inflearnspring.member.Member;
import com.blog.inflearnspring.member.MemberRepository;
import com.blog.inflearnspring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
