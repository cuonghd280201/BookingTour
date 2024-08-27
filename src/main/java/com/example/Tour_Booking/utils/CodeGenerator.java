package com.example.Tour_Booking.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@UtilityClass
public class CodeGenerator {
    public String randomNumbeGenerate(){
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        return String.format("%04d", randomNumber);
    }

    public String generate(String codeType){
        String stringDate = DateTimeUtils.convertLocalDateToString(LocalDate.now());
        String randomNumber = randomNumbeGenerate();
        return "FPT" + codeType + "-" + stringDate + "-" + randomNumber;
    }
}
