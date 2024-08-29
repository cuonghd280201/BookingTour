package com.example.Tour_Booking.service;

import com.example.Tour_Booking.config.CityMapper;
import com.example.Tour_Booking.config.MapperConfig;
import com.example.Tour_Booking.dto.BaseResponseDTO;
import com.example.Tour_Booking.dto.CityDTO;
import com.example.Tour_Booking.entity.City;
import com.example.Tour_Booking.repository.CityRepository;
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
public class CityService1 {

    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;
    private final CityMapper cityMapper;
    private final MapperConfig mapperConfig;

//    public ResponseEntity<BaseResponseDTO> getAllCity(){
//        List<City> cityList = cityRepository.findAll();
//        List<CityDTO> cityDTOList = cityList.stream().map(city -> modelMapper.map(city, CityDTO.class)).collect(Collectors.toList());
//        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "Succesfully", cityDTOList));
//    }
    public ResponseEntity<BaseResponseDTO> getAllCities(){
        List<City> cityList = cityRepository.findAll();
        List<CityDTO> cities = cityList.stream().map(mapperConfig::cityToCity).collect(Collectors.toList());
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "Successfully", cities));
    }


}
