package com.example.cfttest.model.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;

@Data
@MappedSuperclass
public class ProductsEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long serialNumber;

    private String manufacturer;
    private BigDecimal price;
    private Integer quantityInStock;
}
