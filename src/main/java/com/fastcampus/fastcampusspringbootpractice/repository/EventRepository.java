package com.fastcampus.fastcampusspringbootpractice.repository;

import com.fastcampus.fastcampusspringbootpractice.constant.EventStatus;
import com.fastcampus.fastcampusspringbootpractice.dto.EventDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventRepository {

    // please make EventRepository
    default List<EventDTO> findEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDateTime,
            LocalDateTime eventEndDatetime
    ){ return List.of(); }

    default Optional<EventDTO> findEventById(Long eventId) { return Optional.empty(); }
    default boolean createEvent(EventDTO eventDTO) { return true;}
    default boolean updateEvent(Long eventId , EventDTO eventDTO) { return true;}
    default boolean deleteEvent(Long eventId) { return true;}

}
