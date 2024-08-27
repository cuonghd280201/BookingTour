package com.example.Tour_Booking.repository;

import com.example.Tour_Booking.entity.TourTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TourTimeRepository extends JpaRepository<TourTime, UUID> {
    Optional<TourTime> findByCode(String code);
}
