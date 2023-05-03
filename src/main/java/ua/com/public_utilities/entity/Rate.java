package ua.com.public_utilities.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "rates")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    private String images;

    @OneToMany(mappedBy = "rate")
    private List<RateHasOrder> RateHasOrderList;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categories;
}
