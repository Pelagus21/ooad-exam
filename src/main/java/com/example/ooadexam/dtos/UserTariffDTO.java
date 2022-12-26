package com.example.ooadexam.dtos;

import com.example.ooadexam.models.PaymentMethod;
import com.example.ooadexam.models.PaymentPeriod;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTariffDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Long tariffId;

    @NotNull
    private PaymentMethod paymentMethod;

    @NotNull
    private PaymentPeriod paymentPeriod;

    @NotNull
    private Date startDate;

}
