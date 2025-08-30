package com.chase.loanUtil;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration


public class AsyncConfig {
	 @Bean(name = "taskExecutor")
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor exe = new ThreadPoolTaskExecutor();
        exe.setCorePoolSize(10);
        exe.setMaxPoolSize(20);
        exe.setQueueCapacity(50);
        exe.setThreadNamePrefix("Bank Task - ");
        exe.initialize();
        
		return exe;
		
	}

}
