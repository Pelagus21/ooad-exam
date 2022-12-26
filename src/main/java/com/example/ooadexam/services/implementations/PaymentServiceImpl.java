package com.example.ooadexam.services.implementations;

import com.example.ooadexam.models.UserBill;
import com.example.ooadexam.services.interfaces.PaymentService;
import org.springframework.stereotype.Service;

//Payment service stub
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public boolean payBill(UserBill bill) {
        //perform an operation with real payment service
        return true;
    }
}
