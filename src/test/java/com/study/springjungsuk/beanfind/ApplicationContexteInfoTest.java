package com.study.springjungsuk.beanfind;

import com.study.springjungsuk.springIprun.order.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

 class ApplicationContexteInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();  // 스프링에 등록된 모든 빈 이름을 조회
        for (String beanDefinitionName : beanDefinitionNames) {     //- iter + tab
            Object bean = ac.getBean(beanDefinitionName);  // 빈 이름으로 빈 객체(인스턴스)를 조회
            System.out.println("beanDefinitionName = " + beanDefinitionName + " Object"  + bean);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicatinoBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("beanDefinitionName = " + beanDefinitionName + " Object"  + bean);
            }
        }
    }
}
