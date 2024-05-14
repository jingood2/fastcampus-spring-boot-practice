package com.fastcampus.fastcampusspringbootpractice.controller;

import com.fastcampus.fastcampusspringbootpractice.constant.PlaceType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.HashMap;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/places")
    // NOTE : @RequestPlaram 이 들어가면 default로 required가 필수
    public ModelAndView adminPlaces(
            PlaceType placeType,
            String placeName,
            String address) {

        Map<String, Object> map = new HashMap<>();
        map.put("placeType", placeType);
        map.put("placeName", placeName);
        map.put("address", address);

        return new ModelAndView("admin/places", map);
    }

    @GetMapping("/places/{placeId}")
    public String adminPlaceDetail(@PathVariable ("placeId") Integer placeId) {
        return "admin/place-detail";
    }

    @GetMapping("/events")
    public String adminEvents() {
        return "admin/events";
    }

    @GetMapping("/events/{eventId}")
    public String adminEventDetail(@PathVariable ("eventId") Integer eventId) {
        return "admin/event-detail";
    }

}
