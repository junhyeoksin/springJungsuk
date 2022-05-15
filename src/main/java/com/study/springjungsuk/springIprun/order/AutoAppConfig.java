package com.study.springjungsuk.springIprun.order;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.lang.reflect.Type;

@Configuration
@ComponentScan(
    excludeFilters = @ComponentScan.Filter(Type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    }
