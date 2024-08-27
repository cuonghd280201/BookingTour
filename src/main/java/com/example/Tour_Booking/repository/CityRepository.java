package com.example.Tour_Booking.repository;

import com.example.Tour_Booking.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
    Optional<City> findByName(String name);
}
