package ua.com.public_utilities.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String phone;

    private String email;
    private String address;

    @OneToOne
    @MapKey
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(mappedBy = "client")
    private List<Order> orderList;
}
