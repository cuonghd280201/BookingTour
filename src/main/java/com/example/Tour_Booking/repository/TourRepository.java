package com.example.Tour_Booking.repository;

import com.example.Tour_Booking.dto.BaseResponseDTO;
import com.example.Tour_Booking.entity.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TourRepository extends JpaRepository<Tour, UUID> {
    Page<Tour> findAll(Pageable pageable);
    Optional<Tour> findByCode(String code);

//    @Query("SELECT t.id, t.code, t.cover_Image, t.create_By, t.create_Date, t.deleted, t.description, t.end_Location, t.price, t.start_Location, t.title,  t.update_By, t.update_Date, t.city_Id, t.tour_Detail_Id, \n" +
//            "            td.id, td.create_By, td.deleted, td.food, td.hotel, td.location, td.time, td.vehicle, ti.id, ti.image, \n" +
//            "            ts.id, ts.create_Date, ts.day, ts.deleted, ts.description, ts.title, ts.update_Date, \n" +
//            "            tt.id, tt.code, tt.create_Date, tt.deleted, tt.end_Date, tt.slot_Number, tt.slot_Number_Actual, tt.start_Date, tt.start_Time,  tt.update_Date \n" +
//            "            FROM Tour t \n" +
//            "            LEFT JOIN Tour_Detail td ON t.tour_Detail_Id = td.id \n" +
//            "            LEFT JOIN Tour_Images ti ON t.id = ti.tour_Id \n" +
//            "            LEFT JOIN Tour_Schedule ts ON t.id = ts.tour_Id \n" +
//            "            LEFT JOIN Tour_Time tt ON t.id = tt.tour_Id")
//    Page<Tour> getAllTour(Pageable pageable);

}
