package com.example.Tour_Booking.controller;

import com.example.Tour_Booking.dto.*;
import com.example.Tour_Booking.service.BannerService;
import com.example.Tour_Booking.service.StaffService1;
import com.example.Tour_Booking.service.TourImageService;
import com.example.Tour_Booking.service.TourVisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("api/v1/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService1 staffService1;

    private final BannerService bannerService;

    private final TourVisitorService tourVisitorService;

    private final TourImageService tourImageService;

    @GetMapping("/tourBanner/viewBanner")
    public ResponseEntity<BaseResponseDTO> viewBannerList(){
        return staffService1.viewBannerList();
    }
    @PostMapping("/tourBanner/addMoreBanner")
    public ResponseEntity<BaseResponseDTO> addMoreBanner(@RequestBody BannerAddMoreForm bannerAddMoreForm){
        return  staffService1.addMoreBanne(bannerAddMoreForm);
    }

    @PutMapping("/tourBanner/updateBanner")
    public ResponseEntity<BaseResponseDTO> updateBanner(@RequestBody BannerDTO bannerDTO){
        return staffService1.updateBanner(bannerDTO);
    }

    @PostMapping("/tour/create")
    public ResponseEntity<BaseResponseDTO> createTour(@RequestBody TourCreateForm tourCreateForm){
        return staffService1.createTour(tourCreateForm);
    }

    @PutMapping("/tourVisitor/updateTourVisitor")
    public ResponseEntity<BaseResponseDTO> updateTourVisitor(@RequestBody TourVisitorDTO tourVisitorDTO){
        return tourVisitorService.updateTourVisitorById(tourVisitorDTO);
    }

    @DeleteMapping("/tourBanner/deleteBanner")
    public ResponseEntity<BaseResponseDTO> deleteBanner(UUID id){
        return staffService1.deleteBanner(id);
    }

    @PostMapping("/tourImage/addMoreImage")
    public ResponseEntity<BaseResponseDTO> addMoreImageTour(@RequestBody TourImageAddMoreForm tourImageAddMoreForm){
        return staffService1.addMoreImage(tourImageAddMoreForm);
    }

    @PutMapping("/tourImage/updateImage")
    public ResponseEntity<BaseResponseDTO> updateImageTour(@RequestBody TourImageDTO tourImageDTO){
        return staffService1.updateImage(tourImageDTO);
    }

    @DeleteMapping("/tourImage/deleteImage")
    public ResponseEntity<BaseResponseDTO> deleteImageTour(UUID id){
        return staffService1.deleteImage(id);
    }

    @GetMapping("/tourImage/listTourImage")
    public ResponseEntity<BaseResponseDTO> getAllImage(){
        return staffService1.getAllImage();
    }

}
