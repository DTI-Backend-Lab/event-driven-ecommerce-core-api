package io.github.henriqueaguiiar.event_driven_ecommerce_core_api.api.v1.dto.output;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;


public record UserOutputDTO(UUID id,
                            String name,
                            String email,
                            String hashedPassword
                            ) {
}
