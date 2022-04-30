package com.study.springjungsuk.springIprun;

import com.study.springjungsuk.springIprun.member.Grade;
import com.study.springjungsuk.springIprun.member.Member;
import com.study.springjungsuk.springIprun.member.MemberService;
import com.study.springjungsuk.springIprun.member.MemberServiceImpl;
import com.study.springjungsuk.springIprun.order.AppConfig;
import com.study.springjungsuk.springIprun.order.Order;
import com.study.springjungsuk.springIprun.order.OrderService;
import com.study.springjungsuk.springIprun.order.OrderServiceImpl;
import javafx.application.Application;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        /**
         * 스프링 컨테이너를 사용해서 Bean(객체) 적힌 것을 호출 할 수 있다.
         */
        ApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "홍길동", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order" + order);
        System.out.println("ordercalculatePrice" + order.calculatePrice());
    }
}
