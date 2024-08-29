package com.example.Tour_Booking.repository;

import com.example.Tour_Booking.entity.TourDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TourDetailRepository extends JpaRepository<TourDetail, UUID> {

}
