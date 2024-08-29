package com.example.Tour_Booking.controller;


import com.example.Tour_Booking.dto.BaseResponseDTO;
import com.example.Tour_Booking.service.Impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.UUID;

@RestController()
@RequestMapping("api/v1/guest")
@RequiredArgsConstructor
public class GuestController {
    private final UserService userService;

//    @PostMapping("/save")
//    public ResponseEntity<BaseResponseDTO> setUser(Principal principal){
//        String uid = principal.getName();
//        return userService.saveUser(uid);
//    }
}
