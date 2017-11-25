package jdev.tracker.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Егор on 19.11.2017.
 */
@Service
public class DataSaveServices {
    private static final Logger log = LoggerFactory.getLogger(DataSaveServices.class);


    private BlockingDeque<String> queue =  new LinkedBlockingDeque<>(100);
    private int putCount;
    private long previous;

    @Scheduled (fixedDelay = 2000)
    void take() throws InterruptedException {
        log.info("take trying!!!");
        long current = System.currentTimeMillis();
        //log.info((current - previous) + " DataSaveServices.take " + queue.poll(500, TimeUnit.MILLISECONDS));
        System.out.println((current - previous) + " DataSaveServices.take " + queue.take());
        previous = current;

    }

    @Scheduled (fixedDelay = 1_000)
    void put() throws InterruptedException {
        int i = putCount++;
        log.info("DataSaveServices.put " + i);
        queue.put("new string => " + i);

    }
}