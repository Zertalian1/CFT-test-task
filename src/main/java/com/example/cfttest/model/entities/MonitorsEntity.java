package com.example.cfttest.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Monitors")
@Data
public class MonitorsEntity extends ProductsEntity{
    private float diagonal;
}
