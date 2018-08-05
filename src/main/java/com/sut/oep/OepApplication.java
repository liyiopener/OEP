package com.sut.oep;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sut.oep.dao")
public class OepApplication {
	public static void main(String[] args) {
		SpringApplication.run(OepApplication.class, args);
	}
}
