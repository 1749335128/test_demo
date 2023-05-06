package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication()
@MapperScan("com.example.demo.mapper")
public class Demo1Application {
    @Bean
    ObjectMapper objectMapper(){
        return  new ObjectMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}
