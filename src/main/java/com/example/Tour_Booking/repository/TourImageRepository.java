package com.example.Tour_Booking.repository;

import com.example.Tour_Booking.entity.TourImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TourImageRepository extends JpaRepository<TourImages, UUID> {
}
