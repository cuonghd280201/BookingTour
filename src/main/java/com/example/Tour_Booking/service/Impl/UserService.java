package com.example.Tour_Booking.service.Impl;


import com.example.Tour_Booking.config.MapperConfig;
import com.example.Tour_Booking.dto.BaseResponseDTO;
import com.example.Tour_Booking.dto.UserDTO;
import com.example.Tour_Booking.entity.User;
import com.example.Tour_Booking.exception.ResourceNotFoundException;
import com.example.Tour_Booking.repository.RoleRepository;
import com.example.Tour_Booking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final RoleRepository roleRepository;
    private final MapperConfig mapperConfig;
    private final UserRepository userRepository;

//    public ResponseEntity<BaseResponseDTO> saveUser(String uid){
//        User user = userRepository.findById(uid).orElseThrow(()-> new ResourceNotFoundException("Not found user"));
//        UserDTO userDTO = new UserDTO();
//        user.setEmail(userDTO.getEmail());
//        user.setName(userDTO.getName());
//        user.setImage(userDTO.getImage());
//        user.setRole(roleRepository.findByName("USER"));
//        user.setEnable(true);
//        user.setPhone(null);
//        userRepository.save(user);
//        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.CREATED, "Successfully"));
//    }
}
