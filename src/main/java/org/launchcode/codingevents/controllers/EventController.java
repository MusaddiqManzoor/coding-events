package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")

public class EventController {

    private static List<String> events = new ArrayList<>();

//    @GetMapping
//    public String displayAllEvents(Model model) {
//        model.addAttribute("events", events);
//        return "events/index";
//    }

    @GetMapping
    public static String displayAllEvents(Model model) {
        HashMap<String, String> events = new HashMap<>();
        events.put("Apple WWDC", "This is a meetup of developers in Apple");
        events.put("SpringOne platform", "This is for people with spring skills.");
        events.put("LC-101", "This is for new techies ready to make a career in tech");
        model.addAttribute("events", events);
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm(){
        return "events/create";
    }

    @PostMapping("create")
    public String addCreateEvent(@RequestParam String eventName) {
        events.add(eventName);
        return "redirect:";

    }
}
