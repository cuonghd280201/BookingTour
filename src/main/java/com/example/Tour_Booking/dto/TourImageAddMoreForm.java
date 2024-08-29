package com.example.Tour_Booking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourImageAddMoreForm {
    private UUID id;

    private Set<TourImageCreateForm> tourImageCreateFormSet;
}
