package ua.com.public_utilities.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private String payment;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client client;

    @OneToMany(mappedBy = "order")
    private List<RateHasOrder> RateHasOrderList;

}
