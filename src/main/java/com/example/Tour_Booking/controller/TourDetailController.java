package com.example.Tour_Booking.controller;

import com.example.Tour_Booking.dto.BaseResponseDTO;
import com.example.Tour_Booking.dto.TourDetailCreateForm;
import com.example.Tour_Booking.service.TourDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/tour-detail")
@RequiredArgsConstructor
public class TourDetailController {
    private final TourDetailService tourDetailService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponseDTO> createTourDetail(Principal principal, @RequestBody TourDetailCreateForm tourDetailCreateForm){
        return null;
    }
}
