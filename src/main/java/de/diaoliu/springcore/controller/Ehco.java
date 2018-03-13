package de.diaoliu.springcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/echo")
public class Ehco {

    @RequestMapping(value="/{message}", method = RequestMethod.GET)
    public String getEcho(@PathVariable String message) {
        return "Message: " + message + " received!";
    }

}
