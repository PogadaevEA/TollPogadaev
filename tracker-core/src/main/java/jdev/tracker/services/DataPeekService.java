package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Егор on 19.11.2017.
 */
@Service
public class DataPeekService {

    private BlockingDeque<String> queue =  new LinkedBlockingDeque<>(100);

    String take() throws InterruptedException {
        return queue.take();
    }

    void put(String newpoint) throws InterruptedException {
        queue.put(newpoint);
    }
}
