package com.example.ooadexam.services.implementations;

import com.example.ooadexam.dtos.UserPostDTO;
import com.example.ooadexam.dtos.UserGetDTO;
import com.example.ooadexam.dtos.UserTariffDTO;
import com.example.ooadexam.dtos.converters.UserDTOConverter;
import com.example.ooadexam.dtos.converters.UserTariffDTOConverter;
import com.example.ooadexam.exceptions.EntityNotFoundException;
import com.example.ooadexam.models.User;
import com.example.ooadexam.repositories.UserRepository;
import com.example.ooadexam.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    //To my mind, such tight coupling between UserServiceImpl and UserDTOConverter is semantically justified.
    //I have explained my point of view in more detailed way in the comments to TariffDTOConverter class (dtos.converters package).
    private final UserDTOConverter userDTOConverter;

    private final UserTariffDTOConverter tariffDTOConverter;

    @Override
    public UserGetDTO createUser(UserPostDTO dto) {
        User user = userDTOConverter.getFromDTO(dto);
        return userDTOConverter.getFromEntity(userRepository.save(user));
    }

    @Override
    public void blockUser(Long id) {
        User user = this.getById(id);
        user.setIsBlocked(true);
        userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User", "id=" + id));
    }

    @Override
    public UserTariffDTO getUserTariff(Long userId) {
        return tariffDTOConverter.getFromEntity(this.getById(userId));
    }
}
