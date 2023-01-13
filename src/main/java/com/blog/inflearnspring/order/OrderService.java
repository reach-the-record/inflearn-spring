package com.blog.inflearnspring.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
