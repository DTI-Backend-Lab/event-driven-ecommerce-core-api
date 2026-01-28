package io.github.henriqueaguiiar.event_driven_ecommerce_core_api.domain.mapper;


import io.github.henriqueaguiiar.event_driven_ecommerce_core_api.api.v1.dto.input.UserInputDTO;
import io.github.henriqueaguiiar.event_driven_ecommerce_core_api.api.v1.dto.output.UserOutputDTO;
import io.github.henriqueaguiiar.event_driven_ecommerce_core_api.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {

    public User toEntity(UserInputDTO userInputDTO) {
        User user = new User();
        user.setName(userInputDTO.name());
        user.setEmail(userInputDTO.email());
        user.setPassword(userInputDTO.password());
        return user;
    }


    public UserOutputDTO toOutputDTO(User user) {
        return  new UserOutputDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
