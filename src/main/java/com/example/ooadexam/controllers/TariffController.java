package com.example.ooadexam.controllers;

import com.example.ooadexam.dtos.TariffDTO;
import com.example.ooadexam.services.interfaces.TariffService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/tariffs")
@RequiredArgsConstructor
public class TariffController {

    private final TariffService tariffService;

    //request for creation of tariff
    @PostMapping("/create")
    public ResponseEntity<TariffDTO> createTariff(@RequestBody @Valid TariffDTO dto) {
        return new ResponseEntity<>(tariffService.createTariff(dto), HttpStatus.CREATED);
    }

}
