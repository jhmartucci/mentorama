package com.br.mentorama.AsyncThreadPool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = {"com.br.mentorama.AsyncThreadPool"})
public class AsyncThreadPoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncThreadPoolApplication.class, args);
	}

}
