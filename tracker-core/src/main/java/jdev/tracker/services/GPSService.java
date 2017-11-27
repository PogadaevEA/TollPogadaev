package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Егор on 18.11.2017.
 */
@Service
public class GPSService {


    @Autowired
    private DataPeekService dataPeekService;

    @PostConstruct
    private void init() throws Exception{
        dataPeekService.put(getGPS());
       System.out.println(getGPS());
    }



//    @Scheduled(cron = "${cron.prop}")
    public String getGPS() throws Exception {
        PointDTO point = new PointDTO();
        point.setLat(55.75222);
        point.setLon(37.61556);
        point.setAutoId("К310МС70");
        point.setTime(System.currentTimeMillis());
        return point.toJson();
    }


}
