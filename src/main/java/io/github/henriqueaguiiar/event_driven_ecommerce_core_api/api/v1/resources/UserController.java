package io.github.henriqueaguiiar.event_driven_ecommerce_core_api.api.v1.resources;


import io.github.henriqueaguiiar.event_driven_ecommerce_core_api.api.v1.dto.input.UserInputDTO;
import io.github.henriqueaguiiar.event_driven_ecommerce_core_api.api.v1.dto.output.UserOutputDTO;
import io.github.henriqueaguiiar.event_driven_ecommerce_core_api.domain.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserOutputDTO> createUser(@RequestBody UserInputDTO userInputDTO) {
     UserOutputDTO outputDTO = userService.createUser(userInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(outputDTO);
    }

}
