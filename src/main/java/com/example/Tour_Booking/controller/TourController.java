package com.example.Tour_Booking.controller;

import com.example.Tour_Booking.dto.BaseResponseDTO;
import com.example.Tour_Booking.service.StaffService;
import com.example.Tour_Booking.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/tour")
@RequiredArgsConstructor
public class TourController {
    private final TourService tourService;
    private final StaffService staffService;
    @GetMapping("/all")
    public ResponseEntity<BaseResponseDTO> getAllTour(@RequestParam(defaultValue = "0") int pageNumer, @RequestParam(defaultValue = "6") int pageSize, @RequestParam(defaultValue = "title") String sortBy, @RequestParam(defaultValue = "desc") String sortOrder){
        return tourService.getAllTour(pageNumer,pageSize,sortBy,sortOrder);
    }

    @GetMapping("/get/{tourId}")
    public ResponseEntity<BaseResponseDTO> viewTourByTourId(@PathVariable("tourId") UUID tourId){
        return tourService.getTourById(tourId);
    }
}
