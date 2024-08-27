package com.example.Tour_Booking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BannerAddMoreForm {
    private Set<BannerCreateForm> bannerCreateFormSet;
}
