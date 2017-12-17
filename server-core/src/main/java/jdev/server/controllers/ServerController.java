package jdev.server.controllers;

import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;

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
}