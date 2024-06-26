package com.fastcampus.fastcampusspringbootpractice.domain;

import com.fastcampus.fastcampusspringbootpractice.constant.EventStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Event {
    private Long id;

    private String placeId;
    private String eventName;
    private EventStatus eventStatus;
    private LocalDateTime eventStartDatetime;
    private LocalDateTime eventEndDatetime;
    private Integer currentNumberOfPeople;
    private Integer capacity;
    private String memo;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
