package com.example.orderservice.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private long id;
    private String name;
    private int quantity;
    private double price;
}
