package com.example.ooadexam.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, name = "user_name")
    private String userName;

    @Column(nullable = false, name = "user_surname")
    private String userSurname;

    @Embedded
    @Column(nullable = false, name = "card_credentials")
    private CardCredentials cardCredentials;

    @Column(nullable = false, name = "is_blocked")
    private Boolean isBlocked;

    @Embedded
    @Column(name = "user_tariff", nullable = false)
    private UserTariff userTariff;
}
