package com.example.Tour_Booking.service;

import com.example.Tour_Booking.dto.BannerAddMoreForm;
import com.example.Tour_Booking.dto.BannerDTO;
import com.example.Tour_Booking.dto.BaseResponseDTO;
import com.example.Tour_Booking.dto.TourCreateForm;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.UUID;

public interface StaffService {
    ResponseEntity<BaseResponseDTO> addMoreBanne(BannerAddMoreForm bannerAddMoreForm);
    ResponseEntity<BaseResponseDTO> viewBannerList();

    ResponseEntity<BaseResponseDTO> updateBanner(BannerDTO bannerDTO);

    ResponseEntity<BaseResponseDTO> deleteBanner(UUID id);

    ResponseEntity<BaseResponseDTO> createTour(Principal principal, TourCreateForm tourCreateForm);
}
