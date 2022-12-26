package com.example.ooadexam.dtos.converters;

import com.example.ooadexam.dtos.TariffDTO;
import com.example.ooadexam.models.Tariff;
import org.springframework.stereotype.Component;

@Component
public class TariffDTOConverter {

    //I have not created general Converter interface because in this class I do not need to implement 'getFromEntity' method.
    //Otherwise, I would have to implement unnecessary method 'getFromEntity', which would be a violation of ISP principle.
    //Another possible solution would be to create three interfaces 'EntityToDTOConverter', 'DTOToEntityConverter', 'BidirectionalConverter'.
    //First two of these interfaces would declare one method each ('getFromDTO', 'getFromEntity' accordingly)
    //and the third interface would extend mentioned two interfaces.
    //However, the return and argument type of these two interface methods must be 'Object' which would lead to downcasting of method argument (poor design solution).
    //That's why I think that implementation of Dependency Inversion principle in this case is unjustified.

    public Tariff getFromDTO(TariffDTO dto) {
        Tariff tariff = new Tariff();
        tariff.setTariffName(dto.getName());
        tariff.setMonthlyCost(dto.getMonthlyCost());
        tariff.setAnnualCost(dto.getAnnualCost());
        return tariff;
    }

}
