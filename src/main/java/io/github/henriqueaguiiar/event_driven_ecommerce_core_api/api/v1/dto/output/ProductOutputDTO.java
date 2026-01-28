package io.github.henriqueaguiiar.event_driven_ecommerce_core_api.api.v1.dto.output;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductOutputDTO(UUID id,
                               Long externalID,
                               String name,
                               String description,
                               BigDecimal price,
                               String imageUrl) {
}
