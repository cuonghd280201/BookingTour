package com.example.Tour_Booking.controller;

import com.example.Tour_Booking.dto.BannerAddMoreForm;
import com.example.Tour_Booking.dto.BannerDTO;
import com.example.Tour_Booking.dto.BaseResponseDTO;
import com.example.Tour_Booking.dto.TourCreateForm;
import com.example.Tour_Booking.service.BannerService;
import com.example.Tour_Booking.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequestMapping("api/v1/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    private final BannerService bannerService;

    @GetMapping("/tourBanner/viewBanner")
    public ResponseEntity<BaseResponseDTO> viewBannerList(){
        return staffService.viewBannerList();
    }
    @PostMapping("/tourBanner/addMoreBanner")
    public ResponseEntity<BaseResponseDTO> addMoreBanner(@RequestBody BannerAddMoreForm bannerAddMoreForm){
        return  staffService.addMoreBanne(bannerAddMoreForm);
    }

    @PutMapping("/tourBanner/updateBanner")
    public ResponseEntity<BaseResponseDTO> updateBanner(@RequestBody BannerDTO bannerDTO){
        return staffService.updateBanner(bannerDTO);
    }

    @PostMapping("/tour/create")
    public ResponseEntity<BaseResponseDTO> createTour(@RequestBody TourCreateForm tourCreateForm){
        return staffService.createTour(tourCreateForm);
    }

}
