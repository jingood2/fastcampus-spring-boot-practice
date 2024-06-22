package com.fastcampus.fastcampusspringbootpractice.api;

import com.fastcampus.fastcampusspringbootpractice.constant.ErrorCode;
import com.fastcampus.fastcampusspringbootpractice.constant.PlaceType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(APIPlaceController.class)
class APIPlaceControllerTest {

    private final MockMvc mvc;

    public APIPlaceControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[API][GET] 장소리스트 조회")
    @Test
    void giverNothing_whenRequestingPlaces_thenReturnsListOfPageInStandardResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/places"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].placeType").value(PlaceType.COMMON.name()))
                .andExpect(jsonPath("$.data[0].placeName").value("배드민턴장"))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.OK.getCode()))
                .andExpect(jsonPath("$.message").value(ErrorCode.OK.getMessage()))
                .andDo(print());


    }

    @DisplayName("[API][GET] 단일 장소 조회")
    @Test
    void giverPlaceAndId_whenRequestingPlace_thenReturnsPlaceInStandardResponse() throws Exception {
        // Given
        int placeId = 1;


        // When & Then
        mvc.perform(get("/api/places/" + placeId))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isMap())
                .andExpect(jsonPath("$.data.placeType").value(PlaceType.COMMON.name()))
                .andExpect(jsonPath("$.data.placeName").value("배드민턴장"))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.OK.getCode()))
                .andExpect(jsonPath("$.message").value(ErrorCode.OK.getMessage()))
                .andDo(print());


    }


}