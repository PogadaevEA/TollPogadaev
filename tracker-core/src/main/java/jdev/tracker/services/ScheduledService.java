package jdev.tracker.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Егор on 18.11.2017.
 */
@Service
public class ScheduledService {

    @Scheduled (fixedDelay = 3000)
    private void tick() {
        System.out.println("ScheduledService.tick");
    }
}