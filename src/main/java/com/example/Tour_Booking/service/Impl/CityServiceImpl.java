package com.example.Tour_Booking.service.Impl;

import com.example.Tour_Booking.dto.BaseResponseDTO;
import com.example.Tour_Booking.dto.CityDTO;
import com.example.Tour_Booking.entity.City;
import com.example.Tour_Booking.repository.CityRepository;
import com.example.Tour_Booking.service.CityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<BaseResponseDTO> getAllCity() {
        List<City> cityList = cityRepository.findAll();
        List<CityDTO> cityDTOList = cityList.stream()
                .map(city -> modelMapper.map(city, CityDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "Successfully", cityDTOList));
    }
}
