package com.example.ooadexam.services.interfaces;

import com.example.ooadexam.models.UserBill;

public interface PaymentService {

    boolean payBill(UserBill bill);
}
