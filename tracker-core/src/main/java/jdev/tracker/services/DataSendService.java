package jdev.tracker.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Егор on 18.11.2017.
 */
@Service
public class DataSendService {

    @Autowired
    private DataPeekService dataPeekService;

    private static final Logger log = LoggerFactory.getLogger(DataSendService.class);
    private long previous;

    @Scheduled(fixedRate = 2000)
    public void sendGPStoServer() throws InterruptedException {
        long current = System.currentTimeMillis();
        log.info((current - previous) + dataPeekService.take());
        previous = current;
    }
}
