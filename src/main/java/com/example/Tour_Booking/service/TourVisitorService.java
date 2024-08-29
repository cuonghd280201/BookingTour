package com.example.Tour_Booking.service;

import com.example.Tour_Booking.config.MapperConfig;
import com.example.Tour_Booking.dto.BaseResponseDTO;
import com.example.Tour_Booking.dto.TourVisitorDTO;
import com.example.Tour_Booking.entity.TourVisitor;
import com.example.Tour_Booking.exception.ResourceNotFoundException;
import com.example.Tour_Booking.repository.TourVisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TourVisitorService {
    private final TourVisitorRepository tourVisitorRepository;
    private final MapperConfig mapperConfig;

    public ResponseEntity<BaseResponseDTO> updateTourVisitorById(TourVisitorDTO tourVisitorDTO){
        TourVisitor tourVisitor = tourVisitorRepository.findById(tourVisitorDTO.getId()).orElseThrow(() -> new
        ResourceNotFoundException("Visitor Not Found"));
        tourVisitorDTO = mapperConfig.visitorToVisitor(tourVisitor);
        tourVisitorRepository.save(tourVisitor);
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "Update Succesfully"));
    }
}
