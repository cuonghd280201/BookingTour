package com.example.Tour_Booking.service.Impl;


import com.example.Tour_Booking.dto.BannerAddMoreForm;
import com.example.Tour_Booking.dto.BannerDTO;
import com.example.Tour_Booking.dto.BaseResponseDTO;
import com.example.Tour_Booking.entity.Banner;
import com.example.Tour_Booking.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    @Autowired
    private BannerServiceImpl bannerService;


    @Override
    public ResponseEntity<BaseResponseDTO> addMoreBanne(BannerAddMoreForm bannerAddMoreForm) {
        Set<Banner> bannerSet = bannerService.createBanner(bannerAddMoreForm.getBannerCreateFormSet());
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "Create Banner Successfully"));
    }

    @Override
    public ResponseEntity<BaseResponseDTO> viewBannerList() {
        List<Banner> banners = bannerService.viewBannerList();
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "View List Banner Successfully", banners));
    }

    @Override
    public ResponseEntity<BaseResponseDTO> updateBanner(BannerDTO bannerDTO) {
        bannerService.updateBanner(bannerDTO);
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "Update Banner Successfully"));
    }

    @Override
    public ResponseEntity<BaseResponseDTO> deleteBanner(UUID id) {
        bannerService.deleteBanner(id);
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "Delete Banner Successfully"));
    }

}
