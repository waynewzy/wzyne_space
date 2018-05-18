package com.wayne;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wayne.dao")
@SpringBootApplication
public class SpaceWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceWebApplication.class, args);
	}
}
