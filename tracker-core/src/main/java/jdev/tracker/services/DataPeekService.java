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

    private BlockingDeque<PointDTO> queue =  new LinkedBlockingDeque<>(100);

    public BlockingDeque<PointDTO> getQueue() {
        return queue;
    }

    PointDTO take() throws InterruptedException{
        return queue.take();
    }

    void put(PointDTO newpoint) throws InterruptedException {
        queue.put(newpoint);
    }
}
