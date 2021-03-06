package com.study.springjungsuk.springIprun.order;

import com.study.springjungsuk.springIprun.member.MemberRepository;
import com.study.springjungsuk.springIprun.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.lang.reflect.Type;

@Configuration
@ComponentScan(
        basePackages = "com.study.springjungsuk.springIprun.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    @Bean(name="memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
