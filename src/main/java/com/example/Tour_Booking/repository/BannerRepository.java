package com.example.Tour_Booking.repository;

import com.example.Tour_Booking.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BannerRepository extends JpaRepository<Banner, UUID> {
}
