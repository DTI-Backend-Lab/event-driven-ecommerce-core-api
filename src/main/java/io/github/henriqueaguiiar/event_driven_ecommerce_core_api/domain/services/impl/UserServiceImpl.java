package io.github.henriqueaguiiar.event_driven_ecommerce_core_api.domain.services.impl;

import io.github.henriqueaguiiar.event_driven_ecommerce_core_api.api.v1.dto.input.UserInputDTO;
import io.github.henriqueaguiiar.event_driven_ecommerce_core_api.api.v1.dto.output.UserOutputDTO;
import io.github.henriqueaguiiar.event_driven_ecommerce_core_api.domain.mapper.UserMapper;
import io.github.henriqueaguiiar.event_driven_ecommerce_core_api.domain.model.User;
import io.github.henriqueaguiiar.event_driven_ecommerce_core_api.domain.repository.UserRepository;
import io.github.henriqueaguiiar.event_driven_ecommerce_core_api.domain.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

        @Override
        public UserOutputDTO createUser(UserInputDTO userInputDTO) {
            User user = userMapper.toEntity(userInputDTO);
            if(user.getPassword() != null && !user.getPassword().isBlank()) {
               user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            userRepository.save(user);
            return userMapper.toOutputDTO(user);
        }
    }
