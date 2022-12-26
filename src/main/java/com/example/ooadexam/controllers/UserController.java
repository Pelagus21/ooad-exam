package com.example.ooadexam.controllers;

import com.example.ooadexam.dtos.UserPostDTO;
import com.example.ooadexam.dtos.UserGetDTO;
import com.example.ooadexam.dtos.UserTariffDTO;
import com.example.ooadexam.services.interfaces.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //user creation request with specified card credentials (must be encrypted)
    //also the id of chosen tariff, payment period and payment method (MANUAL/AUTOMATIC) are transmitted in this DTO
    @PostMapping("/create")
    public ResponseEntity<UserGetDTO> createUser(@RequestBody @Valid UserPostDTO dto) {
        return new ResponseEntity<>(userService.createUser(dto), HttpStatus.CREATED);
    }

    //request to block a specified user
    @PostMapping("/block/{id}")
    public ResponseEntity<String> blockUser(@PathVariable(name = "id") Long id) {
        userService.blockUser(id);
        return new ResponseEntity<>("User with id= "+ id + " blocked", HttpStatus.OK);
    }

    //this endpoint returns information about the user's tariff, payment period, payment method and the date when the mentioned tariff was firstly applied by user
    @GetMapping("/getTariff/{userId}")
    public ResponseEntity<UserTariffDTO> getUserTariff(@PathVariable(name = "userId") Long userId) {
        return new ResponseEntity<>(userService.getUserTariff(userId), HttpStatus.OK);
    }

}
