package com.study.springjungsuk.springIprun;

import com.study.springjungsuk.springIprun.member.Grade;
import com.study.springjungsuk.springIprun.member.Member;
import com.study.springjungsuk.springIprun.member.MemberService;
import com.study.springjungsuk.springIprun.member.MemberServiceImpl;
import com.study.springjungsuk.springIprun.order.AppConfig;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appconfig = new AppConfig();
//        MemberService memberService = appconfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);    //Bean 은 메서드 명으로 기억됨
//
//      MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "홍길동", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("member" + member.getName());
        System.out.println("findMember" + findMember.getName());

    }
}
