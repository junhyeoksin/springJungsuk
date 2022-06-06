package com.study.springjungsuk.scan.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;

public class ComponentFilterAppConfigTest {
    @Test
    void filterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        assertThat(beanA).isNotNull();

//        ac.getBean("beanB", BeanB.class);
        Assertions.assertThrows((
                        NoSuchBeanDefinitionException.class),
                () -> ac.getBean("beanB", BeanB.class)
        );
        /**
         * includeFilters 에 MyIncludeComponent 에노테이션을 추가해서 BeanA 빈에 등록
         * excludeFilters 에 MyExcludeComponent 에노테이션을 추가해서 BeanB 빈에 등록되지 않는다.
         *
         */


    }
    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyexcludeComponent.class))
    static class ComponentFilterAppConfig{

    }
}
