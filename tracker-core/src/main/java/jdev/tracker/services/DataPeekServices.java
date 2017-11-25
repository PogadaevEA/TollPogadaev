package jdev.tracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.PostConstruct;

/**
 * Created by Егор on 18.11.2017.
 */
@Service
public class DataPeekServices {

    @Autowired
    private DataSentServices dataSentServices;

    @PostConstruct
    private void init() {
        dataSentServices.callFromInit();
    }

    double lat;
    double lon;
    double azim;
    String autoId;
    long time;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }
    public void setAzim(double azim) {
        this.azim = azim;
    }

    public double getAzim() {
        return azim;
    }

    @Scheduled(cron = "${cron.prop}")
    public void SetGet() throws Exception {
        setLat(55.75222);
        setLon(37.61556);
        setAzim(180.00);
        setAutoId("К310МС70");
        setTime(System.currentTimeMillis());
    }

    @Scheduled(cron = "${cron.prop}")
    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(this));
        return mapper.writeValueAsString(this);
    }

//    @Override
//    public String toString() {
//        return "PointDTO{" +
//                "lat=" + lat +
//                ", lon=" + lon +
//                ", autoId='" + autoId + '\'' +
//                '}';
//    }




}
