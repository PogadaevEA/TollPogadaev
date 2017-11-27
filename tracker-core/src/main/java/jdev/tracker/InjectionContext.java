package jdev.tracker;

import jdev.tracker.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Created by Егор on 18.11.2017.
 */
@Configuration
@EnableScheduling
@PropertySource("classpath:/app.properties")
public class InjectionContext {

    @Bean
    public GPSService peekServices() {
        return new GPSService();
    }

    @Bean
    public DataSendService sentServices() {
        return new DataSendService();
    }

    @Bean
    public DataPeekService saveServices() {
        return new DataPeekService();}

    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("poolScheduler");
        scheduler.setPoolSize(20);
        return scheduler;
    }

}
