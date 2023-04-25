package ua.com.public_utilities.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "rate_has_orders")
public class RateHasOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rate_id")
    private Rate rate;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private BigDecimal totalBill;


    public RateHasOrder(Rate rate, Order order1) {
        this.rate = rate;
        this.order = order1;
    }
}
