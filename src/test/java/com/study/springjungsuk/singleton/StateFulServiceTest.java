package com.study.springjungsuk.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        //-------------------------------------------------------------------------------------------
        // 실패
        StateFulServiceError stateFulServiceError1 = ac.getBean(StateFulServiceError.class);
        StateFulServiceError stateFulServiceError2 = ac.getBean(StateFulServiceError.class);


        // 사용자A  10000 원 주문
        stateFulServiceError1.order("userA", 10000);
        // 사용자B 20000 원 주문
        stateFulServiceError2.order("userB", 20000);

        // 사용자 A가 조회
        int price = stateFulServiceError1.getPrice();
        System.out.println("price = " + price);   // 20000원

        Assertions.assertThat(stateFulServiceError1.getPrice()).isEqualTo(20000);

        //-----------------------------------------------------------------------------------------
        // 성공
        StateFulService stateFulService1 = ac.getBean(StateFulService.class);
        StateFulService stateFulService2 = ac.getBean(StateFulService.class);

        // 사용자A
        int userA = stateFulService1.order("userA", 50000);
        // 사용자B
        int userB = stateFulService2.order("userB", 100000);


        Assertions.assertThat(userA).isEqualTo(50000);



    }


    static class TestConfig{
        @Bean
        public StateFulServiceError stateFulServiceError(){
            return new StateFulServiceError();
        }

        @Bean
        public StateFulService stateFulService(){
            return new StateFulService();
        }
    }




}