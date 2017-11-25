package jdev.tracker;

import jdev.tracker.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Егор on 18.11.2017.
 */
@Configuration
@EnableScheduling
@PropertySource("classpath:/app.properties")
public class InjectionContext {

    @Bean
    public DataPeekServices peekServices() {
        return new DataPeekServices();
    }

    @Bean
    public DataSentServices sentServices() {
        return new DataSentServices();
    }

    @Bean
    public DataSaveServices saveServices() {
        return new DataSaveServices();}

}
