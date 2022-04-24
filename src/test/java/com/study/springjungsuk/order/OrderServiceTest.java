package com.study.springjungsuk.order;

import com.study.springjungsuk.springIprun.member.Grade;
import com.study.springjungsuk.springIprun.member.Member;
import com.study.springjungsuk.springIprun.member.MemberService;
import com.study.springjungsuk.springIprun.member.MemberServiceImpl;
import com.study.springjungsuk.springIprun.order.Order;
import com.study.springjungsuk.springIprun.order.OrderService;
import com.study.springjungsuk.springIprun.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void creatOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, " 홍길동", Grade.VIP);  //vip 경우 1000원 할인
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "홍길동", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
