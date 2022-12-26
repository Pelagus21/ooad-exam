package com.example.ooadexam.dtos;

import com.example.ooadexam.models.PaymentMethod;
import com.example.ooadexam.models.PaymentPeriod;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserPostDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotNull
    //validate with some card number regexp
    @Pattern(regexp = "")
    private String cardNumber;

    @NotNull
    @Min(100)
    @Max(999)
    private Integer cvc;

    @NotNull
    @Min(1)
    @Max(12)
    private Integer expMonth;

    @NotNull
    @Min(0)
    private Integer expYear;

    @NotNull
    private Long tariffId;

    @NotNull
    private PaymentPeriod period;

    @NotNull
    private PaymentMethod method;
}
