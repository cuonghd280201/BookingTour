package com.example.Tour_Booking.dto;


import com.example.Tour_Booking.common.Pagination;
import com.example.Tour_Booking.utils.DateTimeUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeUtils.DATETIME_FORMAT)
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
    private Pagination pagination;
    private Object data;

    public BaseResponseDTO(LocalDateTime timestamp, HttpStatus status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    public BaseResponseDTO(LocalDateTime timestamp, HttpStatus status, String message, Object data) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
