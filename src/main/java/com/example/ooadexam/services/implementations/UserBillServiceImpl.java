package com.example.ooadexam.services.implementations;

import com.example.ooadexam.dtos.UserBillDTO;
import com.example.ooadexam.dtos.converters.UserBillDTOConverter;
import com.example.ooadexam.exceptions.UserBlockedException;
import com.example.ooadexam.models.PaymentMethod;
import com.example.ooadexam.models.User;
import com.example.ooadexam.models.UserBill;
import com.example.ooadexam.repositories.UserBillRepository;
import com.example.ooadexam.services.interfaces.PaymentService;
import com.example.ooadexam.services.interfaces.UserBillService;
import com.example.ooadexam.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserBillServiceImpl implements UserBillService {

    private final UserBillRepository billRepository;

    //To my mind, such tight coupling between UserBillServiceImpl and UserBillDTOConverter is semantically justified.
    //I have explained my point of view in more detailed way in the comments to TariffDTOConverter class (dtos.converters package).
    private final UserBillDTOConverter converter;

    private final PaymentService paymentService;

    private final UserService userService;

    @Override
    public UserBillDTO createBill(Long userId) {
        User user = userService.getById(userId);
        if(user.getIsBlocked()) throw new UserBlockedException(userId);
        UserBill bill = new UserBill();
        bill.setUser(user);
        bill.setCreationDate(new Date());
        bill.setIsPaid(false);
        if(user.getUserTariff().getPaymentMethod().equals(PaymentMethod.AUTOMATIC)) {
            boolean success = paymentService.payBill(bill);
            bill.setIsPaid(success);
        }
        return converter.getFromEntity(billRepository.save(bill));
    }
}
