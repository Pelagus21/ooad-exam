package com.example.ooadexam.services.interfaces;

import com.example.ooadexam.dtos.UserPostDTO;
import com.example.ooadexam.dtos.UserGetDTO;
import com.example.ooadexam.dtos.UserTariffDTO;
import com.example.ooadexam.models.User;

public interface UserService {

    UserGetDTO createUser(UserPostDTO dto);

    void blockUser(Long id);

    User getById(Long id);

    UserTariffDTO getUserTariff(Long userId);

}
