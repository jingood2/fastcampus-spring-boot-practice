package com.fastcampus.fastcampusspringbootpractice.api;

import com.fastcampus.fastcampusspringbootpractice.constant.PlaceType;
import com.fastcampus.fastcampusspringbootpractice.dto.APIDataResponse;
import com.fastcampus.fastcampusspringbootpractice.dto.PlaceDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIPlaceController {

    @GetMapping("/places")
    public APIDataResponse<List<PlaceDTO>> getPlaces() {

        return APIDataResponse.of(List.of(PlaceDTO.of(
                PlaceType.COMMON,
                "배드민턴장",
                "강남구",
                "010-2222-2222",
                30,
                "신장개업"
        )));
    }

    @PostMapping("/places")
    public Boolean createPlace(){
        return true;
    }
    @GetMapping("/places/{placeId}")
    public APIDataResponse<PlaceDTO> getPlace(@PathVariable Integer placeId){
        return APIDataResponse.of(PlaceDTO.of(
                PlaceType.COMMON,
                "배드민턴장",
                "강남구",
                "010-2222-2222",
                30,
                "신장개업"
        ));
    }

    @PutMapping("/places/{placeId}")
    public Boolean updatePlace(@PathVariable Integer placeId){
        return true;
    }

    @DeleteMapping("/places/{placeId}")
    public Boolean deletePlace(@PathVariable Integer placeId){
        return true;
    }



}
