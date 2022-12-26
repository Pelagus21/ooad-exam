package com.example.ooadexam.dtos;

import com.example.ooadexam.models.PaymentMethod;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserBillDTO {

    private String userName;

    private String userSurname;

    private String cardNumber;

    private String tariffName;

    private Double price;

    private Date creationDate;

    //if paymentMethod='AUTOMATIC' and isPaid=false then automatic payment attempt is failed -> should repeat attempt a day later
    private PaymentMethod paymentMethod;

    private Boolean isPaid;
}

