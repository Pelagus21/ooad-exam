package com.example.ooadexam.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardCredentials {

    //card credentials must be stored encrypted

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private Integer cvc;

    @Column(name = "exp_month", nullable = false)
    private Integer expMonth;

    @Column(name = "exp_year", nullable = false)
    private Integer expYear;

}
