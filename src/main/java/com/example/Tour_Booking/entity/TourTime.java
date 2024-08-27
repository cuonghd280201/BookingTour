package com.example.Tour_Booking.entity;

import com.example.Tour_Booking.common.TimeStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Builder
@Where(clause = "deleted=false")
public class TourTime {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;
    private LocalDate startDate;

    private LocalDate endDate;

    private String startTime;

    private Integer slotNumber;

    private Integer slotNumberActual;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime createDate;

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime updateDate;

    @Enumerated(EnumType.STRING)
    private TimeStatus timeStatus;

    private boolean deleted = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id", referencedColumnName = "id")
    private Tour tour;

    @OneToMany(mappedBy = "tourTime", cascade = CascadeType.ALL)
    private Set<TourVisitor> tourVisitorSet;
    @OneToMany(mappedBy = "tourTime", cascade = CascadeType.ALL)
    private Set<Orders> ordersSet;
    private String code;

}
