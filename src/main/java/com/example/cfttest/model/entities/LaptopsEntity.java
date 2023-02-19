package com.example.cfttest.model.entities;


import com.example.cfttest.model.enums.LaptopsScreenDiagonal;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Laptops")
@Data
public class LaptopsEntity extends ProductsEntity{
    @Enumerated
    private LaptopsScreenDiagonal screenDiagonal;
}
