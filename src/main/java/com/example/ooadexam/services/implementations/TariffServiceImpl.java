package com.example.ooadexam.services.implementations;

import com.example.ooadexam.dtos.TariffDTO;
import com.example.ooadexam.dtos.converters.TariffDTOConverter;
import com.example.ooadexam.exceptions.EntityNotFoundException;
import com.example.ooadexam.models.Tariff;
import com.example.ooadexam.repositories.TariffRepository;
import com.example.ooadexam.services.interfaces.TariffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TariffServiceImpl implements TariffService {

    private final TariffRepository tariffRepository;

    //To my mind, such tight coupling between TariffServiceImpl and TariffDTOConverter is semantically justified.
    //I have explained my point of view in more detailed way in the comments to TariffDTOConverter class (dtos.converters package).
    private final TariffDTOConverter converter;

    @Override
    public TariffDTO createTariff(TariffDTO dto) {
        Tariff tariff = tariffRepository.save(converter.getFromDTO(dto));
        dto.setId(tariff.getTariffId());
        return dto;
    }

    @Override
    public Tariff getById(Long id) {
        return tariffRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tariff", "id=" + id));
    }
}
