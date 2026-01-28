package io.github.henriqueaguiiar.event_driven_ecommerce_core_api.domain.services;


import io.github.henriqueaguiiar.event_driven_ecommerce_core_api.api.v1.dto.input.UserInputDTO;
import io.github.henriqueaguiiar.event_driven_ecommerce_core_api.api.v1.dto.output.UserOutputDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserOutputDTO createUser(UserInputDTO userInputDTO);




}
