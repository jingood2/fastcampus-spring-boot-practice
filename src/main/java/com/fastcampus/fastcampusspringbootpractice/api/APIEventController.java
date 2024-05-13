package com.fastcampus.fastcampusspringbootpractice.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("/events")
    public List<String> getEvents(){
        return List.of("event1", "event2");
    }

    @PostMapping("/events")
    public Boolean createEvent(){
        return true;
    }

    @GetMapping("/events/{eventId}")
    public String getEvent(@PathVariable Integer eventId){
        return "get event";
    }

    @PutMapping("/events/{eventId}")
    public Boolean updateEvent(@PathVariable Integer eventId){
        return true;
    }

    @DeleteMapping("/events/{eventId}")
    public Boolean deleteEvent(@PathVariable Integer eventId){
        return true;
    }

}
