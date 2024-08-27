package com.example.Tour_Booking.dto;

import java.math.BigDecimal;
import java.util.Set;

public class TourCreateForm {
    private String title;

    private String starLocation;

    private String endLocation;

    private String description;

    private BigDecimal price;

    private String coverImage;

    private String city;

//    private TourDetailCreateForm tourDetailCreateForm;

    private Set<TourScheduleCreateForm> listTourSchedule;

    private Set<TourTimeCreateForm> tourTimeCreateFormSet;

    private Set<TourImageCreateForm> tourImageCreateForms;
}
