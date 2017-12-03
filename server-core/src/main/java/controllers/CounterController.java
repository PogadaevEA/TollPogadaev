package controllers;

import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CounterController {

    private static final String template = "It's yours, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/counter")
    public CurrentState greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new CurrentState(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping(value = "/coords", method = RequestMethod.GET)
    public Response setCoords(@RequestParam(value="location") String location){
        System.out.println(location);
        Response response;
        if (location.split(",").length == 2) {
             response = new Response("ok", true);
        } else {
             response = new Response("fail", false);
        }

        return response;
    }

    @RequestMapping(value = "/relay")
    public PointDTO relay(){
        PointDTO country = restTemplate.getForObject(
                "http://services.groupkt.com/country/get/iso2code/RU", PointDTO.class);
        return country;
    }
}