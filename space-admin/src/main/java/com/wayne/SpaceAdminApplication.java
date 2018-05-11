package com.wayne;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Wayne
 * @date 2018/3/10
 * <p>
 * desc:
 */

@MapperScan("com.wayne")
@SpringBootApplication
public class SpaceAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceAdminApplication.class, args);
	}
}
