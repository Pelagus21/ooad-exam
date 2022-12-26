package com.example.ooadexam.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TariffDTO {

    @Nullable
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    private Double monthlyCost;

    @NotNull
    @Min(0)
    private Double annualCost;
}
