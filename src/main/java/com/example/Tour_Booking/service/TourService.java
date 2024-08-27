package com.example.Tour_Booking.service;

import com.example.Tour_Booking.dto.BaseResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface TourService {
    ResponseEntity<BaseResponseDTO> getAllTour(int pageNumber, int pageSize, String sortBy, String sortOrder);
    ResponseEntity<BaseResponseDTO> getTourById(UUID id);
}
