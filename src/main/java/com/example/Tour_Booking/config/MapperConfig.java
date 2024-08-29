package com.example.Tour_Booking.config;

import com.example.Tour_Booking.dto.CityDTO;
import com.example.Tour_Booking.dto.TourImageDTO;
import com.example.Tour_Booking.dto.TourScheduleDTO;
import com.example.Tour_Booking.entity.City;
import com.example.Tour_Booking.entity.TourImages;
import com.example.Tour_Booking.entity.TourSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapperConfig {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CityDTO cityToCity(City city);

    TourImageDTO imageToImage(TourImages tourImages);

    TourScheduleDTO scheduleToSchedule(TourSchedule tourSchedule);
}
