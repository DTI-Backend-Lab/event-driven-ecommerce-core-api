package io.github.henriqueaguiiar.event_driven_ecommerce_core_api.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "order_items")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private Long externalProductId;
    private String productName;
    private BigDecimal productPrice;
    private String productDescription;
    private String productImageUrl;
    private Integer quantity;

}
