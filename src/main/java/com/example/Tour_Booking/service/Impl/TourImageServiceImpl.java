package com.example.Tour_Booking.service.Impl;

import com.example.Tour_Booking.dto.TourImageCreateForm;
import com.example.Tour_Booking.dto.TourImageDTO;
import com.example.Tour_Booking.entity.TourImages;
import com.example.Tour_Booking.exception.ResourceNotFoundException;
import com.example.Tour_Booking.repository.TourImageRepository;
import com.example.Tour_Booking.service.TourImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TourImageServiceImpl implements TourImageService {
    private final TourImageRepository tourImageRepository;
    @Override
    public Set<TourImages> createImage(Set<TourImageCreateForm> listTourImage) {
            Set<TourImages> tourImagesSet = new HashSet<>();
            for(TourImageCreateForm tourImageCreateForm : listTourImage){
                TourImages tourImages = new TourImages();
                tourImages.setImage(tourImageCreateForm.getImage());
                tourImagesSet.add(tourImages);
            }
        return tourImagesSet;
    }

    @Override
    public void updateImage(TourImageDTO tourImageDTO) {
        TourImages tourImages = tourImageRepository.findById(tourImageDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Image not found"));
        String imageLink = tourImageDTO.getImage();
        if(imageLink.isEmpty()){
            tourImageDTO.setImage(tourImages.getImage());
        }
        tourImages.setImage(tourImageDTO.getImage());
        tourImageRepository.save(tourImages);

    }

    @Override
    public void deleteImage(UUID id) {
        TourImages tourImages = tourImageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Image not found"));
        tourImageRepository.deleteById(id);
    }
}
