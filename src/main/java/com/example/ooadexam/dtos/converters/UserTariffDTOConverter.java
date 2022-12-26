package com.example.ooadexam.dtos.converters;

import com.example.ooadexam.dtos.UserTariffDTO;
import com.example.ooadexam.models.User;
import com.example.ooadexam.models.UserTariff;
import org.springframework.stereotype.Component;

@Component
public class UserTariffDTOConverter {

    public UserTariffDTO getFromEntity(User user) {
        UserTariff userTariff = user.getUserTariff();
        UserTariffDTO dto = new UserTariffDTO();
        dto.setUserId(user.getUserId());
        dto.setTariffId(userTariff.getTariff().getTariffId());
        dto.setPaymentMethod(userTariff.getPaymentMethod());
        dto.setPaymentPeriod(userTariff.getPaymentPeriod());
        dto.setStartDate(userTariff.getStartDate());
        return dto;
    }

}
