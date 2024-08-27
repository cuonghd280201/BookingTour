package com.example.Tour_Booking.repository;

import com.example.Tour_Booking.entity.Role;
import com.example.Tour_Booking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    Optional<User> findByFireBaseUid(String fireBaseUid);

    List<User> findAllByRole(Role role);
}
