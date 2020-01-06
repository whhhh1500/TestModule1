package com.cc1500;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//@EnableScheduling
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.cc1500.system.mapper")
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
		System.out.println("(♥◠‿◠)ﾉﾞ♥◠‿◠)ﾉ AdminApplication 启动成功 )");
	}

}
