package jdev.tracker.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Егор on 18.11.2017.
 */
@Service
public class DataSendService {

    @Autowired
    private DataPeekService dataPeekService;


    RestTemplate restTemplate = new RestTemplate();

    @Scheduled(cron = "${cron.prop30sec}")
    public void sendGPStoServer() throws InterruptedException,JsonProcessingException {
        int i=0;
        for (PointDTO point:dataPeekService.getQueue()) {
            restTemplate.postForObject("http://localhost:8080/points", point, PointDTO.class);
            i++;
        }
    }
}
