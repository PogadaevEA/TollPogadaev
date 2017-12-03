package jdev.tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jdev.tracker.services.FortuneService;

@Controller
public class GessingController {

    @Autowired
    FortuneService fortuneService;

    @RequestMapping("/gess")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="Noname") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("num", fortuneService.tryFortune());
        return "gessing";
    }

}
