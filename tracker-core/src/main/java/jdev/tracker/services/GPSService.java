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
    double latnew = 55.75222;
    double lonnew = 37.61556;
    double speednew = 20.0;


    @Autowired
    private DataPeekService dataPeekService;

    @PostConstruct
    @Scheduled(cron = "${cron.prop}")
    private void init() throws Exception{
        dataPeekService.put(getGPS());
    }




    public PointDTO getGPS() throws Exception {
        PointDTO point = new PointDTO();
        point.setLat(this.latnew);
        point.setLon(this.lonnew);
        point.setAzim(180.0);
        point.setSpeed(this.speednew);
        point.setAutoId("К310МС70");
        point.setTime(System.currentTimeMillis());
        this.latnew = this.latnew + 0.1;
        this.lonnew = this.lonnew + 0.1;
        this.speednew = this.speednew + 1.0;
        return point;
    }


}
