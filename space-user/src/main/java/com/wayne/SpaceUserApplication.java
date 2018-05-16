package com.wayne;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wayne.dao")
public class SpaceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceUserApplication.class, args);
	}
}
