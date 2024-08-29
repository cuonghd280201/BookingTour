package com.example.Tour_Booking.service;

import com.example.Tour_Booking.dto.TourDetailCreateForm;
import com.example.Tour_Booking.entity.TourDetail;
import com.example.Tour_Booking.entity.User;

public interface TourDetailService {
    TourDetail createTourDetail(TourDetailCreateForm tourDetailCreateForm);
}
