package com.fastcampus.fastcampusspringbootpractice.api;

import com.fastcampus.fastcampusspringbootpractice.constant.ErrorCode;
import com.fastcampus.fastcampusspringbootpractice.dto.APIErrorResponse;
import com.fastcampus.fastcampusspringbootpractice.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("/events")
    public List<String> getEvents() throws Exception {
        throw new HttpRequestMethodNotSupportedException("GET");
        //return List.of("event1", "event2");
    }

    @PostMapping("/events")
    public Boolean createEvent(){
        throw new RuntimeException("장군님");
        //return true;
    }

    @GetMapping("/events/{eventId}")
    public String getEvent(@PathVariable Integer eventId){
        throw new RuntimeException("런타임에러");
        //return "get event";
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
