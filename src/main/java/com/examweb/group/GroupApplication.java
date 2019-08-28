package com.examweb.group;

import com.examweb.group.utils.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableTransactionManagement

public class GroupApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupApplication.class, args);
		System.out.print(new ServerConfig().getUrl());
	}
}
