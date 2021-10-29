package kr.co.farmstory1;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("kr.co.farmstory1.dao")
@SpringBootApplication
public class Farmstory1Application {

	public static void main(String[] args) {
		SpringApplication.run(Farmstory1Application.class, args);
	}

}
