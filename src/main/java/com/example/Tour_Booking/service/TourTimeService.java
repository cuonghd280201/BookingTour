package com.example.Tour_Booking.service;

import com.example.Tour_Booking.dto.TourTimeCreateForm;
import com.example.Tour_Booking.dto.TourTimeDTO;
import com.example.Tour_Booking.entity.TourTime;

import java.util.Set;
import java.util.UUID;

public interface TourTimeService {
    Set<TourTime> createTime(Set<TourTimeCreateForm> listTourTime);

    void updateTime(TourTimeDTO tourTimeDTO, TourTime tourTime);

    TourTime findById(UUID id);
}
