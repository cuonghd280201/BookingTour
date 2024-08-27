package com.example.Tour_Booking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BannerDTO {
    private UUID id;
    private String image;
}
