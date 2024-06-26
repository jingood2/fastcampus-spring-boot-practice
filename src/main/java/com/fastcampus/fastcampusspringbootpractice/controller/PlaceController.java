package com.fastcampus.fastcampusspringbootpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/places")
@Controller
public class PlaceController {

    @GetMapping("/")
    public String place() {
        return "places";
    }

    @GetMapping("/{placeId}")
    public String placeDetail(@PathVariable("placeId") Integer placeId) {
        return "place/detail";
    }
}
