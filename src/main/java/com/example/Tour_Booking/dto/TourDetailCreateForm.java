package com.example.Tour_Booking.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourDetailCreateForm {
    private String time;

    private String vehicle;

    private String location;

    private String food;

    private String hotel;
}
