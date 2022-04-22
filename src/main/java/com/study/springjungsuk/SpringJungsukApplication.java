package com.study.springjungsuk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) //당장 JDBC설정이 필요없고 어떤 DB를 사용할지 결정하지 않았을 때 사용
public class SpringJungsukApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJungsukApplication.class, args);
    }

}
