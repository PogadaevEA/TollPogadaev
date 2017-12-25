package jdev.server.controllers;

import jdev.dto.PointDTO;
import jdev.server.dao.Point;
import jdev.server.dao.repo.PointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Егор on 25.11.2017.
 */
@RestController
public class ServerController {
    Logger logger = LoggerFactory.getLogger(ServerController.class);
    private long previous;
    private final RestTemplate restT;

    public ServerController(@Autowired RestTemplate RT){
        this.restT = RT;
    }

    @Autowired
    PointRepository pointRepository;


    @RequestMapping(value = "points", method = RequestMethod.POST,  headers = "Accept=application/json")
    public @ResponseBody
    PointDTO createPoint(@RequestBody PointDTO point) {
        long current = System.currentTimeMillis();
        previous = current;
        logger.info((current - previous) + String.valueOf(point));
        try (FileWriter writer = new FileWriter("tracks.txt", true)) {
            writer.write(String.valueOf(point) + System.getProperty("line.separator"));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return point;
    }

    @RequestMapping(value = "/points/", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public Point[] getByTime(@RequestParam("auto-id") String autoId, @RequestParam long hours) {
        long millis = TimeUnit.HOURS.toMillis(hours);
        List<jdev.server.dao.Point> allPoints = (List<jdev.server.dao.Point>) pointRepository.filterByTime(
                autoId,
                millis,
                System.currentTimeMillis()
        );

        int i = 0;
        Point[] points = new Point[allPoints.size()];
        for(jdev.server.dao.Point entityPoint : allPoints) {
            Point point = new Point();
            point.setLat(entityPoint.getLat());
            point.setLon(entityPoint.getLon());
            point.setAzimuth(entityPoint.getAzimuth());
            point.setSpeed(entityPoint.getSpeed());
            point.setTime(entityPoint.getTime());

            points[i++] = point;
        }

        return points;
    }
}