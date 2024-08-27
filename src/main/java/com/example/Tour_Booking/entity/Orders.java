package com.example.Tour_Booking.entity;

import com.example.Tour_Booking.common.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Builder
public class Orders {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;
    private BigDecimal price;
    private BigDecimal paid;
    private BigDecimal priceAfterPaid;
    private BigDecimal amount;
    private BigDecimal refund;
    private String updateBy;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    @Enumerated(EnumType.STRING)

    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_time_id", referencedColumnName = "id")
    private TourTime tourTime;
    private User user;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private Set<Payment> paymentSet;

    private String code;
}
