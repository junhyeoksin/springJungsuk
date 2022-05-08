package com.study.springjungsuk.singleton;

import com.study.springjungsuk.springIprun.member.MemberService;
import com.study.springjungsuk.springIprun.order.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너 ")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회: 할때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 할때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
    }
}
