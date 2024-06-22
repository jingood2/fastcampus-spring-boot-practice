package com.fastcampus.fastcampusspringbootpractice.service;

import ch.qos.logback.classic.Logger;
import com.fastcampus.fastcampusspringbootpractice.constant.EventStatus;
import com.fastcampus.fastcampusspringbootpractice.dto.EventDTO;
import com.fastcampus.fastcampusspringbootpractice.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * 이벤트 서비스
 */
@Service
@RequiredArgsConstructor
public class EventService {

    private final Logger log = (Logger) LoggerFactory.getLogger(EventService.class);

    private final EventRepository eventRepository;


    public List<EventDTO> findEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
             LocalDateTime eventEndDatetime
    ) {
        log.info("Finding events...");
        return eventRepository.findEvents(placeId, eventName, eventStatus, eventStartDatetime, eventEndDatetime);
    }

    public Optional<EventDTO> findEventById(Long eventId) {
        log.info("Finding event by ID: {}", eventId);
        return eventRepository.findEventById(eventId);
        //return Optional.empty();
    }

    public boolean createEvent(EventDTO eventDTO) {
        log.info("Creating event: {}", eventDTO);
        // Input validation
//        if (eventDTO == null || eventDTO.getPlaceId() == null || eventDTO.getEventName() == null || eventDTO.getEventStatus() == null) {
//            return false;
//        }
        // Additional validation logic
        return eventRepository.createEvent(eventDTO);
        //return true;
    }

    public boolean updateEvent(Long eventId, EventDTO eventDTO) {
        log.info("Updating event with ID: {}", eventId);
        // Input validation
//        if (eventId == null || eventDTO == null || eventDTO.getPlaceId() == null || eventDTO.getEventName() == null || eventDTO.getEventStatus() == null) {
//            return false;
//        }

//      // Additional validation logic
        return eventRepository.updateEvent(eventId, eventDTO);
    }

    public boolean deleteEvent(Long eventId) {
        log.info("Deleting event with ID: {}", eventId);
        // Input validation
        if (eventId == null) {
            return false;
        }
        // Additional validation logic
        return eventRepository.deleteEvent(eventId);
    }
}
