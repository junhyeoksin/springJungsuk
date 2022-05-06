package com.study.springjungsuk.beanfind;

import com.study.springjungsuk.springIprun.member.MemberService;
import com.study.springjungsuk.springIprun.member.MemberServiceImpl;
import com.study.springjungsuk.springIprun.order.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName(" 빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);  //memberService가 memberServiceImpl 인스턴스이면 성공

    }
    @Test
    @DisplayName(" 이름없이 타입으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean( MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);  //memberService가 memberServiceImpl 인스턴스이면 성공

    }

    @Test
    @DisplayName(" 구체 타입으로 조회")
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);  //memberService가 memberServiceImpl 인스턴스이면 성공

    }

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByNameX(){
        assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("xxxx", MemberService.class));
    }
}
