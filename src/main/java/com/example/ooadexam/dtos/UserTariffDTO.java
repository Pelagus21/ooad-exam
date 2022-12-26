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

    private Long userId;

    private Long tariffId;

    private PaymentMethod paymentMethod;

    private PaymentPeriod paymentPeriod;

    private Date startDate;

}
