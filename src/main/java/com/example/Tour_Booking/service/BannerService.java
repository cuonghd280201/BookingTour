package com.example.Tour_Booking.service;

import com.example.Tour_Booking.dto.BannerCreateForm;
import com.example.Tour_Booking.dto.BannerDTO;
import com.example.Tour_Booking.entity.Banner;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface BannerService {

    Set<Banner> createBanner(Set<BannerCreateForm> listBanner);
    void updateBanner(BannerDTO bannerDTO);
    List<Banner> viewBannerList();

    void deleteBanner(UUID id);
}
