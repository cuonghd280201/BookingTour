package com.example.Tour_Booking.repository;

import com.example.Tour_Booking.entity.TourVisitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TourVisitorRepository extends JpaRepository<TourVisitor, UUID> {
}
