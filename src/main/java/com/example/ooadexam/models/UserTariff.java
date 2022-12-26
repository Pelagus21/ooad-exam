package com.example.ooadexam.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTariff {

    @ManyToOne
    @JoinColumn(name = "tariff_id", referencedColumnName = "tariff_id", nullable = false)
    private Tariff tariff;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "payment_period")
    private PaymentPeriod paymentPeriod;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "payment_method")
    private PaymentMethod paymentMethod;

    //date when user connected tariff for the first time
    @Column(nullable = false, name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
}
