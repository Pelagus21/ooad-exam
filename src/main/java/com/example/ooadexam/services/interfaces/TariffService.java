package com.example.ooadexam.services.interfaces;

import com.example.ooadexam.dtos.TariffDTO;
import com.example.ooadexam.models.Tariff;

public interface TariffService {

    TariffDTO createTariff(TariffDTO dto);

    Tariff getById(Long id);
}
