package com.example.Tour_Booking.service.Impl;

import com.example.Tour_Booking.dto.TourDetailCreateForm;
import com.example.Tour_Booking.entity.TourDetail;
import com.example.Tour_Booking.entity.User;
import com.example.Tour_Booking.repository.TourDetailRepository;
import com.example.Tour_Booking.repository.UserRepository;
import com.example.Tour_Booking.service.TourDetailService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TourDetailServiceImpl implements TourDetailService {
    private final TourDetailRepository tourDetailRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Override
    public TourDetail createTourDetail(TourDetailCreateForm tourDetailCreateForm) {
        TourDetail tourDetail =modelMapper.map(tourDetailCreateForm, TourDetail.class);
       // tourDetail.setCreateBy(user.getName());
        return tourDetail;
    }
}
