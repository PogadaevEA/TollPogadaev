package jdev.server.controllers;

import jdev.dto.PointDTO;
import jdev.server.services.CreateFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Егор on 25.11.2017.
 */
@RestController
public class ServerController {
    Logger logger = LoggerFactory.getLogger(ServerController.class);
    private long previous;

    @Autowired
    CreateFileService createFileService;

    @RequestMapping(value = "points", method = RequestMethod.POST)
    public @ResponseBody
    PointDTO createPoint(@RequestBody PointDTO point) {
        long current = System.currentTimeMillis();
        //log.info((current - previous) + dataPeekService.take().toJson());
        //previous = current;
        logger.info((current - previous) +"AutoId" + point.getAutoId() + " lon = " + point.getLon() + " lat = " + point.getLat());
        createFileService.writeInFile((current - previous) +"AutoId" + point.getAutoId() + " lon = " + point.getLon() + " lat = " + point.getLat());
        return point;
    }
}