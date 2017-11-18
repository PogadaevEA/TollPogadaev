package jdev.tracker;

import jdev.tracker.services.DataSentServices;
import jdev.tracker.services.DataPeekServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Егор on 18.11.2017.
 */
@Configuration
public class InjectionContext {

    @Bean
    public DataPeekServices peekService() {
        return new DataPeekServices();
    }

    @Bean
    public DataSentServices sendService() {
        return new DataSentServices();
    }
}
