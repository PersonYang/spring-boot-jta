package com.young;

import com.young.config.PrimaryDBConfig;
import com.young.config.SecondaryDBConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableConfigurationProperties(value = { PrimaryDBConfig.class,SecondaryDBConfig.class })
@ImportResource(value = "classpath:/dubbo/dubbo-consumer.xml")
public class SpringBootJtaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJtaApplication.class, args);
	}
}
