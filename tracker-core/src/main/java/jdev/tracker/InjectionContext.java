package jdev.tracker;

import jdev.tracker.services.DataSentServices;
import jdev.tracker.services.DataPeekServices;
import jdev.tracker.services.ScheduledService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Егор on 18.11.2017.
 */
@Configuration
@EnableScheduling
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
    public ScheduledService scheduledService() {
        return new ScheduledService();
    }
}
