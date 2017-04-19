package com.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ImportResource({ "classpath:/com/shop/config/spring-config.xml" })
public class AppConfig {

	@Autowired
	JdbcTemplate jbdcTemplate;
}
