package com.example.ooadexam.dtos.converters;

import com.example.ooadexam.dtos.UserPostDTO;
import com.example.ooadexam.dtos.UserGetDTO;
import com.example.ooadexam.models.*;
import com.example.ooadexam.services.interfaces.TariffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class UserDTOConverter {

    private final TariffService tariffService;

    public User getFromDTO(UserPostDTO dto) {
        Tariff tariff = tariffService.getById(dto.getTariffId());
        User user = new User();
        user.setUserName(dto.getName());
        user.setUserSurname(dto.getSurname());
        user.setIsBlocked(false);
        user.setUserTariff(new UserTariff(tariff, dto.getPeriod(), dto.getMethod(), new Date()));
        user.setCardCredentials(new CardCredentials(dto.getCardNumber(), dto.getCvc(), dto.getExpMonth(), dto.getExpYear()));
        return user;
    }

    public UserGetDTO getFromEntity(User user) {
        return new UserGetDTO(user.getUserId(), user.getUserName(), user.getUserSurname());
    }
}
