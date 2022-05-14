package com.study.springjungsuk.singleton;

import com.study.springjungsuk.springIprun.member.MemberRepository;
import com.study.springjungsuk.springIprun.member.MemberServiceImpl;
import com.study.springjungsuk.springIprun.order.AppConfig;
import com.study.springjungsuk.springIprun.order.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    @DisplayName("singleton - memberRepository 객체 test")
    void configurationTest(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        System.out.println("memberService - > memberRepository1 = " + memberRepository1);
        System.out.println("orderService - > memberRepository2 = " + memberRepository2);
    }
}
