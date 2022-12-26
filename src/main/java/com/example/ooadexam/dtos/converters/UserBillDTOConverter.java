package com.example.ooadexam.dtos.converters;

import com.example.ooadexam.dtos.UserBillDTO;
import com.example.ooadexam.models.PaymentMethod;
import com.example.ooadexam.models.PaymentPeriod;
import com.example.ooadexam.models.UserBill;
import org.springframework.stereotype.Component;

@Component
public class UserBillDTOConverter {

    public UserBillDTO getFromEntity(UserBill bill) {
        UserBillDTO dto = new UserBillDTO();
        dto.setUserName(bill.getUser().getUserName());
        dto.setUserSurname(bill.getUser().getUserSurname());
        dto.setCardNumber(bill.getUser().getCardCredentials().getCardNumber());
        PaymentPeriod period = bill.getUser().getUserTariff().getPaymentPeriod();
        dto.setPrice(period.equals(PaymentPeriod.MONTH) ?
                bill.getUser().getUserTariff().getTariff().getMonthlyCost() :
                bill.getUser().getUserTariff().getTariff().getAnnualCost());
        dto.setIsPaid(bill.getIsPaid());
        dto.setCreationDate(bill.getCreationDate());
        dto.setTariffName(bill.getUser().getUserTariff().getTariff().getTariffName());
        dto.setPaymentMethod(bill.getUser().getUserTariff().getPaymentMethod());
        return dto;
    }

}
