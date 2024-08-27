package com.example.Tour_Booking.service.Impl;

import com.example.Tour_Booking.dto.TourScheduleCreateForm;
import com.example.Tour_Booking.entity.TourSchedule;
import com.example.Tour_Booking.repository.TourScheduleRepository;
import com.example.Tour_Booking.service.TourScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TourScheduleServiceImpl implements TourScheduleService {
    private final TourScheduleRepository tourScheduleRepository;
    @Override
    public Set<TourSchedule> createTourSchedule(Set<TourScheduleCreateForm> listScheduleForm) {
        Set<TourSchedule> listTourSchedule = new HashSet<>();
        for (TourScheduleCreateForm dto : listScheduleForm){
            TourSchedule tourSchedule = new TourSchedule();
            tourSchedule.setDay(dto.getDay());
            tourSchedule.setTitle(dto.getTitle());
            tourSchedule.setDescription(dto.getDescription());
            listTourSchedule.add(tourSchedule);
            tourScheduleRepository.save(tourSchedule);
        }
        return listTourSchedule;
    }
}
