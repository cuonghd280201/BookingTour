package com.example.Tour_Booking.service.Impl;

import com.example.Tour_Booking.common.TimeStatus;
import com.example.Tour_Booking.dto.TourTimeCreateForm;
import com.example.Tour_Booking.dto.TourTimeDTO;
import com.example.Tour_Booking.entity.TourTime;
import com.example.Tour_Booking.exception.ResourceNotFoundException;
import com.example.Tour_Booking.repository.TourTimeRepository;
import com.example.Tour_Booking.service.TourService;
import com.example.Tour_Booking.service.TourTimeService;
import com.example.Tour_Booking.utils.CodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TourTimeServiceImpl implements TourTimeService {
    private final TourTimeRepository tourTimeRepository;

    @Override
    public Set<TourTime> createTime(Set<TourTimeCreateForm> listTourTime) {
        Set<TourTime> tourTimeList = new HashSet<>();
        for (TourTimeCreateForm tourTimeCreateForm: listTourTime){
            TourTime tourTime = new TourTime();
            tourTime.setStartDate(tourTimeCreateForm.getStartDate());
            tourTime.setEndDate(tourTimeCreateForm.getEndDate());
            tourTime.setStartTime(tourTimeCreateForm.getStartTime());
            tourTime.setSlotNumber(tourTimeCreateForm.getSlotNumber());
            tourTime.setSlotNumberActual(0);
            tourTime.setTimeStatus(TimeStatus.ACTIVE);

            String code = CodeGenerator.generate("TM");
            while (tourTimeRepository.findByCode(code).isPresent()){
                code = CodeGenerator.generate("TM");
            }
            tourTime.setCode(code);
            tourTimeList.add(tourTime);
            tourTimeRepository.save(tourTime);
        }
        return tourTimeList;
    }

    @Override
    public void updateTime(TourTimeDTO tourTimeDTO, TourTime tourTime) {
        tourTime.setStartTime(tourTimeDTO.getStartTime());
        tourTime.setStartDate(tourTimeDTO.getStartDate());
        tourTime.setEndDate(tourTimeDTO.getEndDate());
        tourTime.setSlotNumber(tourTimeDTO.getSlotNumber());
        tourTime.setSlotNumberActual(tourTimeDTO.getSlotNumberActual());
        tourTime.setCreateDate(tourTimeDTO.getCreateDate());
        tourTime.setTimeStatus(tourTimeDTO.getTimeStatus());
        tourTime.setDeleted(tourTimeDTO.isDeleted());
        tourTimeRepository.save(tourTime);
    }

    @Override
    public TourTime findById(UUID id) {
        return tourTimeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Time not found"));
    }
}
