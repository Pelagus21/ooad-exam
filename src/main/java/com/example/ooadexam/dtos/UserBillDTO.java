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

    @NotBlank
    private String userName;

    @NotBlank
    private String userSurname;

    @NotNull
    //validate with some regexp
    @Pattern(regexp = "")
    private String cardNumber;

    @NotBlank
    private String tariffName;

    @NotNull
    @Min(0)
    private Double price;

    @NotNull
    private Date creationDate;

    //if paymentMethod='AUTOMATIC' and isPaid=false then automatic payment attempt is failed -> should repeat attempt a day later
    @NotNull
    private PaymentMethod paymentMethod;

    @NotNull
    private Boolean isPaid;
}

