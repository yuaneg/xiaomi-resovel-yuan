package xyz.talentboy.common.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 异步
 * @author yuaneg 2017年1月18日下午1:51:56
 *
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

   @Override
     public Executor getAsyncExecutor() {
         ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
         executor.setCorePoolSize(7);
         executor.setMaxPoolSize(42);
         executor.setQueueCapacity(11);
         executor.setThreadNamePrefix("myasync");
         executor.initialize();
         return executor;
     }

     @Override
     public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
         return new SimpleAsyncUncaughtExceptionHandler();
     }
     
}