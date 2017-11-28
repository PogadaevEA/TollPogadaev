package jdev.tracker.services;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    @Scheduled(cron = "${cron.prop30sec}")
    public void sendGPStoServer() throws InterruptedException,JsonProcessingException {
        long current = System.currentTimeMillis();
        log.info((current - previous) + dataPeekService.take().toJson());
        previous = current;
    }
}
