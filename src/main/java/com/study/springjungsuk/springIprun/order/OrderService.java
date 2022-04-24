package com.study.springjungsuk.springIprun.order;

public interface OrderService {
    //주문생성
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
