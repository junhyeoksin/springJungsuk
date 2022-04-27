package com.study.springjungsuk.springIprun;

import com.study.springjungsuk.springIprun.member.Grade;
import com.study.springjungsuk.springIprun.member.Member;
import com.study.springjungsuk.springIprun.member.MemberService;
import com.study.springjungsuk.springIprun.member.MemberServiceImpl;
import com.study.springjungsuk.springIprun.order.AppConfig;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appconfig = new AppConfig();
        MemberService memberService = appconfig.memberService();

//      MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "홍길동", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("member" + member.getName());
        System.out.println("findMember" + findMember.getName());

    }
}
