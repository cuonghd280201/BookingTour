package com.example.Tour_Booking.service;

import com.example.Tour_Booking.dto.TourScheduleCreateForm;
import com.example.Tour_Booking.entity.TourSchedule;

import java.util.Set;

public interface TourScheduleService {
    Set<TourSchedule> createTourSchedule(Set<TourScheduleCreateForm> listScheduleForm);
}
