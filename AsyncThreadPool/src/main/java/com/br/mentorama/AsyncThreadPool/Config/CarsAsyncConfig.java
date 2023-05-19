package com.br.mentorama.AsyncThreadPool.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class CarsAsyncConfig {
    @Bean
    public Executor executor(){
        return ForkJoinPool.commonPool();
    }
    @Bean
    public Executor customThreadPool(){
        ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();
        exec.setCorePoolSize(5);
        exec.setMaxPoolSize(15);
        exec.setQueueCapacity(20);
        return exec;
    }
}
