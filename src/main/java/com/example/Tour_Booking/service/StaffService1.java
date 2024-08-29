package com.example.Tour_Booking.service;

import com.example.Tour_Booking.common.TourStatus;
import com.example.Tour_Booking.config.MapperConfig;
import com.example.Tour_Booking.dto.*;
import com.example.Tour_Booking.entity.*;
import com.example.Tour_Booking.exception.ResourceNotFoundException;
import com.example.Tour_Booking.repository.*;
import com.example.Tour_Booking.service.Impl.BannerServiceImpl;
import com.example.Tour_Booking.service.TourDetailService;
import com.example.Tour_Booking.service.TourImageService;
import com.example.Tour_Booking.service.TourScheduleService;
import com.example.Tour_Booking.service.TourTimeService;
import com.example.Tour_Booking.utils.CodeGenerator;
import com.example.Tour_Booking.utils.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffService1 {
    private final BannerServiceImpl bannerService;
    private final UserRepository userRepository;
    private final TourDetailService tourDetailService;
    private final TourScheduleService tourScheduleService;
    private final TourRepository tourRepository;
    private final TourTimeService tourTimeService;
    private final TourImageService tourImageService;
    private final CityRepository cityRepository;
    private final TourTimeRepository tourTimeRepository;
    private final TourScheduleRepository tourScheduleRepository;
    private final TourImageRepository tourImageRepository;
    private final MapperConfig mapperConfig;




    public ResponseEntity<BaseResponseDTO> addMoreBanne(BannerAddMoreForm bannerAddMoreForm) {
        Set<Banner> bannerSet = bannerService.createBanner(bannerAddMoreForm.getBannerCreateFormSet());
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "Create Banner Successfully"));
    }

    public ResponseEntity<BaseResponseDTO> viewBannerList() {
        List<Banner> banners = bannerService.viewBannerList();
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "View List Banner Successfully", banners));
    }

    public ResponseEntity<BaseResponseDTO> updateBanner(BannerDTO bannerDTO) {
        bannerService.updateBanner(bannerDTO);
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "Update Banner Successfully"));
    }

    public ResponseEntity<BaseResponseDTO> deleteBanner(UUID id) {
        bannerService.deleteBanner(id);
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "Delete Banner Successfully"));
    }

    public ResponseEntity<BaseResponseDTO> createTour(TourCreateForm tourCreateForm) {
        //User user = userRepository.findByFireBaseUid(principal.getName()).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        List<String> listMessage = new ArrayList<>();
        if(tourCreateForm.getTourDetailCreateForm() == null){
            listMessage.add("Tour detail need to be input");
        }
        if(tourCreateForm.getListTourSchedule() == null){
            listMessage.add("Tour Schedule need to be input");
        }else{
            int scheduleDayDistance = tourCreateForm.getListTourSchedule().size();
            Set<TourTimeCreateForm> tourTimeCreateFormSet = tourCreateForm.getTourTimeCreateFormSet();
            for (TourTimeCreateForm tourTimeCreateForm : tourTimeCreateFormSet){
                LocalDate startDate = tourTimeCreateForm.getStartDate();
                LocalDate endDate = tourTimeCreateForm.getEndDate();
                LocalDate dateNow = LocalDate.now();
                int startDateResult = DateTimeUtils.actualCompareInfo(dateNow, startDate);
                if(startDateResult >= 0){
                    listMessage.add("Start Date " + startDate+ " must be in the future.");
                }
                int endDateResult = DateTimeUtils.actualCompareInfo(dateNow, endDate);
                if(endDateResult >= 0){
                    listMessage.add("End Date " + endDate + " must be in the future.");
                }

                int bothDateResult = DateTimeUtils.actualCompareInfo(startDate, endDate);
                if(endDateResult >= 0){
                    listMessage.add("End Date " + endDate + " must be after Start Date " + startDate + " .");
                }

                Period period = startDate.until(endDate);
                int dayDistance = period.getDays();
                if((dayDistance + 1) != scheduleDayDistance){
                    listMessage.add("The number from Start Date " + startDate + " to End Date " + endDate + " doesn't match with Schedule Days.");
                }
            }
        }
        if(listMessage.isEmpty()){
            return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "These fields do not validatae", listMessage));
        }

        TourDetail tourDetail = tourDetailService.createTourDetail(tourCreateForm.getTourDetailCreateForm());
        Set<TourSchedule> tourScheduleSet = tourScheduleService.createTourSchedule(tourCreateForm.getListTourSchedule());
        Set<TourTime> tourTimeSet = new HashSet<>();
        if(tourCreateForm.getTourTimeCreateFormSet() != null){
            tourTimeSet = tourTimeService.createTime(tourCreateForm.getTourTimeCreateFormSet());
        }

        Set<TourImages> tourImagesSet = new HashSet<>();
        if(tourCreateForm.getTourImageCreateForms() != null){
            tourImagesSet = tourImageService.createImage(tourCreateForm.getTourImageCreateForms());
        }

        Tour tour = new Tour();
        tour.setTitle(tourCreateForm.getTitle());
        tour.setStartLocation(tourCreateForm.getStarLocation());
        tour.setEndLocation(tourCreateForm.getEndLocation());
        tour.setDescription(tourCreateForm.getDescription());
        tour.setPrice(tourCreateForm.getPrice());
        tour.setCoverImage(tourCreateForm.getCoverImage());
        tour.setCity(cityRepository.findByName(tourCreateForm.getCity())
                .orElseThrow(() -> new ResourceNotFoundException("City not found!")));
        tour.setTourStatus(TourStatus.ACTIVE);
        // tour.setCreateBy(user.getName());
        tour.setTourDetail(tourDetail);
        tour.setTourTimeSet(tourTimeSet);
        tour.setTourSchedules(tourScheduleSet);
        tour.setTourImagesSet(tourImagesSet);

        String code = CodeGenerator.generate("TO");
        while (tourRepository.findByCode(code).isPresent()){
            code = CodeGenerator.generate("TO");
        }
        tour.setCode(code);

        tourRepository.save(tour);
        if(tourCreateForm.getTourTimeCreateFormSet() != null) {
            for (TourTime tourTime : tourTimeSet) {
                tourTime.setTour(tour);
                tourTimeRepository.save(tourTime);
            }
        }

        for(TourSchedule tourSchedule : tourScheduleSet){
            tourSchedule.setTour(tour);
            tourScheduleRepository.save(tourSchedule);
        }

        if(tourCreateForm.getTourImageCreateForms() != null) {
            for (TourImages tourImages : tourImagesSet) {
                tourImages.setTour(tour);
                tourImageRepository.save(tourImages);
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.CREATED, "Successfully"));
    }

    //Image
    public ResponseEntity<BaseResponseDTO> addMoreImage(TourImageAddMoreForm tourImageAddMoreForm){
        Tour tour = tourRepository.findById(tourImageAddMoreForm.getId()).orElseThrow(() -> new ResourceNotFoundException("Tour not found"));
        Set<TourImages> tourImagesSet = tourImageService.createImage(tourImageAddMoreForm.getTourImageCreateFormSet());
        tour.setTourImagesSet(tourImagesSet);
        for(TourImages tourImages : tourImagesSet){
            tourImages.setTour(tour);
            tourImageRepository.save(tourImages);
        }
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "Add Successsfully"));
    }

    public ResponseEntity<BaseResponseDTO> updateImage(TourImageDTO tourImageDTO){
        tourImageService.updateImage(tourImageDTO);
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "Update Successfully"));
    }

    public ResponseEntity<BaseResponseDTO> deleteImage(UUID id){
        tourImageService.deleteImage(id);
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "Delete Successfully"));
    }
    public ResponseEntity<BaseResponseDTO> getAllImage(){
        List<TourImages> tourImagesList = tourImageRepository.findAll();
        List<TourImageDTO> tourImageDTOList = tourImagesList.stream().map(mapperConfig::imageToImage).collect(Collectors.toList());
        return ResponseEntity.ok(new BaseResponseDTO(LocalDateTime.now(), HttpStatus.OK, "View List Successfully", tourImageDTOList));
    }


}
