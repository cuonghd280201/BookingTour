package com.example.Tour_Booking.config;

import com.example.Tour_Booking.dto.CityDTO;
import com.example.Tour_Booking.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CityDTO cityToCity(City city);

}
