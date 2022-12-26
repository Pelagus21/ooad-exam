package com.example.ooadexam.services.interfaces;

import com.example.ooadexam.dtos.UserBillDTO;

public interface UserBillService {

    UserBillDTO createBill(Long userId);

}
