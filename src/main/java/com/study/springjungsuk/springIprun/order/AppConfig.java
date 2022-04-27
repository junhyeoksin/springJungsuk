package com.study.springjungsuk.springIprun.order;

import com.study.springjungsuk.springIprun.discount.DiscountPolicy;
import com.study.springjungsuk.springIprun.discount.FixDiscountPolicy;
import com.study.springjungsuk.springIprun.discount.RateDiscountPolicy;
import com.study.springjungsuk.springIprun.member.MemberRepository;
import com.study.springjungsuk.springIprun.member.MemberService;
import com.study.springjungsuk.springIprun.member.MemberServiceImpl;
import com.study.springjungsuk.springIprun.member.MemoryMemberRepository;

/**
 *    1. 애플리케이션의 실제 동작에 필요한 실제 구현 객체를 생성
 *    2. 생성한 객체 인스턴스의 참조(레퍼런스) 를 생성자를 통해 주입(연결)
 *    3. 오직 Appconfig 처럼 외부에서 구현객체를 주입한다.
 */
public class AppConfig {

    // config 객체는 memoryMemberRepository 객체를 생성하고 그 참조값을 memberServiceImpl을 생성하면서 생성자로 전달한다.
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }


    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
