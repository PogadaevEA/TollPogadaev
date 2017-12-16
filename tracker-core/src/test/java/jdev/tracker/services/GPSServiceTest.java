package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class GPSServiceTest {
    @Test
    public void getGPS() throws Exception {
        PointDTO point = new PointDTO();
        point.setLat(56);
        point.setLon(74);
        point.setAzim(123);
        point.setSpeed(40);
        point.setAutoId("k310ms70");
        point.setTime(System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lat\":56"));
        assertTrue(point.toJson().contains("\"time\":"));
        assertTrue(point.toJson().contains("\"lon\":74"));
        assertTrue(point.toJson().contains("\"azim\":123"));
        assertTrue(point.toJson().contains("\"autoId\":"));
        assertTrue(point.toJson().contains("\"speed\":40"));
        System.out.println(point.toJson());
    }

}