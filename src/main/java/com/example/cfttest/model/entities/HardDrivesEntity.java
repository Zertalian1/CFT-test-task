package com.example.cfttest.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "HardDrives")
@Data
public class HardDrivesEntity extends ProductsEntity {
    private int capacity;
}
