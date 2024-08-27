package com.example.Tour_Booking.repository;

import com.example.Tour_Booking.entity.TourSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TourScheduleRepository extends JpaRepository<TourSchedule, UUID> {
}
