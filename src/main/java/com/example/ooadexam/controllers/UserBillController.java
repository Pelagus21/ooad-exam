package com.example.ooadexam.controllers;

import com.example.ooadexam.dtos.UserBillDTO;
import com.example.ooadexam.services.interfaces.UserBillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/bills")
@RequiredArgsConstructor
public class UserBillController {

    private final UserBillService userBillService;

    //bill formation request for particular user
    //bill (invoice) is formed based on the user's data from db
    @PostMapping("/create/{userId}")
    public ResponseEntity<UserBillDTO> createUserBill(@PathVariable(name = "userId") Long userId) {
        return new ResponseEntity<>(userBillService.createBill(userId), HttpStatus.CREATED);
    }

}
