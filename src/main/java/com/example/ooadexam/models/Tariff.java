package com.example.ooadexam.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tariff_id")
    private Long tariffId;

    @Column(name = "tariff_name", nullable = false)
    private String tariffName;

    @Column(name = "monthly_cost", nullable = false)
    private Double monthlyCost;

    @Column(name = "annual_cost", nullable = false)
    private Double annualCost;

}
