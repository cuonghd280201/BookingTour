package com.example.Tour_Booking.service.Impl;

import com.example.Tour_Booking.dto.BannerCreateForm;
import com.example.Tour_Booking.dto.BannerDTO;
import com.example.Tour_Booking.entity.Banner;
import com.example.Tour_Booking.exception.ResourceNotFoundException;
import com.example.Tour_Booking.repository.BannerRepository;
import com.example.Tour_Booking.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerRepository bannerRepository;
    @Override
    public Set<Banner> createBanner(Set<BannerCreateForm> listBanner) {

        Set<Banner> bannerSet = new HashSet<>();
        for(BannerCreateForm bannerCreateForm: listBanner){
            Banner banner = new Banner();
            banner.setImage(bannerCreateForm.getImage());
            bannerSet.add(banner);
            bannerRepository.save(banner);
        }
        return bannerSet;
    }

    @Override
    public void updateBanner(BannerDTO bannerDTO) {
        Banner banner = bannerRepository.findById(bannerDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Banner not found"));
        if(bannerDTO.getImage() == null){
             bannerDTO.setImage(banner.getImage());
             banner.setImage(bannerDTO.getImage());
             bannerRepository.save(banner);
        }

    }

    @Override
    public List<Banner> viewBannerList() {
        return bannerRepository.findAll();
    }

    @Override
    public void deleteBanner(UUID id) {
        Banner banner = bannerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Banner not found"));
        bannerRepository.deleteById(id);

    }
}
