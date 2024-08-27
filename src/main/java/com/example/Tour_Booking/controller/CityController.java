package com.example.Tour_Booking.controller;

import com.example.Tour_Booking.dto.BaseResponseDTO;
import com.example.Tour_Booking.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/city")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("/all")
    public ResponseEntity<BaseResponseDTO> getAllCity(){
        return cityService.getAllCity();
    }
}
