package com.example.Tour_Booking.service.Impl;

import com.example.Tour_Booking.common.PageableRequest;
import com.example.Tour_Booking.common.Pagination;
import com.example.Tour_Booking.dto.*;
import com.example.Tour_Booking.entity.Tour;
import com.example.Tour_Booking.entity.TourImages;
import com.example.Tour_Booking.entity.TourSchedule;
import com.example.Tour_Booking.entity.TourTime;
import com.example.Tour_Booking.exception.ResourceNotFoundException;
import com.example.Tour_Booking.repository.TourRepository;
import com.example.Tour_Booking.service.TourService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;
    private final ModelMapper modelMapper;
    @Override
    public ResponseEntity<BaseResponseDTO> getAllTour(int pageNumber, int pageSize, String sortBy, String sortOrder) {
        PageableRequest pageableRequest = new PageableRequest(pageNumber, pageSize, sortBy, sortOrder);
        Pageable pageable = pageableRequest.toPageable();
        Page<Tour> tourPage = null;
        List<Tour> tourList;
        List<TourDTO> tourDTOS = null;
        tourPage = tourRepository.findAll(pageable);
        tourList = tourPage.getContent();
        tourDTOS = tourList.stream().map(this:: convertToTourDTO).toList();
        Pagination pagination = new Pagination(tourPage.getNumber(), tourPage.getTotalElements(), tourPage.getTotalPages());
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "Successfully", pagination, tourDTOS));
    }

    @Override
    public ResponseEntity<BaseResponseDTO> getTourById(UUID id) {
        Tour tour = tourRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found id"));
        TourInfoDTO tourInfoDTO = convertToInfoTourDTO(tour);
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.FOUND, "Get Tour Detail Successfully!", tourInfoDTO));
    }

    private TourInfoDTO convertToInfoTourDTO(Tour tour) {
        TourInfoDTO tourInfoDTO = modelMapper.map(tour, TourInfoDTO.class);
        if(tour.getTourSchedules() == null){
            tour.setTourSchedules(null);
        }
        if(tour.getTourTimeSet() == null){
            tour.setTourTimeSet(null);
        }
        if(tour.getTourImagesSet() == null){
            tour.setTourImagesSet(null);
        }
    // tour detail

        Set<TourImageDTO> tourImageDTOSet = new HashSet<>();
        for (TourImages tourImages: tour.getTourImagesSet()){
            TourImageDTO tourImageDTO = modelMapper.map(tourImages, TourImageDTO.class);
            tourImageDTOSet.add(tourImageDTO);
        }

        Set<TourScheduleDTO> tourScheduleDTOS = new HashSet<>();
        for(TourSchedule tourSchedule: tour.getTourSchedules()){
            TourScheduleDTO tourScheduleDTO = modelMapper.map(tourSchedule, TourScheduleDTO.class);
            tourScheduleDTOS.add(tourScheduleDTO);
        }

        Set<TourTimeDTO> tourTimeDTOS = new HashSet<>();
        for (TourTime tourTime : tour.getTourTimeSet()){
            TourTimeDTO tourTimeDTO = modelMapper.map(tourTime, TourTimeDTO.class);
            tourTimeDTOS.add(tourTimeDTO);
        }

    //    tourInfoDTO.setTourDetail(tourDetailDTO);
        tourInfoDTO.setTourImagesSet(tourImageDTOSet);
        tourInfoDTO.setTourSchedules(tourScheduleDTOS);
        tourInfoDTO.setTourTimeSet(tourTimeDTOS);
        return tourInfoDTO;
    }

    public TourDTO convertToTourDTO(Tour tour){
        if(tour == null){
            return null;
        }
        return modelMapper.map(tour, TourDTO.class);
    }
}
