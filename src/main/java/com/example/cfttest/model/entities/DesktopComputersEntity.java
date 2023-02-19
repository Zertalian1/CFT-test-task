package com.example.cfttest.model.entities;

import com.example.cfttest.model.enums.DesktopComputersFormFactor;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DesktopComputers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DesktopComputersEntity extends ProductsEntity{
    @Enumerated
    private DesktopComputersFormFactor formFactor;
}
