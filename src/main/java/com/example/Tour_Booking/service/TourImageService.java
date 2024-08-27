package com.example.Tour_Booking.service;

import com.example.Tour_Booking.dto.TourImageCreateForm;
import com.example.Tour_Booking.dto.TourImageDTO;
import com.example.Tour_Booking.entity.TourImages;

import java.util.Set;
import java.util.UUID;

public interface TourImageService {
    Set<TourImages> createImage(Set<TourImageCreateForm> tourImageCreateForms);

    void updateImage(TourImageDTO tourImageDTO);

    void deleteImage(UUID id);
}
