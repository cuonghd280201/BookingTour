package com.example.Tour_Booking.service;

import com.example.Tour_Booking.dto.BaseResponseDTO;
import org.springframework.http.ResponseEntity;

public interface CityService {
    ResponseEntity<BaseResponseDTO> getAllCity();
}
